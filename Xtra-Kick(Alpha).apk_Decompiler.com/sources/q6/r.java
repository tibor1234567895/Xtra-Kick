package q6;

import android.view.View;
import b7.d;
import b7.e;
import com.github.andreyasadchy.xtra.ui.games.GamesFragment;
import f7.l;
import f7.m;
import hb.h0;
import j3.k0;
import xa.j;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13388h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GamesFragment f13389i;

    public /* synthetic */ r(GamesFragment gamesFragment, int i10) {
        this.f13388h = i10;
        this.f13389i = gamesFragment;
    }

    public final void onClick(View view) {
        int i10 = this.f13388h;
        GamesFragment gamesFragment = this.f13389i;
        switch (i10) {
            case 0:
                int i11 = GamesFragment.f3425t0;
                j.f("this$0", gamesFragment);
                k0 V = h0.V(gamesFragment);
                e.f2652a.getClass();
                V.m(d.a());
                return;
            default:
                int i12 = GamesFragment.f3425t0;
                j.f("this$0", gamesFragment);
                h0.V(gamesFragment).m(l.a(m.f5938a, 0, (String) null, true, 15));
                return;
        }
    }
}
