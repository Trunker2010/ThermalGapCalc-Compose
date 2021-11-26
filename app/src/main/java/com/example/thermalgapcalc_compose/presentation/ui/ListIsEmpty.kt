package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thermalgapcalc_compose.R
import com.example.thermalgapcalc_compose.ui.theme.Typography


@Composable
fun ListEmpty(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Text(text = stringResource(R.string.listIsEmpty),style = Typography.h6)
    }
}
@Composable
@Preview(showBackground = true)
fun PreviewListEmpty() {
    ListEmpty(modifier = Modifier)
}