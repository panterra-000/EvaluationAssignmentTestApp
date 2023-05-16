package mapp.test.presentation.views.leadprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mapp.test.coreui.composable.Spacer10dp
import mapp.test.coreui.composable.Spacer13dp
import mapp.test.coreui.composable.Spacer6dp
import mapp.test.coreui.composable.buttons.PrimaryIconButton
import mapp.test.coreui.composable.image.AvatarImageView
import mapp.test.coreui.composable.text.ActiveTitleText18sp
import mapp.test.coreui.composable.text.PrimaryTitleText16sp

@Composable
fun LeadHeaderView(
    fullName: String, avatarUrl: String, leadId: Int, editClick: () -> Unit
) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        Spacer10dp()
        Column(Modifier.padding(start = 10.dp, end = 10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                AvatarImageView(title = "", avatarImageUrl = avatarUrl)
                Spacer13dp()
                Column(Modifier.fillMaxWidth()) {
                    Row {
                        ActiveTitleText18sp(text = fullName)
                        Spacer(modifier = Modifier.width(16.dp))
                        PrimaryIconButton(
                            resId = mapp.test.coreui.R.drawable.ic_edit, onclick = editClick
                        )
                    }
                    Spacer6dp()
                    PrimaryTitleText16sp(text = "ID: $leadId")
                }
            }
        }
    }
}