# Button Style Guide

## ไฟล์ที่เกี่ยวข้อง
- `res/values/button_styles.xml` — style ทั้งหมด
- `res/values/colors.xml` — สีทั้งหมด

---

## Style ที่มี

| Style | ลักษณะ | ใช้เมื่อ |
|---|---|---|
| `App.Button.Primary` | พื้นน้ำเงิน | action หลัก เช่น ค้นหา, บันทึก, เพิ่ม |
| `App.Button.Secondary` | พื้นเทา | action รอง เช่น ดูรายละเอียด |
| `App.Button.Danger` | พื้นแดง | ลบ, ยืนยันอันตราย |
| `App.Button.Success` | พื้นเขียว | บันทึกสำเร็จ, ยืนยัน |
| `App.Button.Warning` | พื้นส้ม | แจ้งเตือน |
| `App.Button.Outline.Primary` | กรอบน้ำเงิน | action รอง / ยกเลิก |
| `App.Button.Outline.Danger` | กรอบแดง | ยกเลิก / ลบแบบไม่ทึบ |
| `App.Button.Primary.FullWidth` | พื้นน้ำเงิน เต็มแถว | ปุ่มล่างสุดของฟอร์ม |
| `App.Button.Outline.Primary.FullWidth` | กรอบน้ำเงิน เต็มแถว | ปุ่ม cancel ล่างสุด |

---

## วิธีใช้ใน XML

### ปุ่มทั่วไป
```xml
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Primary"
    android:id="@+id/btnSave"
    android:text="บันทึก" />
```

### ปุ่มคู่ (เพิ่ม / ยกเลิก) ในฟอร์ม
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_marginTop="16dp">

    <com.google.android.material.button.MaterialButton
        style="@style/App.Button.Primary"
        android:id="@+id/btnAdd"
        android:layout_width="0dp"
        android:layout_weight="1"
        android:layout_marginEnd="8dp"
        android:text="เพิ่ม" />

    <com.google.android.material.button.MaterialButton
        style="@style/App.Button.Outline.Danger"
        android:id="@+id/btnCancel"
        android:layout_width="0dp"
        android:layout_weight="1"
        android:layout_marginStart="8dp"
        android:text="ยกเลิก" />

</LinearLayout>
```

### ปุ่มเต็มแถว
```xml
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Primary.FullWidth"
    android:id="@+id/btnLogin"
    android:text="เข้าสู่ระบบ" />
```

### ปุ่ม navigation bar (ORDERS / SEARCH)
```xml
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Secondary"
    android:id="@+id/btnOrders"
    android:layout_width="0dp"
    android:layout_weight="1"
    android:layout_marginEnd="8dp"
    android:text="ORDERS" />

<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Primary"
    android:id="@+id/btnSearch"
    android:layout_width="0dp"
    android:layout_weight="1"
    android:layout_marginStart="8dp"
    android:text="SEARCH" />
```

---

## วิธีเปลี่ยนสี

### เปลี่ยนสีของ style ที่มีอยู่
แก้ไขค่าใน `res/values/colors.xml`:
```xml
<!-- เปลี่ยนปุ่ม Primary เป็นสีเขียว -->
<color name="btnPrimaryBg">#388E3C</color>
<color name="btnPrimaryText">#FFFFFF</color>
```

### เพิ่ม style ใหม่
เพิ่มใน `res/values/button_styles.xml`:
```xml
<style name="App.Button.Custom" parent="App.Button">
    <item name="backgroundTint">#7B1FA2</item>  <!-- ม่วง -->
    <item name="android:textColor">#FFFFFF</item>
</style>
```

### Override สีเฉพาะปุ่มนั้น (ไม่กระทบปุ่มอื่น)
```xml
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Primary"
    android:id="@+id/btnSpecial"
    app:backgroundTint="#7B1FA2"
    android:text="พิเศษ" />
```

---

## ตัวอย่างแต่ละ Style

```xml
<!-- Primary -->
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Primary"
    android:text="Primary" />

<!-- Danger -->
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Danger"
    android:text="ลบ" />

<!-- Success -->
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Success"
    android:text="ยืนยัน" />

<!-- Outline Primary -->
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Outline.Primary"
    android:text="ยกเลิก" />

<!-- Outline Danger -->
<com.google.android.material.button.MaterialButton
    style="@style/App.Button.Outline.Danger"
    android:text="ยกเลิก" />
```
