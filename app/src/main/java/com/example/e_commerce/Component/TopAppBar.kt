package com.example.e_commerce.Component

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.e_commerce.R
import com.example.mynewcompose.Component.IconButtonComponent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopAppBarComponent(text: String = "My bar", navController: NavController){
    TopAppBar(
        title = { Text(text = text) },
        navigationIcon = {
            IconButtonComponent(
                onClick = { navController.navigateUp() },
                icon = painterResource(id = R.drawable.round_arrow_back),
                contentDescription = "Localized description" )
                },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary))
}