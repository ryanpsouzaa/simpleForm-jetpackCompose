package com.app.simpleform.ui.component.modifier_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.simpleform.ui.theme.SimpleFormTheme

@Composable
fun LayoutPropertiesDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        //tamanho fixo
        Box(
            modifier = Modifier
                //.size(100.dp)
                .width(200.dp)
                .height(100.dp)
                .background(Color.Blue)
        )
        //tamanho baseado em preenchimento em largura
        //fillMaxWidth() -> preenchimento total em largura
        //fillMaxHeight() -> preenchimento total em altura
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(200.dp)
                .background(Color.Gray)
        )

        //offset(x = dp, y = dp) -> deslocamento
        Box(
            modifier = Modifier
                .size(300.dp)
                .offset(x = 50.dp)
                .background(Color.Yellow)
        )

        //aspectRatio -> proporcao
        //ajusta largura/altura conforme a proporcao mencionada
        Box(
            modifier = Modifier
                .width(100.dp)
                .aspectRatio(16f/9f)
                .background(Color.Red)
        )

        //Distribuicao de espaco
        //weight(1f)
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Gray),
            horizontalArrangement = Arrangement.spacedBy(8.dp)){
            Box(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxHeight()
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun LayoutPropertiesDemoPreview() {
    SimpleFormTheme {
        LayoutPropertiesDemo()
    }

}