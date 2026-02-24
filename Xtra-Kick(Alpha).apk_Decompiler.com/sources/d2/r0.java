package d2;

import android.util.SparseArray;
import com.bumptech.glide.integration.webp.c;
import j1.a;

public final class r0 implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4288a;

    /* renamed from: b  reason: collision with root package name */
    public Cloneable f4289b;

    /* renamed from: c  reason: collision with root package name */
    public int f4290c;

    /* renamed from: d  reason: collision with root package name */
    public int f4291d;

    /* renamed from: e  reason: collision with root package name */
    public int f4292e;

    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Cloneable, byte[]] */
    public r0(int i10, int i11) {
        this.f4288a = 2;
        this.f4290c = i10;
        this.f4291d = i11;
        this.f4289b = new byte[((i11 * 2) - 1)];
        this.f4292e = 0;
    }

    public final long a(long j10) {
        int min = (int) Math.min((long) ((this.f4290c + this.f4291d) - this.f4292e), 4);
        this.f4292e += min;
        return (long) min;
    }

    public final int b() {
        return ((g() << 8) & 65280) | (g() & 255);
    }

    public final void c() {
        int i10;
        int i11;
        boolean z10 = false;
        switch (this.f4288a) {
            case 0:
                int i12 = this.f4291d;
                if (i12 >= 0 && (i12 < (i11 = this.f4290c) || (i12 == i11 && this.f4292e == 0))) {
                    z10 = true;
                }
                a.e(z10);
                return;
            default:
                int i13 = this.f4291d;
                if (i13 >= 0 && (i13 < (i10 = this.f4290c) || (i13 == i10 && this.f4292e == 0))) {
                    z10 = true;
                }
                a.e(z10);
                return;
        }
    }

    public final boolean d(int i10) {
        int i11 = this.f4291d;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        int i14 = (this.f4292e + i10) - (i12 * 8);
        if (i14 > 7) {
            i13++;
            i14 -= 8;
        }
        while (true) {
            i11++;
            if (i11 > i13 || i13 >= this.f4290c) {
                int i15 = this.f4290c;
            } else if (k(i11)) {
                i13++;
                i11 += 2;
            }
        }
        int i152 = this.f4290c;
        if (i13 >= i152) {
            return i13 == i152 && i14 == 0;
        }
        return true;
    }

    public final boolean e() {
        int i10 = this.f4291d;
        int i11 = this.f4292e;
        int i12 = 0;
        while (this.f4291d < this.f4290c && !f()) {
            i12++;
        }
        boolean z10 = this.f4291d == this.f4290c;
        this.f4291d = i10;
        this.f4292e = i11;
        return !z10 && d((i12 * 2) + 1);
    }

    public final boolean f() {
        boolean z10 = false;
        switch (this.f4288a) {
            case 0:
                if ((((byte[]) this.f4289b)[this.f4291d] & (128 >> this.f4292e)) != 0) {
                    z10 = true;
                }
                l();
                return z10;
            default:
                if ((((((byte[]) this.f4289b)[this.f4291d] & 255) >> this.f4292e) & 1) == 1) {
                    z10 = true;
                }
                m(1);
                return z10;
        }
    }

    public final int g() {
        int i10 = this.f4292e;
        if (i10 >= this.f4290c + this.f4291d) {
            return -1;
        }
        this.f4292e = i10 + 1;
        return ((byte[]) this.f4289b)[i10];
    }

    public final int h(int i10) {
        switch (this.f4288a) {
            case 0:
                this.f4292e += i10;
                int i11 = 0;
                while (true) {
                    int i12 = this.f4292e;
                    int i13 = 2;
                    if (i12 > 8) {
                        int i14 = i12 - 8;
                        this.f4292e = i14;
                        int i15 = this.f4291d;
                        i11 |= (((byte[]) this.f4289b)[i15] & 255) << i14;
                        if (!k(i15 + 1)) {
                            i13 = 1;
                        }
                        this.f4291d = i15 + i13;
                    } else {
                        int i16 = this.f4291d;
                        int i17 = (-1 >>> (32 - i10)) & (((255 & ((byte[]) this.f4289b)[i16]) >> (8 - i12)) | i11);
                        if (i12 == 8) {
                            this.f4292e = 0;
                            if (!k(i16 + 1)) {
                                i13 = 1;
                            }
                            this.f4291d = i16 + i13;
                        }
                        c();
                        return i17;
                    }
                }
            default:
                int i18 = this.f4291d;
                int min = Math.min(i10, 8 - this.f4292e);
                int i19 = i18 + 1;
                int i20 = ((((byte[]) this.f4289b)[i18] & 255) >> this.f4292e) & (255 >> (8 - min));
                while (min < i10) {
                    i20 |= (((byte[]) this.f4289b)[i19] & 255) << min;
                    min += 8;
                    i19++;
                }
                int i21 = i20 & (-1 >>> (32 - i10));
                m(i10);
                return i21;
        }
    }

    public final int i() {
        int i10 = 0;
        int i11 = 0;
        while (!f()) {
            i11++;
        }
        int i12 = (1 << i11) - 1;
        if (i11 > 0) {
            i10 = h(i11);
        }
        return i12 + i10;
    }

    public final int j() {
        int i10 = i();
        return ((i10 + 1) / 2) * (i10 % 2 == 0 ? -1 : 1);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Cloneable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(int r4) {
        /*
            r3 = this;
            r0 = 2
            if (r0 > r4) goto L_0x0023
            int r0 = r3.f4290c
            if (r4 >= r0) goto L_0x0023
            java.lang.Cloneable r0 = r3.f4289b
            r1 = r0
            byte[] r1 = (byte[]) r1
            byte r1 = r1[r4]
            r2 = 3
            if (r1 != r2) goto L_0x0023
            r1 = r0
            byte[] r1 = (byte[]) r1
            int r2 = r4 + -2
            byte r1 = r1[r2]
            if (r1 != 0) goto L_0x0023
            byte[] r0 = (byte[]) r0
            r1 = 1
            int r4 = r4 - r1
            byte r4 = r0[r4]
            if (r4 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.r0.k(int):boolean");
    }

    public final void l() {
        int i10 = 1;
        int i11 = this.f4292e + 1;
        this.f4292e = i11;
        if (i11 == 8) {
            this.f4292e = 0;
            int i12 = this.f4291d;
            if (k(i12 + 1)) {
                i10 = 2;
            }
            this.f4291d = i12 + i10;
        }
        c();
    }

    public final void m(int i10) {
        switch (this.f4288a) {
            case 0:
                int i11 = this.f4291d;
                int i12 = i10 / 8;
                int i13 = i11 + i12;
                this.f4291d = i13;
                int i14 = (i10 - (i12 * 8)) + this.f4292e;
                this.f4292e = i14;
                if (i14 > 7) {
                    this.f4291d = i13 + 1;
                    this.f4292e = i14 - 8;
                }
                while (true) {
                    i11++;
                    if (i11 > this.f4291d) {
                        c();
                        return;
                    } else if (k(i11)) {
                        this.f4291d++;
                        i11 += 2;
                    }
                }
            default:
                int i15 = i10 / 8;
                int i16 = this.f4291d + i15;
                this.f4291d = i16;
                int i17 = (i10 - (i15 * 8)) + this.f4292e;
                this.f4292e = i17;
                if (i17 > 7) {
                    this.f4291d = i16 + 1;
                    this.f4292e = i17 - 8;
                }
                c();
                return;
        }
    }

    public r0(int i10, int i11, int i12, SparseArray sparseArray) {
        this.f4288a = 4;
        this.f4290c = i10;
        this.f4291d = i11;
        this.f4292e = i12;
        this.f4289b = sparseArray;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Cloneable, byte[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public r0(int r2, int r3, int r4, byte[] r5) {
        /*
            r1 = this;
            r1.f4288a = r4
            r0 = 3
            if (r4 == r0) goto L_0x0015
            r1.<init>()
            r1.f4289b = r5
            r1.f4291d = r2
            r1.f4290c = r3
            r2 = 0
            r1.f4292e = r2
            r1.c()
            return
        L_0x0015:
            r1.<init>()
            r1.f4289b = r5
            r1.f4290c = r2
            r1.f4291d = r3
            r1.f4292e = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.r0.<init>(int, int, int, byte[]):void");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Cloneable, byte[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public r0(byte[] r2) {
        /*
            r1 = this;
            r0 = 1
            r1.f4288a = r0
            r1.<init>()
            r1.f4289b = r2
            int r2 = r2.length
            r1.f4290c = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.r0.<init>(byte[]):void");
    }
}
