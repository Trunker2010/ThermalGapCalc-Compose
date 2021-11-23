package com.example.thermalgapcalc_compose.presentation.navigation

const val DETAIL_ID_KEY = "id"
const val DETAIL_EX_GAP_NORMAL_KEY = "exGapNormal"
const val DETAIL_EX_GAP_TOLERANCE_KEY = "exGapTolerance"
const val DETAIL_IN_GAP_TOLERANCE_KEY = "inGapTolerance"
const val DETAIL_IN_GAP_NORMAL_KEY = "inGapNormal"

const val HISTORY_ROUTE = "history_rout"
const val ADD_ROUTE = "add_rout"
const val SETTINGS_ROUTE = "settings_rout"
const val ROOT_GRAPH_ROUTE = "root"

sealed class Screen(val route: String) {
    object History : Screen("history_screen")
    object EngineSettings : Screen("engine_settings_screen")
    object ValveSettings : Screen("valve_settings_screen")
    object AddingMeasurementsCylinder : Screen("adding_cylinder_screen")
    object MeasurementResult : Screen("measurement_result_screen")
    object Settings : Screen("settings_screen")
    object SavedDetails :
        Screen("saved_details_screen?id={$DETAIL_ID_KEY}&exGapNormal={$DETAIL_EX_GAP_NORMAL_KEY}&exGapTolerance={$DETAIL_EX_GAP_TOLERANCE_KEY}&inGapNormal={$DETAIL_IN_GAP_NORMAL_KEY}&inGapTolerance={$DETAIL_IN_GAP_TOLERANCE_KEY}") {
        fun passParams(
            id: String,
            exGapNormal: Float,
            exGapTolerance: Float,
            inGapNormal: Float,
            inGapTolerance: Float,
        ): String {
            return "saved_details_screen?id=$id&exGapNormal=$exGapNormal&exGapTolerance=$exGapTolerance&inGapNormal=$inGapNormal&inGapTolerance=$inGapTolerance"
        }
    }
}
