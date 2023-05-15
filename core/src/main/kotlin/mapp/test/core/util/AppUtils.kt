package mapp.test.core.util

import android.content.Context
import android.util.Log
import android.widget.Toast

fun myLogD(msg: String = "", tag: String = "TAG_D") {
    Log.d(tag, msg)
}

fun showShortToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}