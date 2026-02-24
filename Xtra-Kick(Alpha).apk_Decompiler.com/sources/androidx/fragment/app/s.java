package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

public final class s extends h0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ h0 f1558h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ t f1559i;

    public s(t tVar, w wVar) {
        this.f1559i = tVar;
        this.f1558h = wVar;
    }

    public final View c(int i10) {
        h0 h0Var = this.f1558h;
        if (h0Var.d()) {
            return h0Var.c(i10);
        }
        Dialog dialog = this.f1559i.f1574o0;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    public final boolean d() {
        if (this.f1558h.d() || this.f1559i.f1578s0) {
            return true;
        }
        return false;
    }
}
