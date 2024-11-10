package com.example.e_commerce.ui.theme.auth.signin

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class SignInData(
    val email: String,
    val password: String
)

class SignInViewModel: ViewModel() {
    private val _signInData = MutableLiveData<SignInData>()
    val signInData: LiveData<SignInData> = _signInData

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    fun onLoginChanged(email: String, password: String) {
        _signInData.value = SignInData(email, password)
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length > 6

    fun onLoginSelected(){
        val email = _signInData.value?.email ?: ""
        val password = _signInData.value?.password ?: ""
    }
}