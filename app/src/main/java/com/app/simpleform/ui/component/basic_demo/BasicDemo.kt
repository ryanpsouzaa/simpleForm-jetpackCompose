package com.app.simpleform.ui.component.basic_demo

import android.R.attr.checked
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.app.simpleform.R
import com.app.simpleform.ui.theme.SimpleFormTheme

@Composable
fun BasicDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = LoremIpsum(50).values.joinToString(),
            color = Color.Red,

            fontSize = TextUnit(value = 12f, type = TextUnitType.Sp),
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodySmall
        )

        var context = LocalContext.current
        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(size = 8.dp),
            border = BorderStroke(2.dp, Brush.linearGradient(
                listOf(
                    Color.Blue, Color.Gray
            ))),
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 1.dp),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Click Here")
        }
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(size = 8.dp),
            border = BorderStroke(2.dp, Brush.linearGradient(
                listOf(
                    Color.Blue, Color.Green
                ))),
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 1.dp),
            onClick = {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null
                )
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
                Text(text = "Click Here")
            }
        }

        //checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = true,
                onCheckedChange = { isChecked ->

                },
                colors = CheckboxDefaults.colors(checkedColor = Color.Green)
            )
            Text(text = "Item Um")
        }

        //switch
        Switch(
            checked = true,
            onCheckedChange = {isChecked ->},
            thumbContent = {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Cyan,
                checkedThumbColor = Color.Gray,
                checkedIconColor = Color.White
            )
        )

        //card
        Card(
            modifier = Modifier.size(width = 300.dp, height = 200.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            ),
            border = BorderStroke(2.dp, Color.Cyan),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ){
            Column(modifier = Modifier.padding(8.dp)) {
                Row {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null,
                        tint = (Color.White))

                    Text(
                        text = LoremIpsum(25).values.joinToString(),
                        color = Color.White)
                }
            }
        }

        //textField
        TextField(
            value = "",
            onValueChange = {text -> },
            placeholder = {Text(text = "placeholder")},
            supportingText = {Text(text = "supporting")},
            label = {Text(text = "Label")},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
        )

        OutlinedTextField(
            value = "",
            onValueChange = {text -> },
            placeholder = {Text(text = "placeholder")},
            supportingText = {Text(text = "supporting")},
            label = {Text(text = "Label")},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
        )

        //botao de selecao
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = true,
                onClick = { }
            )
            Text(text = "Marque a opcao")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicDemoPreview() {
    SimpleFormTheme {
        BasicDemo()
    }

}