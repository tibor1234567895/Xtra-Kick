package m7;

import android.content.Context;
import androidx.lifecycle.m0;
import androidx.lifecycle.w1;
import com.github.andreyasadchy.xtra.model.ui.Video;
import e6.e0;
import e6.x;
import e6.z1;
import hb.d1;
import hb.h0;
import pa.h;
import r3.u0;
import xa.j;

public abstract class e extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final e0 f10688d;

    /* renamed from: e  reason: collision with root package name */
    public final x f10689e;

    /* renamed from: f  reason: collision with root package name */
    public final m0 f10690f;

    /* renamed from: g  reason: collision with root package name */
    public final u0 f10691g;

    public e(z1 z1Var, e0 e0Var, x xVar) {
        j.f("playerRepository", z1Var);
        j.f("bookmarksRepository", e0Var);
        j.f("repository", xVar);
        this.f10688d = e0Var;
        this.f10689e = xVar;
        this.f10690f = z1Var.c();
        this.f10691g = e0Var.c();
    }

    public final void d(Context context, Video video) {
        j.f("video", video);
        h0.b1(d1.f7786h, (h) null, 0, new d(video, this, context, (pa.e) null), 3);
    }
}
