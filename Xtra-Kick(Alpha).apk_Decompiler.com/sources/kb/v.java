package kb;

import wa.p;

public final class v implements i {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ p f9404h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f9405i;

    public v(p pVar, i iVar) {
        this.f9404h = pVar;
        this.f9405i = iVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kb.j r7, pa.e r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kb.u
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kb.u r0 = (kb.u) r0
            int r1 = r0.f9397i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9397i = r1
            goto L_0x0018
        L_0x0013:
            kb.u r0 = new kb.u
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f9396h
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9397i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            hb.h0.O1(r8)
            goto L_0x0073
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0032:
            lb.v r7 = r0.f9401m
            kb.j r2 = r0.f9400l
            kb.v r4 = r0.f9399k
            hb.h0.O1(r8)     // Catch:{ all -> 0x003c }
            goto L_0x005e
        L_0x003c:
            r8 = move-exception
            goto L_0x007a
        L_0x003e:
            hb.h0.O1(r8)
            lb.v r8 = new lb.v
            pa.k r2 = r0.getContext()
            r8.<init>(r7, r2)
            wa.p r2 = r6.f9404h     // Catch:{ all -> 0x0076 }
            r0.f9399k = r6     // Catch:{ all -> 0x0076 }
            r0.f9400l = r7     // Catch:{ all -> 0x0076 }
            r0.f9401m = r8     // Catch:{ all -> 0x0076 }
            r0.f9397i = r4     // Catch:{ all -> 0x0076 }
            java.lang.Object r2 = r2.g(r8, r0)     // Catch:{ all -> 0x0076 }
            if (r2 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r4 = r6
            r2 = r7
            r7 = r8
        L_0x005e:
            r7.releaseIntercepted()
            kb.i r7 = r4.f9405i
            r8 = 0
            r0.f9399k = r8
            r0.f9400l = r8
            r0.f9401m = r8
            r0.f9397i = r3
            java.lang.Object r7 = r7.b(r2, r0)
            if (r7 != r1) goto L_0x0073
            return r1
        L_0x0073:
            la.v r7 = la.v.f9814a
            return r7
        L_0x0076:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x007a:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.v.b(kb.j, pa.e):java.lang.Object");
    }
}
