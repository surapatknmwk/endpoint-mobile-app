package com.personal.endpointmobile.core.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00060\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0014\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/personal/endpointmobile/core/data/LocationMasterData;", "", "()V", "districtsByProvinceId", "", "", "", "Lcom/personal/endpointmobile/domain/model/District;", "getDistrictsByProvinceId", "()Ljava/util/Map;", "districtsByProvinceId$delegate", "Lkotlin/Lazy;", "provinces", "Lcom/personal/endpointmobile/domain/model/Province;", "getProvinces", "()Ljava/util/List;", "provinces$delegate", "sakonNakhon", "subDistrictsByDistrictId", "Lcom/personal/endpointmobile/domain/model/SubDistrict;", "getSubDistrictsByDistrictId", "subDistrictsByDistrictId$delegate", "app_debug"})
public final class LocationMasterData {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy provinces$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy districtsByProvinceId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy subDistrictsByDistrictId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.personal.endpointmobile.domain.model.Province sakonNakhon = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.personal.endpointmobile.core.data.LocationMasterData INSTANCE = null;
    
    private LocationMasterData() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personal.endpointmobile.domain.model.Province> getProvinces() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, java.util.List<com.personal.endpointmobile.domain.model.District>> getDistrictsByProvinceId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, java.util.List<com.personal.endpointmobile.domain.model.SubDistrict>> getSubDistrictsByDistrictId() {
        return null;
    }
}