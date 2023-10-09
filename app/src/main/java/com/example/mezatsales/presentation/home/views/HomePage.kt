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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mezatsales.presentation.Screen
import com.example.mezatsales.presentation.home.HomeViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
){
    var showMenu by remember { mutableStateOf(false) }
    val auth by lazy { Firebase.auth }
    val state = viewModel.itemState.value


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(top = 10.dp)
        ,
    ) {

        Box(Modifier.fillMaxWidth()) {
            IconButton(onClick = { navController.navigate(Screen.ProfilScreen.route) }) {
                Icon(imageVector = Icons.Filled.Person,
                     contentDescription = "Profile")
            }


            IconButton(onClick = { showMenu = true},
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 10.dp)) {
                Icon(imageVector = Icons.Filled.Menu,contentDescription = "Menu",
                    modifier = Modifier.align(Alignment.CenterEnd))
            }
            Box(modifier = Modifier.align(Alignment.BottomEnd)
                ){
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    modifier = Modifier
                        .background(Color.DarkGray)

                ) {
                    DropdownMenuItem(
                        text = {
                            Text("Mağazam", color = Color.White)
                        },
                        onClick = { /* TODO */ },
                    )
                    DropdownMenuItem(
                        text = {
                            Text("Profil", color = Color.White)
                        },
                        onClick = { navController.navigate(Screen.ProfilScreen.route) },
                    )
                    DropdownMenuItem(
                        text = {
                            Text("Çıkış yap", color = Color.White)
                        },
                        onClick = {auth.signOut()
                                   navController.navigate(Screen.LoginScreen.route)},
                    )
                }
            }

        }
        Divider(
            color = Color.Blue,
            modifier = Modifier.fillMaxWidth()
        )

        Box(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(top = 10.dp),
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
                            viewModel.filterCategory(item)
                        },
                            shape = RoundedCornerShape(15.dp),
                            ) {
                            Text(text = item)
                        }
                    }
                    "Retro"->{
                        Button(onClick = {
                            viewModel.filterCategory(item)
                        },
                            modifier = Modifier.padding(start = 5.dp),
                            shape = RoundedCornerShape(15.dp)) {
                            Text(text = item)
                        }
                    }
                    "Sanat"->{
                        Button(onClick = {
                            viewModel.filterCategory(item)
                        },
                            modifier = Modifier.padding(start = 5.dp),
                            shape = RoundedCornerShape(15.dp)) {
                            Text(text = item)
                        }
                    }
                    "Antika"->{
                        Button(onClick = {
                            viewModel.filterCategory(item)
                        },
                            modifier = Modifier.padding(start = 5.dp),
                            shape = RoundedCornerShape(15.dp)) {
                            Text(text = item)
                        }
                    }
                }

            })
        }
        LazyColumn(content = {
            items(state.item){item ->
                ItemRow(item = item,
                    onItemClick = {

                    })
            }
        })

    }

}
