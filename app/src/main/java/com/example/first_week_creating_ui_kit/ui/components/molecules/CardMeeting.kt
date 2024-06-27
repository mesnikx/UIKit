package com.example.first_week_creating_ui_kit.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first_week_creating_ui_kit.ui.components.atoms.AvatarType
import com.example.first_week_creating_ui_kit.ui.components.atoms.CustomAvatar
import com.example.first_week_creating_ui_kit.ui.components.atoms.CustomChip
import com.example.first_week_creating_ui_kit.ui.theme.AppTheme

@Composable
fun CardMeeting(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String? = null,
    dateAndPlace: String,
    onCLick: () -> Unit = {},
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RectangleShape,
        onClick = onCLick,
        modifier = modifier
            .padding(
                bottom = AppTheme.dimens.padding12dp,
                start = AppTheme.dimens.padding4dp,
                top = AppTheme.dimens.padding4dp
            )
            .fillMaxWidth()
    ) {
        Row {
            if (imageUrl != null) {
                CustomAvatar(
                    type = AvatarType.AvatarMeeting,
                    model = imageUrl,
                    size = 48.dp,
                    modifier = Modifier.padding(
                        bottom = AppTheme.dimens.padding20dp,
                        end = AppTheme.dimens.padding12dp
                    )
                )
            } else {
                CustomAvatar(
                    type = AvatarType.AvatarMeeting,
                    size = 48.dp,
                    modifier = Modifier.padding(
                        bottom = AppTheme.dimens.padding20dp,
                        end = AppTheme.dimens.padding12dp
                    )
                )
            }
            Column {
                Text(
                    text = title,
                    style = AppTheme.typo.bodyText1,
                    color = AppTheme.colors.neutralColorFont,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = dateAndPlace,
                    style = AppTheme.typo.metadata1,
                    color = AppTheme.colors.neutralColorSecondaryText,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(modifier = Modifier.padding(top = AppTheme.dimens.padding4dp)) {
                    CustomChip(
                        text = "Python",
                        modifier = Modifier.padding(end = AppTheme.dimens.padding4dp)
                    )
                    CustomChip(
                        text = "Moscow",
                        modifier = Modifier.padding(end = AppTheme.dimens.padding4dp)
                    )
                    CustomChip(
                        text = "Junior",
                        modifier = Modifier.padding(end = AppTheme.dimens.padding4dp)
                    )
                }
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.padding12dp),
            thickness = AppTheme.dimens.padding2dp / 2,
            color = AppTheme.colors.neutralColorDivider
        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowCardMeeting() {
    Column {
        CardMeeting(
            title = "Developers meeting",
            dateAndPlace = "27.06.2024 - Moscow",
            modifier = Modifier.padding(AppTheme.dimens.padding4dp)
        )
        CardMeeting(
            title = "Kotlin Con",
            dateAndPlace = "29.08.2024",
            modifier = Modifier.padding(AppTheme.dimens.padding4dp)
        )
        CardMeeting(
            title = "Mobius Fall",
            dateAndPlace = "20.11.2024",
            modifier = Modifier.padding(AppTheme.dimens.padding4dp),
            imageUrl = "https://sun9-57.userapi.com/impg/Umm90jen_qIn5iswC26Eg5B_WK3A1FhY5j3npA/8YSlbgn5oIo.jpg?size=600x600&quality=95&sign=7d019a27e80fa0c004065b3bcde32cea&type=album"
        )
        CardMeeting(
            title = "Mobius Fall",
            dateAndPlace = "20.11.2024",
            modifier = Modifier.padding(AppTheme.dimens.padding4dp),
            imageUrl = "https://sun9-57.userapi.com/impg/Umm90jen_qIn5iswC26Eg5B_WK3A1FhY5j3npA/8YSlbgn5oIo.jpg?size=600x600&quality=95&sign=7d019a27e80fa0c004065b3bcde32cea&type=album"
        )
        CardMeeting(
            title = "Mobius Fall",
            dateAndPlace = "20.11.2024",
            modifier = Modifier.padding(AppTheme.dimens.padding4dp),
            imageUrl = "https://sun9-57.userapi.com/impg/Umm90jen_qIn5iswC26Eg5B_WK3A1FhY5j3npA/8YSlbgn5oIo.jpg?size=600x600&quality=95&sign=7d019a27e80fa0c004065b3bcde32cea&type=album"
        )
    }
}