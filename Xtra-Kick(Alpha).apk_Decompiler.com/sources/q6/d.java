package q6;

import androidx.fragment.app.c0;
import androidx.viewpager2.adapter.g;
import k6.e;
import p7.c;
import xa.j;

public final class d extends g {

    /* renamed from: i  reason: collision with root package name */
    public final c0 f13351i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c0 c0Var) {
        super(c0Var);
        j.f("fragment", c0Var);
        this.f13351i = c0Var;
    }

    public final c0 c(int i10) {
        c0 c0Var;
        if (i10 == 0) {
            c0Var = new c();
        } else if (i10 != 1) {
            c0Var = new e();
        } else {
            c0Var = new j7.d();
        }
        c0Var.j0(this.f13351i.f1357m);
        return c0Var;
    }

    public final int getItemCount() {
        return 3;
    }
}
