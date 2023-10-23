package com.example.mezatsales.presentation.home

import com.example.mezatsales.data.ItemData

data class ItemState(
    val isLoading : Boolean = false,
    val item : List<ItemData> = emptyList()
)
