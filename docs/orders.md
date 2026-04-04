# Function Orders

## Notes สำหรับการทำความเข้าใจ Function Orders

### ไฟล์ที่เกี่ยวข้อง
| ไฟล์ | หน้าที่ |
|---|---|
| `res/layout/fragment_orders.xml` | UI layout ของ form เพิ่ม order |
| `presentation/ui/home/OrdersFragment.kt` | Logic หลัก: validation, spinner, reset, insert |
| `core/utils/LocationDropdownHelper.kt` | Helper setup dropdown จังหวัด/อำเภอ/ตำบล และ platform |
| `core/utils/Extensions.kt` | Extension functions: `visible()` / `gone()` สำหรับซ่อน/แสดง view |
| `core/utils/AppDialog.kt` | Custom alert dialog component |
| `domain/repository/OrderRepository.kt` | Interface: `insert`, `getAll`, `deleteById` |
| `data/repository/OrderRepositoryImpl.kt` | SQLite implementation ของ OrderRepository |
| `data/local/db/AppDatabase.kt` | SQLiteOpenHelper, สร้างตาราง |
| `data/local/dao/OrderDao.kt` | SQL query: `insert`, `getAll`, `deleteById` |
| `core/di/DatabaseModule.kt` | Hilt provide `AppDatabase` |

---

### การทำงานของ Button

**ปุ่มเพิ่ม (btnAddOrder)**
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
> pattern เดียวกับที่ใช้ใน `LoginFragment` และ `RegisterFragment`

#### Spinner Overlay (บล็อก touch พื้นหลัง)
- เมื่อ spinner แสดง จะมี `viewSpinnerOverlay` (semi-transparent layer) คลุมทั้งหน้าจอ
- `android:clickable="true"` + `android:focusable="true"` → ดัก touch ทุก event ไม่ให้ผ่านไปถึง view ด้านหลัง
- `viewSpinnerOverlay` และ `progressBar` จะแสดง/ซ่อนพร้อมกันเสมอ

#### Spinner Timeout
- ทุกครั้งที่แสดง spinner ต้องเรียก `showSpinnerWithTimeout()` เท่านั้น
- ถ้า spinner แสดงนานกว่า **3 นาที** → แสดง `Toast`: `"Error: session timeout"` แล้วเรียก `hideSpinner()`
- เมื่อ operation เสร็จก่อน timeout → เรียก `hideSpinner()` เพื่อยกเลิก timeout

#### ปิด Spinner ต้อง Delay 2 วินาทีเสมอ
- `hideSpinner()` จะไม่ซ่อนทันที แต่ delay **2 วินาที** ก่อนซ่อน spinner + overlay
- ช่วง delay 2 วินาที → overlay ยังคลุมอยู่ ผู้ใช้ยังกด action พื้นหลังไม่ได้
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
    }, 2000L)
}
```

---

### Dropdown Cascade (จังหวัด → อำเภอ → ตำบล)
- setup ผ่าน `setupLocationDropdowns(tilProvince, tilDistrict, tilSubDistrict)`
- เมื่อเลือกจังหวัด → อำเภอจะ update อัตโนมัติ
- เมื่อเลือกอำเภอ → ตำบลจะ update อัตโนมัติ
- ตอน `resetFields()` ต้อง clear ทั้ง 3 field เสมอ

---

---

### หน้า Order Result

#### ไฟล์ที่เกี่ยวข้อง
| ไฟล์ | หน้าที่ |
|---|---|
| `res/layout/fragment_order_result.xml` | UI แสดงรายการ order |
| `res/layout/item_order.xml` | layout แต่ละ item ใน RecyclerView |
| `res/layout/dialog_edit_order.xml` | layout BottomSheet แก้ไข order |
| `presentation/ui/home/OrderResultFragment.kt` | โหลด orders จาก SQLite มาแสดง, จัดการ edit/delete |
| `presentation/ui/home/OrderResultAdapter.kt` | RecyclerView Adapter |
| `presentation/ui/home/EditOrderDialog.kt` | BottomSheetDialogFragment สำหรับแก้ไข order |
| `domain/model/Order.kt` | data class ของ Order |
| `domain/repository/OrderRepository.kt` | interface: `getAll()`, `updateById()` |
| `data/local/dao/OrderDao.kt` | query `SELECT * FROM orders ORDER BY id DESC`, `UPDATE` |

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
    val createdAt: Long
)
```

#### SQLite Database
- ใช้ `AppDatabase` (SQLiteOpenHelper) ชื่อไฟล์ `endpoint.db`
- inject ผ่าน Hilt (`DatabaseModule` → `RepositoryModule`)
- `OrderResultFragment` inject `OrderRepository` แล้วเรียก `getAll()` ใน `lifecycleScope.launch`
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
| `created_at` | INTEGER NOT NULL | timestamp |

#### Flow เมื่อกดปุ่มเพิ่ม
```
validateForm() → pass
    → showSpinnerWithTimeout()
    → lifecycleScope.launch {
          saveOrder()                ← suspend: build Order → orderRepository.insert() → SQLite (IO thread)
          hideSpinner() (delay 2 วิ)
      }
    → AppDialog (SUCCESS) "เพิ่ม Order สำเร็จ"
    → กด ตกลง → resetFields() → navigate to OrderResultFragment
```

#### Flow โหลด Order Result
```
OrderResultFragment.onViewCreated()
    → loadOrders()
         → lifecycleScope.launch {
               orderRepository.getAll()    ← suspend (IO thread, SQLite read)
               if empty → tvEmpty
               else     → RecyclerView + OrderResultAdapter(onCardClick, onDeleteClick)
           }
```

#### Flow กดที่ card เพื่อแก้ไข
```
กด card
    → EditOrderDialog.newInstance(order) { updated → ... }
         → BottomSheetDialog แสดงทุก field พร้อม pre-fill ข้อมูลเดิม
         → cascade dropdown จังหวัด/อำเภอ/ตำบล pre-fill จาก LocationMasterData
    → กด ยืนยัน
         → validate (ชื่อ + Platform required)
         → onConfirm(updated)
              → orderRepository.updateById(updated)    ← suspend (IO thread, SQLite UPDATE)
              → loadOrders()    ← reload list
    → กด ยกเลิก → dismiss dialog ไม่ทำอะไร
```

#### Layout ของ fragment_order_result.xml
```
[ เพิ่ม Order (btnAddOrder)              ]
[ รายการ Orders      [ กรอง (btnFilter)] ]
[ RecyclerView (rvOrders) / tvEmpty      ]
[ Bottom Nav                             ]
```

| View ID | ประเภท | หมายเหตุ |
|---|---|---|
| `btnAddOrder` | Secondary | navigate to ordersFragment |
| `btnFilter` | Outline Secondary | ขนาดเล็ก, อยู่ขวาของ title (ยังไม่ implement) |

#### Navigation
```
login/register  ──→  orderResultFragment   (home หลัง login)
ordersFragment  ──→  orderResultFragment
                         ↓ btnBack
                     (navigateUp)
                         ↓ btnSearch
                     searchFragment
                         ↓ btnAddOrder / btnOrders
                     ordersFragment
```

#### item_order.xml แสดงผล
```
┌──────────────────────────────────────────┐
│ ชื่อ (bold)              Platform (เทา)  │  ← แสดงเสมอ
│ โทร: xxx-xxx-xxxx                        │  ← แสดงเมื่อมีเบอร์
│ ที่อยู่: ตำบล, อำเภอ, จังหวัด           │  ← แสดงเมื่อมีข้อมูล
│ รายละเอียด...              [ ลบ ]        │  ← แสดงเมื่อไม่ว่าง, maxLines=2
└──────────────────────────────────────────┘
```

- **เบอร์โทร** — format `xxx-xxx-xxxx` โดย Regex ใน Adapter ก่อนแสดงผล
- **กดที่ card** — เปิด `EditOrderDialog` (BottomSheet) พร้อม pre-fill ข้อมูลเดิมทุก field
- **ปุ่มลบ (btnDeleteItem)** — อยู่ row เดียวกับรายละเอียด (ล่างสุดของ card) เสมอ
  - กด → `AppDialog` WARNING "ต้องการลบรายการ {ชื่อ} ใช่ไหม?"
  - กด **ยืนยัน** → `deleteById(order.id)` → SQLite → `loadOrders()` reload list
  - กด **ยกเลิก** → ปิด dialog ไม่ทำอะไร
- Adapter รับ `onCardClick: (Order) -> Unit` และ `onDeleteClick: (Order) -> Unit` callback — Fragment เป็นคนจัดการทั้งหมด

#### EditOrderDialog
- `BottomSheetDialogFragment` สร้างผ่าน `EditOrderDialog.newInstance(order) { updated -> ... }`
- pre-fill ทุก field จาก `order` ที่รับมา
- location dropdown: ค้นหา province/district จาก `LocationMasterData` แล้วตั้ง adapter + enable ก่อน setText (เพราะ cascade ทำงานผ่าน `setOnItemClickListener` เท่านั้น)
- validate: ชื่อและ Platform required — แสดง error ที่ `TextInputLayout`
- กดยืนยัน → `order.copy(...)` พร้อมค่าใหม่ → callback `onConfirm`

---

### TODO ที่ยังค้างอยู่
- [ ] implement ปุ่ม กรอง — filter รายการตามเงื่อนไข
- [x] ~~implement ปุ่ม ลบ (btnDeleteItem) — ลบ order รายการ~~ ✓ done
- [x] ~~implement กด card เพื่อแก้ไข order (EditOrderDialog + updateById)~~ ✓ done
- [ ] implement ปุ่ม กรอง — filter รายการตามเงื่อนไข
- [ ] เพิ่ม pagination หรือ load more ใน OrderResultFragment