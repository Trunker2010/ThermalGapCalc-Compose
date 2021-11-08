package com.example.thermalgapcalc_compose.data.storage

import com.example.thermalgapcalc_compose.data.db.AppDataBase
import com.example.thermalgapcalc_compose.data.db.entity.CylindersListEntity
import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam
import com.example.thermalgapcalc_compose.domain.model.getGsonEngineList
import com.example.thermalgapcalc_compose.domain.model.toMeasurementEngineEntity


class LocalEngineMeasurementStorage(appDataBase: AppDataBase) :
    EngineMeasurementStorage {
    private val measurementEngineDao = appDataBase.measurementEngineDao()
    private val cylindersListDao = appDataBase.CylindersListDao()
    override fun getList(): List<EngineMeasurementModel> {
        val entityList = measurementEngineDao.getAll()
        val modelList: MutableList<EngineMeasurementModel> = mutableListOf()
        entityList.forEach {
            val engineMeasurementModel = EngineMeasurementModel(
                id = it.id,
                date = it.date!!.toLong(),
                inGapNormal = it.inGapNormal!!,
                inGapTolerance = it.inGapTolerance!!,
                exGapNormal = it.exGapNormal!!,
                exGapTolerance = it.exGapTolerance!!,
                IdCylindersList = it.IdCylindersListJson
            )
            modelList.add(engineMeasurementModel)
        }
        return modelList
    }

    override fun save(measurementParam: SaveEngineMeasurementParam) {
        val saveEngineMeasurementParam = measurementParam.toMeasurementEngineEntity()
        val gsonEngineList = measurementParam.getGsonEngineList()
        measurementEngineDao.save(saveEngineMeasurementParam)
        cylindersListDao.save(CylindersListEntity(saveEngineMeasurementParam.IdCylindersListJson,
            gsonEngineList))
    }
}