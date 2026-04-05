package com.personal.endpointmobile.core.sync

import com.personal.endpointmobile.domain.model.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object SheetSyncService {

    // AKfycbyUxdWnEt4-cTOz2DwdxpNftmQrYe5K0FR7Mo12QNNpuRygvzbxG-sMTzReSoa7jCNQeQ

    // ใส่ค่าจาก Google Apps Script ที่ deploy แล้ว
    private const val WEB_APP_URL = "https://script.google.com/macros/s/AKfycbyUxdWnEt4-cTOz2DwdxpNftmQrYe5K0FR7Mo12QNNpuRygvzbxG-sMTzReSoa7jCNQeQ/exec"
    private const val SECRET_TOKEN = "admin1234"

    // ปิด auto-redirect เพราะ Apps Script ส่ง 302 มาก่อนเสมอ
    // ถ้าให้ OkHttp follow เอง จะเปลี่ยน POST → GET ทำให้ได้ HTML กลับมาแทน JSON
    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .followRedirects(false)
        .followSslRedirects(false)
        .build()

    suspend fun sync(orders: List<Order>): Result<Int> = withContext(Dispatchers.IO) {
        try {
            val ordersArray = JSONArray().apply {
                orders.forEach { order ->
                    put(JSONObject().apply {
                        put("id",           order.id)
                        put("name",         order.name)
                        put("platform",     order.platform)
                        put("phone",        order.phone)
                        put("province",     order.province)
                        put("district",     order.district)
                        put("subDistrict",  order.subDistrict)
                        put("detail",       order.detail)
                        put("status",       order.status)
                        put("receivedAt",   order.receivedAt)
                        put("createdAt",    order.createdAt)
                    })
                }
            }

            val body = JSONObject().apply {
                put("token",  SECRET_TOKEN)
                put("orders", ordersArray)
            }

            val requestBody = body.toString().toRequestBody("application/json".toMediaType())

            var request = Request.Builder()
                .url(WEB_APP_URL)
                .post(requestBody)
                .build()

            var response = client.newCall(request).execute()

            // Apps Script flow:
            // 1. POST → /exec  (doPost ทำงานที่นี่)
            // 2. 302 redirect → googleusercontent URL  (เอาไว้ส่ง response body กลับมา)
            // 3. GET redirect URL → ได้ JSON กลับมา  (ต้องเป็น GET ไม่ใช่ POST)
            if (response.code in 300..399) {
                val redirectUrl = response.header("Location")
                    ?: return@withContext Result.failure(Exception("Redirect ล้มเหลว: ไม่มี Location header"))
                response.close()
                request = Request.Builder()
                    .url(redirectUrl)
                    .get()
                    .build()
                response = client.newCall(request).execute()
            }

            val rawResponse = response.body?.string() ?: ""
            val responseJson = try {
                JSONObject(rawResponse)
            } catch (e: Exception) {
                // แสดง response จริงเพื่อ debug — ลบ block นี้ออกเมื่อแก้ได้แล้ว
                return@withContext Result.failure(
                    Exception("[HTTP ${response.code}] raw: ${rawResponse.take(300)}")
                )
            }

            if (responseJson.optBoolean("success")) {
                Result.success(responseJson.optInt("synced"))
            } else {
                Result.failure(Exception(responseJson.optString("error", "Unknown error")))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
