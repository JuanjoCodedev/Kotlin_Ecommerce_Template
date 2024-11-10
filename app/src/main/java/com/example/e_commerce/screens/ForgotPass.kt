package com.example.e_commerce.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.e_commerce.Component.TopAppBarComponent
import com.example.e_commerce.R
import com.example.mynewcompose.Component.ButtonTonalDefaultComponent
import com.example.mynewcompose.Component.TextFieldDefaultComponent

@Composable
fun ForgotPassScreen(navigationController: NavHostController) {
    Column {
        TopAppBarComponent(text = "Volver atrás", navController = navigationController)

        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
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

            Spacer(modifier = Modifier.size(50.dp))
            Column() {
                Text(text = "¡Ingresa tus datos!",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.size(20.dp))
                TextFieldDefaultComponent(labelText = "Correo eléctronico")

                Spacer(modifier = Modifier.size(25.dp))
                ButtonTonalDefaultComponent(onClick = { /*TODO*/ }, text = "Validar Correo")

                Spacer(modifier = Modifier.size(25.dp))
                Text(text = "Ingrese su correo electrónico para validar su cuenta. Una vez validado, recibirá un código de verificación en su bandeja de entrada.",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center)
            }
        }
    }
}