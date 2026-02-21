package e6;

import a6.b;
import a6.f;
import a6.g;
import a6.z;
import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import hb.d1;
import hb.h0;
import hb.p0;
import javax.inject.Inject;
import pa.e;
import pa.h;
import r3.s0;
import r3.u0;
import xa.j;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final b f5105a;

    /* renamed from: b  reason: collision with root package name */
    public final g f5106b;

    /* renamed from: c  reason: collision with root package name */
    public final z f5107c;

    @Inject
    public e0(b bVar, g gVar, z zVar) {
        j.f("bookmarksDao", bVar);
        j.f("localFollowsChannelDao", gVar);
        j.f("videosDao", zVar);
        this.f5105a = bVar;
        this.f5106b = gVar;
        this.f5107c = zVar;
    }

    public final void a(Context context, Bookmark bookmark) {
        j.f("context", context);
        h0.b1(d1.f7786h, (h) null, 0, new y(bookmark, this, context, (e) null), 3);
    }

    public final Object b(String str, e eVar) {
        return h0.c2(p0.f7834b, new z(this, str, (e) null), eVar);
    }

    public final u0 c() {
        f fVar = (f) this.f5105a;
        fVar.getClass();
        return fVar.f234a.f13722e.b(new String[]{"bookmarks"}, new a6.e(fVar, s0.k(0, "SELECT * FROM bookmarks"), 0));
    }

    public final void d(Bookmark bookmark) {
        h0.b1(d1.f7786h, (h) null, 0, new d0(this, bookmark, (e) null), 3);
    }
}
