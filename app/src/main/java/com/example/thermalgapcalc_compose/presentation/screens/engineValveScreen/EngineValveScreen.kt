package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardState
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardViewModel
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
