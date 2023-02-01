package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alagunas.canigetacocktail.ui.activities.ui.theme.CanIGetACocktailTheme

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
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


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

