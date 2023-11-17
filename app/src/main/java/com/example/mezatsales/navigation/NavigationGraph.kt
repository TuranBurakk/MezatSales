package com.example.mezatsales.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mezatsales.data.ItemData
import com.example.mezatsales.presentation.Screen
import com.example.mezatsales.presentation.addItem.view.AddItemScreen
import com.example.mezatsales.presentation.home.views.HomeScreen
import com.example.mezatsales.presentation.itemDetail.itemDetailScreen
import com.example.mezatsales.presentation.login.views.LoginScreen
import com.example.mezatsales.presentation.message.views.MessageScreen
import com.example.mezatsales.presentation.profile.views.ProfileScreen
import com.example.mezatsales.presentation.signup.SignUpScreen

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
            HomeScreen(navController)
        }

        composable(route = Screen.ProfilScreen.route){
            ProfileScreen(navController)
        }

        composable(route = Screen.ItemDetailScreen.route){
           val result = navController.previousBackStackEntry?.savedStateHandle?.get<ItemData>("item")

            if (result != null) {
                itemDetailScreen(navController,result)
            }
        }
        composable(route = Screen.AddItemScreen.route){
            AddItemScreen(navController = navController)
        }
        composable(route = Screen.MessageScreen.route){
            MessageScreen(navController = navController)
        }
    }

}