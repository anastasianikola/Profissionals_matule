package com.example.profissionals_matule.domain.validator

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ValidatorModule {

    @Singleton
    @Provides
    fun provideEmailValidator(): EmailValidator {
        return EmailValidator()
    }

    @Singleton
    @Provides
    fun providePasswordValidator(): PasswordValidator {
        return PasswordValidator()
    }

}