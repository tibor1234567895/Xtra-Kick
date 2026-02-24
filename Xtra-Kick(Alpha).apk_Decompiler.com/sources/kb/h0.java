package kb;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class h0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9319i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x0 f9320j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i f9321k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ k0 f9322l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9323m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(x0 x0Var, i iVar, k0 k0Var, Object obj, e eVar) {
        super(2, eVar);
        this.f9320j = x0Var;
        this.f9321k = iVar;
        this.f9322l = k0Var;
        this.f9323m = obj;
    }

    public final e create(Object obj, e eVar) {
        return new h0(this.f9320j, this.f9321k, this.f9322l, this.f9323m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        if (r6.f9318j == r5) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r9.f9319i
            kb.i r2 = r9.f9321k
            kb.k0 r3 = r9.f9322l
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r7) goto L_0x0023
            if (r1 == r6) goto L_0x001f
            if (r1 == r5) goto L_0x0023
            if (r1 != r4) goto L_0x0017
            goto L_0x0023
        L_0x0017:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001f:
            hb.h0.O1(r10)
            goto L_0x0059
        L_0x0023:
            hb.h0.O1(r10)
            goto L_0x00a9
        L_0x0028:
            hb.h0.O1(r10)
            kb.w0 r10 = kb.x0.f9417a
            r10.getClass()
            kb.y0 r10 = kb.w0.f9412b
            kb.x0 r1 = r9.f9320j
            if (r1 != r10) goto L_0x003f
            r9.f9319i = r7
            java.lang.Object r10 = r2.b(r3, r9)
            if (r10 != r0) goto L_0x00a9
            return r0
        L_0x003f:
            kb.b1 r10 = kb.w0.f9413c
            r7 = 0
            if (r1 != r10) goto L_0x0062
            r10 = r3
            lb.b r10 = (lb.b) r10
            lb.a0 r10 = r10.j()
            kb.f0 r1 = new kb.f0
            r1.<init>(r7)
            r9.f9319i = r6
            java.lang.Object r10 = hb.h0.W(r10, r1, r9)
            if (r10 != r0) goto L_0x0059
            return r0
        L_0x0059:
            r9.f9319i = r5
            java.lang.Object r10 = r2.b(r3, r9)
            if (r10 != r0) goto L_0x00a9
            return r0
        L_0x0062:
            r10 = r3
            lb.b r10 = (lb.b) r10
            monitor-enter(r10)
            lb.a0 r5 = r10.f9821k     // Catch:{ all -> 0x00ac }
            if (r5 != 0) goto L_0x0073
            lb.a0 r5 = new lb.a0     // Catch:{ all -> 0x00ac }
            int r6 = r10.f9819i     // Catch:{ all -> 0x00ac }
            r5.<init>(r6)     // Catch:{ all -> 0x00ac }
            r10.f9821k = r5     // Catch:{ all -> 0x00ac }
        L_0x0073:
            monitor-exit(r10)
            kb.i r10 = r1.a(r5)
            kb.p r1 = kb.q.f9364a
            boolean r1 = r10 instanceof kb.c1
            if (r1 == 0) goto L_0x007f
            goto L_0x0099
        L_0x007f:
            kb.p r1 = kb.q.f9364a
            kb.o r5 = kb.q.f9365b
            boolean r6 = r10 instanceof kb.h
            if (r6 == 0) goto L_0x0093
            r6 = r10
            kb.h r6 = (kb.h) r6
            wa.l r8 = r6.f9317i
            if (r8 != r1) goto L_0x0093
            wa.p r1 = r6.f9318j
            if (r1 != r5) goto L_0x0093
            goto L_0x0099
        L_0x0093:
            kb.h r1 = new kb.h
            r1.<init>(r10)
            r10 = r1
        L_0x0099:
            kb.g0 r1 = new kb.g0
            java.lang.Object r5 = r9.f9323m
            r1.<init>(r2, r3, r5, r7)
            r9.f9319i = r4
            java.lang.Object r10 = hb.h0.B(r10, r1, r9)
            if (r10 != r0) goto L_0x00a9
            return r0
        L_0x00a9:
            la.v r10 = la.v.f9814a
            return r10
        L_0x00ac:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.h0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
