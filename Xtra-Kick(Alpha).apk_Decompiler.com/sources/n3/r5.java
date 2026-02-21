package n3;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.l;
import wa.p;

public final class r5 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11464i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11465j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ s5 f11466k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f11467l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ l f11468m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r5(s5 s5Var, int i10, l lVar, e eVar) {
        super(2, eVar);
        this.f11466k = s5Var;
        this.f11467l = i10;
        this.f11468m = lVar;
    }

    public final e create(Object obj, e eVar) {
        r5 r5Var = new r5(this.f11466k, this.f11467l, this.f11468m, eVar);
        r5Var.f11465j = obj;
        return r5Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((r5) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r8.f11464i
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            n3.s5 r6 = r8.f11466k
            if (r1 == 0) goto L_0x003c
            if (r1 == r5) goto L_0x0034
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x0025
            if (r1 == r2) goto L_0x001c
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001c:
            java.lang.Object r0 = r8.f11465j
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            hb.h0.O1(r9)
            goto L_0x0094
        L_0x0025:
            hb.h0.O1(r9)
            goto L_0x0095
        L_0x002a:
            java.lang.Object r1 = r8.f11465j
            hb.l1 r1 = (hb.l1) r1
            hb.h0.O1(r9)     // Catch:{ all -> 0x0032 }
            goto L_0x0078
        L_0x0032:
            r9 = move-exception
            goto L_0x0086
        L_0x0034:
            java.lang.Object r1 = r8.f11465j
            hb.l1 r1 = (hb.l1) r1
            hb.h0.O1(r9)
            goto L_0x0063
        L_0x003c:
            hb.h0.O1(r9)
            java.lang.Object r9 = r8.f11465j
            hb.f0 r9 = (hb.f0) r9
            pa.k r9 = r9.v()
            hb.k1 r1 = hb.l1.f7823b
            pa.h r9 = r9.N(r1)
            if (r9 == 0) goto L_0x0098
            hb.l1 r9 = (hb.l1) r9
            n3.p5 r1 = r6.f11477a
            r8.f11465j = r9
            r8.f11464i = r5
            int r5 = r8.f11467l
            java.lang.Object r1 = r1.b(r5, r9, r8)
            if (r1 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r7 = r1
            r1 = r9
            r9 = r7
        L_0x0063:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0095
            wa.l r9 = r8.f11468m     // Catch:{ all -> 0x0032 }
            r8.f11465j = r1     // Catch:{ all -> 0x0032 }
            r8.f11464i = r4     // Catch:{ all -> 0x0032 }
            java.lang.Object r9 = r9.invoke(r8)     // Catch:{ all -> 0x0032 }
            if (r9 != r0) goto L_0x0078
            return r0
        L_0x0078:
            n3.p5 r9 = r6.f11477a
            r2 = 0
            r8.f11465j = r2
            r8.f11464i = r3
            java.lang.Object r9 = r9.a(r1, r8)
            if (r9 != r0) goto L_0x0095
            return r0
        L_0x0086:
            n3.p5 r3 = r6.f11477a
            r8.f11465j = r9
            r8.f11464i = r2
            java.lang.Object r1 = r3.a(r1, r8)
            if (r1 != r0) goto L_0x0093
            return r0
        L_0x0093:
            r0 = r9
        L_0x0094:
            throw r0
        L_0x0095:
            la.v r9 = la.v.f9814a
            return r9
        L_0x0098:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Internal error. coroutineScope should've created a job."
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.r5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
