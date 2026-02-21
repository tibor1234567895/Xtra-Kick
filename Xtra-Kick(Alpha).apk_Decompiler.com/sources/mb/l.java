package mb;

import android.support.v4.media.j;
import hb.d0;
import hb.j0;
import hb.m0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pa.k;

public final class l extends d0 implements m0 {

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10866o = AtomicIntegerFieldUpdater.newUpdater(l.class, "runningWorkers");

    /* renamed from: j  reason: collision with root package name */
    public final d0 f10867j;

    /* renamed from: k  reason: collision with root package name */
    public final int f10868k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ m0 f10869l;

    /* renamed from: m  reason: collision with root package name */
    public final q f10870m;

    /* renamed from: n  reason: collision with root package name */
    public final Object f10871n;
    private volatile int runningWorkers;

    public l(d0 d0Var, int i10) {
        m0 m0Var;
        this.f10867j = d0Var;
        this.f10868k = i10;
        if (d0Var instanceof m0) {
            m0Var = (m0) d0Var;
        } else {
            m0Var = null;
        }
        this.f10869l = m0Var == null ? j0.f7813a : m0Var;
        this.f10870m = new q();
        this.f10871n = new Object();
    }

    public final void M0(k kVar, Runnable runnable) {
        boolean z10;
        Runnable Q0;
        this.f10870m.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10866o;
        if (atomicIntegerFieldUpdater.get(this) < this.f10868k) {
            synchronized (this.f10871n) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f10868k) {
                    z10 = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z10 = true;
                }
            }
            if (z10 && (Q0 = Q0()) != null) {
                this.f10867j.M0(this, new j((Object) this, 13, (Object) Q0));
            }
        }
    }

    public final void N0(k kVar, Runnable runnable) {
        boolean z10;
        Runnable Q0;
        this.f10870m.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10866o;
        if (atomicIntegerFieldUpdater.get(this) < this.f10868k) {
            synchronized (this.f10871n) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f10868k) {
                    z10 = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z10 = true;
                }
            }
            if (z10 && (Q0 = Q0()) != null) {
                this.f10867j.N0(this, new j((Object) this, 13, (Object) Q0));
            }
        }
    }

    public final Runnable Q0() {
        while (true) {
            Runnable runnable = (Runnable) this.f10870m.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f10871n) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10866o;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f10870m.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final void W(long j10, hb.l lVar) {
        this.f10869l.W(j10, lVar);
    }
}
