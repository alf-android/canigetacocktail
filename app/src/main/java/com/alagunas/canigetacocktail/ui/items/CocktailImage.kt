package com.alagunas.canigetacocktail.ui.items

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import imageShape

@Composable
fun CocktailImage(image: String, modifier: Modifier) {
    Card(
        shape = imageShape,
        modifier = modifier
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(imageShape)
                .border(width = 1.dp, color = Color.Black, shape = imageShape)
        )
    }
}