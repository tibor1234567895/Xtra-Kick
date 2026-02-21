package b0;

import android.app.Notification;

public final class r {
    private r() {
    }

    public static Notification a(Notification.Builder builder) {
        return builder.build();
    }

    public static Notification.Builder b(Notification.Builder builder, int i10) {
        return builder.setPriority(i10);
    }

    public static Notification.Builder c(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSubText(charSequence);
    }

    public static Notification.Builder d(Notification.Builder builder, boolean z10) {
        return builder.setUsesChronometer(z10);
    }
}
