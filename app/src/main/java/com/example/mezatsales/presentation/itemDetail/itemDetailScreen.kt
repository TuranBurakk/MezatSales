package com.example.mezatsales.presentation.itemDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.mezatsales.presentation.topBar.topBar


@Composable
fun itemDetailScreen(navController: NavController){
    Column {
        topBar(navController = navController)
    }
}