package d5;

import android.os.SystemClock;
import android.support.v4.media.session.u;
import android.util.Log;
import androidx.appcompat.widget.i5;
import b5.a;
import b5.j;
import b5.n;
import d0.d;
import f5.f;
import f5.h;
import f5.i;
import g5.g;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;
import w5.b;

public final class w implements c0, i, f0 {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4497h = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    public final k0 f4498a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f4499b;

    /* renamed from: c  reason: collision with root package name */
    public final h f4500c;

    /* renamed from: d  reason: collision with root package name */
    public final i5 f4501d;

    /* renamed from: e  reason: collision with root package name */
    public final s0 f4502e;

    /* renamed from: f  reason: collision with root package name */
    public final d f4503f;

    /* renamed from: g  reason: collision with root package name */
    public final c f4504g;

    public w(h hVar, f fVar, g gVar, g gVar2, g gVar3, g gVar4) {
        this.f4500c = hVar;
        v vVar = new v(fVar);
        c cVar = new c();
        this.f4504g = cVar;
        synchronized (this) {
            synchronized (cVar) {
                cVar.f4362d = this;
            }
        }
        this.f4499b = new e0();
        this.f4498a = new k0();
        this.f4501d = new i5(gVar, gVar2, gVar3, gVar4, this, this);
        this.f4503f = new d(vVar);
        this.f4502e = new s0();
        hVar.f5823e = this;
    }

    public static void f(o0 o0Var) {
        if (o0Var instanceof g0) {
            ((g0) o0Var).c();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final u a(com.bumptech.glide.h hVar, Object obj, j jVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.j jVar2, u uVar, b bVar, boolean z10, boolean z11, n nVar, boolean z12, boolean z13, boolean z14, boolean z15, s5.g gVar, Executor executor) {
        long j10;
        if (f4497h) {
            int i12 = w5.i.f16115a;
            j10 = SystemClock.elapsedRealtimeNanos();
        } else {
            j10 = 0;
        }
        long j11 = j10;
        this.f4499b.getClass();
        d0 d0Var = new d0(obj, jVar, i10, i11, bVar, cls, cls2, nVar);
        synchronized (this) {
            try {
                g0 c10 = c(d0Var, z12, j11);
                if (c10 == null) {
                    u g10 = g(hVar, obj, jVar, i10, i11, cls, cls2, jVar2, uVar, bVar, z10, z11, nVar, z12, z13, z14, z15, gVar, executor, d0Var, j11);
                    return g10;
                }
                ((s5.h) gVar).l(c10, a.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final g0 b(j jVar) {
        g0 g0Var;
        Object obj;
        h hVar = this.f4500c;
        synchronized (hVar) {
            w5.j jVar2 = (w5.j) hVar.f16118a.remove(jVar);
            g0Var = null;
            if (jVar2 == null) {
                obj = null;
            } else {
                hVar.f16120c -= (long) jVar2.f16117b;
                obj = jVar2.f16116a;
            }
        }
        o0 o0Var = (o0) obj;
        if (o0Var != null) {
            if (o0Var instanceof g0) {
                g0Var = (g0) o0Var;
            } else {
                g0Var = new g0(o0Var, true, true, jVar, this);
            }
        }
        if (g0Var != null) {
            g0Var.a();
            this.f4504g.a(jVar, g0Var);
        }
        return g0Var;
    }

    public final g0 c(d0 d0Var, boolean z10, long j10) {
        g0 g0Var;
        if (!z10) {
            return null;
        }
        c cVar = this.f4504g;
        synchronized (cVar) {
            b bVar = (b) cVar.f4360b.get(d0Var);
            if (bVar == null) {
                g0Var = null;
            } else {
                g0Var = (g0) bVar.get();
                if (g0Var == null) {
                    cVar.b(bVar);
                }
            }
        }
        if (g0Var != null) {
            g0Var.a();
        }
        if (g0Var != null) {
            if (f4497h) {
                int i10 = w5.i.f16115a;
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(d0Var);
            }
            return g0Var;
        }
        g0 b10 = b(d0Var);
        if (b10 == null) {
            return null;
        }
        if (f4497h) {
            int i11 = w5.i.f16115a;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(d0Var);
        }
        return b10;
    }

    public final synchronized void d(b0 b0Var, j jVar, g0 g0Var) {
        HashMap hashMap;
        if (g0Var != null) {
            if (g0Var.f4383h) {
                this.f4504g.a(jVar, g0Var);
            }
        }
        k0 k0Var = this.f4498a;
        k0Var.getClass();
        if (b0Var.f4355w) {
            hashMap = k0Var.f4420b;
        } else {
            hashMap = k0Var.f4419a;
        }
        if (b0Var.equals(hashMap.get(jVar))) {
            hashMap.remove(jVar);
        }
    }

    public final void e(j jVar, g0 g0Var) {
        c cVar = this.f4504g;
        synchronized (cVar) {
            b bVar = (b) cVar.f4360b.remove(jVar);
            if (bVar != null) {
                bVar.f4339c = null;
                bVar.clear();
            }
        }
        if (g0Var.f4383h) {
            o0 o0Var = (o0) this.f4500c.d(jVar, g0Var);
        } else {
            this.f4502e.a(g0Var, false);
        }
    }

    public final u g(com.bumptech.glide.h hVar, Object obj, j jVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.j jVar2, u uVar, b bVar, boolean z10, boolean z11, n nVar, boolean z12, boolean z13, boolean z14, boolean z15, s5.g gVar, Executor executor, d0 d0Var, long j10) {
        com.bumptech.glide.h hVar2 = hVar;
        Object obj2 = obj;
        j jVar3 = jVar;
        int i12 = i10;
        int i13 = i11;
        com.bumptech.glide.j jVar4 = jVar2;
        u uVar2 = uVar;
        n nVar2 = nVar;
        boolean z16 = z15;
        s5.g gVar2 = gVar;
        Executor executor2 = executor;
        d0 d0Var2 = d0Var;
        k0 k0Var = this.f4498a;
        b0 b0Var = (b0) (z16 ? k0Var.f4420b : k0Var.f4419a).get(d0Var2);
        if (b0Var != null) {
            b0Var.a(gVar2, executor2);
            if (f4497h) {
                int i14 = w5.i.f16115a;
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(d0Var);
            }
            return new u(this, gVar2, b0Var);
        }
        b0 b0Var2 = (b0) ((l0.d) this.f4501d.f880h).j();
        w5.n.b(b0Var2);
        synchronized (b0Var2) {
            b0Var2.f4351s = d0Var2;
            b0Var2.f4352t = z12;
            b0Var2.f4353u = z13;
            b0Var2.f4354v = z14;
            b0Var2.f4355w = z16;
        }
        d dVar = this.f4503f;
        n nVar3 = (n) ((l0.d) dVar.f4092j).j();
        w5.n.b(nVar3);
        int i15 = dVar.f4090h;
        dVar.f4090h = i15 + 1;
        i iVar = nVar3.f4434h;
        iVar.f4394c = hVar2;
        iVar.f4395d = obj2;
        iVar.f4405n = jVar3;
        iVar.f4396e = i12;
        iVar.f4397f = i13;
        iVar.f4407p = uVar2;
        iVar.f4398g = cls;
        iVar.f4399h = nVar3.f4437k;
        iVar.f4402k = cls2;
        iVar.f4406o = jVar4;
        iVar.f4400i = nVar2;
        iVar.f4401j = bVar;
        iVar.f4408q = z10;
        iVar.f4409r = z11;
        nVar3.f4441o = hVar2;
        nVar3.f4442p = jVar3;
        nVar3.f4443q = jVar4;
        nVar3.f4444r = d0Var2;
        nVar3.f4445s = i12;
        nVar3.f4446t = i13;
        nVar3.f4447u = uVar2;
        nVar3.f4452z = z16;
        nVar3.f4448v = nVar2;
        nVar3.f4449w = b0Var2;
        nVar3.f4450x = i15;
        nVar3.L = 1;
        nVar3.A = obj2;
        k0 k0Var2 = this.f4498a;
        k0Var2.getClass();
        (b0Var2.f4355w ? k0Var2.f4420b : k0Var2.f4419a).put(d0Var2, b0Var2);
        s5.g gVar3 = gVar;
        b0Var2.a(gVar3, executor);
        b0Var2.k(nVar3);
        if (f4497h) {
            int i16 = w5.i.f16115a;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(d0Var);
        }
        return new u(this, gVar3, b0Var2);
    }
}
