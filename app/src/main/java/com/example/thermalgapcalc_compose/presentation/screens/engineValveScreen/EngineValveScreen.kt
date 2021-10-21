package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.CylinderState
import com.example.thermalgapcalc_compose.presentation.CylinderValveMeasurementState
import com.example.thermalgapcalc_compose.presentation.screens.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField.NumericTextField

object EngineValveScreen {
    @Composable
    fun EngineValveScreen(viewModel: EngineSettingsViewModel, navController: NavHostController) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(text = stringResource(id = R.string.calculate)) },
                    onClick = { navController.navigate(NavigationRoute.RESULT) })
            },
        ) {
            Column() {
                EngineParamsCard(viewModel = viewModel)
                CylinderCardsHolder(viewModel = viewModel)
            }
        }
    }

    @Composable
    fun EngineParamsCard(viewModel: EngineSettingsViewModel) {
        CardWithTitle(title = stringResource(id = R.string.engine_titile)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "${stringResource(id = R.string.cylinders_count)} ")
                Text(text = "${viewModel.engineViewState.getCylinderQuantity().value.toInt()}")
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
                Text(text = "${viewModel.engineViewState.getInValveQuantity().value}")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "${stringResource(id = R.string.in_gaps)} ")
                Text(text = "${viewModel.engineViewState.getInGapNormal().value} ${stringResource(id = R.string.plus_minus)}${viewModel.engineViewState.getInGapTolerance().value}")
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
                Text(text = "${viewModel.engineViewState.getExValveQuantity().value}")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "${stringResource(id = R.string.ex_gaps)} ")
                Text(text = "${viewModel.engineViewState.getExGapNormal().value} ${stringResource(id = R.string.plus_minus)}${viewModel.engineViewState.getExGapTolerance().value}")
            }
        }
    }

    @Composable
    fun CylinderCard(number: Int, cylinderState: CylinderState) {
        val inValveList = cylinderState.inValveList
        val exValveList = cylinderState.exValveList
        val cylinderFormat =
            String.format(stringResource(id = R.string.cylinder), (number + 1).toString())
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
                    modifier = Modifier.wrapContentWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.ex),
                        Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                    repeat(exValveList.size) {
                        MeasurementFields(exValveList[it])
                    }

                }

                Column(
                    modifier = Modifier.wrapContentWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.input),
                        Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,

                        )
                    repeat(inValveList.size) {
                        MeasurementFields(inValveList[it])
                    }

                }

            }

        }
    }

    @Composable
    fun MeasurementFields(valveMeasurementState: CylinderValveMeasurementState) {
        var measurementGapState by remember {
            valveMeasurementState.measurementGapState
        }
        var measurementSpacerState by remember {
            valveMeasurementState.measurementSpacerState
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumericTextField(
                R.string.gap_label,
                measurementGapState,
                modifier = Modifier
                    .weight(1f),
                onParamsChange = {
                    measurementGapState = it
                }

            )
            Spacer(Modifier.size(8.dp))
            NumericTextField(
                labelRes = R.string.spacer_label,
                measurementSpacerState,
                modifier = Modifier
                    .weight(1f),
                onParamsChange = { measurementSpacerState = it }
            )
        }
    }

    @Composable
    fun CylinderCardsHolder(viewModel: EngineSettingsViewModel) {
        val scrollState = rememberScrollState()
        Column(Modifier
            .verticalScroll(scrollState)
            .padding(bottom = 80.dp)) {
            repeat(viewModel.engineViewState.getCylinderQuantity().value.toInt()) { cylinderNumber ->
                val cylinderState = viewModel.cylinderStateList[cylinderNumber]
                CylinderCard(number = cylinderNumber, cylinderState)
            }
        }
    }
}