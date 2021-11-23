package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.presentation.navigation.Screen
import com.example.thermalgapcalc_compose.ui.theme.ThermalGapCalcComposeTheme


@Composable
fun SavedMeasurementCard(
    navController: NavHostController,
    modifier: Modifier,
    data: String,
    exValveSize: Int,
    inValveSize: Int,
    exGapNormal: Float,
    exGapTolerance: Float,
    inGapNormal: Float,
    inGapTolerance: Float,
    IdCylindersListJson: String,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp, horizontal = 8.dp)
            .clickable {
                navController.navigate(
                    Screen.SavedDetails.passParams(
                        id = IdCylindersListJson,
                        exGapNormal = exGapNormal,
                        exGapTolerance = exGapTolerance,
                        inGapNormal = inGapNormal,
                        inGapTolerance = inGapTolerance
                    )
                )
            }, shape = RoundedCornerShape(18.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .background(
                        MaterialTheme.colors.secondaryVariant,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(all = 4.dp)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 2.dp),
                    text = data,
                    style = MaterialTheme.typography.body2
                )
            }

            val exParams = stringResource(
                id = R.string.ex_engine_info,
                formatArgs = arrayOf(
                    exGapNormal,
                    exGapTolerance,
                    exValveSize,
                    if (exValveSize == 1) stringResource(id = R.string.valve) else stringResource(id = R.string.valve_a),
                )
            )
            val inParams = stringResource(
                id = R.string.in_engine_info,
                formatArgs = arrayOf(
                    inGapNormal,
                    inGapTolerance,
                    inValveSize,
                    if (inValveSize == 1) stringResource(id = R.string.valve) else stringResource(id = R.string.valve_a),
                )
            )
            Text(text = exParams)
            Divider(Modifier.padding(vertical = 2.dp))
            Text(text = inParams)
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun PreviewSaSavedMeasurementCard() {
    ThermalGapCalcComposeTheme(darkTheme = true) {
//        SavedMeasurementCard(
//            Modifier, "20.07.2021 17:34:52",
//            2,
//            1,
//            0.18f,
//            0.03f,
//            0.15f,
//            0.03f,
//            "0000"
//        )
    }
}