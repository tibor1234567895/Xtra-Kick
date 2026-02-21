package com.bumptech.glide.load.data;

import android.support.v4.media.h;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class j extends FilterInputStream {

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f3227j = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: k  reason: collision with root package name */
    public static final int f3228k = 31;

    /* renamed from: h  reason: collision with root package name */
    public final byte f3229h;

    /* renamed from: i  reason: collision with root package name */
    public int f3230i;

    public j(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 < -1 || i10 > 8) {
            throw new IllegalArgumentException(h.i("Cannot add invalid orientation: ", i10));
        }
        this.f3229h = (byte) i10;
    }

    public final void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() {
        int i10;
        int i11 = this.f3230i;
        int read = (i11 < 2 || i11 > (i10 = f3228k)) ? super.read() : i11 == i10 ? this.f3229h : f3227j[i11 - 2] & 255;
        if (read != -1) {
            this.f3230i++;
        }
        return read;
    }

    public final void reset() {
        throw new UnsupportedOperationException();
    }

    public final long skip(long j10) {
        long skip = super.skip(j10);
        if (skip > 0) {
            this.f3230i = (int) (((long) this.f3230i) + skip);
        }
        return skip;
    }

    public final int read(byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = this.f3230i;
        int i14 = f3228k;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.f3229h;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int min = Math.min(i14 - i13, i11);
            System.arraycopy(f3227j, this.f3230i - 2, bArr, i10, min);
            i12 = min;
        }
        if (i12 > 0) {
            this.f3230i += i12;
        }
        return i12;
    }
}
