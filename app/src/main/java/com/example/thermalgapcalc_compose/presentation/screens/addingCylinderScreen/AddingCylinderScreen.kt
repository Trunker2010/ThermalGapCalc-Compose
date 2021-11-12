package com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model.AddingCylinderEvents
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.view.AddingCylinderCard
import com.example.thermalgapcalc_compose.presentation.ui.CustomTextButton

object AddingCylinderScreen {
    @Composable
    fun AddingCylinderScreen(viewModel: AddingCylinderViewModel) {
        Scaffold {
            Column {
                AddingCylinderCard(viewModel = viewModel)
                CustomTextButton(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    textRes = R.string.add
                ) {
                    viewModel.obtainEvent(AddingCylinderEvents.AddCylinderClick)
                }
            }
        }
    }
}