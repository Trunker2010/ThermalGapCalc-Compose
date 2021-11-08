package com.example.thermalgapcalc_compose.presentation.screens.rootScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenEvent
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenState
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenViewModelViewModel
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.ListEmpty
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.LoadingList
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.SavedMeasurementsHolder

object RootScreen {
    @Composable
    fun RootScreen(
        navController: NavHostController,
        viewModelViewModel: RootScreenViewModelViewModel
    ) {
        val viewState = viewModelViewModel.rootScreenState.observeAsState()
        LaunchedEffect(key1 = viewState, block = {
            viewModelViewModel.obtainEvent(RootScreenEvent.LoadMeasurementList)
        })
        Scaffold(floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModelViewModel.getList()
                navController.navigate(NavigationRoute.ENGINE_SETTINGS)
            }, content = {}
            )

        }) {
            when (val state = viewState.value) {
                is RootScreenState.Loading -> {
                    LoadingList(modifier = Modifier)
                }
                is RootScreenState.Display -> {
                    SavedMeasurementsHolder(modifier = Modifier, list = state.measurementsList)
                }
                is RootScreenState.Empty -> {
                    ListEmpty(modifier = Modifier)
                }
            }

        }
    }
}