package com.example.mezatsales.presentation.home.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mezatsales.data.ItemData
import com.example.mezatsales.presentation.customView.ExpandableCard


@Composable
fun ItemRow(
    item : ItemData,
    navController: NavController
){

    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 10.dp)){
        Box(
            Modifier.padding(start = 5.dp)
        ) {
            ExpandableCard(navController,time = item.time.toString(),item.price.toString(),title = item.name.toString(),
                description =item.description.toString())

        }
        }
}

