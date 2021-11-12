package com.example.thermalgapcalc_compose.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextButton(modifier: Modifier, textRes: Int, onClick: () -> Unit) {
    TextButton(
        modifier = modifier,
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.primary),

        ) {
        Text(stringResource(id = textRes))
    }
}