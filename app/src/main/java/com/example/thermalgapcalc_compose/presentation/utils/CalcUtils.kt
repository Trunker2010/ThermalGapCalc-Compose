package com.example.thermalgapcalc_compose.presentation.utils

import kotlin.math.roundToInt

object CalcUtils {
    fun calcSpacer(currentSpacer: Float, gap: Float, normalGap: Float) =
        (((currentSpacer + (gap - normalGap)) * 100.0F).roundToInt() / 100.0F)

    fun calcGapDeviation(normalGap: Float, gap: Float) =
        (((gap - normalGap) * 100.0F).roundToInt() / 100.0F)
}