package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.navigation.Screen
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineViewState
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view.GapsSettings
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view.ValveSelector
import com.example.thermalgapcalc_compose.presentation.ui.CustomTextButton


object EngineSettingsScreen {
    @Composable
    fun EngineSettingsScreen(navController: NavController, viewModel: EngineSettingsViewModel) {

        val viewState =
            viewModel.engineViewState.observeAsState()
        val scrollState = rememberScrollState()

        when (val state = viewState.value) {
            is EngineViewState.ViewStateInitial -> {

                Column(
                    modifier = Modifier
                        .verticalScroll(scrollState)
                        .padding(bottom = 80.dp)
                        .fillMaxSize()

                ) {
                    GapsSettings(state,
                        onExGapNormalChange = { state, str ->
                            viewModel.obtainEvent(
                                EngineSettingsEvents.BaseExGapChange(
                                    state,
                                    str
                                )
                            )
                        },
                        onExGapToleranceChange = { state, str ->
                            viewModel.obtainEvent(
                                EngineSettingsEvents.ExToleranceChange(
                                    state,
                                    str
                                )
                            )
                        },
                        onInGapNormalChange = { state, str ->
                            viewModel.obtainEvent(
                                EngineSettingsEvents.BaseInGapChange(
                                    state,
                                    str
                                )
                            )
                        },
                        onInGapToleranceChange = { state, str ->
                            viewModel.obtainEvent(
                                EngineSettingsEvents.InToleranceChange(
                                    state,
                                    str
                                )
                            )
                        }
                    )
                    ValveSelector(state, viewModel = viewModel)
                }
                Column(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {
                    CustomTextButton(modifier = Modifier, textRes = R.string.next, onClick = {
                        viewModel.obtainEvent(EngineSettingsEvents.NextClicked)
                        navController.navigate(Screen.ValveSettings.route)
                    })
                }
            }
            null -> TODO()
        }
    }
}