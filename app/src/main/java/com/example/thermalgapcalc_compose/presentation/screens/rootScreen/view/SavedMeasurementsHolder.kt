package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SavedMeasurementsHolder(modifier: Modifier, list: List<EngineMeasurementModel>) {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss")
    Column(Modifier.fillMaxSize()) {
        LazyColumn {

            list.reversed().forEach() {
                item {
                    val instant = Instant.ofEpochMilli(it.date)
                    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                    SavedMeasurementCard(
                        modifier = Modifier,
                        data =formatter.format(date),
                        exValveSize = 1,                     //TODO нужно сохранять в таблицу колличество входных/выходных клапанов
                        inValveSize = 2,
                        exGapNormal = it.exGapNormal.toFloat(),
                        exGapTolerance = it.exGapTolerance.toFloat(),
                        inGapNormal = it.inGapNormal.toFloat(),
                        inGapTolerance = it.inGapTolerance.toFloat(),
                        IdCylindersListJson = it.IdCylindersList
                    )
                }

            }
        }
    }
}