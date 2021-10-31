package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderHolderState

@Composable
fun CylinderCardsHolder(
    viewModel: CylinderCardsViewModel,
) {
    val holderState =
        viewModel.cardHolderViewState.observeAsState()

    when (val state = holderState.value) {
        is CylinderHolderState.Display -> {
            LazyColumn() {
                repeat(state.engineSettingsConfig.cylindersList.size) { index ->
                    item {
                        val cylinderState = state.engineSettingsConfig.cylindersList[index]
                        CylinderCard(index = index, cylinderState, viewModel)
                    }
                }
                item { Box(modifier = Modifier.padding(bottom = 80.dp)) }
            }
        }
    }
}