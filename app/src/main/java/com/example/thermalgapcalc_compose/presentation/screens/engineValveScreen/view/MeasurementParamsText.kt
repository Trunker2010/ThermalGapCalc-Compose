package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.ui.theme.Shapes
import com.example.thermalgapcalc_compose.ui.theme.Typography

@Composable
fun MeasurementParams(gap: String, spacer: String, modifier: Modifier) {
    Row(modifier
        .padding(4.dp)
        .border(BorderStroke(2.dp, Color.DarkGray),shape = Shapes.small)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f).padding(4.dp)) {
            Text(text = stringResource(id = R.string.gap_label), style = Typography.h6)
            Text(text = gap, style = Typography.subtitle1)
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f).padding(4.dp)) {
            Text(text = stringResource(id = R.string.spacer_label), style = Typography.h6)
            Text(text = spacer, style = Typography.subtitle1)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()) {
        MeasurementParams(gap = "0.25", spacer = "2.3", modifier = Modifier
            .padding()
            .weight(1f))
        MeasurementParams(gap = "0.25", spacer = "2.3", modifier = Modifier
            .padding()
            .weight(1f))
    }
}