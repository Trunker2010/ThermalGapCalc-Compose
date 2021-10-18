package com.example.thermalgapcalc_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.thermalgapcalc_compose.presentation.screens.Navigation.NavigationComponent
import com.example.thermalgapcalc_compose.ui.theme.ThermalGapCalcComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ThermalGapCalcComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThermalGapCalcComposeTheme {
    }
}