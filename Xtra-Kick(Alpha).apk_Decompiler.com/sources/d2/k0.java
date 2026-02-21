package d2;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public int f4212a;

    /* renamed from: b  reason: collision with root package name */
    public String f4213b;

    /* renamed from: c  reason: collision with root package name */
    public int f4214c;

    /* renamed from: d  reason: collision with root package name */
    public int f4215d;

    /* renamed from: e  reason: collision with root package name */
    public int f4216e;

    /* renamed from: f  reason: collision with root package name */
    public int f4217f;

    /* renamed from: g  reason: collision with root package name */
    public int f4218g;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r9) {
        /*
            r8 = this;
            r0 = -2097152(0xffffffffffe00000, float:NaN)
            r1 = r9 & r0
            r2 = 0
            r3 = 1
            if (r1 != r0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 != 0) goto L_0x000e
            return r2
        L_0x000e:
            int r0 = r9 >>> 19
            r1 = 3
            r0 = r0 & r1
            if (r0 != r3) goto L_0x0015
            return r2
        L_0x0015:
            int r4 = r9 >>> 17
            r4 = r4 & r1
            if (r4 != 0) goto L_0x001b
            return r2
        L_0x001b:
            int r5 = r9 >>> 12
            r6 = 15
            r5 = r5 & r6
            if (r5 == 0) goto L_0x00b4
            if (r5 != r6) goto L_0x0026
            goto L_0x00b4
        L_0x0026:
            int r6 = r9 >>> 10
            r6 = r6 & r1
            if (r6 != r1) goto L_0x002c
            return r2
        L_0x002c:
            r8.f4212a = r0
            java.lang.String[] r2 = d2.l0.f4223a
            int r7 = 3 - r4
            r2 = r2[r7]
            r8.f4213b = r2
            int[] r2 = d2.l0.f4224b
            r2 = r2[r6]
            r8.f4215d = r2
            r6 = 2
            if (r0 != r6) goto L_0x0041
            int r2 = r2 / r6
            goto L_0x0045
        L_0x0041:
            if (r0 != 0) goto L_0x0047
            int r2 = r2 / 4
        L_0x0045:
            r8.f4215d = r2
        L_0x0047:
            int r2 = r9 >>> 9
            r2 = r2 & r3
            r7 = 1152(0x480, float:1.614E-42)
            if (r4 == r3) goto L_0x005b
            if (r4 == r6) goto L_0x0060
            if (r4 != r1) goto L_0x0055
            r7 = 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x0055:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>()
            throw r9
        L_0x005b:
            if (r0 != r1) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r7 = 576(0x240, float:8.07E-43)
        L_0x0060:
            r8.f4218g = r7
            if (r4 != r1) goto L_0x007c
            if (r0 != r1) goto L_0x006c
            int[] r0 = d2.l0.f4225c
            int r5 = r5 - r3
            r0 = r0[r5]
            goto L_0x0071
        L_0x006c:
            int[] r0 = d2.l0.f4226d
            int r5 = r5 - r3
            r0 = r0[r5]
        L_0x0071:
            r8.f4217f = r0
            int r0 = r0 * 12
            int r4 = r8.f4215d
            int r0 = r0 / r4
            int r0 = r0 + r2
            int r0 = r0 * 4
            goto L_0x0095
        L_0x007c:
            r7 = 144(0x90, float:2.02E-43)
            if (r0 != r1) goto L_0x0098
            if (r4 != r6) goto L_0x0088
            int[] r0 = d2.l0.f4227e
            int r5 = r5 - r3
            r0 = r0[r5]
            goto L_0x008d
        L_0x0088:
            int[] r0 = d2.l0.f4228f
            int r5 = r5 - r3
            r0 = r0[r5]
        L_0x008d:
            r8.f4217f = r0
            int r0 = r0 * 144
            int r4 = r8.f4215d
            int r0 = r0 / r4
            int r0 = r0 + r2
        L_0x0095:
            r8.f4214c = r0
            goto L_0x00ab
        L_0x0098:
            int[] r0 = d2.l0.f4229g
            int r5 = r5 - r3
            r0 = r0[r5]
            r8.f4217f = r0
            if (r4 != r3) goto L_0x00a3
            r7 = 72
        L_0x00a3:
            int r7 = r7 * r0
            int r0 = r8.f4215d
            int r7 = r7 / r0
            int r7 = r7 + r2
            r8.f4214c = r7
        L_0x00ab:
            int r9 = r9 >> 6
            r9 = r9 & r1
            if (r9 != r1) goto L_0x00b1
            r6 = 1
        L_0x00b1:
            r8.f4216e = r6
            return r3
        L_0x00b4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.k0.a(int):boolean");
    }
}
