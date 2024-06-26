package com.example.first_week_creating_ui_kit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.first_week_creating_ui_kit.ui.theme.AppTheme
import com.example.firstweek_lessonfirst.R

sealed interface AvatarType {
    data object AvatarProfile : AvatarType
    data object AvatarMeeting : AvatarType
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CustomAvatar(
    modifier: Modifier = Modifier,
    model: String? = null,
    type: AvatarType,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    size: Dp = 100.dp,
    defaultImage: Int = R.drawable.ic_avatar,
    defaultDescription: Int = R.string.avatar,
    backgroundColor: Color = AppTheme.colors.neutralColorBackground,
    addIcon: Int = R.drawable.ic_add
) {
    when (type) {
        AvatarType.AvatarProfile -> {
            Box(
                modifier = modifier
                    .size(size)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .background(backgroundColor)
                ) {
                    if (defaultImage == R.drawable.ic_avatar) {
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxSize(0.5f),
                            painter = painterResource(defaultImage),
                            contentDescription = stringResource(defaultDescription),
                            contentScale = ContentScale.Fit
                        )
                    } else {
                        GlideImage(
                            model = model,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxSize(0.5f),
                            contentDescription = stringResource(defaultDescription),
                            contentScale = ContentScale.Fit
                        )
                    }

                }
                if (isEnabled) {
                    IconButton(
                        onClick = onClick,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(AppTheme.dimens.paddingSmall)
                            .fillMaxSize(0.24f)

                    ) {
                        Icon(
                            painter = painterResource(addIcon),
                            contentDescription = stringResource(defaultDescription),
                        )
                    }
                }
            }
        }

        AvatarType.AvatarMeeting -> {
            Box(
                modifier = modifier
                    .size(56.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(backgroundColor)
                        .clip(RoundedCornerShape(AppTheme.dimens.paddingLarge))
                        .wrapContentSize()
                ) {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(AppTheme.dimens.paddingLarge)),
                        painter = painterResource(defaultImage),
                        contentDescription = stringResource(defaultDescription),
                        contentScale = ContentScale.Crop
                    )
                }
                if (isEnabled) {
                    IconButton(
                        onClick = onClick,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .fillMaxSize(0.24f)
                    ) {
                        Icon(
                            painter = painterResource(addIcon),
                            contentDescription = stringResource(defaultDescription),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp2() {
    Column(modifier = Modifier.padding(16.dp)) {
        CustomAvatar(
            type = AvatarType.AvatarProfile,
            onClick = {},
            isEnabled = true,
            defaultImage = R.drawable.ic_avatar,
            defaultDescription = R.string.avatar,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        CustomAvatar(
            type = AvatarType.AvatarMeeting,
            onClick = {},
            isEnabled = true,
            defaultImage = R.drawable.ava_orange,
            defaultDescription = R.string.avatar,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        CustomAvatar(
            type = AvatarType.AvatarProfile,
            model = "https://avatars.dzeninfra.ru/get-zen_doc/1592433/pub_613232f67916e7006acd81cc_613238bd39f2cf24c3cb3303/scale_1200",
            onClick = {},
            isEnabled = true,
            defaultImage = R.drawable.ava_woman,
            defaultDescription = R.string.avatar,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyApp2() {
    MyApp2()
}