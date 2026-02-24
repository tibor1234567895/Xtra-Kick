package androidx.fragment.app;

import android.support.v4.media.h;
import android.view.View;

public final class w extends h0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ c0 f1591h;

    public w(c0 c0Var) {
        this.f1591h = c0Var;
    }

    public final View c(int i10) {
        c0 c0Var = this.f1591h;
        View view = c0Var.M;
        if (view != null) {
            return view.findViewById(i10);
        }
        throw new IllegalStateException(h.l("Fragment ", c0Var, " does not have a view"));
    }

    public final boolean d() {
        return this.f1591h.M != null;
    }
}
