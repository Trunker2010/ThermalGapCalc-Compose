package com.example.thermalgapcalc_compose.presentation

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.thermalgapcalc_compose.presentation.navigation.Navigation.NavigationComponent
import com.example.thermalgapcalc_compose.presentation.ui.bottom_navigation.BottomNavigationBar
import com.example.thermalgapcalc_compose.ui.theme.ThermalGapCalcComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    @ExperimentalFoundationApi
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            ThermalGapCalcComposeTheme {
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController) },
                    floatingActionButtonPosition = FabPosition.Center,
                    isFloatingActionButtonDocked = true
                ) {
                    Box(Modifier.padding(it)) {
                        NavigationComponent(navController = navController)
                    }
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