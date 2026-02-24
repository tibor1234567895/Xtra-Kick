package androidx.viewpager2.adapter;

import android.widget.FrameLayout;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import java.util.WeakHashMap;
import m0.c1;
import m0.l0;

class FragmentStateAdapter$2 implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ h f2284h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g f2285i;

    public FragmentStateAdapter$2(g gVar, h hVar) {
        this.f2285i = gVar;
        this.f2284h = hVar;
    }

    public final void d(d0 d0Var, r rVar) {
        g gVar = this.f2285i;
        if (!gVar.f2305b.N()) {
            d0Var.o().c(this);
            h hVar = this.f2284h;
            WeakHashMap weakHashMap = c1.f10054a;
            if (l0.b((FrameLayout) hVar.itemView)) {
                gVar.f(hVar);
            }
        }
    }
}
