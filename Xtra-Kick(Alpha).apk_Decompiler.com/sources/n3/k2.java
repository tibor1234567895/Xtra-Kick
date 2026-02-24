package n3;

import kb.j;

public final class k2 implements j {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11283h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f11284i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f11285j;

    public /* synthetic */ k2(Object obj, int i10, Object obj2) {
        this.f11283h = i10;
        this.f11284i = obj;
        this.f11285j = obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.Object r10, pa.e r11) {
        /*
            r9 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r9.f11283h
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r9.f11285j
            java.lang.Object r5 = r9.f11284i
            r6 = 1
            switch(r1) {
                case 0: goto L_0x00b6;
                case 1: goto L_0x0062;
                case 2: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x00c6
        L_0x0012:
            boolean r1 = r11 instanceof kb.j0
            if (r1 == 0) goto L_0x0023
            r1 = r11
            kb.j0 r1 = (kb.j0) r1
            int r7 = r1.f9336j
            r8 = r7 & r3
            if (r8 == 0) goto L_0x0023
            int r7 = r7 - r3
            r1.f9336j = r7
            goto L_0x0028
        L_0x0023:
            kb.j0 r1 = new kb.j0
            r1.<init>(r9, r11)
        L_0x0028:
            java.lang.Object r11 = r1.f9334h
            int r3 = r1.f9336j
            if (r3 == 0) goto L_0x003a
            if (r3 != r6) goto L_0x0034
            hb.h0.O1(r11)
            goto L_0x0057
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>(r2)
            throw r10
        L_0x003a:
            hb.h0.O1(r11)
            kb.j r5 = (kb.j) r5
            ma.e0 r11 = new ma.e0
            xa.s r4 = (xa.s) r4
            int r2 = r4.f16816h
            int r3 = r2 + 1
            r4.f16816h = r3
            if (r2 < 0) goto L_0x005a
            r11.<init>(r2, r10)
            r1.f9336j = r6
            java.lang.Object r10 = r5.a(r11, r1)
            if (r10 != r0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            la.v r0 = la.v.f9814a
        L_0x0059:
            return r0
        L_0x005a:
            java.lang.ArithmeticException r10 = new java.lang.ArithmeticException
            java.lang.String r11 = "Index overflow has happened"
            r10.<init>(r11)
            throw r10
        L_0x0062:
            boolean r1 = r11 instanceof n3.b3
            if (r1 == 0) goto L_0x0073
            r1 = r11
            n3.b3 r1 = (n3.b3) r1
            int r7 = r1.f11064i
            r8 = r7 & r3
            if (r8 == 0) goto L_0x0073
            int r7 = r7 - r3
            r1.f11064i = r7
            goto L_0x0078
        L_0x0073:
            n3.b3 r1 = new n3.b3
            r1.<init>(r9, r11)
        L_0x0078:
            java.lang.Object r11 = r1.f11063h
            int r3 = r1.f11064i
            if (r3 == 0) goto L_0x008a
            if (r3 != r6) goto L_0x0084
            hb.h0.O1(r11)
            goto L_0x00b3
        L_0x0084:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>(r2)
            throw r10
        L_0x008a:
            hb.h0.O1(r11)
            kb.j r4 = (kb.j) r4
            r11 = r10
            n3.a6 r11 = (n3.a6) r11
            int r2 = r11.f11051a
            int r2 = r2 * -1
            n3.g3 r5 = (n3.g3) r5
            n3.r3 r3 = r5.f11196c
            int r3 = r3.f11463f
            if (r2 > r3) goto L_0x00a7
            int r11 = r11.f11052b
            int r11 = r11 * -1
            if (r11 <= r3) goto L_0x00a5
            goto L_0x00a7
        L_0x00a5:
            r11 = 0
            goto L_0x00a8
        L_0x00a7:
            r11 = 1
        L_0x00a8:
            if (r11 == 0) goto L_0x00b3
            r1.f11064i = r6
            java.lang.Object r10 = r4.a(r10, r1)
            if (r10 != r0) goto L_0x00b3
            goto L_0x00b5
        L_0x00b3:
            la.v r0 = la.v.f9814a
        L_0x00b5:
            return r0
        L_0x00b6:
            n3.r0 r10 = (n3.r0) r10
            n3.g3 r5 = (n3.g3) r5
            n3.d1 r4 = (n3.d1) r4
            java.lang.Object r10 = n3.g3.b(r5, r4, r10, r11)
            if (r10 != r0) goto L_0x00c3
            goto L_0x00c5
        L_0x00c3:
            la.v r10 = la.v.f9814a
        L_0x00c5:
            return r10
        L_0x00c6:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            java.lang.Object r10 = r9.b(r10, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.k2.a(java.lang.Object, pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(int r5, pa.e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kb.z0
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kb.z0 r0 = (kb.z0) r0
            int r1 = r0.f9429j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9429j = r1
            goto L_0x0018
        L_0x0013:
            kb.z0 r0 = new kb.z0
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f9427h
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9429j
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            hb.h0.O1(r6)
            goto L_0x0050
        L_0x0027:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002f:
            hb.h0.O1(r6)
            if (r5 <= 0) goto L_0x0053
            java.lang.Object r5 = r4.f11284i
            r6 = r5
            xa.q r6 = (xa.q) r6
            boolean r6 = r6.f16814h
            if (r6 != 0) goto L_0x0053
            xa.q r5 = (xa.q) r5
            r5.f16814h = r3
            java.lang.Object r5 = r4.f11285j
            kb.j r5 = (kb.j) r5
            kb.v0 r6 = kb.v0.START
            r0.f9429j = r3
            java.lang.Object r5 = r5.a(r6, r0)
            if (r5 != r1) goto L_0x0050
            return r1
        L_0x0050:
            la.v r5 = la.v.f9814a
            return r5
        L_0x0053:
            la.v r5 = la.v.f9814a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.k2.b(int, pa.e):java.lang.Object");
    }

    public k2(j jVar, g3 g3Var) {
        this.f11283h = 1;
        this.f11285j = jVar;
        this.f11284i = g3Var;
    }
}
