package com.example.mycity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.MyCityDataProvider
import com.example.mycity.model.Category

enum class MyCityScreen {
    Home,
    PlaceList,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyCityScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = when (currentScreen) {
                    MyCityScreen.Home -> "Мой Город (Кемерово)"
                    MyCityScreen.PlaceList -> "Список мест"
                    MyCityScreen.Detail -> "Подробности"
                }
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Назад"
                    )
                }
            }
        }
    )
}

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Home.name
    )

    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        if (windowSize == WindowWidthSizeClass.Expanded) {
            Row(modifier = Modifier.padding(innerPadding)) {
                CategoryListScreen(
                    categories = Category.values().toList(),
                    onCategoryClick = { viewModel.updateCurrentCategory(it) },
                    modifier = Modifier.weight(1f)
                )
                PlaceListScreen(
                    places = MyCityDataProvider.allPlaces.filter { it.category == uiState.currentCategory },
                    onPlaceClick = { /* Для простоты на планшете оставляем так */ },
                    modifier = Modifier.weight(1f)
                )
            }
        } else {

            NavHost(
                navController = navController,
                startDestination = MyCityScreen.Home.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = MyCityScreen.Home.name) {
                    CategoryListScreen(
                        categories = Category.values().toList(),
                        onCategoryClick = {
                            viewModel.updateCurrentCategory(it)
                            navController.navigate(MyCityScreen.PlaceList.name)
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                composable(route = MyCityScreen.PlaceList.name) {
                    PlaceListScreen(
                        places = MyCityDataProvider.allPlaces.filter { it.category == uiState.currentCategory },
                        onPlaceClick = {
                            viewModel.updateSelectedPlace(it)
                            navController.navigate(MyCityScreen.Detail.name)
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                composable(route = MyCityScreen.Detail.name) {
                    uiState.selectedPlace?.let { place ->
                        PlaceDetailScreen(
                            place = place,
                            onBackPressed = { navController.navigateUp() },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}