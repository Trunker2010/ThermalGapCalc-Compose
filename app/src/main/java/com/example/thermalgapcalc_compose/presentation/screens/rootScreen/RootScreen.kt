package com.example.thermalgapcalc_compose.presentation.screens.rootScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenViewModelViewModel

object RootScreen {
    @Composable
    fun RootScreen(navController: NavHostController, viewModelViewModel: RootScreenViewModelViewModel) {
        Scaffold(floatingActionButton = {
            FloatingActionButton(onClick = {
                //todo реализовать отображение списка
                viewModelViewModel.getList()
                navController.navigate(NavigationRoute.ENGINE_SETTINGS)
            }
            ) {

            }
        }){
            Column {
                Text("Список пуст")
            }
        }
    }
}