package mapp.test.coreui.composable.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import mapp.test.coreui.composable.text.AvatarText23sp
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun AvatarImageView(avatarImageUrl: String = "", title: String) {
    Box(
        Modifier.size(50.dp)
    ) {
        if (avatarImageUrl.isNotEmpty()) {
            Image(
                painter = rememberAsyncImagePainter(model = avatarImageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(50.dp)
                    .clip(RoundedCornerShape(50))
            )
        } else {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                TestAppTheme.colors.avatarTopGradient,
                                TestAppTheme.colors.avatarBottomGradient,
                            )
                        )
                    ), contentAlignment = Alignment.Center
            ) {
                AvatarText23sp(text = title)
            }
        }
    }
}
