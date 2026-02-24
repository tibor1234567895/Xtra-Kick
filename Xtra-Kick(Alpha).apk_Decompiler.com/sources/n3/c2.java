package n3;

import la.v;
import pa.e;
import ra.i;
import wa.r;

public final class c2 extends i implements r {

    /* renamed from: i  reason: collision with root package name */
    public int f11082i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11083j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11084k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ y f11085l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ k5 f11086m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ h1 f11087n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c2(k5 k5Var, e eVar, h1 h1Var) {
        super(4, eVar);
        this.f11087n = h1Var;
        this.f11086m = k5Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: n3.s1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: n3.r1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: n3.r1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: n3.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: n3.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: n3.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: n3.q1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r11.f11082i
            r2 = 1
            if (r1 == 0) goto L_0x0016
            if (r1 != r2) goto L_0x000e
            hb.h0.O1(r12)
            goto L_0x0097
        L_0x000e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0016:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11083j
            java.lang.Object r1 = r11.f11084k
            n3.y r3 = r11.f11085l
            n3.s1 r1 = (n3.s1) r1
            r10 = r12
            n3.c1 r10 = (n3.c1) r10
            n3.y r12 = n3.y.RECEIVER
            n3.h1 r4 = r11.f11087n
            if (r3 == r12) goto L_0x0083
            boolean r12 = r1 instanceof n3.q1
            if (r12 == 0) goto L_0x0055
            n3.q1 r1 = (n3.q1) r1
            n3.c1 r12 = r1.f11426e
            r4.b(r12)
            int r7 = r1.f11424c
            int r8 = r1.f11425d
            java.lang.String r12 = "loadType"
            n3.d1 r5 = r1.f11422a
            xa.j.f(r12, r5)
            java.lang.String r12 = "pages"
            java.util.List r6 = r1.f11423b
            xa.j.f(r12, r6)
            java.lang.String r12 = "sourceLoadStates"
            n3.c1 r9 = r1.f11426e
            xa.j.f(r12, r9)
            n3.q1 r1 = new n3.q1
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L_0x008c
        L_0x0055:
            boolean r12 = r1 instanceof n3.o1
            if (r12 == 0) goto L_0x0069
            r12 = r1
            n3.o1 r12 = (n3.o1) r12
            n3.d1 r12 = r12.f11371a
            n3.y0 r3 = n3.z0.f11599b
            r3.getClass()
            n3.z0 r3 = n3.z0.f11601d
            r4.c(r12, r3)
            goto L_0x008c
        L_0x0069:
            boolean r12 = r1 instanceof n3.r1
            if (r12 == 0) goto L_0x007d
            n3.r1 r1 = (n3.r1) r1
            n3.c1 r12 = r1.f11453a
            r4.b(r12)
            n3.r1 r12 = new n3.r1
            n3.c1 r1 = r1.f11453a
            r12.<init>(r1, r10)
            r1 = r12
            goto L_0x008c
        L_0x007d:
            la.g r12 = new la.g
            r12.<init>()
            throw r12
        L_0x0083:
            n3.r1 r1 = new n3.r1
            n3.c1 r12 = r4.d()
            r1.<init>(r12, r10)
        L_0x008c:
            r11.f11082i = r2
            n3.k5 r12 = r11.f11086m
            java.lang.Object r12 = r12.g(r1, r11)
            if (r12 != r0) goto L_0x0097
            return r0
        L_0x0097:
            la.v r12 = la.v.f9814a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.c2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object k(Object obj, Object obj2, Object obj3, Object obj4) {
        c2 c2Var = new c2(this.f11086m, (e) obj4, this.f11087n);
        c2Var.f11083j = obj;
        c2Var.f11084k = obj2;
        c2Var.f11085l = (y) obj3;
        return c2Var.invokeSuspend(v.f9814a);
    }
}
