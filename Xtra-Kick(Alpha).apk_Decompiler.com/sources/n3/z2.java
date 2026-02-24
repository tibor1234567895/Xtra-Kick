package n3;

import kb.j;
import la.v;
import ob.d;
import pa.e;
import ra.i;
import wa.p;

public final class z2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public d f11608i;

    /* renamed from: j  reason: collision with root package name */
    public j f11609j;

    /* renamed from: k  reason: collision with root package name */
    public int f11610k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f11611l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ g3 f11612m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z2(g3 g3Var, e eVar) {
        super(2, eVar);
        this.f11612m = g3Var;
    }

    public final e create(Object obj, e eVar) {
        z2 z2Var = new z2(this.f11612m, eVar);
        z2Var.f11611l = obj;
        return z2Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((z2) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kb.j} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r5.f11610k
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 == r3) goto L_0x0018
            if (r1 != r2) goto L_0x0010
            hb.h0.O1(r6)
            goto L_0x0062
        L_0x0010:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0018:
            kb.j r1 = r5.f11609j
            ob.d r3 = r5.f11608i
            java.lang.Object r4 = r5.f11611l
            n3.h3 r4 = (n3.h3) r4
            hb.h0.O1(r6)
            goto L_0x0042
        L_0x0024:
            hb.h0.O1(r6)
            java.lang.Object r6 = r5.f11611l
            r1 = r6
            kb.j r1 = (kb.j) r1
            n3.g3 r6 = r5.f11612m
            n3.h3 r4 = r6.f11205l
            ob.d r6 = r4.f11229a
            r5.f11611l = r4
            r5.f11608i = r6
            r5.f11609j = r1
            r5.f11610k = r3
            java.lang.Object r3 = r6.e(r5)
            if (r3 != r0) goto L_0x0041
            return r0
        L_0x0041:
            r3 = r6
        L_0x0042:
            r6 = 0
            n3.l3 r4 = r4.f11230b     // Catch:{ all -> 0x0065 }
            n3.h1 r4 = r4.f11319l     // Catch:{ all -> 0x0065 }
            n3.c1 r4 = r4.d()     // Catch:{ all -> 0x0065 }
            r3.f(r6)
            n3.r1 r3 = new n3.r1
            r3.<init>(r4, r6)
            r5.f11611l = r6
            r5.f11608i = r6
            r5.f11609j = r6
            r5.f11610k = r2
            java.lang.Object r6 = r1.a(r3, r5)
            if (r6 != r0) goto L_0x0062
            return r0
        L_0x0062:
            la.v r6 = la.v.f9814a
            return r6
        L_0x0065:
            r0 = move-exception
            r3.f(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.z2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
