package mapp.test.evaluationassignmenttestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import mapp.test.core.util.myLogD
import mapp.test.core.util.showShortToast
import mapp.test.evaluationassignmenttestapp.ui.AppMainComposableRoot

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMainComposableRoot()
        }
    }
    override fun onStart() {
        super.onStart()
        myLogD("Start","DAG")
        showShortToast(this, "Start")
    }
    override fun onResume() {
        super.onResume()
        myLogD("Resume","DAG")
        showShortToast(this, "Resume")

    }
    override fun onPause() {
        super.onPause()
        myLogD("Pause","DAG")
        showShortToast(this, "Pause")
    }
    override fun onStop() {
        super.onStop()
        myLogD("Stop","DAG")
        showShortToast(this, "Stop")
    }
    override fun onRestart() {
        super.onRestart()
        myLogD("Restart","DAG")
        showShortToast(this, "Restart")
    }
    override fun onDestroy() {
        super.onDestroy()
        myLogD("Destroy","DAG")
        showShortToast(this, "Destroy")
    }

}


