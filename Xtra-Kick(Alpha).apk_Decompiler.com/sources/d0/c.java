package d0;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f4089a = new ThreadLocal();

    private c() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.res.Resources r4, android.content.res.XmlResourceParser r5, android.content.res.Resources.Theme r6) {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x000f
            r3 = 1
            if (r1 == r3) goto L_0x000f
            goto L_0x0004
        L_0x000f:
            if (r1 != r2) goto L_0x0016
            android.content.res.ColorStateList r4 = b(r4, r5, r0, r6)
            return r4
        L_0x0016:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.c.a(android.content.res.Resources, android.content.res.XmlResourceParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x012f  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList b(android.content.res.Resources r37, android.content.res.XmlResourceParser r38, android.util.AttributeSet r39, android.content.res.Resources.Theme r40) {
        /*
            r0 = r37
            r1 = r39
            r2 = r40
            java.lang.String r3 = r38.getName()
            java.lang.String r4 = "selector"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x03a6
            int r3 = r38.getDepth()
            r4 = 1
            int r3 = r3 + r4
            r5 = 20
            int[][] r6 = new int[r5][]
            int[] r5 = new int[r5]
            r7 = 0
            r8 = 0
        L_0x0020:
            int r9 = r38.next()
            if (r9 == r4) goto L_0x0394
            int r10 = r38.getDepth()
            r11 = 3
            if (r10 >= r3) goto L_0x002f
            if (r9 == r11) goto L_0x0394
        L_0x002f:
            r12 = 2
            if (r9 != r12) goto L_0x0383
            if (r10 > r3) goto L_0x0383
            java.lang.String r9 = r38.getName()
            java.lang.String r10 = "item"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0042
            goto L_0x0383
        L_0x0042:
            int[] r9 = a0.a.f6a
            if (r2 != 0) goto L_0x004b
            android.content.res.TypedArray r9 = r0.obtainAttributes(r1, r9)
            goto L_0x004f
        L_0x004b:
            android.content.res.TypedArray r9 = r2.obtainStyledAttributes(r1, r9, r7, r7)
        L_0x004f:
            r10 = -1
            int r13 = r9.getResourceId(r7, r10)
            r14 = 31
            if (r13 == r10) goto L_0x008a
            java.lang.ThreadLocal r15 = f4089a
            java.lang.Object r16 = r15.get()
            android.util.TypedValue r16 = (android.util.TypedValue) r16
            if (r16 != 0) goto L_0x006b
            android.util.TypedValue r10 = new android.util.TypedValue
            r10.<init>()
            r15.set(r10)
            goto L_0x006d
        L_0x006b:
            r10 = r16
        L_0x006d:
            r0.getValue(r13, r10, r4)
            int r10 = r10.type
            r15 = 28
            if (r10 < r15) goto L_0x007a
            if (r10 > r14) goto L_0x007a
            r10 = 1
            goto L_0x007b
        L_0x007a:
            r10 = 0
        L_0x007b:
            if (r10 != 0) goto L_0x008a
            android.content.res.XmlResourceParser r10 = r0.getXml(r13)     // Catch:{ Exception -> 0x008a }
            android.content.res.ColorStateList r10 = a(r0, r10, r2)     // Catch:{ Exception -> 0x008a }
            int r10 = r10.getDefaultColor()     // Catch:{ Exception -> 0x008a }
            goto L_0x0091
        L_0x008a:
            r10 = -65281(0xffffffffffff00ff, float:NaN)
            int r10 = r9.getColor(r7, r10)
        L_0x0091:
            boolean r13 = r9.hasValue(r4)
            r15 = 1065353216(0x3f800000, float:1.0)
            if (r13 == 0) goto L_0x009e
            float r11 = r9.getFloat(r4, r15)
            goto L_0x00ab
        L_0x009e:
            boolean r13 = r9.hasValue(r11)
            if (r13 == 0) goto L_0x00a9
            float r11 = r9.getFloat(r11, r15)
            goto L_0x00ab
        L_0x00a9:
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x00ab:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r14) goto L_0x00b7
            boolean r13 = r9.hasValue(r12)
            if (r13 == 0) goto L_0x00b7
            r13 = 2
            goto L_0x00b8
        L_0x00b7:
            r13 = 4
        L_0x00b8:
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r13 = r9.getFloat(r13, r14)
            r9.recycle()
            int r9 = r39.getAttributeCount()
            int[] r14 = new int[r9]
            r4 = 0
            r12 = 0
        L_0x00c9:
            if (r4 >= r9) goto L_0x00f9
            int r15 = r1.getAttributeNameResource(r4)
            r7 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r7) goto L_0x00f1
            r7 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r7) goto L_0x00f1
            r7 = 2130968632(0x7f040038, float:1.7545923E38)
            if (r15 == r7) goto L_0x00f1
            r7 = 2130969239(0x7f040297, float:1.7547154E38)
            if (r15 == r7) goto L_0x00f1
            int r7 = r12 + 1
            r0 = 0
            boolean r18 = r1.getAttributeBooleanValue(r4, r0)
            if (r18 == 0) goto L_0x00ed
            goto L_0x00ee
        L_0x00ed:
            int r15 = -r15
        L_0x00ee:
            r14[r12] = r15
            r12 = r7
        L_0x00f1:
            int r4 = r4 + 1
            r0 = r37
            r7 = 0
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00c9
        L_0x00f9:
            int[] r0 = android.util.StateSet.trimStateSet(r14, r12)
            r4 = 1120403456(0x42c80000, float:100.0)
            r7 = 0
            int r9 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x010a
            int r9 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x010a
            r9 = 1
            goto L_0x010b
        L_0x010a:
            r9 = 0
        L_0x010b:
            r12 = 1065353216(0x3f800000, float:1.0)
            int r14 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x011b
            if (r9 != 0) goto L_0x011b
            r34 = r3
            r30 = r5
            r7 = 1
            r5 = r0
            goto L_0x033e
        L_0x011b:
            int r12 = android.graphics.Color.alpha(r10)
            float r12 = (float) r12
            float r12 = r12 * r11
            r11 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r11
            int r11 = (int) r12
            r12 = 255(0xff, float:3.57E-43)
            r14 = 0
            int r11 = h0.a.a(r11, r14, r12)
            if (r9 == 0) goto L_0x0330
            d0.a r9 = d0.a.a(r10)
            d0.u r10 = d0.u.f4118k
            float r12 = r9.f4080b
            double r14 = (double) r12
            r18 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r20 = 1007753895(0x3c111aa7, float:0.008856452)
            r21 = 1147261687(0x4461d2f7, float:903.2963)
            r22 = 1122500608(0x42e80000, float:116.0)
            r23 = 1098907648(0x41800000, float:16.0)
            int r24 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r24 < 0) goto L_0x02c6
            int r14 = java.lang.Math.round(r13)
            double r14 = (double) r14
            r18 = 0
            int r24 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r24 <= 0) goto L_0x02c6
            int r14 = java.lang.Math.round(r13)
            double r14 = (double) r14
            r18 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r24 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r24 < 0) goto L_0x0160
            goto L_0x02c6
        L_0x0160:
            float r9 = r9.f4079a
            int r14 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r14 >= 0) goto L_0x0168
            r9 = 0
            goto L_0x016e
        L_0x0168:
            r14 = 1135869952(0x43b40000, float:360.0)
            float r9 = java.lang.Math.min(r14, r9)
        L_0x016e:
            r15 = r12
            r14 = 0
            r18 = 1
            r19 = 0
        L_0x0174:
            float r25 = r19 - r12
            float r25 = java.lang.Math.abs(r25)
            r26 = 1053609165(0x3ecccccd, float:0.4)
            int r25 = (r25 > r26 ? 1 : (r25 == r26 ? 0 : -1))
            if (r25 < 0) goto L_0x02b7
            r25 = 1148846080(0x447a0000, float:1000.0)
            r26 = 1148846080(0x447a0000, float:1000.0)
            r27 = 0
            r28 = 1120403456(0x42c80000, float:100.0)
            r29 = 0
        L_0x018b:
            float r30 = r27 - r28
            float r30 = java.lang.Math.abs(r30)
            r31 = 1008981770(0x3c23d70a, float:0.01)
            r32 = 1073741824(0x40000000, float:2.0)
            int r30 = (r30 > r31 ? 1 : (r30 == r31 ? 0 : -1))
            if (r30 <= 0) goto L_0x0275
            float r30 = r28 - r27
            float r30 = r30 / r32
            float r7 = r30 + r27
            d0.a r4 = d0.a.b(r7, r15, r9)
            d0.u r1 = d0.u.f4118k
            int r1 = r4.c(r1)
            int r4 = android.graphics.Color.red(r1)
            float r4 = d0.b.a(r4)
            int r33 = android.graphics.Color.green(r1)
            float r33 = d0.b.a(r33)
            int r34 = android.graphics.Color.blue(r1)
            float r34 = d0.b.a(r34)
            float[][] r35 = d0.b.f4088d
            r16 = 1
            r35 = r35[r16]
            r17 = 0
            r36 = r35[r17]
            float r4 = r4 * r36
            r36 = r35[r16]
            float r33 = r33 * r36
            float r33 = r33 + r4
            r4 = 2
            r35 = r35[r4]
            float r34 = r34 * r35
            float r34 = r34 + r33
            r4 = 1120403456(0x42c80000, float:100.0)
            float r2 = r34 / r4
            int r30 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r30 > 0) goto L_0x01e8
            float r2 = r2 * r21
            r30 = r5
            goto L_0x01f4
        L_0x01e8:
            r30 = r5
            double r4 = (double) r2
            double r4 = java.lang.Math.cbrt(r4)
            float r2 = (float) r4
            float r2 = r2 * r22
            float r2 = r2 - r23
        L_0x01f4:
            float r4 = r13 - r2
            float r4 = java.lang.Math.abs(r4)
            r5 = 1045220557(0x3e4ccccd, float:0.2)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x024f
            d0.a r1 = d0.a.a(r1)
            float r5 = r1.f4081c
            r34 = r3
            float r3 = r1.f4080b
            d0.a r3 = d0.a.b(r5, r3, r9)
            float r5 = r3.f4082d
            r35 = r4
            float r4 = r1.f4082d
            float r4 = r4 - r5
            float r5 = r1.f4083e
            r36 = r7
            float r7 = r3.f4083e
            float r5 = r5 - r7
            float r7 = r1.f4084f
            float r3 = r3.f4084f
            float r7 = r7 - r3
            float r4 = r4 * r4
            float r5 = r5 * r5
            float r5 = r5 + r4
            float r7 = r7 * r7
            float r7 = r7 + r5
            double r3 = (double) r7
            double r3 = java.lang.Math.sqrt(r3)
            r5 = r0
            r7 = r1
            r0 = 4603849755075763241(0x3fe428f5c28f5c29, double:0.63)
            double r0 = java.lang.Math.pow(r3, r0)
            r3 = 4609028894647239311(0x3ff68f5c28f5c28f, double:1.41)
            double r0 = r0 * r3
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x0254
            r26 = r0
            r29 = r7
            r25 = r35
            goto L_0x0254
        L_0x024f:
            r5 = r0
            r34 = r3
            r36 = r7
        L_0x0254:
            r0 = 0
            int r1 = (r25 > r0 ? 1 : (r25 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x025e
            int r1 = (r26 > r0 ? 1 : (r26 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x025e
            goto L_0x027b
        L_0x025e:
            int r1 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r1 >= 0) goto L_0x0265
            r27 = r36
            goto L_0x0267
        L_0x0265:
            r28 = r36
        L_0x0267:
            r1 = r39
            r2 = r40
            r0 = r5
            r5 = r30
            r3 = r34
            r4 = 1120403456(0x42c80000, float:100.0)
            r7 = 0
            goto L_0x018b
        L_0x0275:
            r34 = r3
            r30 = r5
            r5 = r0
            r0 = 0
        L_0x027b:
            r1 = r29
            if (r18 == 0) goto L_0x029c
            if (r1 == 0) goto L_0x0286
            int r10 = r1.c(r10)
            goto L_0x02c3
        L_0x0286:
            float r1 = r12 - r19
            float r1 = r1 / r32
            float r15 = r1 + r19
            r1 = r39
            r2 = r40
            r0 = r5
            r5 = r30
            r3 = r34
            r4 = 1120403456(0x42c80000, float:100.0)
            r7 = 0
            r18 = 0
            goto L_0x0174
        L_0x029c:
            if (r1 != 0) goto L_0x02a0
            r12 = r15
            goto L_0x02a3
        L_0x02a0:
            r14 = r1
            r19 = r15
        L_0x02a3:
            float r1 = r12 - r19
            float r1 = r1 / r32
            float r15 = r1 + r19
            r1 = r39
            r2 = r40
            r0 = r5
            r5 = r30
            r3 = r34
            r4 = 1120403456(0x42c80000, float:100.0)
            r7 = 0
            goto L_0x0174
        L_0x02b7:
            r34 = r3
            r30 = r5
            r5 = r0
            if (r14 != 0) goto L_0x02bf
            goto L_0x02cb
        L_0x02bf:
            int r10 = r14.c(r10)
        L_0x02c3:
            r7 = 1
            goto L_0x0336
        L_0x02c6:
            r34 = r3
            r30 = r5
            r5 = r0
        L_0x02cb:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x02d4
            r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x02c3
        L_0x02d4:
            r0 = 1120272384(0x42c60000, float:99.0)
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x02dd
            r7 = 1
            r10 = -1
            goto L_0x0336
        L_0x02dd:
            float r0 = r13 + r23
            float r0 = r0 / r22
            r1 = 1090519040(0x41000000, float:8.0)
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x02e9
            r1 = 1
            goto L_0x02ea
        L_0x02e9:
            r1 = 0
        L_0x02ea:
            if (r1 == 0) goto L_0x02f1
            float r1 = r0 * r0
            float r1 = r1 * r0
            goto L_0x02f3
        L_0x02f1:
            float r1 = r13 / r21
        L_0x02f3:
            float r2 = r0 * r0
            float r2 = r2 * r0
            int r3 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r3 <= 0) goto L_0x02fd
            r3 = 1
            goto L_0x02fe
        L_0x02fd:
            r3 = 0
        L_0x02fe:
            if (r3 == 0) goto L_0x0302
            r4 = r2
            goto L_0x0308
        L_0x0302:
            float r4 = r0 * r22
            float r4 = r4 - r23
            float r4 = r4 / r21
        L_0x0308:
            if (r3 == 0) goto L_0x030b
            goto L_0x0311
        L_0x030b:
            float r0 = r0 * r22
            float r0 = r0 - r23
            float r2 = r0 / r21
        L_0x0311:
            float[] r0 = d0.b.f4087c
            r3 = 0
            r7 = r0[r3]
            float r4 = r4 * r7
            double r3 = (double) r4
            r7 = 1
            r9 = r0[r7]
            float r1 = r1 * r9
            double r9 = (double) r1
            r1 = 2
            r0 = r0[r1]
            float r2 = r2 * r0
            double r0 = (double) r2
            r18 = r3
            r20 = r9
            r22 = r0
            int r10 = e0.a.a(r18, r20, r22)
            goto L_0x0336
        L_0x0330:
            r34 = r3
            r30 = r5
            r7 = 1
            r5 = r0
        L_0x0336:
            r0 = 16777215(0xffffff, float:2.3509886E-38)
            r0 = r0 & r10
            int r1 = r11 << 24
            r10 = r0 | r1
        L_0x033e:
            int r0 = r8 + 1
            r1 = r30
            int r2 = r1.length
            r3 = 8
            if (r0 <= r2) goto L_0x0356
            r2 = 4
            if (r8 > r2) goto L_0x034d
            r2 = 8
            goto L_0x034f
        L_0x034d:
            int r2 = r8 * 2
        L_0x034f:
            int[] r2 = new int[r2]
            r4 = 0
            java.lang.System.arraycopy(r1, r4, r2, r4, r8)
            r1 = r2
        L_0x0356:
            r1[r8] = r10
            int r2 = r6.length
            if (r0 <= r2) goto L_0x0374
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r2 = r2.getComponentType()
            r4 = 4
            if (r8 > r4) goto L_0x0367
            goto L_0x0369
        L_0x0367:
            int r3 = r8 * 2
        L_0x0369:
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r2, r3)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r3 = 0
            java.lang.System.arraycopy(r6, r3, r2, r3, r8)
            r6 = r2
        L_0x0374:
            r6[r8] = r5
            int[][] r6 = (int[][]) r6
            r2 = r40
            r8 = r0
            r5 = r1
            r3 = r34
            r4 = 1
            r7 = 0
            r0 = r37
            goto L_0x0390
        L_0x0383:
            r34 = r3
            r1 = r5
            r7 = 1
            r0 = r37
            r2 = r40
            r5 = r1
            r3 = r34
            r4 = 1
            r7 = 0
        L_0x0390:
            r1 = r39
            goto L_0x0020
        L_0x0394:
            r1 = r5
            int[] r0 = new int[r8]
            int[][] r2 = new int[r8][]
            r3 = 0
            java.lang.System.arraycopy(r1, r3, r0, r3, r8)
            java.lang.System.arraycopy(r6, r3, r2, r3, r8)
            android.content.res.ColorStateList r1 = new android.content.res.ColorStateList
            r1.<init>(r2, r0)
            return r1
        L_0x03a6:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r38.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": invalid color state list tag "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.c.b(android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }
}
