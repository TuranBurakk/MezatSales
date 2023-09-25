package com.example.mezatsales.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mezatsales.ui.Screen
import com.example.mezatsales.ui.home.views.HomeScreen
import com.example.mezatsales.ui.login.views.LoginScreen
import com.example.mezatsales.ui.signup.SignUpScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController)

        }
        composable(route = Screen.SignUpScreen.route) {
            SignUpScreen(navController)

        }
        composable(route= Screen.HomeScreen.route){
            HomeScreen()
        }
    }

}