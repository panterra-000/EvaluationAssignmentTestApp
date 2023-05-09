package mapp.test.evaluationassignmenttestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mapp.test.evaluationassignmenttestapp.ui.theme.EvaluationAssignmentTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            EvaluationAssignmentTestAppTheme {

            }
        }
    }
}
