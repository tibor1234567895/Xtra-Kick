package o1;

import h1.a;
import h1.b;
import java.nio.ByteBuffer;

public final class r extends q {

    /* renamed from: i  reason: collision with root package name */
    public int[] f12037i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f12038j;

    public final void e(ByteBuffer byteBuffer) {
        int[] iArr = this.f12038j;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer l10 = l(((limit - position) / this.f12030b.f6881d) * this.f12031c.f6881d);
        while (position < limit) {
            for (int i10 : iArr) {
                l10.putShort(byteBuffer.getShort((i10 * 2) + position));
            }
            position += this.f12030b.f6881d;
        }
        byteBuffer.position(limit);
        l10.flip();
    }

    public final a h(a aVar) {
        int[] iArr = this.f12037i;
        if (iArr == null) {
            return a.f6877e;
        }
        if (aVar.f6880c == 2) {
            int length = iArr.length;
            int i10 = aVar.f6879b;
            boolean z10 = i10 != length;
            int i11 = 0;
            while (i11 < iArr.length) {
                int i12 = iArr[i11];
                if (i12 < i10) {
                    z10 |= i12 != i11;
                    i11++;
                } else {
                    throw new b(aVar);
                }
            }
            return z10 ? new a(aVar.f6878a, iArr.length, 2) : a.f6877e;
        }
        throw new b(aVar);
    }

    public final void i() {
        this.f12038j = this.f12037i;
    }

    public final void k() {
        this.f12038j = null;
        this.f12037i = null;
    }
}
