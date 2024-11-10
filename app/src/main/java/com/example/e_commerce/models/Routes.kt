package com.example.e_commerce.models

sealed class Routes(val route: String) {
    object SignInScreen:Routes("signInScreen")
    object SignUpScreen:Routes("signUpScreen")
    object ForgotPassScreen:Routes("forgotPassScreen")
}