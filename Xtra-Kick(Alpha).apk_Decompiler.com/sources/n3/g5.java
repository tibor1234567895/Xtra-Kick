package n3;

import hb.f0;
import jb.b;
import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class g5 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public b f11209i;

    /* renamed from: j  reason: collision with root package name */
    public int f11210j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11211k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ j f11212l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ p f11213m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g5(j jVar, p pVar, e eVar) {
        super(2, eVar);
        this.f11212l = jVar;
        this.f11213m = pVar;
    }

    public final e create(Object obj, e eVar) {
        g5 g5Var = new g5(this.f11212l, this.f11213m, eVar);
        g5Var.f11211k = obj;
        return g5Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((g5) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r9.f11210j
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x002d
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            jb.b r1 = r9.f11209i
            java.lang.Object r5 = r9.f11211k
            hb.l1 r5 = (hb.l1) r5
            hb.h0.O1(r10)
            goto L_0x004c
        L_0x0017:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001f:
            jb.b r1 = r9.f11209i
            java.lang.Object r5 = r9.f11211k
            hb.l1 r5 = (hb.l1) r5
            hb.h0.O1(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0060
        L_0x002d:
            hb.h0.O1(r10)
            java.lang.Object r10 = r9.f11211k
            hb.f0 r10 = (hb.f0) r10
            r1 = 6
            r5 = 0
            jb.c r1 = hb.h0.a(r5, r4, r1)
            n3.f5 r6 = new n3.f5
            wa.p r7 = r9.f11213m
            r6.<init>(r1, r7, r4)
            r7 = 3
            hb.c2 r5 = hb.h0.b1(r10, r4, r5, r6, r7)
            jb.b r10 = new jb.b
            r10.<init>(r1)
            r1 = r10
        L_0x004c:
            r10 = r9
        L_0x004d:
            r10.f11211k = r5
            r10.f11209i = r1
            r10.f11210j = r3
            java.lang.Object r6 = r1.b(r10)
            if (r6 != r0) goto L_0x005a
            return r0
        L_0x005a:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x0060:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0080
            java.lang.Object r10 = r5.c()
            r0.f11211k = r6
            r0.f11209i = r5
            r0.f11210j = r2
            kb.j r7 = r0.f11212l
            java.lang.Object r10 = r7.a(r10, r0)
            if (r10 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r10 = r0
            r0 = r1
            r1 = r5
            r5 = r6
            goto L_0x004d
        L_0x0080:
            r6.e(r4)
            la.v r10 = la.v.f9814a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.g5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
