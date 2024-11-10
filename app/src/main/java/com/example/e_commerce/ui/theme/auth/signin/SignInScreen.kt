package com.example.e_commerce.ui.theme.auth.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.e_commerce.R
import com.example.e_commerce.models.Routes
import com.example.mynewcompose.Component.IconButtonComponent

@Composable
fun SignInScreen(navigationController: NavHostController, viewModel: SignInViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally){

        HeaderLoginComposable()
        FormLoginComposable(navigationController = navigationController, viewModel)
        RedSocialComposable(navigationController = navigationController)

    }
}

@Composable
fun HeaderLoginComposable(){
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
}

@Composable
fun EmailFieldComposable(email: String, onTextFieldChange:(String)-> Unit){
    TextField(
        value = email, onValueChange = {onTextFieldChange(it)},
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = "Correo eléctronico")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
    )
}

@Composable
fun PasswordFieldComposable(password: String, onTextFieldChange:(String)-> Unit){
    TextField(
        value = password, onValueChange = {onTextFieldChange(it)},
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = "Contraseña")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
    )
}

@Composable
fun LoginButtonComposable(loginEnable: Boolean, onLoginSelected:()-> Unit){
    FilledTonalButton(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = loginEnable,
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Text(text = "Iniciar sesión")
    }
}

@Composable
fun FormLoginComposable(navigationController: NavHostController, viewModel: SignInViewModel){
    val signInData: SignInData by viewModel.signInData.observeAsState(initial = SignInData("", ""))
    val loginEnabled: Boolean by viewModel.loginEnable.observeAsState(initial = false)

    val email = signInData.email
    val password = signInData.password

    Column(Modifier.width(300.dp)) {
        Text(text = "Accede a tu Cuenta",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.size(20.dp))
        EmailFieldComposable(email) {viewModel.onLoginChanged(it, password)}

        Spacer(modifier = Modifier.size(20.dp))
        PasswordFieldComposable(password) {viewModel.onLoginChanged(email, it)}

        Spacer(modifier = Modifier.size(25.dp))
        LoginButtonComposable(loginEnabled) {viewModel.onLoginSelected()}

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Olvide mi contraseña",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigationController.navigate(Routes.ForgotPassScreen.route) },
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RedSocialComposable(navigationController: NavHostController){
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
            Text(text = "¿No tienes cuenta?")

            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "Crear cuenta",
                modifier = Modifier.clickable { navigationController.navigate(Routes.SignUpScreen.route) },
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold)
        }
    }
}