package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.KickGiftTrainSnapshot
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GiftTrainAggregatorTest {

    private val aggregator = GiftTrainAggregator()
    private val snapshot = KickGiftTrainSnapshot(gifterName = "rembbu", giftees = listOf("kkosu", "CJPJAM", "itnog"))

    @Test
    fun sameGifterEventsMergeIntoOneTrain() {
        aggregator.onGiftEvent(snapshot, nowMs = 0)
        val trains = aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "Rembbu", giftees = listOf("kkosu", "porkneck")),
            nowMs = 5_000L,
        )
        assertEquals(1, trains.size)
        val train = trains.single()
        assertEquals("rembbu", train.gifterName)
        assertEquals(listOf("kkosu", "CJPJAM", "itnog", "porkneck"), train.giftees)
        assertEquals(5, train.totalGifted)
    }

    @Test
    fun distinctGiftersCreateSeparateTrains() {
        aggregator.onGiftEvent(snapshot, nowMs = 0)
        val trains = aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "llnahiara", giftees = listOf("aayush_mb")),
            nowMs = 1_000L,
        )
        assertEquals(2, trains.size)
    }

    @Test
    fun trainExpiresAfterDuration() {
        val train = aggregator.onGiftEvent(snapshot, nowMs = 0).single()
        assertTrue(aggregator.prune(1_000L).isNotEmpty())
        assertTrue(aggregator.prune(train.displayDurationMs).isEmpty())
    }

    @Test
    fun bannerDurationScalesWithGiftCount() {
        val single = aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "rembbu", giftees = listOf("kkosu")),
            nowMs = 0,
        ).single()
        val mass = aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "llnahiara", giftees = List(25) { "viewer$it" }),
            nowMs = 0,
        ).last { it.gifterName == "llnahiara" }
        assertEquals(5_000L, single.displayDurationMs)
        assertEquals(29_000L, mass.displayDurationMs)
        assertTrue(mass.displayDurationMs > single.displayDurationMs)
    }

    @Test
    fun newEventExtendsExpiry() {
        aggregator.onGiftEvent(snapshot, nowMs = 0)
        aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "rembbu", giftees = listOf("Mrchow289", "jormas23", "aayush_mb", "porkneck", "ftschrissy")),
            nowMs = 5_000L,
        )
        val train = aggregator.prune(0).single()
        assertEquals(8, train.totalGifted)
        assertTrue(aggregator.prune(10_000L).isNotEmpty())
        assertTrue(aggregator.prune(5_000L + train.displayDurationMs).isEmpty())
    }

    @Test
    fun gifteeListDedupesAndCaps() {
        val capped = GiftTrainAggregator(maxGifteesPerTrain = 3)
        val trains = capped.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "rembbu", giftees = listOf("a", "b", "a", "c", "d")),
            nowMs = 0,
        )
        assertEquals(listOf("a", "b", "c"), trains.single().giftees)
        assertEquals(5, trains.single().totalGifted)
    }

    @Test
    fun anonymousGifterStillProducesTrain() {
        val trains = aggregator.onGiftEvent(KickGiftTrainSnapshot(gifterName = null, totalGifted = 10), nowMs = 0)
        assertEquals(1, trains.size)
        assertEquals(10, trains.single().totalGifted)
    }

    @Test
    fun overlappingGiftersStaySeparateTrains() {
        aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "rembbu", giftees = listOf("a", "b")),
            nowMs = 0,
        )
        aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "llnahiara", giftees = listOf("c")),
            nowMs = 1_000,
        )
        val trains = aggregator.prune(1_000)
        assertEquals(2, trains.size)
        assertEquals(setOf("rembbu", "llnahiara"), trains.mapNotNull { it.gifterName }.toSet())
    }

    @Test
    fun newerTrainShowsFirstOlderResurfacesWhenItExpires() {
        aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "big", giftees = List(25) { "viewer$it" }),
            nowMs = 0,
        )
        aggregator.onGiftEvent(
            KickGiftTrainSnapshot(gifterName = "small", giftees = listOf("x")),
            nowMs = 3_000,
        )
        assertEquals("small", aggregator.prune(3_000).maxByOrNull { it.lastUpdatedAtMs }?.gifterName)
        val afterSmallExpires = aggregator.prune(8_000)
        assertEquals(1, afterSmallExpires.size)
        assertEquals("big", afterSmallExpires.single().gifterName)
    }

    @Test
    fun maxTrainsEvictsLeastRecentlyUpdated() {
        val capped = GiftTrainAggregator(maxTrains = 2)
        capped.onGiftEvent(KickGiftTrainSnapshot(gifterName = "a", giftees = listOf("a1")), nowMs = 0)
        capped.onGiftEvent(KickGiftTrainSnapshot(gifterName = "b", giftees = listOf("b1")), nowMs = 1_000)
        capped.onGiftEvent(KickGiftTrainSnapshot(gifterName = "a", giftees = listOf("a2")), nowMs = 2_000)
        val trains = capped.onGiftEvent(KickGiftTrainSnapshot(gifterName = "c", giftees = listOf("c1")), nowMs = 3_000)
        assertEquals(listOf("a", "c"), trains.mapNotNull { it.gifterName })
    }

    @Test
    fun clearDropsAllTrains() {
        aggregator.onGiftEvent(snapshot, nowMs = 0)
        aggregator.clear()
        assertTrue(aggregator.prune(0).isEmpty())
    }
}
