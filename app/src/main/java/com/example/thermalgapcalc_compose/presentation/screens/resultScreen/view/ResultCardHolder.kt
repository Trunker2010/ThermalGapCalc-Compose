package com.example.thermalgapcalc_compose.presentation.screens.resultScreen.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.thermalgapcalc_compose.presentation.data.CylinderState

@Composable
fun ResultCardHolder(
    cylinderStateList: MutableList<CylinderState>,
    inNormal: Float,
    exNormal: Float,
    exTolerance: Float,
    inTolerance: Float
) {
    LazyColumn {
        itemsIndexed(
            cylinderStateList
        ) { index, cylinderState ->
            CardResult(
                cylinderNumber = index,
                cylinderState = cylinderState,
                inNormal = inNormal,
                exNormal = exNormal,
                inTolerance = inTolerance,
                exTolerance = exTolerance,
            )
        }
    }
}