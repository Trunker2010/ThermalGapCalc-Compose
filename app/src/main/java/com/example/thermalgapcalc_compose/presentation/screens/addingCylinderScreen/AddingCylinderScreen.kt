package com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model.AddingCylinderEvents
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.view.AddingCylinderCard

object AddingCylinderScreen {
    @Composable
    fun AddingCylinderScreen(viewModel: AddingCylinderViewModel) {
        Scaffold {
            Column {
                AddingCylinderCard(viewModel = viewModel)
                TextButton(modifier = Modifier.padding(horizontal = 8.dp),onClick = { viewModel.obtainEvent(AddingCylinderEvents.AddCylinderClick) }) {
                    Text(text = stringResource(id = R.string.add))
                }

            }
        }
    }
}