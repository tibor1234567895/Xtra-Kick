package h3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import f0.g;
import j1.l0;

public final class j {
    private j() {
    }

    public static void a(NotificationManager notificationManager, String str, String str2) {
        g.r();
        NotificationChannel c10 = g.c(str, str2);
        if (l0.f8453a <= 27) {
            c10.setShowBadge(false);
        }
        notificationManager.createNotificationChannel(c10);
    }
}
