package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickMessage
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.Executors

@RunWith(RobolectricTestRunner::class)
@Config(application = android.app.Application::class)
class KickModerationTargetIdTest {

    private val json = Json { ignoreUnknownKeys = true }
    private lateinit var kickRepository: KickRepository

    @Before
    fun setUp() {
        val context = RuntimeEnvironment.getApplication()
        val okHttpClient = OkHttpClient()
        val executor = Executors.newSingleThreadExecutor()
        val authRepository = AuthRepository(
            httpEngine = null,
            cronetEngine = null,
            cronetExecutor = executor,
            okHttpClient = okHttpClient,
            json = json,
        )
        val kickOfficialApiClient = KickOfficialApiClient(
            context = context,
            okHttpClient = okHttpClient,
            json = json,
        )
        kickRepository = KickRepository(
            context = context,
            okHttpClient = okHttpClient,
            cronetEngine = null,
            cronetExecutor = executor,
            json = json,
            authRepository = authRepository,
            kickOfficialApiClient = kickOfficialApiClient,
        )
    }

    @Test
    fun `extracts target message id from root message_id`() {
        val payload = """{"id": "event-999", "message_id": "target-msg-123"}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-123", targetId)
    }

    @Test
    fun `extracts target message id from root target_message_id`() {
        val payload = """{"id": "event-999", "target_message_id": "target-msg-456"}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-456", targetId)
    }

    @Test
    fun `extracts target message id from root target_id`() {
        val payload = """{"id": "event-999", "target_id": "target-msg-789"}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-789", targetId)
    }

    @Test
    fun `extracts target message id from root camelCase messageId`() {
        val payload = """{"id": "event-999", "messageId": "target-msg-101"}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-101", targetId)
    }

    @Test
    fun `extracts target message id from nested message object`() {
        val payload = """{"id": "event-999", "message": {"id": "target-msg-202", "content": "bad msg"}}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-202", targetId)
    }

    @Test
    fun `extracts target message id from nested deleted_message object`() {
        val payload = """{"id": "event-999", "deleted_message": {"id": "target-msg-303"}}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-303", targetId)
    }

    @Test
    fun `extracts target message id from nested target_message object`() {
        val payload = """{"id": "event-999", "target_message": {"id": "target-msg-404"}}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-404", targetId)
    }

    @Test
    fun `extracts target message id from nested data wrapper`() {
        val payload = """{"data": {"message": {"id": "target-msg-505"}}}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-505", targetId)
    }

    @Test
    fun `extracts target message id from stringified data wrapper`() {
        val payload = """{"data": "{\"message_id\": \"target-msg-606\"}"}"""
        val targetId = kickRepository.extractTargetMessageIdFromRawJson(payload)
        assertEquals("target-msg-606", targetId)
    }

    @Test
    fun `getKickModerationTargetMessageId prefers raw message_id over event id`() {
        val payload = """{"id": "event-action-id-999", "message_id": "actual-chat-msg-id-123"}"""
        val kickMsg = json.decodeFromString<KickMessage>(payload)
        val targetId = kickRepository.getKickModerationTargetMessageId(kickMsg, payload)
        assertEquals("actual-chat-msg-id-123", targetId)
    }

    @Test
    fun `getKickModerationTargetMessageId prefers nested message id over event id`() {
        val payload = """{"id": "event-action-id-999", "message": {"id": "actual-chat-msg-id-456"}}"""
        val kickMsg = KickMessage(id = "event-action-id-999")
        val targetId = kickRepository.getKickModerationTargetMessageId(kickMsg, payload)
        assertEquals("actual-chat-msg-id-456", targetId)
    }

    @Test
    fun `getKickModerationTargetMessageId falls back to message id when payload has no distinct message id`() {
        val payload = """{"id": "only-id-789"}"""
        val kickMsg = json.decodeFromString<KickMessage>(payload)
        val targetId = kickRepository.getKickModerationTargetMessageId(kickMsg, payload)
        assertEquals("only-id-789", targetId)
    }

    @Test
    fun `getKickModerationTargetMessageId decodes new KickMessage fields`() {
        val payload = """{"message_id": "direct-message-id", "target_id": "direct-target-id"}"""
        val kickMsg = json.decodeFromString<KickMessage>(payload)
        assertEquals("direct-message-id", kickMsg.messageId)
        assertEquals("direct-target-id", kickMsg.targetId)
    }
}
