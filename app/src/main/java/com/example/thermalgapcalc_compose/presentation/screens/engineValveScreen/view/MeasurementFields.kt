package com.example.thermalgapcalc_compose.presentation.screens.data

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderHolderState
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField

@Composable
fun MeasurementFields(
    viewState: LiveData<CylinderHolderState>,
    cylinderState: CylinderValveMeasurementState,
    onChangeMeasurementGapState: (MutableState<String>, gap: String) -> Unit,
    onChangeMeasurementSpacerState: (MutableState<String>, spacer: String) -> Unit,
) {
    val vState = viewState.observeAsState()
    when (val state = vState.value) {
        is CylinderHolderState.Display -> {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumericTextField.NumericTextField(
                    R.string.gap_label,
                    cylinderState.measurementGapState,
                    modifier = Modifier
                        .weight(1f),
                    onParamsChange = onChangeMeasurementGapState

                )
                Spacer(Modifier.size(8.dp))
                NumericTextField.NumericTextField(
                    labelRes = R.string.spacer_label,
                    cylinderState.measurementSpacerState,
                    modifier = Modifier
                        .weight(1f),
                    onParamsChange = onChangeMeasurementSpacerState
                )
            }
        }
    }
}