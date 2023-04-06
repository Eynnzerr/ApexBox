package com.eynnzerr.apexbox.base

import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CPApplication: Application(), Configuration.Provider {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        // min sdk is 26, so notification channel is needed.
        val channel = NotificationChannel(
            "subscription_channel",
            "Map Subscription",
            NotificationManager.IMPORTANCE_HIGH
        )
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    @Inject lateinit var workerFactory: HiltWorkerFactory

    // since this is an application context, which will always exist till app finishes, it won't cause memory leak literally.
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
        .setWorkerFactory(workerFactory)
        // .setMinimumLoggingLevel(android.util.Log.DEBUG)
        .build()
}