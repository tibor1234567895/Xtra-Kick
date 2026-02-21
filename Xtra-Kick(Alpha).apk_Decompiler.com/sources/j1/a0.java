package j1;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8405a;

    /* renamed from: b  reason: collision with root package name */
    public int f8406b;

    /* renamed from: c  reason: collision with root package name */
    public int f8407c;

    /* renamed from: d  reason: collision with root package name */
    public int f8408d;

    public a0() {
        this.f8405a = l0.f8458f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f8408d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r2 = this;
            int r0 = r2.f8406b
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f8408d
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f8407c
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            j1.a.e(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.a0.a():void");
    }

    public final int b() {
        return ((this.f8408d - this.f8406b) * 8) - this.f8407c;
    }

    public final void c() {
        if (this.f8407c != 0) {
            this.f8407c = 0;
            this.f8406b++;
            a();
        }
    }

    public final int d() {
        a.e(this.f8407c == 0);
        return this.f8406b;
    }

    public final int e() {
        return (this.f8406b * 8) + this.f8407c;
    }

    public final boolean f() {
        boolean z10 = (this.f8405a[this.f8406b] & (128 >> this.f8407c)) != 0;
        l();
        return z10;
    }

    public final int g(int i10) {
        int i11;
        if (i10 == 0) {
            return 0;
        }
        this.f8407c += i10;
        int i12 = 0;
        while (true) {
            i11 = this.f8407c;
            if (i11 <= 8) {
                break;
            }
            int i13 = i11 - 8;
            this.f8407c = i13;
            byte[] bArr = this.f8405a;
            int i14 = this.f8406b;
            this.f8406b = i14 + 1;
            i12 |= (bArr[i14] & 255) << i13;
        }
        byte[] bArr2 = this.f8405a;
        int i15 = this.f8406b;
        int i16 = (-1 >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.f8407c = 0;
            this.f8406b = i15 + 1;
        }
        a();
        return i16;
    }

    public final void h(byte[] bArr, int i10) {
        int i11 = (i10 >> 3) + 0;
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArr2 = this.f8405a;
            int i13 = this.f8406b;
            int i14 = i13 + 1;
            this.f8406b = i14;
            byte b10 = bArr2[i13];
            int i15 = this.f8407c;
            byte b11 = (byte) (b10 << i15);
            bArr[i12] = b11;
            bArr[i12] = (byte) (((255 & bArr2[i14]) >> (8 - i15)) | b11);
        }
        int i16 = i10 & 7;
        if (i16 != 0) {
            byte b12 = (byte) (bArr[i11] & (255 >> i16));
            bArr[i11] = b12;
            int i17 = this.f8407c;
            if (i17 + i16 > 8) {
                byte[] bArr3 = this.f8405a;
                int i18 = this.f8406b;
                this.f8406b = i18 + 1;
                bArr[i11] = (byte) (b12 | ((bArr3[i18] & 255) << i17));
                this.f8407c = i17 - 8;
            }
            int i19 = this.f8407c + i16;
            this.f8407c = i19;
            byte[] bArr4 = this.f8405a;
            int i20 = this.f8406b;
            bArr[i11] = (byte) (((byte) (((255 & bArr4[i20]) >> (8 - i19)) << (8 - i16))) | bArr[i11]);
            if (i19 == 8) {
                this.f8407c = 0;
                this.f8406b = i20 + 1;
            }
            a();
        }
    }

    public final void i(byte[] bArr, int i10) {
        a.e(this.f8407c == 0);
        System.arraycopy(this.f8405a, this.f8406b, bArr, 0, i10);
        this.f8406b += i10;
        a();
    }

    public final void j(int i10, byte[] bArr) {
        this.f8405a = bArr;
        this.f8406b = 0;
        this.f8407c = 0;
        this.f8408d = i10;
    }

    public final void k(int i10) {
        int i11 = i10 / 8;
        this.f8406b = i11;
        this.f8407c = i10 - (i11 * 8);
        a();
    }

    public final void l() {
        int i10 = this.f8407c + 1;
        this.f8407c = i10;
        if (i10 == 8) {
            this.f8407c = 0;
            this.f8406b++;
        }
        a();
    }

    public final void m(int i10) {
        int i11 = i10 / 8;
        int i12 = this.f8406b + i11;
        this.f8406b = i12;
        int i13 = (i10 - (i11 * 8)) + this.f8407c;
        this.f8407c = i13;
        if (i13 > 7) {
            this.f8406b = i12 + 1;
            this.f8407c = i13 - 8;
        }
        a();
    }

    public final void n(int i10) {
        a.e(this.f8407c == 0);
        this.f8406b += i10;
        a();
    }

    public a0(int i10, byte[] bArr) {
        this.f8405a = bArr;
        this.f8408d = i10;
    }
}
