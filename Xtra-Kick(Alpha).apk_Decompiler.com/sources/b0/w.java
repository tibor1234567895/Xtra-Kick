package b0;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.support.v4.media.h;
import androidx.appcompat.widget.w1;

public final class w {
    private w() {
    }

    public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        h.A();
        return w1.f(icon, charSequence, pendingIntent);
    }

    public static Notification.Builder b(Notification.Builder builder, Object obj) {
        return builder.setSmallIcon(w1.j(obj));
    }
}
