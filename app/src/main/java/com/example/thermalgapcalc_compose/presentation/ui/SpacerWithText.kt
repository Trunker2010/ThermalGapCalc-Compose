package com.example.thermalgapcalc_compose.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thermalgapcalc_compose.presentation.ui.SpacerWithText.CircleText

object SpacerWithText {

    @Composable
    fun CircleText(
        modifier: Modifier = Modifier,
        text: String,
        background: Color = Color.Black
    ) {
        Box(contentAlignment = Alignment.Center,
            modifier = modifier
                .background(background, shape = CircleShape)
                .shadow(elevation = 4.dp, shape = CircleShape)
                .border(4.dp, Color.Gray, shape = CircleShape)
                .layout() { measurable, constraints ->
                    // Measure the composable
                    val placeable = measurable.measure(constraints)

                    //get the current max dimension to assign width=height
                    val currentHeight = placeable.height
                    var heightCircle = currentHeight
                    if (placeable.width > heightCircle)
                        heightCircle = placeable.width

                    //assign the dimension and the center position
                    layout(heightCircle, heightCircle) {
                        // Where the composable gets placed
                        placeable.placeRelative(0, (heightCircle - currentHeight) / 2)
                    }
                }
        ) {

            Text(
                text = text,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .padding(4.dp)
                    .defaultMinSize(48.dp) //Use a min size for short text.
            )
        }
    }
}

@Preview
@Composable
fun SpacerWithTextPrev() {
    CircleText(text = "asd")
}