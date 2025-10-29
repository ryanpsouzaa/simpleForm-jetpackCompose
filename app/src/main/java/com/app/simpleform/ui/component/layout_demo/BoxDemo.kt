package com.app.simpleform.ui.component.layout_demo

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.simpleform.ui.theme.SimpleFormTheme

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(modifier = Modifier.align(Alignment.TopStart), text = "Hello World")
        Column(
            modifier = Modifier.align(Alignment.TopEnd).fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.size(50.dp).background(Color.Yellow))
            Box(modifier = Modifier.size(50.dp).background(Color.Blue))
            Box(modifier = Modifier.size(50.dp).background(Color.Red))
            Box(modifier = Modifier.size(50.dp).background(Color.Magenta))


        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxDemoPreview() {
    SimpleFormTheme {
        Scaffold { innerPadding ->
            BoxDemo(modifier = Modifier.padding(innerPadding))
        }
    }

}