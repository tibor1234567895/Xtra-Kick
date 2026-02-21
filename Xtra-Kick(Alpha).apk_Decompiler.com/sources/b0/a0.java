package b0;

import a4.a;
import android.app.Notification;

public final class a0 {
    private a0() {
    }

    public static Notification.Builder a(Notification.Builder builder, boolean z10) {
        return builder.setAllowSystemGeneratedContextualActions(z10);
    }

    public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
        return builder.setBubbleMetadata(bubbleMetadata);
    }

    public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
        return builder.setContextual(z10);
    }

    public static Notification.Builder d(Notification.Builder builder, Object obj) {
        return builder.setLocusId(a.g(obj));
    }
}
