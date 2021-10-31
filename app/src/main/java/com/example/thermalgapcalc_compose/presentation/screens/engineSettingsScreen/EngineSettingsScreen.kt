package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineViewState
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField.NumericTextField
import kotlin.math.roundToInt

object EngineSettingsScreen {
    @Composable
    fun EngineSettingsScreen(navController: NavController, viewModel: EngineSettingsViewModel) {

        val viewState =
            viewModel.engineViewState.observeAsState()
        LaunchedEffect(key1 = viewState,
            block = { viewModel.obtainEvent(EngineSettingsEvents.InitialSettings) })
        val scrollState = rememberScrollState()
        when (val state = viewState.value) {
            is EngineViewState.ViewStateInitial -> {
                Scaffold(
                    floatingActionButton = {
                        ExtendedFloatingActionButton(onClick = {
                            viewModel.obtainEvent(EngineSettingsEvents.GenerateCylinderList)
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
                        ) { state, float ->
                            viewModel.obtainEvent(EngineSettingsEvents.CylinderSizeQuantityChange(state,
                                float))
                        }
                        GapsSettings(state,
                            onExGapNormalChange = { state, str ->
                                viewModel.obtainEvent(EngineSettingsEvents.BaseExGapChange(state,
                                    str))
                            },
                            onExGapToleranceChange = { state, str ->
                                viewModel.obtainEvent(EngineSettingsEvents.ExToleranceChange(state,
                                    str))
                            },
                            onInGapNormalChange = { state, str ->
                                viewModel.obtainEvent(EngineSettingsEvents.BaseInGapChange(state,
                                    str))
                            },
                            onInGapToleranceChange = { state, str ->
                                viewModel.obtainEvent(EngineSettingsEvents.InToleranceChange(state,
                                    str))
                            }
                        )
                        ValveSelector(state, viewModel = viewModel)
                    }
                }
            }
        }
    }

    @Composable
    private fun EngineSize(
        state: EngineViewState.ViewStateInitial,
        onSizeChange: (MutableState<Float>, size: Float) -> Unit,
    ) {
        CardWithTitle(title = stringResource(id = R.string.cylinders_count)) {
            Text(text = state.engineSettingsConfig.cylinderQuantity.value.roundToInt().toString())
            Slider(
                value = state.engineSettingsConfig.cylinderQuantity.value, steps = 14, valueRange = 1f..16f,
                onValueChange = {
                    onSizeChange(state.engineSettingsConfig.cylinderQuantity, it)
                },
                onValueChangeFinished = {
                    state.engineSettingsConfig.cylinderQuantity.value.roundToInt().toFloat()
                }
            )
        }
    }

    @Composable
    private fun GapsSettings(
        state: EngineViewState.ViewStateInitial,
        onExGapNormalChange: (state: MutableState<String>, exGapNormal: String) -> Unit,
        onInGapNormalChange: (state: MutableState<String>, inGapNormal: String) -> Unit,
        onExGapToleranceChange: (state: MutableState<String>, exGapTolerance: String) -> Unit,
        onInGapToleranceChange: (state: MutableState<String>, inGapTolerance: String) -> Unit,
    ) {
        CardWithTitle(title = stringResource(id = R.string.gaps)) {
            Row(Modifier.padding(top = 8.dp)) {
                NumericTextField(
                    labelRes = R.string.ex_label,
                    inputParam = state.engineSettingsConfig.exGapNormal,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f),
                    onParamsChange = onExGapNormalChange
                )
                NumericTextField(
                    labelRes = R.string.plus_minus,
                    inputParam = state.engineSettingsConfig.exGapTolerance,
                    onParamsChange = onExGapToleranceChange
                )
            }
            Row {
                NumericTextField(
                    labelRes = R.string.in_label,
                    inputParam = state.engineSettingsConfig.inGapNormal,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f),
                    onParamsChange = onInGapNormalChange
                )
                NumericTextField(
                    labelRes = R.string.plus_minus,
                    inputParam = state.engineSettingsConfig.inGapTolerance,
                    onParamsChange = onInGapToleranceChange
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
            Row {
                ValveSizeRadioButtonGroup(
                    title = stringResource(id = R.string.input),
                    state.engineSettingsConfig.inValveQuantity,
                ) { state, size ->
                    viewModel.obtainEvent(EngineSettingsEvents.InValveSizeChange(state,
                        size))
                }
                ValveSizeRadioButtonGroup(
                    title = stringResource(id = R.string.ex),
                    state.engineSettingsConfig.exValveQuantity
                ) { state, size ->
                    viewModel.obtainEvent(EngineSettingsEvents.ExValveSizeChange(state,
                        size))
                }
            }
        }
    }

    @Composable
    private fun ValveSizeRadioButtonGroup(
        title: String,
        state: MutableState<Int>,
        onValveSizeChange: (MutableState<Int>, Int) -> Unit,
    ) {
        Box {
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
                        RadioButton(selected = state.value == 1,
                            onClick = { onValveSizeChange(state, 1) })
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "2", textAlign = TextAlign.Center)
                        RadioButton(selected = state.value == 2,
                            onClick = { onValveSizeChange(state, 2) })
                    }
                }
            }
        }
    }
}