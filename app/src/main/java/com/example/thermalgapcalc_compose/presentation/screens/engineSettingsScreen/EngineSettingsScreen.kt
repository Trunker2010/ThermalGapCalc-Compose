package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineViewState
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view.EngineSizeSetter
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view.GapsSettings
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view.ValveSelector


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
                        EngineSizeSetter(
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
}