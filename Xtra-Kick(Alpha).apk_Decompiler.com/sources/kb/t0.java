package kb;

import android.support.v4.media.h;
import h3.u1;
import jb.a;

public abstract class t0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f9395a = new u1("NO_VALUE", 2);

    public static final s0 a(int i10, int i11, a aVar) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i10 > 0 || i11 > 0 || aVar == a.SUSPEND) {
                    z12 = true;
                }
                if (z12) {
                    int i12 = i11 + i10;
                    if (i12 < 0) {
                        i12 = Integer.MAX_VALUE;
                    }
                    return new s0(i10, i12, aVar);
                }
                throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + aVar).toString());
            }
            throw new IllegalArgumentException(h.i("extraBufferCapacity cannot be negative, but was ", i11).toString());
        }
        throw new IllegalArgumentException(h.i("replay cannot be negative, but was ", i10).toString());
    }
}
