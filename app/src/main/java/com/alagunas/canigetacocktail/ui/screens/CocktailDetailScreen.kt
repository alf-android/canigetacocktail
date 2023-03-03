package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alagunas.canigetacocktail.R
import com.alagunas.canigetacocktail.ui.theme.CanIGetACocktailTheme
import com.alagunas.canigetacocktail.ui.items.CocktailImage
import com.alagunas.domain.model.Cocktail
import com.alagunas.domain.model.bestInstruction
import com.alagunas.domain.model.bestName
import com.alagunas.domain.model.ingredientsWithMeasure

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
                .padding(top = 30.dp),
            size = 200.dp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = cocktail.bestName()?: stringResource(R.string.no_name),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = cocktail.bestInstruction(),
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
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.ingredients),
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        ) {
            items(cocktail.ingredientsWithMeasure()) { ingredient ->
                Text(text = ingredient, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CocktailDetailCardScreenPreview() {
    CanIGetACocktailTheme {
        CocktailDetailCardScreen(Cocktail("123"))
    }
}