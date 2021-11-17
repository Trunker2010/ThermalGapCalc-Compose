package com.example.thermalgapcalc_compose.presentation.ui.bottom_navigation

import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.navigation.ADD_ROUTE
import com.example.thermalgapcalc_compose.presentation.navigation.HISTORY_ROUTE
import com.example.thermalgapcalc_compose.presentation.navigation.SETTINGS_ROUTE
import com.example.thermalgapcalc_compose.presentation.navigation.Screen


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {

    object History : NavigationItem(HISTORY_ROUTE, R.drawable.ic_baseline_history_24, "История")
    object Add : NavigationItem(ADD_ROUTE, R.drawable.ic_baseline_add_box_24, "Создать")
    object Settings : NavigationItem(SETTINGS_ROUTE, R.drawable.ic_baseline_settings_24, "Настройки")
}