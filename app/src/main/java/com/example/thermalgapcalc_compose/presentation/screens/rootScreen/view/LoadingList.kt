package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.R

@Composable
fun LoadingList(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(modifier = Modifier.padding(all= 8.dp), text = stringResource(id = R.string.loading))
        CircularProgressIndicator(modifier = Modifier.padding(all = 4.dp))
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLoadingList() {
    LoadingList(modifier = Modifier)
}