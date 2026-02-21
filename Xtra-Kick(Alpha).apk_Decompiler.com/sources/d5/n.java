package d5;

import android.os.Build;
import android.os.SystemClock;
import android.support.v4.media.session.u;
import android.util.Log;
import b5.a;
import b5.j;
import b5.m;
import com.bumptech.glide.load.data.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import k5.w;
import l0.d;
import w5.b;
import w5.i;
import x5.e;
import x5.h;

public final class n implements g, Runnable, Comparable, e {
    public Object A;
    public Thread B;
    public j C;
    public j D;
    public Object E;
    public a F;
    public com.bumptech.glide.load.data.e G;
    public volatile h H;
    public volatile boolean I;
    public volatile boolean J;
    public boolean K;
    public int L;

    /* renamed from: h  reason: collision with root package name */
    public final i f4434h = new i();

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f4435i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final h f4436j = new h();

    /* renamed from: k  reason: collision with root package name */
    public final v f4437k;

    /* renamed from: l  reason: collision with root package name */
    public final d f4438l;

    /* renamed from: m  reason: collision with root package name */
    public final k f4439m = new k();

    /* renamed from: n  reason: collision with root package name */
    public final l f4440n = new l();

    /* renamed from: o  reason: collision with root package name */
    public com.bumptech.glide.h f4441o;

    /* renamed from: p  reason: collision with root package name */
    public j f4442p;

    /* renamed from: q  reason: collision with root package name */
    public com.bumptech.glide.j f4443q;

    /* renamed from: r  reason: collision with root package name */
    public d0 f4444r;

    /* renamed from: s  reason: collision with root package name */
    public int f4445s;

    /* renamed from: t  reason: collision with root package name */
    public int f4446t;

    /* renamed from: u  reason: collision with root package name */
    public u f4447u;

    /* renamed from: v  reason: collision with root package name */
    public b5.n f4448v;

    /* renamed from: w  reason: collision with root package name */
    public j f4449w;

    /* renamed from: x  reason: collision with root package name */
    public int f4450x;

    /* renamed from: y  reason: collision with root package name */
    public m f4451y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f4452z;

    public n(v vVar, d dVar) {
        this.f4437k = vVar;
        this.f4438l = dVar;
    }

    public final void a(j jVar, Object obj, com.bumptech.glide.load.data.e eVar, a aVar, j jVar2) {
        this.C = jVar;
        this.E = obj;
        this.G = eVar;
        this.F = aVar;
        this.D = jVar2;
        boolean z10 = false;
        if (jVar != this.f4434h.a().get(0)) {
            z10 = true;
        }
        this.K = z10;
        if (Thread.currentThread() != this.B) {
            o(3);
        } else {
            g();
        }
    }

    public final void b() {
        o(2);
    }

    public final h c() {
        return this.f4436j;
    }

    public final int compareTo(Object obj) {
        n nVar = (n) obj;
        int ordinal = this.f4443q.ordinal() - nVar.f4443q.ordinal();
        if (ordinal == 0) {
            return this.f4450x - nVar.f4450x;
        }
        return ordinal;
    }

    public final void d(j jVar, Exception exc, com.bumptech.glide.load.data.e eVar, a aVar) {
        eVar.c();
        i0 i0Var = new i0("Fetching data failed", Collections.singletonList(exc));
        Class a10 = eVar.a();
        i0Var.f4412i = jVar;
        i0Var.f4413j = aVar;
        i0Var.f4414k = a10;
        this.f4435i.add(i0Var);
        if (Thread.currentThread() != this.B) {
            o(2);
        } else {
            p();
        }
    }

    public final o0 e(com.bumptech.glide.load.data.e eVar, Object obj, a aVar) {
        if (obj == null) {
            eVar.c();
            return null;
        }
        try {
            int i10 = i.f16115a;
            SystemClock.elapsedRealtimeNanos();
            o0 f10 = f(obj, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                f10.toString();
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(this.f4444r);
                Thread.currentThread().getName();
            }
            return f10;
        } finally {
            eVar.c();
        }
    }

    public final o0 f(Object obj, a aVar) {
        boolean z10;
        Class<?> cls = obj.getClass();
        i iVar = this.f4434h;
        l0 c10 = iVar.c(cls);
        b5.n nVar = this.f4448v;
        if (Build.VERSION.SDK_INT >= 26) {
            if (aVar == a.RESOURCE_DISK_CACHE || iVar.f4409r) {
                z10 = true;
            } else {
                z10 = false;
            }
            m mVar = w.f9187j;
            Boolean bool = (Boolean) nVar.c(mVar);
            if (bool == null || (bool.booleanValue() && !z10)) {
                nVar = new b5.n();
                b bVar = this.f4448v.f2635b;
                b bVar2 = nVar.f2635b;
                bVar2.i(bVar);
                bVar2.put(mVar, Boolean.valueOf(z10));
            }
        }
        b5.n nVar2 = nVar;
        g h10 = this.f4441o.b().h(obj);
        try {
            return c10.a(this.f4445s, this.f4446t, new android.support.v4.media.n((Object) this, (Object) aVar, 26), nVar2, h10);
        } finally {
            h10.c();
        }
    }

    public final void g() {
        o0 o0Var;
        boolean z10;
        k kVar;
        if (Log.isLoggable("DecodeJob", 2)) {
            String str = "data: " + this.E + ", cache key: " + this.C + ", fetcher: " + this.G;
            int i10 = i.f16115a;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(this.f4444r);
            if (str != null) {
                ", ".concat(str);
            }
            Thread.currentThread().getName();
        }
        n0 n0Var = null;
        try {
            o0Var = e(this.G, this.E, this.F);
        } catch (i0 e10) {
            j jVar = this.D;
            a aVar = this.F;
            e10.f4412i = jVar;
            e10.f4413j = aVar;
            e10.f4414k = null;
            this.f4435i.add(e10);
            o0Var = null;
        }
        if (o0Var != null) {
            a aVar2 = this.F;
            boolean z11 = this.K;
            if (o0Var instanceof j0) {
                ((j0) o0Var).a();
            }
            boolean z12 = true;
            if (this.f4439m.f4418c != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                n0Var = (n0) n0.f4453l.j();
                w5.n.b(n0Var);
                n0Var.f4457k = false;
                n0Var.f4456j = true;
                n0Var.f4455i = o0Var;
                o0Var = n0Var;
            }
            r();
            b0 b0Var = (b0) this.f4449w;
            synchronized (b0Var) {
                b0Var.f4356x = o0Var;
                b0Var.f4357y = aVar2;
                b0Var.F = z11;
            }
            b0Var.h();
            this.f4451y = m.ENCODE;
            try {
                kVar = this.f4439m;
                if (kVar.f4418c == null) {
                    z12 = false;
                }
                if (z12) {
                    v vVar = this.f4437k;
                    b5.n nVar = this.f4448v;
                    kVar.getClass();
                    vVar.a().a(kVar.f4416a, new u((Object) kVar.f4417b, (Object) kVar.f4418c, (Object) nVar, 18, 0));
                    kVar.f4418c.a();
                }
                if (n0Var != null) {
                    n0Var.a();
                }
                k();
            } catch (Throwable th) {
                if (n0Var != null) {
                    n0Var.a();
                }
                throw th;
            }
        } else {
            p();
        }
    }

    public final h h() {
        int ordinal = this.f4451y.ordinal();
        i iVar = this.f4434h;
        if (ordinal == 1) {
            return new p0(iVar, this);
        }
        if (ordinal == 2) {
            return new e(iVar.a(), iVar, this);
        }
        if (ordinal == 3) {
            return new t0(iVar, this);
        }
        if (ordinal == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f4451y);
    }

    public final m i(m mVar) {
        int ordinal = mVar.ordinal();
        if (ordinal == 0) {
            boolean b10 = this.f4447u.b();
            m mVar2 = m.RESOURCE_CACHE;
            return b10 ? mVar2 : i(mVar2);
        } else if (ordinal != 1) {
            m mVar3 = m.FINISHED;
            if (ordinal == 2) {
                return this.f4452z ? mVar3 : m.SOURCE;
            }
            if (ordinal == 3 || ordinal == 5) {
                return mVar3;
            }
            throw new IllegalArgumentException("Unrecognized stage: " + mVar);
        } else {
            boolean a10 = this.f4447u.a();
            m mVar4 = m.DATA_CACHE;
            return a10 ? mVar4 : i(mVar4);
        }
    }

    public final void j() {
        r();
        i0 i0Var = new i0("Failed to load resource", new ArrayList(this.f4435i));
        b0 b0Var = (b0) this.f4449w;
        synchronized (b0Var) {
            b0Var.A = i0Var;
        }
        b0Var.g();
        l();
    }

    public final void k() {
        boolean a10;
        l lVar = this.f4440n;
        synchronized (lVar) {
            lVar.f4422b = true;
            a10 = lVar.a();
        }
        if (a10) {
            n();
        }
    }

    public final void l() {
        boolean a10;
        l lVar = this.f4440n;
        synchronized (lVar) {
            lVar.f4423c = true;
            a10 = lVar.a();
        }
        if (a10) {
            n();
        }
    }

    public final void m() {
        boolean a10;
        l lVar = this.f4440n;
        synchronized (lVar) {
            lVar.f4421a = true;
            a10 = lVar.a();
        }
        if (a10) {
            n();
        }
    }

    public final void n() {
        l lVar = this.f4440n;
        synchronized (lVar) {
            lVar.f4422b = false;
            lVar.f4421a = false;
            lVar.f4423c = false;
        }
        k kVar = this.f4439m;
        kVar.f4416a = null;
        kVar.f4417b = null;
        kVar.f4418c = null;
        i iVar = this.f4434h;
        iVar.f4394c = null;
        iVar.f4395d = null;
        iVar.f4405n = null;
        iVar.f4398g = null;
        iVar.f4402k = null;
        iVar.f4400i = null;
        iVar.f4406o = null;
        iVar.f4401j = null;
        iVar.f4407p = null;
        iVar.f4392a.clear();
        iVar.f4403l = false;
        iVar.f4393b.clear();
        iVar.f4404m = false;
        this.I = false;
        this.f4441o = null;
        this.f4442p = null;
        this.f4448v = null;
        this.f4443q = null;
        this.f4444r = null;
        this.f4449w = null;
        this.f4451y = null;
        this.H = null;
        this.B = null;
        this.C = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.J = false;
        this.A = null;
        this.f4435i.clear();
        this.f4438l.e(this);
    }

    public final void o(int i10) {
        g5.g gVar;
        this.L = i10;
        b0 b0Var = (b0) this.f4449w;
        if (b0Var.f4353u) {
            gVar = b0Var.f4348p;
        } else if (b0Var.f4354v) {
            gVar = b0Var.f4349q;
        } else {
            gVar = b0Var.f4347o;
        }
        gVar.execute(this);
    }

    public final void p() {
        this.B = Thread.currentThread();
        int i10 = i.f16115a;
        SystemClock.elapsedRealtimeNanos();
        boolean z10 = false;
        while (!this.J && this.H != null && !(z10 = this.H.c())) {
            this.f4451y = i(this.f4451y);
            this.H = h();
            if (this.f4451y == m.SOURCE) {
                o(2);
                return;
            }
        }
        if ((this.f4451y == m.FINISHED || this.J) && !z10) {
            j();
        }
    }

    public final void q() {
        int a10 = s.i.a(this.L);
        if (a10 == 0) {
            this.f4451y = i(m.INITIALIZE);
            this.H = h();
        } else if (a10 != 1) {
            if (a10 == 2) {
                g();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: ".concat(android.support.v4.media.h.D(this.L)));
        }
        p();
    }

    public final void r() {
        Throwable th;
        this.f4436j.a();
        if (this.I) {
            if (this.f4435i.isEmpty()) {
                th = null;
            } else {
                ArrayList arrayList = this.f4435i;
                th = (Throwable) arrayList.get(arrayList.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.I = true;
    }

    public final void run() {
        com.bumptech.glide.load.data.e eVar = this.G;
        try {
            if (this.J) {
                j();
                if (eVar != null) {
                    eVar.c();
                    return;
                }
                return;
            }
            q();
            if (eVar != null) {
                eVar.c();
            }
        } catch (d e10) {
            throw e10;
        } catch (Throwable th) {
            if (eVar != null) {
                eVar.c();
            }
            throw th;
        }
    }
}
