package com.example.thermalgapcalc_compose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thermalgapcalc_compose.data.db.dao.CylindersListDao
import com.example.thermalgapcalc_compose.data.db.dao.SettingsEngineParamDao
import com.example.thermalgapcalc_compose.data.db.entity.CylindersListEntity
import com.example.thermalgapcalc_compose.data.db.entity.SettingsEngineParamsEntity

@Database(entities = [SettingsEngineParamsEntity::class,CylindersListEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun measurementEngineDao(): SettingsEngineParamDao
    abstract fun CylindersListDao(): CylindersListDao
}