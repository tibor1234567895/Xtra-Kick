package v1;

import a2.e;
import android.os.Looper;
import g1.s0;
import g1.u1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import n1.f0;
import p1.p;
import p1.q;
import p1.r;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f15556a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f15557b = new HashSet(1);

    /* renamed from: c  reason: collision with root package name */
    public final f0 f15558c = new f0();

    /* renamed from: d  reason: collision with root package name */
    public final q f15559d = new q();

    /* renamed from: e  reason: collision with root package name */
    public Looper f15560e;

    /* renamed from: f  reason: collision with root package name */
    public u1 f15561f;

    /* renamed from: g  reason: collision with root package name */
    public f0 f15562g;

    public final f0 a(a0 a0Var) {
        return new f0(this.f15558c.f15620c, 0, a0Var);
    }

    public abstract y b(a0 a0Var, e eVar, long j10);

    public final void c(b0 b0Var) {
        HashSet hashSet = this.f15557b;
        boolean z10 = !hashSet.isEmpty();
        hashSet.remove(b0Var);
        if (z10 && hashSet.isEmpty()) {
            d();
        }
    }

    public void d() {
    }

    public final void e(b0 b0Var) {
        this.f15560e.getClass();
        HashSet hashSet = this.f15557b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(b0Var);
        if (isEmpty) {
            f();
        }
    }

    public void f() {
    }

    public u1 g() {
        return null;
    }

    public abstract s0 h();

    public boolean i() {
        return true;
    }

    public abstract void j();

    public final void k(b0 b0Var, k1.f0 f0Var, f0 f0Var2) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f15560e;
        j1.a.b(looper == null || looper == myLooper);
        this.f15562g = f0Var2;
        u1 u1Var = this.f15561f;
        this.f15556a.add(b0Var);
        if (this.f15560e == null) {
            this.f15560e = myLooper;
            this.f15557b.add(b0Var);
            l(f0Var);
        } else if (u1Var != null) {
            e(b0Var);
            b0Var.a(this, u1Var);
        }
    }

    public abstract void l(k1.f0 f0Var);

    public final void m(u1 u1Var) {
        this.f15561f = u1Var;
        Iterator it = this.f15556a.iterator();
        while (it.hasNext()) {
            ((b0) it.next()).a(this, u1Var);
        }
    }

    public abstract void n(y yVar);

    public final void o(b0 b0Var) {
        ArrayList arrayList = this.f15556a;
        arrayList.remove(b0Var);
        if (arrayList.isEmpty()) {
            this.f15560e = null;
            this.f15561f = null;
            this.f15562g = null;
            this.f15557b.clear();
            p();
            return;
        }
        c(b0Var);
    }

    public abstract void p();

    public final void q(r rVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f15559d.f12507c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar.f12504b == rVar) {
                copyOnWriteArrayList.remove(pVar);
            }
        }
    }

    public final void r(g0 g0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f15558c.f15620c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            if (e0Var.f15614b == g0Var) {
                copyOnWriteArrayList.remove(e0Var);
            }
        }
    }
}
