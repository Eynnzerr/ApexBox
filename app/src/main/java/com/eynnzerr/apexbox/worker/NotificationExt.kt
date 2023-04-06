package com.eynnzerr.apexbox.worker

import android.app.Notification
import android.app.NotificationManager
import androidx.work.CoroutineWorker
import com.eynnzerr.apexbox.R
import kotlin.random.Random

fun CoroutineWorker.sendNotification(title: String, content: String) {
    val notificationManager = applicationContext.getSystemService(NotificationManager::class.java)
    val notification = Notification.Builder(applicationContext, "subscription_channel")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(title)
        .setContentText(content)
        .build()
    notificationManager.notify(Random.nextInt(), notification)
}