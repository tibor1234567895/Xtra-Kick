package com.xtrakick.app.ui.settings

import android.app.Application
import android.content.ContextWrapper
import android.os.Looper
import androidx.fragment.app.FragmentActivity
import com.xtrakick.app.R
import com.xtrakick.app.db.MutedChatUsersDao
import com.xtrakick.app.model.ui.MutedChatUser
import com.xtrakick.app.repository.AuthRepository
import com.xtrakick.app.repository.KickAccountMutedUsersStore
import com.xtrakick.app.repository.KickOfficialApiClient
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.MutedChatUsersRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.util.ReflectionHelpers
import org.robolectric.util.ReflectionHelpers.ClassParameter
import java.io.IOException
import java.util.concurrent.Executors

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class MutedUsersDialogTest {
    @Test
    fun localUserWithoutAnIdCanBeUnmuted() = verifyLocalUnmute(null)

    @Test
    fun localUnmuteDoesNotRemoveAnAccountMuteWithTheSameId() = verifyLocalUnmute("123")

    private fun verifyLocalUnmute(id: String?) = runBlocking {
        val context = RuntimeEnvironment.getApplication()
        val executor = Executors.newSingleThreadExecutor()
        val client = OkHttpClient.Builder().addInterceptor { throw IOException("No account session") }.build()
        val json = Json { ignoreUnknownKeys = true }
        val auth = AuthRepository(null, null, executor, client, json)
        val kick = KickRepository(context, client, null, executor, json, auth, KickOfficialApiClient(context, client, json))
        val accountMutes = KickAccountMutedUsersStore(kick).apply { onAccountMuteApplied("123", "testuser") }
        val dao = LocalMutes().apply { insert(MutedChatUser(id, "testuser", "testuser")) }
        val activity = Robolectric.buildActivity(FragmentActivity::class.java)
        activity.get().setTheme(R.style.BaseDarkTheme)
        activity.setup()
        val dialog = MutedUsersDialog().apply {
            ReflectionHelpers.setField(this, "injected", true)
            ReflectionHelpers.setField(this, "componentContext", ContextWrapper(activity.get()))
            kickRepository = kick
            kickAccountMutedUsersStore = accountMutes
            mutedChatUsersRepository = MutedChatUsersRepository(dao)
        }
        try {
            dialog.showNow(activity.get().supportFragmentManager, "muted")
            ReflectionHelpers.callInstanceMethod<Unit>(
                dialog, "unmuteUser",
                ClassParameter.from(
                    MutedUsersDialog.MutedUserRow.User::class.java,
                    MutedUsersDialog.MutedUserRow.User(id, "testuser", onKickAccount = false),
                ),
            )
            withTimeout(5000) {
                while (dao.rows.value.isNotEmpty() || ReflectionHelpers.getField<Boolean>(dialog, "unmuteInFlight")) {
                    shadowOf(Looper.getMainLooper()).idle()
                    delay(10)
                }
            }

            assertEquals("123", accountMutes.users.value.single().id)
            assertFalse(ReflectionHelpers.getField(dialog, "unmuteInFlight"))
        } finally {
            dialog.dismissNow()
            activity.pause().stop().destroy()
            executor.shutdownNow()
        }
    }

    private class LocalMutes : MutedChatUsersDao {
        val rows = MutableStateFlow<List<MutedChatUser>>(emptyList())
        override fun getAllFlow() = rows
        override fun getByUserIdOrLoginOrName(userId: String?, userLogin: String?, userName: String?) = rows.value.filter {
            (userId != null && it.userId == userId) || (userLogin != null && it.userLogin == userLogin) ||
                (userName != null && it.userName == userName)
        }
        override fun insert(item: MutedChatUser) {
            rows.value += item
        }
        override fun delete(item: MutedChatUser) {
            rows.value -= item
        }
        override fun update(item: MutedChatUser) = Unit
    }
}
