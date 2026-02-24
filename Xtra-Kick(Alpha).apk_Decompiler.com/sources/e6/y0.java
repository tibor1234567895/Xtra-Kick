package e6;

import a6.b;
import a6.g;
import a6.z;
import hb.h0;
import hb.p0;
import javax.inject.Inject;
import pa.e;
import xa.j;

public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final g f5273a;

    /* renamed from: b  reason: collision with root package name */
    public final z f5274b;

    /* renamed from: c  reason: collision with root package name */
    public final b f5275c;

    @Inject
    public y0(g gVar, z zVar, b bVar) {
        j.f("localFollowsChannelDao", gVar);
        j.f("videosDao", zVar);
        j.f("bookmarksDao", bVar);
        this.f5273a = gVar;
        this.f5274b = zVar;
        this.f5275c = bVar;
    }

    public final Object a(int i10, e eVar) {
        return h0.c2(p0.f7834b, new u0(this, i10, (e) null), eVar);
    }
}
