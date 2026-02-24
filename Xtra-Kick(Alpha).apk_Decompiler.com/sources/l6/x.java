package l6;

import androidx.appcompat.widget.j3;
import com.github.andreyasadchy.xtra.ui.view.CustomSwipeRefreshLayout;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import hb.h0;
import i3.i;
import kb.m0;
import n3.x3;
import pa.e;
import pa.h;
import xa.j;

public abstract class x extends f {

    /* renamed from: j0  reason: collision with root package name */
    public static final /* synthetic */ int f9680j0 = 0;

    public static void p0(x xVar, j3 j3Var, x3 x3Var, m0 m0Var, boolean z10, int i10) {
        boolean z11;
        if ((i10 & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((i10 & 16) != 0) {
            z10 = true;
        }
        xVar.getClass();
        j.f("flow", m0Var);
        h0.b1(h0.v0(xVar.C()), (h) null, 0, new s(m0Var, x3Var, (e) null), 3);
        h0.b1(h0.v0(xVar.C()), (h) null, 0, new u(j3Var, x3Var, (e) null, z11), 3);
        if (z11) {
            ((CustomSwipeRefreshLayout) j3Var.f899f).setEnabled(true);
            ((CustomSwipeRefreshLayout) j3Var.f899f).setOnRefreshListener(new q(x3Var));
        }
        if (z10 && h0.l1(xVar.f0()).getBoolean("ui_scrolltop", true)) {
            ((GridRecyclerView) j3Var.f897d).addOnScrollListener(new v(j3Var, 0, xVar));
            ((FloatingActionButton) j3Var.f898e).setOnClickListener(new i(5, xVar));
        }
        xVar.u().Z(xVar, new q(x3Var));
    }

    public static void q0(GridRecyclerView gridRecyclerView, x3 x3Var) {
        x3Var.registerAdapterDataObserver(new w(x3Var, 0, gridRecyclerView));
        gridRecyclerView.setAdapter(x3Var);
    }
}
