package com.xtrakick.app.ui.main

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

/**
 * Central WorkManager wiring for reward claiming so MainActivity, SettingsActivity and the
 * worker itself share one set of unique-work names and constraints.
 */
internal object RewardClaimScheduler {

    private const val MIN_FOLLOW_UP_MS = 90_000L
    private const val MAX_FOLLOW_UP_MS = 6 * 60 * 60_000L

    /** Idempotently installs the 15-minute periodic check plus an immediate first pass. */
    fun enable(context: Context) {
        val workManager = WorkManager.getInstance(context)
        workManager.enqueueUniquePeriodicWork(
            RewardClaimWorker.PERIODIC_WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequestBuilder<RewardClaimWorker>(15, TimeUnit.MINUTES)
                .setConstraints(networkConstraints())
                .build(),
        )
        workManager.enqueueUniqueWork(
            RewardClaimWorker.ONESHOT_WORK_NAME,
            ExistingWorkPolicy.KEEP,
            OneTimeWorkRequestBuilder<RewardClaimWorker>()
                .setConstraints(networkConstraints())
                .build(),
        )
    }

    fun disable(context: Context) {
        val workManager = WorkManager.getInstance(context)
        workManager.cancelUniqueWork(RewardClaimWorker.PERIODIC_WORK_NAME)
        workManager.cancelUniqueWork(RewardClaimWorker.ONESHOT_WORK_NAME)
    }

    /** Adaptive wake-up between runs, mirroring the userscript scheduler; clamped 90 s … 6 h. */
    fun followUp(context: Context, delayMillis: Long) {
        val clamped = delayMillis.coerceIn(MIN_FOLLOW_UP_MS, MAX_FOLLOW_UP_MS)
        WorkManager.getInstance(context).enqueueUniqueWork(
            RewardClaimWorker.ONESHOT_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequestBuilder<RewardClaimWorker>()
                .setInitialDelay(clamped, TimeUnit.MILLISECONDS)
                .setConstraints(networkConstraints())
                .build(),
        )
    }

    private fun networkConstraints() = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()
}