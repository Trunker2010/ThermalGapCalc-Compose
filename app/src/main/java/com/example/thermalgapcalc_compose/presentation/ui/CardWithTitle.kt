package com.example.thermalgapcalc_compose.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

object CardWithTitle {
    @Composable
    fun CardWithTitle(title: String, content: @Composable () -> Unit) {
        Card(
            Modifier
                .padding(all = 8.dp)
                .shadow(8.dp)
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title, Modifier.padding(vertical = 8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6
                )
                content()
            }
        }
    }
}