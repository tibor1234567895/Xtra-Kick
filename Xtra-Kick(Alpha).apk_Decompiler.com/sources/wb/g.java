package wb;

import dc.j;
import java.util.Arrays;
import ma.o;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f16229a = true;

    /* renamed from: b  reason: collision with root package name */
    public final j f16230b;

    /* renamed from: c  reason: collision with root package name */
    public int f16231c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16232d;

    /* renamed from: e  reason: collision with root package name */
    public int f16233e;

    /* renamed from: f  reason: collision with root package name */
    public e[] f16234f;

    /* renamed from: g  reason: collision with root package name */
    public int f16235g;

    /* renamed from: h  reason: collision with root package name */
    public int f16236h;

    /* renamed from: i  reason: collision with root package name */
    public int f16237i;

    public g(j jVar) {
        this.f16230b = jVar;
        this.f16231c = Integer.MAX_VALUE;
        this.f16233e = 4096;
        this.f16234f = new e[8];
        this.f16235g = 7;
    }

    public final void a(int i10) {
        int i11;
        if (i10 > 0) {
            int length = this.f16234f.length - 1;
            int i12 = 0;
            while (true) {
                i11 = this.f16235g;
                if (length < i11 || i10 <= 0) {
                    e[] eVarArr = this.f16234f;
                    int i13 = i11 + 1;
                    System.arraycopy(eVarArr, i13, eVarArr, i13 + i12, this.f16236h);
                    e[] eVarArr2 = this.f16234f;
                    int i14 = this.f16235g + 1;
                    Arrays.fill(eVarArr2, i14, i14 + i12, (Object) null);
                    this.f16235g += i12;
                } else {
                    e eVar = this.f16234f[length];
                    xa.j.c(eVar);
                    i10 -= eVar.f16212c;
                    int i15 = this.f16237i;
                    e eVar2 = this.f16234f[length];
                    xa.j.c(eVar2);
                    this.f16237i = i15 - eVar2.f16212c;
                    this.f16236h--;
                    i12++;
                    length--;
                }
            }
            e[] eVarArr3 = this.f16234f;
            int i132 = i11 + 1;
            System.arraycopy(eVarArr3, i132, eVarArr3, i132 + i12, this.f16236h);
            e[] eVarArr22 = this.f16234f;
            int i142 = this.f16235g + 1;
            Arrays.fill(eVarArr22, i142, i142 + i12, (Object) null);
            this.f16235g += i12;
        }
    }

    public final void b(e eVar) {
        int i10 = this.f16233e;
        int i11 = eVar.f16212c;
        if (i11 > i10) {
            e[] eVarArr = this.f16234f;
            o.f(eVarArr, (j0) null, 0, eVarArr.length);
            this.f16235g = this.f16234f.length - 1;
            this.f16236h = 0;
            this.f16237i = 0;
            return;
        }
        a((this.f16237i + i11) - i10);
        int i12 = this.f16236h + 1;
        e[] eVarArr2 = this.f16234f;
        if (i12 > eVarArr2.length) {
            e[] eVarArr3 = new e[(eVarArr2.length * 2)];
            System.arraycopy(eVarArr2, 0, eVarArr3, eVarArr2.length, eVarArr2.length);
            this.f16235g = this.f16234f.length - 1;
            this.f16234f = eVarArr3;
        }
        int i13 = this.f16235g;
        this.f16235g = i13 - 1;
        this.f16234f[i13] = eVar;
        this.f16236h++;
        this.f16237i += i11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(dc.n r10) {
        /*
            r9 = this;
            java.lang.String r0 = "data"
            xa.j.f(r0, r10)
            boolean r0 = r9.f16229a
            r1 = 0
            if (r0 == 0) goto L_0x0087
            wb.k0 r0 = wb.k0.f16282a
            r0.getClass()
            int r0 = r10.d()
            r2 = 0
            r5 = r2
            r4 = 0
        L_0x0017:
            if (r4 >= r0) goto L_0x002a
            byte r7 = r10.i(r4)
            byte[] r8 = qb.f.f13487a
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte[] r8 = wb.k0.f16284c
            byte r7 = r8[r7]
            long r7 = (long) r7
            long r5 = r5 + r7
            int r4 = r4 + 1
            goto L_0x0017
        L_0x002a:
            r0 = 7
            long r7 = (long) r0
            long r5 = r5 + r7
            r0 = 3
            long r4 = r5 >> r0
            int r0 = (int) r4
            int r4 = r10.d()
            if (r0 >= r4) goto L_0x0087
            dc.j r0 = new dc.j
            r0.<init>()
            wb.k0 r4 = wb.k0.f16282a
            r4.getClass()
            int r4 = r10.d()
            r5 = r2
            r2 = 0
        L_0x0047:
            if (r1 >= r4) goto L_0x006d
            byte r3 = r10.i(r1)
            byte[] r7 = qb.f.f13487a
            r3 = r3 & 255(0xff, float:3.57E-43)
            int[] r7 = wb.k0.f16283b
            r7 = r7[r3]
            byte[] r8 = wb.k0.f16284c
            byte r3 = r8[r3]
            long r5 = r5 << r3
            long r7 = (long) r7
            long r5 = r5 | r7
            int r2 = r2 + r3
        L_0x005d:
            r3 = 8
            if (r2 < r3) goto L_0x006a
            int r2 = r2 + -8
            long r7 = r5 >> r2
            int r3 = (int) r7
            r0.Q0(r3)
            goto L_0x005d
        L_0x006a:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x006d:
            if (r2 <= 0) goto L_0x007c
            int r10 = 8 - r2
            long r3 = r5 << r10
            r5 = 255(0xff, double:1.26E-321)
            long r1 = r5 >>> r2
            long r1 = r1 | r3
            int r10 = (int) r1
            r0.Q0(r10)
        L_0x007c:
            dc.n r10 = r0.m()
            int r0 = r10.d()
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x008b
        L_0x0087:
            int r0 = r10.d()
        L_0x008b:
            r2 = 127(0x7f, float:1.78E-43)
            r9.e(r0, r2, r1)
            dc.j r0 = r9.f16230b
            r0.N0(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.g.c(dc.n):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.util.ArrayList r14) {
        /*
            r13 = this;
            boolean r0 = r13.f16232d
            r1 = 0
            if (r0 == 0) goto L_0x001e
            int r0 = r13.f16231c
            int r2 = r13.f16233e
            r3 = 32
            r4 = 31
            if (r0 >= r2) goto L_0x0012
            r13.e(r0, r4, r3)
        L_0x0012:
            r13.f16232d = r1
            r0 = 2147483647(0x7fffffff, float:NaN)
            r13.f16231c = r0
            int r0 = r13.f16233e
            r13.e(r0, r4, r3)
        L_0x001e:
            int r0 = r14.size()
            r2 = 0
        L_0x0023:
            if (r2 >= r0) goto L_0x010a
            java.lang.Object r3 = r14.get(r2)
            wb.e r3 = (wb.e) r3
            dc.n r4 = r3.f16210a
            dc.n r4 = r4.p()
            wb.h r5 = wb.h.f16252a
            r5.getClass()
            java.util.Map r5 = wb.h.f16254c
            java.lang.Object r5 = r5.get(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r6 = -1
            r7 = 1
            dc.n r8 = r3.f16211b
            if (r5 == 0) goto L_0x0075
            int r5 = r5.intValue()
            int r5 = r5 + r7
            r9 = 2
            if (r9 > r5) goto L_0x0052
            r9 = 8
            if (r5 >= r9) goto L_0x0052
            r9 = 1
            goto L_0x0053
        L_0x0052:
            r9 = 0
        L_0x0053:
            if (r9 == 0) goto L_0x0076
            wb.e[] r9 = wb.h.f16253b
            int r10 = r5 + -1
            r10 = r9[r10]
            dc.n r10 = r10.f16211b
            boolean r10 = xa.j.a(r10, r8)
            if (r10 == 0) goto L_0x0065
            r9 = r5
            goto L_0x0078
        L_0x0065:
            r9 = r9[r5]
            dc.n r9 = r9.f16211b
            boolean r9 = xa.j.a(r9, r8)
            if (r9 == 0) goto L_0x0076
            int r9 = r5 + 1
            r12 = r9
            r9 = r5
            r5 = r12
            goto L_0x0078
        L_0x0075:
            r5 = -1
        L_0x0076:
            r9 = r5
            r5 = -1
        L_0x0078:
            if (r5 != r6) goto L_0x00bf
            int r10 = r13.f16235g
            int r10 = r10 + r7
            wb.e[] r7 = r13.f16234f
            int r7 = r7.length
        L_0x0080:
            if (r10 >= r7) goto L_0x00bf
            wb.e[] r11 = r13.f16234f
            r11 = r11[r10]
            xa.j.c(r11)
            dc.n r11 = r11.f16210a
            boolean r11 = xa.j.a(r11, r4)
            if (r11 == 0) goto L_0x00bc
            wb.e[] r11 = r13.f16234f
            r11 = r11[r10]
            xa.j.c(r11)
            dc.n r11 = r11.f16211b
            boolean r11 = xa.j.a(r11, r8)
            if (r11 == 0) goto L_0x00ad
            int r5 = r13.f16235g
            int r10 = r10 - r5
            wb.h r5 = wb.h.f16252a
            r5.getClass()
            wb.e[] r5 = wb.h.f16253b
            int r5 = r5.length
            int r5 = r5 + r10
            goto L_0x00bf
        L_0x00ad:
            if (r9 != r6) goto L_0x00bc
            int r9 = r13.f16235g
            int r9 = r10 - r9
            wb.h r11 = wb.h.f16252a
            r11.getClass()
            wb.e[] r11 = wb.h.f16253b
            int r11 = r11.length
            int r9 = r9 + r11
        L_0x00bc:
            int r10 = r10 + 1
            goto L_0x0080
        L_0x00bf:
            if (r5 == r6) goto L_0x00c9
            r3 = 127(0x7f, float:1.78E-43)
            r4 = 128(0x80, float:1.794E-43)
            r13.e(r5, r3, r4)
            goto L_0x0106
        L_0x00c9:
            r5 = 64
            if (r9 != r6) goto L_0x00d6
            dc.j r6 = r13.f16230b
            r6.Q0(r5)
            r13.c(r4)
            goto L_0x0100
        L_0x00d6:
            dc.n r6 = wb.e.f16204d
            r4.getClass()
            java.lang.String r7 = "prefix"
            xa.j.f(r7, r6)
            int r7 = r6.d()
            boolean r6 = r4.m(r1, r6, r7)
            if (r6 == 0) goto L_0x00fb
            dc.n r6 = wb.e.f16209i
            boolean r4 = xa.j.a(r6, r4)
            if (r4 != 0) goto L_0x00fb
            r3 = 15
            r13.e(r9, r3, r1)
            r13.c(r8)
            goto L_0x0106
        L_0x00fb:
            r4 = 63
            r13.e(r9, r4, r5)
        L_0x0100:
            r13.c(r8)
            r13.b(r3)
        L_0x0106:
            int r2 = r2 + 1
            goto L_0x0023
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.g.d(java.util.ArrayList):void");
    }

    public final void e(int i10, int i11, int i12) {
        j jVar = this.f16230b;
        if (i10 < i11) {
            jVar.Q0(i10 | i12);
            return;
        }
        jVar.Q0(i12 | i11);
        int i13 = i10 - i11;
        while (i13 >= 128) {
            jVar.Q0(128 | (i13 & 127));
            i13 >>>= 7;
        }
        jVar.Q0(i13);
    }
}
