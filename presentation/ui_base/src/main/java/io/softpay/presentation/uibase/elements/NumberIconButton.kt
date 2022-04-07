package io.softpay.presentation.uibase.elements

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import io.softpay.presentation.uibase.theme.styles.Blue200
import io.softpay.presentation.uibase.theme.styles.Blue500
import io.softpay.presentation.uibase.theme.styles.White
import io.softpay.presentation.uibase.theme.styles.WhiteTransparent


@Composable
fun NumberIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    iconColor: Color
) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = backgroundColor,
            contentColor = backgroundColor
        ),
        shape = CircleShape,
    ) {
        Icon(
            tint = iconColor,
            imageVector = icon,
            contentDescription = null
        )
    }
}