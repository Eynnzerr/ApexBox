package com.eynnzerr.apexbox.worker

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.data.repository.AppRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random

@HiltWorker
class SubscriptionWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted val workerParams: WorkerParameters,
    private val repository: AppRepository
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        Log.d(TAG, "doWork: worker scheduled and doing job.")
        runCatching{
            repository.getMapRotation()
        }.onSuccess { response ->
            if (response.isSuccessful) {
                response.body()?.let { mapRotation ->
                    val subscribedMaps = inputData.getStringArray("subscribed_maps")
                    subscribedMaps?.let { targetMaps ->
                        if (mapRotation.battle_royale.current.map in targetMaps) {
                            // Hit and notification
                            sendNotification("Subscribed Map Available Now!", "BR map updates to ${mapRotation.battle_royale.current.map}, next is ${mapRotation.battle_royale.next.map} ")
                        }
                        // enqueue next work
                        WorkManager.getInstance(context).apply {
                            val data = Data.Builder()
                                .putStringArray("subscribed_maps", targetMaps)
                                .build()
                            enqueue(
                                OneTimeWorkRequestBuilder<SubscriptionWorker>()
                                .setInputData(data)
                                .setConstraints(
                                    Constraints.Builder()
                                        .setRequiredNetworkType(NetworkType.CONNECTED)
                                        .build()
                                )
                                .setInitialDelay(mapRotation.battle_royale.current.remainingSecs.toLong(), TimeUnit.SECONDS)
                                .build()
                            )
                        }
                    }
                }
            }
        }.onFailure { exception ->
            Log.d(TAG, "doWork: $exception")
            return Result.failure()
        }
        return Result.success()
    }

    private fun sendNotification(title: String, content: String) {
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        val notification = Notification.Builder(context, "subscription_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(content)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
    }
}

private const val TAG = "SubscriptionWorker"