package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R


@Composable
fun SavedMeasurementCard(
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
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = data, style = MaterialTheme.typography.body2)
            val exParams = stringResource(id = R.string.ex_engine_info,
                formatArgs = arrayOf(
                    exGapNormal,
                    exGapTolerance,
                    exValveSize,
                    if (exValveSize == 1) stringResource(id = R.string.valve) else stringResource(id = R.string.valve_a),
                ))
            val inParams = stringResource(id = R.string.in_engine_info,
                formatArgs = arrayOf(
                    inGapNormal,
                    inGapTolerance,
                    inValveSize,
                    if (inValveSize == 1) stringResource(id = R.string.valve) else stringResource(id = R.string.valve_a),
                ))
            Text(text = exParams)
            Text(text = inParams)
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun PreviewSaSavedMeasurementCard() {
    SavedMeasurementCard(Modifier, "20.07.2021 17:34:52",
        2,
        1,
        0.18f,
        0.03f,
        0.15f,
        0.03f,
        "0000")
}