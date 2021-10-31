package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.data.CylinderState
import com.example.thermalgapcalc_compose.presentation.screens.data.CylinderValveMeasurementState
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardState
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CardHolderEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderHolderState
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.ui.NumericTextField.NumericTextField

object EngineValveScreen {
    @Composable
    fun EngineValveScreen(
        pramCardsViewModel: ParamsCardViewModel,
        cardsViewModel: CylinderCardsViewModel,
        navController: NavHostController,
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(text = stringResource(id = R.string.calculate)) },
                    onClick = { navController.navigate(NavigationRoute.RESULT) })
            },
        ) {
            val viewState = pramCardsViewModel.cardParamsState.observeAsState()

            Column {
                when (val state = viewState.value) {
                    is ParamsCardState.Display -> {
                        EngineParamsCard(state = state)
                        CylinderCardsHolder(viewModel = cardsViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun EngineParamsCard(state: ParamsCardState.Display) {
    CardWithTitle(title = stringResource(id = R.string.engine_title)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.cylinders_count)} ")
            Text(text = "${state.engineSettingsConfig.cylinderQuantity.value.toInt()}")
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.in_valve_count)} ")
            Text(text = "${state.engineSettingsConfig.inValveQuantity.value}")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.in_gaps)} ")
            Text(text = "${state.engineSettingsConfig.inGapNormal.value} ${stringResource(id = R.string.plus_minus)}${state.engineSettingsConfig.inGapTolerance.value}")
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.ex_valve_count)} ")
            Text(text = "${state.engineSettingsConfig.exValveQuantity.value}")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${stringResource(id = R.string.ex_gaps)} ")
            Text(text = "${state.engineSettingsConfig.exGapNormal.value} ${stringResource(id = R.string.plus_minus)}${state.engineSettingsConfig.exGapTolerance.value}")
        }
    }
}

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
                NumericTextField(
                    R.string.gap_label,
                    cylinderState.measurementGapState,
                    modifier = Modifier
                        .weight(1f),
                    onParamsChange = onChangeMeasurementGapState

                )
                Spacer(Modifier.size(8.dp))
                NumericTextField(
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

@Composable
fun CylinderCardsHolder(
    viewModel: CylinderCardsViewModel,
) {

    val scrollState = rememberScrollState()
    val holderState =
        viewModel.cardHolderViewState.observeAsState()

    when (val state = holderState.value) {
        is CylinderHolderState.Display -> {
            Column(Modifier
                .verticalScroll(scrollState)
                .padding(bottom = 80.dp)) {
                repeat(state.engineSettingsConfig.cylindersList.size) { index ->
                    val cylinderState = state.engineSettingsConfig.cylindersList[index]
                    CylinderCard(index = index, cylinderState, viewModel)
                }
            }

        }
    }
}