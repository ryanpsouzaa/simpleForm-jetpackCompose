package com.app.simpleform.ui.component.layout_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.app.simpleform.ui.theme.SimpleFormTheme

@Composable
fun ConstraintLayoutDemo(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ){
        val (title, subtitle, boxRed, boxGreen, boxBlue) = createRefs()

        Text(
            text = "Titulo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.constrainAs(title){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })

        Text(
            text = "Subtitulo",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(subtitle){
            top.linkTo(title.bottom)
            start.linkTo(parent.start)
        })

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed){
                    top.linkTo(subtitle.bottom, margin = 15.dp)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue){
                    top.linkTo(boxRed.bottom, margin = 15.dp)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Green)
                .constrainAs(boxGreen){
                    top.linkTo(boxBlue.bottom, margin = 15.dp)
                    start.linkTo(parent.start)
                }
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun ConstraintLayoutDemoPreview() {
    SimpleFormTheme {
        ConstraintLayoutDemo()
    }
}