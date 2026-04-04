# Project Structure — EndpointMobile

แอป Android (Kotlin) สำหรับจัดการออเดอร์และค้นหาข้อมูล
ใช้สถาปัตยกรรม **Clean Architecture + MVVM**

---

## โครงสร้างโฟลเดอร์หลัก

```
endpoint - mobile - app/
├── app/src/main/
│   ├── java/com/personal/endpointmobile/
│   │   ├── core/           # Utilities, DI, Master data
│   │   ├── domain/         # Business logic (pure Kotlin)
│   │   ├── data/           # Repository implementations
│   │   └── presentation/   # UI, ViewModel, Navigation
│   └── res/
│       ├── layout/         # XML layouts
│       ├── navigation/     # nav_graph.xml
│       └── values/         # colors, strings, themes, styles
├── docs/                   # เอกสาร
├── build.gradle.kts        # Root build config
└── settings.gradle.kts     # Module config
```

---

## Architecture Layers

```
Presentation (MVVM)
   └── Fragment + ViewModel + StateFlow
Domain (Pure Kotlin)
   └── UseCase + Model + Repository Interface
Data
   └── Repository Impl + Data Source
Core
   └── DI (Hilt) + Utils + Master Data
```

### Core (`core/`)
| ไฟล์ | หน้าที่ |
|------|---------|
| `di/AppModule.kt` | Provide Firebase (ปัจจุบัน disable) |
| `di/RepositoryModule.kt` | Bind repository (ใช้ FakeAuthRepository) |
| `data/OrderCache.kt` | เก็บ order ใน memory (ชั่วคราว) |
| `data/LocationMasterData.kt` | ข้อมูลจังหวัด/อำเภอ/ตำบล |
| `data/PlatformMasterData.kt` | ประเภท platform |
| `utils/Resource.kt` | Result wrapper: Success / Error / Loading |
| `utils/Extensions.kt` | Extension functions สำหรับ View |
| `utils/LocationDropdownHelper.kt` | จัดการ dropdown location แบบ cascade |

### Domain (`domain/`)
| ไฟล์ | หน้าที่ |
|------|---------|
| `model/User.kt` | Data class ผู้ใช้ |
| `model/Order.kt` | Data class ออเดอร์ |
| `model/Location.kt` | Data class ตำแหน่งที่ตั้ง |
| `repository/AuthRepository.kt` | Interface สำหรับ auth |
| `usecase/auth/SignInUseCase.kt` | Business logic การ login |
| `usecase/auth/SignUpUseCase.kt` | Business logic การ register |

### Data (`data/`)
| ไฟล์ | หน้าที่ |
|------|---------|
| `repository/FakeAuthRepository.kt` | Mock auth (user: admin / pass: 1234) |
| `repository/AuthRepositoryImpl.kt` | Firebase auth (ปัจจุบัน disable) |
| `source/remote/FirebaseAuthSource.kt` | Firebase wrapper |

### Presentation (`presentation/`)
| ไฟล์ | หน้าที่ |
|------|---------|
| `ui/MainActivity.kt` | Entry point หลัก, NavHostFragment |
| `ui/auth/LoginFragment.kt` | หน้า Login |
| `ui/auth/RegisterFragment.kt` | หน้า Register |
| `ui/home/SearchFragment.kt` | หน้าค้นหาออเดอร์ |
| `ui/home/SearchResultFragment.kt` | แสดงผลการค้นหา |
| `ui/home/OrdersFragment.kt` | ฟอร์มเพิ่มออเดอร์ใหม่ |
| `ui/home/OrderResultFragment.kt` | รายการออเดอร์ทั้งหมด |
| `ui/home/OrderResultAdapter.kt` | RecyclerView adapter |
| `viewmodel/AuthViewModel.kt` | ViewModel สำหรับ auth |

---

## Navigation Flow

```
Login
  └→ Register
       └→ Search (หน้าหลักหลัง login)
             ├→ Search Result   (ค้นหาแล้วแสดงผล)
             └→ Orders Form     (เพิ่มออเดอร์)
                   └→ Order Result  (รายการออเดอร์)
```

**nav_graph.xml** อยู่ที่ `res/navigation/nav_graph.xml`

---

## Tech Stack

| หมวด | เทคโนโลยี |
|------|-----------|
| ภาษา | Kotlin |
| DI | Hilt (Dagger) |
| Async | Coroutines + StateFlow |
| UI Binding | ViewBinding |
| Navigation | Jetpack Navigation Component |
| UI | Material Design 3 |
| Logging | Timber |
| Backend | Firebase (เตรียมไว้, ยังไม่ active) |

---

## Entry Points สำคัญ

- **`EndpointApp.kt`** — Hilt Application class (จุดเริ่มต้นของ app)
- **`MainActivity.kt`** — Activity หลัก (มี NavHostFragment)
- **`nav_graph.xml`** — กำหนดเส้นทาง navigation ทั้งหมด

---

## สถานะปัจจุบัน

- Auth และ Order UI พร้อมใช้งาน (ใช้ Mock data)
- Firebase integration เตรียมไว้แต่ยัง disable
- `OrderCache` เก็บข้อมูล in-memory เท่านั้น (ยังไม่มี backend จริง)
- `core/network/` ว่างอยู่ รอ API integration
- `profile/` และ `widget/` ยังไม่ implement


### AppDialog Component

ใช้แทน `MaterialAlertDialogBuilder` โดยตรง — รองรับ icon สี, 2 ปุ่ม, custom text

```kotlin
AppDialog.show(
    fragment = this,
    type = AppDialog.Type.SUCCESS,   // SUCCESS / ERROR / WARNING / INFO
    title = "สำเร็จ",
    message = "เพิ่ม Order สำเร็จ",
    positiveText = "ตกลง",           // optional, default = "ตกลง"
    negativeText = "ยกเลิก",         // optional, null = ซ่อนปุ่ม negative
    cancelable = false,              // optional, default = false
    onPositive = { /* action */ },
    onNegative = { /* action */ }
)
```

| Type | Icon | สีปุ่ม |
|---|---|---|
| `SUCCESS` | วงกลมเขียว + ✓ | เขียว |
| `ERROR` | วงกลมแดง + ✕ | แดง |
| `WARNING` | วงกลมส้ม + ! | ส้ม |
| `INFO` | วงกลมน้ำเงิน + i | น้ำเงิน |

- Layout: `res/layout/component_alert_dialog.xml`
- Icons: `res/drawable/ic_dialog_*.xml`