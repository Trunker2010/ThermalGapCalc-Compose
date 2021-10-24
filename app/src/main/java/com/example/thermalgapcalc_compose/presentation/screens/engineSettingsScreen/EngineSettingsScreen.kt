package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.EngineViewState
import com.example.thermalgapcalc_compose.presentation.screens.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.model.EngineEvent
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField.NumericTextField
import kotlin.math.roundToInt

object EngineSettingsScreen {
    @Composable
    private fun EngineSize(
        state: EngineViewState.ViewStateInitial,
        onSizeChange: (size: Float) -> Unit,
    ) {
        CardWithTitle(title = stringResource(id = R.string.cylinders_count)) {
            Text(text = state.cylinderQuantity.roundToInt().toString())
            Slider(
                value = state.cylinderQuantity, steps = 14, valueRange = 1f..16f,
                onValueChange = {
                    onSizeChange(it)
                },
                onValueChangeFinished = {
                    state.cylinderQuantity.roundToInt().toFloat()
                }
            )
        }
    }

    @Composable
    private fun GapsSettings(
        state: EngineViewState.ViewStateInitial,
        onExGapNormalChange: (exGapNormal: String) -> Unit,
        onInGapNormalChange: (inGapNormal: String) -> Unit,
        onExGapToleranceChange: (exGapTolerance: String) -> Unit,
        onInGapToleranceChange: (inGapTolerance: String) -> Unit,

        ) {
        CardWithTitle(title = stringResource(id = R.string.gaps)) {


            Row(Modifier.padding(top = 8.dp)) {
                NumericTextField(
                    labelRes = R.string.ex_label,
                    inputParam = state.exGapNormal,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f),
                    onParamsChange = { onExGapNormalChange(it) }
                )
                NumericTextField(
                    labelRes = R.string.plus_minus,
                    inputParam = state.exGapTolerance,
                    onParamsChange = { onExGapToleranceChange(it) }
                )
            }
            Row() {
                NumericTextField(
                    labelRes = R.string.in_label,
                    inputParam = state.inGapNormal,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f),
                    onParamsChange = { onInGapNormalChange(it) }
                )
                NumericTextField(
                    labelRes = R.string.plus_minus,
                    inputParam = state.inGapTolerance,
                    onParamsChange = { onInGapToleranceChange(it) }
                )
            }
        }
    }

    @Composable
    private fun ValveSelector(
        state: EngineViewState.ViewStateInitial,
        viewModel: EngineSettingsViewModel,
    ) {
        CardWithTitle(title = stringResource(id = R.string.valve_quantity)) {
            Row() {
                ValveSizeRadioButtonGroup(
                    title = stringResource(id = R.string.input),
                    state.inValveQuantity,
                ) { viewModel.obtainEvent(EngineEvent.InValveSizeChange(it)) }
                ValveSizeRadioButtonGroup(
                    title = stringResource(id = R.string.ex),
                    state.exValveQuantity
                ) { viewModel.obtainEvent(EngineEvent.ExValveSizeChange(it)) }
            }
        }
    }

    @Composable
    private fun ValveSizeRadioButtonGroup(
        title: String,
        state: Int,
        onValveSizeChange: (Int) -> Unit,
    ) {

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
                        RadioButton(selected = state == 1, onClick = { onValveSizeChange(1) })
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "2", textAlign = TextAlign.Center)
                        RadioButton(selected = state == 2, onClick = { onValveSizeChange(2) })

                    }
                }
            }
        }
    }

    @Composable
    fun EngineSettingsScreen(navController: NavController, viewModel: EngineSettingsViewModel) {
        val viewState =
            viewModel.engineViewState.observeAsState(initial = EngineViewState.ViewStateInitial())
        val scrollState = rememberScrollState()
        when (val state = viewState.value) {
            is EngineViewState.ViewStateInitial -> {
                Scaffold(
                    floatingActionButton = {
                        ExtendedFloatingActionButton(onClick = {
                            navController.navigate(NavigationRoute.VALVE_SETTINGS)
                        }, text = { Text(text = stringResource(id = R.string.next)) })
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .verticalScroll(scrollState)
                            .padding(bottom = 80.dp)
                    ) {
                        EngineSize(
                            state,
                        ) { viewModel.obtainEvent(EngineEvent.CylinderSizeQuantityChange(it)) }
                        GapsSettings(state,
                            onExGapNormalChange = {
                                viewModel.obtainEvent(EngineEvent.BaseExGapChange(it))
                            },
                            onExGapToleranceChange = {
                                viewModel.obtainEvent(EngineEvent.ExToleranceChange(it))
                            },
                            onInGapNormalChange = {
                                viewModel.obtainEvent(EngineEvent.BaseInGapChange(it))
                            },
                            onInGapToleranceChange = {
                                viewModel.obtainEvent(EngineEvent.InToleranceChange(it))
                            }
                        )
                        ValveSelector(state, viewModel = viewModel)
                    }
                }
            }
        }

    }
}
