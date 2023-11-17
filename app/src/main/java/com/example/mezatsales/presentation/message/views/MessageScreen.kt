package com.example.mezatsales.presentation.message.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.mezatsales.presentation.topBar.topBar

@Composable
fun MessageScreen(
    navController: NavController
){
    Column {
        topBar(navController = navController)
        LazyColumn(){

        }
    }

}