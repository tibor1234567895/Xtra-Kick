package b0;

import android.app.Notification;

public final class s {
    private s() {
    }

    public static Notification.Builder a(Notification.Builder builder, boolean z10) {
        return builder.setShowWhen(z10);
    }
}
