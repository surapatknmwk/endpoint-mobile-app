# Function Search

## Notes สำหรับการทำความเข้าใจ Function Search

### ไฟล์ที่เกี่ยวข้อง
| ไฟล์ | หน้าที่ |
|---|---|
| `res/layout/fragment_search.xml` | UI layout ของหน้าค้นหา |
| `presentation/ui/home/SearchFragment.kt` | Logic หลัก: date picker, search, reset |
| `core/utils/LocationDropdownHelper.kt` | Helper setup dropdown จังหวัด/อำเภอ/ตำบล |
| `core/utils/Extensions.kt` | Extension functions: `visible()` / `gone()` |

---

### Layout Overview

หน้านี้แบ่งเป็น 3 ส่วน:

```
[ Top Bar ]          ← component_top_bar + layoutTopActions (welcome, icon buttons)
[ ScrollView ]       ← cardSearch (form ค้นหา)
[ Bottom Nav ]       ← component_bottom_nav
```

**Top Bar Actions (layoutTopActions)** — วางทับ Top Bar ด้านขวา:
| View ID | หน้าที่ |
|---|---|
| `tvWelcome` | แสดงชื่อผู้ใช้ ("ยินดีต้อนรับ, {name}") |
| `btnProfile` | ปุ่มไปหน้า Profile (ยังไม่ implement) |
| `btnSettings` | ปุ่มไปหน้า Settings (ยังไม่ implement) |
| `btnSignOut` | ออกจากระบบ → navigate ไป loginFragment |

---

### Search Form Fields

| View ID | ประเภท | Required | หมายเหตุ |
|---|---|---|---|
| `etName` | TextInputEditText | ❌ | ข้อความทั่วไป |
| `actvProvince` | AutoCompleteTextView | ❌ | dropdown, cascade |
| `actvDistrict` | AutoCompleteTextView | ❌ | dropdown, ขึ้นกับจังหวัด |
| `actvSubDistrict` | AutoCompleteTextView | ❌ | dropdown, ขึ้นกับอำเภอ |
| `etDate` | TextInputEditText | ❌ | `focusable="false"`, เปิด date picker แทน |

> ไม่มี required field — กด ค้นหา โดยไม่กรอกอะไรก็ได้ (ส่ง filter เปล่าไป)

---

### การทำงานของ Button

**ปุ่มค้นหา (btnSearchFilter)**
1. รวบรวมค่าจากทุก field (ถ้าว่างส่งเป็น `""`)
2. ส่งค่าผ่าน `Bundle` → navigate ไป `searchResultFragment`

```kotlin
val args = Bundle().apply {
    putString("name", ...)
    putString("province", ...)
    putString("district", ...)
    putString("subDistrict", ...)
    putString("date", ...)
}
findNavController().navigate(R.id.action_searchFragment_to_searchResultFragment, args)
```

**ปุ่ม Reset (btnReset)**
1. `etName.text?.clear()`
2. เรียก `resetLocation()` (คืนค่าจาก `setupLocationDropdowns`) → clear dropdown ทั้ง 3
3. `etDate.text?.clear()`

> ไม่มี spinner — reset เป็น local action เท่านั้น

---

### Date Picker

- ใช้ `MaterialDatePicker` จาก Material Design
- กดที่ `etDate` หรือ icon ปฏิทิน (`endIcon`) → เปิด picker
- ป้องกัน open ซ้ำด้วย `if (!datePicker.isAdded)`
- รูปแบบวันที่ที่แสดง: **dd/MM/yyyy** (เช่น 30/03/2026)

```kotlin
datePicker.addOnPositiveButtonClickListener { selection ->
    val formatted = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(selection))
    binding.etDate.setText(formatted)
}
```

---

### Dropdown Cascade (จังหวัด → อำเภอ → ตำบล)
- setup ผ่าน `setupLocationDropdowns(tilProvince, tilDistrict, tilSubDistrict)`
- คืนค่า `resetLocation: () -> Unit` — ใช้ตอนกด Reset
- เมื่อเลือกจังหวัด → อำเภอ update อัตโนมัติ
- เมื่อเลือกอำเภอ → ตำบล update อัตโนมัติ

---

### User Welcome Message

- ดึง user จาก `authViewModel.currentUser`
- แสดงใน `tvWelcome`: `getString(R.string.welcome_message, user?.displayName ?: "User")`
- ถ้าไม่มี displayName → fallback เป็น "User"

---

### Navigation

```
searchFragment
  ├─ btnSearchFilter  ──→  searchResultFragment  (ส่ง filter args)
  ├─ bottomNav.btnOrders ──→  orderResultFragment
  └─ btnSignOut  ──────→  loginFragment  (pop back stack)
```

---

### หน้า Search Result

#### ไฟล์ที่เกี่ยวข้อง
| ไฟล์ | หน้าที่ |
|---|---|
| `res/layout/fragment_search_result.xml` | UI แสดงผลการค้นหา |
| `presentation/ui/home/SearchResultFragment.kt` | รับ args และแสดงผล |

#### Arguments ที่รับจาก searchFragment
| Key | Type | ค่าถ้าว่าง |
|---|---|---|
| `name` | String | `""` |
| `province` | String | `""` |
| `district` | String | `""` |
| `subDistrict` | String | `""` |
| `date` | String | `""` |

#### Navigation จาก Search Result
```
searchResultFragment
  ├─ topBar.btnBack  ──────→  popBackStack() (กลับ searchFragment)
  ├─ bottomNav.btnSearch ──→  searchFragment
  └─ bottomNav.btnOrders ──→  orderResultFragment
```

---

### TODO ที่ยังค้างอยู่
- [ ] implement logic โหลดข้อมูลจาก API ด้วย filter ใน `SearchResultFragment`
- [ ] เชื่อม `btnProfile` และ `btnSettings` เมื่อ implement หน้านั้น
- [ ] แสดงผลการค้นหาใน RecyclerView (ปัจจุบันหน้า result ยังว่าง)
