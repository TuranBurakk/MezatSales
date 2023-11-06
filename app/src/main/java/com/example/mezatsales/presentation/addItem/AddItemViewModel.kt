package com.example.mezatsales.presentation.addItem

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mezatsales.data.ItemData
import com.example.mezatsales.data.UserData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor():ViewModel() {

    private val user by lazy { FirebaseAuth.getInstance() }
    private val db by lazy { FirebaseFirestore.getInstance() }
    private val storage by lazy { FirebaseStorage.getInstance() }
    val uuid = UUID.randomUUID()
    fun addItem(
        item: ItemData
    ){
        item.imageUri?.let {
            storage.getReference("images/").child("images").child("${uuid}.jpeg").putFile(
                 Uri.parse(item.imageUri)
            ).addOnSuccessListener {
                storage.getReference("images/").child("images").child("${uuid}.jpeg").downloadUrl.addOnSuccessListener {
                    item.imageUri = it.toString()
                }
        }.addOnSuccessListener {
                db.collection("user").document(user.currentUser!!.uid).update("salesItem",FieldValue.arrayUnion(item))
                db.collection("user").document("items").update("salesItem",FieldValue.arrayUnion(item))
            }
    }
        }

    }