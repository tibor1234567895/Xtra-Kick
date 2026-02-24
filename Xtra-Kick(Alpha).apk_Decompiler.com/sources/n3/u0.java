package n3;

import wa.p;
import xa.k;

public final class u0 extends k implements p {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11497h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f11498i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u0(int i10, Object obj) {
        super(2);
        this.f11497h = i10;
        this.f11498i = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        if (r1 == null) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r3.f11497h
            java.lang.Object r1 = r3.f11498i
            switch(r0) {
                case 0: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x003d
        L_0x0008:
            n3.s0 r4 = (n3.s0) r4
            n3.s0 r5 = (n3.s0) r5
            java.lang.String r0 = "prependHint"
            xa.j.f(r0, r4)
            java.lang.String r0 = "appendHint"
            xa.j.f(r0, r5)
            n3.a6 r1 = (n3.a6) r1
            n3.a6 r0 = r4.f11471a
            n3.d1 r2 = n3.d1.PREPEND
            boolean r0 = hb.h0.E1(r1, r0, r2)
            if (r0 == 0) goto L_0x0029
            r4.f11471a = r1
            kb.s0 r4 = r4.f11472b
            r4.h(r1)
        L_0x0029:
            n3.a6 r4 = r5.f11471a
            n3.d1 r0 = n3.d1.APPEND
            boolean r4 = hb.h0.E1(r1, r4, r0)
            if (r4 == 0) goto L_0x003a
            r5.f11471a = r1
            kb.s0 r4 = r5.f11472b
            r4.h(r1)
        L_0x003a:
            la.v r4 = la.v.f9814a
            return r4
        L_0x003d:
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            pa.h r5 = (pa.h) r5
            pa.i r0 = r5.getKey()
            lb.v r1 = (lb.v) r1
            pa.k r1 = r1.f9865i
            pa.h r1 = r1.N(r0)
            hb.k1 r2 = hb.l1.f7823b
            if (r0 == r2) goto L_0x005a
            if (r5 == r1) goto L_0x006f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0071
        L_0x005a:
            hb.l1 r1 = (hb.l1) r1
            hb.l1 r5 = (hb.l1) r5
        L_0x005e:
            r0 = 0
            if (r5 != 0) goto L_0x0063
            r5 = r0
            goto L_0x006a
        L_0x0063:
            if (r5 != r1) goto L_0x0066
            goto L_0x006a
        L_0x0066:
            boolean r2 = r5 instanceof mb.y
            if (r2 != 0) goto L_0x009b
        L_0x006a:
            if (r5 != r1) goto L_0x0076
            if (r1 != 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            int r4 = r4 + 1
        L_0x0071:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            return r4
        L_0x0076:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of "
            r0.<init>(r2)
            r0.append(r5)
            java.lang.String r5 = ", expected child of "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x009b:
            hb.u1 r5 = (hb.u1) r5
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = hb.u1.f7860i
            java.lang.Object r5 = r2.get(r5)
            hb.p r5 = (hb.p) r5
            if (r5 == 0) goto L_0x00ac
            hb.l1 r5 = r5.getParent()
            goto L_0x005e
        L_0x00ac:
            r5 = r0
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.u0.g(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
