package com.example.mezatsales.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mezatsales.data.ItemData
import com.example.mezatsales.data.UserData
import com.example.mezatsales.presentation.home.ItemState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor():ViewModel() {

    private val _itemState = mutableStateOf(ItemState())
    val itemState : State<ItemState> = _itemState

    private val user by lazy { FirebaseAuth.getInstance() }
    private val db by lazy { FirebaseFirestore.getInstance() }
    private val itemList = mutableListOf<ItemData>()

    init {
        getItem()
    }

    private fun getItem(){
        db.collection("user").document(user.currentUser!!.uid).get()
            .addOnSuccessListener {documentSnapshot ->
                val saleItems = documentSnapshot.toObject<UserData>()
                if (saleItems != null) {
                    itemList.clear()
                    for (item in saleItems!!.salesItem) {
                        val name = item.name
                        val description = item.description
                        val category = item.category
                        val price = item.price
                        val time = item.Address
                        val item = ItemData(time,price, category, name, description)
                        itemList.add(item)
                    }
                    _itemState.value = ItemState(item = itemList)
                }

            }
    }
}