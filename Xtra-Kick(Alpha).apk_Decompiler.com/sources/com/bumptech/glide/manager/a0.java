package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import d5.v;
import g.g0;
import java.util.concurrent.Executor;
import w5.h;

public final class a0 implements x {

    /* renamed from: n  reason: collision with root package name */
    public static final Executor f3248n = AsyncTask.SERIAL_EXECUTOR;

    /* renamed from: h  reason: collision with root package name */
    public final Context f3249h;

    /* renamed from: i  reason: collision with root package name */
    public final c f3250i;

    /* renamed from: j  reason: collision with root package name */
    public final h f3251j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f3252k;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f3253l;

    /* renamed from: m  reason: collision with root package name */
    public final g0 f3254m = new g0(4, this);

    public a0(Context context, v vVar, w wVar) {
        this.f3249h = context.getApplicationContext();
        this.f3251j = vVar;
        this.f3250i = wVar;
    }

    public final void a() {
        f3248n.execute(new z(this, 1));
    }

    public final boolean b() {
        f3248n.execute(new z(this, 0));
        return true;
    }

    public final boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3251j.get()).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e10) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e10);
            }
            return true;
        }
    }
}
