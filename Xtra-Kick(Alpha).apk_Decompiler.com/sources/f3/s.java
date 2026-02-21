package f3;

import android.support.v4.media.n;
import d2.p0;
import d2.x0;
import d2.y;
import j1.b0;

public final class s implements k {

    /* renamed from: a  reason: collision with root package name */
    public final n f5716a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5717b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5718c;

    /* renamed from: d  reason: collision with root package name */
    public final y f5719d = new y(7);

    /* renamed from: e  reason: collision with root package name */
    public final y f5720e = new y(8);

    /* renamed from: f  reason: collision with root package name */
    public final y f5721f = new y(6);

    /* renamed from: g  reason: collision with root package name */
    public long f5722g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f5723h = new boolean[3];

    /* renamed from: i  reason: collision with root package name */
    public String f5724i;

    /* renamed from: j  reason: collision with root package name */
    public x0 f5725j;

    /* renamed from: k  reason: collision with root package name */
    public r f5726k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5727l;

    /* renamed from: m  reason: collision with root package name */
    public long f5728m = -9223372036854775807L;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5729n;

    /* renamed from: o  reason: collision with root package name */
    public final b0 f5730o = new b0();

    public s(n nVar, boolean z10, boolean z11) {
        this.f5716a = nVar;
        this.f5717b = z10;
        this.f5718c = z11;
    }

    public final void a() {
        this.f5722g = 0;
        this.f5729n = false;
        this.f5728m = -9223372036854775807L;
        p0.a(this.f5723h);
        this.f5719d.c();
        this.f5720e.c();
        this.f5721f.c();
        r rVar = this.f5726k;
        if (rVar != null) {
            rVar.f5708k = false;
            rVar.f5712o = false;
            q qVar = rVar.f5711n;
            qVar.f5683b = false;
            qVar.f5682a = false;
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Cloneable, byte[]] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(byte[] r18, int r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            boolean r4 = r0.f5727l
            if (r4 == 0) goto L_0x0012
            f3.r r4 = r0.f5726k
            boolean r4 = r4.f5700c
            if (r4 == 0) goto L_0x001c
        L_0x0012:
            f3.y r4 = r0.f5719d
            r4.a(r1, r2, r3)
            f3.y r4 = r0.f5720e
            r4.a(r1, r2, r3)
        L_0x001c:
            f3.y r4 = r0.f5721f
            r4.a(r1, r2, r3)
            f3.r r4 = r0.f5726k
            boolean r5 = r4.f5708k
            if (r5 != 0) goto L_0x0029
            goto L_0x0187
        L_0x0029:
            int r3 = r3 - r2
            byte[] r5 = r4.f5704g
            int r6 = r5.length
            int r7 = r4.f5705h
            int r7 = r7 + r3
            r8 = 2
            if (r6 >= r7) goto L_0x003b
            int r7 = r7 * 2
            byte[] r5 = java.util.Arrays.copyOf(r5, r7)
            r4.f5704g = r5
        L_0x003b:
            byte[] r5 = r4.f5704g
            int r6 = r4.f5705h
            java.lang.System.arraycopy(r1, r2, r5, r6, r3)
            int r1 = r4.f5705h
            int r1 = r1 + r3
            r4.f5705h = r1
            byte[] r2 = r4.f5704g
            d2.r0 r3 = r4.f5703f
            r3.f4289b = r2
            r2 = 0
            r3.f4291d = r2
            r3.f4290c = r1
            r3.f4292e = r2
            r3.c()
            r1 = 8
            boolean r1 = r3.d(r1)
            if (r1 != 0) goto L_0x0061
            goto L_0x0187
        L_0x0061:
            r3.l()
            int r1 = r3.h(r8)
            r5 = 5
            r3.m(r5)
            boolean r6 = r3.e()
            if (r6 != 0) goto L_0x0074
            goto L_0x0187
        L_0x0074:
            r3.i()
            boolean r6 = r3.e()
            if (r6 != 0) goto L_0x007f
            goto L_0x0187
        L_0x007f:
            int r6 = r3.i()
            boolean r7 = r4.f5700c
            r9 = 1
            if (r7 != 0) goto L_0x0092
            r4.f5708k = r2
            f3.q r1 = r4.f5711n
            r1.f5686e = r6
            r1.f5683b = r9
            goto L_0x0187
        L_0x0092:
            boolean r7 = r3.e()
            if (r7 != 0) goto L_0x009a
            goto L_0x0187
        L_0x009a:
            int r7 = r3.i()
            android.util.SparseArray r10 = r4.f5702e
            int r11 = r10.indexOfKey(r7)
            if (r11 >= 0) goto L_0x00aa
            r4.f5708k = r2
            goto L_0x0187
        L_0x00aa:
            java.lang.Object r10 = r10.get(r7)
            d2.n0 r10 = (d2.n0) r10
            android.util.SparseArray r11 = r4.f5701d
            int r12 = r10.f4249b
            java.lang.Object r11 = r11.get(r12)
            d2.o0 r11 = (d2.o0) r11
            boolean r12 = r11.f4265h
            if (r12 == 0) goto L_0x00c9
            boolean r12 = r3.d(r8)
            if (r12 != 0) goto L_0x00c6
            goto L_0x0187
        L_0x00c6:
            r3.m(r8)
        L_0x00c9:
            int r8 = r11.f4267j
            boolean r12 = r3.d(r8)
            if (r12 != 0) goto L_0x00d3
            goto L_0x0187
        L_0x00d3:
            int r8 = r3.h(r8)
            boolean r12 = r11.f4266i
            if (r12 != 0) goto L_0x00f7
            boolean r12 = r3.d(r9)
            if (r12 != 0) goto L_0x00e3
            goto L_0x0187
        L_0x00e3:
            boolean r12 = r3.f()
            if (r12 == 0) goto L_0x00f8
            boolean r13 = r3.d(r9)
            if (r13 != 0) goto L_0x00f1
            goto L_0x0187
        L_0x00f1:
            boolean r13 = r3.f()
            r14 = 1
            goto L_0x00fa
        L_0x00f7:
            r12 = 0
        L_0x00f8:
            r13 = 0
            r14 = 0
        L_0x00fa:
            int r15 = r4.f5706i
            if (r15 != r5) goto L_0x0100
            r5 = 1
            goto L_0x0101
        L_0x0100:
            r5 = 0
        L_0x0101:
            if (r5 == 0) goto L_0x0110
            boolean r15 = r3.e()
            if (r15 != 0) goto L_0x010b
            goto L_0x0187
        L_0x010b:
            int r15 = r3.i()
            goto L_0x0111
        L_0x0110:
            r15 = 0
        L_0x0111:
            boolean r10 = r10.f4250c
            int r2 = r11.f4268k
            if (r2 != 0) goto L_0x013a
            int r2 = r11.f4269l
            boolean r16 = r3.d(r2)
            if (r16 != 0) goto L_0x0121
            goto L_0x0187
        L_0x0121:
            int r2 = r3.h(r2)
            if (r10 == 0) goto L_0x0135
            if (r12 != 0) goto L_0x0135
            boolean r10 = r3.e()
            if (r10 != 0) goto L_0x0130
            goto L_0x0187
        L_0x0130:
            int r3 = r3.j()
            goto L_0x0136
        L_0x0135:
            r3 = 0
        L_0x0136:
            r10 = r3
            r3 = 0
            r9 = 0
            goto L_0x0161
        L_0x013a:
            if (r2 != r9) goto L_0x015b
            boolean r2 = r11.f4270m
            if (r2 != 0) goto L_0x015b
            boolean r2 = r3.e()
            if (r2 != 0) goto L_0x0147
            goto L_0x0187
        L_0x0147:
            int r2 = r3.j()
            if (r10 == 0) goto L_0x015c
            if (r12 != 0) goto L_0x015c
            boolean r10 = r3.e()
            if (r10 != 0) goto L_0x0156
            goto L_0x0187
        L_0x0156:
            int r3 = r3.j()
            goto L_0x015d
        L_0x015b:
            r2 = 0
        L_0x015c:
            r3 = 0
        L_0x015d:
            r9 = r3
            r10 = 0
            r3 = r2
            r2 = 0
        L_0x0161:
            f3.q r0 = r4.f5711n
            r0.f5684c = r11
            r0.f5685d = r1
            r0.f5686e = r6
            r0.f5687f = r8
            r0.f5688g = r7
            r0.f5689h = r12
            r0.f5690i = r14
            r0.f5691j = r13
            r0.f5692k = r5
            r0.f5693l = r15
            r0.f5694m = r2
            r0.f5695n = r10
            r0.f5696o = r3
            r0.f5697p = r9
            r1 = 1
            r0.f5682a = r1
            r0.f5683b = r1
            r0 = 0
            r4.f5708k = r0
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.s.b(byte[], int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0269, code lost:
        if (r1 != 1) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b1, code lost:
        if (r6.f5695n != r7.f5695n) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c2, code lost:
        if (r6.f5697p != r7.f5697p) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01d0, code lost:
        if (r6.f5693l != r7.f5693l) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01d6, code lost:
        if (r6 == false) goto L_0x0214;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0271 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0289 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0230 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            d2.x0 r2 = r0.f5725j
            j1.a.f(r2)
            int r2 = j1.l0.f8453a
            int r2 = r1.f8415b
            int r3 = r1.f8416c
            byte[] r4 = r1.f8414a
            long r5 = r0.f5722g
            int r7 = r3 - r2
            long r8 = (long) r7
            long r5 = r5 + r8
            r0.f5722g = r5
            d2.x0 r5 = r0.f5725j
            r5.d(r7, r1)
        L_0x001e:
            boolean[] r1 = r0.f5723h
            int r1 = d2.p0.b(r4, r2, r3, r1)
            if (r1 != r3) goto L_0x002a
            r0.b(r4, r2, r3)
            return
        L_0x002a:
            int r5 = r1 + 3
            byte r6 = r4[r5]
            r6 = r6 & 31
            int r7 = r1 - r2
            if (r7 <= 0) goto L_0x0037
            r0.b(r4, r2, r1)
        L_0x0037:
            int r1 = r3 - r1
            long r8 = r0.f5722g
            long r10 = (long) r1
            long r8 = r8 - r10
            if (r7 >= 0) goto L_0x0041
            int r7 = -r7
            goto L_0x0042
        L_0x0041:
            r7 = 0
        L_0x0042:
            long r10 = r0.f5728m
            boolean r12 = r0.f5727l
            f3.y r14 = r0.f5720e
            f3.y r15 = r0.f5719d
            if (r12 == 0) goto L_0x005d
            f3.r r12 = r0.f5726k
            boolean r12 = r12.f5700c
            if (r12 == 0) goto L_0x0053
            goto L_0x005d
        L_0x0053:
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            goto L_0x0127
        L_0x005d:
            r15.b(r7)
            r14.b(r7)
            boolean r12 = r0.f5727l
            if (r12 != 0) goto L_0x00ed
            boolean r12 = r15.f5799c
            if (r12 == 0) goto L_0x0053
            boolean r12 = r14.f5799c
            if (r12 == 0) goto L_0x0053
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            byte[] r13 = r15.f5800d
            int r2 = r15.f5801e
            byte[] r2 = java.util.Arrays.copyOf(r13, r2)
            r12.add(r2)
            byte[] r2 = r14.f5800d
            int r13 = r14.f5801e
            byte[] r2 = java.util.Arrays.copyOf(r2, r13)
            r12.add(r2)
            byte[] r2 = r15.f5800d
            int r13 = r15.f5801e
            r16 = r3
            r3 = 3
            d2.o0 r2 = d2.p0.e(r2, r3, r13)
            byte[] r3 = r14.f5800d
            int r13 = r14.f5801e
            d2.n0 r3 = d2.p0.d(r3, r13)
            int r13 = r2.f4258a
            r17 = r4
            int r4 = r2.f4259b
            r18 = r5
            int r5 = r2.f4260c
            java.lang.String r4 = j1.e.a(r13, r4, r5)
            d2.x0 r5 = r0.f5725j
            g1.z r13 = new g1.z
            r13.<init>()
            r19 = r6
            java.lang.String r6 = r0.f5724i
            r13.f6744a = r6
            java.lang.String r6 = "video/avc"
            r13.f6754k = r6
            r13.f6751h = r4
            int r4 = r2.f4262e
            r13.f6759p = r4
            int r4 = r2.f4263f
            r13.f6760q = r4
            float r4 = r2.f4264g
            r13.f6763t = r4
            r13.f6756m = r12
            g1.a0 r4 = new g1.a0
            r4.<init>(r13)
            r5.a(r4)
            r4 = 1
            r0.f5727l = r4
            f3.r r4 = r0.f5726k
            android.util.SparseArray r4 = r4.f5701d
            int r5 = r2.f4261d
            r4.append(r5, r2)
            f3.r r2 = r0.f5726k
            android.util.SparseArray r2 = r2.f5702e
            int r4 = r3.f4248a
            r2.append(r4, r3)
            r15.c()
            goto L_0x0124
        L_0x00ed:
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            boolean r2 = r15.f5799c
            if (r2 == 0) goto L_0x010f
            byte[] r2 = r15.f5800d
            int r3 = r15.f5801e
            r4 = 3
            d2.o0 r2 = d2.p0.e(r2, r4, r3)
            f3.r r3 = r0.f5726k
            android.util.SparseArray r3 = r3.f5701d
            int r4 = r2.f4261d
            r3.append(r4, r2)
            r15.c()
            goto L_0x0127
        L_0x010f:
            boolean r2 = r14.f5799c
            if (r2 == 0) goto L_0x0127
            byte[] r2 = r14.f5800d
            int r3 = r14.f5801e
            d2.n0 r2 = d2.p0.d(r2, r3)
            f3.r r3 = r0.f5726k
            android.util.SparseArray r3 = r3.f5702e
            int r4 = r2.f4248a
            r3.append(r4, r2)
        L_0x0124:
            r14.c()
        L_0x0127:
            f3.y r2 = r0.f5721f
            boolean r3 = r2.b(r7)
            if (r3 == 0) goto L_0x014b
            byte[] r3 = r2.f5800d
            int r4 = r2.f5801e
            int r3 = d2.p0.f(r4, r3)
            byte[] r4 = r2.f5800d
            j1.b0 r5 = r0.f5730o
            r5.E(r3, r4)
            r3 = 4
            r5.G(r3)
            android.support.v4.media.n r3 = r0.f5716a
            java.lang.Object r3 = r3.f338j
            d2.x0[] r3 = (d2.x0[]) r3
            d2.m.a(r10, r5, r3)
        L_0x014b:
            f3.r r3 = r0.f5726k
            boolean r4 = r0.f5727l
            boolean r5 = r0.f5729n
            int r6 = r3.f5706i
            r7 = 9
            if (r6 == r7) goto L_0x01d8
            boolean r6 = r3.f5700c
            if (r6 == 0) goto L_0x0214
            f3.q r6 = r3.f5711n
            f3.q r7 = r3.f5710m
            boolean r10 = r6.f5682a
            if (r10 != 0) goto L_0x0165
            goto L_0x01d3
        L_0x0165:
            boolean r10 = r7.f5682a
            if (r10 != 0) goto L_0x016b
            goto L_0x01d5
        L_0x016b:
            d2.o0 r10 = r6.f5684c
            j1.a.f(r10)
            d2.o0 r11 = r7.f5684c
            j1.a.f(r11)
            int r12 = r6.f5687f
            int r13 = r7.f5687f
            if (r12 != r13) goto L_0x01d5
            int r12 = r6.f5688g
            int r13 = r7.f5688g
            if (r12 != r13) goto L_0x01d5
            boolean r12 = r6.f5689h
            boolean r13 = r7.f5689h
            if (r12 != r13) goto L_0x01d5
            boolean r12 = r6.f5690i
            if (r12 == 0) goto L_0x0195
            boolean r12 = r7.f5690i
            if (r12 == 0) goto L_0x0195
            boolean r12 = r6.f5691j
            boolean r13 = r7.f5691j
            if (r12 != r13) goto L_0x01d5
        L_0x0195:
            int r12 = r6.f5685d
            int r13 = r7.f5685d
            if (r12 == r13) goto L_0x019f
            if (r12 == 0) goto L_0x01d5
            if (r13 == 0) goto L_0x01d5
        L_0x019f:
            int r11 = r11.f4268k
            int r10 = r10.f4268k
            if (r10 != 0) goto L_0x01b3
            if (r11 != 0) goto L_0x01b3
            int r12 = r6.f5694m
            int r13 = r7.f5694m
            if (r12 != r13) goto L_0x01d5
            int r12 = r6.f5695n
            int r13 = r7.f5695n
            if (r12 != r13) goto L_0x01d5
        L_0x01b3:
            r12 = 1
            if (r10 != r12) goto L_0x01c4
            if (r11 != r12) goto L_0x01c4
            int r10 = r6.f5696o
            int r11 = r7.f5696o
            if (r10 != r11) goto L_0x01d5
            int r10 = r6.f5697p
            int r11 = r7.f5697p
            if (r10 != r11) goto L_0x01d5
        L_0x01c4:
            boolean r10 = r6.f5692k
            boolean r11 = r7.f5692k
            if (r10 != r11) goto L_0x01d5
            if (r10 == 0) goto L_0x01d3
            int r6 = r6.f5693l
            int r7 = r7.f5693l
            if (r6 == r7) goto L_0x01d3
            goto L_0x01d5
        L_0x01d3:
            r6 = 0
            goto L_0x01d6
        L_0x01d5:
            r6 = 1
        L_0x01d6:
            if (r6 == 0) goto L_0x0214
        L_0x01d8:
            if (r4 == 0) goto L_0x0206
            boolean r4 = r3.f5712o
            if (r4 == 0) goto L_0x0206
            long r6 = r3.f5707j
            long r10 = r8 - r6
            int r4 = (int) r10
            int r25 = r1 + r4
            long r10 = r3.f5714q
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x01f1
            goto L_0x0206
        L_0x01f1:
            boolean r1 = r3.f5715r
            long r12 = r3.f5713p
            long r6 = r6 - r12
            int r4 = (int) r6
            d2.x0 r6 = r3.f5698a
            r26 = 0
            r20 = r6
            r21 = r10
            r23 = r1
            r24 = r4
            r20.e(r21, r23, r24, r25, r26)
        L_0x0206:
            long r6 = r3.f5707j
            r3.f5713p = r6
            long r6 = r3.f5709l
            r3.f5714q = r6
            r1 = 0
            r3.f5715r = r1
            r1 = 1
            r3.f5712o = r1
        L_0x0214:
            boolean r1 = r3.f5699b
            r4 = 2
            if (r1 == 0) goto L_0x0229
            f3.q r1 = r3.f5711n
            boolean r5 = r1.f5683b
            if (r5 == 0) goto L_0x0228
            int r1 = r1.f5686e
            r5 = 7
            if (r1 == r5) goto L_0x0226
            if (r1 != r4) goto L_0x0228
        L_0x0226:
            r5 = 1
            goto L_0x0229
        L_0x0228:
            r5 = 0
        L_0x0229:
            boolean r1 = r3.f5715r
            int r6 = r3.f5706i
            r7 = 5
            if (r6 == r7) goto L_0x0238
            if (r5 == 0) goto L_0x0236
            r5 = 1
            if (r6 != r5) goto L_0x0236
            goto L_0x0238
        L_0x0236:
            r5 = 0
            goto L_0x0239
        L_0x0238:
            r5 = 1
        L_0x0239:
            r1 = r1 | r5
            r3.f5715r = r1
            if (r1 == 0) goto L_0x0241
            r1 = 0
            r0.f5729n = r1
        L_0x0241:
            long r5 = r0.f5728m
            boolean r1 = r0.f5727l
            if (r1 == 0) goto L_0x0251
            f3.r r1 = r0.f5726k
            boolean r1 = r1.f5700c
            if (r1 == 0) goto L_0x024e
            goto L_0x0251
        L_0x024e:
            r1 = r19
            goto L_0x0259
        L_0x0251:
            r1 = r19
            r15.d(r1)
            r14.d(r1)
        L_0x0259:
            r2.d(r1)
            f3.r r2 = r0.f5726k
            r2.f5706i = r1
            r2.f5709l = r5
            r2.f5707j = r8
            boolean r3 = r2.f5699b
            if (r3 == 0) goto L_0x026c
            r3 = 1
            if (r1 == r3) goto L_0x0277
            goto L_0x026d
        L_0x026c:
            r3 = 1
        L_0x026d:
            boolean r5 = r2.f5700c
            if (r5 == 0) goto L_0x0289
            if (r1 == r7) goto L_0x0277
            if (r1 == r3) goto L_0x0277
            if (r1 != r4) goto L_0x0289
        L_0x0277:
            f3.q r1 = r2.f5710m
            f3.q r3 = r2.f5711n
            r2.f5710m = r3
            r2.f5711n = r1
            r3 = 0
            r1.f5683b = r3
            r1.f5682a = r3
            r2.f5705h = r3
            r1 = 1
            r2.f5708k = r1
        L_0x0289:
            r3 = r16
            r4 = r17
            r2 = r18
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.s.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5724i = j0Var.f5631e;
        j0Var.b();
        x0 d10 = yVar.d(j0Var.f5630d, 2);
        this.f5725j = d10;
        this.f5726k = new r(d10, this.f5717b, this.f5718c);
        this.f5716a.m(yVar, j0Var);
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5728m = j10;
        }
        this.f5729n = ((i10 & 2) != 0) | this.f5729n;
    }

    public final void f() {
    }
}
