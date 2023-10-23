package com.example.mezatsales.presentation.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mezatsales.presentation.home.HomeViewModel
import com.example.mezatsales.presentation.topBar.topBar

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
){


    val state = viewModel.itemState.value


    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 10.dp)
        ,
    ) {

        topBar(navController)

        Box(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(top = 10.dp),
            Alignment.Center
        ){
            Text(text = "categories"
                , color = MaterialTheme.colorScheme.onSurface)

        }

        LazyRow(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 10.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            val list = listOf("all","vehicle","electronic","furniture")
            items(list, itemContent = {item->
                when(item){
                    "vehicle"->{
                        Button(onClick = {
                            viewModel.filterCategory(item)
                        },
                            modifier = Modifier.padding(start = 5.dp),
                            shape = RoundedCornerShape(15.dp),
                            ) {
                            Text(text = item, color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                    "electronic"->{
                        Button(onClick = {
                            viewModel.filterCategory(item)
                        },
                            modifier = Modifier.padding(start = 5.dp),
                            shape = RoundedCornerShape(15.dp)) {
                            Text(text = item, color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                    "furniture"->{
                        Button(onClick = {
                            viewModel.filterCategory(item)
                        },
                            modifier = Modifier.padding(start = 5.dp),
                            shape = RoundedCornerShape(15.dp)) {
                            Text(text = item, color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                    "all"->{
                        Button(onClick = {
                            viewModel.filterCategory(item)
                        },
                            modifier = Modifier.padding(start = 5.dp),
                            shape = RoundedCornerShape(15.dp)) {
                            Text(text = item, color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                }

            })
        }
        LazyColumn(content = {
            items(state.item){item ->
                ItemRow(item = item,
                    navController)
            }
        })

    }

}
