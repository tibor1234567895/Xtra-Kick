package ub;

import dc.m;
import dc.n;
import fb.w;
import pb.r1;
import qb.h;
import xa.j;

public abstract class g {
    static {
        n.f4802k.getClass();
        m.b("\"\\");
        m.b("\t ,=");
    }

    public static final boolean a(r1 r1Var) {
        if (j.a(r1Var.f12961h.f12885b, "HEAD")) {
            return false;
        }
        int i10 = r1Var.f12964k;
        if (((i10 >= 100 && i10 < 200) || i10 == 204 || i10 == 304) && h.f(r1Var) == -1 && !w.g("chunked", r1.e(r1Var, "Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01ef, code lost:
        if (qb.b.f13476a.b(r0) == false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f4, code lost:
        if (r18 == false) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x020c, code lost:
        if (okhttp3.internal.publicsuffix.PublicSuffixDatabase.f12396i.a(r14) == null) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x020e, code lost:
        r5 = 0;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0254 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(pb.z r37, pb.t0 r38, pb.p0 r39) {
        /*
            r1 = r37
            r2 = r38
            r0 = r39
            java.lang.String r3 = "<this>"
            xa.j.f(r3, r1)
            java.lang.String r3 = "url"
            xa.j.f(r3, r2)
            java.lang.String r3 = "headers"
            xa.j.f(r3, r0)
            pb.x r3 = pb.z.f13039a
            if (r1 != r3) goto L_0x001a
            return
        L_0x001a:
            pb.v r3 = pb.w.f13009j
            r3.getClass()
            java.lang.String[] r3 = r0.f12931h
            int r3 = r3.length
            r4 = 2
            int r3 = r3 / r4
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x0027:
            if (r7 >= r3) goto L_0x0046
            java.lang.String r9 = r0.c(r7)
            java.lang.String r10 = "Set-Cookie"
            boolean r9 = fb.w.g(r10, r9)
            if (r9 == 0) goto L_0x0043
            if (r8 != 0) goto L_0x003c
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>(r4)
        L_0x003c:
            java.lang.String r9 = r0.f(r7)
            r8.add(r9)
        L_0x0043:
            int r7 = r7 + 1
            goto L_0x0027
        L_0x0046:
            if (r8 == 0) goto L_0x004d
            java.util.List r0 = ma.z.J(r8)
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            if (r0 != 0) goto L_0x0052
            ma.b0 r0 = ma.b0.f10801h
        L_0x0052:
            r3 = r0
            int r7 = r3.size()
            r8 = 0
            r9 = 0
        L_0x0059:
            if (r8 >= r7) goto L_0x025b
            java.lang.Object r0 = r3.get(r8)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r0 = "setCookie"
            xa.j.f(r0, r10)
            long r11 = java.lang.System.currentTimeMillis()
            r13 = 59
            r14 = 6
            int r0 = qb.f.e(r10, r13, r5, r5, r14)
            r15 = 61
            int r6 = qb.f.e(r10, r15, r5, r0, r4)
            if (r6 != r0) goto L_0x007e
        L_0x007a:
            r36 = r3
            goto L_0x0245
        L_0x007e:
            java.lang.String r17 = qb.f.o(r5, r6, r10)
            int r16 = r17.length()
            r18 = 1
            if (r16 != 0) goto L_0x008d
            r16 = 1
            goto L_0x008f
        L_0x008d:
            r16 = 0
        L_0x008f:
            if (r16 != 0) goto L_0x007a
            int r4 = qb.f.g(r17)
            r14 = -1
            if (r4 == r14) goto L_0x0099
            goto L_0x007a
        L_0x0099:
            int r6 = r6 + 1
            java.lang.String r4 = qb.f.o(r6, r0, r10)
            int r6 = qb.f.g(r4)
            if (r6 == r14) goto L_0x00a6
            goto L_0x007a
        L_0x00a6:
            int r0 = r0 + 1
            int r6 = r10.length()
            r19 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r21 = -1
            r29 = r19
            r27 = r21
            r14 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 1
            r31 = 0
        L_0x00c2:
            r32 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r34 = -9223372036854775808
            if (r0 >= r6) goto L_0x0195
            int r5 = qb.f.d(r10, r13, r0, r6)
            int r13 = qb.f.d(r10, r15, r0, r5)
            java.lang.String r0 = qb.f.o(r0, r13, r10)
            if (r13 >= r5) goto L_0x00e0
            int r13 = r13 + 1
            java.lang.String r13 = qb.f.o(r13, r5, r10)
            goto L_0x00e2
        L_0x00e0:
            java.lang.String r13 = ""
        L_0x00e2:
            java.lang.String r15 = "expires"
            boolean r15 = fb.w.g(r0, r15)
            if (r15 == 0) goto L_0x00f9
            int r0 = r13.length()     // Catch:{ IllegalArgumentException -> 0x00f5 }
            long r29 = pb.v.b(r0, r13)     // Catch:{ IllegalArgumentException -> 0x00f5 }
            r36 = r3
            goto L_0x0131
        L_0x00f5:
            r36 = r3
            goto L_0x018a
        L_0x00f9:
            java.lang.String r15 = "max-age"
            boolean r15 = fb.w.g(r0, r15)
            if (r15 == 0) goto L_0x0135
            long r27 = java.lang.Long.parseLong(r13)     // Catch:{ NumberFormatException -> 0x0113 }
            r32 = 0
            int r0 = (r27 > r32 ? 1 : (r27 == r32 ? 0 : -1))
            if (r0 > 0) goto L_0x010c
            goto L_0x010e
        L_0x010c:
            r34 = r27
        L_0x010e:
            r36 = r3
            r27 = r34
            goto L_0x0131
        L_0x0113:
            r0 = move-exception
            r15 = r0
            fb.l r0 = new fb.l     // Catch:{  }
            r36 = r3
            java.lang.String r3 = "-?\\d+"
            r0.<init>(r3)     // Catch:{ NumberFormatException -> 0x018a }
            boolean r0 = r0.b(r13)     // Catch:{ NumberFormatException -> 0x018a }
            if (r0 == 0) goto L_0x0134
            java.lang.String r0 = "-"
            r3 = 0
            boolean r0 = fb.w.m(r13, r0, r3)     // Catch:{ NumberFormatException -> 0x018a }
            if (r0 == 0) goto L_0x012f
            r32 = r34
        L_0x012f:
            r27 = r32
        L_0x0131:
            r25 = 1
            goto L_0x018a
        L_0x0134:
            throw r15     // Catch:{ NumberFormatException -> 0x018a }
        L_0x0135:
            r36 = r3
            java.lang.String r3 = "domain"
            boolean r3 = fb.w.g(r0, r3)
            if (r3 == 0) goto L_0x016a
            java.lang.String r0 = "."
            r3 = 0
            boolean r15 = fb.w.f(r13, r0, r3)     // Catch:{  }
            r3 = r15 ^ 1
            if (r3 == 0) goto L_0x015e
            java.lang.String r0 = fb.y.B(r0, r13)     // Catch:{  }
            java.lang.String r0 = hb.h0.R1(r0)     // Catch:{  }
            if (r0 == 0) goto L_0x0158
            r14 = r0
            r26 = 0
            goto L_0x018a
        L_0x0158:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{  }
            r0.<init>()     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x015e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{  }
            java.lang.String r3 = "Failed requirement."
            java.lang.String r3 = r3.toString()     // Catch:{  }
            r0.<init>(r3)     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x016a:
            java.lang.String r3 = "path"
            boolean r3 = fb.w.g(r0, r3)
            if (r3 == 0) goto L_0x0175
            r31 = r13
            goto L_0x018a
        L_0x0175:
            java.lang.String r3 = "secure"
            boolean r3 = fb.w.g(r0, r3)
            if (r3 == 0) goto L_0x0180
            r23 = 1
            goto L_0x018a
        L_0x0180:
            java.lang.String r3 = "httponly"
            boolean r0 = fb.w.g(r0, r3)
            if (r0 == 0) goto L_0x018a
            r24 = 1
        L_0x018a:
            int r0 = r5 + 1
            r3 = r36
            r5 = 0
            r13 = 59
            r15 = 61
            goto L_0x00c2
        L_0x0195:
            r36 = r3
            int r0 = (r27 > r34 ? 1 : (r27 == r34 ? 0 : -1))
            if (r0 != 0) goto L_0x019e
            r19 = r34
            goto L_0x01c0
        L_0x019e:
            int r0 = (r27 > r21 ? 1 : (r27 == r21 ? 0 : -1))
            if (r0 == 0) goto L_0x01be
            r5 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r27 > r5 ? 1 : (r27 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x01b0
            r0 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r0
            long r32 = r27 * r5
        L_0x01b0:
            long r32 = r11 + r32
            int r0 = (r32 > r11 ? 1 : (r32 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x01c0
            int r0 = (r32 > r19 ? 1 : (r32 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x01bb
            goto L_0x01c0
        L_0x01bb:
            r19 = r32
            goto L_0x01c0
        L_0x01be:
            r19 = r29
        L_0x01c0:
            java.lang.String r0 = r2.f12992d
            if (r14 != 0) goto L_0x01c6
            r14 = r0
            goto L_0x01f7
        L_0x01c6:
            boolean r3 = xa.j.a(r0, r14)
            if (r3 == 0) goto L_0x01cd
            goto L_0x01f4
        L_0x01cd:
            r3 = 0
            boolean r5 = fb.w.f(r0, r14, r3)
            if (r5 == 0) goto L_0x01f2
            int r3 = r0.length()
            int r5 = r14.length()
            int r3 = r3 - r5
            int r3 = r3 + -1
            char r3 = r0.charAt(r3)
            r5 = 46
            if (r3 != r5) goto L_0x01f2
            fb.l r3 = qb.b.f13476a
            fb.l r3 = qb.b.f13476a
            boolean r3 = r3.b(r0)
            if (r3 != 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r18 = 0
        L_0x01f4:
            if (r18 != 0) goto L_0x01f7
            goto L_0x020e
        L_0x01f7:
            int r0 = r0.length()
            int r3 = r14.length()
            if (r0 == r3) goto L_0x0210
            ac.a r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.f12392e
            r0.getClass()
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.f12396i
            java.lang.String r0 = r0.a(r14)
            if (r0 != 0) goto L_0x0210
        L_0x020e:
            r5 = 0
            goto L_0x0245
        L_0x0210:
            java.lang.String r0 = "/"
            r3 = r31
            r5 = 0
            if (r3 == 0) goto L_0x0221
            boolean r6 = fb.w.m(r3, r0, r5)
            if (r6 != 0) goto L_0x021e
            goto L_0x0221
        L_0x021e:
            r22 = r3
            goto L_0x0239
        L_0x0221:
            java.lang.String r3 = r38.b()
            r6 = 47
            r10 = 6
            int r6 = fb.y.w(r3, r6, r5, r10)
            if (r6 == 0) goto L_0x0237
            java.lang.String r0 = r3.substring(r5, r6)
            java.lang.String r3 = "this as java.lang.String…ing(startIndex, endIndex)"
            xa.j.e(r3, r0)
        L_0x0237:
            r22 = r0
        L_0x0239:
            pb.w r0 = new pb.w
            r16 = r0
            r18 = r4
            r21 = r14
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26)
            goto L_0x0246
        L_0x0245:
            r0 = 0
        L_0x0246:
            if (r0 != 0) goto L_0x0249
            goto L_0x0254
        L_0x0249:
            if (r9 != 0) goto L_0x0251
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r9 = r3
        L_0x0251:
            r9.add(r0)
        L_0x0254:
            int r8 = r8 + 1
            r3 = r36
            r4 = 2
            goto L_0x0059
        L_0x025b:
            if (r9 == 0) goto L_0x0267
            java.util.List r0 = java.util.Collections.unmodifiableList(r9)
            java.lang.String r3 = "{\n        Collections.un…ableList(cookies)\n      }"
            xa.j.e(r3, r0)
            goto L_0x0269
        L_0x0267:
            ma.b0 r0 = ma.b0.f10801h
        L_0x0269:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0270
            return
        L_0x0270:
            r1.a(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.g.b(pb.z, pb.t0, pb.p0):void");
    }
}
