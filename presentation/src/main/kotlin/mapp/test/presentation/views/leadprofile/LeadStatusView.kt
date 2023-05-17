package mapp.test.presentation.views.leadprofile

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import mapp.test.FetchLeadQuery
import mapp.test.coreui.composable.FillAvailableSpacer
import mapp.test.coreui.composable.Spacer16dp
import mapp.test.coreui.composable.Spacer4dp
import mapp.test.coreui.composable.Spacer8dp
import mapp.test.coreui.composable.column.PrimaryBorderedColumnMaxSize
import mapp.test.coreui.composable.custom.StatusStepItemView
import mapp.test.coreui.composable.icons.PrimaryIcon
import mapp.test.coreui.composable.icons.SimpleRoundIconWithBackground
import mapp.test.coreui.composable.row.PrimaryRowMaxWithVerticalAlignCenter
import mapp.test.coreui.composable.text.PrimaryActiveText14sp
import mapp.test.coreui.composable.text.PrimarySubTitleBoldText13sp

@Composable
fun LeadStatusView(status: FetchLeadQuery.Status, onClick: () -> Unit) {
    PrimaryBorderedColumnMaxSize(onClick = onClick) {
        PrimaryRowMaxWithVerticalAlignCenter {
            PrimarySubTitleBoldText13sp(text = stringResource(id = mapp.test.coreui.R.string.status_title))
            FillAvailableSpacer()
            SimpleRoundIconWithBackground(color = status.color)
            Spacer8dp()
            PrimaryActiveText14sp(text = status.title)
            Spacer16dp()
            PrimaryIcon(
                resId = mapp.test.coreui.R.drawable.ic_right,
            )
        }
        Spacer8dp()
        PrimaryRowMaxWithVerticalAlignCenter {
            repeat((1..status.stepsCount).count()) { count ->
                StatusStepItemView(
                    isActive = count < status.step,
                    activeColor = status.legacyColor,
                    inactiveColor = status.backgroundColor
                )
                Spacer4dp()
            }
        }
    }
}