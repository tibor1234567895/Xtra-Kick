package e6;

import a6.b;
import a6.g;
import a6.p;
import a6.z;
import android.content.Context;
import com.github.andreyasadchy.xtra.XtraApp;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import hb.d1;
import hb.h0;
import javax.inject.Inject;
import pa.e;
import pa.h;
import xa.j;
import y5.v;

public final class o1 {

    /* renamed from: a  reason: collision with root package name */
    public final z f5207a;

    /* renamed from: b  reason: collision with root package name */
    public final p f5208b;

    /* renamed from: c  reason: collision with root package name */
    public final g f5209c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5210d;

    @Inject
    public o1(z zVar, p pVar, g gVar, b bVar) {
        j.f("videosDao", zVar);
        j.f("requestsDao", pVar);
        j.f("localFollowsChannelDao", gVar);
        j.f("bookmarksDao", bVar);
        this.f5207a = zVar;
        this.f5208b = pVar;
        this.f5209c = gVar;
        this.f5210d = bVar;
    }

    public final void a(Context context, OfflineVideo offlineVideo) {
        h0.b1(d1.f7786h, (h) null, 0, new g1(offlineVideo, this, context, (e) null), 3);
    }

    public final void b(OfflineVideo offlineVideo) {
        h0.b1(d1.f7786h, (h) null, 0, new m1(this, offlineVideo, (e) null), 3);
    }

    public final void c(int i10, long j10) {
        XtraApp.f3319k.getClass();
        Context applicationContext = v.a().getApplicationContext();
        j.e("appContext", applicationContext);
        if (h0.l1(applicationContext).getBoolean("player_use_videopositions", true)) {
            h0.b1(d1.f7786h, (h) null, 0, new n1(this, i10, j10, (e) null), 3);
        }
    }
}
