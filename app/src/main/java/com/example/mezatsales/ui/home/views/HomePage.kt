package com.example.mezatsales.ui.home.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(){

    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(top = 10.dp, start = 10.dp)
        ,
    ) {

        Box(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth(),
            Alignment.Center
        ){
            Text(text = "Katagoriler"
                , color = Color.White)

        }

        LazyRow(modifier = Modifier
            .background(Color.DarkGray)
            .padding(start = 10.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            val list = listOf("Tesbih","Retro","Sanat","Antika")
            items(list, itemContent = {item->
                when(item){
                    "Tesbih"->{
                        Button(onClick = {
                            Toast.makeText(context,item, Toast.LENGTH_LONG).show()
                        }) {
                            Text(text = item)
                        }
                    }
                    "Retro"->{
                        Button(onClick = {
                            Toast.makeText(context,item, Toast.LENGTH_LONG).show()
                        }) {
                            Text(text = item)
                        }
                    }
                    "Sanat"->{
                        Button(onClick = {
                            Toast.makeText(context,item, Toast.LENGTH_LONG).show()
                        }) {
                            Text(text = item)
                        }
                    }
                    "Antika"->{
                        Button(onClick = {
                            Toast.makeText(context,item, Toast.LENGTH_LONG).show()
                        }) {
                            Text(text = item)
                        }
                    }
                }

            })
        }

    }

}

@Preview
@Composable
fun previewLoginScreen(){
    HomeScreen()
}