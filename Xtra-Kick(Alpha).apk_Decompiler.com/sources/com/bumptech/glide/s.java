package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import androidx.activity.h;
import c0.g;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.d0;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.manager.u;
import com.bumptech.glide.manager.v;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import o5.e;
import s5.f;

public class s implements ComponentCallbacks2, m {

    /* renamed from: r  reason: collision with root package name */
    public static final f f3307r = ((f) ((f) new f().e(Bitmap.class)).i());

    /* renamed from: h  reason: collision with root package name */
    public final c f3308h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f3309i;

    /* renamed from: j  reason: collision with root package name */
    public final l f3310j;

    /* renamed from: k  reason: collision with root package name */
    public final v f3311k;

    /* renamed from: l  reason: collision with root package name */
    public final u f3312l;

    /* renamed from: m  reason: collision with root package name */
    public final d0 f3313m = new d0();

    /* renamed from: n  reason: collision with root package name */
    public final h f3314n;

    /* renamed from: o  reason: collision with root package name */
    public final d f3315o;

    /* renamed from: p  reason: collision with root package name */
    public final CopyOnWriteArrayList f3316p;

    /* renamed from: q  reason: collision with root package name */
    public f f3317q;

    static {
        f fVar = (f) ((f) new f().e(e.class)).i();
        f fVar2 = (f) ((f) ((f) new f().f(d5.u.f4492b)).o()).s(true);
    }

    public s(c cVar, l lVar, u uVar, Context context) {
        boolean z10;
        d dVar;
        v vVar = new v();
        com.bumptech.glide.manager.f fVar = cVar.f3169m;
        h hVar = new h(14, this);
        this.f3314n = hVar;
        this.f3308h = cVar;
        this.f3310j = lVar;
        this.f3312l = uVar;
        this.f3311k = vVar;
        this.f3309i = context;
        Context applicationContext = context.getApplicationContext();
        r rVar = new r(this, vVar);
        fVar.getClass();
        boolean z11 = false;
        if (g.a(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.isLoggable("ConnectivityMonitor", 3);
        if (z10) {
            dVar = new com.bumptech.glide.manager.e(applicationContext, rVar);
        } else {
            dVar = new p();
        }
        this.f3315o = dVar;
        synchronized (cVar.f3170n) {
            if (!cVar.f3170n.contains(this)) {
                cVar.f3170n.add(this);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
        char[] cArr = w5.p.f16126a;
        if (!(Looper.myLooper() == Looper.getMainLooper() ? true : z11)) {
            w5.p.e().post(hVar);
        } else {
            lVar.c(this);
        }
        lVar.c(dVar);
        this.f3316p = new CopyOnWriteArrayList(cVar.f3166j.f3192e);
        s(cVar.f3166j.a());
    }

    public final synchronized void c() {
        q();
        this.f3313m.c();
    }

    public final synchronized void j() {
        r();
        this.f3313m.j();
    }

    public final synchronized void k() {
        this.f3313m.k();
        Iterator it = w5.p.d(this.f3313m.f3263h).iterator();
        while (it.hasNext()) {
            o((t5.g) it.next());
        }
        this.f3313m.f3263h.clear();
        v vVar = this.f3311k;
        Iterator it2 = w5.p.d(vVar.f3284a).iterator();
        while (it2.hasNext()) {
            vVar.a((s5.d) it2.next());
        }
        vVar.f3285b.clear();
        this.f3310j.h(this);
        this.f3310j.h(this.f3315o);
        w5.p.e().removeCallbacks(this.f3314n);
        this.f3308h.d(this);
    }

    public q l(Class cls) {
        return new q(this.f3308h, this, cls, this.f3309i);
    }

    public q m() {
        return l(Bitmap.class).a(f3307r);
    }

    public q n() {
        return l(Drawable.class);
    }

    public final void o(t5.g gVar) {
        boolean z10;
        if (gVar != null) {
            boolean t10 = t(gVar);
            s5.d h10 = gVar.h();
            if (!t10) {
                c cVar = this.f3308h;
                synchronized (cVar.f3170n) {
                    Iterator it = cVar.f3170n.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((s) it.next()).t(gVar)) {
                                z10 = true;
                                break;
                            }
                        } else {
                            z10 = false;
                            break;
                        }
                    }
                }
                if (!z10 && h10 != null) {
                    gVar.a((s5.d) null);
                    h10.clear();
                }
            }
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i10) {
    }

    public q p(String str) {
        return n().F(str);
    }

    public final synchronized void q() {
        v vVar = this.f3311k;
        vVar.f3286c = true;
        Iterator it = w5.p.d(vVar.f3284a).iterator();
        while (it.hasNext()) {
            s5.d dVar = (s5.d) it.next();
            if (dVar.isRunning()) {
                dVar.g();
                vVar.f3285b.add(dVar);
            }
        }
    }

    public final synchronized void r() {
        v vVar = this.f3311k;
        vVar.f3286c = false;
        Iterator it = w5.p.d(vVar.f3284a).iterator();
        while (it.hasNext()) {
            s5.d dVar = (s5.d) it.next();
            if (!dVar.j() && !dVar.isRunning()) {
                dVar.e();
            }
        }
        vVar.f3285b.clear();
    }

    public synchronized void s(f fVar) {
        this.f3317q = (f) ((f) fVar.clone()).b();
    }

    public final synchronized boolean t(t5.g gVar) {
        s5.d h10 = gVar.h();
        if (h10 == null) {
            return true;
        }
        if (!this.f3311k.a(h10)) {
            return false;
        }
        this.f3313m.f3263h.remove(gVar);
        gVar.a((s5.d) null);
        return true;
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f3311k + ", treeNode=" + this.f3312l + "}";
    }
}
