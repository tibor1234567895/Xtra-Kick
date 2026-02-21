package n3;

import ob.d;
import ob.e;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f11177a = new h0();

    /* renamed from: b  reason: collision with root package name */
    public final d f11178b = e.a();

    /* renamed from: c  reason: collision with root package name */
    public int f11179c = -1;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[Catch:{ all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.Serializable a(pa.e r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof n3.e0
            if (r0 == 0) goto L_0x0013
            r0 = r9
            n3.e0 r0 = (n3.e0) r0
            int r1 = r0.f11123l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11123l = r1
            goto L_0x0018
        L_0x0013:
            n3.e0 r0 = new n3.e0
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f11121j
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11123l
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            ob.d r1 = r0.f11120i
            n3.g0 r0 = r0.f11119h
            hb.h0.O1(r9)
            goto L_0x0047
        L_0x002b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0033:
            hb.h0.O1(r9)
            r0.f11119h = r8
            ob.d r9 = r8.f11178b
            r0.f11120i = r9
            r0.f11123l = r3
            java.lang.Object r0 = r9.e(r0)
            if (r0 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r8
            r1 = r9
        L_0x0047:
            r9 = 0
            n3.h0 r2 = r0.f11177a     // Catch:{ all -> 0x0087 }
            java.util.List r2 = r2.b()     // Catch:{ all -> 0x0087 }
            int r0 = r0.f11179c     // Catch:{ all -> 0x0087 }
            int r4 = r2.size()     // Catch:{ all -> 0x0087 }
            int r0 = r0 - r4
            int r0 = r0 + r3
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0087 }
            int r4 = ma.s.i(r2)     // Catch:{ all -> 0x0087 }
            r3.<init>(r4)     // Catch:{ all -> 0x0087 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0087 }
            r4 = 0
        L_0x0064:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0087 }
            if (r5 == 0) goto L_0x0083
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0087 }
            int r6 = r4 + 1
            if (r4 < 0) goto L_0x007f
            n3.s1 r5 = (n3.s1) r5     // Catch:{ all -> 0x0087 }
            ma.e0 r7 = new ma.e0     // Catch:{ all -> 0x0087 }
            int r4 = r4 + r0
            r7.<init>(r4, r5)     // Catch:{ all -> 0x0087 }
            r3.add(r7)     // Catch:{ all -> 0x0087 }
            r4 = r6
            goto L_0x0064
        L_0x007f:
            ma.r.h()     // Catch:{ all -> 0x0087 }
            throw r9     // Catch:{ all -> 0x0087 }
        L_0x0083:
            r1.f(r9)
            return r3
        L_0x0087:
            r0 = move-exception
            r1.f(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.g0.a(pa.e):java.io.Serializable");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(ma.e0 r5, pa.e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof n3.f0
            if (r0 == 0) goto L_0x0013
            r0 = r6
            n3.f0 r0 = (n3.f0) r0
            int r1 = r0.f11146m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11146m = r1
            goto L_0x0018
        L_0x0013:
            n3.f0 r0 = new n3.f0
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f11144k
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11146m
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            ob.d r5 = r0.f11143j
            ma.e0 r1 = r0.f11142i
            n3.g0 r0 = r0.f11141h
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
            r0.f11141h = r4
            r0.f11142i = r5
            ob.d r6 = r4.f11178b
            r0.f11143j = r6
            r0.f11146m = r3
            java.lang.Object r0 = r6.e(r0)
            if (r0 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r0 = r4
        L_0x004c:
            r1 = 0
            int r2 = r5.f10808a     // Catch:{ all -> 0x0062 }
            r0.f11179c = r2     // Catch:{ all -> 0x0062 }
            n3.h0 r0 = r0.f11177a     // Catch:{ all -> 0x0062 }
            java.lang.Object r5 = r5.f10809b     // Catch:{ all -> 0x0062 }
            n3.s1 r5 = (n3.s1) r5     // Catch:{ all -> 0x0062 }
            r0.a(r5)     // Catch:{ all -> 0x0062 }
            la.v r5 = la.v.f9814a     // Catch:{ all -> 0x0062 }
            r6.f(r1)
            la.v r5 = la.v.f9814a
            return r5
        L_0x0062:
            r5 = move-exception
            r6.f(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.g0.b(ma.e0, pa.e):java.lang.Object");
    }
}
