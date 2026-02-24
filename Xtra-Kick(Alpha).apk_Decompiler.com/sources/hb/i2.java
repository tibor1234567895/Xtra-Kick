package hb;

import la.i;
import la.v;
import mb.f0;
import mb.y;
import pa.e;
import pa.k;

public final class i2 extends y {

    /* renamed from: l  reason: collision with root package name */
    public final ThreadLocal f7812l;
    private volatile boolean threadLocalIsSet;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i2(pa.e r3, pa.k r4) {
        /*
            r2 = this;
            hb.j2 r0 = hb.j2.f7816h
            pa.h r1 = r4.N(r0)
            if (r1 != 0) goto L_0x000d
            pa.k r0 = r4.I0(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r4
        L_0x000e:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f7812l = r0
            pa.k r3 = r3.getContext()
            pa.f r0 = pa.g.f12752g
            pa.h r3 = r3.N(r0)
            boolean r3 = r3 instanceof hb.d0
            if (r3 != 0) goto L_0x0031
            r3 = 0
            java.lang.Object r3 = mb.f0.c(r4, r3)
            mb.f0.a(r4, r3)
            r2.g0(r4, r3)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.i2.<init>(pa.e, pa.k):void");
    }

    public final boolean f0() {
        boolean z10 = this.threadLocalIsSet && this.f7812l.get() == null;
        this.f7812l.remove();
        return !z10;
    }

    public final void g0(k kVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f7812l.set(new i(kVar, obj));
    }

    public final void q(Object obj) {
        if (this.threadLocalIsSet) {
            i iVar = (i) this.f7812l.get();
            if (iVar != null) {
                f0.a((k) iVar.f9799h, iVar.f9800i);
            }
            this.f7812l.remove();
        }
        Object r12 = h0.r1(obj);
        e eVar = this.f10888k;
        k context = eVar.getContext();
        i2 i2Var = null;
        Object c10 = f0.c(context, i2Var);
        if (c10 != f0.f10849a) {
            i2Var = h0.Z1(eVar, context, c10);
        }
        try {
            this.f10888k.resumeWith(r12);
            v vVar = v.f9814a;
        } finally {
            if (i2Var == null || i2Var.f0()) {
                f0.a(context, c10);
            }
        }
    }
}
