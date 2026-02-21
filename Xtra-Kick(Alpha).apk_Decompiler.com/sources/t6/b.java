package t6;

import android.os.Bundle;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
import com.woxthebox.draglistview.R;
import h3.b0;
import h3.c0;
import h3.f4;
import h9.e0;
import h9.q;
import xa.j;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14571h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f14572i;

    public /* synthetic */ b(l lVar, int i10) {
        this.f14571h = i10;
        this.f14572i = lVar;
    }

    public final void run() {
        int i10 = this.f14571h;
        l lVar = this.f14572i;
        switch (i10) {
            case 0:
                f fVar = l.f14620w0;
                j.f("this$0", lVar);
                if (lVar.u0().f3546v) {
                    lVar.x0();
                    return;
                } else {
                    lVar.J0();
                    return;
                }
            default:
                f fVar2 = l.f14620w0;
                j.f("this$0", lVar);
                c0 c0Var = lVar.f14623j0;
                if (c0Var != null) {
                    b0 b0Var = (b0) c0Var.get();
                    CustomPlayerView customPlayerView = (CustomPlayerView) lVar.h0().findViewById(R.id.playerView);
                    if (customPlayerView != null) {
                        customPlayerView.setPlayer(b0Var);
                    }
                    b0Var.x0(new i(lVar));
                    if (lVar.v0().f14606g) {
                        lVar.v0().f14606g = false;
                        Bundle bundle = Bundle.EMPTY;
                        e0 T0 = b0Var.T0(new f4(bundle, "moveForeground"), bundle);
                        T0.a(new c(T0, lVar, 2), q.f7765h);
                    }
                    if (!lVar.v0().f14605f) {
                        Bundle bundle2 = Bundle.EMPTY;
                        b0Var.T0(new f4(bundle2, "clear"), bundle2);
                        if (lVar.f9598h0 || !lVar.f9595e0) {
                            lVar.L0();
                            return;
                        }
                        return;
                    }
                    return;
                }
                j.l("controllerFuture");
                throw null;
        }
    }
}
