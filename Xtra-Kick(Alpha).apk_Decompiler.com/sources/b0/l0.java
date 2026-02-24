package b0;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

public final class l0 {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f2370c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static String f2371d;

    /* renamed from: e  reason: collision with root package name */
    public static HashSet f2372e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static final Object f2373f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static j0 f2374g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2375a;

    /* renamed from: b  reason: collision with root package name */
    public final NotificationManager f2376b;

    public l0(Context context) {
        this.f2375a = context;
        this.f2376b = (NotificationManager) context.getSystemService("notification");
    }

    public final void a(int i10, Notification notification) {
        boolean z10;
        Bundle bundle = notification.extras;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            z10 = false;
        } else {
            z10 = true;
        }
        NotificationManager notificationManager = this.f2376b;
        if (z10) {
            g0 g0Var = new g0(this.f2375a.getPackageName(), i10, notification);
            synchronized (f2373f) {
                if (f2374g == null) {
                    f2374g = new j0(this.f2375a.getApplicationContext());
                }
                f2374g.f2365i.obtainMessage(0, g0Var).sendToTarget();
            }
            notificationManager.cancel((String) null, i10);
            return;
        }
        notificationManager.notify((String) null, i10, notification);
    }
}
