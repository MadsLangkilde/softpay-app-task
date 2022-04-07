package io.softpay.presentation.uibase.elements

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.softpay.presentation.uibase.theme.styles.*


@Composable
fun NumberButton(
    number: Int,
    onClick: (digit: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = {
            onClick(number)
        },
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = WhiteTransparent,
            contentColor = WhiteTransparent
        ),
        shape = CircleShape,
    ) {
        Text(
            text = number.toString(),
            fontSize = 30.sp,
            color = White
        )
    }
}