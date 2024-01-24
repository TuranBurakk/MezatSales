package com.example.mezatsales.presentation.message.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mezatsales.presentation.customView.MessageCard
import com.example.mezatsales.presentation.message.MessageViewModel
import com.example.mezatsales.presentation.topBar.topBar

@Composable
fun MessageScreen(
    navController: NavController,
    viewModel: MessageViewModel = hiltViewModel()
){
    val state = viewModel.messages.value

    Column (
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()

    ){
        topBar(navController = navController)
        LazyColumn(Modifier.padding(5.dp)){
            items(state.item){
                it.userName?.let { it1 -> MessageCard(userName = it1,it.text) }
            }
        }
    }

}

@Composable
@Preview
fun prevMessageScreen(){
    MessageScreen(rememberNavController())
}