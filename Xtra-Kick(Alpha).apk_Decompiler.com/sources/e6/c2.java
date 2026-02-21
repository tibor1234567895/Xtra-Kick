package e6;

import a6.t;
import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import hb.h0;
import hb.p0;
import javax.inject.Inject;
import la.v;
import pa.e;
import qa.a;
import xa.j;

public final class c2 {

    /* renamed from: a  reason: collision with root package name */
    public final t f5094a;

    @Inject
    public c2(t tVar) {
        j.f("sortChannelDao", tVar);
        this.f5094a = tVar;
    }

    public final Object a(String str, e eVar) {
        return h0.c2(p0.f7834b, new a2(this, str, (e) null), eVar);
    }

    public final Object b(SortChannel sortChannel, e eVar) {
        Object c22 = h0.c2(p0.f7834b, new b2(this, sortChannel, (e) null), eVar);
        if (c22 == a.COROUTINE_SUSPENDED) {
            return c22;
        }
        return v.f9814a;
    }
}
