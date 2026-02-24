package h3;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.z;
import g1.k1;
import g1.t0;
import java.util.HashMap;

public final class g2 {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f7045b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap f7046c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final n2 f7047a;

    static {
        t0.a("media3.session");
    }

    public g2(Context context, String str, k1 k1Var, PendingIntent pendingIntent, b2 b2Var, Bundle bundle, a aVar) {
        String str2 = str;
        synchronized (f7045b) {
            HashMap hashMap = f7046c;
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, this);
            } else {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
        }
        this.f7047a = new n2(this, context, str, k1Var, pendingIntent, b2Var, bundle, aVar);
    }

    public final IBinder a() {
        c3 c3Var;
        n2 n2Var = this.f7047a;
        synchronized (n2Var.f7228a) {
            try {
                if (n2Var.f7247t == null) {
                    MediaSessionCompat$Token h10 = ((z) n2Var.f7237j.f7047a.f7234g.f7442l.f428i).h();
                    c3 c3Var2 = new c3(n2Var);
                    c3Var2.c(h10);
                    n2Var.f7247t = c3Var2;
                }
                c3Var = n2Var.f7247t;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return c3Var.onBind(new Intent("android.media.browse.MediaBrowserService"));
    }

    public final k1 b() {
        return this.f7047a.f7246s.f6334a;
    }
}
