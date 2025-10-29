package com.app.simpleform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.simpleform.ui.component.ChooseMyFavoriteHeroScreen
import com.app.simpleform.ui.component.modifier_demo.InteractionPropertiesDemo
import com.app.simpleform.ui.theme.SimpleFormTheme
import com.app.simpleform.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //HelloContent(modifier = Modifier.padding(innerPadding))
                    //InteractionPropertiesDemo(modifier = Modifier.padding(innerPadding))
                    ChooseMyFavoriteHeroScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HelloContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var name by remember { mutableStateOf("") }

        if(name.isNotEmpty()){
            Text(
                text = stringResource(id = R.string.hello, name),
                modifier = Modifier.padding(bottom = 8.dp),
                style = Typography.bodyMedium
            )

        }
        OutlinedTextField(
            value = name,
            onValueChange = { updatedText -> name = updatedText },
            label = { Text(text = stringResource(id = R.string.name)) }
        )

    }
}

@Preview
@Composable
private fun HelloContentPreview() {
    SimpleFormTheme {
        HelloContent()
    }
}