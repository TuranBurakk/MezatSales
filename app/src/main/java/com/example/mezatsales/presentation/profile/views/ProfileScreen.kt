package com.example.mezatsales.presentation.profile.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.mezatsales.presentation.topBar.topBar

@Composable
fun ProfileScreen(
    navController: NavController
){
    Column(
        Modifier.fillMaxSize()
            .background(Color.DarkGray)
    ){
        topBar(navController = navController)


    }

}