package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alagunas.canigetacocktail.ui.activities.ui.theme.CanIGetACocktailTheme

@Composable
fun CocktailListScreen(navController: NavHostController = rememberNavController()) {
    CanIGetACocktailTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        ) {
            val id1 = 1
            Button(onClick = { navController.navigate(route = "cocktaildetail/$id1") }) {
                Text(text = "cocktail 1")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "cocktail 2")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "cocktail 3")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "cocktail 4")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "cocktail 5")
            }
            Spacer(modifier = Modifier.height(5.dp))
            val id6 = 6
            Button(onClick = { navController.navigate(route = "cocktaildetail/$id6") }) {
                Text(text = "cocktail 6")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CocktailListScreenPreview() {
    CocktailListScreen()
}