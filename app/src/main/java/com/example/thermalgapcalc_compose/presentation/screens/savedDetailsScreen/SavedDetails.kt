package com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view.CylinderCard
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.LoadingList
import com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.model.SavedDetailsScreenEvent
import com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.model.SavedDetailsScreenState
import com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.model.SavedDetailsViewModel

@Composable
fun SavedDetails(navController: NavHostController, viewModel: SavedDetailsViewModel, id: String) {

    val viewState = viewModel.saveDetailsState
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(SavedDetailsScreenEvent.LoadMeasurements(id = id))
    })
    when (val currentViewState = viewState.value) {
        is SavedDetailsScreenState.Display -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(
                    currentViewState.measurementsList,
                ) { index, item ->
                    CylinderCard(index, item)
                }
            }
        }
        is SavedDetailsScreenState.Loading -> {
            LoadingList(modifier = Modifier)
        }
        else -> {
            //TODO
            LoadingList(modifier = Modifier)
        }
    }


}