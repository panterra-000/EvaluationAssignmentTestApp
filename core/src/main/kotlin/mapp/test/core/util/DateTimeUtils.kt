package mapp.test.core.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

fun getCurrentTimeString(): String {
    return getCurrentDateTime().toString("yyyy/MM/dd HH:mm:ss")
}

fun getCurrentTimeIn12Hours(): String {
    return getCurrentDateTime().toString("HH:mm a")
}

@SuppressLint("SimpleDateFormat")
fun String.changeDateFormat(): String {
    val sdfSource = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val date = sdfSource.parse(this)
    val sdfDestination = SimpleDateFormat("dd.MM.yyyy")
    return sdfDestination.format(date)
}

