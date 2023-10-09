package com.example.mezatsales.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.mezatsales.data.AuthRepository
import com.example.mezatsales.data.UserData
import com.example.mezatsales.presentation.Screen
import com.example.mezatsales.utils.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val auth by lazy { Firebase.auth }
    val user = auth.currentUser
    val db by lazy { FirebaseFirestore.getInstance() }

    val _signInState = Channel<SignInState>()
    val signInState = _signInState.receiveAsFlow()

    val _googleState = mutableStateOf(GoogleSignInState())
    val googleState: State<GoogleSignInState> = _googleState

    fun googleSignIn(credential: AuthCredential) = viewModelScope.launch {
        repository.googleSignIn(credential).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _googleState.value = GoogleSignInState(success = result.data)
                    db.collection("user").document(auth.currentUser!!.uid).set(UserData()).addOnCompleteListener {task ->
                    }.addOnFailureListener {exception->

                    }
                }

                is Resource.Loading -> {
                    _googleState.value = GoogleSignInState(loading = true)
                }

                is Resource.Error -> {
                    _googleState.value = GoogleSignInState(error = result.message!!)
                }

                else -> {}
            }


        }
    }

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _signInState.send(SignInState(isSuccess = "Sign In Success "))
                    db.collection("user").document(auth.currentUser!!.uid).set(UserData()).addOnCompleteListener {task ->
                    }.addOnFailureListener {exception->

                    }
                }
                is Resource.Loading -> {
                    _signInState.send(SignInState(isLoading = true))
                }
                is Resource.Error -> {

                    _signInState.send(SignInState(isError = result.message))
                }
            }

        }
    }

    fun checkUser(navController:NavController){
        //for autologin
        if (user != null){
            navController.navigate(Screen.HomeScreen.route)
        }
    }
}
