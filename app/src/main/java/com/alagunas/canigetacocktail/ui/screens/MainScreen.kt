package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alagunas.canigetacocktail.ui.theme.CocktailsTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    Scaffold(scaffoldState = scaffoldState,
    topBar = { CocktailsTopAppBar(title = "What do you want?") }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 50.dp)
        ) {
            Button(onClick = { navController.navigate(route = "cocktaillist") }) {
                Text(text = "Check Cocktails")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Manage my Cocktails")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "My Minibar")
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

