package com.personal.endpointmobile.core.di

import com.personal.endpointmobile.data.repository.FakeAuthRepository
import com.personal.endpointmobile.data.repository.OrderRepositoryImpl
import com.personal.endpointmobile.domain.repository.AuthRepository
import com.personal.endpointmobile.domain.repository.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: FakeAuthRepository): AuthRepository

    @Binds
    @Singleton
    abstract fun bindOrderRepository(impl: OrderRepositoryImpl): OrderRepository
}
