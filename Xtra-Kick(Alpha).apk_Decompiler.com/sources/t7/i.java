package t7;

import kb.j;
import la.v;
import pa.e;
import wa.p;

public final class i extends ra.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14692i;

    /* renamed from: j  reason: collision with root package name */
    public int f14693j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f14694k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f14695l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ k f14696m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(int i10, k kVar, e eVar) {
        super(2, eVar);
        this.f14695l = i10;
        this.f14696m = kVar;
    }

    public final e create(Object obj, e eVar) {
        i iVar = new i(this.f14695l, this.f14696m, eVar);
        iVar.f14694k = obj;
        return iVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((i) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r9.f14693j
            r2 = -1
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r5) goto L_0x0024
            if (r1 == r4) goto L_0x0019
            if (r1 != r3) goto L_0x0011
            goto L_0x0024
        L_0x0011:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0019:
            int r1 = r9.f14692i
            java.lang.Object r6 = r9.f14694k
            kb.j r6 = (kb.j) r6
            hb.h0.O1(r10)
            r10 = r9
            goto L_0x006c
        L_0x0024:
            int r1 = r9.f14692i
            java.lang.Object r6 = r9.f14694k
            kb.j r6 = (kb.j) r6
            hb.h0.O1(r10)
            r10 = r9
            goto L_0x007b
        L_0x002f:
            hb.h0.O1(r10)
            java.lang.Object r10 = r9.f14694k
            kb.j r10 = (kb.j) r10
            int r1 = r9.f14695l
            r6 = r10
            r10 = r9
        L_0x003a:
            if (r2 >= r1) goto L_0x007d
            t7.k r7 = r10.f14696m
            boolean r7 = r7.f14709h
            if (r7 != 0) goto L_0x005a
            cb.a r7 = cb.b.f3062k
            r7.getClass()
            cb.b r7 = new cb.b
            r8 = 0
            r7.<init>(r1, r8, r2)
            r10.f14694k = r6
            r10.f14692i = r1
            r10.f14693j = r5
            java.lang.Object r7 = r6.a(r7, r10)
            if (r7 != r0) goto L_0x007b
            return r0
        L_0x005a:
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r1)
            r10.f14694k = r6
            r10.f14692i = r1
            r10.f14693j = r4
            java.lang.Object r7 = r6.a(r7, r10)
            if (r7 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r10.f14694k = r6
            r10.f14692i = r1
            r10.f14693j = r3
            r7 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = hb.h0.L(r7, r10)
            if (r7 != r0) goto L_0x007b
            return r0
        L_0x007b:
            int r1 = r1 + r2
            goto L_0x003a
        L_0x007d:
            la.v r10 = la.v.f9814a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
