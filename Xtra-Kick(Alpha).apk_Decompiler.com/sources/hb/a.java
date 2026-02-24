package hb;

import androidx.fragment.app.y;
import la.g;
import la.l;
import la.v;
import mb.f0;
import mb.j;
import pa.e;
import pa.k;
import qa.d;
import wa.p;

public abstract class a extends u1 implements e, f0 {

    /* renamed from: j  reason: collision with root package name */
    public final k f7775j;

    public a(k kVar, boolean z10) {
        super(z10);
        K((l1) kVar.N(l1.f7823b));
        this.f7775j = kVar.I0(this);
    }

    public final void J(y yVar) {
        h0.K0(this.f7775j, yVar);
    }

    public final String R() {
        return super.R();
    }

    public final void U(Object obj) {
        boolean z10;
        if (obj instanceof w) {
            w wVar = (w) obj;
            Throwable th = wVar.f7875a;
            wVar.getClass();
            if (w.f7874b.get(wVar) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            c0(th, z10);
            return;
        }
        d0(obj);
    }

    public boolean c() {
        return super.c();
    }

    public void c0(Throwable th, boolean z10) {
    }

    public void d0(Object obj) {
    }

    public final void e0(int i10, a aVar, p pVar) {
        Object obj;
        k kVar;
        Object c10;
        if (i10 != 0) {
            int i11 = i10 - 1;
            if (i11 == 0) {
                try {
                    e b10 = d.b(d.a(aVar, this, pVar));
                    int i12 = l.f9802h;
                    j.a(b10, v.f9814a, (wa.l) null);
                } catch (Throwable th) {
                    int i13 = l.f9802h;
                    resumeWith(h0.I(th));
                    throw th;
                }
            } else if (i11 == 1) {
            } else {
                if (i11 == 2) {
                    e b11 = d.b(d.a(aVar, this, pVar));
                    int i14 = l.f9802h;
                    b11.resumeWith(v.f9814a);
                } else if (i11 == 3) {
                    try {
                        kVar = this.f7775j;
                        c10 = f0.c(kVar, (Object) null);
                        xa.y.c(2, pVar);
                        obj = pVar.g(aVar, this);
                        f0.a(kVar, c10);
                        if (obj != qa.a.COROUTINE_SUSPENDED) {
                            int i15 = l.f9802h;
                            resumeWith(obj);
                        }
                    } catch (Throwable th2) {
                        int i16 = l.f9802h;
                        obj = h0.I(th2);
                    }
                } else {
                    throw new g();
                }
            }
        } else {
            throw null;
        }
    }

    public final k getContext() {
        return this.f7775j;
    }

    public final void resumeWith(Object obj) {
        Throwable a10 = l.a(obj);
        if (a10 != null) {
            obj = new w(a10, false);
        }
        Object Q = Q(obj);
        if (Q != v1.f7868b) {
            q(Q);
        }
    }

    public final String u() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public final k v() {
        return this.f7775j;
    }
}
