package lb;

import java.util.Arrays;
import la.l;
import la.v;
import pa.e;
import xa.j;

public abstract class b {

    /* renamed from: h  reason: collision with root package name */
    public c[] f9818h;

    /* renamed from: i  reason: collision with root package name */
    public int f9819i;

    /* renamed from: j  reason: collision with root package name */
    public int f9820j;

    /* renamed from: k  reason: collision with root package name */
    public a0 f9821k;

    public final c e() {
        c cVar;
        a0 a0Var;
        synchronized (this) {
            c[] cVarArr = this.f9818h;
            if (cVarArr == null) {
                cVarArr = g();
                this.f9818h = cVarArr;
            } else if (this.f9819i >= cVarArr.length) {
                Object[] copyOf = Arrays.copyOf(cVarArr, cVarArr.length * 2);
                j.e("copyOf(this, newSize)", copyOf);
                this.f9818h = (c[]) copyOf;
                cVarArr = (c[]) copyOf;
            }
            int i10 = this.f9820j;
            do {
                cVar = cVarArr[i10];
                if (cVar == null) {
                    cVar = f();
                    cVarArr[i10] = cVar;
                }
                i10++;
                if (i10 >= cVarArr.length) {
                    i10 = 0;
                }
                j.d("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>", cVar);
            } while (!cVar.a(this));
            this.f9820j = i10;
            this.f9819i++;
            a0Var = this.f9821k;
        }
        if (a0Var != null) {
            a0Var.x(1);
        }
        return cVar;
    }

    public abstract c f();

    public abstract c[] g();

    public final void i(c cVar) {
        a0 a0Var;
        int i10;
        e[] b10;
        synchronized (this) {
            int i11 = this.f9819i - 1;
            this.f9819i = i11;
            a0Var = this.f9821k;
            if (i11 == 0) {
                this.f9820j = 0;
            }
            j.d("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>", cVar);
            b10 = cVar.b(this);
        }
        for (e eVar : b10) {
            if (eVar != null) {
                int i12 = l.f9802h;
                eVar.resumeWith(v.f9814a);
            }
        }
        if (a0Var != null) {
            a0Var.x(-1);
        }
    }

    public final a0 j() {
        a0 a0Var;
        synchronized (this) {
            a0Var = this.f9821k;
            if (a0Var == null) {
                a0Var = new a0(this.f9819i);
                this.f9821k = a0Var;
            }
        }
        return a0Var;
    }
}
