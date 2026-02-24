package n3;

import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class v1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11517i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11518j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ d5 f11519k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v1(d5 d5Var, e eVar) {
        super(2, eVar);
        this.f11519k = d5Var;
    }

    public final e create(Object obj, e eVar) {
        v1 v1Var = new v1(this.f11519k, eVar);
        v1Var.f11518j = obj;
        return v1Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((v1) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kb.j} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r6.f11517i
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 == r4) goto L_0x0019
            if (r1 != r3) goto L_0x0011
            hb.h0.O1(r7)
            goto L_0x0053
        L_0x0011:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0019:
            java.lang.Object r1 = r6.f11518j
            kb.j r1 = (kb.j) r1
            hb.h0.O1(r7)
            goto L_0x003c
        L_0x0021:
            hb.h0.O1(r7)
            java.lang.Object r7 = r6.f11518j
            r1 = r7
            kb.j r1 = (kb.j) r1
            n3.d5 r7 = r6.f11519k
            if (r7 != 0) goto L_0x002f
            r7 = r2
            goto L_0x003e
        L_0x002f:
            r6.f11518j = r1
            r6.f11517i = r4
            n3.c5 r7 = (n3.c5) r7
            java.lang.Object r7 = r7.a(r6)
            if (r7 != r0) goto L_0x003c
            return r0
        L_0x003c:
            n3.p4 r7 = (n3.p4) r7
        L_0x003e:
            n3.p4 r5 = n3.p4.LAUNCH_INITIAL_REFRESH
            if (r7 != r5) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r4 = 0
        L_0x0044:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)
            r6.f11518j = r2
            r6.f11517i = r3
            java.lang.Object r7 = r1.a(r7, r6)
            if (r7 != r0) goto L_0x0053
            return r0
        L_0x0053:
            la.v r7 = la.v.f9814a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.v1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
