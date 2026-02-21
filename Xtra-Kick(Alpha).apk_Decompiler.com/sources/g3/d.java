package g3;

import d2.v;
import d2.w;
import d2.x0;
import d2.y;

public final class d implements v {

    /* renamed from: a  reason: collision with root package name */
    public y f6818a;

    /* renamed from: b  reason: collision with root package name */
    public x0 f6819b;

    /* renamed from: c  reason: collision with root package name */
    public int f6820c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f6821d = -1;

    /* renamed from: e  reason: collision with root package name */
    public b f6822e;

    /* renamed from: f  reason: collision with root package name */
    public int f6823f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f6824g = -1;

    public final void a() {
    }

    public final void c(long j10, long j11) {
        this.f6820c = j10 == 0 ? 0 : 4;
        b bVar = this.f6822e;
        if (bVar != null) {
            bVar.c(j11);
        }
    }

    /* JADX WARNING: type inference failed for: r2v21, types: [g3.a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r29, d2.s0 r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            d2.x0 r2 = r0.f6819b
            j1.a.f(r2)
            int r2 = j1.l0.f8453a
            int r2 = r0.f6820c
            r3 = -1
            r4 = 4
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x01e5
            r7 = 8
            r8 = 2
            r9 = -1
            if (r2 == r5) goto L_0x01b6
            r11 = 3
            if (r2 == r8) goto L_0x00cf
            if (r2 == r11) goto L_0x0047
            if (r2 != r4) goto L_0x0041
            long r7 = r0.f6824g
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r5 = 0
        L_0x0029:
            j1.a.e(r5)
            long r4 = r0.f6824g
            long r7 = r29.p()
            long r4 = r4 - r7
            g3.b r2 = r0.f6822e
            r2.getClass()
            boolean r1 = r2.a(r1, r4)
            if (r1 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            return r3
        L_0x0041:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0047:
            r29.f()
            j1.b0 r2 = new j1.b0
            r2.<init>((int) r7)
            r3 = 1684108385(0x64617461, float:1.6635614E22)
            a2.k r2 = g3.e.b(r3, r1, r2)
            r1.g(r7)
            long r7 = r29.p()
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            long r7 = r2.f60b
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            android.util.Pair r2 = android.util.Pair.create(r3, r2)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            int r3 = r3.intValue()
            r0.f6823f = r3
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            long r7 = r0.f6821d
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x008d
            r11 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x008d
            r2 = r7
        L_0x008d:
            int r5 = r0.f6823f
            long r7 = (long) r5
            long r7 = r7 + r2
            r0.f6824g = r7
            long r1 = r29.c()
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x00c0
            long r7 = r0.f6824g
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Data exceeds input length: "
            r3.<init>(r5)
            long r7 = r0.f6824g
            r3.append(r7)
            java.lang.String r5 = ", "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "WavExtractor"
            j1.v.g(r5, r3)
            r0.f6824g = r1
        L_0x00c0:
            g3.b r1 = r0.f6822e
            r1.getClass()
            int r2 = r0.f6823f
            long r7 = r0.f6824g
            r1.b(r2, r7)
            r0.f6820c = r4
            return r6
        L_0x00cf:
            j1.b0 r2 = new j1.b0
            r3 = 16
            r2.<init>((int) r3)
            r7 = 1718449184(0x666d7420, float:2.8033575E23)
            a2.k r7 = g3.e.b(r7, r1, r2)
            r8 = 16
            long r12 = r7.f60b
            int r7 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r7 < 0) goto L_0x00e7
            r7 = 1
            goto L_0x00e8
        L_0x00e7:
            r7 = 0
        L_0x00e8:
            j1.a.e(r7)
            byte[] r7 = r2.f8414a
            r1.m(r7, r6, r3)
            r2.G(r6)
            int r7 = r2.n()
            int r16 = r2.n()
            int r17 = r2.m()
            int r18 = r2.m()
            int r19 = r2.n()
            int r2 = r2.n()
            int r8 = (int) r12
            int r8 = r8 - r3
            if (r8 <= 0) goto L_0x0115
            byte[] r3 = new byte[r8]
            r1.m(r3, r6, r8)
            goto L_0x0117
        L_0x0115:
            byte[] r3 = j1.l0.f8458f
        L_0x0117:
            r21 = r3
            long r8 = r29.l()
            long r12 = r29.p()
            long r8 = r8 - r12
            int r3 = (int) r8
            r1.g(r3)
            d2.b r1 = new d2.b
            r14 = r1
            r15 = r7
            r20 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            r3 = 17
            if (r7 != r3) goto L_0x013e
            g3.a r2 = new g3.a
            d2.y r3 = r0.f6818a
            d2.x0 r4 = r0.f6819b
            r2.<init>(r3, r4, r1)
            goto L_0x019e
        L_0x013e:
            r3 = 6
            if (r7 != r3) goto L_0x0157
            g3.c r2 = new g3.c
            d2.y r3 = r0.f6818a
            d2.x0 r4 = r0.f6819b
            java.lang.String r26 = "audio/g711-alaw"
            r27 = -1
            r22 = r2
            r23 = r3
            r24 = r4
            r25 = r1
            r22.<init>(r23, r24, r25, r26, r27)
            goto L_0x019e
        L_0x0157:
            r3 = 7
            if (r7 != r3) goto L_0x0170
            g3.c r2 = new g3.c
            d2.y r3 = r0.f6818a
            d2.x0 r4 = r0.f6819b
            java.lang.String r26 = "audio/g711-mlaw"
            r27 = -1
            r22 = r2
            r23 = r3
            r24 = r4
            r25 = r1
            r22.<init>(r23, r24, r25, r26, r27)
            goto L_0x019e
        L_0x0170:
            if (r7 == r5) goto L_0x0183
            if (r7 == r11) goto L_0x017c
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r7 == r3) goto L_0x0183
            r27 = 0
            goto L_0x0189
        L_0x017c:
            r3 = 32
            if (r2 != r3) goto L_0x0181
            goto L_0x0187
        L_0x0181:
            r4 = 0
            goto L_0x0187
        L_0x0183:
            int r4 = j1.l0.t(r2)
        L_0x0187:
            r27 = r4
        L_0x0189:
            if (r27 == 0) goto L_0x01a3
            g3.c r2 = new g3.c
            d2.y r3 = r0.f6818a
            d2.x0 r4 = r0.f6819b
            java.lang.String r26 = "audio/raw"
            r22 = r2
            r23 = r3
            r24 = r4
            r25 = r1
            r22.<init>(r23, r24, r25, r26, r27)
        L_0x019e:
            r0.f6822e = r2
            r0.f6820c = r11
            return r6
        L_0x01a3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported WAV format type: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            g1.b1 r1 = g1.b1.c(r1)
            throw r1
        L_0x01b6:
            j1.b0 r2 = new j1.b0
            r2.<init>((int) r7)
            a2.k r3 = a2.k.a(r1, r2)
            int r4 = r3.f59a
            r5 = 1685272116(0x64733634, float:1.7945858E22)
            if (r4 == r5) goto L_0x01ca
            r29.f()
            goto L_0x01e0
        L_0x01ca:
            r1.n(r7)
            r2.G(r6)
            byte[] r4 = r2.f8414a
            r1.m(r4, r6, r7)
            long r9 = r2.j()
            long r2 = r3.f60b
            int r3 = (int) r2
            int r3 = r3 + r7
            r1.g(r3)
        L_0x01e0:
            r0.f6821d = r9
            r0.f6820c = r8
            return r6
        L_0x01e5:
            long r7 = r29.p()
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x01f1
            r2 = 1
            goto L_0x01f2
        L_0x01f1:
            r2 = 0
        L_0x01f2:
            j1.a.e(r2)
            int r2 = r0.f6823f
            if (r2 == r3) goto L_0x01ff
            r1.g(r2)
            r0.f6820c = r4
            goto L_0x0214
        L_0x01ff:
            boolean r2 = g3.e.a(r29)
            if (r2 == 0) goto L_0x0215
            long r2 = r29.l()
            long r7 = r29.p()
            long r2 = r2 - r7
            int r3 = (int) r2
            r1.g(r3)
            r0.f6820c = r5
        L_0x0214:
            return r6
        L_0x0215:
            java.lang.String r1 = "Unsupported or unrecognized wav file type."
            r2 = 0
            g1.b1 r1 = g1.b1.a(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.d.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f6818a = yVar;
        this.f6819b = yVar.d(0, 1);
        yVar.a();
    }

    public final boolean h(w wVar) {
        return e.a(wVar);
    }
}
