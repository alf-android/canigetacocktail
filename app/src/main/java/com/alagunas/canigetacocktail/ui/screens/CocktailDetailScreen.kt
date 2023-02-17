package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alagunas.canigetacocktail.R
import com.alagunas.canigetacocktail.ui.theme.CanIGetACocktailTheme
import com.alagunas.canigetacocktail.ui.items.CocktailImage
import com.alagunas.domain.model.Cocktail

@Composable
fun CocktailDetailCardScreen(cocktail: Cocktail) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.primary_color),
                        colorResource(id = R.color.secondary_color)
                    )
                )
            )
    ) {
        CocktailImage(
            image = cocktail.thumb ?: "",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = cocktail.name ?: "No name from arguments.",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = cocktail.description ?: "No description from arguments.",
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
                .padding(all = 5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CocktailDetailCardScreenPreview() {
    CanIGetACocktailTheme {
        CocktailDetailCardScreen(Cocktail("123"))
    }
}