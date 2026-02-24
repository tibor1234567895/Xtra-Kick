package n3;

import hb.l1;
import ob.d;
import ob.e;
import xa.j;

public final class p5 {

    /* renamed from: a  reason: collision with root package name */
    public final s5 f11410a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f11411b;

    /* renamed from: c  reason: collision with root package name */
    public final d f11412c = e.a();

    /* renamed from: d  reason: collision with root package name */
    public l1 f11413d;

    /* renamed from: e  reason: collision with root package name */
    public int f11414e;

    public p5(s5 s5Var, boolean z10) {
        j.f("singleRunner", s5Var);
        this.f11410a = s5Var;
        this.f11411b = z10;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(hb.l1 r5, pa.e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof n3.n5
            if (r0 == 0) goto L_0x0013
            r0 = r6
            n3.n5 r0 = (n3.n5) r0
            int r1 = r0.f11365m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11365m = r1
            goto L_0x0018
        L_0x0013:
            n3.n5 r0 = new n3.n5
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f11363k
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11365m
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            ob.d r5 = r0.f11362j
            hb.l1 r1 = r0.f11361i
            n3.p5 r0 = r0.f11360h
            hb.h0.O1(r6)
            r6 = r5
            r5 = r1
            goto L_0x004c
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            hb.h0.O1(r6)
            r0.f11360h = r4
            r0.f11361i = r5
            ob.d r6 = r4.f11412c
            r0.f11362j = r6
            r0.f11365m = r3
            java.lang.Object r0 = r6.e(r0)
            if (r0 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r0 = r4
        L_0x004c:
            r1 = 0
            hb.l1 r2 = r0.f11413d     // Catch:{ all -> 0x005b }
            if (r5 != r2) goto L_0x0053
            r0.f11413d = r1     // Catch:{ all -> 0x005b }
        L_0x0053:
            la.v r5 = la.v.f9814a     // Catch:{ all -> 0x005b }
            r6.f(r1)
            la.v r5 = la.v.f9814a
            return r5
        L_0x005b:
            r5 = move-exception
            r6.f(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.p5.a(hb.l1, pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(int r10, hb.l1 r11, pa.e r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof n3.o5
            if (r0 == 0) goto L_0x0013
            r0 = r12
            n3.o5 r0 = (n3.o5) r0
            int r1 = r0.f11392n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11392n = r1
            goto L_0x0018
        L_0x0013:
            n3.o5 r0 = new n3.o5
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f11390l
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11392n
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r10 = r0.f11389k
            ob.a r11 = r0.f11388j
            hb.l1 r1 = r0.f11387i
            n3.p5 r0 = r0.f11386h
            hb.h0.O1(r12)     // Catch:{ all -> 0x00ad }
            goto L_0x009d
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            int r10 = r0.f11389k
            ob.a r11 = r0.f11388j
            hb.l1 r2 = r0.f11387i
            n3.p5 r6 = r0.f11386h
            hb.h0.O1(r12)
            goto L_0x0061
        L_0x0048:
            hb.h0.O1(r12)
            r0.f11386h = r9
            r0.f11387i = r11
            ob.d r12 = r9.f11412c
            r0.f11388j = r12
            r0.f11389k = r10
            r0.f11392n = r5
            java.lang.Object r2 = r12.e(r0)
            if (r2 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r6 = r9
            r2 = r11
            r11 = r12
        L_0x0061:
            hb.l1 r12 = r6.f11413d     // Catch:{ all -> 0x00ad }
            if (r12 == 0) goto L_0x0078
            boolean r7 = r12.c()     // Catch:{ all -> 0x00ad }
            if (r7 == 0) goto L_0x0078
            int r7 = r6.f11414e     // Catch:{ all -> 0x00ad }
            if (r7 < r10) goto L_0x0078
            if (r7 != r10) goto L_0x0076
            boolean r7 = r6.f11411b     // Catch:{ all -> 0x00ad }
            if (r7 == 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r5 = 0
            goto L_0x00a3
        L_0x0078:
            if (r12 != 0) goto L_0x007b
            goto L_0x0085
        L_0x007b:
            n3.l5 r7 = new n3.l5     // Catch:{ all -> 0x00ad }
            n3.s5 r8 = r6.f11410a     // Catch:{ all -> 0x00ad }
            r7.<init>(r8)     // Catch:{ all -> 0x00ad }
            r12.e(r7)     // Catch:{ all -> 0x00ad }
        L_0x0085:
            if (r12 != 0) goto L_0x0088
            goto L_0x009f
        L_0x0088:
            r0.f11386h = r6     // Catch:{ all -> 0x00ad }
            r0.f11387i = r2     // Catch:{ all -> 0x00ad }
            r0.f11388j = r11     // Catch:{ all -> 0x00ad }
            r0.f11389k = r10     // Catch:{ all -> 0x00ad }
            r0.f11392n = r3     // Catch:{ all -> 0x00ad }
            hb.u1 r12 = (hb.u1) r12     // Catch:{ all -> 0x00ad }
            java.lang.Object r12 = r12.P(r0)     // Catch:{ all -> 0x00ad }
            if (r12 != r1) goto L_0x009b
            return r1
        L_0x009b:
            r1 = r2
            r0 = r6
        L_0x009d:
            r6 = r0
            r2 = r1
        L_0x009f:
            r6.f11413d = r2     // Catch:{ all -> 0x00ad }
            r6.f11414e = r10     // Catch:{ all -> 0x00ad }
        L_0x00a3:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x00ad }
            ob.d r11 = (ob.d) r11
            r11.f(r4)
            return r10
        L_0x00ad:
            r10 = move-exception
            ob.d r11 = (ob.d) r11
            r11.f(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.p5.b(int, hb.l1, pa.e):java.lang.Object");
    }
}
