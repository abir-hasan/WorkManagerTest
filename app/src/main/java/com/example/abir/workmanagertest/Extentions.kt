package com.example.abir.workmanagertest

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

fun Activity.showToast(message: String = "") {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String = "") {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

const val APP_TAG = "TestApp"

fun String.logVerbose(tag: String = APP_TAG) {
    if (BuildConfig.DEBUG)
        Log.v(tag, this)
}

fun String.logDebug(tag: String = APP_TAG) {
    if (BuildConfig.DEBUG)
        Log.d(tag, this)
}

fun String.logInfo(tag: String = APP_TAG) {
    if (BuildConfig.DEBUG)
        Log.i(tag, this)
}

fun String.logWarn(tag: String = APP_TAG) {
    if (BuildConfig.DEBUG)
        Log.w(tag, this)

}

fun String.logError(tag: String = APP_TAG) {
    if (BuildConfig.DEBUG)
        Log.e(tag, this)
}

fun parseTime(value: String): String {
    val dateTime = "2018-11-27 17:48:38.300"
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
    try {
        val calendar = Calendar.getInstance()
        calendar.time = format.parse(value)
        var hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timeString: String
        if (hour > 12) {
            hour %= 12

            timeString = "$hour:${beautifyTimeString(minute)} PM"
        } else {
            timeString = "$hour:${beautifyTimeString(minute)} AM"
        }
        return timeString
    } catch (e: Exception) {
        e.printStackTrace()
        return ""
    }
}

fun parseDateTime(value: String): String {
    val sampleInputForInputFormat = "2018-11-27 17:48:38.300"
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
    //val outputFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.getDefault())

    return try {
        val dateValue: Date = inputFormat.parse(value)
        outputFormat.format(dateValue)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

fun parseDateTime(value: Long): String {
    //val outputFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
    //val outputFormat = SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.getDefault())
    //val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a", Locale.getDefault())

    return try {
        val dateValue = Date(value)
        outputFormat.format(dateValue)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

fun parseDateTimeWithFormat(
    givenValue: String, givenFormat: String, requiredFormat: String
): String {
    val inputFormat = SimpleDateFormat(givenFormat, Locale.getDefault())
    val outputFormat = SimpleDateFormat(requiredFormat, Locale.getDefault())

    return try {
        val dateValue: Date = inputFormat.parse(givenValue)
        outputFormat.format(dateValue)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

private fun beautifyTimeString(time: Int) = if (time < 10) "0$time" else time.toString()