package v;

import java.util.ArrayList;
import s.i;
import u.f;

public final class n extends q {

    /* renamed from: k  reason: collision with root package name */
    public final f f15525k;

    /* renamed from: l  reason: collision with root package name */
    public a f15526l = null;

    public n(f fVar) {
        super(fVar);
        f fVar2 = new f(this);
        this.f15525k = fVar2;
        this.f15548h.f15512e = 6;
        this.f15549i.f15512e = 7;
        fVar2.f15512e = 8;
        this.f15546f = 1;
    }

    public final void a(d dVar) {
        int i10;
        float f10;
        if (i.a(this.f15550j) != 3) {
            g gVar = this.f15545e;
            if (gVar.f15510c && !gVar.f15517j && this.f15544d == 3) {
                f fVar = this.f15542b;
                int i11 = fVar.f15116t;
                if (i11 == 2) {
                    f fVar2 = fVar.U;
                    if (fVar2 != null) {
                        g gVar2 = fVar2.f15088e.f15545e;
                        if (gVar2.f15517j) {
                            f10 = ((float) gVar2.f15514g) * fVar.A;
                        }
                    }
                } else if (i11 == 3) {
                    g gVar3 = fVar.f15086d.f15545e;
                    if (gVar3.f15517j) {
                        int i12 = fVar.Y;
                        if (i12 != -1) {
                            if (i12 == 0) {
                                f10 = ((float) gVar3.f15514g) * fVar.X;
                            } else if (i12 != 1) {
                                i10 = 0;
                                gVar.d(i10);
                            }
                        }
                        f10 = ((float) gVar3.f15514g) / fVar.X;
                    }
                }
                i10 = (int) (f10 + 0.5f);
                gVar.d(i10);
            }
            f fVar3 = this.f15548h;
            if (fVar3.f15510c) {
                f fVar4 = this.f15549i;
                if (fVar4.f15510c) {
                    if (!fVar3.f15517j || !fVar4.f15517j || !gVar.f15517j) {
                        boolean z10 = gVar.f15517j;
                        ArrayList arrayList = fVar3.f15519l;
                        ArrayList arrayList2 = fVar4.f15519l;
                        if (!z10 && this.f15544d == 3) {
                            f fVar5 = this.f15542b;
                            if (fVar5.f15115s == 0 && !fVar5.y()) {
                                int i13 = ((f) arrayList.get(0)).f15514g + fVar3.f15513f;
                                int i14 = ((f) arrayList2.get(0)).f15514g + fVar4.f15513f;
                                fVar3.d(i13);
                                fVar4.d(i14);
                                gVar.d(i14 - i13);
                                return;
                            }
                        }
                        if (!gVar.f15517j && this.f15544d == 3 && this.f15541a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                            int i15 = (((f) arrayList2.get(0)).f15514g + fVar4.f15513f) - (((f) arrayList.get(0)).f15514g + fVar3.f15513f);
                            int i16 = gVar.f15520m;
                            if (i15 < i16) {
                                gVar.d(i15);
                            } else {
                                gVar.d(i16);
                            }
                        }
                        if (gVar.f15517j && arrayList.size() > 0 && arrayList2.size() > 0) {
                            f fVar6 = (f) arrayList.get(0);
                            f fVar7 = (f) arrayList2.get(0);
                            int i17 = fVar6.f15514g;
                            int i18 = fVar3.f15513f + i17;
                            int i19 = fVar7.f15514g;
                            int i20 = fVar4.f15513f + i19;
                            float f11 = this.f15542b.f15091f0;
                            if (fVar6 == fVar7) {
                                f11 = 0.5f;
                            } else {
                                i17 = i18;
                                i19 = i20;
                            }
                            fVar3.d((int) ((((float) ((i19 - i17) - gVar.f15514g)) * f11) + ((float) i17) + 0.5f));
                            fVar4.d(fVar3.f15514g + gVar.f15514g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        f fVar8 = this.f15542b;
        l(fVar8.K, fVar8.M, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x025b, code lost:
        if (r15.f15542b.F != false) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0292, code lost:
        if (r0.f15544d == 3) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02b8, code lost:
        if (r15.f15542b.F != false) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0309, code lost:
        if (r0.f15544d == 3) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
        r0 = r15.f15542b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r15 = this;
            u.f r0 = r15.f15542b
            boolean r1 = r0.f15080a
            v.g r2 = r15.f15545e
            if (r1 == 0) goto L_0x000f
            int r0 = r0.l()
            r2.d(r0)
        L_0x000f:
            boolean r0 = r2.f15517j
            v.f r1 = r15.f15549i
            v.f r3 = r15.f15548h
            r4 = 3
            r5 = 1
            r6 = 4
            if (r0 != 0) goto L_0x0084
            u.f r0 = r15.f15542b
            int[] r7 = r0.f15113q0
            r7 = r7[r5]
            r15.f15544d = r7
            boolean r0 = r0.F
            if (r0 == 0) goto L_0x002d
            v.a r0 = new v.a
            r0.<init>(r15)
            r15.f15526l = r0
        L_0x002d:
            int r0 = r15.f15544d
            if (r0 == r4) goto L_0x00b2
            if (r0 != r6) goto L_0x0078
            u.f r7 = r15.f15542b
            u.f r7 = r7.U
            if (r7 == 0) goto L_0x0078
            int[] r8 = r7.f15113q0
            r8 = r8[r5]
            if (r8 != r5) goto L_0x0078
            int r0 = r7.l()
            u.f r4 = r15.f15542b
            u.e r4 = r4.K
            int r4 = r4.e()
            int r0 = r0 - r4
            u.f r4 = r15.f15542b
            u.e r4 = r4.M
            int r4 = r4.e()
            int r0 = r0 - r4
            v.n r4 = r7.f15088e
            v.f r4 = r4.f15548h
            u.f r5 = r15.f15542b
            u.e r5 = r5.K
            int r5 = r5.e()
            v.q.b(r3, r4, r5)
            v.n r3 = r7.f15088e
            v.f r3 = r3.f15549i
            u.f r4 = r15.f15542b
            u.e r4 = r4.M
            int r4 = r4.e()
            int r4 = -r4
            v.q.b(r1, r3, r4)
            r2.d(r0)
            return
        L_0x0078:
            if (r0 != r5) goto L_0x00b2
            u.f r0 = r15.f15542b
            int r0 = r0.l()
            r2.d(r0)
            goto L_0x00b2
        L_0x0084:
            int r0 = r15.f15544d
            if (r0 != r6) goto L_0x00b2
            u.f r0 = r15.f15542b
            u.f r7 = r0.U
            if (r7 == 0) goto L_0x00b2
            int[] r8 = r7.f15113q0
            r8 = r8[r5]
            if (r8 != r5) goto L_0x00b2
            v.n r2 = r7.f15088e
            v.f r2 = r2.f15548h
            u.e r0 = r0.K
            int r0 = r0.e()
            v.q.b(r3, r2, r0)
            v.n r0 = r7.f15088e
            v.f r0 = r0.f15549i
            u.f r2 = r15.f15542b
            u.e r2 = r2.M
            int r2 = r2.e()
            int r2 = -r2
            v.q.b(r1, r0, r2)
            return
        L_0x00b2:
            boolean r0 = r2.f15517j
            v.f r7 = r15.f15525k
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L_0x01c7
            u.f r10 = r15.f15542b
            boolean r11 = r10.f15080a
            if (r11 == 0) goto L_0x01c7
            u.e[] r0 = r10.R
            r11 = r0[r9]
            u.e r12 = r11.f15076f
            if (r12 == 0) goto L_0x012d
            r13 = r0[r4]
            u.e r13 = r13.f15076f
            if (r13 == 0) goto L_0x012d
            boolean r0 = r10.y()
            if (r0 == 0) goto L_0x00ee
            u.f r0 = r15.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r9]
            int r0 = r0.e()
            r3.f15513f = r0
            u.f r0 = r15.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r4]
            int r0 = r0.e()
            int r0 = -r0
            r1.f15513f = r0
            goto L_0x0125
        L_0x00ee:
            u.f r0 = r15.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r9]
            v.f r0 = v.q.h(r0)
            if (r0 == 0) goto L_0x0107
            u.f r2 = r15.f15542b
            u.e[] r2 = r2.R
            r2 = r2[r9]
            int r2 = r2.e()
            v.q.b(r3, r0, r2)
        L_0x0107:
            u.f r0 = r15.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r4]
            v.f r0 = v.q.h(r0)
            if (r0 == 0) goto L_0x0121
            u.f r2 = r15.f15542b
            u.e[] r2 = r2.R
            r2 = r2[r4]
            int r2 = r2.e()
            int r2 = -r2
            v.q.b(r1, r0, r2)
        L_0x0121:
            r3.f15509b = r5
            r1.f15509b = r5
        L_0x0125:
            u.f r0 = r15.f15542b
            boolean r1 = r0.F
            if (r1 == 0) goto L_0x0325
            goto L_0x01c0
        L_0x012d:
            if (r12 == 0) goto L_0x014f
            v.f r0 = v.q.h(r11)
            if (r0 == 0) goto L_0x0325
            u.f r4 = r15.f15542b
            u.e[] r4 = r4.R
            r4 = r4[r9]
            int r4 = r4.e()
            v.q.b(r3, r0, r4)
            int r0 = r2.f15514g
            v.q.b(r1, r3, r0)
            u.f r0 = r15.f15542b
            boolean r1 = r0.F
            if (r1 == 0) goto L_0x0325
            goto L_0x01c0
        L_0x014f:
            r5 = r0[r4]
            u.e r9 = r5.f15076f
            if (r9 == 0) goto L_0x0176
            v.f r0 = v.q.h(r5)
            if (r0 == 0) goto L_0x016f
            u.f r5 = r15.f15542b
            u.e[] r5 = r5.R
            r4 = r5[r4]
            int r4 = r4.e()
            int r4 = -r4
            v.q.b(r1, r0, r4)
            int r0 = r2.f15514g
            int r0 = -r0
            v.q.b(r3, r1, r0)
        L_0x016f:
            u.f r0 = r15.f15542b
            boolean r1 = r0.F
            if (r1 == 0) goto L_0x0325
            goto L_0x01c0
        L_0x0176:
            r0 = r0[r6]
            u.e r4 = r0.f15076f
            if (r4 == 0) goto L_0x0194
            v.f r0 = v.q.h(r0)
            if (r0 == 0) goto L_0x0325
            v.q.b(r7, r0, r8)
            u.f r0 = r15.f15542b
            int r0 = r0.f15083b0
            int r0 = -r0
            v.q.b(r3, r7, r0)
            int r0 = r2.f15514g
            v.q.b(r1, r3, r0)
            goto L_0x0325
        L_0x0194:
            boolean r0 = r10 instanceof u.k
            if (r0 != 0) goto L_0x0325
            u.f r0 = r10.U
            if (r0 == 0) goto L_0x0325
            u.d r0 = u.d.CENTER
            u.e r0 = r10.j(r0)
            u.e r0 = r0.f15076f
            if (r0 != 0) goto L_0x0325
            u.f r0 = r15.f15542b
            u.f r4 = r0.U
            v.n r4 = r4.f15088e
            v.f r4 = r4.f15548h
            int r0 = r0.s()
            v.q.b(r3, r4, r0)
            int r0 = r2.f15514g
            v.q.b(r1, r3, r0)
            u.f r0 = r15.f15542b
            boolean r1 = r0.F
            if (r1 == 0) goto L_0x0325
        L_0x01c0:
            int r0 = r0.f15083b0
            v.q.b(r7, r3, r0)
            goto L_0x0325
        L_0x01c7:
            java.util.ArrayList r10 = r2.f15519l
            if (r0 != 0) goto L_0x0204
            int r0 = r15.f15544d
            if (r0 != r4) goto L_0x0204
            u.f r0 = r15.f15542b
            int r11 = r0.f15116t
            if (r11 == r9) goto L_0x01e8
            if (r11 == r4) goto L_0x01d8
            goto L_0x0207
        L_0x01d8:
            boolean r0 = r0.y()
            if (r0 != 0) goto L_0x0207
            u.f r0 = r15.f15542b
            int r11 = r0.f15115s
            if (r11 != r4) goto L_0x01e5
            goto L_0x0207
        L_0x01e5:
            v.l r0 = r0.f15086d
            goto L_0x01ef
        L_0x01e8:
            u.f r0 = r0.U
            if (r0 != 0) goto L_0x01ed
            goto L_0x0207
        L_0x01ed:
            v.n r0 = r0.f15088e
        L_0x01ef:
            v.g r0 = r0.f15545e
            r10.add(r0)
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            r2.f15509b = r5
            java.util.ArrayList r0 = r2.f15518k
            r0.add(r3)
            r0.add(r1)
            goto L_0x0207
        L_0x0204:
            r2.b(r15)
        L_0x0207:
            u.f r0 = r15.f15542b
            u.e[] r11 = r0.R
            r12 = r11[r9]
            u.e r13 = r12.f15076f
            if (r13 == 0) goto L_0x025e
            r14 = r11[r4]
            u.e r14 = r14.f15076f
            if (r14 == 0) goto L_0x025e
            boolean r0 = r0.y()
            if (r0 == 0) goto L_0x0237
            u.f r0 = r15.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r9]
            int r0 = r0.e()
            r3.f15513f = r0
            u.f r0 = r15.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r4]
            int r0 = r0.e()
            int r0 = -r0
            r1.f15513f = r0
            goto L_0x0257
        L_0x0237:
            u.f r0 = r15.f15542b
            u.e[] r0 = r0.R
            r0 = r0[r9]
            v.f r0 = v.q.h(r0)
            u.f r1 = r15.f15542b
            u.e[] r1 = r1.R
            r1 = r1[r4]
            v.f r1 = v.q.h(r1)
            if (r0 == 0) goto L_0x0250
            r0.b(r15)
        L_0x0250:
            if (r1 == 0) goto L_0x0255
            r1.b(r15)
        L_0x0255:
            r15.f15550j = r6
        L_0x0257:
            u.f r0 = r15.f15542b
            boolean r0 = r0.F
            if (r0 == 0) goto L_0x031d
            goto L_0x02ba
        L_0x025e:
            r14 = 0
            if (r13 == 0) goto L_0x0296
            v.f r0 = v.q.h(r12)
            if (r0 == 0) goto L_0x031d
            u.f r6 = r15.f15542b
            u.e[] r6 = r6.R
            r6 = r6[r9]
            int r6 = r6.e()
            v.q.b(r3, r0, r6)
            r15.c(r1, r3, r5, r2)
            u.f r0 = r15.f15542b
            boolean r0 = r0.F
            if (r0 == 0) goto L_0x0282
            v.a r0 = r15.f15526l
            r15.c(r7, r3, r5, r0)
        L_0x0282:
            int r0 = r15.f15544d
            if (r0 != r4) goto L_0x031d
            u.f r0 = r15.f15542b
            float r1 = r0.X
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x031d
            v.l r0 = r0.f15086d
            int r1 = r0.f15544d
            if (r1 != r4) goto L_0x031d
            goto L_0x030b
        L_0x0296:
            r9 = r11[r4]
            u.e r12 = r9.f15076f
            r13 = -1
            if (r12 == 0) goto L_0x02c0
            v.f r0 = v.q.h(r9)
            if (r0 == 0) goto L_0x031d
            u.f r6 = r15.f15542b
            u.e[] r6 = r6.R
            r4 = r6[r4]
            int r4 = r4.e()
            int r4 = -r4
            v.q.b(r1, r0, r4)
            r15.c(r3, r1, r13, r2)
            u.f r0 = r15.f15542b
            boolean r0 = r0.F
            if (r0 == 0) goto L_0x031d
        L_0x02ba:
            v.a r0 = r15.f15526l
            r15.c(r7, r3, r5, r0)
            goto L_0x031d
        L_0x02c0:
            r6 = r11[r6]
            u.e r9 = r6.f15076f
            if (r9 == 0) goto L_0x02d8
            v.f r0 = v.q.h(r6)
            if (r0 == 0) goto L_0x031d
            v.q.b(r7, r0, r8)
            v.a r0 = r15.f15526l
            r15.c(r3, r7, r13, r0)
            r15.c(r1, r3, r5, r2)
            goto L_0x031d
        L_0x02d8:
            boolean r6 = r0 instanceof u.k
            if (r6 != 0) goto L_0x031d
            u.f r6 = r0.U
            if (r6 == 0) goto L_0x031d
            v.n r6 = r6.f15088e
            v.f r6 = r6.f15548h
            int r0 = r0.s()
            v.q.b(r3, r6, r0)
            r15.c(r1, r3, r5, r2)
            u.f r0 = r15.f15542b
            boolean r0 = r0.F
            if (r0 == 0) goto L_0x02f9
            v.a r0 = r15.f15526l
            r15.c(r7, r3, r5, r0)
        L_0x02f9:
            int r0 = r15.f15544d
            if (r0 != r4) goto L_0x031d
            u.f r0 = r15.f15542b
            float r1 = r0.X
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x031d
            v.l r0 = r0.f15086d
            int r1 = r0.f15544d
            if (r1 != r4) goto L_0x031d
        L_0x030b:
            v.g r0 = r0.f15545e
            java.util.ArrayList r0 = r0.f15518k
            r0.add(r2)
            u.f r0 = r15.f15542b
            v.l r0 = r0.f15086d
            v.g r0 = r0.f15545e
            r10.add(r0)
            r2.f15508a = r15
        L_0x031d:
            int r0 = r10.size()
            if (r0 != 0) goto L_0x0325
            r2.f15510c = r5
        L_0x0325:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.n.d():void");
    }

    public final void e() {
        f fVar = this.f15548h;
        if (fVar.f15517j) {
            this.f15542b.f15081a0 = fVar.f15514g;
        }
    }

    public final void f() {
        this.f15543c = null;
        this.f15548h.c();
        this.f15549i.c();
        this.f15525k.c();
        this.f15545e.c();
        this.f15547g = false;
    }

    public final boolean k() {
        return this.f15544d != 3 || this.f15542b.f15116t == 0;
    }

    public final void m() {
        this.f15547g = false;
        f fVar = this.f15548h;
        fVar.c();
        fVar.f15517j = false;
        f fVar2 = this.f15549i;
        fVar2.c();
        fVar2.f15517j = false;
        f fVar3 = this.f15525k;
        fVar3.c();
        fVar3.f15517j = false;
        this.f15545e.f15517j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f15542b.f15097i0;
    }
}
