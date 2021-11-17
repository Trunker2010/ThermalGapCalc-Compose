package com.example.thermalgapcalc_compose.presentation.navigation

const val HISTORY_ROUTE= "history_rout"
const val ADD_ROUTE= "add_rout"
const val SETTINGS_ROUTE= "settings_rout"
const val ROOT_GRAPH_ROUTE = "root"

sealed class Screen(val route: String) {
    object History : Screen("history_screen")
    object EngineSettings : Screen("engine_settings_screen")
    object ValveSettings : Screen("valve_settings_screen")
    object AddingMeasurementsCylinder : Screen("adding_cylinder_screen")
    object MeasurementResult : Screen("measurement_result_screen")
    object Settings: Screen("settings_screen")
}
