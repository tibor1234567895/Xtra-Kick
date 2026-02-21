package kb;

import lb.v;

public abstract class b implements i {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kb.j r6, pa.e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kb.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kb.a r0 = (kb.a) r0
            int r1 = r0.f9262k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9262k = r1
            goto L_0x0018
        L_0x0013:
            kb.a r0 = new kb.a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f9260i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9262k
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            lb.v r6 = r0.f9259h
            hb.h0.O1(r7)     // Catch:{ all -> 0x0029 }
            goto L_0x004b
        L_0x0029:
            r7 = move-exception
            goto L_0x0055
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            hb.h0.O1(r7)
            lb.v r7 = new lb.v
            pa.k r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f9259h = r7     // Catch:{ all -> 0x0051 }
            r0.f9262k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r6 = r5.e(r7, r0)     // Catch:{ all -> 0x0051 }
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r7
        L_0x004b:
            r6.releaseIntercepted()
            la.v r6 = la.v.f9814a
            return r6
        L_0x0051:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0055:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.b.b(kb.j, pa.e):java.lang.Object");
    }

    public abstract Object e(v vVar, a aVar);
}
