package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SavedMeasurementsHolder(modifier: Modifier, list: List<EngineMeasurementModel>) {
    val groupFormatter = DateTimeFormatter.ofPattern("dd.MM.yy")
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    val grouped =
        list.reversed().groupBy {
            groupFormatter.format(
                LocalDateTime.ofInstant(Instant.ofEpochMilli(it.date), ZoneId.systemDefault())
            )
        }
    Column(Modifier.fillMaxSize()) {
        LazyColumn {
            grouped.forEach { (initial, contactsForInitial) ->
                stickyHeader {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                MaterialTheme.colors.surface
                            )
                    ) {
                        Column() {
                            Text(modifier = Modifier
                                .padding(start = 12.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                                .padding(start = 4.dp), text = initial)
                        }
                    }
                }
                items(contactsForInitial) {
                    val instant = Instant.ofEpochMilli(it.date)
                    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                    SavedMeasurementCard(
                        modifier = Modifier,
                        data = formatter.format(date),
                        exValveSize = it.exValveQuantity,
                        inValveSize = it.inValveQuantity,
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