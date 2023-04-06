package com.eynnzerr.apexbox.worker

import android.app.Notification
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.data.repository.AppRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@HiltWorker
class SubscriptionWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted val workerParams: WorkerParameters,
    private val repository: AppRepository
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        Log.d(TAG, "doWork: a worker starts working")
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
                                .setInitialDelay(mapRotation.battle_royale.current.remainingSecs.toLong(), TimeUnit.SECONDS)
                                // .setInitialDelay(10, TimeUnit.SECONDS)
                                .setConstraints(
                                    Constraints.Builder()
                                        .setRequiredNetworkType(NetworkType.CONNECTED)
                                        .build()
                                )
                                .build()
                            )
                        }
                    }
                    Log.d(TAG, "a worker has finished and scheduled next work after ${mapRotation.battle_royale.current.remainingSecs} seconds.")
                }
            }
        }.onFailure { exception ->
            Log.d(TAG, "doWork: $exception")
            return Result.failure()
        }
        return Result.success()
    }
}

private const val TAG = "SubscriptionWorker"