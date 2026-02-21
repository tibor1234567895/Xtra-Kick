package n3;

import hb.f0;
import jb.g;
import jb.t;
import pa.e;
import pa.k;
import xa.j;

public final class k5 implements f0, t {

    /* renamed from: h  reason: collision with root package name */
    public final t f11292h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f0 f11293i;

    public k5(f0 f0Var, g gVar) {
        j.f("scope", f0Var);
        j.f("channel", gVar);
        this.f11292h = gVar;
        this.f11293i = f0Var;
    }

    public final boolean b(Throwable th) {
        return this.f11292h.b(th);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=androidx.lifecycle.p1, code=wa.a, for r6v0, types: [androidx.lifecycle.p1, wa.a] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(wa.a r6, pa.e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof n3.i5
            if (r0 == 0) goto L_0x0013
            r0 = r7
            n3.i5 r0 = (n3.i5) r0
            int r1 = r0.f11260k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11260k = r1
            goto L_0x0018
        L_0x0013:
            n3.i5 r0 = new n3.i5
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f11258i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11260k
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            wa.a r6 = r0.f11257h
            hb.h0.O1(r7)     // Catch:{ all -> 0x007e }
            goto L_0x006c
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            hb.h0.O1(r7)
            pa.k r7 = r5.v()     // Catch:{ all -> 0x007e }
            hb.k1 r2 = hb.l1.f7823b     // Catch:{ all -> 0x007e }
            pa.h r7 = r7.N(r2)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x0072
            hb.l1 r7 = (hb.l1) r7     // Catch:{ all -> 0x007e }
            r0.f11257h = r6     // Catch:{ all -> 0x007e }
            r0.getClass()     // Catch:{ all -> 0x007e }
            r0.f11260k = r3     // Catch:{ all -> 0x007e }
            hb.l r2 = new hb.l     // Catch:{ all -> 0x007e }
            pa.e r4 = qa.d.b(r0)     // Catch:{ all -> 0x007e }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x007e }
            r2.w()     // Catch:{ all -> 0x007e }
            n3.j5 r3 = new n3.j5     // Catch:{ all -> 0x007e }
            r4 = 0
            r3.<init>(r2, r4)     // Catch:{ all -> 0x007e }
            hb.u1 r7 = (hb.u1) r7     // Catch:{ all -> 0x007e }
            r7.L(r3)     // Catch:{ all -> 0x007e }
            java.lang.Object r7 = r2.u()     // Catch:{ all -> 0x007e }
            if (r7 != r1) goto L_0x0069
            hb.h0.m1(r0)     // Catch:{ all -> 0x007e }
        L_0x0069:
            if (r7 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r6.b()
            la.v r6 = la.v.f9814a
            return r6
        L_0x0072:
            java.lang.String r7 = "Internal error, context should have a job."
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x007e }
            r0.<init>(r7)     // Catch:{ all -> 0x007e }
            throw r0     // Catch:{ all -> 0x007e }
        L_0x007e:
            r7 = move-exception
            r6.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.k5.c(androidx.lifecycle.p1, pa.e):java.lang.Object");
    }

    public final Object g(Object obj, e eVar) {
        return this.f11292h.g(obj, eVar);
    }

    public final k v() {
        return this.f11293i.v();
    }
}
