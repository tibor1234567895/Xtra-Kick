package t6;

import android.widget.ImageButton;
import com.woxthebox.draglistview.R;
import d9.r0;
import g1.a2;
import g1.b2;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.h;
import g1.h1;
import g1.i1;
import g1.j1;
import g1.k1;
import g1.q;
import g1.s0;
import g1.u1;
import g1.v0;
import g1.y1;
import g1.z0;
import g1.z1;
import hb.h0;
import i1.d;
import java.util.Iterator;
import java.util.List;
import w6.f;
import xa.j;

public final class i implements i1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f14602h;

    public i(l lVar) {
        this.f14602h = lVar;
    }

    public final /* synthetic */ void A(float f10) {
    }

    public final void B(d1 d1Var) {
        j.f("error", d1Var);
        l lVar = this.f14602h;
        if (lVar.M != null) {
            lVar.z0(d1Var);
        }
    }

    public final /* synthetic */ void D(y1 y1Var) {
    }

    public final /* synthetic */ void F(int i10) {
    }

    public final /* synthetic */ void G(long j10) {
    }

    public final /* synthetic */ void K(int i10, int i11) {
    }

    public final /* synthetic */ void L(int i10, s0 s0Var) {
    }

    public final /* synthetic */ void N(e1 e1Var) {
    }

    public final /* synthetic */ void O(g1 g1Var) {
    }

    public final void P(a2 a2Var) {
        boolean z10;
        Object obj;
        boolean z11;
        j.f("tracks", a2Var);
        l lVar = this.f14602h;
        if (lVar.M != null) {
            r0 r0Var = a2Var.f6289h;
            j.e("tracks.groups", r0Var);
            Iterator it = r0Var.iterator();
            while (true) {
                z10 = true;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((z1) obj).f6778i.f6675j == 3) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            if (obj == null) {
                z10 = false;
            }
            l.E0(lVar, z10, false, 2);
            if (!r0Var.isEmpty()) {
                Object d10 = lVar.v0().f14608i.d();
                Boolean bool = Boolean.TRUE;
                if (!j.a(d10, bool)) {
                    lVar.v0().f14608i.l(bool);
                }
            }
        }
    }

    public final void Q(u1 u1Var, int i10) {
        j.f("timeline", u1Var);
    }

    public final /* synthetic */ void R(d dVar) {
    }

    public final /* synthetic */ void S(z0 z0Var) {
    }

    public final /* synthetic */ void V(b2 b2Var) {
    }

    public final /* synthetic */ void X(q qVar) {
    }

    public final void Y(boolean z10) {
        l lVar = this.f14602h;
        if (lVar.M != null && !lVar.t0().getBoolean("player_keep_screen_on_when_paused", false)) {
            lVar.h0().setKeepScreenOn(z10);
        }
    }

    public final /* synthetic */ void a(int i10) {
    }

    public final /* synthetic */ void c(h hVar) {
    }

    public final /* synthetic */ void e(v0 v0Var) {
    }

    public final /* synthetic */ void f(boolean z10) {
    }

    public final /* synthetic */ void g(int i10, boolean z10) {
    }

    public final /* synthetic */ void h(int i10) {
    }

    public final /* synthetic */ void i(long j10) {
    }

    public final /* synthetic */ void j(boolean z10) {
    }

    public final /* synthetic */ void k(int i10) {
    }

    public final void l(k1 k1Var, h1 h1Var) {
        ImageButton imageButton;
        j.f("player", k1Var);
        l lVar = this.f14602h;
        if (lVar.M != null && (lVar instanceof f) && !lVar.t0().getBoolean("player_pause", false)) {
            if (h1Var.f6411a.a(4, 5) && (imageButton = (ImageButton) lVar.h0().findViewById(R.id.exo_play_pause)) != null) {
                if (k1Var.b() == 4 || k1Var.b() == 1 || !k1Var.y()) {
                    imageButton.setVisibility(0);
                } else {
                    h0.J0(imageButton);
                }
            }
        }
    }

    public final /* synthetic */ void m(long j10) {
    }

    public final /* synthetic */ void n(int i10, j1 j1Var, j1 j1Var2) {
    }

    public final /* synthetic */ void q(boolean z10) {
    }

    public final /* synthetic */ void r() {
    }

    public final /* synthetic */ void s() {
    }

    public final /* synthetic */ void t(v0 v0Var) {
    }

    public final /* synthetic */ void u(d1 d1Var) {
    }

    public final /* synthetic */ void v(boolean z10) {
    }

    public final /* synthetic */ void x(List list) {
    }

    public final /* synthetic */ void y(int i10, boolean z10) {
    }

    public final /* synthetic */ void z(int i10, boolean z10) {
    }
}
