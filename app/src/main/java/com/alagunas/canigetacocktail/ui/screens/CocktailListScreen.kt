package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alagunas.canigetacocktail.ui.theme.CocktailsTopAppBar
import com.alagunas.canigetacocktail.viewmodels.CocktailListViewModel
import com.alagunas.data.fold
import com.alagunas.domain.model.Cocktail
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailListScreen(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModel: CocktailListViewModel = getViewModel()
) {

    val cocktailsFromRepo by viewModel.showCocktails.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { CocktailsTopAppBar("List of cocktails") }
    ) {

        cocktailsFromRepo.fold(
            ifLoading = { Text(text = "Loading...") },
            ifNoInternet = { Text(text = "Network error.") },
            onError = { Text(text = "Cocktails not found.") },
            onSuccess = {
                CocktailList(navController = navController, cocktails = it)
            }
        )
    }
}

@Composable
fun CocktailList(
    navController: NavController,
    cocktails: List<Cocktail>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(5.dp)
        ) {
            items(cocktails) { cocktail ->
                CocktailItem(cocktail) {
                    navController.navigate(route = "cocktaildetail/${cocktail.id}")
                }
            }
        }
    }
}

@Composable
fun CocktailItem(cocktail: Cocktail, onCocktailClicked: () -> Unit) {
    Text(text = cocktail.name, modifier = Modifier.clickable { onCocktailClicked() })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CocktailListScreenPreview() {
    CocktailItem(Cocktail(id = "1", name = "cocktail test", description = "No description"), {})
}