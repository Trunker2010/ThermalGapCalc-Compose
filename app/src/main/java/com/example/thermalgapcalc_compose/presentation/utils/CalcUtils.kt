package com.example.thermalgapcalc_compose.presentation.utils

import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.BAD_STATE
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.GOOD_STATE
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.NORMAL_STATE
import kotlin.math.roundToInt

object CalcUtils {

    object DeviationStatuses {
        val GOOD_STATE = "good"
        val NORMAL_STATE = "normal"
        val BAD_STATE = "bad"
    }

    fun calcSpacer(currentSpacer: Float, gap: Float, normalGap: Float) =
        (((currentSpacer + (gap - normalGap)) * 100.0F).roundToInt() / 100.0F)

    fun calcGapDeviation(normalGap: Float, gap: Float) =
        (((gap - normalGap) * 100.0F).roundToInt() / 100.0F)

    private fun calcDeviationPercent(gapTolerance: Float, gap: Float): Float {
        return (((gap / gapTolerance * 100) * 100.0F).roundToInt() / 100.0F)
    }

    fun getDeviationStatus(gapTolerance: Float, deviation: Float): String {
        return when (calcDeviationPercent(gapTolerance = gapTolerance, deviation)) {
            in 0f..35.0f -> {
                GOOD_STATE
            }
            in 35.01f..67.0f -> {
                NORMAL_STATE
            }
            else -> {
                BAD_STATE
            }
        }
    }
}