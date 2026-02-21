package com.bumptech.glide.integration.webp;

import java.io.InputStream;
import k5.k;
import k5.l;

public final class d implements c, l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3207a;

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f3208b;

    public /* synthetic */ d(InputStream inputStream, int i10) {
        this.f3207a = i10;
        this.f3208b = inputStream;
    }

    public final long a(long j10) {
        int i10 = this.f3207a;
        InputStream inputStream = this.f3208b;
        switch (i10) {
            case 0:
                if (j10 < 0) {
                    return 0;
                }
                long j11 = j10;
                while (j11 > 0) {
                    long skip = inputStream.skip(j11);
                    if (skip > 0) {
                        j11 -= skip;
                    } else if (inputStream.read() == -1) {
                        return j10 - j11;
                    } else {
                        j11--;
                    }
                }
                return j10 - j11;
            default:
                if (j10 < 0) {
                    return 0;
                }
                long j12 = j10;
                while (j12 > 0) {
                    long skip2 = inputStream.skip(j12);
                    if (skip2 > 0) {
                        j12 -= skip2;
                    } else if (inputStream.read() == -1) {
                        return j10 - j12;
                    } else {
                        j12--;
                    }
                }
                return j10 - j12;
        }
    }

    public final int b() {
        int d10;
        short d11;
        switch (this.f3207a) {
            case 0:
                InputStream inputStream = this.f3208b;
                d11 = (inputStream.read() << 8) & 65280;
                d10 = inputStream.read() & 255;
                break;
            default:
                d10 = d() << 8;
                d11 = d();
                break;
        }
        return d10 | d11;
    }

    public final short d() {
        int read = this.f3208b.read();
        if (read != -1) {
            return (short) read;
        }
        throw new k();
    }

    public final int f(int i10, byte[] bArr) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10 && (i12 = this.f3208b.read(bArr, i11, i10 - i11)) != -1) {
            i11 += i12;
        }
        if (i11 != 0 || i12 != -1) {
            return i11;
        }
        throw new k();
    }

    public final int g() {
        return this.f3208b.read();
    }
}
