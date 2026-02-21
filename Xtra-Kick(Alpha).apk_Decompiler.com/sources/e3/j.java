package e3;

import j1.b0;
import w2.c;

public final class j extends c {

    /* renamed from: m  reason: collision with root package name */
    public final b0 f5035m = new b0();

    /* renamed from: n  reason: collision with root package name */
    public final b f5036n = new b();

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fd, code lost:
        if (")".equals(e3.b.b(r6, r11)) == false) goto L_0x00ff;
     */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0375 A[EDGE_INSN: B:231:0x0375->B:191:0x0375 ?: BREAK  
    EDGE_INSN: B:232:0x0375->B:191:0x0375 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final w2.d f(byte[] r21, int r22, boolean r23) {
        /*
            r20 = this;
            r1 = r20
            j1.b0 r0 = r1.f5035m
            r2 = r21
            r3 = r22
            r0.E(r3, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            e3.k.d(r0)     // Catch:{ b1 -> 0x03cf }
        L_0x0013:
            java.lang.String r3 = r0.g()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x001e
            goto L_0x0013
        L_0x001e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x0023:
            r4 = -1
            r5 = 0
            r6 = -1
            r7 = 0
        L_0x0027:
            r9 = 2
            r10 = 1
            if (r6 != r4) goto L_0x004b
            int r7 = r0.f8415b
            java.lang.String r6 = r0.g()
            if (r6 != 0) goto L_0x0035
            r6 = 0
            goto L_0x0027
        L_0x0035:
            java.lang.String r11 = "STYLE"
            boolean r11 = r11.equals(r6)
            if (r11 == 0) goto L_0x003f
            r6 = 2
            goto L_0x0027
        L_0x003f:
            java.lang.String r9 = "NOTE"
            boolean r6 = r6.startsWith(r9)
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x0027
        L_0x0049:
            r6 = 3
            goto L_0x0027
        L_0x004b:
            r0.G(r7)
            if (r6 == 0) goto L_0x03c9
            if (r6 != r10) goto L_0x005d
        L_0x0052:
            java.lang.String r4 = r0.g()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0023
            goto L_0x0052
        L_0x005d:
            if (r6 != r9) goto L_0x0385
            boolean r6 = r3.isEmpty()
            if (r6 == 0) goto L_0x037d
            r0.g()
            e3.b r6 = r1.f5036n
            java.lang.StringBuilder r11 = r6.f4990b
            r11.setLength(r5)
            int r12 = r0.f8415b
        L_0x0071:
            java.lang.String r13 = r0.g()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0379
            byte[] r13 = r0.f8414a
            int r14 = r0.f8415b
            j1.b0 r6 = r6.f4989a
            r6.E(r14, r13)
            r6.G(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L_0x008c:
            e3.b.c(r6)
            int r13 = r6.f8416c
            int r14 = r6.f8415b
            int r13 = r13 - r14
            java.lang.String r14 = "{"
            java.lang.String r15 = ""
            r7 = 5
            if (r13 >= r7) goto L_0x009c
            goto L_0x00ff
        L_0x009c:
            java.lang.String r7 = r6.s(r7)
            java.lang.String r13 = "::cue"
            boolean r7 = r13.equals(r7)
            if (r7 != 0) goto L_0x00a9
            goto L_0x00ff
        L_0x00a9:
            int r7 = r6.f8415b
            java.lang.String r13 = e3.b.b(r6, r11)
            if (r13 != 0) goto L_0x00b2
            goto L_0x00ff
        L_0x00b2:
            boolean r16 = r14.equals(r13)
            if (r16 == 0) goto L_0x00bd
            r6.G(r7)
            r7 = r15
            goto L_0x0100
        L_0x00bd:
            java.lang.String r7 = "("
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x00f2
            int r7 = r6.f8415b
            int r13 = r6.f8416c
            r16 = 0
        L_0x00cb:
            if (r7 >= r13) goto L_0x00e4
            if (r16 != 0) goto L_0x00e4
            byte[] r8 = r6.f8414a
            int r16 = r7 + 1
            byte r7 = r8[r7]
            char r7 = (char) r7
            r8 = 41
            if (r7 != r8) goto L_0x00dc
            r7 = 1
            goto L_0x00dd
        L_0x00dc:
            r7 = 0
        L_0x00dd:
            r19 = r16
            r16 = r7
            r7 = r19
            goto L_0x00cb
        L_0x00e4:
            int r7 = r7 + -1
            int r8 = r6.f8415b
            int r7 = r7 - r8
            java.lang.String r7 = r6.s(r7)
            java.lang.String r7 = r7.trim()
            goto L_0x00f3
        L_0x00f2:
            r7 = 0
        L_0x00f3:
            java.lang.String r8 = e3.b.b(r6, r11)
            java.lang.String r13 = ")"
            boolean r8 = r13.equals(r8)
            if (r8 != 0) goto L_0x0100
        L_0x00ff:
            r7 = 0
        L_0x0100:
            if (r7 == 0) goto L_0x0375
            java.lang.String r8 = e3.b.b(r6, r11)
            boolean r8 = r14.equals(r8)
            if (r8 != 0) goto L_0x010e
            goto L_0x0375
        L_0x010e:
            e3.c r8 = new e3.c
            r8.<init>()
            boolean r13 = r15.equals(r7)
            if (r13 == 0) goto L_0x011a
            goto L_0x0180
        L_0x011a:
            r13 = 91
            int r13 = r7.indexOf(r13)
            if (r13 == r4) goto L_0x013f
            java.util.regex.Pattern r14 = e3.b.f4987c
            java.lang.String r9 = r7.substring(r13)
            java.util.regex.Matcher r9 = r14.matcher(r9)
            boolean r14 = r9.matches()
            if (r14 == 0) goto L_0x013b
            java.lang.String r9 = r9.group(r10)
            r9.getClass()
            r8.f4994d = r9
        L_0x013b:
            java.lang.String r7 = r7.substring(r5, r13)
        L_0x013f:
            int r9 = j1.l0.f8453a
            java.lang.String r9 = "\\."
            java.lang.String[] r7 = r7.split(r9, r4)
            r9 = r7[r5]
            r13 = 35
            int r13 = r9.indexOf(r13)
            if (r13 == r4) goto L_0x0160
            java.lang.String r14 = r9.substring(r5, r13)
            r8.f4992b = r14
            int r13 = r13 + 1
            java.lang.String r9 = r9.substring(r13)
            r8.f4991a = r9
            goto L_0x0162
        L_0x0160:
            r8.f4992b = r9
        L_0x0162:
            int r9 = r7.length
            if (r9 <= r10) goto L_0x0180
            int r9 = r7.length
            int r13 = r7.length
            if (r9 > r13) goto L_0x016b
            r13 = 1
            goto L_0x016c
        L_0x016b:
            r13 = 0
        L_0x016c:
            j1.a.b(r13)
            java.lang.Object[] r7 = java.util.Arrays.copyOfRange(r7, r10, r9)
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.HashSet r9 = new java.util.HashSet
            java.util.List r7 = java.util.Arrays.asList(r7)
            r9.<init>(r7)
            r8.f4993c = r9
        L_0x0180:
            r7 = 0
            r9 = 0
        L_0x0182:
            java.lang.String r13 = "}"
            if (r7 != 0) goto L_0x0362
            int r7 = r6.f8415b
            java.lang.String r9 = e3.b.b(r6, r11)
            if (r9 == 0) goto L_0x0197
            boolean r14 = r13.equals(r9)
            if (r14 == 0) goto L_0x0195
            goto L_0x0197
        L_0x0195:
            r14 = 0
            goto L_0x0198
        L_0x0197:
            r14 = 1
        L_0x0198:
            if (r14 != 0) goto L_0x0358
            r6.G(r7)
            e3.b.c(r6)
            java.lang.String r7 = e3.b.a(r6, r11)
            boolean r16 = r15.equals(r7)
            if (r16 == 0) goto L_0x01ac
            goto L_0x0358
        L_0x01ac:
            java.lang.String r4 = ":"
            java.lang.String r5 = e3.b.b(r6, r11)
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x01ba
            goto L_0x0358
        L_0x01ba:
            e3.b.c(r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 0
        L_0x01c3:
            java.lang.String r10 = ";"
            if (r5 != 0) goto L_0x01ef
            int r1 = r6.f8415b
            r17 = r5
            java.lang.String r5 = e3.b.b(r6, r11)
            if (r5 != 0) goto L_0x01d3
            r1 = 0
            goto L_0x01f3
        L_0x01d3:
            boolean r18 = r13.equals(r5)
            if (r18 != 0) goto L_0x01e8
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x01e0
            goto L_0x01e8
        L_0x01e0:
            r4.append(r5)
            r1 = r20
            r5 = r17
            goto L_0x01c3
        L_0x01e8:
            r6.G(r1)
            r5 = 1
            r1 = r20
            goto L_0x01c3
        L_0x01ef:
            java.lang.String r1 = r4.toString()
        L_0x01f3:
            if (r1 == 0) goto L_0x0358
            boolean r4 = r15.equals(r1)
            if (r4 == 0) goto L_0x01fd
            goto L_0x0358
        L_0x01fd:
            int r4 = r6.f8415b
            java.lang.String r5 = e3.b.b(r6, r11)
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x020a
            goto L_0x0213
        L_0x020a:
            boolean r5 = r13.equals(r5)
            if (r5 == 0) goto L_0x0358
            r6.G(r4)
        L_0x0213:
            java.lang.String r4 = "color"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0226
            r4 = 1
            int r1 = j1.f.a(r1, r4)
            r8.f4996f = r1
            r8.f4997g = r4
            goto L_0x0358
        L_0x0226:
            r4 = 1
            java.lang.String r5 = "background-color"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0239
            int r1 = j1.f.a(r1, r4)
            r8.f4998h = r1
            r8.f4999i = r4
            goto L_0x0358
        L_0x0239:
            java.lang.String r5 = "ruby-position"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x025a
            java.lang.String r5 = "over"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x024d
            r8.f5006p = r4
            goto L_0x0358
        L_0x024d:
            java.lang.String r4 = "under"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0358
            r1 = 2
            r8.f5006p = r1
            goto L_0x0358
        L_0x025a:
            java.lang.String r4 = "text-combine-upright"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x027a
            java.lang.String r4 = "all"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0275
            java.lang.String r4 = "digits"
            boolean r1 = r1.startsWith(r4)
            if (r1 == 0) goto L_0x0273
            goto L_0x0275
        L_0x0273:
            r1 = 0
            goto L_0x0276
        L_0x0275:
            r1 = 1
        L_0x0276:
            r8.f5007q = r1
            goto L_0x0358
        L_0x027a:
            java.lang.String r4 = "text-decoration"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x028f
            java.lang.String r4 = "underline"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0358
            r1 = 1
            r8.f5001k = r1
            goto L_0x0358
        L_0x028f:
            java.lang.String r4 = "font-family"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x029f
            java.lang.String r1 = c9.b.a(r1)
            r8.f4995e = r1
            goto L_0x0358
        L_0x029f:
            java.lang.String r4 = "font-weight"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x02b4
            java.lang.String r4 = "bold"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0358
            r4 = 1
            r8.f5002l = r4
            goto L_0x0358
        L_0x02b4:
            r4 = 1
            java.lang.String r5 = "font-style"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x02c9
            java.lang.String r5 = "italic"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0358
            r8.f5003m = r4
            goto L_0x0358
        L_0x02c9:
            java.lang.String r4 = "font-size"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0358
            java.lang.String r4 = c9.b.a(r1)
            java.util.regex.Pattern r5 = e3.b.f4988d
            java.util.regex.Matcher r4 = r5.matcher(r4)
            boolean r5 = r4.matches()
            if (r5 != 0) goto L_0x02fa
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Invalid font-size: '"
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = "'."
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.String r4 = "WebvttCssParser"
            j1.v.g(r4, r1)
            goto L_0x0358
        L_0x02fa:
            r1 = 2
            java.lang.String r5 = r4.group(r1)
            r5.getClass()
            int r1 = r5.hashCode()
            r7 = 37
            if (r1 == r7) goto L_0x0329
            r7 = 3240(0xca8, float:4.54E-42)
            if (r1 == r7) goto L_0x031e
            r7 = 3592(0xe08, float:5.033E-42)
            if (r1 == r7) goto L_0x0313
            goto L_0x0331
        L_0x0313:
            java.lang.String r1 = "px"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x031c
            goto L_0x0331
        L_0x031c:
            r1 = 2
            goto L_0x0334
        L_0x031e:
            java.lang.String r1 = "em"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0327
            goto L_0x0331
        L_0x0327:
            r1 = 1
            goto L_0x0334
        L_0x0329:
            java.lang.String r1 = "%"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0333
        L_0x0331:
            r1 = -1
            goto L_0x0334
        L_0x0333:
            r1 = 0
        L_0x0334:
            r5 = 1
            r7 = 2
            if (r1 == 0) goto L_0x0347
            if (r1 == r5) goto L_0x0345
            if (r1 != r7) goto L_0x033f
            r8.f5004n = r5
            goto L_0x034a
        L_0x033f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0345:
            r1 = 2
            goto L_0x0348
        L_0x0347:
            r1 = 3
        L_0x0348:
            r8.f5004n = r1
        L_0x034a:
            java.lang.String r1 = r4.group(r5)
            r1.getClass()
            float r1 = java.lang.Float.parseFloat(r1)
            r8.f5005o = r1
            goto L_0x035a
        L_0x0358:
            r5 = 1
            r7 = 2
        L_0x035a:
            r1 = r20
            r7 = r14
            r4 = -1
            r5 = 0
            r10 = 1
            goto L_0x0182
        L_0x0362:
            r5 = 1
            r7 = 2
            boolean r1 = r13.equals(r9)
            if (r1 == 0) goto L_0x036d
            r12.add(r8)
        L_0x036d:
            r1 = r20
            r4 = -1
            r5 = 0
            r9 = 2
            r10 = 1
            goto L_0x008c
        L_0x0375:
            r2.addAll(r12)
            goto L_0x03c5
        L_0x0379:
            r1 = r20
            goto L_0x0071
        L_0x037d:
            w2.f r0 = new w2.f
            java.lang.String r1 = "A style block was found after the first cue."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0385:
            r1 = 3
            if (r6 != r1) goto L_0x03c5
            java.util.regex.Pattern r1 = e3.i.f5031a
            java.lang.String r1 = r0.g()
            if (r1 != 0) goto L_0x0392
            r7 = 0
            goto L_0x03c0
        L_0x0392:
            java.util.regex.Pattern r4 = e3.i.f5031a
            java.util.regex.Matcher r5 = r4.matcher(r1)
            boolean r6 = r5.matches()
            if (r6 == 0) goto L_0x03a4
            r6 = 0
            e3.d r7 = e3.i.d(r6, r5, r0, r2)
            goto L_0x03c0
        L_0x03a4:
            r6 = 0
            java.lang.String r5 = r0.g()
            if (r5 != 0) goto L_0x03ac
            goto L_0x03bf
        L_0x03ac:
            java.util.regex.Matcher r4 = r4.matcher(r5)
            boolean r5 = r4.matches()
            if (r5 == 0) goto L_0x03bf
            java.lang.String r1 = r1.trim()
            e3.d r7 = e3.i.d(r1, r4, r0, r2)
            goto L_0x03c0
        L_0x03bf:
            r7 = r6
        L_0x03c0:
            if (r7 == 0) goto L_0x03c5
            r3.add(r7)
        L_0x03c5:
            r1 = r20
            goto L_0x0023
        L_0x03c9:
            e3.l r0 = new e3.l
            r0.<init>(r3)
            return r0
        L_0x03cf:
            r0 = move-exception
            r1 = r0
            w2.f r0 = new w2.f
            r0.<init>((g1.b1) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.j.f(byte[], int, boolean):w2.d");
    }
}
