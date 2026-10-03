package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.KickGiftTrain
import com.xtrakick.app.model.chat.KickGiftTrainSnapshot
import java.util.Locale

/**
 * Merges consecutive gifted-subs events into banner trains. A new event from
 * the same gifter extends the train; the train expires [KickGiftTrain.displayDurationMs]
 * after its last event.
 */
class GiftTrainAggregator(
    private val maxTrains: Int = 3,
    private val maxGifteesPerTrain: Int = 50,
) {
    private val trains = LinkedHashMap<String, KickGiftTrain>()

    @Synchronized
    fun onGiftEvent(snapshot: KickGiftTrainSnapshot, nowMs: Long): List<KickGiftTrain> {
        pruneExpired(nowMs)
        val key = trainKey(snapshot)
        val existing = trains[key]
        trains[key] = if (existing == null) snapshot.toTrain(nowMs) else existing.mergedWith(snapshot, nowMs)
        while (trains.size > maxTrains) {
            val oldest = trains.entries.minByOrNull { it.value.lastUpdatedAtMs } ?: break
            trains.remove(oldest.key)
        }
        return active(nowMs)
    }

    @Synchronized
    fun prune(nowMs: Long): List<KickGiftTrain> {
        pruneExpired(nowMs)
        return active(nowMs)
    }

    @Synchronized
    fun clear() {
        trains.clear()
    }

    private fun active(nowMs: Long): List<KickGiftTrain> =
        trains.values.filter { nowMs < it.lastUpdatedAtMs + it.displayDurationMs }

    private fun pruneExpired(nowMs: Long) {
        trains.values.removeAll { nowMs >= it.lastUpdatedAtMs + it.displayDurationMs }
    }

    private fun trainKey(snapshot: KickGiftTrainSnapshot): String =
        snapshot.gifterName?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotEmpty() } ?: ANONYMOUS_KEY

    private fun KickGiftTrainSnapshot.toTrain(nowMs: Long): KickGiftTrain = KickGiftTrain(
        gifterName = gifterName?.trim()?.takeIf { it.isNotEmpty() },
        giftees = giftees.distinctBy { it.lowercase(Locale.ROOT) }.take(maxGifteesPerTrain),
        totalGifted = totalGifted ?: giftees.size.coerceAtLeast(1),
        lastUpdatedAtMs = nowMs,
    )

    private fun KickGiftTrain.mergedWith(snapshot: KickGiftTrainSnapshot, nowMs: Long): KickGiftTrain {
        val giftees = LinkedHashMap<String, String>()
        this.giftees.forEach { giftees[it.lowercase(Locale.ROOT)] = it }
        snapshot.giftees.forEach { name ->
            val key = name.lowercase(Locale.ROOT)
            if (!giftees.containsKey(key) && giftees.size < maxGifteesPerTrain) {
                giftees[key] = name
            }
        }
        return copy(
            giftees = giftees.values.toList(),
            totalGifted = totalGifted + (snapshot.totalGifted ?: snapshot.giftees.size.coerceAtLeast(1)),
            lastUpdatedAtMs = nowMs,
        )
    }

    companion object {
        private const val ANONYMOUS_KEY = "\u0000anonymous"
    }
}
