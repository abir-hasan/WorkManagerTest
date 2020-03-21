package com.example.abir.workmanagertest

import android.content.Context
import androidx.core.content.edit
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*

class UserAliveWorker(val mContext: Context, params: WorkerParameters) :
    Worker(mContext, params) {

    companion object {
        const val TAG = "UserAliveWorker"
    }

    override fun doWork(): Result {
        return try {
            val calledTime = Calendar.getInstance().timeInMillis
            "doWork() called at: ${parseDateTime(calledTime)}".logDebug(TAG)

            val sharedPreferences =
                mContext.getSharedPreferences(Constants.appPreferenceName, Context.MODE_PRIVATE)
            val updateCount = sharedPreferences.getInt(Constants.updateCount, 0) + 1
            val prevValues = sharedPreferences.getString(Constants.lastUpdate, "")

            val storeResult =
                "$prevValues\nOccurrence($updateCount) at: ${parseDateTime(calledTime)}"

            sharedPreferences.edit {
                putInt(Constants.updateCount, updateCount)
                putString(Constants.lastUpdate, storeResult)
            }
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }
}