package com.example.thermalgapcalc_compose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thermalgapcalc_compose.data.db.entity.SettingsEngineParamsEntity

@Database(entities = [SettingsEngineParamsEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun measurementEngineDao(): SettingsEngineParamDao
}