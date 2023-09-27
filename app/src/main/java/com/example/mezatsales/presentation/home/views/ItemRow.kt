package com.example.mezatsales.presentation.home.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mezatsales.presentation.customView.ExpandableCard


@Composable
fun ItemRow(){

    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 10.dp)){
        Box(
            Modifier.padding(start = 5.dp)
        ) {
            ExpandableCard(lastPrice = "100",title = "test", description ="deneme" )

        }
        Box(
            Modifier.padding(start = 5.dp)
        ) {
            ExpandableCard(lastPrice = "100",title = "test", description ="deneme" )

        }    }
}

@Preview
@Composable
fun PreviewItemRow(){
    ItemRow()
}