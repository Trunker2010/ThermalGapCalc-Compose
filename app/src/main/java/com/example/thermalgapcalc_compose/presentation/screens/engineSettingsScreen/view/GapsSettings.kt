package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineViewState
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField

@Composable
fun GapsSettings(
    state: EngineViewState.ViewStateInitial,
    onExGapNormalChange: (state: MutableState<String>, exGapNormal: String) -> Unit,
    onInGapNormalChange: (state: MutableState<String>, inGapNormal: String) -> Unit,
    onExGapToleranceChange: (state: MutableState<String>, exGapTolerance: String) -> Unit,
    onInGapToleranceChange: (state: MutableState<String>, inGapTolerance: String) -> Unit,
) {
    CardWithTitle.CardWithTitle(title = stringResource(id = R.string.gaps)) {
        Row(Modifier.padding(top = 8.dp)) {
            NumericTextField.NumericTextField(
                labelRes = R.string.ex_label,
                inputParam = state.engineSettingsConfig.exGapNormal,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .fillMaxWidth(0.5f),
                onParamsChange = onExGapNormalChange
            )
            NumericTextField.NumericTextField(
                labelRes = R.string.plus_minus,
                inputParam = state.engineSettingsConfig.exGapTolerance,
                onParamsChange = onExGapToleranceChange
            )
        }
        Row {
            NumericTextField.NumericTextField(
                labelRes = R.string.in_label,
                inputParam = state.engineSettingsConfig.inGapNormal,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .fillMaxWidth(0.5f),
                onParamsChange = onInGapNormalChange
            )
            NumericTextField.NumericTextField(
                labelRes = R.string.plus_minus,
                inputParam = state.engineSettingsConfig.inGapTolerance,
                onParamsChange = onInGapToleranceChange
            )
        }
    }
}