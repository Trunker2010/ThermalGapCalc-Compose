package com.example.thermalgapcalc_compose.di

import android.content.Context
import androidx.room.Room
import com.example.thermalgapcalc_compose.data.db.AppDataBase
import com.example.thermalgapcalc_compose.data.repository.EngineMeasurementRepositoryImpl
import com.example.thermalgapcalc_compose.data.storage.LocalEngineMeasurementStorage
import com.example.thermalgapcalc_compose.domain.useCas.GetEngineMeasurementListUseCase
import com.example.thermalgapcalc_compose.domain.useCas.GetMeasurementDetailsListUseCase
import com.example.thermalgapcalc_compose.domain.useCas.SaveEngineMeasurementUseCase
import com.example.thermalgapcalc_compose.presentation.data.EngineSettingsConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEngineSettingsConfig(): EngineSettingsConfig = EngineSettingsConfig()

    @Provides
    @Singleton
    fun provideAppDb(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "thermal_gap_calc_db").build()
    }

    @Provides
    @Singleton
    fun provideSaveEngineMeasurementUseCase(engineMeasurementRepository: EngineMeasurementRepositoryImpl): SaveEngineMeasurementUseCase =
        SaveEngineMeasurementUseCase(engineMeasurementRepository)

    @Provides
    @Singleton
    fun provideGetEngineMeasurementList(engineMeasurementRepository: EngineMeasurementRepositoryImpl): GetEngineMeasurementListUseCase =
        GetEngineMeasurementListUseCase(engineMeasurementRepository)

    @Provides
    @Singleton
    fun provideGetMeasurementDetailsListUseCase(engineMeasurementRepository: EngineMeasurementRepositoryImpl): GetMeasurementDetailsListUseCase =
        GetMeasurementDetailsListUseCase(engineMeasurementRepository)

    @Provides
    @Singleton
    fun provideEngineMeasurementRepository(localEngineMeasurementStorage: LocalEngineMeasurementStorage): EngineMeasurementRepositoryImpl =
        EngineMeasurementRepositoryImpl(localEngineMeasurementStorage = localEngineMeasurementStorage)

    @Provides
    @Singleton
    fun provideLocalMeasurementStorage(appDataBase: AppDataBase): LocalEngineMeasurementStorage =
        LocalEngineMeasurementStorage(appDataBase = appDataBase)
}