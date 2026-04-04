package com.personal.endpointmobile.core.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"setupLocationDropdowns", "Lkotlin/Function0;", "", "Landroidx/fragment/app/Fragment;", "tilProvince", "Lcom/google/android/material/textfield/TextInputLayout;", "tilDistrict", "tilSubDistrict", "setupPlatformDropdown", "tilPlatform", "app_debug"})
public final class LocationDropdownHelperKt {
    
    /**
     * ตั้งค่า cascade dropdown จังหวัด → อำเภอ → ตำบล
     *
     * ใช้งาน:
     *  val resetLocation = setupLocationDropdowns(binding.tilProvince, binding.tilDistrict, binding.tilSubDistrict)
     *  resetLocation() // เรียกเพื่อ reset ค่าทั้งหมด
     *
     * @return lambda สำหรับ reset ค่าทั้งหมดกลับสู่สถานะเริ่มต้น
     */
    @org.jetbrains.annotations.NotNull()
    public static final kotlin.jvm.functions.Function0<kotlin.Unit> setupLocationDropdowns(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$setupLocationDropdowns, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout tilProvince, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout tilDistrict, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout tilSubDistrict) {
        return null;
    }
    
    /**
     * ตั้งค่า dropdown สำหรับ Platform (Facebook / Line / TikTok)
     *
     * ใช้งาน:
     *  setupPlatformDropdown(binding.tilPlatform)
     */
    public static final void setupPlatformDropdown(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$setupPlatformDropdown, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout tilPlatform) {
    }
}