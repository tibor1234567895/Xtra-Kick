package com.xtrakick.app.ui.player

import com.xtrakick.app.R
import org.junit.Assert.assertEquals
import org.junit.Test

class PlayerVolumeDialogTest {

    @Test
    fun getVolumeIconRes_integerPercent_mapsCorrectly() {
        assertEquals(R.drawable.baseline_volume_off_black_24, PlayerVolumeDialog.getVolumeIconRes(-5))
        assertEquals(R.drawable.baseline_volume_off_black_24, PlayerVolumeDialog.getVolumeIconRes(0))

        assertEquals(R.drawable.ic_volume_low, PlayerVolumeDialog.getVolumeIconRes(1))
        assertEquals(R.drawable.ic_volume_low, PlayerVolumeDialog.getVolumeIconRes(15))
        assertEquals(R.drawable.ic_volume_low, PlayerVolumeDialog.getVolumeIconRes(33))

        assertEquals(R.drawable.ic_volume_medium, PlayerVolumeDialog.getVolumeIconRes(34))
        assertEquals(R.drawable.ic_volume_medium, PlayerVolumeDialog.getVolumeIconRes(50))
        assertEquals(R.drawable.ic_volume_medium, PlayerVolumeDialog.getVolumeIconRes(66))

        assertEquals(R.drawable.ic_volume_high, PlayerVolumeDialog.getVolumeIconRes(67))
        assertEquals(R.drawable.ic_volume_high, PlayerVolumeDialog.getVolumeIconRes(80))
        assertEquals(R.drawable.ic_volume_high, PlayerVolumeDialog.getVolumeIconRes(100))
        assertEquals(R.drawable.ic_volume_high, PlayerVolumeDialog.getVolumeIconRes(150))
    }

    @Test
    fun getVolumeIconRes_floatFraction_mapsCorrectly() {
        assertEquals(R.drawable.baseline_volume_off_black_24, PlayerVolumeDialog.getVolumeIconRes(0f))
        assertEquals(R.drawable.ic_volume_low, PlayerVolumeDialog.getVolumeIconRes(0.2f))
        assertEquals(R.drawable.ic_volume_medium, PlayerVolumeDialog.getVolumeIconRes(0.5f))
        assertEquals(R.drawable.ic_volume_high, PlayerVolumeDialog.getVolumeIconRes(1.0f))
    }
}
