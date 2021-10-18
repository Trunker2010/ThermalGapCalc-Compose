package com.example.thermalgapcalc_compose.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.CylinderState
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils

object CardResult {
    @Composable
    fun CardResult(
        cylinderNumber: Int,
        cylinderState: CylinderState,
        inNormal: Float,
        exNormal: Float
    ) {

        CardWithTitle("Цилиндер  ${(cylinderNumber + 1)}") {
            Column() {
                Text(
                    text = stringResource(id = R.string.ex),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Row() {
                    repeat(cylinderState.exValveList.size) {
                        val currentGap =
                            cylinderState.exValveList[it].measurementGapState.value.toFloat()
                        val currentSpacer =
                            cylinderState.exValveList[it].measurementSpacerState.value.toFloat()

                        SpacerWithText.CircleText(
                            text = CalcUtils.calcSpaсer(currentSpacer, currentGap, exNormal)
                                .toString(),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                                .wrapContentWidth()
                        )
                    }
                }
            }
            Column() {
                Text(
                    text = stringResource(id = R.string.input),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Row() {
                    repeat(cylinderState.inValveList.size) {
                        val currentGap =
                            cylinderState.inValveList[it].measurementGapState.value.toFloat()
                        val currentSpacer =
                            cylinderState.inValveList[it].measurementSpacerState.value.toFloat()

                        SpacerWithText.CircleText(
                            text = CalcUtils.calcSpaсer(currentSpacer, currentGap, inNormal)
                                .toString(),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                                .wrapContentWidth()
                        )

                    }
                }
            }

        }
    }
}