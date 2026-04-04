# Firebase
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }

# Hilt
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }

# Data classes used with Firestore
-keep class com.personal.endpointmobile.data.model.** { *; }
-keep class com.personal.endpointmobile.domain.model.** { *; }
