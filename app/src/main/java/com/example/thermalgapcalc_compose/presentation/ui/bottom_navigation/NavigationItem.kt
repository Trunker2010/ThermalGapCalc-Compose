package com.example.thermalgapcalc_compose.presentation.ui.bottom_navigation

import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.R

const val HISTORY_ROUTE = "history_rout"
const val ADD_ROUTE = "add_rout"
const val SETTINGS_ROUTE = "settings_rout"

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {

    object History : NavigationItem(NavigationRoute.ROOT, R.drawable.ic_baseline_history_24, "История")
    object Add : NavigationItem(NavigationRoute.ENGINE_SETTINGS, R.drawable.ic_baseline_add_box_24, "Создать")
    object Settings : NavigationItem(NavigationRoute.SETTINGS, R.drawable.ic_baseline_settings_24, "Настройки")
}