package n3;

import la.v;
import pa.e;
import ra.i;
import wa.l;

public final class x4 extends i implements l {

    /* renamed from: i  reason: collision with root package name */
    public int f11567i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c5 f11568j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x4(c5 c5Var, e eVar) {
        super(1, eVar);
        this.f11568j = c5Var;
    }

    public final e create(e eVar) {
        return new x4(this.f11568j, eVar);
    }

    public final Object invoke(Object obj) {
        return ((x4) create((e) obj)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r6.f11567i
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            hb.h0.O1(r7)
            r1 = r0
            r0 = r6
            goto L_0x0043
        L_0x000f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0017:
            hb.h0.O1(r7)
            r7 = r6
        L_0x001b:
            n3.c5 r1 = r7.f11568j
            n3.d r3 = r1.f11095c
            n3.w4 r4 = n3.w4.f11541h
            java.lang.Object r3 = r3.a(r4)
            la.i r3 = (la.i) r3
            if (r3 != 0) goto L_0x002c
            la.v r7 = la.v.f9814a
            return r7
        L_0x002c:
            java.lang.Object r4 = r3.f9799h
            n3.d1 r4 = (n3.d1) r4
            java.lang.Object r3 = r3.f9800i
            n3.o4 r3 = (n3.o4) r3
            r7.f11567i = r2
            n3.r4 r1 = r1.f11094b
            java.lang.Object r1 = r1.a()
            if (r1 != r0) goto L_0x003f
            return r0
        L_0x003f:
            r5 = r0
            r0 = r7
            r7 = r1
            r1 = r5
        L_0x0043:
            n3.q4 r7 = (n3.q4) r7
            r7 = r0
            r0 = r1
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.x4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
