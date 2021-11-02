package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderHolderState

@Composable
fun CylinderCardsHolder(
    viewModel: CylinderCardsViewModel,
    navController: NavHostController,
) {
    val holderState =
        viewModel.cardHolderViewState.observeAsState()

    when (val state = holderState.value) {
        is CylinderHolderState.Display -> {
            LazyColumn {
                itemsIndexed(
                    state.engineSettingsConfig.cylindersList,
                ) { index, item ->
                    CylinderCard(index, item)
                }

                item {
                    TextButton(modifier = Modifier.padding(start = 8.dp),
                        onClick = { navController.navigate(NavigationRoute.ADDING) }) {
                        Text(text = stringResource(id = R.string.add_cylinder))
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(35.dp))
                }
            }
        }
    }
}