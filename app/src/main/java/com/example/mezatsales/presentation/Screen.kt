package com.example.mezatsales.presentation

sealed class Screen(val route:String) {

    object LoginScreen: Screen("login_screen")
    object HomeScreen: Screen("home_screen")
    object SignUpScreen: Screen("signup_screen")

    object ProfilScreen : Screen("profil_screen")

    object ItemDetailScreen : Screen("detail_screen/{item}")

    object AddItemScreen : Screen("add_item")

    object MessageScreen : Screen("message_screen")
}