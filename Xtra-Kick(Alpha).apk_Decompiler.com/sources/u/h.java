package u;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public int f15131a;

    /* renamed from: b  reason: collision with root package name */
    public f f15132b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f15133c = 0;

    /* renamed from: d  reason: collision with root package name */
    public e f15134d;

    /* renamed from: e  reason: collision with root package name */
    public e f15135e;

    /* renamed from: f  reason: collision with root package name */
    public e f15136f;

    /* renamed from: g  reason: collision with root package name */
    public e f15137g;

    /* renamed from: h  reason: collision with root package name */
    public int f15138h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f15139i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f15140j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f15141k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f15142l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f15143m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f15144n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f15145o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f15146p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f15147q = 0;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ i f15148r;

    public h(i iVar, int i10, e eVar, e eVar2, e eVar3, e eVar4, int i11) {
        this.f15148r = iVar;
        this.f15131a = i10;
        this.f15134d = eVar;
        this.f15135e = eVar2;
        this.f15136f = eVar3;
        this.f15137g = eVar4;
        this.f15138h = iVar.f15165x0;
        this.f15139i = iVar.f15161t0;
        this.f15140j = iVar.f15166y0;
        this.f15141k = iVar.f15162u0;
        this.f15147q = i11;
    }

    public final void a(f fVar) {
        int i10 = this.f15131a;
        int i11 = 0;
        i iVar = this.f15148r;
        if (i10 == 0) {
            int U = iVar.U(this.f15147q, fVar);
            if (fVar.f15113q0[0] == 3) {
                this.f15146p++;
                U = 0;
            }
            int i12 = iVar.Q0;
            if (fVar.f15095h0 != 8) {
                i11 = i12;
            }
            this.f15142l = U + i11 + this.f15142l;
            int T = iVar.T(this.f15147q, fVar);
            if (this.f15132b == null || this.f15133c < T) {
                this.f15132b = fVar;
                this.f15133c = T;
                this.f15143m = T;
            }
        } else {
            int U2 = iVar.U(this.f15147q, fVar);
            int T2 = iVar.T(this.f15147q, fVar);
            if (fVar.f15113q0[1] == 3) {
                this.f15146p++;
                T2 = 0;
            }
            int i13 = iVar.R0;
            if (fVar.f15095h0 != 8) {
                i11 = i13;
            }
            this.f15143m = T2 + i11 + this.f15143m;
            if (this.f15132b == null || this.f15133c < U2) {
                this.f15132b = fVar;
                this.f15133c = U2;
                this.f15142l = U2;
            }
        }
        this.f15145o++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r21, boolean r22, boolean r23) {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.f15145o
            r2 = 0
            r3 = 0
        L_0x0006:
            u.i r4 = r0.f15148r
            if (r3 >= r1) goto L_0x001e
            int r5 = r0.f15144n
            int r5 = r5 + r3
            int r6 = r4.f15151c1
            if (r5 < r6) goto L_0x0012
            goto L_0x001e
        L_0x0012:
            u.f[] r4 = r4.f15150b1
            r4 = r4[r5]
            if (r4 == 0) goto L_0x001b
            r4.D()
        L_0x001b:
            int r3 = r3 + 1
            goto L_0x0006
        L_0x001e:
            if (r1 == 0) goto L_0x02c8
            u.f r3 = r0.f15132b
            if (r3 != 0) goto L_0x0026
            goto L_0x02c8
        L_0x0026:
            if (r23 == 0) goto L_0x002c
            if (r21 != 0) goto L_0x002c
            r5 = 1
            goto L_0x002d
        L_0x002c:
            r5 = 0
        L_0x002d:
            r6 = -1
            r7 = 0
            r8 = -1
            r9 = -1
        L_0x0031:
            if (r7 >= r1) goto L_0x0053
            if (r22 == 0) goto L_0x0039
            int r10 = r1 + -1
            int r10 = r10 - r7
            goto L_0x003a
        L_0x0039:
            r10 = r7
        L_0x003a:
            int r11 = r0.f15144n
            int r11 = r11 + r10
            int r10 = r4.f15151c1
            if (r11 < r10) goto L_0x0042
            goto L_0x0053
        L_0x0042:
            u.f[] r10 = r4.f15150b1
            r10 = r10[r11]
            if (r10 == 0) goto L_0x0050
            int r10 = r10.f15095h0
            if (r10 != 0) goto L_0x0050
            if (r8 != r6) goto L_0x004f
            r8 = r7
        L_0x004f:
            r9 = r7
        L_0x0050:
            int r7 = r7 + 1
            goto L_0x0031
        L_0x0053:
            int r7 = r0.f15131a
            if (r7 != 0) goto L_0x01ab
            u.f r7 = r0.f15132b
            int r11 = r4.F0
            r7.f15101k0 = r11
            int r11 = r0.f15139i
            if (r21 <= 0) goto L_0x0064
            int r12 = r4.R0
            int r11 = r11 + r12
        L_0x0064:
            u.e r12 = r0.f15135e
            u.e r13 = r7.K
            r13.a(r12, r11)
            u.e r11 = r7.M
            if (r23 == 0) goto L_0x0076
            u.e r12 = r0.f15137g
            int r14 = r0.f15141k
            r11.a(r12, r14)
        L_0x0076:
            if (r21 <= 0) goto L_0x0081
            u.e r12 = r0.f15135e
            u.f r12 = r12.f15074d
            u.e r12 = r12.M
            r12.a(r13, r2)
        L_0x0081:
            int r12 = r4.T0
            r14 = 3
            if (r12 != r14) goto L_0x00a8
            boolean r12 = r7.F
            if (r12 != 0) goto L_0x00a8
            r12 = 0
        L_0x008b:
            if (r12 >= r1) goto L_0x00a8
            if (r22 == 0) goto L_0x0093
            int r15 = r1 + -1
            int r15 = r15 - r12
            goto L_0x0094
        L_0x0093:
            r15 = r12
        L_0x0094:
            int r10 = r0.f15144n
            int r10 = r10 + r15
            int r15 = r4.f15151c1
            if (r10 < r15) goto L_0x009c
            goto L_0x00a8
        L_0x009c:
            u.f[] r15 = r4.f15150b1
            r10 = r15[r10]
            boolean r15 = r10.F
            if (r15 == 0) goto L_0x00a5
            goto L_0x00a9
        L_0x00a5:
            int r12 = r12 + 1
            goto L_0x008b
        L_0x00a8:
            r10 = r7
        L_0x00a9:
            r12 = 0
            r15 = 0
        L_0x00ab:
            if (r15 >= r1) goto L_0x02c8
            if (r22 == 0) goto L_0x00b4
            int r16 = r1 + -1
            int r16 = r16 - r15
            goto L_0x00b6
        L_0x00b4:
            r16 = r15
        L_0x00b6:
            int r14 = r0.f15144n
            int r14 = r14 + r16
            int r3 = r4.f15151c1
            if (r14 < r3) goto L_0x00c0
            goto L_0x02c8
        L_0x00c0:
            u.f[] r3 = r4.f15150b1
            r3 = r3[r14]
            if (r3 != 0) goto L_0x00cb
            r17 = r1
            r2 = 3
            goto L_0x01a2
        L_0x00cb:
            u.e r14 = r3.J
            if (r15 != 0) goto L_0x00d6
            u.e r2 = r0.f15134d
            int r6 = r0.f15138h
            r3.g(r14, r2, r6)
        L_0x00d6:
            if (r16 != 0) goto L_0x0122
            int r2 = r4.E0
            r6 = 1065353216(0x3f800000, float:1.0)
            if (r22 == 0) goto L_0x00e5
            r16 = r2
            float r2 = r4.K0
            float r2 = r6 - r2
            goto L_0x00e9
        L_0x00e5:
            r16 = r2
            float r2 = r4.K0
        L_0x00e9:
            int r6 = r0.f15144n
            if (r6 != 0) goto L_0x0105
            int r6 = r4.G0
            r18 = r2
            r2 = -1
            if (r6 == r2) goto L_0x0107
            if (r22 == 0) goto L_0x00fd
            float r2 = r4.M0
            r16 = 1065353216(0x3f800000, float:1.0)
            float r2 = r16 - r2
            goto L_0x00ff
        L_0x00fd:
            float r2 = r4.M0
        L_0x00ff:
            r19 = r6
            r6 = r2
            r2 = r19
            goto L_0x011e
        L_0x0105:
            r18 = r2
        L_0x0107:
            if (r23 == 0) goto L_0x011a
            int r2 = r4.I0
            r6 = -1
            if (r2 == r6) goto L_0x011a
            if (r22 == 0) goto L_0x0117
            float r6 = r4.O0
            r16 = 1065353216(0x3f800000, float:1.0)
            float r6 = r16 - r6
            goto L_0x011e
        L_0x0117:
            float r6 = r4.O0
            goto L_0x011e
        L_0x011a:
            r2 = r16
            r6 = r18
        L_0x011e:
            r3.f15099j0 = r2
            r3.f15089e0 = r6
        L_0x0122:
            int r2 = r1 + -1
            if (r15 != r2) goto L_0x0132
            u.e r2 = r0.f15136f
            int r6 = r0.f15140j
            r17 = r1
            u.e r1 = r3.L
            r3.g(r1, r2, r6)
            goto L_0x0134
        L_0x0132:
            r17 = r1
        L_0x0134:
            if (r12 == 0) goto L_0x015c
            int r1 = r4.Q0
            u.e r2 = r12.L
            r14.a(r2, r1)
            if (r15 != r8) goto L_0x0149
            int r1 = r0.f15138h
            boolean r6 = r14.h()
            if (r6 == 0) goto L_0x0149
            r14.f15078h = r1
        L_0x0149:
            r1 = 0
            r2.a(r14, r1)
            r1 = 1
            int r6 = r9 + 1
            if (r15 != r6) goto L_0x015c
            int r1 = r0.f15140j
            boolean r6 = r2.h()
            if (r6 == 0) goto L_0x015c
            r2.f15078h = r1
        L_0x015c:
            if (r3 == r7) goto L_0x01a0
            int r1 = r4.T0
            r2 = 3
            if (r1 != r2) goto L_0x0176
            boolean r6 = r10.F
            if (r6 == 0) goto L_0x0176
            if (r3 == r10) goto L_0x0176
            boolean r6 = r3.F
            if (r6 == 0) goto L_0x0176
            u.e r1 = r3.N
            u.e r6 = r10.N
            r12 = 0
            r1.a(r6, r12)
            goto L_0x019e
        L_0x0176:
            u.e r6 = r3.K
            if (r1 == 0) goto L_0x019a
            u.e r12 = r3.M
            r14 = 1
            if (r1 == r14) goto L_0x0195
            if (r5 == 0) goto L_0x0190
            u.e r1 = r0.f15135e
            int r14 = r0.f15139i
            r6.a(r1, r14)
            u.e r1 = r0.f15137g
            int r6 = r0.f15141k
            r12.a(r1, r6)
            goto L_0x019e
        L_0x0190:
            r1 = 0
            r6.a(r13, r1)
            goto L_0x0196
        L_0x0195:
            r1 = 0
        L_0x0196:
            r12.a(r11, r1)
            goto L_0x019e
        L_0x019a:
            r1 = 0
            r6.a(r13, r1)
        L_0x019e:
            r12 = r3
            goto L_0x01a2
        L_0x01a0:
            r2 = 3
            goto L_0x019e
        L_0x01a2:
            int r15 = r15 + 1
            r1 = r17
            r2 = 0
            r6 = -1
            r14 = 3
            goto L_0x00ab
        L_0x01ab:
            r17 = r1
            u.f r1 = r0.f15132b
            int r2 = r4.E0
            r1.f15099j0 = r2
            int r2 = r0.f15138h
            if (r21 <= 0) goto L_0x01ba
            int r3 = r4.Q0
            int r2 = r2 + r3
        L_0x01ba:
            u.e r3 = r1.L
            u.e r6 = r1.J
            if (r22 == 0) goto L_0x01db
            u.e r7 = r0.f15136f
            r3.a(r7, r2)
            if (r23 == 0) goto L_0x01ce
            u.e r2 = r0.f15134d
            int r7 = r0.f15140j
            r6.a(r2, r7)
        L_0x01ce:
            if (r21 <= 0) goto L_0x01f5
            u.e r2 = r0.f15136f
            u.f r2 = r2.f15074d
            u.e r2 = r2.J
            r7 = 0
            r2.a(r3, r7)
            goto L_0x01f5
        L_0x01db:
            u.e r7 = r0.f15134d
            r6.a(r7, r2)
            if (r23 == 0) goto L_0x01e9
            u.e r2 = r0.f15136f
            int r7 = r0.f15140j
            r3.a(r2, r7)
        L_0x01e9:
            if (r21 <= 0) goto L_0x01f5
            u.e r2 = r0.f15134d
            u.f r2 = r2.f15074d
            u.e r2 = r2.L
            r7 = 0
            r2.a(r6, r7)
        L_0x01f5:
            r7 = r17
            r2 = 0
            r10 = 0
        L_0x01f9:
            if (r2 >= r7) goto L_0x02c8
            int r11 = r0.f15144n
            int r11 = r11 + r2
            int r12 = r4.f15151c1
            if (r11 < r12) goto L_0x0204
            goto L_0x02c8
        L_0x0204:
            u.f[] r12 = r4.f15150b1
            r11 = r12[r11]
            if (r11 != 0) goto L_0x020d
            r11 = r10
            goto L_0x02c1
        L_0x020d:
            u.e r12 = r11.K
            if (r2 != 0) goto L_0x023d
            u.e r13 = r0.f15135e
            int r14 = r0.f15139i
            r11.g(r12, r13, r14)
            int r13 = r4.F0
            float r14 = r4.L0
            int r15 = r0.f15144n
            if (r15 != 0) goto L_0x022a
            int r15 = r4.H0
            r16 = r13
            r13 = -1
            if (r15 == r13) goto L_0x022d
            float r14 = r4.N0
            goto L_0x0238
        L_0x022a:
            r16 = r13
            r13 = -1
        L_0x022d:
            if (r23 == 0) goto L_0x0236
            int r15 = r4.J0
            if (r15 == r13) goto L_0x0236
            float r14 = r4.P0
            goto L_0x0238
        L_0x0236:
            r15 = r16
        L_0x0238:
            r11.f15101k0 = r15
            r11.f15091f0 = r14
            goto L_0x023e
        L_0x023d:
            r13 = -1
        L_0x023e:
            int r14 = r7 + -1
            if (r2 != r14) goto L_0x024b
            u.e r14 = r0.f15137g
            int r15 = r0.f15141k
            u.e r13 = r11.M
            r11.g(r13, r14, r15)
        L_0x024b:
            if (r10 == 0) goto L_0x0273
            int r13 = r4.R0
            u.e r10 = r10.M
            r12.a(r10, r13)
            if (r2 != r8) goto L_0x0260
            int r13 = r0.f15139i
            boolean r14 = r12.h()
            if (r14 == 0) goto L_0x0260
            r12.f15078h = r13
        L_0x0260:
            r13 = 0
            r10.a(r12, r13)
            r12 = 1
            int r13 = r9 + 1
            if (r2 != r13) goto L_0x0273
            int r12 = r0.f15141k
            boolean r13 = r10.h()
            if (r13 == 0) goto L_0x0273
            r10.f15078h = r12
        L_0x0273:
            if (r11 == r1) goto L_0x02c1
            r10 = 2
            u.e r12 = r11.L
            u.e r13 = r11.J
            if (r22 == 0) goto L_0x0295
            int r14 = r4.S0
            if (r14 == 0) goto L_0x0290
            r15 = 1
            if (r14 == r15) goto L_0x028b
            if (r14 == r10) goto L_0x0286
            goto L_0x02c1
        L_0x0286:
            r10 = 0
            r13.a(r6, r10)
            goto L_0x0291
        L_0x028b:
            r10 = 0
            r13.a(r6, r10)
            goto L_0x02c2
        L_0x0290:
            r10 = 0
        L_0x0291:
            r12.a(r3, r10)
            goto L_0x02c2
        L_0x0295:
            int r14 = r4.S0
            if (r14 == 0) goto L_0x02bb
            r15 = 1
            if (r14 == r15) goto L_0x02b6
            if (r14 == r10) goto L_0x029f
            goto L_0x02af
        L_0x029f:
            if (r5 == 0) goto L_0x02b1
            u.e r10 = r0.f15134d
            int r14 = r0.f15138h
            r13.a(r10, r14)
            u.e r10 = r0.f15136f
            int r13 = r0.f15140j
            r12.a(r10, r13)
        L_0x02af:
            r10 = 0
            goto L_0x02c3
        L_0x02b1:
            r10 = 0
            r13.a(r6, r10)
            goto L_0x02b7
        L_0x02b6:
            r10 = 0
        L_0x02b7:
            r12.a(r3, r10)
            goto L_0x02c3
        L_0x02bb:
            r10 = 0
            r15 = 1
            r13.a(r6, r10)
            goto L_0x02c3
        L_0x02c1:
            r10 = 0
        L_0x02c2:
            r15 = 1
        L_0x02c3:
            int r2 = r2 + 1
            r10 = r11
            goto L_0x01f9
        L_0x02c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u.h.b(int, boolean, boolean):void");
    }

    public final int c() {
        if (this.f15131a == 1) {
            return this.f15143m - this.f15148r.R0;
        }
        return this.f15143m;
    }

    public final int d() {
        if (this.f15131a == 0) {
            return this.f15142l - this.f15148r.Q0;
        }
        return this.f15142l;
    }

    public final void e(int i10) {
        i iVar;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = this.f15146p;
        if (i16 != 0) {
            int i17 = this.f15145o;
            int i18 = i10 / i16;
            int i19 = 0;
            while (true) {
                iVar = this.f15148r;
                if (i19 >= i17 || (i11 = this.f15144n + i19) >= iVar.f15151c1) {
                    this.f15142l = 0;
                    this.f15143m = 0;
                    this.f15132b = null;
                    this.f15133c = 0;
                    int i20 = this.f15145o;
                    int i21 = 0;
                } else {
                    f fVar = iVar.f15150b1[i11];
                    if (this.f15131a == 0) {
                        if (fVar != null) {
                            int[] iArr = fVar.f15113q0;
                            if (iArr[0] == 3 && fVar.f15115s == 0) {
                                int i22 = iArr[1];
                                i14 = i18;
                                i12 = fVar.l();
                                i13 = i22;
                                i15 = 1;
                            }
                        }
                        i19++;
                    } else {
                        if (fVar != null) {
                            int[] iArr2 = fVar.f15113q0;
                            if (iArr2[1] == 3 && fVar.f15116t == 0) {
                                i15 = iArr2[0];
                                i12 = i18;
                                i14 = fVar.q();
                                i13 = 1;
                            }
                        }
                        i19++;
                    }
                    iVar.S(fVar, i15, i14, i13, i12);
                    i19++;
                }
            }
            this.f15142l = 0;
            this.f15143m = 0;
            this.f15132b = null;
            this.f15133c = 0;
            int i202 = this.f15145o;
            int i212 = 0;
            while (i212 < i202) {
                int i23 = this.f15144n + i212;
                if (i23 < iVar.f15151c1) {
                    f fVar2 = iVar.f15150b1[i23];
                    if (this.f15131a == 0) {
                        int q10 = fVar2.q();
                        int i24 = iVar.Q0;
                        if (fVar2.f15095h0 == 8) {
                            i24 = 0;
                        }
                        this.f15142l = q10 + i24 + this.f15142l;
                        int T = iVar.T(this.f15147q, fVar2);
                        if (this.f15132b == null || this.f15133c < T) {
                            this.f15132b = fVar2;
                            this.f15133c = T;
                            this.f15143m = T;
                        }
                    } else {
                        int U = iVar.U(this.f15147q, fVar2);
                        int T2 = iVar.T(this.f15147q, fVar2);
                        int i25 = iVar.R0;
                        if (fVar2.f15095h0 == 8) {
                            i25 = 0;
                        }
                        this.f15143m = T2 + i25 + this.f15143m;
                        if (this.f15132b == null || this.f15133c < U) {
                            this.f15132b = fVar2;
                            this.f15133c = U;
                            this.f15142l = U;
                        }
                    }
                    i212++;
                } else {
                    return;
                }
            }
        }
    }

    public final void f(int i10, e eVar, e eVar2, e eVar3, e eVar4, int i11, int i12, int i13, int i14, int i15) {
        this.f15131a = i10;
        this.f15134d = eVar;
        this.f15135e = eVar2;
        this.f15136f = eVar3;
        this.f15137g = eVar4;
        this.f15138h = i11;
        this.f15139i = i12;
        this.f15140j = i13;
        this.f15141k = i14;
        this.f15147q = i15;
    }
}
