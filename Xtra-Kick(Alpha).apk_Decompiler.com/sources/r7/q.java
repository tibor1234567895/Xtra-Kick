package r7;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.k0;
import androidx.lifecycle.p1;
import androidx.lifecycle.x1;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n1;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridAutofitLayoutManager;
import com.woxthebox.draglistview.R;
import h6.l;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i6.c;
import la.e;
import la.f;
import n3.o3;
import xa.j;
import xa.v;

public final class q extends s {

    /* renamed from: l0  reason: collision with root package name */
    public static final p f13858l0 = new p(0);

    /* renamed from: i0  reason: collision with root package name */
    public o3 f13859i0;

    /* renamed from: j0  reason: collision with root package name */
    public GridAutofitLayoutManager f13860j0;

    /* renamed from: k0  reason: collision with root package name */
    public final x1 f13861k0;

    public q() {
        e a10 = f.a(new l(new p1(20, this), 28));
        this.f13861k0 = h0.K(this, v.a(ChatViewModel.class), new m(a10, 28), new n(a10, 28), new o(this, a10, 28));
    }

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        this.f13859i0 = new o3((i6.e) g0());
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        return layoutInflater.inflate(R.layout.fragment_emotes, viewGroup, false);
    }

    public final void Z(View view, Bundle bundle) {
        k0 k0Var;
        j.f("view", view);
        Context f02 = f0();
        Bundle e02 = e0();
        String str = "4";
        String string = h0.l1(f02).getString("chat_image_quality", str);
        if (string != null) {
            str = string;
        }
        o3 o3Var = this.f13859i0;
        if (o3Var != null) {
            o oVar = new o(this, o3Var, str);
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setItemAnimator((n1) null);
            recyclerView.setAdapter(oVar);
            GridAutofitLayoutManager gridAutofitLayoutManager = new GridAutofitLayoutManager(f02, h0.E(f02, 50.0f));
            this.f13860j0 = gridAutofitLayoutManager;
            recyclerView.setLayoutManager(gridAutofitLayoutManager);
            c cVar = new c(7, oVar);
            int i10 = e02.getInt("position");
            x1 x1Var = this.f13861k0;
            if (i10 == 0) {
                k0Var = (k0) ((ChatViewModel) x1Var.getValue()).f3352i.getValue();
            } else if (i10 != 1) {
                k0Var = ((ChatViewModel) x1Var.getValue()).f3354k;
            } else {
                k0Var = ((ChatViewModel) x1Var.getValue()).f3353j;
            }
            k0Var.f(C(), cVar);
            return;
        }
        j.l("listener");
        throw null;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        j.f("newConfig", configuration);
        this.K = true;
        GridAutofitLayoutManager gridAutofitLayoutManager = this.f13860j0;
        if (gridAutofitLayoutManager != null) {
            gridAutofitLayoutManager.U = true;
        } else {
            j.l("layoutManager");
            throw null;
        }
    }
}
