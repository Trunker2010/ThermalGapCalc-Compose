package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardState
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle

@Composable
fun EngineParamsCard(state: ParamsCardState.Display) {
    CardWithTitle.CardWithTitle(title = stringResource(id = R.string.engine_title)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.cylinders_count)} ")
            Text(text = "${state.engineSettingsConfig.cylinderQuantity.value.toInt()}")
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.in_valve_count)} ")
            Text(text = "${state.engineSettingsConfig.inValveQuantity.value}")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.in_gaps)} ")
            Text(text = "${state.engineSettingsConfig.inGapNormal.value} ${stringResource(id = R.string.plus_minus)}${state.engineSettingsConfig.inGapTolerance.value}")
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.ex_valve_count)} ")
            Text(text = "${state.engineSettingsConfig.exValveQuantity.value}")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.ex_gaps)} ")
            Text(text = "${state.engineSettingsConfig.exGapNormal.value} ${stringResource(id = R.string.plus_minus)}${state.engineSettingsConfig.exGapTolerance.value}")
        }
    }
}