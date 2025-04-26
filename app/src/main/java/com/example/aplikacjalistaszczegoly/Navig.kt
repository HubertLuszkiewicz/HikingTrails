package com.example.aplikacjalistaszczegoly

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navig(
    navController: NavHostController,
    viewModel: TimerExampleViewModel,
    darkThemeViewModel: DarkThemeViewModel){
    val isDark by darkThemeViewModel.isDark.observeAsState(false)
    NavHost(
        navController = navController,
        startDestination = "splash"
    ){
        composable("splash") {
            SplashScreen(navController)
        }
        composable(route = "main"){
            Main(
                navController,
                viewModel,
                darkThemeViewModel
            )
        }
        composable(
            route = "Details/{trailId}",
            arguments = listOf(
                navArgument(name = "trailId") {
                    type = NavType.IntType
                }
            )
        ){backstackEntry ->
            DetailsScreen(
                trailId = backstackEntry.arguments?.getInt("trailId"),
                viewModel = viewModel,
                navController = navController,
                darkThemeViewModel = darkThemeViewModel
            )
        }
    }
}