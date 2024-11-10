package com.example.e_commerce.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce.R
import com.example.mynewcompose.Component.ButtonTonalDefaultComponent

@Composable
fun CardMinimalComponent() {
    Card(
        modifier = Modifier.clickable { /*TODO*/ }
            .size(width = 240.dp, height = 390.dp)
    ) {
        Column {
            Image(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Multimedia de tarjeta",
                Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center){

                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Titulo",
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "$10.0",
                    fontSize = 20.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = LoremIpsum(50).values.take(10).joinToString(separator = " "),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.size(20.dp))
                ButtonTonalDefaultComponent(onClick = { /*TODO*/ }, text = "Agregar", heightButton = 45)
            }


        }
    }
}