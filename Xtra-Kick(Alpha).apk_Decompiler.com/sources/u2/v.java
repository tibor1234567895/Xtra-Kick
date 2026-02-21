package u2;

import d2.w0;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f15316a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15317b;

    /* renamed from: c  reason: collision with root package name */
    public final w0 f15318c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15319d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f15320e;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r6.equals("cbc1") == false) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public v(boolean r5, java.lang.String r6, int r7, byte[] r8, int r9, int r10, byte[] r11) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L_0x0009
            r2 = 1
            goto L_0x000a
        L_0x0009:
            r2 = 0
        L_0x000a:
            if (r11 != 0) goto L_0x000e
            r3 = 1
            goto L_0x000f
        L_0x000e:
            r3 = 0
        L_0x000f:
            r2 = r2 ^ r3
            j1.a.b(r2)
            r4.f15316a = r5
            r4.f15317b = r6
            r4.f15319d = r7
            r4.f15320e = r11
            d2.w0 r5 = new d2.w0
            if (r6 != 0) goto L_0x0020
            goto L_0x0076
        L_0x0020:
            int r7 = r6.hashCode()
            r11 = 3
            r2 = 2
            switch(r7) {
                case 3046605: goto L_0x004b;
                case 3046671: goto L_0x0040;
                case 3049879: goto L_0x0035;
                case 3049895: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0053
        L_0x002a:
            java.lang.String r7 = "cens"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0033
            goto L_0x0053
        L_0x0033:
            r0 = 3
            goto L_0x0054
        L_0x0035:
            java.lang.String r7 = "cenc"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x003e
            goto L_0x0053
        L_0x003e:
            r0 = 2
            goto L_0x0054
        L_0x0040:
            java.lang.String r7 = "cbcs"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0049
            goto L_0x0053
        L_0x0049:
            r0 = 1
            goto L_0x0054
        L_0x004b:
            java.lang.String r7 = "cbc1"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0054
        L_0x0053:
            r0 = -1
        L_0x0054:
            if (r0 == 0) goto L_0x0075
            if (r0 == r1) goto L_0x0075
            if (r0 == r2) goto L_0x0076
            if (r0 == r11) goto L_0x0076
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r11 = "Unsupported protection scheme type '"
            r7.<init>(r11)
            r7.append(r6)
            java.lang.String r6 = "'. Assuming AES-CTR crypto mode."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "TrackEncryptionBox"
            j1.v.g(r7, r6)
            goto L_0x0076
        L_0x0075:
            r1 = 2
        L_0x0076:
            r5.<init>(r1, r9, r10, r8)
            r4.f15318c = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.v.<init>(boolean, java.lang.String, int, byte[], int, int, byte[]):void");
    }
}
