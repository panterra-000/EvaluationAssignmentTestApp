package mapp.test.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mapp.test.core.data.LeadModel
import mapp.test.coreui.composable.DividerMin
import mapp.test.coreui.composable.Spacer10dp
import mapp.test.coreui.composable.Spacer12dp
import mapp.test.coreui.composable.Spacer13dp
import mapp.test.coreui.composable.Spacer2dp
import mapp.test.coreui.composable.Spacer6dp
import mapp.test.coreui.composable.image.AvatarImageView
import mapp.test.coreui.composable.row.PrimaryScrollableRow
import mapp.test.coreui.composable.text.ActiveTitleText18sp
import mapp.test.coreui.composable.text.PrimaryBoldText15sp
import mapp.test.coreui.composable.text.PrimaryChipText14sp
import mapp.test.coreui.composable.text.Text20sp

@Composable
fun LeadView(leadModel: LeadModel, onclick: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable { onclick() }) {
        Spacer10dp()
        Column(Modifier.padding(start = 13.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AvatarImageView(title = leadModel.avatarName, avatarImageUrl = leadModel.avatarUrl)
                Spacer13dp()
                Column(Modifier.fillMaxWidth()) {
                    Row {
                        ActiveTitleText18sp(text = leadModel.fullName)
                        Spacer(modifier = Modifier.width(16.dp))
                        Text20sp(text = leadModel.countryEmoji)
                    }
                    PrimaryScrollableRow {
                        leadModel.intention?.let { intention ->
                            PrimaryChipText14sp(text = intention.title)
                            Spacer6dp()
                        }
                        leadModel.status?.let { status ->
                            PrimaryChipText14sp(text = status.title)
                            Spacer6dp()
                        }
                        leadModel.adSource?.let { adSource ->
                            PrimaryChipText14sp(text = adSource.title)
                            Spacer6dp()
                        }
                        leadModel.channelSource?.let { channelSource ->
                            PrimaryChipText14sp(text = channelSource.title)
                            Spacer6dp()
                        }
                    }
                }
            }
            Spacer12dp()
            PrimaryBoldText15sp(text = "Created date: ${leadModel.createdAt}")
            PrimaryBoldText15sp(text = "Updated date: ${leadModel.updatedAt}")
        }
        Spacer10dp()
        DividerMin()
    }
}