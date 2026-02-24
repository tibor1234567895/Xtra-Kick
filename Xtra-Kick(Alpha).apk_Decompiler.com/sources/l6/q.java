package l6;

import android.os.Bundle;
import androidx.fragment.app.j1;
import n3.x3;
import z3.j;

public final /* synthetic */ class q implements j, j1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ x3 f9659h;

    public /* synthetic */ q(x3 x3Var) {
        this.f9659h = x3Var;
    }

    public final void j(Bundle bundle, String str) {
        int i10 = x.f9680j0;
        x3 x3Var = this.f9659h;
        xa.j.f("$pagingAdapter", x3Var);
        xa.j.f("<anonymous parameter 0>", str);
        if (bundle.getBoolean("refresh")) {
            x3Var.b();
        }
    }
}
