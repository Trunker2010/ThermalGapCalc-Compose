package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view

import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineViewState
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle
import kotlin.math.roundToInt

@Composable
fun EngineSizeSetter(
    state: EngineViewState.ViewStateInitial,
    onSizeChange: (MutableState<Float>, size: Float) -> Unit,
) {
    CardWithTitle.CardWithTitle(title = stringResource(id = R.string.cylinders_count)) {
        Text(text = state.engineSettingsConfig.cylinderQuantity.value.roundToInt().toString())
        Slider(
            value = state.engineSettingsConfig.cylinderQuantity.value,
            steps = 14,
            valueRange = 1f..16f,
            onValueChange = {
                onSizeChange(state.engineSettingsConfig.cylinderQuantity, it)
            },
            onValueChangeFinished = {
                state.engineSettingsConfig.cylinderQuantity.value.roundToInt().toFloat()
            }
        )
    }
}