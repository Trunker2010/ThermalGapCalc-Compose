package com.example.thermalgapcalc_compose.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.thermalgapcalc_compose.data.db.entity.CylindersListEntity

@Dao
interface CylindersListDao {
    @Insert
    fun save(cylindersList: CylindersListEntity)

    @Query("SELECT * FROM CylindersListEntity WHERE id LIKE :id")
    fun getById(id: String): CylindersListEntity
}