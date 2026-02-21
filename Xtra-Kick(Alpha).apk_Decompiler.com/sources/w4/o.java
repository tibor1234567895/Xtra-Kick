package w4;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import i4.t;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import la.e;
import la.v;
import r4.f;
import r4.g;
import r4.h;
import r4.j;

public final class o implements ComponentCallbacks2, g {

    /* renamed from: h  reason: collision with root package name */
    public final Context f16098h;

    /* renamed from: i  reason: collision with root package name */
    public final WeakReference f16099i;

    /* renamed from: j  reason: collision with root package name */
    public final h f16100j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f16101k;

    /* renamed from: l  reason: collision with root package name */
    public final AtomicBoolean f16102l;

    static {
        new n(0);
    }

    public o(t tVar, Context context, boolean z10) {
        h hVar;
        boolean z11;
        this.f16098h = context;
        this.f16099i = new WeakReference(tVar);
        if (z10) {
            tVar.getClass();
            ConnectivityManager connectivityManager = (ConnectivityManager) c0.g.d(context, ConnectivityManager.class);
            if (connectivityManager != null) {
                if (c0.g.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    try {
                        hVar = new j(connectivityManager, this);
                    } catch (Exception unused) {
                        hVar = new f();
                    }
                }
            }
            hVar = new f();
        } else {
            hVar = new f();
        }
        this.f16100j = hVar;
        this.f16101k = hVar.a();
        this.f16102l = new AtomicBoolean(false);
    }

    public final void a() {
        if (!this.f16102l.getAndSet(true)) {
            this.f16098h.unregisterComponentCallbacks(this);
            this.f16100j.shutdown();
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (((t) this.f16099i.get()) == null) {
            a();
            v vVar = v.f9814a;
        }
    }

    public final void onLowMemory() {
        onTrimMemory(80);
    }

    public final void onTrimMemory(int i10) {
        v vVar;
        q4.h hVar;
        t tVar = (t) this.f16099i.get();
        if (tVar != null) {
            e eVar = tVar.f8273b;
            if (!(eVar == null || (hVar = (q4.h) eVar.getValue()) == null)) {
                hVar.f13331a.a(i10);
                hVar.f13332b.a(i10);
            }
            vVar = v.f9814a;
        } else {
            vVar = null;
        }
        if (vVar == null) {
            a();
        }
    }
}
