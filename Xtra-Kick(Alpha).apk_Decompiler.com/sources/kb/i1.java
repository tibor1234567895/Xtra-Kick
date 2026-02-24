package kb;

import pa.e;
import wa.p;

public final class i1 implements j {

    /* renamed from: h  reason: collision with root package name */
    public final j f9332h;

    /* renamed from: i  reason: collision with root package name */
    public final p f9333i;

    public i1(p pVar, j jVar) {
        this.f9332h = jVar;
        this.f9333i = pVar;
    }

    public final Object a(Object obj, e eVar) {
        return this.f9332h.a(obj, eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(pa.e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kb.h1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kb.h1 r0 = (kb.h1) r0
            int r1 = r0.f9328l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9328l = r1
            goto L_0x0018
        L_0x0013:
            kb.h1 r0 = new kb.h1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f9326j
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9328l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            hb.h0.O1(r7)
            goto L_0x0071
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0032:
            lb.v r2 = r0.f9325i
            kb.i1 r4 = r0.f9324h
            hb.h0.O1(r7)     // Catch:{ all -> 0x0077 }
            goto L_0x0058
        L_0x003a:
            hb.h0.O1(r7)
            lb.v r2 = new lb.v
            kb.j r7 = r6.f9332h
            pa.k r5 = r0.getContext()
            r2.<init>(r7, r5)
            wa.p r7 = r6.f9333i     // Catch:{ all -> 0x0077 }
            r0.f9324h = r6     // Catch:{ all -> 0x0077 }
            r0.f9325i = r2     // Catch:{ all -> 0x0077 }
            r0.f9328l = r4     // Catch:{ all -> 0x0077 }
            java.lang.Object r7 = r7.g(r2, r0)     // Catch:{ all -> 0x0077 }
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r4 = r6
        L_0x0058:
            r2.releaseIntercepted()
            kb.j r7 = r4.f9332h
            boolean r2 = r7 instanceof kb.i1
            if (r2 == 0) goto L_0x0074
            kb.i1 r7 = (kb.i1) r7
            r2 = 0
            r0.f9324h = r2
            r0.f9325i = r2
            r0.f9328l = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L_0x0071
            return r1
        L_0x0071:
            la.v r7 = la.v.f9814a
            return r7
        L_0x0074:
            la.v r7 = la.v.f9814a
            return r7
        L_0x0077:
            r7 = move-exception
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.i1.b(pa.e):java.lang.Object");
    }
}
