package com.alagunas.canigetacocktail.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alagunas.canigetacocktail.R
import com.alagunas.canigetacocktail.ui.items.CocktailImage
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
//        topBar = { CocktailsTopAppBar("List of cocktails") }
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

            Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp)) {
                Abecedari(viewModel)
                Spacer(modifier = Modifier.padding(20.dp))

                cocktailsFromRepo.fold(
                    ifLoading = {
                        Text(
                            text = "Loading...",
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .wrapContentWidth(align = Alignment.CenterHorizontally)
                                .wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    },
                    ifNoInternet = { Text(text = "Network error.") },
                    onError = { Text(text = "Cocktails not found.") },
                    onSuccess = {
                        CocktailList(navController = navController, cocktails = it)
                    }
                )
            }

        }

    }
}

@Composable
fun Abecedari(viewModel: CocktailListViewModel) {
    Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
        Text(text = "A", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("A") })
        Text(text = "B", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("B") })
        Text(text = "C", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("C") })
        Text(text = "D", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("D") })
        Text(text = "E", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("E") })
        Text(text = "F", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("F") })
        Text(text = "G", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("G") })
        Text(text = "H", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("H") })
        Text(text = "I", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("I") })
        Text(text = "J", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("J") })
        Text(text = "K", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("K") })
        Text(text = "L", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("L") })
        Text(text = "M", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("M") })
        Text(text = "N", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("N") })
        Text(text = "O", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("O") })
        Text(text = "P", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("P") })
        Text(text = "Q", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("Q") })
        Text(text = "R", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("R") })
        Text(text = "S", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("S") })
        Text(text = "T", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("T") })
        Text(text = "U", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("U") })
        Text(text = "V", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("V") })
        Text(text = "W", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("W") })
        Text(text = "X", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("X") })
        Text(text = "Y", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("Y") })
        Text(text = "Z", modifier = Modifier.clickable { viewModel.getCocktailsByFirstLetter("Z") })
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
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(5.dp)
        ) {
            items(cocktails) { cocktail ->
                CocktailItem(cocktail) {
                    navController.navigate(route = "cocktaildetail/$cocktail")
                }
            }
        }
    }
}

@Composable
fun CocktailItem(cocktail: Cocktail, onCocktailClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clickable { onCocktailClicked() }
    ) {
        CocktailImage(
            image = cocktail.thumb ?: "",
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = cocktail.name ?: "No name"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CocktailListScreenPreview() {
    CocktailItem(Cocktail(id = "1", name = "cocktail test", description = "No description"), {})
}