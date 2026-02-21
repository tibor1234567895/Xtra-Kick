package n3;

import la.v;
import ob.d;
import pa.e;
import ra.i;
import wa.p;

public final class y2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public Object f11580i;

    /* renamed from: j  reason: collision with root package name */
    public Object f11581j;

    /* renamed from: k  reason: collision with root package name */
    public d f11582k;

    /* renamed from: l  reason: collision with root package name */
    public int f11583l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f11584m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ g3 f11585n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y2(g3 g3Var, e eVar) {
        super(2, eVar);
        this.f11585n = g3Var;
    }

    public final e create(Object obj, e eVar) {
        y2 y2Var = new y2(this.f11585n, eVar);
        y2Var.f11584m = obj;
        return y2Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((y2) create((k5) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: n3.k5} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r10.f11583l
            n3.d1 r2 = n3.d1.REFRESH
            r3 = 3
            r4 = 2
            r5 = 1
            n3.g3 r6 = r10.f11585n
            r7 = 0
            if (r1 == 0) goto L_0x0048
            if (r1 == r5) goto L_0x0036
            if (r1 == r4) goto L_0x002d
            if (r1 != r3) goto L_0x0025
            java.lang.Object r0 = r10.f11581j
            ob.a r0 = (ob.a) r0
            java.lang.Object r1 = r10.f11580i
            n3.h3 r1 = (n3.h3) r1
            java.lang.Object r3 = r10.f11584m
            n3.k5 r3 = (n3.k5) r3
            hb.h0.O1(r11)
            goto L_0x00d5
        L_0x0025:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002d:
            java.lang.Object r1 = r10.f11584m
            n3.k5 r1 = (n3.k5) r1
            hb.h0.O1(r11)
            goto L_0x00bf
        L_0x0036:
            ob.d r1 = r10.f11582k
            java.lang.Object r5 = r10.f11581j
            n3.h3 r5 = (n3.h3) r5
            java.lang.Object r8 = r10.f11580i
            n3.d5 r8 = (n3.d5) r8
            java.lang.Object r9 = r10.f11584m
            n3.k5 r9 = (n3.k5) r9
            hb.h0.O1(r11)
            goto L_0x0099
        L_0x0048:
            hb.h0.O1(r11)
            java.lang.Object r11 = r10.f11584m
            r9 = r11
            n3.k5 r9 = (n3.k5) r9
            java.util.concurrent.atomic.AtomicBoolean r11 = r6.f11203j
            r1 = 0
            boolean r11 = r11.compareAndSet(r1, r5)
            if (r11 == 0) goto L_0x00f3
            n3.s2 r11 = new n3.s2
            r11.<init>(r6, r9, r7)
            hb.h0.b1(r9, r7, r1, r11, r3)
            r11 = 6
            jb.c r11 = hb.h0.a(r1, r7, r11)
            n3.t2 r8 = new n3.t2
            r8.<init>(r6, r7, r11)
            hb.h0.b1(r9, r7, r1, r8, r3)
            n3.x2 r8 = new n3.x2
            r8.<init>(r6, r7, r11)
            hb.h0.b1(r9, r7, r1, r8, r3)
            boolean r11 = r6.f11198e
            if (r11 == 0) goto L_0x00ad
            n3.d5 r8 = r6.f11199f
            if (r8 != 0) goto L_0x007f
            goto L_0x00ad
        L_0x007f:
            n3.o4 r11 = r6.f11200g
            if (r11 != 0) goto L_0x00a8
            n3.h3 r11 = r6.f11205l
            ob.d r1 = r11.f11229a
            r10.f11584m = r9
            r10.f11580i = r8
            r10.f11581j = r11
            r10.f11582k = r1
            r10.f11583l = r5
            java.lang.Object r5 = r1.e(r10)
            if (r5 != r0) goto L_0x0098
            return r0
        L_0x0098:
            r5 = r11
        L_0x0099:
            n3.l3 r11 = r5.f11230b     // Catch:{ all -> 0x00a3 }
            n3.o4 r11 = r11.a(r7)     // Catch:{ all -> 0x00a3 }
            r1.f(r7)
            goto L_0x00a8
        L_0x00a3:
            r11 = move-exception
            r1.f(r7)
            throw r11
        L_0x00a8:
            n3.c5 r8 = (n3.c5) r8
            r8.b(r2, r11)
        L_0x00ad:
            r10.f11584m = r9
            r10.f11580i = r7
            r10.f11581j = r7
            r10.f11582k = r7
            r10.f11583l = r4
            java.lang.Object r11 = r6.f(r10)
            if (r11 != r0) goto L_0x00be
            return r0
        L_0x00be:
            r1 = r9
        L_0x00bf:
            n3.h3 r11 = r6.f11205l
            ob.d r4 = r11.f11229a
            r10.f11584m = r1
            r10.f11580i = r11
            r10.f11581j = r4
            r10.f11583l = r3
            java.lang.Object r3 = r4.e(r10)
            if (r3 != r0) goto L_0x00d2
            return r0
        L_0x00d2:
            r3 = r1
            r0 = r4
            r1 = r11
        L_0x00d5:
            n3.l3 r11 = r1.f11230b     // Catch:{ all -> 0x00ec }
            n3.h1 r11 = r11.f11319l     // Catch:{ all -> 0x00ec }
            n3.a1 r11 = r11.a(r2)     // Catch:{ all -> 0x00ec }
            ob.d r0 = (ob.d) r0
            r0.f(r7)
            boolean r11 = r11 instanceof n3.w0
            if (r11 != 0) goto L_0x00e9
            n3.g3.d(r6, r3)
        L_0x00e9:
            la.v r11 = la.v.f9814a
            return r11
        L_0x00ec:
            r11 = move-exception
            ob.d r0 = (ob.d) r0
            r0.f(r7)
            throw r11
        L_0x00f3:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?"
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.y2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
