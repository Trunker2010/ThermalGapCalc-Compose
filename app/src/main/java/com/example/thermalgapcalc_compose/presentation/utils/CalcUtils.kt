package com.example.thermalgapcalc_compose.presentation.utils

import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.BAD_STATE
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.GOOD_STATE
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.DeviationStatuses.NORMAL_STATE
import java.lang.Exception
import kotlin.math.roundToInt

object CalcUtils {

    object DeviationStatuses {
        const val GOOD_STATE = "good"
        const val NORMAL_STATE = "normal"
        const val BAD_STATE = "bad"
    }

    fun calcSpacer(currentSpacer: Float, gap: Float, normalGap: Float) =
        (((currentSpacer + (gap - normalGap)) * 100.0F).roundToInt() / 100.0F)

    fun calcGapDeviation(normalGap: Float, gap: Float) =
        (((gap - normalGap) * 100.0F).roundToInt() / 100.0F)


    private fun calcDeviationPercent(gapTolerance: Float, gap: Float): Float {
        // TODO: 21.10.2021 Разобраться с ошибкой
        return try {
            (((gap / gapTolerance * 100.0f) * 100.0F).roundToInt() / 100.0F)
        } catch (e: Exception) {
            0.0f
        }
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