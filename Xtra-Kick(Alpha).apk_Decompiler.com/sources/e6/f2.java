package e6;

import a6.v;
import com.github.andreyasadchy.xtra.model.offline.SortGame;
import hb.h0;
import hb.p0;
import javax.inject.Inject;
import pa.e;
import qa.a;
import xa.j;

public final class f2 {

    /* renamed from: a  reason: collision with root package name */
    public final v f5121a;

    @Inject
    public f2(v vVar) {
        j.f("sortGameDao", vVar);
        this.f5121a = vVar;
    }

    public final Object a(String str, e eVar) {
        return h0.c2(p0.f7834b, new d2(this, str, (e) null), eVar);
    }

    public final Object b(SortGame sortGame, e eVar) {
        Object c22 = h0.c2(p0.f7834b, new e2(this, sortGame, (e) null), eVar);
        if (c22 == a.COROUTINE_SUSPENDED) {
            return c22;
        }
        return la.v.f9814a;
    }
}
