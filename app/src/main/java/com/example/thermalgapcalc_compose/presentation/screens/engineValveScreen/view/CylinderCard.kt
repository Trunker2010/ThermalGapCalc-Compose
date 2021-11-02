package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.data.CylinderState

@Composable
fun CylinderCard(
    index: Int,
    cylinderState: CylinderState,
) {
    val inValveList = cylinderState.inValveList
    val exValveList = cylinderState.exValveList
    val cylinderFormat =
        String.format(stringResource(id = R.string.cylinder), (index + 1).toString())
    Card(
        Modifier
            .padding(all = 8.dp)
            .shadow(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = (cylinderFormat),
                textAlign = TextAlign.Center,
            )
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 8.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.ex),
                    Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()) {
                    exValveList.forEach {
                        MeasurementParams(gap = it.measurementGapState.value,
                            spacer = it.measurementSpacerState.value,
                            modifier = Modifier.weight(1f))
                    }
                }
            }

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 8.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.input),
                    Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()) {
                    inValveList.forEach {
                        MeasurementParams(gap = it.measurementGapState.value,
                            spacer = it.measurementSpacerState.value,
                            modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}