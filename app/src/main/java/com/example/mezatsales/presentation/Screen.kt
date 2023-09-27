package com.example.mezatsales.presentation

sealed class Screen(val route:String) {

    object LoginScreen: Screen("login_screen")
    object HomeScreen: Screen("home_screen")
    object SignUpScreen: Screen("signup_screen")
}