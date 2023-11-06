package com.example.mezatsales.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mezatsales.data.ItemData
import com.example.mezatsales.data.UserData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject constructor():ViewModel() {

    private val _itemState = mutableStateOf(ItemState())
    val itemState : State<ItemState> = _itemState

    private val db by lazy { FirebaseFirestore.getInstance() }
    private val itemList = mutableListOf<ItemData>()

    init {
        getItem()
    }

    private fun getItem(){
        db.collection("user").document("items").get()
            .addOnSuccessListener {documentSnapshot ->
                val saleItems = documentSnapshot.toObject<UserData>()
                if (saleItems != null) {
                    itemList.clear()
                    for (item in saleItems?.salesItem ?: emptyList()) {
                        val name = item?.name
                        val description = item?.description
                        val category = item?.category
                        val price = item?.price
                        val time = item?.Address
                        val uri = item?.imageUri
                        val item = ItemData(time,price, category, name, description,uri)
                        itemList.add(item)
                    }
                    _itemState.value = ItemState(item = itemList)
                }

            }
    }
    fun filterCategory(category : String){
    if (category == "todo"){
        getItem()
    }else{
        _itemState.value = ItemState(item = itemList.filter { it.category == category })
    }
    }
}