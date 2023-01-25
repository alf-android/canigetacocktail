package com.alagunas.canigetacocktail.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class CocktailDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanIGetACocktailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CocktailDetailCardWithImage("")
                }
            }
        }
    }
}

@Composable
fun CocktailDetailCardWithText(name: String, description: String) {
    Column {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            color = colorResource(R.color.purple_200),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp
                )
                .background(color = Color.Blue)
                .padding(all = 5.dp)
        )
    }
}

@Composable
fun CocktailDetailCardWithImage(imageFromAPI: String) {
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
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        CocktailDetailCardWithText(
            stringResource(R.string.sex_on_the_beach),
            "Es un cocktail con ron y algunos zumos. Pueden ser zumo de piña y zumo de melocotón, pero si lo pruebas a añadir el blue, estará riquísimo."
        )
    }
}

//@Preview(showBackground = true, name = "Cocktail Card Preview")
//@Composable
//fun CocktailDetailCardWithTextPreview(){
//    CanIGetACocktailTheme {
//        CocktailDetailCardWithText("sex on the beach", "Es un cocktail con ron.")
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    CanIGetACocktailTheme {
//
//    }
//}

@Preview(showBackground = true)
@Composable
fun CocktailDetailCardWithImagePreview() {
    CanIGetACocktailTheme {
        CocktailDetailCardWithImage("")
    }
}