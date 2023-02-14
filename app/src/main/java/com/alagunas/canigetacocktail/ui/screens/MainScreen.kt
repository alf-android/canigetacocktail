package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import buttonShape
import com.alagunas.canigetacocktail.R
import com.alagunas.canigetacocktail.ui.theme.CocktailsTopAppBar
import com.alagunas.canigetacocktail.ui.theme.MyYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {

    Scaffold(
        scaffoldState = scaffoldState,
//        topBar = { CocktailsTopAppBar(title = "What do you want?") }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.primary_color),
                            colorResource(id = R.color.secondary_color)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(top = 50.dp)
            ) {
                Button(
                    onClick = { navController.navigate(route = "cocktaillist") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = buttonShape
                ) {
                    Text(text = "Check Cocktails")
                }
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = buttonShape) {
                    Text(text = "Manage my Cocktails")
                }
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = buttonShape) {
                    Text(text = "My Minibar")
                }
            }
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

