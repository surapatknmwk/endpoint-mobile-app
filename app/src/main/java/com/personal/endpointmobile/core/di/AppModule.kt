package com.personal.endpointmobile.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Firebase providers disabled until ready
    // Re-enable by uncommenting and restoring Firebase dependencies in build.gradle.kts
}
