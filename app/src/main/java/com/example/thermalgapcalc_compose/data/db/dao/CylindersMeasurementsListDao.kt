package com.example.thermalgapcalc_compose.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.thermalgapcalc_compose.data.db.entity.CylindersMeasurementsListEntity

@Dao
interface CylindersMeasurementsListDao {
    @Insert
    fun save(cylindersMeasurementsList: CylindersMeasurementsListEntity)

    @Query("SELECT * FROM CylindersMeasurementsListEntity WHERE id LIKE :id")
    fun getById(id: String): CylindersMeasurementsListEntity
}