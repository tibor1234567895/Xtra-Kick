package q1;

import a2.e;
import a2.i;
import android.os.Looper;
import d9.r0;
import g1.m0;
import g1.n0;
import g1.s0;
import g1.t0;
import k1.f0;
import p1.n;
import p1.u;
import r1.g;
import r1.w;
import r1.x;
import v1.a;
import v1.a0;
import v1.k;
import v1.y;

public final class q extends a implements w {

    /* renamed from: h  reason: collision with root package name */
    public final l f13224h;

    /* renamed from: i  reason: collision with root package name */
    public final n0 f13225i;

    /* renamed from: j  reason: collision with root package name */
    public final c f13226j;

    /* renamed from: k  reason: collision with root package name */
    public final k f13227k;

    /* renamed from: l  reason: collision with root package name */
    public final u f13228l;

    /* renamed from: m  reason: collision with root package name */
    public final i f13229m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f13230n;

    /* renamed from: o  reason: collision with root package name */
    public final int f13231o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f13232p = false;

    /* renamed from: q  reason: collision with root package name */
    public final x f13233q;

    /* renamed from: r  reason: collision with root package name */
    public final long f13234r;

    /* renamed from: s  reason: collision with root package name */
    public final s0 f13235s;

    /* renamed from: t  reason: collision with root package name */
    public m0 f13236t;

    /* renamed from: u  reason: collision with root package name */
    public f0 f13237u;

    static {
        t0.a("media3.exoplayer.hls");
    }

    public q(s0 s0Var, c cVar, d dVar, k kVar, u uVar, i iVar, x xVar, long j10, boolean z10, int i10) {
        n0 n0Var = s0Var.f6557i;
        n0Var.getClass();
        this.f13225i = n0Var;
        this.f13235s = s0Var;
        this.f13236t = s0Var.f6558j;
        this.f13226j = cVar;
        this.f13224h = dVar;
        this.f13227k = kVar;
        this.f13228l = uVar;
        this.f13229m = iVar;
        this.f13233q = xVar;
        this.f13234r = j10;
        this.f13230n = z10;
        this.f13231o = i10;
    }

    public static g s(long j10, r0 r0Var) {
        g gVar = null;
        for (int i10 = 0; i10 < r0Var.size(); i10++) {
            g gVar2 = (g) r0Var.get(i10);
            int i11 = (gVar2.f13570l > j10 ? 1 : (gVar2.f13570l == j10 ? 0 : -1));
            if (i11 <= 0 && gVar2.f13559s) {
                gVar = gVar2;
            } else if (i11 > 0) {
                break;
            }
        }
        return gVar;
    }

    public final y b(a0 a0Var, e eVar, long j10) {
        v1.f0 a10 = a(a0Var);
        p1.q qVar = new p1.q(this.f15559d.f12507c, 0, a0Var);
        l lVar = this.f13224h;
        x xVar = this.f13233q;
        c cVar = this.f13226j;
        f0 f0Var = this.f13237u;
        u uVar = this.f13228l;
        i iVar = this.f13229m;
        k kVar = this.f13227k;
        boolean z10 = this.f13230n;
        int i10 = this.f13231o;
        boolean z11 = this.f13232p;
        n1.f0 f0Var2 = this.f15562g;
        j1.a.f(f0Var2);
        return new p(lVar, xVar, cVar, f0Var, uVar, qVar, iVar, a10, eVar, kVar, z10, i10, z11, f0Var2);
    }

    public final s0 h() {
        return this.f13235s;
    }

    public final void j() {
        this.f13233q.f();
    }

    public final void l(f0 f0Var) {
        this.f13237u = f0Var;
        Looper myLooper = Looper.myLooper();
        myLooper.getClass();
        n1.f0 f0Var2 = this.f15562g;
        j1.a.f(f0Var2);
        u uVar = this.f13228l;
        uVar.f(myLooper, f0Var2);
        uVar.e();
        v1.f0 a10 = a((a0) null);
        this.f13233q.a(this.f13225i.f6478a, a10, this);
    }

    public final void n(y yVar) {
        p pVar = (p) yVar;
        pVar.f13206i.g(pVar);
        for (v vVar : pVar.B) {
            if (vVar.K) {
                for (u uVar : vVar.C) {
                    uVar.i();
                    n nVar = uVar.f15570h;
                    if (nVar != null) {
                        nVar.d(uVar.f15567e);
                        uVar.f15570h = null;
                        uVar.f15569g = null;
                    }
                }
            }
            vVar.f13266q.f(vVar);
            vVar.f13274y.removeCallbacksAndMessages((Object) null);
            vVar.O = true;
            vVar.f13275z.clear();
        }
        pVar.f13222y = null;
    }

    public final void p() {
        this.f13233q.stop();
        this.f13228l.a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: r1.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: r1.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: r1.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: r1.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(r1.l r40) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            boolean r2 = r1.f13594p
            long r5 = r1.f13586h
            if (r2 == 0) goto L_0x0010
            long r7 = j1.l0.Q(r5)
            r12 = r7
            goto L_0x0015
        L_0x0010:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0015:
            r2 = 2
            r7 = 1
            int r8 = r1.f13582d
            if (r8 == r2) goto L_0x0024
            if (r8 != r7) goto L_0x001e
            goto L_0x0024
        L_0x001e:
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0025
        L_0x0024:
            r10 = r12
        L_0x0025:
            q1.m r14 = new q1.m
            r1.x r9 = r0.f13233q
            r1.o r15 = r9.c()
            r15.getClass()
            r14.<init>(r15, r1)
            boolean r15 = r9.b()
            r16 = 0
            r19 = r8
            long r7 = r1.f13599u
            boolean r2 = r1.f13585g
            d9.r0 r3 = r1.f13596r
            r28 = r12
            long r12 = r1.f13583e
            if (r15 == 0) goto L_0x0192
            long r23 = r9.o()
            long r24 = r5 - r23
            boolean r4 = r1.f13593o
            if (r4 == 0) goto L_0x0056
            long r26 = r24 + r7
            r30 = r26
            goto L_0x005b
        L_0x0056:
            r30 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x005b:
            boolean r9 = r1.f13594p
            if (r9 == 0) goto L_0x0082
            int r9 = j1.l0.f8453a
            r32 = r14
            long r14 = r0.f13234r
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x0073
            long r14 = java.lang.System.currentTimeMillis()
            goto L_0x0079
        L_0x0073:
            long r26 = android.os.SystemClock.elapsedRealtime()
            long r14 = r26 + r14
        L_0x0079:
            long r14 = j1.l0.H(r14)
            long r5 = r5 + r7
            long r14 = r14 - r5
            r35 = r14
            goto L_0x0086
        L_0x0082:
            r32 = r14
            r35 = r16
        L_0x0086:
            g1.m0 r5 = r0.f13236t
            long r5 = r5.f6463h
            r1.k r9 = r1.f13600v
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r21 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r21 == 0) goto L_0x009c
            long r5 = j1.l0.H(r5)
        L_0x0099:
            r33 = r5
            goto L_0x00c4
        L_0x009c:
            int r5 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x00a3
            long r5 = r7 - r12
            goto L_0x00c1
        L_0x00a3:
            long r5 = r9.f13580d
            int r21 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r21 == 0) goto L_0x00b4
            r21 = r5
            long r5 = r1.f13592n
            int r23 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r23 == 0) goto L_0x00b4
            r5 = r21
            goto L_0x00c1
        L_0x00b4:
            long r5 = r9.f13579c
            int r23 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r23 == 0) goto L_0x00bb
            goto L_0x00c1
        L_0x00bb:
            r5 = 3
            long r14 = r1.f13591m
            long r5 = r5 * r14
        L_0x00c1:
            long r5 = r5 + r35
            goto L_0x0099
        L_0x00c4:
            long r7 = r7 + r35
            r37 = r7
            long r5 = j1.l0.i(r33, r35, r37)
            g1.s0 r14 = r0.f13235s
            g1.m0 r14 = r14.f6558j
            float r15 = r14.f6466k
            r23 = 0
            r26 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r15 = (r15 > r26 ? 1 : (r15 == r26 ? 0 : -1))
            if (r15 != 0) goto L_0x00f4
            float r14 = r14.f6467l
            int r14 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r14 != 0) goto L_0x00f4
            long r14 = r9.f13579c
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r26 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r26 != 0) goto L_0x00f4
            long r14 = r9.f13580d
            int r9 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x00f4
            r9 = 1
            goto L_0x00f5
        L_0x00f4:
            r9 = 0
        L_0x00f5:
            g1.l0 r14 = new g1.l0
            r14.<init>()
            long r5 = j1.l0.Q(r5)
            r14.f6449a = r5
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r9 == 0) goto L_0x0107
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x010b
        L_0x0107:
            g1.m0 r6 = r0.f13236t
            float r6 = r6.f6466k
        L_0x010b:
            r14.f6452d = r6
            if (r9 == 0) goto L_0x0110
            goto L_0x0114
        L_0x0110:
            g1.m0 r5 = r0.f13236t
            float r5 = r5.f6467l
        L_0x0114:
            r14.f6453e = r5
            g1.m0 r5 = r14.a()
            r0.f13236t = r5
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0126
            goto L_0x012e
        L_0x0126:
            long r5 = r5.f6463h
            long r5 = j1.l0.H(r5)
            long r12 = r7 - r5
        L_0x012e:
            if (r2 == 0) goto L_0x0132
            r2 = r12
            goto L_0x0160
        L_0x0132:
            d9.r0 r2 = r1.f13597s
            r1.g r2 = s(r12, r2)
            if (r2 == 0) goto L_0x013b
            goto L_0x015e
        L_0x013b:
            boolean r2 = r3.isEmpty()
            if (r2 == 0) goto L_0x0144
            r2 = r16
            goto L_0x0160
        L_0x0144:
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r5 = 1
            int r2 = j1.l0.d(r3, r2, r5)
            java.lang.Object r2 = r3.get(r2)
            r1.i r2 = (r1.i) r2
            d9.r0 r3 = r2.f13565t
            r1.g r3 = s(r12, r3)
            if (r3 == 0) goto L_0x015e
            long r2 = r3.f13570l
            goto L_0x0160
        L_0x015e:
            long r2 = r2.f13570l
        L_0x0160:
            r6 = r19
            r5 = 2
            if (r6 != r5) goto L_0x016b
            boolean r5 = r1.f13584f
            if (r5 == 0) goto L_0x016b
            r5 = 1
            goto L_0x016c
        L_0x016b:
            r5 = 0
        L_0x016c:
            v1.f1 r6 = new v1.f1
            r9 = r6
            long r7 = r1.f13599u
            r16 = r7
            r22 = 1
            r1 = 1
            r23 = r4 ^ 1
            g1.s0 r1 = r0.f13235s
            r26 = r1
            g1.m0 r1 = r0.f13236t
            r27 = r1
            r12 = r28
            r4 = r32
            r14 = r30
            r18 = r24
            r20 = r2
            r24 = r5
            r25 = r4
            r9.<init>(r10, r12, r14, r16, r18, r20, r22, r23, r24, r25, r26, r27)
            goto L_0x01e0
        L_0x0192:
            r4 = r14
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x01c1
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x01a3
            goto L_0x01c1
        L_0x01a3:
            if (r2 != 0) goto L_0x01be
            int r2 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x01aa
            goto L_0x01be
        L_0x01aa:
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r5 = 1
            int r2 = j1.l0.d(r3, r2, r5)
            java.lang.Object r2 = r3.get(r2)
            r1.i r2 = (r1.i) r2
            long r2 = r2.f13570l
            r20 = r2
            goto L_0x01c3
        L_0x01be:
            r20 = r12
            goto L_0x01c3
        L_0x01c1:
            r20 = r16
        L_0x01c3:
            v1.f1 r6 = new v1.f1
            r9 = r6
            long r1 = r1.f13599u
            r14 = r1
            r16 = r1
            r18 = 0
            r22 = 1
            r23 = 0
            r24 = 1
            g1.s0 r1 = r0.f13235s
            r26 = r1
            r27 = 0
            r12 = r28
            r25 = r4
            r9.<init>(r10, r12, r14, r16, r18, r20, r22, r23, r24, r25, r26, r27)
        L_0x01e0:
            r0.m(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.q.t(r1.l):void");
    }
}
