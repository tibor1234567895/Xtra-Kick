package b0;

import android.app.Notification;

public final class c0 {
    private c0() {
    }

    public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
        return builder.setAuthenticationRequired(z10);
    }

    public static Notification.Builder b(Notification.Builder builder, int i10) {
        return builder.setForegroundServiceBehavior(i10);
    }
}
