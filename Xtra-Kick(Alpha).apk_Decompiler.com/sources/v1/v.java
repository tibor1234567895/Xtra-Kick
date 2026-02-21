package v1;

import a2.e;
import g1.r1;
import g1.t1;
import g1.u1;
import j1.a;

public final class v extends m1 {

    /* renamed from: l  reason: collision with root package name */
    public final boolean f15806l;

    /* renamed from: m  reason: collision with root package name */
    public final t1 f15807m;

    /* renamed from: n  reason: collision with root package name */
    public final r1 f15808n;

    /* renamed from: o  reason: collision with root package name */
    public t f15809o;

    /* renamed from: p  reason: collision with root package name */
    public s f15810p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f15811q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f15812r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15813s;

    public v(a aVar, boolean z10) {
        super(aVar);
        boolean z11;
        if (!z10 || !aVar.i()) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f15806l = z11;
        this.f15807m = new t1();
        this.f15808n = new r1();
        u1 g10 = aVar.g();
        if (g10 != null) {
            this.f15809o = new t(g10, (Object) null, (Object) null);
            this.f15813s = true;
            return;
        }
        this.f15809o = new t(new u(aVar.h()), t1.f6573y, t.f15785p);
    }

    /* renamed from: A */
    public final s b(a0 a0Var, e eVar, long j10) {
        boolean z10;
        s sVar = new s(a0Var, eVar, j10);
        if (sVar.f15781k == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        a aVar = this.f15722k;
        sVar.f15781k = aVar;
        if (this.f15812r) {
            Object obj = this.f15809o.f15787o;
            Object obj2 = a0Var.f6678a;
            if (obj != null && obj2.equals(t.f15785p)) {
                obj2 = this.f15809o.f15787o;
            }
            sVar.a(a0Var.b(obj2));
        } else {
            this.f15810p = sVar;
            if (!this.f15811q) {
                this.f15811q = true;
                w((Object) null, aVar);
            }
        }
        return sVar;
    }

    public final void B(long j10) {
        s sVar = this.f15810p;
        int k10 = this.f15809o.k(sVar.f15778h.f6678a);
        if (k10 != -1) {
            t tVar = this.f15809o;
            r1 r1Var = this.f15808n;
            tVar.o(k10, r1Var, false);
            long j11 = r1Var.f6545k;
            if (j11 != -9223372036854775807L && j10 >= j11) {
                j10 = Math.max(0, j11 - 1);
            }
            sVar.f15784n = j10;
        }
    }

    public final void j() {
    }

    public final void n(y yVar) {
        ((s) yVar).b();
        if (yVar == this.f15810p) {
            this.f15810p = null;
        }
    }

    public final void p() {
        this.f15812r = false;
        this.f15811q = false;
        super.p();
    }

    public final a0 x(a0 a0Var) {
        Object obj = a0Var.f6678a;
        Object obj2 = this.f15809o.f15787o;
        if (obj2 != null && obj2.equals(obj)) {
            obj = t.f15785p;
        }
        return a0Var.b(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y(g1.u1 r15) {
        /*
            r14 = this;
            boolean r0 = r14.f15812r
            if (r0 == 0) goto L_0x001c
            v1.t r0 = r14.f15809o
            v1.t r1 = new v1.t
            java.lang.Object r2 = r0.f15786n
            java.lang.Object r0 = r0.f15787o
            r1.<init>(r15, r2, r0)
            r14.f15809o = r1
            v1.s r15 = r14.f15810p
            if (r15 == 0) goto L_0x00bb
            long r0 = r15.f15784n
            r14.B(r0)
            goto L_0x00bb
        L_0x001c:
            boolean r0 = r15.y()
            if (r0 == 0) goto L_0x0040
            boolean r0 = r14.f15813s
            if (r0 == 0) goto L_0x0032
            v1.t r0 = r14.f15809o
            v1.t r1 = new v1.t
            java.lang.Object r2 = r0.f15786n
            java.lang.Object r0 = r0.f15787o
            r1.<init>(r15, r2, r0)
            goto L_0x003c
        L_0x0032:
            java.lang.Object r0 = g1.t1.f6573y
            java.lang.Object r1 = v1.t.f15785p
            v1.t r2 = new v1.t
            r2.<init>(r15, r0, r1)
            r1 = r2
        L_0x003c:
            r14.f15809o = r1
            goto L_0x00bb
        L_0x0040:
            r0 = 0
            g1.t1 r1 = r14.f15807m
            r15.v(r0, r1)
            long r2 = r1.f6587t
            java.lang.Object r4 = r1.f6575h
            v1.s r5 = r14.f15810p
            if (r5 == 0) goto L_0x006c
            v1.t r6 = r14.f15809o
            v1.a0 r7 = r5.f15778h
            java.lang.Object r7 = r7.f6678a
            g1.r1 r8 = r14.f15808n
            r6.p(r7, r8)
            long r6 = r8.f6546l
            long r8 = r5.f15779i
            long r6 = r6 + r8
            v1.t r5 = r14.f15809o
            g1.t1 r0 = r5.v(r0, r1)
            long r0 = r0.f6587t
            int r5 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x006c
            r12 = r6
            goto L_0x006d
        L_0x006c:
            r12 = r2
        L_0x006d:
            g1.t1 r9 = r14.f15807m
            g1.r1 r10 = r14.f15808n
            r11 = 0
            r8 = r15
            android.util.Pair r0 = r8.r(r9, r10, r11, r12)
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            boolean r0 = r14.f15813s
            if (r0 == 0) goto L_0x0091
            v1.t r0 = r14.f15809o
            v1.t r1 = new v1.t
            java.lang.Object r4 = r0.f15786n
            java.lang.Object r0 = r0.f15787o
            r1.<init>(r15, r4, r0)
            goto L_0x0097
        L_0x0091:
            v1.t r0 = new v1.t
            r0.<init>(r15, r4, r1)
            r1 = r0
        L_0x0097:
            r14.f15809o = r1
            v1.s r15 = r14.f15810p
            if (r15 == 0) goto L_0x00bb
            r14.B(r2)
            v1.a0 r15 = r15.f15778h
            java.lang.Object r0 = r15.f6678a
            v1.t r1 = r14.f15809o
            java.lang.Object r1 = r1.f15787o
            if (r1 == 0) goto L_0x00b6
            java.lang.Object r1 = v1.t.f15785p
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00b6
            v1.t r0 = r14.f15809o
            java.lang.Object r0 = r0.f15787o
        L_0x00b6:
            v1.a0 r15 = r15.b(r0)
            goto L_0x00bc
        L_0x00bb:
            r15 = 0
        L_0x00bc:
            r0 = 1
            r14.f15813s = r0
            r14.f15812r = r0
            v1.t r0 = r14.f15809o
            r14.m(r0)
            if (r15 == 0) goto L_0x00d0
            v1.s r0 = r14.f15810p
            r0.getClass()
            r0.a(r15)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.v.y(g1.u1):void");
    }

    public final void z() {
        if (!this.f15806l) {
            this.f15811q = true;
            w((Object) null, this.f15722k);
        }
    }
}
