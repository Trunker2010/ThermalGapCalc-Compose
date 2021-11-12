package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ValveSizeRadioButtonGroup(
    title: String,
    state: MutableState<Int>,
    onValveSizeChange: (MutableState<Int>, Int) -> Unit,
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title, modifier = Modifier,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "1", textAlign = TextAlign.Center)
                RadioButton(selected = state.value == 1,
                    onClick = { onValveSizeChange(state, 1) })
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "2", textAlign = TextAlign.Center)
                RadioButton(selected = state.value == 2,
                    onClick = { onValveSizeChange(state, 2) })
            }
        }
    }
}