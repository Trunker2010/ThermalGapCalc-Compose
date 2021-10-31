package com.example.thermalgapcalc_compose.presentation.screens.resultScreen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.data.CylinderState
import com.example.thermalgapcalc_compose.presentation.ui.CardWithTitle.CardWithTitle
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.GOOD_STATE
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.NORMAL_STATE
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.calcGapDeviation
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.calcSpacer
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.getDeviationStatus

@Composable
fun CardResult(
    cylinderNumber: Int,
    cylinderState: CylinderState,
    inNormal: Float,
    exNormal: Float,
    exTolerance: Float,
    inTolerance: Float,
) {
    @Composable
    fun getDeviationStatusColor(status: String): Color {
        return when (status) {
            GOOD_STATE -> {
                colorResource(id = R.color.good_status)
            }
            NORMAL_STATE -> {
                colorResource(id = R.color.normal_status)
            }
            else -> {
                colorResource(id = R.color.bad_status)
            }
        }
    }

    val cylinderFormat =
        String.format(stringResource(id = R.string.cylinder), (cylinderNumber + 1).toString())
    CardWithTitle(title = cylinderFormat) {
        Column {
            Text(
                text = stringResource(id = R.string.ex),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Row {
                repeat(cylinderState.exValveList.size) {
                    val currentGap =
                        cylinderState.exValveList[it].measurementGapState.value.toFloat()
                    val currentSpacer =
                        cylinderState.exValveList[it].measurementSpacerState.value.toFloat()
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SpacerWithText.CircleText(
                            text = calcSpacer(currentSpacer, currentGap, exNormal)
                                .toString(),
                        )
                        val deviation = calcGapDeviation(exNormal, currentGap)
                        val deviationStatusColor =
                            getDeviationStatusColor(status = getDeviationStatus(exTolerance,
                                deviation = deviation))
                        Text(
                            text = deviation.toString(),
                            textAlign = TextAlign.Center,
                            color = deviationStatusColor
                        )
                    }
                }
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.input),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Row {
                repeat(cylinderState.inValveList.size) {
                    val currentGap =
                        cylinderState.inValveList[it].measurementGapState.value.toFloat()
                    val currentSpacer =
                        cylinderState.inValveList[it].measurementSpacerState.value.toFloat()
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SpacerWithText.CircleText(
                            text = calcSpacer(currentSpacer, currentGap, inNormal)
                                .toString(),
                        )
                        val deviation = calcGapDeviation(inNormal, currentGap)
                        val deviationStatusColor =
                            getDeviationStatusColor(status = getDeviationStatus(inTolerance,
                                deviation))
                        Text(deviation.toString(),
                            textAlign = TextAlign.Center,
                            color = deviationStatusColor)
                    }
                }
            }
        }
    }
}