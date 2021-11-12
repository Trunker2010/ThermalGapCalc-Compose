package com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.data.EngineSettingsConfig
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.AddingCylinderViewModel
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model.AddingCylinderEvents
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model.AddingCylinderState

@Composable
fun AddingCylinderCard(
    viewModel: AddingCylinderViewModel,
) {
    when (val state = viewModel.addingCylinderState.value) {
        is AddingCylinderState.Display -> {
            Card(
                Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                elevation = 4.dp
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        modifier = Modifier.wrapContentWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.ex),
                            Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                        )
                        repeat(state.cylinderState.exValveList.size) {
                            MeasurementFields(
                                state.cylinderState.exValveList[it].measurementGapState,
                                state.cylinderState.exValveList[it].measurementSpacerState,
                                { state, str ->
                                    viewModel.obtainEvent(
                                        AddingCylinderEvents.ExMeasurementGapChange(
                                            state,
                                            str
                                        )
                                    )
                                },
                                { state, str ->
                                    viewModel.obtainEvent(
                                        AddingCylinderEvents.ExMeasurementSpacerChange(
                                            state,
                                            str
                                        )
                                    )
                                }
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    Column(
                        modifier = Modifier.wrapContentWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.input),
                            Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,

                            )
                        repeat(state.cylinderState.inValveList.size) {
                            MeasurementFields(
                                state.cylinderState.inValveList[it].measurementGapState,
                                state.cylinderState.inValveList[it].measurementSpacerState,
                                { state, str ->
                                    viewModel.obtainEvent(
                                        AddingCylinderEvents.InMeasurementGapChange(
                                            state,
                                            str
                                        )
                                    )
                                },
                                { state, str ->
                                    viewModel.obtainEvent(
                                        AddingCylinderEvents.InMeasurementSpacerChange(
                                            state,
                                            str
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }

        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun PreviewAddingCylinderCard() {
    AddingCylinderCard(viewModel = AddingCylinderViewModel(EngineSettingsConfig()))
}