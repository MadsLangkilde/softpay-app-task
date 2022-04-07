package io.softpay.presentation.uibase.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.softpay.presentation.uibase.theme.styles.*

@Composable
fun NumberKeyboard(
    onClick: (digit: Int) -> Unit,
    onSubmit: () -> Unit,
    onDeleteChar: () -> Unit,
    modifier: Modifier
) {
    val buttonSize = 70.dp
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            NumberButton(number = 1, onClick = onClick, modifier = Modifier.size(buttonSize))
            NumberButton(number = 2, onClick = onClick, modifier = Modifier.size(buttonSize))
            NumberButton(number = 3, onClick = onClick, modifier = Modifier.size(buttonSize))
        }
        Row {
            NumberButton(number = 4, onClick = onClick, modifier = Modifier.size(buttonSize))
            NumberButton(number = 5, onClick = onClick, modifier = Modifier.size(buttonSize))
            NumberButton(number = 6, onClick = onClick, modifier = Modifier.size(buttonSize))
        }

        Row {
            NumberButton(number = 7, onClick = onClick, modifier = Modifier.size(buttonSize))
            NumberButton(number = 8, onClick = onClick, modifier = Modifier.size(buttonSize))
            NumberButton(number = 9, onClick = onClick, modifier = Modifier.size(buttonSize))
        }

        Row {
            NumberIconButton(
                icon = Icons.Rounded.Check,
                onSubmit,
                modifier = Modifier.size(buttonSize),
                WhiteTransparentMedium,
                Blue900
            )
            NumberButton(number = 0, onClick = onClick, modifier = Modifier.size(buttonSize))
            NumberIconButton(
                icon = Icons.Rounded.Backspace,
                onDeleteChar,
                modifier = Modifier.size(buttonSize),
                WhiteTransparentMedium,
                Blue900
            )
        }
    }
}

