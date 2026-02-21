package com.github.andreyasadchy.xtra;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y0;
import b6.b;
import b6.c;
import com.github.andreyasadchy.xtra.util.AppLifecycleObserver;
import y5.n;
import y5.v;

public final class XtraApp extends n implements i4.n {

    /* renamed from: k  reason: collision with root package name */
    public static final v f3319k = new v(0);

    /* renamed from: l  reason: collision with root package name */
    public static Application f3320l;

    /* renamed from: j  reason: collision with root package name */
    public final AppLifecycleObserver f3321j = new AppLifecycleObserver();

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void onCreate() {
        super.onCreate();
        f3319k.getClass();
        f3320l = this;
        c.f2640a.getClass();
        registerActivityLifecycleCallbacks(new b(this));
        y0.f1792p.getClass();
        y0.f1793q.f1799m.a(this.f3321j);
    }
}
