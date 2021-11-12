package com.example.thermalgapcalc_compose.presentation.screens.rootScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenEvent
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenState
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenViewModelViewModel
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.ListEmpty
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.LoadingList
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view.SavedMeasurementsHolder

object RootScreen {
    @ExperimentalFoundationApi
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun RootScreen(
        navController: NavHostController,
        viewModelViewModel: RootScreenViewModelViewModel
    ) {

        val viewState = viewModelViewModel.rootScreenState.observeAsState()
        LaunchedEffect(key1 = viewState, block = {
            viewModelViewModel.obtainEvent(RootScreenEvent.LoadMeasurementList)
        })

        Column(Modifier.fillMaxSize()) {
            when (val state = viewState.value) {
                is RootScreenState.Loading -> {
                    LoadingList(modifier = Modifier)
                }
                is RootScreenState.Display -> {
                    SavedMeasurementsHolder(
                        modifier = Modifier,
                        list = state.measurementsList
                    )
                }
                is RootScreenState.Empty -> {
                    ListEmpty(modifier = Modifier)
                }
            }
        }
    }
}