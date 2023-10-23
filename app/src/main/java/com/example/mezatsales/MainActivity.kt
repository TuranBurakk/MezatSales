package com.example.mezatsales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.mezatsales.navigation.NavigationGraph
import com.example.mezatsales.presentation.theme.MezatSalesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MezatSalesTheme(darkTheme = isSystemInDarkTheme()) {
                NavigationGraph()
            }

        }
    }
}


