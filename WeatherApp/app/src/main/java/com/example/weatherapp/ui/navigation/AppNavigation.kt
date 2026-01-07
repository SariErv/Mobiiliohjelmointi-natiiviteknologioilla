package com.example.weatherapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.InfoScreen
import com.example.weatherapp.ui.screens.MainScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = "MainScreen"

    ) {
        composable(route = "MainScreen") {
            MainScreen(navController, modifier)
        }
        composable(route = "InfoScreen") {
            InfoScreen(navController,modifier)
        }
    }
}