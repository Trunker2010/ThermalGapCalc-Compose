package com.example.thermalgapcalc_compose.presentation.screens.resultScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultViewModel
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.view.ResultCardHolder

object ResultScreen {
    @Composable
    fun ResultScreen(
        viewModel: ResultViewModel,
        navController: NavHostController,
    ) {
        ResultCardHolder(viewModel = viewModel)
    }
}