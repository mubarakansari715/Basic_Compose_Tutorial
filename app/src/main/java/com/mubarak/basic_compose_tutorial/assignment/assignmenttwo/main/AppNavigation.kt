package com.mubarak.basic_compose_tutorial.assignment.assignmenttwo.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mubarak.basic_compose_tutorial.assignment.assignmenttwo.screen.LoginScreen
import com.mubarak.basic_compose_tutorial.assignment.assignmenttwo.screen.MainScreen
import com.mubarak.basic_compose_tutorial.assignment.assignmenttwo.screen.RegisterScreen

/***
 * This handling the navigation of the screens
 * We need to add navigation dependencies in gradle
 */
@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable(route = "login") {
            LoginScreen() {
                navController.navigate("main/$it")
            }
        }

        composable(route = "main/{username}", arguments = listOf(
            navArgument("username") {
                type = NavType.StringType
            }
        )) {
            MainScreen("${it.arguments?.getString("username")}") {
                navController.navigate("register")
            }
        }

        composable(route = "register") {
            RegisterScreen() {
                navController.popBackStack(route = "login", inclusive = false)
            }
        }
    }
}