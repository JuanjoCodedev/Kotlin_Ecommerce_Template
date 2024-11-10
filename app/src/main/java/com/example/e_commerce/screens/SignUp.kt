package com.example.e_commerce.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.e_commerce.R
import com.example.e_commerce.models.Routes
import com.example.mynewcompose.Component.ButtonTonalDefaultComponent
import com.example.mynewcompose.Component.IconButtonComponent
import com.example.mynewcompose.Component.TextFieldDefaultComponent
import com.example.mynewcompose.Component.TextFieldDefaultPasswordComponent

@Composable
fun SignUpScreen(navigationController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally){

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(90.dp)
                ),
            contentAlignment = Alignment.Center){
            Icon(
                painter = painterResource(id = R.drawable.flower),
                contentDescription = "Flower",
                Modifier.size(80.dp),
                tint = Color.White)
        }


        Column(Modifier.width(300.dp)) {
            Text(text = "¡Únete Ahora!",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.size(20.dp))
            TextFieldDefaultComponent(labelText = "Correo eléctronico")

            Spacer(modifier = Modifier.size(20.dp))
            TextFieldDefaultPasswordComponent(labelText = "Contraseña")

            Spacer(modifier = Modifier.size(20.dp))
            TextFieldDefaultPasswordComponent(labelText = "Confirmar contraseña")

            Spacer(modifier = Modifier.size(25.dp))
            ButtonTonalDefaultComponent(onClick = { /*TODO*/ }, text = "Crear cuenta")

        }

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "O continuar con")

            Spacer(modifier = Modifier.size(10.dp))
            Row {
                IconButtonComponent(
                    onClick = { /*TODO*/ },
                    icon = painterResource(id = R.drawable.google),
                    contentDescription = "Google")
                IconButtonComponent(
                    onClick = { /*TODO*/ },
                    icon = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook")
                IconButtonComponent(
                    onClick = { /*TODO*/ },
                    icon = painterResource(id = R.drawable.github),
                    contentDescription = "Github",
                )
            }

            Spacer(modifier = Modifier.size(30.dp))
            Row {
                Text(text = "¿Tienes cuenta?")

                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "Autenticarme",
                    modifier = Modifier.clickable { navigationController.navigate(Routes.SignInScreen.route) },
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}