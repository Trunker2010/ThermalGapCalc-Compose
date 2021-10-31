package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
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
                itemsIndexed(state.engineSettingsConfig.cylindersList,
                    { index, item -> item.hashCode() }) { index, item ->
                    CylinderCard(index = index, item, viewModel)
                }
            }
        }
    }
}