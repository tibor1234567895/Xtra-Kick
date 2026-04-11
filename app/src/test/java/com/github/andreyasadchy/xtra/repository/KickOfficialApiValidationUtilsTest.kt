package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickEventSubscriptionRequestItem
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardCreateRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardUpdateRequest
import org.junit.Assert.assertThrows
import org.junit.Test

class KickOfficialApiValidationUtilsTest {

    @Test
    fun validateCreateRewardRejectsLongTitle() {
        assertThrows(IllegalArgumentException::class.java) {
            KickOfficialApiValidationUtils.validateCreateReward(
                KickOfficialRewardCreateRequest(
                    title = "x".repeat(KickOfficialApiValidationUtils.REWARD_TITLE_MAX_LENGTH + 1),
                    cost = 1,
                )
            )
        }
    }

    @Test
    fun validateCreateRewardRejectsLowCost() {
        assertThrows(IllegalArgumentException::class.java) {
            KickOfficialApiValidationUtils.validateCreateReward(
                KickOfficialRewardCreateRequest(
                    title = "Song request",
                    cost = 0,
                )
            )
        }
    }

    @Test
    fun validateUpdateRewardRequiresAtLeastOneField() {
        assertThrows(IllegalArgumentException::class.java) {
            KickOfficialApiValidationUtils.validateUpdateReward(KickOfficialRewardUpdateRequest())
        }
    }

    @Test
    fun validateRedemptionIdsRejectsDuplicates() {
        assertThrows(IllegalArgumentException::class.java) {
            KickOfficialApiValidationUtils.validateRedemptionActionIds(
                listOf("abc", "abc")
            )
        }
    }

    @Test
    fun validateEventSubscriptionCreateRejectsUnknownEvents() {
        assertThrows(IllegalArgumentException::class.java) {
            KickOfficialApiValidationUtils.validateEventSubscriptionCreate(
                listOf(KickEventSubscriptionRequestItem(name = "unknown.event"))
            )
        }
    }
}
