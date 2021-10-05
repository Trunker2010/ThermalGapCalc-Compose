package com.example.thermalgapcalc_compose.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
object NextButton{
    @Composable
    private fun NextButton(navController: NavController) {

        Box(
            modifier = Modifier
                .padding(bottom = 8.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            TextButton(
                onClick = { navController.navigate(NavigationRoute.VALVE_SETTINGS) },
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(all = 8.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}