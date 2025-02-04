package com.example.profissionals_matule.data.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // This ensures the binding is available application-wide
abstract class AuthenticationModule {

    @Binds
    abstract fun bindAuthenticationRepository(
        impl: AuthenticationRepositoryImpl // Provide the implementation here
    ): AuthenticationRepository // Bind it to the interface
}