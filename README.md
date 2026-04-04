

### Project Structure

endpoint - mobile/
├── build.gradle.kts              # Root build file
├── settings.gradle.kts
├── gradle/libs.versions.toml     # Version catalog
└── app/
    ├── build.gradle.kts          # App dependencies
    ├── proguard-rules.pro
    └── src/main/
        ├── AndroidManifest.xml
        ├── java/com/personal/endpointmobile/
        │   ├── EndpointApp.kt            # Hilt application
        │   ├── core/
        │   │   ├── di/                   # Hilt modules
        │   │   └── utils/                # Resource<T>, Extensions
        │   ├── domain/                   # Pure Kotlin — no Android/Firebase
        │   │   ├── model/User.kt
        │   │   ├── repository/           # Interfaces
        │   │   └── usecase/auth/         # Business logic
        │   ├── data/                     # Firebase implementations
        │   │   ├── model/UserDto.kt
        │   │   ├── source/remote/        # FirebaseAuthSource
        │   │   └── repository/           # AuthRepositoryImpl
        │   └── presentation/
        │       ├── ui/                   # MainActivity, Fragments
        │       └── viewmodel/            # AuthViewModel
        └── res/
            ├── layout/                   # XML layouts (ViewBinding)
            ├── navigation/nav_graph.xml
            └── values/
