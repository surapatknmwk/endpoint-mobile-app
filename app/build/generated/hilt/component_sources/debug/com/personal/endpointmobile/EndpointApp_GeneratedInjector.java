package com.personal.endpointmobile;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;
import javax.annotation.processing.Generated;

@OriginatingElement(
    topLevelClass = EndpointApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
@Generated("dagger.hilt.android.processor.internal.androidentrypoint.InjectorEntryPointGenerator")
public interface EndpointApp_GeneratedInjector {
  void injectEndpointApp(EndpointApp endpointApp);
}
