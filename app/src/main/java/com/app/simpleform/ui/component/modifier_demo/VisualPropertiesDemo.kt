package com.app.simpleform.ui.component.modifier_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.simpleform.ui.theme.SimpleFormTheme

@Composable
fun VisualPropertiesDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //background
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color(color = 0xFF000000))
        )

        //background com brush
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(brush = Brush.linearGradient(
                    listOf(Color.Yellow, Color.Green, Color.Blue)
                ))
        )

        //borda simples
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .border(width = 5.dp, color = Color.Black, shape = CircleShape)
        )

        //sombra
        Box(
            modifier = Modifier
                .size(200.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
                .background(Color.Red)
        )

        //GraphicsLayer -> transformacoes visuais avancadas
        Box(
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer{
                    val rotationZ = 100 * 0.15f
                    this.rotationZ = rotationZ
                    rotationX = 15f
                    scaleY = 2f
                    alpha = 0.7f
                }
                .background(Color.Yellow)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VisualPropertiesDemoPreview() {
    SimpleFormTheme {
        VisualPropertiesDemo()
    }
}