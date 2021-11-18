package com.example.thermalgapcalc_compose.data.storage

import com.example.thermalgapcalc_compose.data.db.AppDataBase
import com.example.thermalgapcalc_compose.data.db.entity.CylindersMeasurementsListEntity
import com.example.thermalgapcalc_compose.domain.model.*
import com.google.gson.Gson


class LocalEngineMeasurementStorage(appDataBase: AppDataBase) :
    EngineMeasurementStorage {
    private val measurementEngineDao = appDataBase.measurementEngineDao()
    private val cylindersListDao = appDataBase.CylindersListDao()
    override fun getSettingsEngineList(): List<EngineMeasurementModel> {
        val entityList = measurementEngineDao.getAll()
        val modelList: MutableList<EngineMeasurementModel> = mutableListOf()
        entityList.forEach {
            val engineMeasurementModel = EngineMeasurementModel(
                id = it.id,
                date = it.date,
                inGapNormal = it.inGapNormal,
                inGapTolerance = it.inGapTolerance,
                exGapNormal = it.exGapNormal,
                exGapTolerance = it.exGapTolerance,
                inValveQuantity = it.inValveQuantity,
                exValveQuantity = it.exValveQuantity,
                IdCylindersList = it.IdCylindersListJson
            )
            modelList.add(engineMeasurementModel)
        }
        return modelList
    }

    override fun save(saveEngineMeasurementParam: SaveEngineMeasurementParam) {
        val measurementParam = saveEngineMeasurementParam.toMeasurementEngineEntity()
        val gsonEngineList = saveEngineMeasurementParam.getGsonEngineList()
        measurementEngineDao.save(measurementParam)
        cylindersListDao.save(
            CylindersMeasurementsListEntity(
                measurementParam.IdCylindersListJson,
                gsonEngineList
            )
        )
    }

    override fun getMeasurementList(id: String): List<SaveCylindersMeasurements> {
        val gson = Gson()
        val json = cylindersListDao.getById(id).listJson
        return gson.fromJson(json, Array<SaveCylindersMeasurements>::class.java).asList()
    }
}