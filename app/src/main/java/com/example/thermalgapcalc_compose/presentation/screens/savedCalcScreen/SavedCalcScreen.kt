package com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.ListEmpty
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.LoadingList
import com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.model.SavedCalcState
import com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.model.SavedCalcViewModel
import com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.model.SavedEvent
import com.example.thermalgapcalc_compose.presentation.ui.resultViews.ResultCardHolder

@Composable
fun SavedCalcScreen(
    navController: NavHostController,
    viewModel: SavedCalcViewModel,
    id: String,
    exGapNormal: Float,
    exGapTolerance: Float,
    inGapNormal: Float,
    inGapTolerance: Float
) {


    val state = viewModel.viewState.observeAsState()
    LaunchedEffect(key1 = state) {
        viewModel.obtainEvent(SavedEvent.LoadMeasurementList(id))
    }
    when (val viewState = state.value) {
        is SavedCalcState.Display -> {
            ResultCardHolder(
                cylinderStateList = viewState.measurementsList,
                inNormal = inGapNormal,
                exNormal = exGapNormal,
                exTolerance = exGapTolerance,
                inTolerance = inGapTolerance
            )
        }
        is SavedCalcState.Loading -> {
            LoadingList(modifier = Modifier)
        }
        is SavedCalcState.Empty -> {
            ListEmpty(modifier = Modifier)
        }
        else -> {}
    }
}