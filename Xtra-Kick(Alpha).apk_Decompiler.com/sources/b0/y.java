package b0;

import android.app.Notification;
import android.content.Context;
import android.support.v4.media.h;
import androidx.activity.b;

public final class y {
    private y() {
    }

    public static Notification.Builder a(Context context, String str) {
        h.C();
        return b.h(context, str);
    }

    public static Notification.Builder b(Notification.Builder builder, int i10) {
        return builder.setBadgeIconType(i10);
    }

    public static Notification.Builder c(Notification.Builder builder, boolean z10) {
        return builder.setColorized(z10);
    }

    public static Notification.Builder d(Notification.Builder builder, int i10) {
        return builder.setGroupAlertBehavior(i10);
    }

    public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSettingsText(charSequence);
    }

    public static Notification.Builder f(Notification.Builder builder, String str) {
        return builder.setShortcutId(str);
    }

    public static Notification.Builder g(Notification.Builder builder, long j10) {
        return builder.setTimeoutAfter(j10);
    }
}
