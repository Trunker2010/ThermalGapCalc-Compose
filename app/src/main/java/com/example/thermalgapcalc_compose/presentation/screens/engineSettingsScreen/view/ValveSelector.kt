package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineViewState
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle

@Composable
fun ValveSelector(
    state: EngineViewState.ViewStateInitial,
    viewModel: EngineSettingsViewModel,
) {
    CardWithTitle.CardWithTitle(title = stringResource(id = R.string.valve_quantity)) {
        Row(horizontalArrangement = Center) {
            ValveSizeRadioButtonGroup(
                title = stringResource(id = R.string.input),
                state.engineSettingsConfig.inValveQuantity,
            ) { state, size ->
                viewModel.obtainEvent(
                    EngineSettingsEvents.InValveSizeChange(
                        state,
                        size
                    )
                )
            }
            ValveSizeRadioButtonGroup(
                title = stringResource(id = R.string.ex),
                state.engineSettingsConfig.exValveQuantity
            ) { state, size ->
                viewModel.obtainEvent(
                    EngineSettingsEvents.ExValveSizeChange(
                        state,
                        size
                    )
                )
            }
        }
    }
}
