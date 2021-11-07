package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardState
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CardHolderEvents
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view.CylinderCardsHolder
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view.EngineParamsCard

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
                    onClick = {
                        cardsViewModel.obtainEvent(event = CardHolderEvents.SaveEngineMeasurements)
                        navController.navigate(NavigationRoute.RESULT)
                    })

            },
        ) {
            val viewState = pramCardsViewModel.cardParamsState.observeAsState()

            when (val state = viewState.value) {
                is ParamsCardState.Display -> {

                    Column(Modifier.fillMaxSize()) {
                        EngineParamsCard(state = state)
                        CylinderCardsHolder(viewModel = cardsViewModel, Modifier.weight(1f))
                        TextButton(modifier = Modifier
                            .padding(start = 8.dp)
                            .padding(vertical = 20.dp),
                            onClick = {
                                navController.navigate(NavigationRoute.ADDING)
                            }) {

                            Text(text = stringResource(id = R.string.add_cylinder))
                        }
                    }
                }
            }
        }
    }
}