package hb;

import la.v;

public final class r1 extends p1 {

    /* renamed from: l  reason: collision with root package name */
    public final u1 f7839l;

    /* renamed from: m  reason: collision with root package name */
    public final s1 f7840m;

    /* renamed from: n  reason: collision with root package name */
    public final q f7841n;

    /* renamed from: o  reason: collision with root package name */
    public final Object f7842o;

    public r1(u1 u1Var, s1 s1Var, q qVar, Object obj) {
        this.f7839l = u1Var;
        this.f7840m = s1Var;
        this.f7841n = qVar;
        this.f7842o = obj;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        o((Throwable) obj);
        return v.f9814a;
    }

    public final void o(Throwable th) {
        u1 u1Var = this.f7839l;
        u1Var.getClass();
        q S = u1.S(this.f7841n);
        s1 s1Var = this.f7840m;
        Object obj = this.f7842o;
        if (S == null || !u1Var.b0(s1Var, S, obj)) {
            u1Var.p(u1Var.B(s1Var, obj));
        }
    }
}
