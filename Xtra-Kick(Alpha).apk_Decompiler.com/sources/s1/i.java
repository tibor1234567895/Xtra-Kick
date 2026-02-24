package s1;

import com.bumptech.glide.manager.b0;
import g1.a1;
import j1.l0;
import j1.v;

public final class i implements l {
    public final m a(k kVar) {
        int i10 = l0.f8453a;
        if (i10 < 23 || i10 < 31) {
            return new d0().a(kVar);
        }
        int h10 = a1.h(kVar.f14029c.f6276s);
        v.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + l0.y(h10));
        return new b0(h10).a(kVar);
    }
}
