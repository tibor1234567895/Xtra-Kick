package ub;

import pb.u0;

public final class b implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f15467a;

    public b(boolean z10) {
        this.f15467a = z10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: pb.q1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v24, resolved type: pb.q1} */
    /* JADX WARNING: type inference failed for: r14v2, types: [java.lang.Throwable] */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c9, code lost:
        if (r0.isDuplex() == false) goto L_0x00ce;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x016f A[Catch:{ IOException -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0174 A[Catch:{ IOException -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01b4 A[Catch:{ IOException -> 0x01d3 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b5 A[Catch:{ IOException -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f9 A[SYNTHETIC, Splitter:B:81:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0131 A[Catch:{ IOException -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0133 A[Catch:{ IOException -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0136 A[Catch:{ IOException -> 0x01d5 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final pb.r1 a(ub.i r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "Connection"
            java.lang.String r2 = "close"
            java.lang.String r3 = "call"
            java.lang.String r4 = "HTTP "
            tb.g r5 = r0.f15475d
            xa.j.c(r5)
            ub.f r6 = r5.f14963d
            pb.g0 r7 = r5.f14961b
            tb.o r8 = r5.f14960a
            pb.j1 r9 = r0.f15476e
            pb.o1 r0 = r9.f12887d
            long r10 = java.lang.System.currentTimeMillis()
            r13 = 0
            r14 = 1
            r7.getClass()     // Catch:{ IOException -> 0x00de }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x00de }
            r6.b(r9)     // Catch:{ IOException -> 0x00de }
            java.lang.String r15 = r9.f12885b     // Catch:{ IOException -> 0x00da }
            boolean r15 = ub.h.a(r15)     // Catch:{ IOException -> 0x00da }
            if (r15 == 0) goto L_0x00bb
            if (r0 == 0) goto L_0x00bb
            java.lang.String r15 = "100-continue"
            java.lang.String r12 = "Expect"
            java.lang.String r12 = r9.b(r12)     // Catch:{ IOException -> 0x00da }
            boolean r12 = fb.w.g(r15, r12)     // Catch:{ IOException -> 0x00da }
            if (r12 == 0) goto L_0x0060
            r6.d()     // Catch:{ IOException -> 0x0054 }
            pb.q1 r12 = r5.f(r14)     // Catch:{ IOException -> 0x00da }
            r7.getClass()     // Catch:{ IOException -> 0x004f }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x004f }
            r15 = 0
            goto L_0x0062
        L_0x004f:
            r0 = move-exception
            r14 = r12
            r12 = 1
            goto L_0x00eb
        L_0x0054:
            r0 = move-exception
            r12 = r0
            r7.getClass()     // Catch:{ IOException -> 0x00da }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x00da }
            r5.g(r12)     // Catch:{ IOException -> 0x00da }
            throw r12     // Catch:{ IOException -> 0x00da }
        L_0x0060:
            r12 = 0
            r15 = 1
        L_0x0062:
            if (r12 != 0) goto L_0x009a
            boolean r16 = r0.isDuplex()     // Catch:{ IOException -> 0x0096 }
            if (r16 == 0) goto L_0x0087
            r6.d()     // Catch:{ IOException -> 0x007b }
            tb.e r16 = r5.b(r9, r14)     // Catch:{ IOException -> 0x0096 }
            dc.h0 r14 = hb.h0.n(r16)     // Catch:{ IOException -> 0x0096 }
            r0.writeTo(r14)     // Catch:{ IOException -> 0x0096 }
        L_0x0078:
            r16 = r12
            goto L_0x00b5
        L_0x007b:
            r0 = move-exception
            r14 = r0
            r7.getClass()     // Catch:{ IOException -> 0x0096 }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x0096 }
            r5.g(r14)     // Catch:{ IOException -> 0x0096 }
            throw r14     // Catch:{ IOException -> 0x0096 }
        L_0x0087:
            tb.e r14 = r5.b(r9, r13)     // Catch:{ IOException -> 0x0096 }
            dc.h0 r14 = hb.h0.n(r14)     // Catch:{ IOException -> 0x0096 }
            r0.writeTo(r14)     // Catch:{ IOException -> 0x0096 }
            r14.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x0078
        L_0x0096:
            r0 = move-exception
            r16 = r12
            goto L_0x00b9
        L_0x009a:
            r16 = r12
            r12 = 1
            r14 = 0
            r8.h(r5, r12, r13, r14)     // Catch:{ IOException -> 0x00b8 }
            tb.r r12 = r5.c()     // Catch:{ IOException -> 0x00b8 }
            wb.v r12 = r12.f15011k     // Catch:{ IOException -> 0x00b8 }
            if (r12 == 0) goto L_0x00ab
            r12 = 1
            goto L_0x00ac
        L_0x00ab:
            r12 = 0
        L_0x00ac:
            if (r12 != 0) goto L_0x00b5
            ub.e r12 = r6.e()     // Catch:{ IOException -> 0x00b8 }
            r12.g()     // Catch:{ IOException -> 0x00b8 }
        L_0x00b5:
            r12 = 1
            r14 = 0
            goto L_0x00c3
        L_0x00b8:
            r0 = move-exception
        L_0x00b9:
            r12 = 1
            goto L_0x00ee
        L_0x00bb:
            r12 = 1
            r14 = 0
            r8.h(r5, r12, r13, r14)     // Catch:{ IOException -> 0x00d8 }
            r16 = r14
            r15 = 1
        L_0x00c3:
            if (r0 == 0) goto L_0x00ce
            boolean r0 = r0.isDuplex()     // Catch:{ IOException -> 0x00cc }
            if (r0 != 0) goto L_0x00f7
            goto L_0x00ce
        L_0x00cc:
            r0 = move-exception
            goto L_0x00ee
        L_0x00ce:
            r6.c()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00f7
        L_0x00d2:
            r0 = move-exception
            r14 = r0
            r5.g(r14)     // Catch:{ IOException -> 0x00cc }
            throw r14     // Catch:{ IOException -> 0x00cc }
        L_0x00d8:
            r0 = move-exception
            goto L_0x00eb
        L_0x00da:
            r0 = move-exception
            r12 = 1
            r14 = 0
            goto L_0x00eb
        L_0x00de:
            r0 = move-exception
            r12 = 1
            r14 = 0
            r7.getClass()     // Catch:{ IOException -> 0x00d8 }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x00d8 }
            r5.g(r0)     // Catch:{ IOException -> 0x00d8 }
            throw r0     // Catch:{ IOException -> 0x00d8 }
        L_0x00eb:
            r16 = r14
            r15 = 1
        L_0x00ee:
            boolean r14 = r0 instanceof wb.a
            if (r14 != 0) goto L_0x01ea
            boolean r14 = r5.f14965f
            if (r14 == 0) goto L_0x01e7
            r14 = r0
        L_0x00f7:
            if (r16 != 0) goto L_0x010c
            pb.q1 r16 = r5.f(r13)     // Catch:{ IOException -> 0x01d9 }
            xa.j.c(r16)     // Catch:{ IOException -> 0x01d9 }
            if (r15 == 0) goto L_0x010c
            r7.getClass()     // Catch:{ IOException -> 0x01d9 }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x01d9 }
            r0 = r16
            r15 = 0
            goto L_0x010e
        L_0x010c:
            r0 = r16
        L_0x010e:
            r0.e(r9)     // Catch:{ IOException -> 0x01d9 }
            tb.r r12 = r5.c()     // Catch:{ IOException -> 0x01d9 }
            pb.m0 r12 = r12.f15006f     // Catch:{ IOException -> 0x01d9 }
            r0.f12938e = r12     // Catch:{ IOException -> 0x01d9 }
            r0.f12944k = r10     // Catch:{ IOException -> 0x01d9 }
            r18 = r14
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x01d5 }
            r0.f12945l = r13     // Catch:{ IOException -> 0x01d5 }
            pb.r1 r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            int r13 = r0.f12964k     // Catch:{ IOException -> 0x01d5 }
            r14 = 100
            if (r13 == r14) goto L_0x0133
            r14 = 103(0x67, float:1.44E-43)
            if (r13 == r14) goto L_0x0133
            r14 = 0
            goto L_0x0134
        L_0x0133:
            r14 = 1
        L_0x0134:
            if (r14 == 0) goto L_0x015f
            r12 = 0
            pb.q1 r0 = r5.f(r12)     // Catch:{ IOException -> 0x01d5 }
            xa.j.c(r0)     // Catch:{ IOException -> 0x01d5 }
            if (r15 == 0) goto L_0x0146
            r7.getClass()     // Catch:{ IOException -> 0x01d5 }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x01d5 }
        L_0x0146:
            r0.e(r9)     // Catch:{ IOException -> 0x01d5 }
            tb.r r9 = r5.c()     // Catch:{ IOException -> 0x01d5 }
            pb.m0 r9 = r9.f15006f     // Catch:{ IOException -> 0x01d5 }
            r0.f12938e = r9     // Catch:{ IOException -> 0x01d5 }
            r0.f12944k = r10     // Catch:{ IOException -> 0x01d5 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x01d5 }
            r0.f12945l = r9     // Catch:{ IOException -> 0x01d5 }
            pb.r1 r0 = r0.a()     // Catch:{ IOException -> 0x01d5 }
            int r13 = r0.f12964k     // Catch:{ IOException -> 0x01d5 }
        L_0x015f:
            r7.getClass()     // Catch:{ IOException -> 0x01d5 }
            xa.j.f(r3, r8)     // Catch:{ IOException -> 0x01d5 }
            r3 = r17
            boolean r7 = r3.f15467a     // Catch:{ IOException -> 0x01d3 }
            if (r7 == 0) goto L_0x0174
            r7 = 101(0x65, float:1.42E-43)
            if (r13 != r7) goto L_0x0174
            pb.r1 r0 = hb.h0.L1(r0)     // Catch:{ IOException -> 0x01d3 }
            goto L_0x0183
        L_0x0174:
            pb.q1 r7 = new pb.q1     // Catch:{ IOException -> 0x01d3 }
            r7.<init>(r0)     // Catch:{ IOException -> 0x01d3 }
            qb.e r0 = r5.e(r0)     // Catch:{ IOException -> 0x01d3 }
            r7.f12940g = r0     // Catch:{ IOException -> 0x01d3 }
            pb.r1 r0 = r7.a()     // Catch:{ IOException -> 0x01d3 }
        L_0x0183:
            pb.j1 r5 = r0.f12961h     // Catch:{ IOException -> 0x01d3 }
            pb.u1 r7 = r0.f12967n
            java.lang.String r5 = r5.b(r1)     // Catch:{ IOException -> 0x01d3 }
            boolean r5 = fb.w.g(r2, r5)     // Catch:{ IOException -> 0x01d3 }
            if (r5 != 0) goto L_0x019b
            java.lang.String r1 = pb.r1.e(r0, r1)     // Catch:{ IOException -> 0x01d3 }
            boolean r1 = fb.w.g(r2, r1)     // Catch:{ IOException -> 0x01d3 }
            if (r1 == 0) goto L_0x01a2
        L_0x019b:
            ub.e r1 = r6.e()     // Catch:{ IOException -> 0x01d3 }
            r1.g()     // Catch:{ IOException -> 0x01d3 }
        L_0x01a2:
            r1 = 204(0xcc, float:2.86E-43)
            if (r13 == r1) goto L_0x01aa
            r1 = 205(0xcd, float:2.87E-43)
            if (r13 != r1) goto L_0x01b4
        L_0x01aa:
            long r1 = r7.contentLength()     // Catch:{ IOException -> 0x01d3 }
            r5 = 0
            int r8 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x01b5
        L_0x01b4:
            return r0
        L_0x01b5:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x01d3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01d3 }
            r1.<init>(r4)     // Catch:{ IOException -> 0x01d3 }
            r1.append(r13)     // Catch:{ IOException -> 0x01d3 }
            java.lang.String r2 = " had non-zero Content-Length: "
            r1.append(r2)     // Catch:{ IOException -> 0x01d3 }
            long r4 = r7.contentLength()     // Catch:{ IOException -> 0x01d3 }
            r1.append(r4)     // Catch:{ IOException -> 0x01d3 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x01d3 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x01d3 }
            throw r0     // Catch:{ IOException -> 0x01d3 }
        L_0x01d3:
            r0 = move-exception
            goto L_0x01de
        L_0x01d5:
            r0 = move-exception
            r3 = r17
            goto L_0x01de
        L_0x01d9:
            r0 = move-exception
            r3 = r17
            r18 = r14
        L_0x01de:
            if (r18 == 0) goto L_0x01e6
            r14 = r18
            la.a.a(r14, r0)
            throw r14
        L_0x01e6:
            throw r0
        L_0x01e7:
            r3 = r17
            throw r0
        L_0x01ea:
            r3 = r17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.b.a(ub.i):pb.r1");
    }
}
