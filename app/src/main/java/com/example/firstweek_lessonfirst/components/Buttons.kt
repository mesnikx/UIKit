package com.example.firstweek_lessonfirst.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppRowOfButtons(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    image: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(6.dp)
            ) {
            Text(text = "Button")
        }
        OutlinedButton(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(6.dp)
        ) {
            Text(text = "Button")
        }
        TextButton(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(6.dp)
            ) {
            Text(text = "Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    AppRowOfButtons(name = "Buttons", onClick = { /*TODO*/ })
}
