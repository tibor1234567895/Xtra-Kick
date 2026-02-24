package pb;

public final class f {
    private f() {
    }

    public /* synthetic */ f(int i10) {
        this();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static pb.g a(pb.p0 r25) {
        /*
            r0 = r25
            java.lang.String r1 = "headers"
            xa.j.f(r1, r0)
            java.lang.String[] r1 = r0.f12931h
            int r1 = r1.length
            int r1 = r1 / 2
            r6 = 0
            r7 = 1
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = -1
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x0021:
            if (r6 >= r1) goto L_0x01b3
            java.lang.String r9 = r0.c(r6)
            java.lang.String r4 = r0.f(r6)
            java.lang.String r5 = "Cache-Control"
            boolean r5 = fb.w.g(r9, r5)
            if (r5 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r8 = r4
            goto L_0x0041
        L_0x0038:
            java.lang.String r5 = "Pragma"
            boolean r5 = fb.w.g(r9, r5)
            if (r5 == 0) goto L_0x01a8
        L_0x0040:
            r7 = 0
        L_0x0041:
            r5 = 0
        L_0x0042:
            int r9 = r4.length()
            if (r5 >= r9) goto L_0x01a8
            int r9 = r4.length()
            r3 = r5
        L_0x004d:
            if (r3 >= r9) goto L_0x0061
            char r2 = r4.charAt(r3)
            java.lang.String r0 = "=,;"
            boolean r0 = fb.y.o(r0, r2)
            if (r0 == 0) goto L_0x005c
            goto L_0x0065
        L_0x005c:
            int r3 = r3 + 1
            r0 = r25
            goto L_0x004d
        L_0x0061:
            int r3 = r4.length()
        L_0x0065:
            java.lang.String r0 = r4.substring(r5, r3)
            java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
            xa.j.e(r2, r0)
            java.lang.CharSequence r0 = fb.y.R(r0)
            java.lang.String r0 = r0.toString()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0105
            char r5 = r4.charAt(r3)
            r9 = 44
            if (r5 == r9) goto L_0x0105
            char r5 = r4.charAt(r3)
            r9 = 59
            if (r5 != r9) goto L_0x008e
            goto L_0x0105
        L_0x008e:
            int r3 = r3 + 1
            byte[] r5 = qb.f.f13487a
            int r5 = r4.length()
        L_0x0096:
            if (r3 >= r5) goto L_0x00ac
            char r9 = r4.charAt(r3)
            r23 = r1
            r1 = 32
            if (r9 == r1) goto L_0x00a7
            r1 = 9
            if (r9 == r1) goto L_0x00a7
            goto L_0x00b2
        L_0x00a7:
            int r3 = r3 + 1
            r1 = r23
            goto L_0x0096
        L_0x00ac:
            r23 = r1
            int r3 = r4.length()
        L_0x00b2:
            int r1 = r4.length()
            if (r3 >= r1) goto L_0x00d3
            char r1 = r4.charAt(r3)
            r5 = 34
            if (r1 != r5) goto L_0x00d3
            int r3 = r3 + 1
            r1 = 4
            r9 = 0
            int r1 = fb.y.t(r4, r5, r3, r9, r1)
            java.lang.String r3 = r4.substring(r3, r1)
            xa.j.e(r2, r3)
            r5 = 1
            int r1 = r1 + r5
            r5 = r1
            goto L_0x010b
        L_0x00d3:
            r5 = 1
            r9 = 0
            int r1 = r4.length()
            r5 = r3
        L_0x00da:
            if (r5 >= r1) goto L_0x00f1
            char r9 = r4.charAt(r5)
            r24 = r1
            java.lang.String r1 = ",;"
            boolean r1 = fb.y.o(r1, r9)
            if (r1 == 0) goto L_0x00eb
            goto L_0x00f5
        L_0x00eb:
            int r5 = r5 + 1
            r1 = r24
            r9 = 0
            goto L_0x00da
        L_0x00f1:
            int r5 = r4.length()
        L_0x00f5:
            java.lang.String r1 = r4.substring(r3, r5)
            xa.j.e(r2, r1)
            java.lang.CharSequence r1 = fb.y.R(r1)
            java.lang.String r3 = r1.toString()
            goto L_0x010b
        L_0x0105:
            r23 = r1
            int r3 = r3 + 1
            r5 = r3
            r3 = 0
        L_0x010b:
            java.lang.String r1 = "no-cache"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x0117
            r1 = -1
            r10 = 1
            goto L_0x01a2
        L_0x0117:
            java.lang.String r1 = "no-store"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x0123
            r1 = -1
            r11 = 1
            goto L_0x01a2
        L_0x0123:
            java.lang.String r1 = "max-age"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x0132
            r1 = -1
            int r12 = qb.f.n(r1, r3)
            goto L_0x01a2
        L_0x0132:
            r1 = -1
            java.lang.String r2 = "s-maxage"
            boolean r2 = fb.w.g(r2, r0)
            if (r2 == 0) goto L_0x0140
            int r13 = qb.f.n(r1, r3)
            goto L_0x01a2
        L_0x0140:
            java.lang.String r1 = "private"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x014b
            r1 = -1
            r14 = 1
            goto L_0x01a2
        L_0x014b:
            java.lang.String r1 = "public"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x0156
            r1 = -1
            r15 = 1
            goto L_0x01a2
        L_0x0156:
            java.lang.String r1 = "must-revalidate"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x0162
            r1 = -1
            r16 = 1
            goto L_0x01a2
        L_0x0162:
            java.lang.String r1 = "max-stale"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x0173
            r0 = 2147483647(0x7fffffff, float:NaN)
            int r17 = qb.f.n(r0, r3)
            r1 = -1
            goto L_0x01a2
        L_0x0173:
            java.lang.String r1 = "min-fresh"
            boolean r1 = fb.w.g(r1, r0)
            if (r1 == 0) goto L_0x0181
            r1 = -1
            int r18 = qb.f.n(r1, r3)
            goto L_0x01a2
        L_0x0181:
            r1 = -1
            java.lang.String r2 = "only-if-cached"
            boolean r2 = fb.w.g(r2, r0)
            if (r2 == 0) goto L_0x018d
            r19 = 1
            goto L_0x01a2
        L_0x018d:
            java.lang.String r2 = "no-transform"
            boolean r2 = fb.w.g(r2, r0)
            if (r2 == 0) goto L_0x0198
            r20 = 1
            goto L_0x01a2
        L_0x0198:
            java.lang.String r2 = "immutable"
            boolean r0 = fb.w.g(r2, r0)
            if (r0 == 0) goto L_0x01a2
            r21 = 1
        L_0x01a2:
            r0 = r25
            r1 = r23
            goto L_0x0042
        L_0x01a8:
            r23 = r1
            r1 = -1
            int r6 = r6 + 1
            r0 = r25
            r1 = r23
            goto L_0x0021
        L_0x01b3:
            if (r7 != 0) goto L_0x01b8
            r22 = 0
            goto L_0x01ba
        L_0x01b8:
            r22 = r8
        L_0x01ba:
            pb.g r0 = new pb.g
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.f.a(pb.p0):pb.g");
    }
}
