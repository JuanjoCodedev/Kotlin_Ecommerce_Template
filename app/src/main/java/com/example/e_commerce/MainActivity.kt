package com.example.e_commerce

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.Component.CardMinimalComponent
import com.example.e_commerce.models.Routes
import com.example.e_commerce.screens.ForgotPassScreen
import com.example.e_commerce.ui.theme.auth.signin.SignInScreen
import com.example.e_commerce.screens.SignUpScreen
import com.example.e_commerce.ui.theme.EcommerceTheme
import com.example.e_commerce.ui.theme.auth.signin.SignInViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceTheme {
                Scaffold {
                   val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.SignInScreen.route){
                        composable(Routes.SignInScreen.route){ SignInScreen(navigationController, SignInViewModel()) }
                        composable(Routes.SignUpScreen.route){ SignUpScreen(navigationController) }
                        composable(Routes.ForgotPassScreen.route){ ForgotPassScreen(navigationController)}
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_7)
@Composable
fun GreetingPreview() {
    EcommerceTheme {
        CardMinimalComponent()
    }
}