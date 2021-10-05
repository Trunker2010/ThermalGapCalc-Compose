package com.example.thermalgapcalc_compose.presentation.screens.engineSettings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField.NumericTextField
import kotlin.math.roundToInt


object EngineSettingsCompose {
    @Composable
    private fun EngineSize(viewModel: EngineSettingsViewModel) {
        var sliderPosition by remember { viewModel.engineViewState.getCylinderQuantity() }
        CardWithTitle(title = stringResource(id = R.string.cylinders_count)) {
            Text(text = sliderPosition.roundToInt().toString())
            Slider(
                value = sliderPosition, steps = 14, valueRange = 1f..16f,
                onValueChange = {
                    sliderPosition = it
                },
                onValueChangeFinished = {
                    viewModel.engineViewState.setCylinderQuantity(
                        sliderPosition.roundToInt().toFloat()
                    )
                }
            )
        }
    }

    @Composable
    private fun GapsSettings(viewModel: EngineSettingsViewModel) {
        CardWithTitle(title = stringResource(id = R.string.gaps)) {
            Row() {
                NumericTextField(
                    labelRes = R.string.in_label,
                    inputParam = viewModel.engineViewState.getInGapNormal(),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f)
                )
                NumericTextField(
                    labelRes = R.string.plus_minus,
                    inputParam = viewModel.engineViewState.getInGapTolerance()
                )
            }
            Row(Modifier.padding(top = 8.dp)) {
                NumericTextField(
                    labelRes = R.string.ex_label,
                    inputParam = viewModel.engineViewState.getExGapNormal(),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f)
                )
                NumericTextField(
                    labelRes = R.string.plus_minus,
                    inputParam = viewModel.engineViewState.getExGapTolerance()
                )
            }
        }
    }


    @Composable
    private fun ValveSelector(viewModel: EngineSettingsViewModel) {
        CardWithTitle(title = stringResource(id = R.string.valve_quantity)) {
            Row() {
                ValveSizeRadioButtonGroup(
                    title = stringResource(id = R.string.input),
                    viewModel.engineViewState.getInValveQuantity()
                )
                ValveSizeRadioButtonGroup(
                    title = stringResource(id = R.string.ex),
                    viewModel.engineViewState.getExValveQuantity()
                )
            }
        }
    }

    @Composable
    private fun ValveSizeRadioButtonGroup(title: String, state: MutableState<Int>) {

        var selectState by remember {
            state
        }
        Box() {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title, modifier = Modifier,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "1", textAlign = TextAlign.Center)
                        RadioButton(selected = selectState == 1, onClick = { selectState = 1 })
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "2", textAlign = TextAlign.Center)
                        RadioButton(selected = selectState == 2, onClick = { selectState = 2 })

                    }
                }
            }
        }
    }

    @Composable
    private fun NextFAB(navController: NavController, viewModel: EngineSettingsViewModel) {
        FloatingActionButton(onClick = {
            viewModel.initCylindersState()
            navController.navigate(NavigationRoute.VALVE_SETTINGS)
        }) {
            Text(text = stringResource(id = R.string.next))
        }
    }

    @Composable
    fun EngineSettingsScreen(navController: NavController, viewModel: EngineSettingsViewModel) {
        val scrollState = rememberScrollState()
        Scaffold(floatingActionButton = {
            NextFAB(navController = navController, viewModel = viewModel)
        }) {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(bottom = 80.dp)
            ) {
                EngineSize(viewModel = viewModel)
                GapsSettings(viewModel = viewModel)
                ValveSelector(viewModel = viewModel)
            }
        }
    }
}
