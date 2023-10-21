package com.example.mezatsales.presentation.topBar

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ColorScheme
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mezatsales.presentation.Screen
import com.example.mezatsales.presentation.theme.AccentColor
import com.example.mezatsales.presentation.theme.Background
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun topBar(
    navController: NavController
){
    var showMenu by remember { mutableStateOf(false) }
    val auth by lazy { Firebase.auth }

    Box(Modifier.fillMaxWidth()) {
        IconButton(onClick = { navController.navigate(Screen.ProfilScreen.route) }) {
            Icon(imageVector = Icons.Filled.Person,
                contentDescription = "Profile",
                tint = AccentColor
            )
        }


        IconButton(onClick = { showMenu = true},
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)) {
            Icon(imageVector = Icons.Filled.Menu,contentDescription = "Menu",
                modifier = Modifier.align(Alignment.CenterEnd),
                tint = AccentColor)
        }
        Box(modifier = Modifier.align(Alignment.BottomEnd)
        ){
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                modifier = Modifier
                    .background(Background)

            ) {
                DropdownMenuItem(text = { Text(text = "Anasayfa", color = Color.White) }
                    , onClick = { navController.navigate(Screen.HomeScreen.route) })
                DropdownMenuItem(
                    text = {
                        Text("Mağazam", color = Color.White)
                    },
                    onClick = {  },
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
        color = AccentColor,
        modifier = Modifier.fillMaxWidth()
    )
}