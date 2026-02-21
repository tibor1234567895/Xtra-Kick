package e6;

import com.github.andreyasadchy.xtra.api.KickApi;
import hb.h0;
import hb.p0;
import javax.inject.Inject;
import pa.e;
import xa.j;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public final KickApi f5233a;

    @Inject
    public s0(KickApi kickApi) {
        j.f("api", kickApi);
        this.f5233a = kickApi;
    }

    public final Object a(String str, e eVar) {
        return h0.c2(p0.f7834b, new f0(this, str, (e) null), eVar);
    }
}
