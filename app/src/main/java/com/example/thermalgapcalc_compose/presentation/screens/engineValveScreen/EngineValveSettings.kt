package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle

@Composable
fun EngineValveScreen(viewModel: EngineSettingsViewModel) {
    Scaffold() {
        EngineParamsCard(viewModel = viewModel)
    }
}

@Composable
fun EngineParamsCard(viewModel: EngineSettingsViewModel) {
    CardWithTitle(title = stringResource(id = R.string.engine_titile)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "${stringResource(id = R.string.cylinders_count)} ")
            Text(text = "${viewModel.size.value.toInt()}")
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "${stringResource(id = R.string.in_valve_count)} ")
            Text(text = "${viewModel.inputValveQuantity.value}")
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "${stringResource(id = R.string.in_gaps)} ")
            Text(text = "${viewModel.inGapNormal.value} ${stringResource(id = R.string.plus_minus)}${viewModel.inGapTolerance.value}")
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "${stringResource(id = R.string.ex_valve_count)} ")
            Text(text = "${viewModel.exValveQuantity.value}")
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "${stringResource(id = R.string.ex_gaps)} ")
            Text(text = "${viewModel.exGapNormal.value} ${stringResource(id = R.string.plus_minus)}${viewModel.exGapTolerance.value}")
        }
    }
}