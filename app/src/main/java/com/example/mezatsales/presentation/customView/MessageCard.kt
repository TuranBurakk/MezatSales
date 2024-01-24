package com.example.mezatsales.presentation.customView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageCard(userName:String,message:String?){
    Card(
        Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(MaterialTheme.colorScheme.background)) {
            Text(text = userName,
                 modifier = Modifier.padding(start = 5.dp),
                 fontWeight = FontWeight.Bold,
                 color = MaterialTheme.colorScheme.onSurface
            )
        if (message != null) {
            Text(text = message,
                modifier = Modifier.padding(start = 5.dp))
        }
    }
}


