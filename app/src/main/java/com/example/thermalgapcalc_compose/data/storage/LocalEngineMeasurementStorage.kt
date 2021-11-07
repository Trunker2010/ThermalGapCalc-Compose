package com.example.thermalgapcalc_compose.data.storage

import android.util.Log
import com.example.thermalgapcalc_compose.data.db.AppDataBase
import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import com.example.thermalgapcalc_compose.domain.model.SaveCylindersMeasurements
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam
import com.example.thermalgapcalc_compose.domain.model.toMeasurementEngineEntity
import com.google.gson.Gson


class LocalEngineMeasurementStorage(appDataBase: AppDataBase) :
    EngineMeasurementStorage {
    private val measurementEngineDao = appDataBase.measurementEngineDao()
    override fun getList(): List<EngineMeasurementModel> {
        val gson = Gson()
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
                cylindersList = gson.fromJson(it.cylindersListJson,
                    Array<SaveCylindersMeasurements>::class.java).toList()
            )
            modelList.add(engineMeasurementModel)
        }
        return modelList
    }

    override fun save(engineMeasurementParam: SaveEngineMeasurementParam) {
        val saveEngineMeasurementParam = engineMeasurementParam.toMeasurementEngineEntity()
        Log.d("save", saveEngineMeasurementParam.cylindersListJson)
        measurementEngineDao.save(saveEngineMeasurementParam)
    }
}