package com.example.mezatsales.presentation.itemDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mezatsales.R
import com.example.mezatsales.data.ItemData
import com.example.mezatsales.presentation.topBar.topBar


@Composable
fun itemDetailScreen(navController: NavController,item:ItemData){
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        topBar(navController = navController)
        Image(painter = painterResource(id = R.drawable.tesbih)
            ,contentDescription ="item"
            , modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp)

        )
        Text(text = "${item.name}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 30.dp))
        Text(text ="CATEGORY",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))
        Text(text = "${item.category}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))
        Text(text = "DESCRIPTION",
             color = MaterialTheme.colorScheme.onSurface,
             modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))
        Text(text = "${item.description}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))
        Text(text = "PRİCE : ${item.price}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))
        Text(text = "ADDRESS : ${item.Address}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))
    }
}


