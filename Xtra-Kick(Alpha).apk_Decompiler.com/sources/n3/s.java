package n3;

import kb.j;

public final class s implements j {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11469h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ j f11470i;

    public /* synthetic */ s(j jVar, int i10) {
        this.f11469h = i10;
        this.f11470i = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.Object r9, pa.e r10) {
        /*
            r8 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r8.f11469h
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            kb.j r3 = r8.f11470i
            r4 = 1
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            switch(r1) {
                case 0: goto L_0x004e;
                case 1: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0099
        L_0x0010:
            boolean r1 = r10 instanceof n3.a0
            if (r1 == 0) goto L_0x0021
            r1 = r10
            n3.a0 r1 = (n3.a0) r1
            int r6 = r1.f11037i
            r7 = r6 & r5
            if (r7 == 0) goto L_0x0021
            int r6 = r6 - r5
            r1.f11037i = r6
            goto L_0x0026
        L_0x0021:
            n3.a0 r1 = new n3.a0
            r1.<init>(r8, r10)
        L_0x0026:
            java.lang.Object r10 = r1.f11036h
            int r5 = r1.f11037i
            if (r5 == 0) goto L_0x0038
            if (r5 != r4) goto L_0x0032
            hb.h0.O1(r10)
            goto L_0x004b
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r2)
            throw r9
        L_0x0038:
            hb.h0.O1(r10)
            la.i r9 = (la.i) r9
            java.lang.Object r9 = r9.f9800i
            if (r9 != 0) goto L_0x0042
            goto L_0x004b
        L_0x0042:
            r1.f11037i = r4
            java.lang.Object r9 = r3.a(r9, r1)
            if (r9 != r0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            la.v r0 = la.v.f9814a
        L_0x004d:
            return r0
        L_0x004e:
            boolean r1 = r10 instanceof n3.r
            if (r1 == 0) goto L_0x005f
            r1 = r10
            n3.r r1 = (n3.r) r1
            int r6 = r1.f11449i
            r7 = r6 & r5
            if (r7 == 0) goto L_0x005f
            int r6 = r6 - r5
            r1.f11449i = r6
            goto L_0x0064
        L_0x005f:
            n3.r r1 = new n3.r
            r1.<init>(r8, r10)
        L_0x0064:
            java.lang.Object r10 = r1.f11448h
            int r5 = r1.f11449i
            if (r5 == 0) goto L_0x0076
            if (r5 != r4) goto L_0x0070
            hb.h0.O1(r10)
            goto L_0x0096
        L_0x0070:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r2)
            throw r9
        L_0x0076:
            hb.h0.O1(r10)
            n3.f1 r9 = (n3.f1) r9
            r9.getClass()
            n3.u3 r10 = new n3.u3
            j3.w0 r2 = r9.f11148b
            java.lang.Object r2 = r2.f8718e
            kb.i r2 = (kb.i) r2
            n3.u3 r9 = r9.f11147a
            n3.v5 r9 = r9.f11506b
            r10.<init>(r2, r9)
            r1.f11449i = r4
            java.lang.Object r9 = r3.a(r10, r1)
            if (r9 != r0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            la.v r0 = la.v.f9814a
        L_0x0098:
            return r0
        L_0x0099:
            boolean r1 = r10 instanceof kb.i0
            if (r1 == 0) goto L_0x00aa
            r1 = r10
            kb.i0 r1 = (kb.i0) r1
            int r6 = r1.f9330i
            r7 = r6 & r5
            if (r7 == 0) goto L_0x00aa
            int r6 = r6 - r5
            r1.f9330i = r6
            goto L_0x00af
        L_0x00aa:
            kb.i0 r1 = new kb.i0
            r1.<init>(r8, r10)
        L_0x00af:
            java.lang.Object r10 = r1.f9329h
            int r5 = r1.f9330i
            if (r5 == 0) goto L_0x00c1
            if (r5 != r4) goto L_0x00bb
            hb.h0.O1(r10)
            goto L_0x00cf
        L_0x00bb:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r2)
            throw r9
        L_0x00c1:
            hb.h0.O1(r10)
            if (r9 == 0) goto L_0x00cf
            r1.f9330i = r4
            java.lang.Object r9 = r3.a(r9, r1)
            if (r9 != r0) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            la.v r0 = la.v.f9814a
        L_0x00d1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.s.a(java.lang.Object, pa.e):java.lang.Object");
    }
}
