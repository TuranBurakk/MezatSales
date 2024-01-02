package com.example.mezatsales.presentation.message.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mezatsales.presentation.customView.MessageCard
import com.example.mezatsales.presentation.topBar.topBar

@Composable
fun MessageScreen(
    navController: NavController
){
    Column (
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()

    ){
        topBar(navController = navController)
        LazyColumn(Modifier.padding(5.dp)){
            item {
                MessageCard()
            }
        }
    }

}

@Composable
@Preview
fun prevMessageScreen(){
    MessageScreen(rememberNavController())
}