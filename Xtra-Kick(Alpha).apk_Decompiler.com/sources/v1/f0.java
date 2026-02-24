package v1;

import androidx.emoji2.text.r;
import g1.a0;
import j1.l0;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import m1.g1;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f15618a;

    /* renamed from: b  reason: collision with root package name */
    public final a0 f15619b;

    /* renamed from: c  reason: collision with root package name */
    public final CopyOnWriteArrayList f15620c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15621d;

    public f0() {
        this(new CopyOnWriteArrayList(), 0, (a0) null);
    }

    public final long a(long j10) {
        long Q = l0.Q(j10);
        if (Q == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f15621d + Q;
    }

    public final void b(int i10, a0 a0Var, int i11, Object obj, long j10) {
        c(new w(1, i10, a0Var, i11, obj, a(j10), -9223372036854775807L));
    }

    public final void c(w wVar) {
        Iterator it = this.f15620c.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            l0.L(e0Var.f15613a, new r(this, e0Var.f15614b, wVar, 10));
        }
    }

    public final void d(r rVar) {
        e(rVar, 4, -1, (a0) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void e(r rVar, int i10, int i11, a0 a0Var, int i12, Object obj, long j10, long j11) {
        r rVar2 = rVar;
        f(rVar, new w(i10, i11, a0Var, i12, obj, a(j10), a(j11)));
    }

    public final void f(r rVar, w wVar) {
        Iterator it = this.f15620c.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            l0.L(e0Var.f15613a, new d0(this, e0Var.f15614b, rVar, wVar, 1));
        }
    }

    public final void g(r rVar) {
        h(rVar, 4, -1, (a0) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void h(r rVar, int i10, int i11, a0 a0Var, int i12, Object obj, long j10, long j11) {
        r rVar2 = rVar;
        i(rVar, new w(i10, i11, a0Var, i12, obj, a(j10), a(j11)));
    }

    public final void i(r rVar, w wVar) {
        Iterator it = this.f15620c.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            l0.L(e0Var.f15613a, new d0(this, e0Var.f15614b, rVar, wVar, 2));
        }
    }

    public final void j(r rVar, int i10, int i11, a0 a0Var, int i12, Object obj, long j10, long j11, IOException iOException, boolean z10) {
        r rVar2 = rVar;
        l(rVar, new w(i10, i11, a0Var, i12, obj, a(j10), a(j11)), iOException, z10);
    }

    public final void k(r rVar, int i10, IOException iOException, boolean z10) {
        j(rVar, i10, -1, (a0) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, iOException, z10);
    }

    public final void l(r rVar, w wVar, IOException iOException, boolean z10) {
        Iterator it = this.f15620c.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            l0.L(e0Var.f15613a, new g1(this, e0Var.f15614b, rVar, wVar, iOException, z10, 1));
        }
    }

    public final void m(r rVar, int i10) {
        n(rVar, i10, -1, (a0) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void n(r rVar, int i10, int i11, a0 a0Var, int i12, Object obj, long j10, long j11) {
        r rVar2 = rVar;
        o(rVar, new w(i10, i11, a0Var, i12, obj, a(j10), a(j11)));
    }

    public final void o(r rVar, w wVar) {
        Iterator it = this.f15620c.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            l0.L(e0Var.f15613a, new d0(this, e0Var.f15614b, rVar, wVar, 0));
        }
    }

    public final void p(w wVar) {
        a0 a0Var = this.f15619b;
        a0Var.getClass();
        Iterator it = this.f15620c.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            l0.L(e0Var.f15613a, new c0(this, e0Var.f15614b, a0Var, wVar, 0));
        }
    }

    public f0(CopyOnWriteArrayList copyOnWriteArrayList, int i10, a0 a0Var) {
        this.f15620c = copyOnWriteArrayList;
        this.f15618a = i10;
        this.f15619b = a0Var;
        this.f15621d = 0;
    }
}
