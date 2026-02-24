package r3;

import a6.e;
import android.support.v4.media.n;
import androidx.lifecycle.k0;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import xa.j;

public final class u0 extends k0 {

    /* renamed from: l  reason: collision with root package name */
    public final n0 f13755l;

    /* renamed from: m  reason: collision with root package name */
    public final n f13756m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f13757n = false;

    /* renamed from: o  reason: collision with root package name */
    public final Callable f13758o;

    /* renamed from: p  reason: collision with root package name */
    public final a0 f13759p;

    /* renamed from: q  reason: collision with root package name */
    public final AtomicBoolean f13760q;

    /* renamed from: r  reason: collision with root package name */
    public final AtomicBoolean f13761r;

    /* renamed from: s  reason: collision with root package name */
    public final AtomicBoolean f13762s;

    /* renamed from: t  reason: collision with root package name */
    public final t0 f13763t;

    /* renamed from: u  reason: collision with root package name */
    public final t0 f13764u;

    public u0(n0 n0Var, n nVar, e eVar, String[] strArr) {
        j.f("database", n0Var);
        this.f13755l = n0Var;
        this.f13756m = nVar;
        this.f13758o = eVar;
        this.f13759p = new a0(strArr, this);
        this.f13760q = new AtomicBoolean(true);
        this.f13761r = new AtomicBoolean(false);
        this.f13762s = new AtomicBoolean(false);
        this.f13763t = new t0(this, 0);
        this.f13764u = new t0(this, 1);
    }

    public final void h() {
        Executor executor;
        n nVar = this.f13756m;
        nVar.getClass();
        ((Set) nVar.f338j).add(this);
        boolean z10 = this.f13757n;
        n0 n0Var = this.f13755l;
        if (z10) {
            executor = n0Var.f13720c;
            if (executor == null) {
                j.l("internalTransactionExecutor");
                throw null;
            }
        } else {
            executor = n0Var.f13719b;
            if (executor == null) {
                j.l("internalQueryExecutor");
                throw null;
            }
        }
        executor.execute(this.f13763t);
    }

    public final void i() {
        n nVar = this.f13756m;
        nVar.getClass();
        ((Set) nVar.f338j).remove(this);
    }
}
