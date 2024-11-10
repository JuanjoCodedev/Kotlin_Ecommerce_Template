package com.example.mynewcompose.Component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.e_commerce.R

@Composable
fun TextFieldDefaultComponent(initialized: String = "", labelText: String, maxLines: Int = 1){
    var text by remember { mutableStateOf(initialized) }
    TextField(
        value = text,
        onValueChange = {text = it},
        label = { Text(labelText)},
        maxLines = maxLines,
        modifier = Modifier.fillMaxWidth())
}

@Composable
fun TextFieldDefaultPasswordComponent(initialized: String = "", labelText: String){
    var text by remember { mutableStateOf(initialized) }
    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        value = text,
        onValueChange = {text = it},
        label = { Text(labelText)},
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButtonComponent(
                onClick = {isPasswordVisible = !isPasswordVisible},
                continerButtonColor = Color.Transparent,
                icon = if(isPasswordVisible) painterResource(id = R.drawable.round_visibility_off) else painterResource(id = R.drawable.round_visibility),
                tintIcon = MaterialTheme.colorScheme.primary,
                contentDescription = "Toggle password visibility")
        },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth())
}

@Composable
fun TextFieldComponent(initialized: String = "", labelText: String){
    var text by remember { mutableStateOf(initialized) }
    TextField(value = text, onValueChange = {text = it}, label = { Text(labelText)}, shape = RoundedCornerShape(8.dp), colors = TextFieldDefaults.colors(
        unfocusedContainerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    ), modifier = Modifier.fillMaxWidth())
}

@Composable
fun OutlinedTextFieldComponent(initialized: String = "", labelText: String){
    var text by remember { mutableStateOf(initialized) }
    OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text(labelText)}, colors = OutlinedTextFieldDefaults.colors(focusedLabelColor = Color.Yellow, unfocusedLabelColor = Color.Blue, focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Blue))
}