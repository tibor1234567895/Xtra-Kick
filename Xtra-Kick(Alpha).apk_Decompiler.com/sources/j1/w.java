package j1;

import android.support.v4.media.h;
import java.util.Arrays;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public int f8479a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f8480b = new long[32];

    public final void a(long j10) {
        int i10 = this.f8479a;
        long[] jArr = this.f8480b;
        if (i10 == jArr.length) {
            this.f8480b = Arrays.copyOf(jArr, i10 * 2);
        }
        long[] jArr2 = this.f8480b;
        int i11 = this.f8479a;
        this.f8479a = i11 + 1;
        jArr2[i11] = j10;
    }

    public final long b(int i10) {
        if (i10 >= 0 && i10 < this.f8479a) {
            return this.f8480b[i10];
        }
        StringBuilder r10 = h.r("Invalid index ", i10, ", size is ");
        r10.append(this.f8479a);
        throw new IndexOutOfBoundsException(r10.toString());
    }
}
