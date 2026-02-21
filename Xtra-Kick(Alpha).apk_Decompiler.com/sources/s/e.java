package s;

import java.util.Arrays;

public final class e {

    /* renamed from: p  reason: collision with root package name */
    public static boolean f13932p = false;

    /* renamed from: q  reason: collision with root package name */
    public static int f13933q = 1000;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13934a;

    /* renamed from: b  reason: collision with root package name */
    public int f13935b;

    /* renamed from: c  reason: collision with root package name */
    public final h f13936c;

    /* renamed from: d  reason: collision with root package name */
    public int f13937d;

    /* renamed from: e  reason: collision with root package name */
    public int f13938e;

    /* renamed from: f  reason: collision with root package name */
    public c[] f13939f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13940g;

    /* renamed from: h  reason: collision with root package name */
    public boolean[] f13941h;

    /* renamed from: i  reason: collision with root package name */
    public int f13942i;

    /* renamed from: j  reason: collision with root package name */
    public int f13943j;

    /* renamed from: k  reason: collision with root package name */
    public int f13944k;

    /* renamed from: l  reason: collision with root package name */
    public final d f13945l;

    /* renamed from: m  reason: collision with root package name */
    public j[] f13946m;

    /* renamed from: n  reason: collision with root package name */
    public int f13947n;

    /* renamed from: o  reason: collision with root package name */
    public c f13948o;

    public e() {
        this.f13934a = false;
        this.f13935b = 0;
        this.f13937d = 32;
        this.f13938e = 32;
        this.f13939f = null;
        this.f13940g = false;
        this.f13941h = new boolean[32];
        this.f13942i = 1;
        this.f13943j = 0;
        this.f13944k = 32;
        this.f13946m = new j[f13933q];
        this.f13947n = 0;
        this.f13939f = new c[32];
        for (int i10 = 0; i10 < this.f13943j; i10++) {
            c cVar = this.f13939f[i10];
            if (cVar != null) {
                this.f13945l.f13929a.e(cVar);
            }
            this.f13939f[i10] = null;
        }
        d dVar = new d();
        this.f13945l = dVar;
        this.f13936c = new h(dVar);
        this.f13948o = new c(dVar);
    }

    public static int o(u.e eVar) {
        j jVar = eVar.f15079i;
        if (jVar != null) {
            return (int) (jVar.f13963l + 0.5f);
        }
        return 0;
    }

    public final j a(int i10) {
        j jVar = (j) this.f13945l.f13930b.j();
        if (jVar == null) {
            jVar = new j(i10);
        } else {
            jVar.c();
        }
        jVar.f13970s = i10;
        int i11 = this.f13947n;
        int i12 = f13933q;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f13933q = i13;
            this.f13946m = (j[]) Arrays.copyOf(this.f13946m, i13);
        }
        j[] jVarArr = this.f13946m;
        int i14 = this.f13947n;
        this.f13947n = i14 + 1;
        jVarArr[i14] = jVar;
        return jVar;
    }

    public final void b(j jVar, j jVar2, int i10, float f10, j jVar3, j jVar4, int i11, int i12) {
        float f11;
        int i13;
        c m10 = m();
        if (jVar2 == jVar3) {
            m10.f13927d.b(jVar, 1.0f);
            m10.f13927d.b(jVar4, 1.0f);
            m10.f13927d.b(jVar2, -2.0f);
        } else {
            if (f10 == 0.5f) {
                m10.f13927d.b(jVar, 1.0f);
                m10.f13927d.b(jVar2, -1.0f);
                m10.f13927d.b(jVar3, -1.0f);
                m10.f13927d.b(jVar4, 1.0f);
                if (i10 > 0 || i11 > 0) {
                    i13 = (-i10) + i11;
                }
            } else if (f10 <= 0.0f) {
                m10.f13927d.b(jVar, -1.0f);
                m10.f13927d.b(jVar2, 1.0f);
                f11 = (float) i10;
                m10.f13925b = f11;
            } else if (f10 >= 1.0f) {
                m10.f13927d.b(jVar4, -1.0f);
                m10.f13927d.b(jVar3, 1.0f);
                i13 = -i11;
            } else {
                float f12 = 1.0f - f10;
                m10.f13927d.b(jVar, f12 * 1.0f);
                m10.f13927d.b(jVar2, f12 * -1.0f);
                m10.f13927d.b(jVar3, -1.0f * f10);
                m10.f13927d.b(jVar4, 1.0f * f10);
                if (i10 > 0 || i11 > 0) {
                    m10.f13925b = (((float) i11) * f10) + (((float) (-i10)) * f12);
                }
            }
            f11 = (float) i13;
            m10.f13925b = f11;
        }
        if (i12 != 8) {
            m10.a(this, i12);
        }
        c(m10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ba, code lost:
        if (r4.f13969r <= 1) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c3, code lost:
        if (r4.f13969r <= 1) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c7, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e4, code lost:
        if (r4.f13969r <= 1) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ed, code lost:
        if (r4.f13969r <= 1) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f1, code lost:
        r14 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(s.c r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r0.f13943j
            r3 = 1
            int r2 = r2 + r3
            int r4 = r0.f13944k
            if (r2 >= r4) goto L_0x0013
            int r2 = r0.f13942i
            int r2 = r2 + r3
            int r4 = r0.f13938e
            if (r2 < r4) goto L_0x0016
        L_0x0013:
            r16.p()
        L_0x0016:
            boolean r2 = r1.f13928e
            if (r2 != 0) goto L_0x01b7
            s.c[] r2 = r0.f13939f
            int r2 = r2.length
            r5 = -1
            if (r2 != 0) goto L_0x0021
            goto L_0x007d
        L_0x0021:
            r2 = 0
        L_0x0022:
            if (r2 != 0) goto L_0x006d
            s.b r6 = r1.f13927d
            int r6 = r6.c()
            r7 = 0
        L_0x002b:
            java.util.ArrayList r8 = r1.f13926c
            if (r7 >= r6) goto L_0x0044
            s.b r9 = r1.f13927d
            s.j r9 = r9.f(r7)
            int r10 = r9.f13961j
            if (r10 != r5) goto L_0x003e
            boolean r10 = r9.f13964m
            if (r10 != 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r8.add(r9)
        L_0x0041:
            int r7 = r7 + 1
            goto L_0x002b
        L_0x0044:
            int r6 = r8.size()
            if (r6 <= 0) goto L_0x006b
            r7 = 0
        L_0x004b:
            if (r7 >= r6) goto L_0x0067
            java.lang.Object r9 = r8.get(r7)
            s.j r9 = (s.j) r9
            boolean r10 = r9.f13964m
            if (r10 == 0) goto L_0x005b
            r1.h(r0, r9, r3)
            goto L_0x0064
        L_0x005b:
            s.c[] r10 = r0.f13939f
            int r9 = r9.f13961j
            r9 = r10[r9]
            r1.i(r0, r9, r3)
        L_0x0064:
            int r7 = r7 + 1
            goto L_0x004b
        L_0x0067:
            r8.clear()
            goto L_0x0022
        L_0x006b:
            r2 = 1
            goto L_0x0022
        L_0x006d:
            s.j r2 = r1.f13924a
            if (r2 == 0) goto L_0x007d
            s.b r2 = r1.f13927d
            int r2 = r2.c()
            if (r2 != 0) goto L_0x007d
            r1.f13928e = r3
            r0.f13934a = r3
        L_0x007d:
            boolean r2 = r17.e()
            if (r2 == 0) goto L_0x0084
            return
        L_0x0084:
            float r2 = r1.f13925b
            r6 = 0
            int r7 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x0096
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r2 * r7
            r1.f13925b = r2
            s.b r2 = r1.f13927d
            r2.k()
        L_0x0096:
            s.b r2 = r1.f13927d
            int r2 = r2.c()
            r7 = 0
            r9 = r7
            r10 = r9
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00a4:
            if (r8 >= r2) goto L_0x0107
            s.b r15 = r1.f13927d
            float r15 = r15.a(r8)
            s.b r4 = r1.f13927d
            s.j r4 = r4.f(r8)
            int r5 = r4.f13970s
            if (r5 != r3) goto L_0x00da
            if (r9 != 0) goto L_0x00bd
            int r5 = r4.f13969r
            if (r5 > r3) goto L_0x00c7
            goto L_0x00c5
        L_0x00bd:
            int r5 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x00cb
            int r5 = r4.f13969r
            if (r5 > r3) goto L_0x00c7
        L_0x00c5:
            r12 = 1
            goto L_0x00c8
        L_0x00c7:
            r12 = 0
        L_0x00c8:
            r9 = r4
            r11 = r15
            goto L_0x0103
        L_0x00cb:
            if (r12 != 0) goto L_0x0103
            int r5 = r4.f13969r
            if (r5 > r3) goto L_0x00d3
            r5 = 1
            goto L_0x00d4
        L_0x00d3:
            r5 = 0
        L_0x00d4:
            if (r5 == 0) goto L_0x0103
            r9 = r4
            r11 = r15
            r12 = 1
            goto L_0x0103
        L_0x00da:
            if (r9 != 0) goto L_0x0103
            int r5 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0103
            if (r10 != 0) goto L_0x00e7
            int r5 = r4.f13969r
            if (r5 > r3) goto L_0x00f1
            goto L_0x00ef
        L_0x00e7:
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x00f5
            int r5 = r4.f13969r
            if (r5 > r3) goto L_0x00f1
        L_0x00ef:
            r14 = 1
            goto L_0x00f2
        L_0x00f1:
            r14 = 0
        L_0x00f2:
            r10 = r4
            r13 = r15
            goto L_0x0103
        L_0x00f5:
            if (r14 != 0) goto L_0x0103
            int r5 = r4.f13969r
            if (r5 > r3) goto L_0x00fd
            r5 = 1
            goto L_0x00fe
        L_0x00fd:
            r5 = 0
        L_0x00fe:
            if (r5 == 0) goto L_0x0103
            r10 = r4
            r13 = r15
            r14 = 1
        L_0x0103:
            int r8 = r8 + 1
            r5 = -1
            goto L_0x00a4
        L_0x0107:
            if (r9 == 0) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            r9 = r10
        L_0x010b:
            if (r9 != 0) goto L_0x010f
            r2 = 1
            goto L_0x0113
        L_0x010f:
            r1.g(r9)
            r2 = 0
        L_0x0113:
            s.b r4 = r1.f13927d
            int r4 = r4.c()
            if (r4 != 0) goto L_0x011d
            r1.f13928e = r3
        L_0x011d:
            if (r2 == 0) goto L_0x01a1
            int r2 = r0.f13942i
            int r2 = r2 + r3
            int r4 = r0.f13938e
            if (r2 < r4) goto L_0x0129
            r16.p()
        L_0x0129:
            r2 = 3
            s.j r2 = r0.a(r2)
            int r4 = r0.f13935b
            int r4 = r4 + r3
            r0.f13935b = r4
            int r5 = r0.f13942i
            int r5 = r5 + r3
            r0.f13942i = r5
            r2.f13960i = r4
            s.d r5 = r0.f13945l
            s.j[] r8 = r5.f13931c
            r8[r4] = r2
            r1.f13924a = r2
            int r4 = r0.f13943j
            r16.i(r17)
            int r8 = r0.f13943j
            int r4 = r4 + r3
            if (r8 != r4) goto L_0x01a1
            s.c r4 = r0.f13948o
            r4.getClass()
            r4.f13924a = r7
            s.b r8 = r4.f13927d
            r8.clear()
            r8 = 0
        L_0x0159:
            s.b r9 = r1.f13927d
            int r9 = r9.c()
            if (r8 >= r9) goto L_0x0175
            s.b r9 = r1.f13927d
            s.j r9 = r9.f(r8)
            s.b r10 = r1.f13927d
            float r10 = r10.a(r8)
            s.b r11 = r4.f13927d
            r11.j(r9, r10, r3)
            int r8 = r8 + 1
            goto L_0x0159
        L_0x0175:
            s.c r4 = r0.f13948o
            r0.s(r4)
            int r4 = r2.f13961j
            r8 = -1
            if (r4 != r8) goto L_0x019f
            s.j r4 = r1.f13924a
            if (r4 != r2) goto L_0x018c
            s.j r2 = r1.f(r7, r2)
            if (r2 == 0) goto L_0x018c
            r1.g(r2)
        L_0x018c:
            boolean r2 = r1.f13928e
            if (r2 != 0) goto L_0x0195
            s.j r2 = r1.f13924a
            r2.e(r0, r1)
        L_0x0195:
            s.f r2 = r5.f13929a
            r2.e(r1)
            int r2 = r0.f13943j
            int r2 = r2 - r3
            r0.f13943j = r2
        L_0x019f:
            r2 = 1
            goto L_0x01a2
        L_0x01a1:
            r2 = 0
        L_0x01a2:
            s.j r4 = r1.f13924a
            if (r4 == 0) goto L_0x01b1
            int r4 = r4.f13970s
            if (r4 == r3) goto L_0x01b2
            float r4 = r1.f13925b
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x01b1
            goto L_0x01b2
        L_0x01b1:
            r3 = 0
        L_0x01b2:
            if (r3 != 0) goto L_0x01b5
            return
        L_0x01b5:
            r4 = r2
            goto L_0x01b8
        L_0x01b7:
            r4 = 0
        L_0x01b8:
            if (r4 != 0) goto L_0x01bd
            r16.i(r17)
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.e.c(s.c):void");
    }

    public final void d(j jVar, int i10) {
        c cVar;
        b bVar;
        float f10;
        int i11 = jVar.f13961j;
        if (i11 == -1) {
            jVar.d(this, (float) i10);
            for (int i12 = 0; i12 < this.f13935b + 1; i12++) {
                j jVar2 = this.f13945l.f13931c[i12];
            }
            return;
        }
        if (i11 != -1) {
            c cVar2 = this.f13939f[i11];
            if (!cVar2.f13928e) {
                if (cVar2.f13927d.c() == 0) {
                    cVar2.f13928e = true;
                } else {
                    cVar = m();
                    if (i10 < 0) {
                        cVar.f13925b = (float) (i10 * -1);
                        bVar = cVar.f13927d;
                        f10 = 1.0f;
                    } else {
                        cVar.f13925b = (float) i10;
                        bVar = cVar.f13927d;
                        f10 = -1.0f;
                    }
                    bVar.b(jVar, f10);
                }
            }
            cVar2.f13925b = (float) i10;
            return;
        }
        cVar = m();
        cVar.f13924a = jVar;
        float f11 = (float) i10;
        jVar.f13963l = f11;
        cVar.f13925b = f11;
        cVar.f13928e = true;
        c(cVar);
    }

    public final void e(j jVar, j jVar2, int i10, int i11) {
        if (i11 == 8 && jVar2.f13964m && jVar.f13961j == -1) {
            jVar.d(this, jVar2.f13963l + ((float) i10));
            return;
        }
        c m10 = m();
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            m10.f13925b = (float) i10;
        }
        if (!z10) {
            m10.f13927d.b(jVar, -1.0f);
            m10.f13927d.b(jVar2, 1.0f);
        } else {
            m10.f13927d.b(jVar, 1.0f);
            m10.f13927d.b(jVar2, -1.0f);
        }
        if (i11 != 8) {
            m10.a(this, i11);
        }
        c(m10);
    }

    public final void f(j jVar, j jVar2, int i10, int i11) {
        c m10 = m();
        j n10 = n();
        n10.f13962k = 0;
        m10.b(jVar, jVar2, n10, i10);
        if (i11 != 8) {
            m10.f13927d.b(k(i11), (float) ((int) (m10.f13927d.g(n10) * -1.0f)));
        }
        c(m10);
    }

    public final void g(j jVar, j jVar2, int i10, int i11) {
        c m10 = m();
        j n10 = n();
        n10.f13962k = 0;
        m10.c(jVar, jVar2, n10, i10);
        if (i11 != 8) {
            m10.f13927d.b(k(i11), (float) ((int) (m10.f13927d.g(n10) * -1.0f)));
        }
        c(m10);
    }

    public final void h(j jVar, j jVar2, j jVar3, j jVar4, float f10) {
        c m10 = m();
        m10.f13927d.b(jVar, -1.0f);
        m10.f13927d.b(jVar2, 1.0f);
        m10.f13927d.b(jVar3, f10);
        m10.f13927d.b(jVar4, -f10);
        c(m10);
    }

    public final void i(c cVar) {
        int i10;
        if (cVar.f13928e) {
            cVar.f13924a.d(this, cVar.f13925b);
        } else {
            c[] cVarArr = this.f13939f;
            int i11 = this.f13943j;
            cVarArr[i11] = cVar;
            j jVar = cVar.f13924a;
            jVar.f13961j = i11;
            this.f13943j = i11 + 1;
            jVar.e(this, cVar);
        }
        if (this.f13934a) {
            int i12 = 0;
            while (i12 < this.f13943j) {
                if (this.f13939f[i12] == null) {
                    System.out.println("WTF");
                }
                c cVar2 = this.f13939f[i12];
                if (cVar2 != null && cVar2.f13928e) {
                    cVar2.f13924a.d(this, cVar2.f13925b);
                    this.f13945l.f13929a.e(cVar2);
                    this.f13939f[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f13943j;
                        if (i13 >= i10) {
                            break;
                        }
                        c[] cVarArr2 = this.f13939f;
                        int i15 = i13 - 1;
                        c cVar3 = cVarArr2[i13];
                        cVarArr2[i15] = cVar3;
                        j jVar2 = cVar3.f13924a;
                        if (jVar2.f13961j == i13) {
                            jVar2.f13961j = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f13939f[i14] = null;
                    }
                    this.f13943j = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f13934a = false;
        }
    }

    public final void j() {
        for (int i10 = 0; i10 < this.f13943j; i10++) {
            c cVar = this.f13939f[i10];
            cVar.f13924a.f13963l = cVar.f13925b;
        }
    }

    public final j k(int i10) {
        if (this.f13942i + 1 >= this.f13938e) {
            p();
        }
        j a10 = a(4);
        int i11 = this.f13935b + 1;
        this.f13935b = i11;
        this.f13942i++;
        a10.f13960i = i11;
        a10.f13962k = i10;
        this.f13945l.f13931c[i11] = a10;
        h hVar = this.f13936c;
        hVar.f13957i.f428i = a10;
        float[] fArr = a10.f13966o;
        Arrays.fill(fArr, 0.0f);
        fArr[a10.f13962k] = 1.0f;
        hVar.j(a10);
        return a10;
    }

    public final j l(Object obj) {
        j jVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f13942i + 1 >= this.f13938e) {
            p();
        }
        if (obj instanceof u.e) {
            u.e eVar = (u.e) obj;
            jVar = eVar.f15079i;
            if (jVar == null) {
                eVar.k();
                jVar = eVar.f15079i;
            }
            int i10 = jVar.f13960i;
            d dVar = this.f13945l;
            if (i10 == -1 || i10 > this.f13935b || dVar.f13931c[i10] == null) {
                if (i10 != -1) {
                    jVar.c();
                }
                int i11 = this.f13935b + 1;
                this.f13935b = i11;
                this.f13942i++;
                jVar.f13960i = i11;
                jVar.f13970s = 1;
                dVar.f13931c[i11] = jVar;
            }
        }
        return jVar;
    }

    public final c m() {
        d dVar = this.f13945l;
        c cVar = (c) dVar.f13929a.j();
        if (cVar == null) {
            return new c(dVar);
        }
        cVar.f13924a = null;
        cVar.f13927d.clear();
        cVar.f13925b = 0.0f;
        cVar.f13928e = false;
        return cVar;
    }

    public final j n() {
        if (this.f13942i + 1 >= this.f13938e) {
            p();
        }
        j a10 = a(3);
        int i10 = this.f13935b + 1;
        this.f13935b = i10;
        this.f13942i++;
        a10.f13960i = i10;
        this.f13945l.f13931c[i10] = a10;
        return a10;
    }

    public final void p() {
        int i10 = this.f13937d * 2;
        this.f13937d = i10;
        this.f13939f = (c[]) Arrays.copyOf(this.f13939f, i10);
        d dVar = this.f13945l;
        dVar.f13931c = (j[]) Arrays.copyOf(dVar.f13931c, this.f13937d);
        int i11 = this.f13937d;
        this.f13941h = new boolean[i11];
        this.f13938e = i11;
        this.f13944k = i11;
    }

    public final void q() {
        h hVar = this.f13936c;
        if (hVar.e()) {
            j();
            return;
        }
        if (this.f13940g) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= this.f13943j) {
                    z10 = true;
                    break;
                } else if (!this.f13939f[i10].f13928e) {
                    break;
                } else {
                    i10++;
                }
            }
            if (z10) {
                j();
                return;
            }
        }
        r(hVar);
    }

    public final void r(h hVar) {
        float f10;
        int i10;
        boolean z10;
        int i11 = 0;
        while (true) {
            f10 = 0.0f;
            i10 = 1;
            if (i11 >= this.f13943j) {
                z10 = false;
                break;
            }
            c cVar = this.f13939f[i11];
            if (cVar.f13924a.f13970s != 1 && cVar.f13925b < 0.0f) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10) {
            boolean z11 = false;
            int i12 = 0;
            while (!z11) {
                i12 += i10;
                float f11 = Float.MAX_VALUE;
                int i13 = 0;
                int i14 = -1;
                int i15 = -1;
                int i16 = 0;
                while (i13 < this.f13943j) {
                    c cVar2 = this.f13939f[i13];
                    if (cVar2.f13924a.f13970s != i10 && !cVar2.f13928e && cVar2.f13925b < f10) {
                        int c10 = cVar2.f13927d.c();
                        int i17 = 0;
                        while (i17 < c10) {
                            j f12 = cVar2.f13927d.f(i17);
                            float g10 = cVar2.f13927d.g(f12);
                            if (g10 > f10) {
                                for (int i18 = 0; i18 < 9; i18++) {
                                    float f13 = f12.f13965n[i18] / g10;
                                    if ((f13 < f11 && i18 == i16) || i18 > i16) {
                                        i15 = f12.f13960i;
                                        i16 = i18;
                                        f11 = f13;
                                        i14 = i13;
                                    }
                                }
                            }
                            i17++;
                            f10 = 0.0f;
                        }
                    }
                    i13++;
                    f10 = 0.0f;
                    i10 = 1;
                }
                if (i14 != -1) {
                    c cVar3 = this.f13939f[i14];
                    cVar3.f13924a.f13961j = -1;
                    cVar3.g(this.f13945l.f13931c[i15]);
                    j jVar = cVar3.f13924a;
                    jVar.f13961j = i14;
                    jVar.e(this, cVar3);
                } else {
                    z11 = true;
                }
                if (i12 > this.f13942i / 2) {
                    z11 = true;
                }
                f10 = 0.0f;
                i10 = 1;
            }
        }
        s(hVar);
        j();
    }

    public final void s(c cVar) {
        for (int i10 = 0; i10 < this.f13942i; i10++) {
            this.f13941h[i10] = false;
        }
        boolean z10 = false;
        int i11 = 0;
        while (!z10) {
            i11++;
            if (i11 < this.f13942i * 2) {
                j jVar = cVar.f13924a;
                if (jVar != null) {
                    this.f13941h[jVar.f13960i] = true;
                }
                j d10 = cVar.d(this.f13941h);
                if (d10 != null) {
                    boolean[] zArr = this.f13941h;
                    int i12 = d10.f13960i;
                    if (!zArr[i12]) {
                        zArr[i12] = true;
                    } else {
                        return;
                    }
                }
                if (d10 != null) {
                    float f10 = Float.MAX_VALUE;
                    int i13 = -1;
                    for (int i14 = 0; i14 < this.f13943j; i14++) {
                        c cVar2 = this.f13939f[i14];
                        if (cVar2.f13924a.f13970s != 1 && !cVar2.f13928e && cVar2.f13927d.h(d10)) {
                            float g10 = cVar2.f13927d.g(d10);
                            if (g10 < 0.0f) {
                                float f11 = (-cVar2.f13925b) / g10;
                                if (f11 < f10) {
                                    i13 = i14;
                                    f10 = f11;
                                }
                            }
                        }
                    }
                    if (i13 > -1) {
                        c cVar3 = this.f13939f[i13];
                        cVar3.f13924a.f13961j = -1;
                        cVar3.g(d10);
                        j jVar2 = cVar3.f13924a;
                        jVar2.f13961j = i13;
                        jVar2.e(this, cVar3);
                    }
                } else {
                    z10 = true;
                }
            } else {
                return;
            }
        }
    }

    public final void t() {
        d dVar;
        int i10 = 0;
        while (true) {
            dVar = this.f13945l;
            j[] jVarArr = dVar.f13931c;
            if (i10 >= jVarArr.length) {
                break;
            }
            j jVar = jVarArr[i10];
            if (jVar != null) {
                jVar.c();
            }
            i10++;
        }
        f fVar = dVar.f13930b;
        j[] jVarArr2 = this.f13946m;
        int i11 = this.f13947n;
        fVar.getClass();
        if (i11 > jVarArr2.length) {
            i11 = jVarArr2.length;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            j jVar2 = jVarArr2[i12];
            int i13 = fVar.f13951j;
            Object[] objArr = fVar.f13950i;
            if (i13 < objArr.length) {
                objArr[i13] = jVar2;
                fVar.f13951j = i13 + 1;
            }
        }
        this.f13947n = 0;
        Arrays.fill(dVar.f13931c, (Object) null);
        this.f13935b = 0;
        h hVar = this.f13936c;
        hVar.f13956h = 0;
        hVar.f13925b = 0.0f;
        this.f13942i = 1;
        for (int i14 = 0; i14 < this.f13943j; i14++) {
            c cVar = this.f13939f[i14];
        }
        for (int i15 = 0; i15 < this.f13943j; i15++) {
            c cVar2 = this.f13939f[i15];
            if (cVar2 != null) {
                dVar.f13929a.e(cVar2);
            }
            this.f13939f[i15] = null;
        }
        this.f13943j = 0;
        this.f13948o = new c(dVar);
    }
}
