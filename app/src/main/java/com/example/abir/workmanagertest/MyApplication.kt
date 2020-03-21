package com.example.abir.workmanagertest

import android.app.Application
import androidx.work.*
import java.util.concurrent.TimeUnit

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initiateUniquePeriodicWork()
    }

    private fun initiateUniquePeriodicWork() {
        "initiateUniquePeriodicWork".logDebug(APP_TAG)
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val myWork = PeriodicWorkRequestBuilder<UserAliveWorker>(
            15, TimeUnit.MINUTES
        )
            .setConstraints(constraints)
            .build()

        // TODO val requestId :Int= myWork.id

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            Constants.pingUserAlive,
            ExistingPeriodicWorkPolicy.KEEP,
            myWork
        )
    }
}