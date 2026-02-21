package d2;

import j1.b0;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f4156a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    private d() {
    }

    public static void a(int i10, b0 b0Var) {
        b0Var.D(7);
        byte[] bArr = b0Var.f8414a;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((i10 >> 16) & 255);
        bArr[5] = (byte) ((i10 >> 8) & 255);
        bArr[6] = (byte) (i10 & 255);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        if (r9 != 11) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        if (r9 != 11) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008f, code lost:
        if (r9 != 8) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b2.e b(j1.a0 r9) {
        /*
            r0 = 16
            int r1 = r9.g(r0)
            int r0 = r9.g(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L_0x0018
            r0 = 24
            int r0 = r9.g(r0)
            r2 = 7
            goto L_0x0019
        L_0x0018:
            r2 = 4
        L_0x0019:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r1 = 2
            int r2 = r9.g(r1)
            r4 = 3
            if (r2 != r4) goto L_0x0032
        L_0x0029:
            r9.g(r1)
            boolean r2 = r9.f()
            if (r2 != 0) goto L_0x0029
        L_0x0032:
            r2 = 10
            int r2 = r9.g(r2)
            boolean r5 = r9.f()
            if (r5 == 0) goto L_0x0047
            int r5 = r9.g(r4)
            if (r5 <= 0) goto L_0x0047
            r9.m(r1)
        L_0x0047:
            boolean r5 = r9.f()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r5 == 0) goto L_0x0057
            r5 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x005a
        L_0x0057:
            r5 = 44100(0xac44, float:6.1797E-41)
        L_0x005a:
            int r9 = r9.g(r3)
            int[] r8 = f4156a
            if (r5 != r6) goto L_0x0069
            r6 = 13
            if (r9 != r6) goto L_0x0069
            r9 = r8[r9]
            goto L_0x0096
        L_0x0069:
            if (r5 != r7) goto L_0x0095
            r6 = 14
            if (r9 >= r6) goto L_0x0095
            r6 = r8[r9]
            int r2 = r2 % 5
            r7 = 1
            r8 = 8
            if (r2 == r7) goto L_0x008d
            r7 = 11
            if (r2 == r1) goto L_0x0088
            if (r2 == r4) goto L_0x008d
            if (r2 == r3) goto L_0x0081
            goto L_0x0093
        L_0x0081:
            if (r9 == r4) goto L_0x0091
            if (r9 == r8) goto L_0x0091
            if (r9 != r7) goto L_0x0093
            goto L_0x0091
        L_0x0088:
            if (r9 == r8) goto L_0x0091
            if (r9 != r7) goto L_0x0093
            goto L_0x0091
        L_0x008d:
            if (r9 == r4) goto L_0x0091
            if (r9 != r8) goto L_0x0093
        L_0x0091:
            int r6 = r6 + 1
        L_0x0093:
            r9 = r6
            goto L_0x0096
        L_0x0095:
            r9 = 0
        L_0x0096:
            b2.e r1 = new b2.e
            r1.<init>(r5, r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.d.b(j1.a0):b2.e");
    }
}
