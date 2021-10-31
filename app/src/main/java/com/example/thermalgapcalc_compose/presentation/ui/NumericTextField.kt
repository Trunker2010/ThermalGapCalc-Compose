package com.example.thermalgapcalc_compose.presentation.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType

object NumericTextField {
    @Composable
    fun NumericTextField(
        labelRes: Int,
        inputParam: MutableState<String>,
        modifier: Modifier = Modifier,
        onParamsChange: (MutableState<String>, String) -> Unit,
    ) {
        OutlinedTextField(
            modifier = modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            label = { Text(text = stringResource(id = labelRes)) },
            value = inputParam.value,
            onValueChange = { onParamsChange(inputParam, it) })
    }
}