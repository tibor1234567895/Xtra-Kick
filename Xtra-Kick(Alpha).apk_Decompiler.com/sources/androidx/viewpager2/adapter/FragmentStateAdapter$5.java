package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.activity.h;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;

class FragmentStateAdapter$5 implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Handler f2286h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Runnable f2287i;

    public FragmentStateAdapter$5(Handler handler, h hVar) {
        this.f2286h = handler;
        this.f2287i = hVar;
    }

    public final void d(d0 d0Var, r rVar) {
        if (rVar == r.ON_DESTROY) {
            this.f2286h.removeCallbacks(this.f2287i);
            d0Var.o().c(this);
        }
    }
}
