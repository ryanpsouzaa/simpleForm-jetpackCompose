package com.app.simpleform.ui.component.layout_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun ColumnDemo(modifier: Modifier = Modifier) {
    //quatro parametros -> modifier, verticalArrangement, horizontalAlignment e content
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello World")
        Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Yellow))
        Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Red))
        Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Blue))

    }
}

@Preview(showBackground = true)
@Composable
private fun ColumnDemoPreview() {
    SimpleFormTheme {
        Scaffold{ innerPadding ->
            ColumnDemo(modifier = Modifier.padding(innerPadding))
        }
    }

}