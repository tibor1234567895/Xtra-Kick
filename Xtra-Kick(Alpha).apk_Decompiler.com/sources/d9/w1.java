package d9;

import java.util.Objects;

public final class w1 extends t0 {

    /* renamed from: n  reason: collision with root package name */
    public static final w1 f4691n = new w1(0, (Object) null, new Object[0]);

    /* renamed from: k  reason: collision with root package name */
    public final transient Object f4692k;

    /* renamed from: l  reason: collision with root package name */
    public final transient Object[] f4693l;

    /* renamed from: m  reason: collision with root package name */
    public final transient int f4694m;

    public w1(int i10, Object obj, Object[] objArr) {
        this.f4692k = obj;
        this.f4693l = objArr;
        this.f4694m = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bc, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object g(java.lang.Object[] r9, int r10, int r11, int r12) {
        /*
            r0 = 1
            if (r10 != r0) goto L_0x0011
            r10 = r9[r12]
            java.util.Objects.requireNonNull(r10)
            r10 = r12 ^ 1
            r9 = r9[r10]
            java.util.Objects.requireNonNull(r9)
            r9 = 0
            return r9
        L_0x0011:
            int r0 = r11 + -1
            r1 = 128(0x80, float:1.794E-43)
            r2 = 0
            r3 = -1
            if (r11 > r1) goto L_0x0056
            byte[] r11 = new byte[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x001e:
            if (r2 >= r10) goto L_0x0055
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            java.util.Objects.requireNonNull(r3)
            r4 = r1 ^ 1
            r4 = r9[r4]
            java.util.Objects.requireNonNull(r4)
            int r5 = r3.hashCode()
            int r5 = d9.h0.a(r5)
        L_0x0037:
            r5 = r5 & r0
            byte r6 = r11[r5]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x0045
            byte r1 = (byte) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x001e
        L_0x0045:
            r7 = r9[r6]
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x0050
            int r5 = r5 + 1
            goto L_0x0037
        L_0x0050:
            java.lang.IllegalArgumentException r9 = h(r3, r4, r9, r6)
            throw r9
        L_0x0055:
            return r11
        L_0x0056:
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r11 > r1) goto L_0x0099
            short[] r11 = new short[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x0060:
            if (r2 >= r10) goto L_0x0098
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            java.util.Objects.requireNonNull(r3)
            r4 = r1 ^ 1
            r4 = r9[r4]
            java.util.Objects.requireNonNull(r4)
            int r5 = r3.hashCode()
            int r5 = d9.h0.a(r5)
        L_0x0079:
            r5 = r5 & r0
            short r6 = r11[r5]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x0088
            short r1 = (short) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x0060
        L_0x0088:
            r7 = r9[r6]
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x0093
            int r5 = r5 + 1
            goto L_0x0079
        L_0x0093:
            java.lang.IllegalArgumentException r9 = h(r3, r4, r9, r6)
            throw r9
        L_0x0098:
            return r11
        L_0x0099:
            int[] r11 = new int[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x009e:
            if (r2 >= r10) goto L_0x00d1
            int r1 = r2 * 2
            int r1 = r1 + r12
            r4 = r9[r1]
            java.util.Objects.requireNonNull(r4)
            r5 = r1 ^ 1
            r5 = r9[r5]
            java.util.Objects.requireNonNull(r5)
            int r6 = r4.hashCode()
            int r6 = d9.h0.a(r6)
        L_0x00b7:
            r6 = r6 & r0
            r7 = r11[r6]
            if (r7 != r3) goto L_0x00c1
            r11[r6] = r1
            int r2 = r2 + 1
            goto L_0x009e
        L_0x00c1:
            r8 = r9[r7]
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x00cc
            int r6 = r6 + 1
            goto L_0x00b7
        L_0x00cc:
            java.lang.IllegalArgumentException r9 = h(r4, r5, r9, r7)
            throw r9
        L_0x00d1:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.w1.g(java.lang.Object[], int, int, int):java.lang.Object");
    }

    public static IllegalArgumentException h(Object obj, Object obj2, Object[] objArr, int i10) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i10]);
        String valueOf4 = String.valueOf(objArr[i10 ^ 1]);
        StringBuilder sb2 = new StringBuilder(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 39);
        sb2.append("Multiple entries with same key: ");
        sb2.append(valueOf);
        sb2.append(Constants.ATTRIBUTE_SEPARATOR);
        sb2.append(valueOf2);
        sb2.append(" and ");
        sb2.append(valueOf3);
        sb2.append(Constants.ATTRIBUTE_SEPARATOR);
        sb2.append(valueOf4);
        return new IllegalArgumentException(sb2.toString());
    }

    public static Object i(Object obj, Object[] objArr, int i10, int i11, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i10 == 1) {
            Object obj3 = objArr[i11];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i11 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int a10 = h0.a(obj2.hashCode());
                while (true) {
                    int i12 = a10 & length;
                    byte b10 = bArr[i12] & 255;
                    if (b10 == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[b10])) {
                        return objArr[b10 ^ 1];
                    }
                    a10 = i12 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int a11 = h0.a(obj2.hashCode());
                while (true) {
                    int i13 = a11 & length2;
                    short s10 = sArr[i13] & 65535;
                    if (s10 == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[s10])) {
                        return objArr[s10 ^ 1];
                    }
                    a11 = i13 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int a12 = h0.a(obj2.hashCode());
                while (true) {
                    int i14 = a12 & length3;
                    int i15 = iArr[i14];
                    if (i15 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i15])) {
                        return objArr[i15 ^ 1];
                    }
                    a12 = i14 + 1;
                }
            }
        }
    }

    public final t1 b() {
        return new t1(this, this.f4693l, 0, this.f4694m);
    }

    public final u1 c() {
        return new u1(this, new v1(0, this.f4694m, this.f4693l));
    }

    public final m0 d() {
        return new v1(1, this.f4694m, this.f4693l);
    }

    public final void e() {
    }

    public final Object get(Object obj) {
        Object i10 = i(this.f4692k, this.f4693l, this.f4694m, 0, obj);
        if (i10 == null) {
            return null;
        }
        return i10;
    }

    public final int size() {
        return this.f4694m;
    }
}
