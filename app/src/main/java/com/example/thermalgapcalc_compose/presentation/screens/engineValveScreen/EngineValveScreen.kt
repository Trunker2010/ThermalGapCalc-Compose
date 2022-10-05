package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.navigation.Screen
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardState
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CardHolderEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view.CylinderCardsHolder
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view.EngineParamsCard
import com.example.thermalgapcalc_compose.presentation.ui.CustomTextButton

object EngineValveScreen {
    @Composable
    fun EngineValveScreen(
        pramCardsViewModel: ParamsCardViewModel,
        cardsViewModel: CylinderCardsViewModel,
        navController: NavController,
    ) {

        val viewState = pramCardsViewModel.cardParamsState.observeAsState()

        when (val state = viewState.value) {
            is ParamsCardState.Display -> {

                Column(Modifier.fillMaxSize()) {
                    EngineParamsCard(state = state)
                    CylinderCardsHolder(viewModel = cardsViewModel, Modifier.weight(1f))

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CustomTextButton(
                            modifier = Modifier,
                            textRes = R.string.add_cylinder
                        ) {
                            navController.navigate(Screen.AddingMeasurementsCylinder.route)
                        }
                        CustomTextButton(modifier = Modifier, textRes = R.string.calculate) {
                            cardsViewModel.obtainEvent(event = CardHolderEvents.SaveEngineMeasurements)
                            navController.navigate(Screen.MeasurementResult.route)
                        }
                    }
                }
            }
            null -> TODO()
        }
    }
}