package com.example.first_week_creating_ui_kit.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first_week_creating_ui_kit.ui.theme.AppTheme

sealed interface ButtonType {
    data object Primary : ButtonType
    data object Secondary : ButtonType
    data object Ghost : ButtonType
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    shape: Shape = RoundedCornerShape(30.dp),
    type: ButtonType = ButtonType.Primary,
    backgroundColor: Color = AppTheme.colors.brandColorDefault,
    contentColor: Color = AppTheme.colors.neutralColorBackground,
    rippleColor: Color = AppTheme.colors.brandColorDarkOnPressed,
    disabledContainerColor: Color = AppTheme.colors.brandColorDefault.copy(alpha = 0.5f),
    disabledContentColor: Color = AppTheme.colors.neutralColorSecondaryBackground
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    when (type) {
        ButtonType.Primary -> {
            Button(
                onClick = onClick,
                enabled = isEnabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isPressed) rippleColor else backgroundColor,
                    contentColor = contentColor,
                    disabledContainerColor = disabledContainerColor,
                    disabledContentColor = disabledContentColor
                ),
                shape = shape,
                modifier = modifier
                    .padding(AppTheme.dimens.paddingMedium),
            ) {
                Text(
                    text,
                    style = AppTheme.typo.subtitle2,
                    textAlign = TextAlign.Center
                )
            }
        }

        ButtonType.Secondary -> {
            OutlinedButton(
                onClick = onClick,
                enabled = isEnabled,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = if (isPressed) rippleColor else backgroundColor,
                    disabledContentColor = disabledContainerColor,

                    ),
                border = BorderStroke(
                    2.dp,
                    if (!isEnabled) disabledContainerColor else if (isPressed) rippleColor else backgroundColor,
                ),
                shape = shape,
                interactionSource = interactionSource,
                modifier = modifier
                    .padding(AppTheme.dimens.paddingMedium)
            ) {
                Text(
                    text,
                    style = AppTheme.typo.subtitle2,
                    textAlign = TextAlign.Center
                )
            }
        }

        ButtonType.Ghost -> {
            TextButton(
                onClick = onClick,
                enabled = isEnabled,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = if (isPressed) rippleColor else backgroundColor,
                    disabledContentColor = disabledContainerColor
                ),
                shape = shape,
                interactionSource = interactionSource,
                modifier = modifier
                    .padding(AppTheme.dimens.paddingMedium)

            ) {
                Text(
                    text,
                    style = AppTheme.typo.subtitle2,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun MyApp() {
    Column(modifier = Modifier.padding(16.dp)) {
        CustomButton(
            text = "Button",
            onClick = { /*TODO*/ },
            type = ButtonType.Primary,
            isEnabled = true,
            modifier = Modifier
        )

        CustomButton(
            text = "Button",
            onClick = { /*TODO*/ },
            type = ButtonType.Secondary,
            isEnabled = true,
            modifier = Modifier
        )

        CustomButton(
            text = "Button",
            onClick = { /*TODO*/ },
            type = ButtonType.Ghost,
            isEnabled = true,
            modifier = Modifier
        )

        CustomButton(
            text = "Button",
            onClick = { /*TODO*/ },
            type = ButtonType.Primary,
            isEnabled = false,
            modifier = Modifier
        )
        CustomButton(
            text = "Button",
            onClick = { /*TODO*/ },
            type = ButtonType.Secondary,
            isEnabled = false,
            modifier = Modifier
        )
        CustomButton(
            text = "Button",
            onClick = { /*TODO*/ },
            type = ButtonType.Ghost,
            isEnabled = false,
            modifier = Modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MyApp()
}