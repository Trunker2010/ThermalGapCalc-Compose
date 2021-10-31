package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.data.CylinderState
import com.example.thermalgapcalc_compose.presentation.screens.data.MeasurementFields
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CardHolderEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel

@Composable
fun CylinderCard(
    index: Int,
    cylinderState: CylinderState,
    viewModel: CylinderCardsViewModel,
) {
    val inValveList = cylinderState.inValveList
    val exValveList = cylinderState.exValveList
    val cylinderFormat =
        String.format(stringResource(id = R.string.cylinder), (index + 1).toString())
    Card(
        Modifier
            .padding(all = 8.dp)
            .shadow(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = (cylinderFormat),
                textAlign = TextAlign.Center,
            )
            Column(
                modifier = Modifier.wrapContentWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.ex),
                    Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
                repeat(exValveList.size) {
                    MeasurementFields(viewModel.cardHolderViewState,
                        exValveList[it],
                        { state, str ->
                            viewModel.obtainEvent(CardHolderEvents.ExMeasurementGapChange(
                                state,
                                str))
                        },
                        { state, str ->
                            viewModel.obtainEvent(CardHolderEvents.ExMeasurementSpacerChange(
                                state,
                                str))
                        }
                    )
                }
            }

            Column(
                modifier = Modifier.wrapContentWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.input),
                    Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,

                    )
                repeat(inValveList.size) {
                    MeasurementFields(viewModel.cardHolderViewState, inValveList[it],
                        { state, str ->
                            viewModel.obtainEvent(CardHolderEvents.InMeasurementGapChange(
                                state = state,
                                str))
                        }
                    ) { state, str ->
                        viewModel.obtainEvent(CardHolderEvents.InMeasurementSpacerChange(
                            state,
                            str))
                    }
                }
            }
        }
    }
}