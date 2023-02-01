package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alagunas.canigetacocktail.R
import com.alagunas.canigetacocktail.ui.activities.ui.theme.CanIGetACocktailTheme
import imageShape

@Composable
fun CocktailDetailCardWithText(name: String, description: String) {
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            color = colorResource(R.color.purple_200),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
                .background(color = Color.Blue)
                .padding(all = 5.dp)
        )
    }
}

@Composable
fun CocktailDetailCardScreen(imageFromAPI: String, cocktailId: Int) {
    val image = painterResource(R.drawable.sex_on_the_beach)
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 12.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .align(alignment = Alignment.CenterHorizontally)
//                .fillMaxWidth()
//                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .clip(imageShape)
                .border(width = 5.dp, color = Color.Black, shape = imageShape)
        )
        CocktailDetailCardWithText(
            stringResource(R.string.sex_on_the_beach),
            "Es un cocktail con ron y algunos zumos. Pueden ser zumo de piña y zumo de melocotón, pero si lo pruebas a añadir el blue, estará riquísimo."
        )
        Text(text = "id: $cocktailId")
    }
}

@Preview(showBackground = true)
@Composable
fun CocktailDetailCardScreenPreview() {
    CanIGetACocktailTheme {
        CocktailDetailCardScreen("", 4)
    }
}