package com.example.thermalgapcalc_compose.di

import com.example.thermalgapcalc_compose.presentation.data.EngineSettingsConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEngineSettingsConfig(): EngineSettingsConfig = EngineSettingsConfig()
}