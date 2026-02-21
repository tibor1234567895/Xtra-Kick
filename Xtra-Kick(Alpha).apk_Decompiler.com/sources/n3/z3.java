package n3;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;
import xa.q;

public final class z3 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public n3 f11613i;

    /* renamed from: j  reason: collision with root package name */
    public q f11614j;

    /* renamed from: k  reason: collision with root package name */
    public int f11615k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ s1 f11616l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ g f11617m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z3(s1 s1Var, g gVar, e eVar) {
        super(2, eVar);
        this.f11616l = s1Var;
        this.f11617m = gVar;
    }

    public final e create(Object obj, e eVar) {
        return new z3(this.f11616l, this.f11617m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((z3) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0375 A[LOOP:2: B:161:0x036f->B:163:0x0375, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0240  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r6 = r16
            qa.a r7 = qa.a.COROUTINE_SUSPENDED
            int r0 = r6.f11615k
            r8 = 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0027
            if (r0 == r1) goto L_0x001c
            if (r0 != r8) goto L_0x0014
            hb.h0.O1(r17)
            goto L_0x00d7
        L_0x0014:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x001c:
            xa.q r0 = r6.f11614j
            n3.n3 r1 = r6.f11613i
            hb.h0.O1(r17)
            r10 = r0
            r0 = r17
            goto L_0x006b
        L_0x0027:
            hb.h0.O1(r17)
            n3.s1 r0 = r6.f11616l
            boolean r3 = r0 instanceof n3.q1
            if (r3 == 0) goto L_0x00c6
            n3.q1 r0 = (n3.q1) r0
            n3.d1 r0 = r0.f11422a
            n3.d1 r3 = n3.d1.REFRESH
            if (r0 != r3) goto L_0x00c6
            n3.g r0 = r6.f11617m
            r0.f11171h = r2
            n3.n3 r9 = new n3.n3
            n3.s1 r0 = r6.f11616l
            n3.q1 r0 = (n3.q1) r0
            r9.<init>(r0)
            xa.q r10 = new xa.q
            r10.<init>()
            n3.g r0 = r6.f11617m
            n3.n3 r3 = r0.f11166c
            int r4 = r0.f11172i
            n3.y3 r5 = new n3.y3
            n3.g r11 = r6.f11617m
            r5.<init>(r11, r9, r10, r2)
            r6.f11613i = r9
            r6.f11614j = r10
            r6.f11615k = r1
            r1 = r3
            r2 = r9
            r3 = r4
            r4 = r5
            r5 = r16
            java.lang.Object r0 = r0.c(r1, r2, r3, r4, r5)
            if (r0 != r7) goto L_0x006a
            return r7
        L_0x006a:
            r1 = r9
        L_0x006b:
            java.lang.Integer r0 = (java.lang.Integer) r0
            boolean r2 = r10.f16814h
            if (r2 == 0) goto L_0x00ba
            n3.g r2 = r6.f11617m
            n3.s1 r3 = r6.f11616l
            n3.q1 r3 = (n3.q1) r3
            n3.c1 r4 = r3.f11426e
            n3.c1 r3 = r3.f11427f
            r2.a(r4, r3)
            if (r0 != 0) goto L_0x009d
            n3.g r0 = r6.f11617m
            n3.v5 r0 = r0.f11167d
            if (r0 != 0) goto L_0x0088
            goto L_0x035d
        L_0x0088:
            int r2 = r1.f11356b
            n3.z5 r3 = new n3.z5
            int r2 = r2 / r8
            int r4 = r1.d()
            int r1 = r1.e()
            r3.<init>(r2, r2, r4, r1)
            r0.b(r3)
            goto L_0x035d
        L_0x009d:
            n3.g r2 = r6.f11617m
            int r3 = r0.intValue()
            r2.f11172i = r3
            n3.g r2 = r6.f11617m
            n3.v5 r2 = r2.f11167d
            if (r2 != 0) goto L_0x00ad
            goto L_0x035d
        L_0x00ad:
            int r0 = r0.intValue()
            n3.y5 r0 = r1.a(r0)
            r2.b(r0)
            goto L_0x035d
        L_0x00ba:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Missing call to onListPresentable after new list was presented. If you are seeing this exception, it is generally an indication of an issue with Paging. Please file a bug so we can fix it at: https://issuetracker.google.com/issues/new?component=413106"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00c6:
            n3.g r0 = r6.f11617m
            n3.i r0 = r0.f11176m
            boolean r0 = r0.f11239e
            if (r0 == 0) goto L_0x00d7
            r6.f11615k = r8
            java.lang.Object r0 = hb.h0.e2(r16)
            if (r0 != r7) goto L_0x00d7
            return r7
        L_0x00d7:
            n3.g r0 = r6.f11617m
            n3.n3 r3 = r0.f11166c
            n3.s1 r4 = r6.f11616l
            n3.b4 r0 = r0.f11173j
            r3.getClass()
            java.lang.String r5 = "pageEvent"
            xa.j.f(r5, r4)
            java.lang.String r5 = "callback"
            xa.j.f(r5, r0)
            boolean r5 = r4 instanceof n3.q1
            n3.d1 r7 = n3.d1.APPEND
            n3.d1 r9 = n3.d1.PREPEND
            java.lang.String r10 = "source"
            if (r5 == 0) goto L_0x01e0
            n3.q1 r4 = (n3.q1) r4
            java.util.List r5 = r4.f11423b
            java.util.Iterator r11 = r5.iterator()
            r12 = 0
        L_0x00ff:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0113
            java.lang.Object r13 = r11.next()
            n3.u5 r13 = (n3.u5) r13
            java.util.List r13 = r13.f11514b
            int r13 = r13.size()
            int r12 = r12 + r13
            goto L_0x00ff
        L_0x0113:
            int r11 = r3.f()
            n3.d1 r13 = r4.f11422a
            int r13 = r13.ordinal()
            if (r13 == 0) goto L_0x01da
            java.util.ArrayList r14 = r3.f11355a
            if (r13 == r1) goto L_0x016f
            if (r13 == r8) goto L_0x0127
            goto L_0x01cc
        L_0x0127:
            int r8 = r3.f11358d
            int r8 = java.lang.Math.min(r8, r12)
            int r13 = r3.f11357c
            int r15 = r3.f11356b
            int r13 = r13 + r15
            int r15 = r12 - r8
            int r1 = r13 + r8
            int r2 = r14.size()
            r14.addAll(r2, r5)
            int r2 = r3.f11356b
            int r2 = r2 + r12
            r3.f11356b = r2
            int r2 = r4.f11425d
            r3.f11358d = r2
            r0.a(r13, r8)
            n3.g r2 = r0.f11066a
            n3.h r2 = r2.f11164a
            if (r15 <= 0) goto L_0x0157
            n3.i r2 = r2.f11214a
            androidx.recyclerview.widget.x0 r2 = r2.f11236b
            r2.c(r1, r15)
            goto L_0x015a
        L_0x0157:
            r2.getClass()
        L_0x015a:
            int r1 = r3.f()
            int r1 = r1 - r11
            int r1 = r1 - r15
            if (r1 <= 0) goto L_0x0168
            int r2 = r3.f()
            int r2 = r2 - r1
            goto L_0x01a5
        L_0x0168:
            if (r1 >= 0) goto L_0x01cc
            int r2 = r3.f()
            goto L_0x01ba
        L_0x016f:
            int r1 = r3.f11357c
            int r1 = java.lang.Math.min(r1, r12)
            int r2 = r3.f11357c
            int r2 = r2 - r1
            int r8 = r12 - r1
            r13 = 0
            r14.addAll(r13, r5)
            int r5 = r3.f11356b
            int r5 = r5 + r12
            r3.f11356b = r5
            int r5 = r4.f11424c
            r3.f11357c = r5
            r0.a(r2, r1)
            n3.g r1 = r0.f11066a
            n3.h r1 = r1.f11164a
            if (r8 <= 0) goto L_0x0199
            n3.i r1 = r1.f11214a
            androidx.recyclerview.widget.x0 r1 = r1.f11236b
            r2 = 0
            r1.c(r2, r8)
            goto L_0x019c
        L_0x0199:
            r1.getClass()
        L_0x019c:
            int r1 = r3.f()
            int r1 = r1 - r11
            int r1 = r1 - r8
            if (r1 <= 0) goto L_0x01b7
            r2 = 0
        L_0x01a5:
            n3.g r3 = r0.f11066a
            n3.h r3 = r3.f11164a
            if (r1 <= 0) goto L_0x01b3
            n3.i r3 = r3.f11214a
            androidx.recyclerview.widget.x0 r3 = r3.f11236b
            r3.c(r2, r1)
            goto L_0x01cc
        L_0x01b3:
            r3.getClass()
            goto L_0x01cc
        L_0x01b7:
            if (r1 >= 0) goto L_0x01cc
            r2 = 0
        L_0x01ba:
            int r1 = -r1
            n3.g r3 = r0.f11066a
            n3.h r3 = r3.f11164a
            if (r1 <= 0) goto L_0x01c9
            n3.i r3 = r3.f11214a
            androidx.recyclerview.widget.x0 r3 = r3.f11236b
            r3.a(r2, r1)
            goto L_0x01cc
        L_0x01c9:
            r3.getClass()
        L_0x01cc:
            n3.c1 r1 = r4.f11426e
            n3.c1 r2 = r4.f11427f
            xa.j.f(r10, r1)
            n3.g r0 = r0.f11066a
            r0.a(r1, r2)
            goto L_0x02c2
        L_0x01da:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x01e0:
            boolean r1 = r4 instanceof n3.o1
            if (r1 == 0) goto L_0x02b0
            n3.o1 r4 = (n3.o1) r4
            int r1 = r3.f()
            n3.d1 r2 = r4.f11371a
            int r5 = r4.f11373c
            int r8 = r4.f11372b
            int r4 = r4.f11374d
            if (r2 != r9) goto L_0x024f
            int r2 = r3.f11357c
            cb.e r10 = new cb.e
            r10.<init>(r8, r5)
            int r5 = r3.b(r10)
            int r8 = r3.f11356b
            int r8 = r8 - r5
            r3.f11356b = r8
            r3.f11357c = r4
            int r3 = r3.f()
            int r3 = r3 - r1
            if (r3 <= 0) goto L_0x0220
            n3.g r1 = r0.f11066a
            n3.h r1 = r1.f11164a
            if (r3 <= 0) goto L_0x021c
            n3.i r1 = r1.f11214a
            androidx.recyclerview.widget.x0 r1 = r1.f11236b
            r5 = 0
            r1.c(r5, r3)
            goto L_0x0237
        L_0x021c:
            r1.getClass()
            goto L_0x0237
        L_0x0220:
            if (r3 >= 0) goto L_0x0237
            int r1 = -r3
            n3.g r5 = r0.f11066a
            n3.h r5 = r5.f11164a
            if (r1 <= 0) goto L_0x0232
            n3.i r5 = r5.f11214a
            androidx.recyclerview.widget.x0 r5 = r5.f11236b
            r8 = 0
            r5.a(r8, r1)
            goto L_0x0238
        L_0x0232:
            r8 = 0
            r5.getClass()
            goto L_0x0238
        L_0x0237:
            r8 = 0
        L_0x0238:
            int r2 = r2 + r3
            int r1 = java.lang.Math.max(r8, r2)
            int r4 = r4 - r1
            if (r4 <= 0) goto L_0x0243
            r0.a(r1, r4)
        L_0x0243:
            n3.y0 r1 = n3.z0.f11599b
            r1.getClass()
            n3.z0 r1 = n3.z0.f11601d
            r0.b(r9, r1)
            goto L_0x02c2
        L_0x024f:
            int r2 = r3.f11358d
            cb.e r10 = new cb.e
            r10.<init>(r8, r5)
            int r5 = r3.b(r10)
            int r8 = r3.f11356b
            int r8 = r8 - r5
            r3.f11356b = r8
            r3.f11358d = r4
            int r5 = r3.f()
            int r5 = r5 - r1
            if (r5 <= 0) goto L_0x027a
            n3.g r8 = r0.f11066a
            n3.h r8 = r8.f11164a
            if (r5 <= 0) goto L_0x0276
            n3.i r8 = r8.f11214a
            androidx.recyclerview.widget.x0 r8 = r8.f11236b
            r8.c(r1, r5)
            goto L_0x028f
        L_0x0276:
            r8.getClass()
            goto L_0x028f
        L_0x027a:
            if (r5 >= 0) goto L_0x028f
            int r1 = r1 + r5
            int r8 = -r5
            n3.g r10 = r0.f11066a
            n3.h r10 = r10.f11164a
            if (r8 <= 0) goto L_0x028c
            n3.i r10 = r10.f11214a
            androidx.recyclerview.widget.x0 r10 = r10.f11236b
            r10.a(r1, r8)
            goto L_0x028f
        L_0x028c:
            r10.getClass()
        L_0x028f:
            if (r5 >= 0) goto L_0x0297
            int r1 = -r5
            int r1 = java.lang.Math.min(r2, r1)
            goto L_0x0298
        L_0x0297:
            r1 = 0
        L_0x0298:
            int r2 = r2 - r1
            int r1 = r4 - r2
            if (r1 <= 0) goto L_0x02a5
            int r2 = r3.f()
            int r2 = r2 - r4
            r0.a(r2, r1)
        L_0x02a5:
            n3.y0 r1 = n3.z0.f11599b
            r1.getClass()
            n3.z0 r1 = n3.z0.f11601d
            r0.b(r7, r1)
            goto L_0x02c2
        L_0x02b0:
            boolean r1 = r4 instanceof n3.r1
            if (r1 == 0) goto L_0x02c2
            n3.r1 r4 = (n3.r1) r4
            n3.c1 r1 = r4.f11453a
            n3.c1 r2 = r4.f11454b
            xa.j.f(r10, r1)
            n3.g r0 = r0.f11066a
            r0.a(r1, r2)
        L_0x02c2:
            n3.s1 r0 = r6.f11616l
            boolean r0 = r0 instanceof n3.o1
            if (r0 == 0) goto L_0x02cd
            n3.g r0 = r6.f11617m
            r1 = 0
            r0.f11171h = r1
        L_0x02cd:
            n3.s1 r0 = r6.f11616l
            boolean r1 = r0 instanceof n3.q1
            if (r1 == 0) goto L_0x035d
            n3.g r1 = r6.f11617m
            n3.g1 r1 = r1.f11168e
            n3.c1 r1 = r1.f11185f
            n3.a1 r2 = r1.f11080b
            boolean r2 = r2.f11039a
            n3.a1 r1 = r1.f11081c
            boolean r1 = r1.f11039a
            n3.q1 r0 = (n3.q1) r0
            n3.d1 r3 = r0.f11422a
            if (r3 != r9) goto L_0x02e9
            if (r2 != 0) goto L_0x02ee
        L_0x02e9:
            if (r3 != r7) goto L_0x02f0
            if (r1 != 0) goto L_0x02ee
            goto L_0x02f0
        L_0x02ee:
            r13 = 0
            goto L_0x02f1
        L_0x02f0:
            r13 = 1
        L_0x02f1:
            java.util.List r0 = r0.f11423b
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x02fe
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x02fe
            goto L_0x0318
        L_0x02fe:
            java.util.Iterator r0 = r0.iterator()
        L_0x0302:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0318
            java.lang.Object r1 = r0.next()
            n3.u5 r1 = (n3.u5) r1
            java.util.List r1 = r1.f11514b
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0302
            r0 = 0
            goto L_0x0319
        L_0x0318:
            r0 = 1
        L_0x0319:
            if (r13 != 0) goto L_0x031f
            n3.g r0 = r6.f11617m
        L_0x031d:
            r1 = 0
            goto L_0x035b
        L_0x031f:
            n3.g r1 = r6.f11617m
            boolean r1 = r1.f11171h
            if (r1 != 0) goto L_0x0327
            if (r0 == 0) goto L_0x035d
        L_0x0327:
            if (r0 != 0) goto L_0x0345
            n3.g r0 = r6.f11617m
            int r0 = r0.f11172i
            n3.g r1 = r6.f11617m
            n3.n3 r2 = r1.f11166c
            int r2 = r2.f11357c
            if (r0 < r2) goto L_0x0345
            int r0 = r1.f11172i
            n3.g r1 = r6.f11617m
            n3.n3 r1 = r1.f11166c
            int r2 = r1.f11357c
            int r1 = r1.f11356b
            int r2 = r2 + r1
            if (r0 <= r2) goto L_0x0343
            goto L_0x0345
        L_0x0343:
            r1 = 0
            goto L_0x0346
        L_0x0345:
            r1 = 1
        L_0x0346:
            n3.g r0 = r6.f11617m
            if (r1 == 0) goto L_0x031d
            n3.v5 r1 = r0.f11167d
            if (r1 != 0) goto L_0x034f
            goto L_0x035d
        L_0x034f:
            n3.n3 r2 = r0.f11166c
            int r0 = r0.f11172i
            n3.y5 r0 = r2.a(r0)
            r1.b(r0)
            goto L_0x035d
        L_0x035b:
            r0.f11171h = r1
        L_0x035d:
            n3.s1 r0 = r6.f11616l
            boolean r1 = r0 instanceof n3.q1
            if (r1 != 0) goto L_0x0367
            boolean r0 = r0 instanceof n3.o1
            if (r0 == 0) goto L_0x037f
        L_0x0367:
            n3.g r0 = r6.f11617m
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.f11169f
            java.util.Iterator r0 = r0.iterator()
        L_0x036f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x037f
            java.lang.Object r1 = r0.next()
            wa.a r1 = (wa.a) r1
            r1.b()
            goto L_0x036f
        L_0x037f:
            la.v r0 = la.v.f9814a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.z3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
