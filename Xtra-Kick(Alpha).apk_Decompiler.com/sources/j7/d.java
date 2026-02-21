package j7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import g7.g;
import h6.l;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import i7.c;
import j3.j;
import l6.c0;
import l6.x;
import la.e;
import xa.v;
import z5.f;

public final class d extends a implements c0, g {

    /* renamed from: t0  reason: collision with root package name */
    public static final /* synthetic */ int f8833t0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public f f8834p0;

    /* renamed from: q0  reason: collision with root package name */
    public final j f8835q0 = new j(v.a(q6.f.class), new g(2, this));

    /* renamed from: r0  reason: collision with root package name */
    public final x1 f8836r0;

    /* renamed from: s0  reason: collision with root package name */
    public c f8837s0;

    public d() {
        e a10 = la.f.a(new l(new g(3, this), 23));
        this.f8836r0 = h0.K(this, v.a(StreamsViewModel.class), new m(a10, 23), new n(a10, 23), new o(this, a10, 23));
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        xa.j.f("inflater", layoutInflater);
        f b10 = f.b(layoutInflater, viewGroup);
        this.f8834p0 = b10;
        LinearLayout linearLayout = b10.f17637a;
        xa.j.e("binding.root", linearLayout);
        return linearLayout;
    }

    public final void Q() {
        super.Q();
        this.f8834p0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        c cVar;
        xa.j.f("view", view);
        boolean z10 = false;
        boolean z11 = true;
        if (xa.j.a(h0.l1(f0()).getString("compactStreamsV2", "disabled"), "all")) {
            q6.f s02 = s0();
            if (!(s0().f13353a == 0 && s0().f13354b == null)) {
                z10 = true;
            }
            cVar = new c(this, s02, z10, 1);
        } else {
            q6.f s03 = s0();
            if (s0().f13353a == 0 && s0().f13354b == null) {
                z11 = false;
            }
            cVar = new c(this, s03, z11, 0);
        }
        this.f8837s0 = cVar;
        f fVar = this.f8834p0;
        xa.j.c(fVar);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) fVar.f17638b.f897d;
        xa.j.e("binding.recyclerViewLayout.recyclerView", gridRecyclerView);
        c cVar2 = this.f8837s0;
        if (cVar2 != null) {
            x.q0(gridRecyclerView, cVar2);
        } else {
            xa.j.l("pagingAdapter");
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m0() {
        /*
            r9 = this;
            z5.f r0 = r9.f8834p0
            xa.j.c(r0)
            java.lang.String r1 = "binding.recyclerViewLayout"
            androidx.appcompat.widget.j3 r3 = r0.f17638b
            xa.j.e(r1, r3)
            i7.c r4 = r9.f8837s0
            if (r4 == 0) goto L_0x0087
            androidx.lifecycle.x1 r0 = r9.f8836r0
            java.lang.Object r0 = r0.getValue()
            com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel r0 = (com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel) r0
            kb.m0 r5 = r0.f3509g
            q6.f r0 = r9.s0()
            int r0 = r0.f13353a
            r1 = 1
            r8 = 0
            if (r0 != 0) goto L_0x0045
            q6.f r0 = r9.s0()
            java.lang.String r0 = r0.f13354b
            if (r0 != 0) goto L_0x0045
            q6.f r0 = r9.s0()
            java.lang.String[] r0 = r0.f13357e
            if (r0 == 0) goto L_0x003f
            int r0 = r0.length
            if (r0 != 0) goto L_0x0039
            r0 = 1
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            if (r0 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r0 = 0
            goto L_0x0040
        L_0x003f:
            r0 = 1
        L_0x0040:
            if (r0 != 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r6 = 0
            goto L_0x0046
        L_0x0045:
            r6 = 1
        L_0x0046:
            r7 = 8
            r2 = r9
            l6.x.p0(r2, r3, r4, r5, r6, r7)
            z5.f r0 = r9.f8834p0
            xa.j.c(r0)
            l.h r0 = r0.f17639c
            java.lang.Object r2 = r0.f9447i
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            java.lang.String r3 = "sortBar.root"
            xa.j.e(r3, r2)
            r2.setVisibility(r8)
            q6.f r2 = r9.s0()
            int r2 = r2.f13353a
            java.lang.Object r0 = r0.f9447i
            if (r2 == 0) goto L_0x007c
            q6.f r2 = r9.s0()
            java.lang.String r2 = r2.f13354b
            if (r2 == 0) goto L_0x007c
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            j7.b r1 = new j7.b
            r1.<init>(r9, r8)
            r0.setOnClickListener(r1)
            goto L_0x0086
        L_0x007c:
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            j7.b r2 = new j7.b
            r2.<init>(r9, r1)
            r0.setOnClickListener(r2)
        L_0x0086:
            return
        L_0x0087:
            java.lang.String r0 = "pagingAdapter"
            xa.j.l(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j7.d.m0():void");
    }

    public final void n() {
        f fVar = this.f8834p0;
        xa.j.c(fVar);
        ((GridRecyclerView) fVar.f17638b.f897d).scrollToPosition(0);
    }

    public final void o0() {
        c cVar = this.f8837s0;
        if (cVar != null) {
            cVar.c();
        } else {
            xa.j.l("pagingAdapter");
            throw null;
        }
    }

    public final q6.f s0() {
        return (q6.f) this.f8835q0.getValue();
    }
}
