package y7;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final c f17106a;

    /* renamed from: b  reason: collision with root package name */
    public final c f17107b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final float f17108c;

    /* renamed from: d  reason: collision with root package name */
    public final float f17109d;

    /* renamed from: e  reason: collision with root package name */
    public final float f17110e;

    /* renamed from: f  reason: collision with root package name */
    public final float f17111f;

    /* renamed from: g  reason: collision with root package name */
    public final float f17112g;

    /* renamed from: h  reason: collision with root package name */
    public final float f17113h;

    /* renamed from: i  reason: collision with root package name */
    public final float f17114i;

    /* renamed from: j  reason: collision with root package name */
    public final int f17115j;

    /* renamed from: k  reason: collision with root package name */
    public final int f17116k;

    /* renamed from: l  reason: collision with root package name */
    public final int f17117l;

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r17, y7.c r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r5 = 2130968675(0x7f040063, float:1.754601E38)
            r16.<init>()
            y7.c r2 = new y7.c
            r2.<init>()
            r1.f17107b = r2
            if (r18 != 0) goto L_0x001a
            y7.c r2 = new y7.c
            r2.<init>()
            r8 = r2
            goto L_0x001c
        L_0x001a:
            r8 = r18
        L_0x001c:
            int r2 = r8.f17087h
            r9 = 1
            r10 = 0
            r11 = 2
            if (r2 == 0) goto L_0x008d
            java.lang.String r3 = "badge"
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            android.content.res.XmlResourceParser r4 = r4.getXml(r2)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
        L_0x002d:
            int r6 = r4.next()     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            if (r6 == r11) goto L_0x0035
            if (r6 != r9) goto L_0x002d
        L_0x0035:
            if (r6 != r11) goto L_0x0067
            java.lang.String r6 = r4.getName()     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            boolean r6 = android.text.TextUtils.equals(r6, r3)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            if (r6 == 0) goto L_0x004b
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r4)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            int r3 = r2.getStyleAttribute()
            r4 = r2
            goto L_0x0090
        L_0x004b:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            java.lang.String r5 = "Must have a <"
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            java.lang.String r3 = "> start tag"
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            java.lang.String r3 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            r0.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            throw r0     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
        L_0x0067:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            java.lang.String r3 = "No start tag found"
            r0.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
            throw r0     // Catch:{ XmlPullParserException -> 0x0071, IOException -> 0x006f }
        L_0x006f:
            r0 = move-exception
            goto L_0x0072
        L_0x0071:
            r0 = move-exception
        L_0x0072:
            android.content.res.Resources$NotFoundException r3 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Can't load badge resource ID #0x"
            r4.<init>(r5)
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            r3.initCause(r0)
            throw r3
        L_0x008d:
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0090:
            if (r3 != 0) goto L_0x0099
            r2 = 2132018279(0x7f140467, float:1.967486E38)
            r6 = 2132018279(0x7f140467, float:1.967486E38)
            goto L_0x009a
        L_0x0099:
            r6 = r3
        L_0x009a:
            int[] r7 = v7.a.f15934c
            int[] r12 = new int[r10]
            r2 = r17
            r3 = r4
            r4 = r7
            r7 = r12
            android.content.res.TypedArray r2 = m8.r.d(r2, r3, r4, r5, r6, r7)
            android.content.res.Resources r3 = r17.getResources()
            r4 = 3
            r5 = -1
            int r6 = r2.getDimensionPixelSize(r4, r5)
            float r6 = (float) r6
            r1.f17108c = r6
            r6 = 2131165782(0x7f070256, float:1.794579E38)
            int r6 = r3.getDimensionPixelSize(r6)
            r7 = 8
            int r6 = r2.getDimensionPixelSize(r7, r6)
            float r6 = (float) r6
            r1.f17114i = r6
            android.content.res.Resources r6 = r17.getResources()
            r12 = 2131165781(0x7f070255, float:1.7945789E38)
            int r6 = r6.getDimensionPixelSize(r12)
            r1.f17115j = r6
            android.content.res.Resources r6 = r17.getResources()
            r12 = 2131165784(0x7f070258, float:1.7945795E38)
            int r6 = r6.getDimensionPixelSize(r12)
            r1.f17116k = r6
            r6 = 11
            int r6 = r2.getDimensionPixelSize(r6, r5)
            float r6 = (float) r6
            r1.f17109d = r6
            r6 = 2131165394(0x7f0700d2, float:1.7945004E38)
            float r12 = r3.getDimension(r6)
            r13 = 9
            float r12 = r2.getDimension(r13, r12)
            r1.f17110e = r12
            r12 = 2131165398(0x7f0700d6, float:1.7945012E38)
            float r14 = r3.getDimension(r12)
            r15 = 14
            float r14 = r2.getDimension(r15, r14)
            r1.f17112g = r14
            float r6 = r3.getDimension(r6)
            float r6 = r2.getDimension(r11, r6)
            r1.f17111f = r6
            float r3 = r3.getDimension(r12)
            r6 = 10
            float r3 = r2.getDimension(r6, r3)
            r1.f17113h = r3
            r3 = 19
            int r3 = r2.getInt(r3, r9)
            r1.f17117l = r3
            y7.c r3 = r1.f17107b
            int r12 = r8.f17095p
            r14 = -2
            if (r12 != r14) goto L_0x012c
            r12 = 255(0xff, float:3.57E-43)
        L_0x012c:
            r3.f17095p = r12
            java.lang.CharSequence r12 = r8.f17099t
            if (r12 != 0) goto L_0x0139
            r12 = 2131952121(0x7f1301f9, float:1.9540676E38)
            java.lang.String r12 = r0.getString(r12)
        L_0x0139:
            r3.f17099t = r12
            y7.c r3 = r1.f17107b
            int r12 = r8.f17100u
            if (r12 != 0) goto L_0x0144
            r12 = 2131886085(0x7f120005, float:1.9406739E38)
        L_0x0144:
            r3.f17100u = r12
            int r12 = r8.f17101v
            if (r12 != 0) goto L_0x014d
            r12 = 2131952134(0x7f130206, float:1.9540702E38)
        L_0x014d:
            r3.f17101v = r12
            java.lang.Boolean r12 = r8.f17103x
            if (r12 == 0) goto L_0x015c
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x015a
            goto L_0x015c
        L_0x015a:
            r12 = 0
            goto L_0x015d
        L_0x015c:
            r12 = 1
        L_0x015d:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            r3.f17103x = r12
            y7.c r3 = r1.f17107b
            int r12 = r8.f17097r
            r6 = 4
            if (r12 != r14) goto L_0x0170
            r12 = 17
            int r12 = r2.getInt(r12, r6)
        L_0x0170:
            r3.f17097r = r12
            int r3 = r8.f17096q
            if (r3 == r14) goto L_0x0179
            y7.c r5 = r1.f17107b
            goto L_0x0187
        L_0x0179:
            r3 = 18
            boolean r12 = r2.hasValue(r3)
            if (r12 == 0) goto L_0x018a
            y7.c r5 = r1.f17107b
            int r3 = r2.getInt(r3, r10)
        L_0x0187:
            r5.f17096q = r3
            goto L_0x018e
        L_0x018a:
            y7.c r3 = r1.f17107b
            r3.f17096q = r5
        L_0x018e:
            y7.c r3 = r1.f17107b
            java.lang.Integer r5 = r8.f17091l
            r12 = 2132017635(0x7f1401e3, float:1.9673554E38)
            if (r5 != 0) goto L_0x019c
            int r5 = r2.getResourceId(r6, r12)
            goto L_0x01a0
        L_0x019c:
            int r5 = r5.intValue()
        L_0x01a0:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.f17091l = r5
            y7.c r3 = r1.f17107b
            java.lang.Integer r5 = r8.f17092m
            r14 = 5
            if (r5 != 0) goto L_0x01b2
            int r5 = r2.getResourceId(r14, r10)
            goto L_0x01b6
        L_0x01b2:
            int r5 = r5.intValue()
        L_0x01b6:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.f17092m = r5
            y7.c r3 = r1.f17107b
            java.lang.Integer r5 = r8.f17093n
            r13 = 12
            if (r5 != 0) goto L_0x01c9
            int r5 = r2.getResourceId(r13, r12)
            goto L_0x01cd
        L_0x01c9:
            int r5 = r5.intValue()
        L_0x01cd:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.f17093n = r5
            y7.c r3 = r1.f17107b
            java.lang.Integer r5 = r8.f17094o
            if (r5 != 0) goto L_0x01e0
            r5 = 13
            int r5 = r2.getResourceId(r5, r10)
            goto L_0x01e4
        L_0x01e0:
            int r5 = r5.intValue()
        L_0x01e4:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.f17094o = r5
            y7.c r3 = r1.f17107b
            java.lang.Integer r5 = r8.f17088i
            if (r5 != 0) goto L_0x01f9
            android.content.res.ColorStateList r5 = q8.d.a(r0, r2, r10)
            int r5 = r5.getDefaultColor()
            goto L_0x01fd
        L_0x01f9:
            int r5 = r5.intValue()
        L_0x01fd:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.f17088i = r5
            y7.c r3 = r1.f17107b
            java.lang.Integer r5 = r8.f17090k
            r12 = 6
            if (r5 != 0) goto L_0x0212
            r5 = 2132017782(0x7f140276, float:1.9673852E38)
            int r5 = r2.getResourceId(r12, r5)
            goto L_0x0216
        L_0x0212:
            int r5 = r5.intValue()
        L_0x0216:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.f17090k = r5
            java.lang.Integer r3 = r8.f17089j
            if (r3 == 0) goto L_0x0224
            y7.c r0 = r1.f17107b
            goto L_0x029f
        L_0x0224:
            r3 = 7
            boolean r5 = r2.hasValue(r3)
            if (r5 == 0) goto L_0x023c
            y7.c r4 = r1.f17107b
            android.content.res.ColorStateList r0 = q8.d.a(r0, r2, r3)
            int r0 = r0.getDefaultColor()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.f17089j = r0
            goto L_0x02a1
        L_0x023c:
            y7.c r5 = r1.f17107b
            java.lang.Integer r5 = r5.f17090k
            int r5 = r5.intValue()
            int[] r7 = v7.a.H
            android.content.res.TypedArray r7 = r0.obtainStyledAttributes(r5, r7)
            r3 = 0
            r7.getDimension(r10, r3)
            android.content.res.ColorStateList r4 = q8.d.a(r0, r7, r4)
            q8.d.a(r0, r7, r6)
            q8.d.a(r0, r7, r14)
            r7.getInt(r11, r10)
            r7.getInt(r9, r9)
            boolean r6 = r7.hasValue(r13)
            if (r6 == 0) goto L_0x0267
            r6 = 12
            goto L_0x0269
        L_0x0267:
            r6 = 10
        L_0x0269:
            r7.getResourceId(r6, r10)
            r7.getString(r6)
            r7.getBoolean(r15, r10)
            q8.d.a(r0, r7, r12)
            r6 = 7
            r7.getFloat(r6, r3)
            r6 = 8
            r7.getFloat(r6, r3)
            r6 = 9
            r7.getFloat(r6, r3)
            r7.recycle()
            int[] r6 = v7.a.f15954w
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r5, r6)
            r0.hasValue(r10)
            r0.getFloat(r10, r3)
            r0.recycle()
            y7.c r0 = r1.f17107b
            int r3 = r4.getDefaultColor()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x029f:
            r0.f17089j = r3
        L_0x02a1:
            y7.c r0 = r1.f17107b
            java.lang.Integer r3 = r8.f17102w
            if (r3 != 0) goto L_0x02af
            r3 = 8388661(0x800035, float:1.1755018E-38)
            int r3 = r2.getInt(r9, r3)
            goto L_0x02b3
        L_0x02af:
            int r3 = r3.intValue()
        L_0x02b3:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.f17102w = r3
            y7.c r0 = r1.f17107b
            java.lang.Integer r3 = r8.f17104y
            if (r3 != 0) goto L_0x02c6
            r3 = 15
            int r3 = r2.getDimensionPixelOffset(r3, r10)
            goto L_0x02ca
        L_0x02c6:
            int r3 = r3.intValue()
        L_0x02ca:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.f17104y = r3
            y7.c r0 = r1.f17107b
            java.lang.Integer r3 = r8.f17105z
            if (r3 != 0) goto L_0x02dd
            r3 = 20
            int r3 = r2.getDimensionPixelOffset(r3, r10)
            goto L_0x02e1
        L_0x02dd:
            int r3 = r3.intValue()
        L_0x02e1:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.f17105z = r3
            y7.c r0 = r1.f17107b
            java.lang.Integer r3 = r8.A
            if (r3 != 0) goto L_0x02fa
            java.lang.Integer r3 = r0.f17104y
            int r3 = r3.intValue()
            r4 = 16
            int r3 = r2.getDimensionPixelOffset(r4, r3)
            goto L_0x02fe
        L_0x02fa:
            int r3 = r3.intValue()
        L_0x02fe:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.A = r3
            y7.c r0 = r1.f17107b
            java.lang.Integer r3 = r8.B
            if (r3 != 0) goto L_0x0317
            java.lang.Integer r3 = r0.f17105z
            int r3 = r3.intValue()
            r4 = 21
            int r3 = r2.getDimensionPixelOffset(r4, r3)
            goto L_0x031b
        L_0x0317:
            int r3 = r3.intValue()
        L_0x031b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.B = r3
            y7.c r0 = r1.f17107b
            java.lang.Integer r3 = r8.C
            if (r3 != 0) goto L_0x0329
            r3 = 0
            goto L_0x032d
        L_0x0329:
            int r3 = r3.intValue()
        L_0x032d:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.C = r3
            y7.c r0 = r1.f17107b
            java.lang.Integer r3 = r8.D
            if (r3 != 0) goto L_0x033a
            goto L_0x033e
        L_0x033a:
            int r10 = r3.intValue()
        L_0x033e:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r0.D = r3
            r2.recycle()
            java.util.Locale r0 = r8.f17098s
            if (r0 != 0) goto L_0x0363
            y7.c r0 = r1.f17107b
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x035c
            java.util.Locale$Category r2 = java.util.Locale.Category.FORMAT
            java.util.Locale r2 = java.util.Locale.getDefault(r2)
            goto L_0x0360
        L_0x035c:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L_0x0360:
            r0.f17098s = r2
            goto L_0x0367
        L_0x0363:
            y7.c r2 = r1.f17107b
            r2.f17098s = r0
        L_0x0367:
            r1.f17106a = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.d.<init>(android.content.Context, y7.c):void");
    }

    public final boolean a() {
        return this.f17107b.f17096q != -1;
    }
}
