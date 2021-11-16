package com.example.thermalgapcalc_compose.presentation.screens.resultScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultViewModel
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.view.ResultCardHolder

object ResultScreen {
    @Composable
    fun ResultScreen(
        viewModel: ResultViewModel,
        navController: NavController,
    ) {
        ResultCardHolder(viewModel = viewModel)
    }
}