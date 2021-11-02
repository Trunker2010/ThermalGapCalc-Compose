package com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField

@Composable
fun MeasurementFields(
    measurementGapState: MutableState<String>,
    measurementSpacerState: MutableState<String>,
    onChangeMeasurementGapState: (MutableState<String>, gap: String) -> Unit,
    onChangeMeasurementSpacerState: (MutableState<String>, spacer: String) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NumericTextField.NumericTextField(
            R.string.gap_label,
            measurementGapState,
            modifier = Modifier
                .weight(1f),
            onParamsChange = onChangeMeasurementGapState

        )
        Spacer(Modifier.size(8.dp))
        NumericTextField.NumericTextField(
            labelRes = R.string.spacer_label,
            measurementSpacerState,
            modifier = Modifier
                .weight(1f),
            onParamsChange = onChangeMeasurementSpacerState
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun PreviewMeasurementFields() {
    MeasurementFields(measurementGapState = mutableStateOf("0.05"),
        measurementSpacerState = mutableStateOf("0.05"),
        onChangeMeasurementGapState = { state, gap -> },
        onChangeMeasurementSpacerState = { state, spacer -> })
}