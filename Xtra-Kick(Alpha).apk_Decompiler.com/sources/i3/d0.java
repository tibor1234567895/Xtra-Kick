package i3;

import android.view.TextureView;
import android.view.View;
import androidx.media3.ui.SubtitleView;
import com.github.andreyasadchy.xtra.ui.view.CustomPlayerView;
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
import g1.r1;
import g1.s0;
import g1.u1;
import g1.v0;
import g1.y1;
import g1.z0;
import i1.d;
import java.util.List;

public final class d0 implements i1, View.OnLayoutChangeListener, View.OnClickListener, v, l {

    /* renamed from: h  reason: collision with root package name */
    public final r1 f8071h = new r1();

    /* renamed from: i  reason: collision with root package name */
    public Object f8072i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g0 f8073j;

    public d0(CustomPlayerView customPlayerView) {
        this.f8073j = customPlayerView;
    }

    public final /* synthetic */ void A(float f10) {
    }

    public final /* synthetic */ void B(d1 d1Var) {
    }

    public final /* synthetic */ void D(y1 y1Var) {
    }

    public final void F(int i10) {
        g0 g0Var = this.f8073j;
        g0Var.i();
        g0Var.k();
        if (!g0Var.b() || !g0Var.D) {
            g0Var.c(false);
            return;
        }
        w wVar = g0Var.f8086q;
        if (wVar != null) {
            wVar.h();
        }
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
        u1 u1Var;
        Object obj;
        g0 g0Var = this.f8073j;
        k1 k1Var = g0Var.f8089t;
        k1Var.getClass();
        if (k1Var.L0(17)) {
            u1Var = k1Var.j0();
        } else {
            u1Var = u1.f6622h;
        }
        if (!u1Var.y()) {
            boolean L0 = k1Var.L0(30);
            r1 r1Var = this.f8071h;
            if (!L0 || k1Var.D().f6289h.isEmpty()) {
                Object obj2 = this.f8072i;
                if (obj2 != null) {
                    int k10 = u1Var.k(obj2);
                    if (k10 != -1 && k1Var.U() == u1Var.o(k10, r1Var, false).f6544j) {
                        return;
                    }
                }
                g0Var.l(false);
            }
            obj = u1Var.o(k1Var.K(), r1Var, true).f6543i;
            this.f8072i = obj;
            g0Var.l(false);
        }
        obj = null;
        this.f8072i = obj;
        g0Var.l(false);
    }

    public final /* synthetic */ void Q(u1 u1Var, int i10) {
    }

    public final void R(d dVar) {
        SubtitleView subtitleView = this.f8073j.f8083n;
        if (subtitleView != null) {
            subtitleView.setCues(dVar.f7994h);
        }
    }

    public final /* synthetic */ void S(z0 z0Var) {
    }

    public final void V(b2 b2Var) {
        this.f8073j.h();
    }

    public final /* synthetic */ void X(q qVar) {
    }

    public final /* synthetic */ void Y(boolean z10) {
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

    public final /* synthetic */ void l(k1 k1Var, h1 h1Var) {
    }

    public final /* synthetic */ void m(long j10) {
    }

    public final void n(int i10, j1 j1Var, j1 j1Var2) {
        w wVar;
        g0 g0Var = this.f8073j;
        if (g0Var.b() && g0Var.D && (wVar = g0Var.f8086q) != null) {
            wVar.h();
        }
    }

    public final void onClick(View view) {
        this.f8073j.g();
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        g0.a((TextureView) view, this.f8073j.F);
    }

    public final /* synthetic */ void q(boolean z10) {
    }

    public final void r() {
        View view = this.f8073j.f8079j;
        if (view != null) {
            view.setVisibility(4);
        }
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

    public final void z(int i10, boolean z10) {
        g0 g0Var = this.f8073j;
        g0Var.i();
        if (!g0Var.b() || !g0Var.D) {
            g0Var.c(false);
            return;
        }
        w wVar = g0Var.f8086q;
        if (wVar != null) {
            wVar.h();
        }
    }
}
