package kb;

import hb.l;
import la.v;
import pa.e;
import xa.j;

public final class q0 implements hb.q0 {

    /* renamed from: h  reason: collision with root package name */
    public final s0 f9366h;

    /* renamed from: i  reason: collision with root package name */
    public final long f9367i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f9368j;

    /* renamed from: k  reason: collision with root package name */
    public final e f9369k;

    public q0(s0 s0Var, long j10, Object obj, l lVar) {
        this.f9366h = s0Var;
        this.f9367i = j10;
        this.f9368j = obj;
        this.f9369k = lVar;
    }

    public final void a() {
        s0 s0Var = this.f9366h;
        synchronized (s0Var) {
            if (this.f9367i >= s0Var.q()) {
                Object[] objArr = s0Var.f9388o;
                j.c(objArr);
                int i10 = (int) this.f9367i;
                if (objArr[(objArr.length - 1) & i10] == this) {
                    objArr[i10 & (objArr.length - 1)] = t0.f9395a;
                    s0Var.l();
                    v vVar = v.f9814a;
                }
            }
        }
    }
}
