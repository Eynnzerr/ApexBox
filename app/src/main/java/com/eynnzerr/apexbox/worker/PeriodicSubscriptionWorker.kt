package com.eynnzerr.apexbox.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.eynnzerr.apexbox.data.repository.AppRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class PeriodicSubscriptionWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted val workerParams: WorkerParameters,
    private val repository: AppRepository
): CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
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
                    }
                }
            }
        }.onFailure { exception ->
            Log.d(TAG, "doWork: $exception")
            return Result.failure()
        }
        return Result.success()
    }


}

private const val TAG = "PeriodicSubscriptionWor"