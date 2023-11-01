package com.example.mezatsales.presentation.addItem.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.mezatsales.R
import com.example.mezatsales.presentation.topBar.topBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(navController: NavController){

    var name by rememberSaveable { mutableStateOf("") }
    var desc by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        topBar(navController = navController)

        Spacer(modifier = Modifier.padding(top = 50.dp))

        ItemImage()

        TextField(modifier = Modifier.padding(top = 10.dp).align(CenterHorizontally),
            value = name,
            onValueChange = {name = it},
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                textColor = MaterialTheme.colorScheme.onSurface
            ),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Enter Name",
                    color = MaterialTheme.colorScheme.onSurface
                )
            })

        TextField(modifier = Modifier.padding(top = 10.dp).align(CenterHorizontally),
            value = desc,
            onValueChange = {desc = it},
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                textColor = MaterialTheme.colorScheme.onSurface
            ),
            placeholder = {
                Text(
                    text = "Enter Description",
                    color = MaterialTheme.colorScheme.onSurface
                )
            })

        TextField(modifier = Modifier.padding(top = 10.dp).align(CenterHorizontally),
            value = address,
            onValueChange = {address = it},
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                textColor = MaterialTheme.colorScheme.onSurface
            ),
            placeholder = {
                Text(
                    text = "Enter Address",
                    color = MaterialTheme.colorScheme.onSurface
                )
            })




        Row(modifier = Modifier
            .align(CenterHorizontally)
            .padding(top = 20.dp)) {
            Button(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.width(100.dp)) {
                Text(text = "Sell", color = MaterialTheme.colorScheme.onSurface)
            }
        }

    }
}

@Composable
fun ItemImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.tesbih
        else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri.value = it.toString() }
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
        Text(text = "Change Item picture", color = MaterialTheme.colorScheme.onSurface)

    }
}



@Preview
@Composable
fun PreAddItemScreen(){
    val navController = rememberNavController()
MaterialTheme {
    AddItemScreen(navController)
}

}