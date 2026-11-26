package com.example.zd5_moskvina.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.zd5_moskvina.ui.screens.DetailScreen
import com.example.zd5_moskvina.ui.screens.ListScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        // Главный экран
        composable("list") {
            ListScreen(
                navController = navController,
                isDarkTheme = isDarkTheme,
                onThemeToggle = onThemeToggle
            )
        }

        // Экран деталей (передаем ID как аргумент)
        composable(
            route = "detail/{specialtyId}",
            arguments = listOf(navArgument("specialtyId") { type = NavType.IntType })
        ) { backStackEntry ->
            val specialtyId = backStackEntry.arguments?.getInt("specialtyId") ?: 0
            DetailScreen(
                specialtyId = specialtyId,
                navController = navController
            )
        }
    }
}