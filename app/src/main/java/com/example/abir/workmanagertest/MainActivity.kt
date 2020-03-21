package com.example.abir.workmanagertest

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkLastUpdate()
    }

    private fun checkLastUpdate() {
        val sharedPref =
            getSharedPreferences(Constants.appPreferenceName, Context.MODE_PRIVATE) ?: return
        val lastUpdate = sharedPref.getString(Constants.lastUpdate, "Unknown")
        "\n\n $lastUpdate".logWarn(APP_TAG)
        tvLastUpdate.text = lastUpdate
    }
}
