package com.alagunas.canigetacocktail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alagunas.canigetacocktail.ui.theme.CanIGetACocktailTheme
import com.alagunas.canigetacocktail.ui.navigation.CocktailArgType
import com.alagunas.canigetacocktail.ui.screens.CocktailDetailCardScreen
import com.alagunas.canigetacocktail.ui.screens.CocktailListScreen
import com.alagunas.canigetacocktail.ui.screens.MainScreen
import com.alagunas.domain.model.Cocktail
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanIGetACocktailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    colorResource(id = R.color.primary_color),
                                    colorResource(id = R.color.secondary_color)
                                )
                            )
                        ),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController: NavHostController = rememberNavController()
                    CocktailNavHost(navController = navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable(route = "main") {
            MainScreen(navController)
        }
        composable(route = "cocktaillist") {
            CocktailListScreen(navController)
        }
        composable(
            route = "cocktaildetail/{cocktail}",
            arguments = listOf(
                navArgument("cocktail") { type = CocktailArgType() }
            )
        ) { navBackStackEntry ->
            val cocktail = navBackStackEntry.arguments?.getString("cocktail")
                ?.let { Gson().fromJson(it, Cocktail::class.java) }
//            val id = navBackStackEntry.arguments?.getInt("cocktailId")
            requireNotNull(cocktail) { "Cocktail entity cannot be null." }
            CocktailDetailCardScreen(cocktail)
        }
    }
}