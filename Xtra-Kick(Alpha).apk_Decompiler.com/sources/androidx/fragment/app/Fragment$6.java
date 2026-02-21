package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;

class Fragment$6 implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ c0 f1310h;

    public Fragment$6(c0 c0Var) {
        this.f1310h = c0Var;
    }

    public final void d(d0 d0Var, r rVar) {
        View view;
        if (rVar == r.ON_STOP && (view = this.f1310h.M) != null) {
            view.cancelPendingInputEvents();
        }
    }
}
