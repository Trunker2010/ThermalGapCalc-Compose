package com.example.thermalgapcalc_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.presentation.screens.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineSettings.EngineSettingsCompose
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.EngineValveCompose
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle
import com.example.thermalgapcalc_compose.ui.theme.ThermalGapCalcComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel by viewModels<EngineSettingsViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ThermalGapCalcComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navController = navController, viewModel)
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController, viewModel: EngineSettingsViewModel) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.ENGINE_SETTINGS
    ) {
        composable(NavigationRoute.ENGINE_SETTINGS) {
            EngineSettingsCompose.EngineSettingsScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(NavigationRoute.VALVE_SETTINGS) {
            EngineValveCompose.EngineValveScreen(viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThermalGapCalcComposeTheme {
        CardWithTitle(title = "asd") {

        }
    }
}