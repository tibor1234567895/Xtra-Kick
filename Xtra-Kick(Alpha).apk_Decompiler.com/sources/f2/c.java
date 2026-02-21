package f2;

import d2.t;
import d2.v;
import d2.w;
import d2.y;
import j1.b0;
import j1.l0;

public final class c implements v {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f5437a = new b0(12);

    /* renamed from: b  reason: collision with root package name */
    public final b f5438b = new b(0);

    /* renamed from: c  reason: collision with root package name */
    public int f5439c;

    /* renamed from: d  reason: collision with root package name */
    public y f5440d = new t();

    /* renamed from: e  reason: collision with root package name */
    public d f5441e;

    /* renamed from: f  reason: collision with root package name */
    public long f5442f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    public f[] f5443g = new f[0];

    /* renamed from: h  reason: collision with root package name */
    public long f5444h;

    /* renamed from: i  reason: collision with root package name */
    public f f5445i;

    /* renamed from: j  reason: collision with root package name */
    public int f5446j = -1;

    /* renamed from: k  reason: collision with root package name */
    public long f5447k = -1;

    /* renamed from: l  reason: collision with root package name */
    public long f5448l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f5449m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5450n;

    public final void a() {
    }

    public final f b(int i10) {
        boolean z10;
        for (f fVar : this.f5443g) {
            if (fVar.f5460b == i10 || fVar.f5461c == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return fVar;
            }
        }
        return null;
    }

    public final void c(long j10, long j11) {
        int i10;
        this.f5444h = -1;
        this.f5445i = null;
        for (f fVar : this.f5443g) {
            if (fVar.f5468j == 0) {
                i10 = 0;
            } else {
                i10 = fVar.f5470l[l0.f(fVar.f5469k, j10, true)];
            }
            fVar.f5466h = i10;
        }
        if (j10 != 0) {
            this.f5439c = 6;
        } else if (this.f5443g.length == 0) {
            this.f5439c = 0;
        } else {
            this.f5439c = 3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x034b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r21, d2.s0 r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            long r2 = r0.f5444h
            r4 = -1
            r6 = 1
            r7 = 0
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x002d
            long r2 = r21.p()
            long r8 = r0.f5444h
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 < 0) goto L_0x0027
            r10 = 262144(0x40000, double:1.295163E-318)
            long r10 = r10 + r2
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0021
            goto L_0x0027
        L_0x0021:
            long r8 = r8 - r2
            int r2 = (int) r8
            r1.g(r2)
            goto L_0x002d
        L_0x0027:
            r2 = r22
            r2.f4296a = r8
            r2 = 1
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            r0.f5444h = r4
            if (r2 == 0) goto L_0x0033
            return r6
        L_0x0033:
            int r2 = r0.f5439c
            r10 = 12
            r11 = 3
            r12 = 1414744396(0x5453494c, float:3.62987127E12)
            r8 = 0
            r9 = 1769369453(0x69766f6d, float:1.8620122E25)
            r4 = 16
            r5 = 8
            f2.b r3 = r0.f5438b
            j1.b0 r13 = r0.f5437a
            switch(r2) {
                case 0: goto L_0x03d9;
                case 1: goto L_0x037f;
                case 2: goto L_0x0276;
                case 3: goto L_0x01dc;
                case 4: goto L_0x01b8;
                case 5: goto L_0x00fe;
                case 6: goto L_0x0050;
                default: goto L_0x004a;
            }
        L_0x004a:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0050:
            long r2 = r21.p()
            long r14 = r0.f5448l
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 < 0) goto L_0x005d
            r7 = -1
            goto L_0x00fd
        L_0x005d:
            f2.f r2 = r0.f5445i
            if (r2 == 0) goto L_0x00a1
            int r3 = r2.f5465g
            d2.x0 r4 = r2.f5459a
            int r1 = r4.c(r1, r3, r7)
            int r3 = r3 - r1
            r2.f5465g = r3
            if (r3 != 0) goto L_0x0070
            r1 = 1
            goto L_0x0071
        L_0x0070:
            r1 = 0
        L_0x0071:
            if (r1 == 0) goto L_0x009c
            int r3 = r2.f5464f
            if (r3 <= 0) goto L_0x0097
            d2.x0 r9 = r2.f5459a
            int r3 = r2.f5466h
            long r4 = r2.f5462d
            long r10 = (long) r3
            long r4 = r4 * r10
            int r10 = r2.f5463e
            long r10 = (long) r10
            long r10 = r4 / r10
            int[] r4 = r2.f5470l
            int r3 = java.util.Arrays.binarySearch(r4, r3)
            if (r3 < 0) goto L_0x008f
            r12 = 1
            goto L_0x0090
        L_0x008f:
            r12 = 0
        L_0x0090:
            int r13 = r2.f5464f
            r14 = 0
            r15 = 0
            r9.e(r10, r12, r13, r14, r15)
        L_0x0097:
            int r3 = r2.f5466h
            int r3 = r3 + r6
            r2.f5466h = r3
        L_0x009c:
            if (r1 == 0) goto L_0x00fd
            r0.f5445i = r8
            goto L_0x00fd
        L_0x00a1:
            long r2 = r21.p()
            r14 = 1
            long r2 = r2 & r14
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x00af
            r1.g(r6)
        L_0x00af:
            byte[] r2 = r13.f8414a
            r1.m(r2, r7, r10)
            r13.G(r7)
            int r2 = r13.i()
            if (r2 != r12) goto L_0x00d0
            r13.G(r5)
            int r2 = r13.i()
            if (r2 != r9) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r10 = 8
        L_0x00c9:
            r1.g(r10)
            r21.f()
            goto L_0x00fd
        L_0x00d0:
            int r3 = r13.i()
            r4 = 1263424842(0x4b4e554a, float:1.352225E7)
            if (r2 != r4) goto L_0x00e2
            long r1 = r21.p()
            long r3 = (long) r3
            long r1 = r1 + r3
            r14 = 8
            goto L_0x00f3
        L_0x00e2:
            r1.g(r5)
            r21.f()
            f2.f r2 = r0.b(r2)
            if (r2 != 0) goto L_0x00f7
            long r1 = r21.p()
            long r14 = (long) r3
        L_0x00f3:
            long r1 = r1 + r14
            r0.f5444h = r1
            goto L_0x00fd
        L_0x00f7:
            r2.f5464f = r3
            r2.f5465g = r3
            r0.f5445i = r2
        L_0x00fd:
            return r7
        L_0x00fe:
            j1.b0 r2 = new j1.b0
            int r3 = r0.f5449m
            r2.<init>((int) r3)
            byte[] r3 = r2.f8414a
            int r8 = r0.f5449m
            r1.readFully(r3, r7, r8)
            int r1 = r2.f8416c
            int r3 = r2.f8415b
            int r1 = r1 - r3
            r8 = 0
            if (r1 >= r4) goto L_0x0116
            goto L_0x012b
        L_0x0116:
            r2.H(r5)
            int r1 = r2.i()
            long r12 = (long) r1
            long r14 = r0.f5447k
            int r1 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x0125
            goto L_0x0128
        L_0x0125:
            r8 = 8
            long r8 = r8 + r14
        L_0x0128:
            r2.G(r3)
        L_0x012b:
            int r1 = r2.f8416c
            int r3 = r2.f8415b
            int r1 = r1 - r3
            if (r1 < r4) goto L_0x0182
            int r1 = r2.i()
            int r3 = r2.i()
            int r5 = r2.i()
            long r12 = (long) r5
            long r12 = r12 + r8
            r2.i()
            f2.f r1 = r0.b(r1)
            if (r1 != 0) goto L_0x014a
            goto L_0x012b
        L_0x014a:
            r3 = r3 & r4
            if (r3 != r4) goto L_0x017c
            int r3 = r1.f5468j
            int[] r5 = r1.f5470l
            int r5 = r5.length
            if (r3 != r5) goto L_0x016d
            long[] r3 = r1.f5469k
            int r5 = r3.length
            int r5 = r5 * 3
            r10 = 2
            int r5 = r5 / r10
            long[] r3 = java.util.Arrays.copyOf(r3, r5)
            r1.f5469k = r3
            int[] r3 = r1.f5470l
            int r5 = r3.length
            int r5 = r5 * 3
            int r5 = r5 / r10
            int[] r3 = java.util.Arrays.copyOf(r3, r5)
            r1.f5470l = r3
        L_0x016d:
            long[] r3 = r1.f5469k
            int r5 = r1.f5468j
            r3[r5] = r12
            int[] r3 = r1.f5470l
            int r10 = r1.f5467i
            r3[r5] = r10
            int r5 = r5 + r6
            r1.f5468j = r5
        L_0x017c:
            int r3 = r1.f5467i
            int r3 = r3 + r6
            r1.f5467i = r3
            goto L_0x012b
        L_0x0182:
            f2.f[] r1 = r0.f5443g
            int r2 = r1.length
            r3 = 0
        L_0x0186:
            if (r3 >= r2) goto L_0x01a1
            r4 = r1[r3]
            long[] r5 = r4.f5469k
            int r8 = r4.f5468j
            long[] r5 = java.util.Arrays.copyOf(r5, r8)
            r4.f5469k = r5
            int[] r5 = r4.f5470l
            int r8 = r4.f5468j
            int[] r5 = java.util.Arrays.copyOf(r5, r8)
            r4.f5470l = r5
            int r3 = r3 + 1
            goto L_0x0186
        L_0x01a1:
            r0.f5450n = r6
            d2.y r1 = r0.f5440d
            d2.e0 r2 = new d2.e0
            long r3 = r0.f5442f
            r5 = 2
            r2.<init>(r5, r3, r0)
            r1.g(r2)
            r1 = 6
            r0.f5439c = r1
            long r1 = r0.f5447k
            r0.f5444h = r1
            return r7
        L_0x01b8:
            byte[] r2 = r13.f8414a
            r1.readFully(r2, r7, r5)
            r13.G(r7)
            int r2 = r13.i()
            int r3 = r13.i()
            r4 = 829973609(0x31786469, float:3.6145826E-9)
            if (r2 != r4) goto L_0x01d3
            r1 = 5
            r0.f5439c = r1
            r0.f5449m = r3
            goto L_0x01db
        L_0x01d3:
            long r1 = r21.p()
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.f5444h = r1
        L_0x01db:
            return r7
        L_0x01dc:
            long r14 = r0.f5447k
            r17 = -1
            int r2 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x01f1
            long r14 = r21.p()
            long r4 = r0.f5447k
            int r8 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x01f1
            r0.f5444h = r4
            return r7
        L_0x01f1:
            byte[] r4 = r13.f8414a
            r1.m(r4, r7, r10)
            r21.f()
            r13.G(r7)
            r3.getClass()
            int r4 = r13.i()
            r3.f5434a = r4
            int r4 = r13.i()
            r3.f5435b = r4
            r3.f5436c = r7
            int r4 = r13.i()
            int r5 = r3.f5434a
            r8 = 1179011410(0x46464952, float:12690.33)
            if (r5 != r8) goto L_0x021c
            r1.g(r10)
            return r7
        L_0x021c:
            if (r5 != r12) goto L_0x0268
            if (r4 == r9) goto L_0x0221
            goto L_0x0268
        L_0x0221:
            long r4 = r21.p()
            r0.f5447k = r4
            int r3 = r3.f5435b
            long r8 = (long) r3
            long r4 = r4 + r8
            r8 = 8
            long r4 = r4 + r8
            r0.f5448l = r4
            boolean r3 = r0.f5450n
            if (r3 != 0) goto L_0x025b
            f2.d r3 = r0.f5441e
            r3.getClass()
            int r3 = r3.f5452b
            r2 = 16
            r3 = r3 & r2
            if (r3 != r2) goto L_0x0242
            r2 = 1
            goto L_0x0243
        L_0x0242:
            r2 = 0
        L_0x0243:
            if (r2 == 0) goto L_0x024d
            r2 = 4
            r0.f5439c = r2
            long r1 = r0.f5448l
            r0.f5444h = r1
            return r7
        L_0x024d:
            d2.y r2 = r0.f5440d
            d2.e0 r3 = new d2.e0
            long r4 = r0.f5442f
            r3.<init>(r4)
            r2.g(r3)
            r0.f5450n = r6
        L_0x025b:
            long r1 = r21.p()
            r3 = 12
            long r1 = r1 + r3
            r0.f5444h = r1
            r1 = 6
            r0.f5439c = r1
            return r7
        L_0x0268:
            long r1 = r21.p()
            int r3 = r3.f5435b
            long r3 = (long) r3
            long r1 = r1 + r3
            r3 = 8
            long r1 = r1 + r3
            r0.f5444h = r1
            return r7
        L_0x0276:
            int r2 = r0.f5446j
            r3 = 4
            int r2 = r2 - r3
            j1.b0 r3 = new j1.b0
            r3.<init>((int) r2)
            byte[] r4 = r3.f8414a
            r1.readFully(r4, r7, r2)
            r1 = 1819436136(0x6c726468, float:1.1721368E27)
            f2.g r2 = f2.g.b(r1, r3)
            int r3 = r2.f5472b
            if (r3 != r1) goto L_0x036c
            java.lang.Class<f2.d> r1 = f2.d.class
            f2.a r1 = r2.a(r1)
            f2.d r1 = (f2.d) r1
            if (r1 == 0) goto L_0x0365
            r0.f5441e = r1
            int r3 = r1.f5453c
            long r3 = (long) r3
            int r1 = r1.f5451a
            long r9 = (long) r1
            long r3 = r3 * r9
            r0.f5442f = r3
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            d9.r0 r2 = r2.f5471a
            d9.p0 r2 = r2.listIterator(r7)
            r13 = 0
        L_0x02b1:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0352
            java.lang.Object r3 = r2.next()
            f2.a r3 = (f2.a) r3
            int r4 = r3.getType()
            r5 = 1819440243(0x6c727473, float:1.17243986E27)
            if (r4 != r5) goto L_0x02b1
            f2.g r3 = (f2.g) r3
            int r4 = r13 + 1
            java.lang.Class<f2.e> r5 = f2.e.class
            f2.a r5 = r3.a(r5)
            f2.e r5 = (f2.e) r5
            java.lang.Class<f2.h> r9 = f2.h.class
            f2.a r9 = r3.a(r9)
            f2.h r9 = (f2.h) r9
            if (r5 != 0) goto L_0x02df
            java.lang.String r3 = "Missing Stream Header"
            goto L_0x02e3
        L_0x02df:
            if (r9 != 0) goto L_0x02e9
            java.lang.String r3 = "Missing Stream Format"
        L_0x02e3:
            java.lang.String r5 = "AviExtractor"
            j1.v.g(r5, r3)
            goto L_0x032a
        L_0x02e9:
            int r10 = r5.f5457d
            long r14 = (long) r10
            int r10 = r5.f5455b
            long r11 = (long) r10
            r16 = 1000000(0xf4240, double:4.940656E-318)
            long r16 = r16 * r11
            int r10 = r5.f5456c
            long r10 = (long) r10
            r18 = r10
            long r10 = j1.l0.M(r14, r16, r18)
            g1.a0 r9 = r9.f5473a
            r9.getClass()
            g1.z r12 = new g1.z
            r12.<init>(r9)
            r12.b(r13)
            int r14 = r5.f5458e
            if (r14 == 0) goto L_0x0310
            r12.f6755l = r14
        L_0x0310:
            java.lang.Class<f2.i> r14 = f2.i.class
            f2.a r3 = r3.a(r14)
            f2.i r3 = (f2.i) r3
            if (r3 == 0) goto L_0x031e
            java.lang.String r3 = r3.f5474a
            r12.f6745b = r3
        L_0x031e:
            java.lang.String r3 = r9.f6276s
            int r14 = g1.a1.h(r3)
            if (r14 == r6) goto L_0x032c
            r3 = 2
            if (r14 != r3) goto L_0x032a
            goto L_0x032c
        L_0x032a:
            r9 = r8
            goto L_0x0349
        L_0x032c:
            d2.y r3 = r0.f5440d
            d2.x0 r3 = r3.d(r13, r14)
            g1.a0 r9 = new g1.a0
            r9.<init>(r12)
            r3.a(r9)
            f2.f r9 = new f2.f
            int r5 = r5.f5457d
            r12 = r9
            r15 = r10
            r17 = r5
            r18 = r3
            r12.<init>(r13, r14, r15, r17, r18)
            r0.f5442f = r10
        L_0x0349:
            if (r9 == 0) goto L_0x034e
            r1.add(r9)
        L_0x034e:
            r13 = r4
            r11 = 3
            goto L_0x02b1
        L_0x0352:
            f2.f[] r2 = new f2.f[r7]
            java.lang.Object[] r1 = r1.toArray(r2)
            f2.f[] r1 = (f2.f[]) r1
            r0.f5443g = r1
            d2.y r1 = r0.f5440d
            r1.a()
            r1 = 3
            r0.f5439c = r1
            return r7
        L_0x0365:
            java.lang.String r1 = "AviHeader not found"
            g1.b1 r1 = g1.b1.a(r1, r8)
            throw r1
        L_0x036c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected header list type "
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r8)
            throw r1
        L_0x037f:
            byte[] r2 = r13.f8414a
            r1.readFully(r2, r7, r10)
            r13.G(r7)
            r3.getClass()
            int r1 = r13.i()
            r3.f5434a = r1
            int r1 = r13.i()
            r3.f5435b = r1
            r3.f5436c = r7
            int r1 = r3.f5434a
            if (r1 != r12) goto L_0x03c4
            int r1 = r13.i()
            r3.f5436c = r1
            r2 = 1819436136(0x6c726468, float:1.1721368E27)
            if (r1 != r2) goto L_0x03af
            int r1 = r3.f5435b
            r0.f5446j = r1
            r1 = 2
            r0.f5439c = r1
            return r7
        L_0x03af:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "hdrl expected, found: "
            r1.<init>(r2)
            int r2 = r3.f5436c
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r8)
            throw r1
        L_0x03c4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "LIST expected, found: "
            r1.<init>(r2)
            int r2 = r3.f5434a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.a(r1, r8)
            throw r1
        L_0x03d9:
            boolean r2 = r20.h(r21)
            if (r2 == 0) goto L_0x03e5
            r1.g(r10)
            r0.f5439c = r6
            return r7
        L_0x03e5:
            java.lang.String r1 = "AVI Header List not found"
            g1.b1 r1 = g1.b1.a(r1, r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f5439c = 0;
        this.f5440d = yVar;
        this.f5444h = -1;
    }

    public final boolean h(w wVar) {
        b0 b0Var = this.f5437a;
        wVar.m(b0Var.f8414a, 0, 12);
        b0Var.G(0);
        if (b0Var.i() != 1179011410) {
            return false;
        }
        b0Var.H(4);
        if (b0Var.i() == 541677121) {
            return true;
        }
        return false;
    }
}
