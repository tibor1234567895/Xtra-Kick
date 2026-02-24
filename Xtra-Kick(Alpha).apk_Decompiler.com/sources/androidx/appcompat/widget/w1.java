package androidx.appcompat.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.SharedElementCallback;
import android.graphics.drawable.Icon;

public abstract /* synthetic */ class w1 {
    public static /* synthetic */ Notification.Action.Builder f(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(icon, charSequence, pendingIntent);
    }

    public static /* bridge */ /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener h(Object obj) {
        return (SharedElementCallback.OnSharedElementsReadyListener) obj;
    }

    public static /* bridge */ /* synthetic */ Icon j(Object obj) {
        return (Icon) obj;
    }
}
