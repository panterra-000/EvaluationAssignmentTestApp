package mapp.test.evaluationassignmenttestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import mapp.test.coreui.theme.PrimaryAppTheme
import mapp.test.evaluationassignmenttestapp.ui.AppMainComposableRoot

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMainComposableRoot()
        }
    }
}
