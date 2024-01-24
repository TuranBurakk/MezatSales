package com.example.mezatsales.presentation.message

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mezatsales.data.Message
import com.example.mezatsales.data.MessageState
import com.example.mezatsales.presentation.home.ItemState
import com.google.firebase.database.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor() : ViewModel() {

    private val _messages = mutableStateOf(MessageState())
    val messages: State<MessageState> = _messages
    private  val messageList = mutableListOf<Message>()
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference.child("messages")

    init {
        getMessage()
    }


    fun getMessage(){
        database.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val message = snapshot.child("message").getValue(Message::class.java)
                message?.let {
                    messageList.add(it)
                    _messages.value = MessageState(item = messageList)
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}
