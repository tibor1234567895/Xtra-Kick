package n3;

import androidx.lifecycle.u1;
import hb.f0;
import hb.h0;
import pa.e;
import pa.h;
import xa.j;

public final class c5 implements d5 {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f11092e = 0;

    /* renamed from: a  reason: collision with root package name */
    public final f0 f11093a;

    /* renamed from: b  reason: collision with root package name */
    public final r4 f11094b;

    /* renamed from: c  reason: collision with root package name */
    public final d f11095c = new d();

    /* renamed from: d  reason: collision with root package name */
    public final s5 f11096d = new s5(false);

    static {
        new s4(0);
    }

    public c5(k5 k5Var, r4 r4Var) {
        this.f11093a = k5Var;
        this.f11094b = r4Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(pa.e r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof n3.u4
            if (r0 == 0) goto L_0x0013
            r0 = r5
            n3.u4 r0 = (n3.u4) r0
            int r1 = r0.f11510k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11510k = r1
            goto L_0x0018
        L_0x0013:
            n3.u4 r0 = new n3.u4
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f11508i
            int r1 = r0.f11510k
            n3.p4 r2 = n3.p4.LAUNCH_INITIAL_REFRESH
            r3 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r3) goto L_0x0029
            n3.c5 r0 = r0.f11507h
            hb.h0.O1(r5)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            hb.h0.O1(r5)
            r0.f11507h = r4
            r0.f11510k = r3
            n3.r4 r5 = r4.f11094b
            r5.getClass()
            r0 = r4
            r5 = r2
        L_0x003f:
            r1 = r5
            n3.p4 r1 = (n3.p4) r1
            if (r1 != r2) goto L_0x004b
            n3.d r0 = r0.f11095c
            n3.v4 r1 = n3.v4.f11532h
            r0.a(r1)
        L_0x004b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.c5.a(pa.e):java.lang.Object");
    }

    public final void b(d1 d1Var, o4 o4Var) {
        j.f("loadType", d1Var);
        if (((Boolean) this.f11095c.a(new u1(d1Var, 2, o4Var))).booleanValue()) {
            int i10 = t4.f11492a[d1Var.ordinal()];
            f0 f0Var = this.f11093a;
            if (i10 == 1) {
                h0.b1(f0Var, (h) null, 0, new b5(this, (e) null), 3);
            } else {
                h0.b1(f0Var, (h) null, 0, new y4(this, (e) null), 3);
            }
        }
    }
}
