package com.personal.endpointmobile.data.local.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.personal.endpointmobile.data.local.dao.OrderDao

class AppDatabase(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object {
        const val DATABASE_NAME = "endpoint.db"

        // ============================================================
        // DATABASE_VERSION — กฎการจัดการ version
        // ============================================================
        // สิ่งที่ทำได้:
        //   - เพิ่ม version (เช่น 2 → 3) เมื่อมีการเปลี่ยน schema
        //   - เพิ่มทีละ 1 เสมอ เพื่อให้ onUpgrade ทำงานถูกต้อง
        //
        // สิ่งที่ห้าม:
        //   - ห้ามลด version เด็ดขาด → app จะ crash ทันที
        //   - ห้ามข้าม version (เช่น 2 → 4) โดยไม่มี migration ของ 3
        //     เพราะ user ที่ยังอยู่ที่ version 2 จะไม่ได้รับ migration ของ 3
        // ============================================================
        const val DATABASE_VERSION = 2
    }

    // onCreate ถูกเรียกครั้งเดียวตอน install ใหม่ (ไม่มี database เดิม)
    // สิ่งที่ห้าม: อย่าแก้ CREATE_TABLE ที่นี่อย่างเดียว
    //   เพราะ user ที่มี app อยู่แล้วจะไม่ได้รับการเปลี่ยนแปลง
    //   ต้องเพิ่ม migration ใน onUpgrade ด้วยเสมอ
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(OrderDao.CREATE_TABLE)
    }

    // onUpgrade ถูกเรียกอัตโนมัติเมื่อ DATABASE_VERSION เพิ่มขึ้น
    // ข้อมูลเดิมของ user จะยังอยู่ครบ ไม่ถูกลบ
    //
    // สิ่งที่ทำได้ใน ALTER TABLE:
    //   - ADD COLUMN (ต้องมี DEFAULT เสมอถ้าเป็น NOT NULL)
    //   - เพิ่ม index ใหม่
    //   - สร้างตารางใหม่
    //
    // สิ่งที่ห้าม:
    //   - ห้าม DROP TABLE หรือ DROP COLUMN → ข้อมูล user หายถาวร
    //   - ห้ามแก้ไข/ลบ block if (oldVersion < X) เดิม
    //     เพราะ user ที่ยังอยู่ version เก่ากว่าจะพลาด migration นั้น
    //   - ห้าม uninstall แล้ว install ใหม่ระหว่าง test → database หายทันที
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE ${OrderDao.TABLE_NAME} ADD COLUMN status TEXT NOT NULL DEFAULT 'ใหม่'")
            db.execSQL("ALTER TABLE ${OrderDao.TABLE_NAME} ADD COLUMN received_at INTEGER NOT NULL DEFAULT 0")
        }
        // เพิ่ม migration ใหม่ต่อท้ายเสมอ เช่น:
        // if (oldVersion < 3) {
        //     db.execSQL("ALTER TABLE ${OrderDao.TABLE_NAME} ADD COLUMN note TEXT DEFAULT ''")
        // }
    }
}
