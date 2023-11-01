package com.example.mezatsales.presentation.profile.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mezatsales.presentation.Screen
import com.example.mezatsales.presentation.home.views.ItemRow
import com.example.mezatsales.presentation.profile.ProfileScreenViewModel
import com.example.mezatsales.presentation.topBar.topBar

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel : ProfileScreenViewModel = hiltViewModel()
){
   val state = viewModel.itemState.value

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        topBar(navController = navController)
        Box(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(top = 10.dp),
            Alignment.Center
        ){
            Text(text = "my products"
                , color = MaterialTheme.colorScheme.onSurface)

        }
        LazyColumn(content = {
            items(state.item){item ->
                ItemRow(item = item , navController =navController )
            }
        })

        Text(text = "Sell", modifier = Modifier.clickable {
            navController.navigate(Screen.AddItemScreen.route)
        })
    }

}

