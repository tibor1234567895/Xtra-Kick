package m7;

import androidx.lifecycle.v1;
import com.github.andreyasadchy.xtra.model.ui.Video;
import hb.h0;
import l6.x;
import m6.r;
import m6.w;
import m6.z;
import xa.j;

public abstract class c extends x implements r {

    /* renamed from: k0  reason: collision with root package name */
    public Video f10683k0;

    public final void b() {
        Video video = this.f10683k0;
        if (video != null) {
            z.D0.getClass();
            w.a(video).q0(u(), (String) null);
        }
    }

    public final void r0(e eVar, a aVar) {
        j.f("viewModel", eVar);
        if (h0.l1(f0()).getBoolean("player_use_videopositions", true)) {
            eVar.f10690f.f(C(), new v1(21, new b(aVar, 0)));
        }
        eVar.f10691g.f(C(), new v1(21, new b(aVar, 1)));
    }
}
