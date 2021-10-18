package com.example.thermalgapcalc_compose.presentation.utils

object CalcUtils {
    fun calcSpaсer(currentSpacer: Float, gap: Float, normalGap: Float) =
        currentSpacer + (gap - normalGap)
}