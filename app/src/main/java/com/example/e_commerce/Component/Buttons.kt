package com.example.mynewcompose.Component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ButtonTonalDefaultComponent(onClick:() -> Unit, text: String, isEnabled: Boolean = true, heightButton: Int = 50){
    FilledTonalButton(
        onClick = { onClick() },
        enabled = isEnabled,
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black),
        modifier = Modifier.fillMaxWidth().height(heightButton.dp)) {
        Text(text)
    }
}

@Composable
fun IconButtonComponent(
    onClick: () -> Unit,
    continerButtonColor: Color = MaterialTheme.colorScheme.primary,
    icon: Painter,
    contentDescription: String,
    sizeIcon: Int = 20,
    tintIcon: Color = Color.White,
    isEnabled: Boolean = true) {
    IconButton(
        onClick = { onClick() },
        enabled = isEnabled,
        colors = IconButtonColors(
            containerColor = continerButtonColor,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.inverseOnSurface,
            disabledContainerColor = MaterialTheme.colorScheme.onSecondary)) {
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            tint = tintIcon,
            modifier = Modifier.size(sizeIcon.dp))
    }
}