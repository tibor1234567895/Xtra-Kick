package d2;

import g1.t0;
import j1.l0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class p implements w {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f4271a = new byte[4096];

    /* renamed from: b  reason: collision with root package name */
    public final g1.p f4272b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4273c;

    /* renamed from: d  reason: collision with root package name */
    public long f4274d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f4275e = new byte[65536];

    /* renamed from: f  reason: collision with root package name */
    public int f4276f;

    /* renamed from: g  reason: collision with root package name */
    public int f4277g;

    static {
        t0.a("media3.extractor");
    }

    public p(g1.p pVar, long j10, long j11) {
        this.f4272b = pVar;
        this.f4274d = j10;
        this.f4273c = j11;
    }

    public final int a(int i10) {
        int min = Math.min(this.f4277g, i10);
        t(min);
        if (min == 0) {
            byte[] bArr = this.f4271a;
            min = s(bArr, 0, Math.min(i10, bArr.length), 0, true);
        }
        if (min != -1) {
            this.f4274d += (long) min;
        }
        return min;
    }

    public final boolean b(byte[] bArr, int i10, int i11, boolean z10) {
        int i12;
        int i13 = this.f4277g;
        if (i13 == 0) {
            i12 = 0;
        } else {
            i12 = Math.min(i13, i11);
            System.arraycopy(this.f4275e, 0, bArr, i10, i12);
            t(i12);
        }
        int i14 = i12;
        while (i14 < i11 && i14 != -1) {
            i14 = s(bArr, i10, i11, i14, z10);
        }
        if (i14 != -1) {
            this.f4274d += (long) i14;
        }
        if (i14 != -1) {
            return true;
        }
        return false;
    }

    public final long c() {
        return this.f4273c;
    }

    public final int d(byte[] bArr, int i10, int i11) {
        int i12;
        r(i11);
        int i13 = this.f4277g;
        int i14 = this.f4276f;
        int i15 = i13 - i14;
        if (i15 == 0) {
            i12 = s(this.f4275e, i14, i11, 0, true);
            if (i12 == -1) {
                return -1;
            }
            this.f4277g += i12;
        } else {
            i12 = Math.min(i11, i15);
        }
        System.arraycopy(this.f4275e, this.f4276f, bArr, i10, i12);
        this.f4276f += i12;
        return i12;
    }

    public final void f() {
        this.f4276f = 0;
    }

    public final void g(int i10) {
        int min = Math.min(this.f4277g, i10);
        t(min);
        int i11 = min;
        while (i11 < i10 && i11 != -1) {
            i11 = s(this.f4271a, -i11, Math.min(i10, this.f4271a.length + i11), i11, false);
        }
        if (i11 != -1) {
            this.f4274d += (long) i11;
        }
    }

    public final boolean h(int i10, boolean z10) {
        r(i10);
        int i11 = this.f4277g - this.f4276f;
        while (i11 < i10) {
            i11 = s(this.f4275e, this.f4276f, i10, i11, z10);
            if (i11 == -1) {
                return false;
            }
            this.f4277g = this.f4276f + i11;
        }
        this.f4276f += i10;
        return true;
    }

    public final boolean k(byte[] bArr, int i10, int i11, boolean z10) {
        if (!h(i11, z10)) {
            return false;
        }
        System.arraycopy(this.f4275e, this.f4276f - i11, bArr, i10, i11);
        return true;
    }

    public final long l() {
        return this.f4274d + ((long) this.f4276f);
    }

    public final void m(byte[] bArr, int i10, int i11) {
        k(bArr, i10, i11, false);
    }

    public final void n(int i10) {
        h(i10, false);
    }

    public final int o(byte[] bArr, int i10, int i11) {
        int i12 = this.f4277g;
        int i13 = 0;
        if (i12 != 0) {
            int min = Math.min(i12, i11);
            System.arraycopy(this.f4275e, 0, bArr, i10, min);
            t(min);
            i13 = min;
        }
        if (i13 == 0) {
            i13 = s(bArr, i10, i11, 0, true);
        }
        if (i13 != -1) {
            this.f4274d += (long) i13;
        }
        return i13;
    }

    public final long p() {
        return this.f4274d;
    }

    public final void r(int i10) {
        int i11 = this.f4276f + i10;
        byte[] bArr = this.f4275e;
        if (i11 > bArr.length) {
            this.f4275e = Arrays.copyOf(this.f4275e, l0.h(bArr.length * 2, 65536 + i11, i11 + 524288));
        }
    }

    public final void readFully(byte[] bArr, int i10, int i11) {
        b(bArr, i10, i11, false);
    }

    public final int s(byte[] bArr, int i10, int i11, int i12, boolean z10) {
        if (!Thread.interrupted()) {
            int o10 = this.f4272b.o(bArr, i10 + i12, i11 - i12);
            if (o10 != -1) {
                return i12 + o10;
            }
            if (i12 == 0 && z10) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    public final void t(int i10) {
        int i11 = this.f4277g - i10;
        this.f4277g = i11;
        this.f4276f = 0;
        byte[] bArr = this.f4275e;
        byte[] bArr2 = i11 < bArr.length - 524288 ? new byte[(65536 + i11)] : bArr;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        this.f4275e = bArr2;
    }
}
