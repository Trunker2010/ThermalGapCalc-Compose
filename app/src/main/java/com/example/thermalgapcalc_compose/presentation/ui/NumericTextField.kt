package com.example.thermalgapcalc_compose.presentation.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

object NumericTextField {
    @Composable
    fun NumericTextField(
        labelRes: Int,
        inputParam: MutableState<String>,
        modifier: Modifier = Modifier,
        onParamsChange: (MutableState<String>, String) -> Unit,
    ) {
        val text = remember {
            inputParam
        }

        OutlinedTextField(
            modifier = modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            label = { Text(text = stringResource(id = labelRes)) },
            value = text.value,
            shape = RoundedCornerShape(18.dp),
            onValueChange = {
                val parsed = parseNumeric(it)
                onParamsChange(text, parsed)
            }
            )
    }

    private fun parseNumeric(text: String): String {
        var digCount = 0
        var parsed = text.replace(",", ".")
        parsed.forEach {
            if (it == '.') {
                digCount++
            }
        }
        if (text.isNotEmpty()) {
            if (parsed.startsWith("00")) {
                parsed = "0"
            }
            if (parsed == (".")) {
                parsed = parsed.replace(".", "0.")
            }
            if (digCount > 1) {
                parsed = "0."
            }
        }
        return parsed
    }
}