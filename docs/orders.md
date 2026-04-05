# Function Orders

## Notes สำหรับการทำความเข้าใจ Function Orders

### ไฟล์ที่เกี่ยวข้อง
| ไฟล์ | หน้าที่ |
|---|---|
| `res/layout/fragment_orders.xml` | UI layout ของ form เพิ่ม order (เข้าได้จาก Bottom Nav → ORDERS) |
| `presentation/ui/home/OrdersFragment.kt` | Logic หลัก: validation, spinner, reset, insert |
| `core/utils/LocationDropdownHelper.kt` | Helper setup dropdown จังหวัด/อำเภอ/ตำบล, platform และ status |
| `core/utils/Extensions.kt` | Extension functions: `visible()` / `gone()` สำหรับซ่อน/แสดง view |
| `core/utils/AppDialog.kt` | Custom alert dialog component |
| `core/utils/OrderFilterStore.kt` | SharedPreferences store สำหรับบันทึก filter draft |
| `domain/model/Order.kt` | data class ของ Order |
| `domain/model/OrderFilter.kt` | data class สำหรับเงื่อนไขกรอง |
| `domain/repository/OrderRepository.kt` | Interface: `insert`, `getAll`, `filter`, `deleteById`, `updateById` |
| `data/repository/OrderRepositoryImpl.kt` | SQLite implementation ของ OrderRepository |
| `data/local/db/AppDatabase.kt` | SQLiteOpenHelper, สร้างตาราง, migration |
| `data/local/dao/OrderDao.kt` | SQL query: `insert`, `getAll`, `filter`, `deleteById`, `updateById` |
| `core/di/DatabaseModule.kt` | Hilt provide `AppDatabase` |
| `core/data/StatusMasterData.kt` | รายการ status: ใหม่, ส่งงานแล้ว, ว่าง |

---

### การทำงานของ Button

**ปุ่มเพิ่ม (btnAddOrder) — ใน OrdersFragment**
1. เรียก `validateForm()` ก่อนเสมอ
2. ถ้าผ่าน → แสดง `progressBar` (spinner) → `lifecycleScope.launch { saveOrder() }`
3. ถ้าไม่ผ่าน → แสดง error ใต้ field ที่ไม่ครบ ไม่ทำอะไรต่อ

**ปุ่มยกเลิก (btnCancel)**
1. แสดง `progressBar` ทันที
2. เรียก `resetFields()` → clear ทุก field + clear error ทุก field
3. ซ่อน `progressBar`

---

### Validation Rules
| Field | Required | Max Length | รูปแบบ |
|---|---|---|---|
| ชื่อ (`etName`) | ✅ | 200 | `inputType="text"` — รองรับภาษาไทย |
| Platform (`actvPlatform`) | ✅ | - | dropdown เลือกได้เท่านั้น |
| เบอร์ติดต่อ (`etPhone`) | ❌ | 10 | `inputType="number"` + `digits="0123456789"` — ตัวเลขเท่านั้น |
| รายละเอียด (`etDetail`) | ❌ | 500 | `inputType="textMultiLine"` — รองรับภาษาไทย |

> `maxLength` ถูก enforce ที่ XML โดยตรง — ผู้ใช้พิมพ์เกินไม่ได้
> required field ถูก check ใน `validateForm()` ใน Fragment

---

### Spinner Pattern ของโปรเจคนี้
ใช้ `ProgressBar` ร่วมกับ extension function จาก `Extensions.kt`
```kotlin
binding.progressBar.visible()  // แสดง spinner
binding.progressBar.gone()     // ซ่อน spinner
```
> pattern เดียวกับที่ใช้ใน `LoginFragment`, `RegisterFragment`, `OrderResultFragment`

#### Spinner Overlay (บล็อก touch พื้นหลัง)
- เมื่อ spinner แสดง จะมี `viewSpinnerOverlay` (semi-transparent layer) คลุมทั้งหน้าจอ
- `android:clickable="true"` + `android:focusable="true"` → ดัก touch ทุก event ไม่ให้ผ่านไปถึง view ด้านหลัง
- `viewSpinnerOverlay` และ `progressBar` จะแสดง/ซ่อนพร้อมกันเสมอ

#### Spinner Timeout
- ทุกครั้งที่แสดง spinner ต้องเรียก `showSpinnerWithTimeout()` เท่านั้น
- ถ้า spinner แสดงนานกว่า **3 นาที** → แสดง `Toast`: `"Error: session timeout"` แล้วเรียก `hideSpinner()`
- เมื่อ operation เสร็จก่อน timeout → เรียก `hideSpinner()` เพื่อยกเลิก timeout

#### ปิด Spinner มี Delay 700ms
- `hideSpinner()` delay **700ms** ก่อนซ่อน spinner + overlay
- ช่วง delay → overlay ยังคลุมอยู่ ผู้ใช้ยังกด action พื้นหลังไม่ได้
- ต้อง cancel timeout ใน `onDestroyView()` เสมอ เพื่อป้องกัน memory leak

```kotlin
private fun showSpinnerWithTimeout() {
    binding.viewSpinnerOverlay.visible()
    binding.progressBar.visible()
    timeoutHandler.removeCallbacks(timeoutRunnable)
    timeoutHandler.postDelayed(timeoutRunnable, 3 * 60 * 1000L)
}

private fun hideSpinner() {
    timeoutHandler.removeCallbacks(timeoutRunnable)
    timeoutHandler.postDelayed({
        if (_binding != null) {
            binding.progressBar.gone()
            binding.viewSpinnerOverlay.gone()
        }
    }, 700L)
}
```

---

### Dropdown Cascade (จังหวัด → อำเภอ → ตำบล)
- setup ผ่าน `setupLocationDropdowns(tilProvince, tilDistrict, tilSubDistrict)`
- เมื่อเลือกจังหวัด → อำเภอจะ update อัตโนมัติ
- เมื่อเลือกอำเภอ → ตำบลจะ update อัตโนมัติ
- ตอน `resetFields()` ต้อง clear ทั้ง 3 field เสมอ
- อ่านค่าจาก dropdown ต้องใช้ `(binding.tilXxx.editText as AutoCompleteTextView).text.toString().trim()` เสมอ — ห้ามอ่านจาก `binding.actvXxx.text` โดยตรง เพราะอาจได้ค่าไม่ตรงใน DialogFragment

---

### หน้า Order Result

#### ไฟล์ที่เกี่ยวข้อง
| ไฟล์ | หน้าที่ |
|---|---|
| `res/layout/fragment_order_result.xml` | UI แสดงรายการ order |
| `res/layout/item_order.xml` | layout แต่ละ item ใน RecyclerView |
| `res/layout/dialog_add_order.xml` | layout Top-sheet Dialog เพิ่ม order |
| `res/layout/dialog_edit_order.xml` | layout BottomSheet แก้ไข order |
| `res/layout/dialog_filter_order.xml` | layout Center Dialog กรอง order |
| `res/anim/slide_in_from_top.xml` | animation AddOrderDialog เข้า (slide ลงจากบน 300ms) |
| `res/anim/slide_out_to_top.xml` | animation AddOrderDialog ออก (slide ขึ้นบน 250ms) |
| `res/drawable/bg_top_sheet.xml` | shape สีขาว มุมล่างโค้ง 16dp สำหรับ AddOrderDialog |
| `res/drawable/bg_dialog_center.xml` | shape สีขาว มุมโค้ง 16dp ทุกด้าน สำหรับ FilterOrderDialog |
| `presentation/ui/home/OrderResultFragment.kt` | โหลด orders จาก SQLite มาแสดง, จัดการ add/edit/delete/filter/submit |
| `presentation/ui/home/OrderResultAdapter.kt` | RecyclerView Adapter — รองรับ mode DELETE และ SUBMIT |
| `presentation/ui/home/AddOrderDialog.kt` | DialogFragment (Top-sheet) สำหรับเพิ่ม order ใหม่ |
| `presentation/ui/home/EditOrderDialog.kt` | BottomSheetDialogFragment สำหรับแก้ไข order |
| `presentation/ui/home/FilterOrderDialog.kt` | DialogFragment (Center) สำหรับกรอง order |
| `domain/model/Order.kt` | data class ของ Order |
| `domain/repository/OrderRepository.kt` | interface: `getAll()`, `filter()`, `updateById()`, `insert()`, `deleteById()` |
| `data/local/dao/OrderDao.kt` | query SELECT, UPDATE, INSERT, DELETE + dynamic filter WHERE |

#### Order Model
```kotlin
data class Order(
    val id: Long,           // System.currentTimeMillis() เป็น unique id
    val name: String,       // required
    val platform: String,   // required
    val phone: String,
    val province: String,
    val district: String,
    val subDistrict: String,
    val detail: String,
    val status: String,     // default "ใหม่" — ระบบกำหนดเอง ผู้ใช้แก้ไขไม่ได้
    val receivedAt: Long,   // System.currentTimeMillis() ตอน insert — ผู้ใช้แก้ไขไม่ได้
    val createdAt: Long
)
```

#### SQLite Database
- ใช้ `AppDatabase` (SQLiteOpenHelper) ชื่อไฟล์ `endpoint.db` version **2**
- migration v1→v2: `ALTER TABLE orders ADD COLUMN status`, `ADD COLUMN received_at`
- inject ผ่าน Hilt (`DatabaseModule` → `RepositoryModule`)
- `OrderResultFragment` inject `OrderRepository` แล้วเรียก `getAll()` หรือ `filter()` ใน `lifecycleScope.launch`
- ดึงข้อมูลบน `Dispatchers.IO` ผ่าน `withContext` ใน `OrderRepositoryImpl`
- เรียงลำดับ `ORDER BY id DESC` (order ใหม่อยู่บนสุด)

**Schema ตาราง `orders`:**
| Column | Type | หมายเหตุ |
|---|---|---|
| `id` | INTEGER PRIMARY KEY | `System.currentTimeMillis()` |
| `name` | TEXT NOT NULL | |
| `platform` | TEXT NOT NULL | |
| `phone` | TEXT | nullable |
| `province` | TEXT | nullable |
| `district` | TEXT | nullable |
| `sub_district` | TEXT | nullable |
| `detail` | TEXT | nullable |
| `status` | TEXT NOT NULL | default `'ใหม่'` — เพิ่มใน migration v2 |
| `received_at` | INTEGER NOT NULL | default `0` — เพิ่มใน migration v2, set เป็น `System.currentTimeMillis()` ตอน insert |
| `created_at` | INTEGER NOT NULL | timestamp |

#### Layout ของ fragment_order_result.xml
```
[ ORDERS (title)                              ]
[ Order (btnNewOrder)                         ]
[ ลบ Order (btnDeleteOrder) | ส่งงาน (btnSubmit) ]
[ รายการ Orders      [ กรอง (btnFilter) ]    ]
[ RecyclerView (rvOrders) / tvEmpty           ]
[ Bottom Nav                                  ]
```

| View ID | ประเภท | หมายเหตุ |
|---|---|---|
| `btnNewOrder` | Secondary | เปิด AddOrderDialog (top-sheet) |
| `btnDeleteOrder` | Outline Danger | สลับ card mode → DELETE — icon สีแดง |
| `btnSubmit` | Success | สลับ card mode → SUBMIT |
| `btnFilter` | Outline Secondary | เปิด FilterOrderDialog (center popup) + spinner |

#### Card Mode (OrderResultAdapter.Mode)
- **DELETE mode** (default) — ปุ่มใน card แสดงปุ่ม **ลบ**
- **SUBMIT mode** — ปุ่มใน card แสดงปุ่ม **ส่งงาน**
- order ที่ `status == "ส่งงานแล้ว"` — แสดง text "ส่งงานแล้ว" สีเขียว แทนปุ่ม, กด card ไม่ได้ (ล็อค)

#### Navigation
```
login/register  ──→  orderResultFragment   (home หลัง login, label = "ORDERS")
                         ↓ bottomNav.btnOrders   ← อยู่กับที่ (no-op)
                         ↓ bottomNav.btnOrders (จาก ordersFragment)
                     orderResultFragment
                         ↓ btnNewOrder           ← เปิด AddOrderDialog (top-sheet) ไม่ navigate
                     [AddOrderDialog]
```

> หน้า searchFragment และ searchResultFragment ถูกลบออกแล้ว — ปุ่ม SEARCH เปลี่ยนเป็น MENU (ยังไม่ implement)

#### Flow กดปุ่ม btnFilter (กรอง)
```
กด btnFilter
    → FilterOrderDialog.newInstance(initialFilter, onApply, onReset, onDraft).show()
         → Center dialog แสดงกลางจอ
         → pre-fill ค่าจาก activeFilter (ถ้ามี)
         → กรอกเงื่อนไข: ชื่อ, platform, จังหวัด, อำเภอ, ตำบล, สถานะ, วันที่รับ Order
    → กด กรอง
         → onApply(filter) → showSpinnerWithTimeout() → loadOrders() → hideSpinner()
         → บันทึก filter ลง OrderFilterStore (SharedPreferences)
    → กด รีเซต
         → onReset() → activeFilter = OrderFilter(status = "ใหม่") → spinner → loadOrders()
    → กด background / back
         → onCancel() → ไม่บันทึก draft (ค่าใน store ไม่เปลี่ยน)
    → ปิด dialog โดยไม่กดปุ่ม
         → onDraft(draft) → บันทึก draft ลง store (เปิดครั้งหน้าค่ายังอยู่)
```

#### Filter Default
- เปิดหน้าครั้งแรก (store ว่าง) → `activeFilter = OrderFilter(status = "ใหม่")`
- เปิดหน้าอีกครั้ง (มี draft ใน store) → ใช้ค่าที่บันทึกไว้
- กด Reset → `activeFilter = OrderFilter(status = "ใหม่")`

#### Flow กดปุ่ม ส่งงาน (btnSubmit บน)
```
กด btnSubmit
    → cardMode = SUBMIT → loadOrders() (reload adapter ด้วย mode ใหม่)
    → ปุ่มใน card เปลี่ยนเป็น "ส่งงาน" (ยกเว้น order ที่ status = "ส่งงานแล้ว")
กด ส่งงาน ใน card
    → AppDialog WARNING "ต้องการส่งงานรายการ {ชื่อ} ใช่ไหม?"
    → กด ยืนยัน → orderRepository.updateById(order.copy(status = "ส่งงานแล้ว")) → loadOrders()
กด btnDeleteOrder (ลบ Order บน)
    → cardMode = DELETE → loadOrders() (ปุ่มใน card กลับเป็น "ลบ")
```

#### Flow โหลด Order Result
```
OrderResultFragment.onViewCreated()
    → loadOrders()   ← suspend fun เรียกผ่าน lifecycleScope.launch
         → orderRepository.getAll() หรือ filter(activeFilter)
         → if empty → tvEmpty
         → else     → RecyclerView + OrderResultAdapter(mode, onCardClick, onDeleteClick, onSubmitClick)
```

#### AddOrderDialog
- `DialogFragment` สร้างผ่าน `AddOrderDialog.newInstance { order -> ... }`
- style: `TopSheetDialogStyle` — slide ลงจากบน
- `status` = `"ใหม่"` เสมอ (hardcode, ไม่แสดง field)
- `receivedAt` = `System.currentTimeMillis()` ตอนกด เพิ่ม (ไม่แสดง field)
- validate: ชื่อและ Platform required

#### EditOrderDialog
- `BottomSheetDialogFragment` สร้างผ่าน `EditOrderDialog.newInstance(order) { updated -> ... }`
- pre-fill ทุก field จาก `order` ที่รับมา
- **ไม่แสดง** field status และ receivedAt — `order.copy(...)` คงค่าเดิมทั้งสองไว้เสมอ
- order ที่ `status == "ส่งงานแล้ว"` — กด card ไม่ได้ (ล็อคที่ Adapter)
- validate: ชื่อและ Platform required

#### FilterOrderDialog
- `DialogFragment` สร้างผ่าน `FilterOrderDialog.newInstance(initialFilter, onApply, onReset, onDraft)`
- style: `CenterDialogStyle` — แสดงกลางจอ, กด background ปิดได้ (setCanceledOnTouchOutside = true)
- กด background → `onCancel()` → `actionHandled = true` → ไม่บันทึก draft
- fields: ชื่อ, platform, จังหวัด/อำเภอ/ตำบล (cascade), สถานะ (dropdown), วันที่รับ Order (DatePicker + clear icon)

#### item_order.xml แสดงผล
```
┌──────────────────────────────────────────┐
│ ชื่อ (bold)              Platform (เทา)  │  ← แสดงเสมอ
│ โทร: xxx-xxx-xxxx                        │  ← แสดงเมื่อมีเบอร์
│ ที่อยู่: ตำบล, อำเภอ, จังหวัด           │  ← แสดงเมื่อมีข้อมูล
│ รายละเอียด...    [ ลบ / ส่งงาน / text ] │  ← ปุ่มสลับตาม mode และ status
└──────────────────────────────────────────┘
```

- **status = "ใหม่"**, DELETE mode → ปุ่ม **ลบ** (outline danger)
- **status = "ใหม่"**, SUBMIT mode → ปุ่ม **ส่งงาน** (success)
- **status = "ส่งงานแล้ว"** → text "ส่งงานแล้ว" สีเขียว, กด card ไม่ได้

---

### TODO ที่ยังค้างอยู่
- [ ] implement ปุ่ม MENU (btnMenu) ใน Bottom Nav
- [ ] เพิ่ม pagination หรือ load more ใน OrderResultFragment
