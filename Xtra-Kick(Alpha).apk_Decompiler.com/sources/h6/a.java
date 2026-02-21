package h6;

import androidx.fragment.app.c0;
import androidx.viewpager2.adapter.g;
import i6.e;
import xa.j;

public final class a extends g {

    /* renamed from: i  reason: collision with root package name */
    public final c0 f7630i;

    /* renamed from: j  reason: collision with root package name */
    public final q f7631j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c0 c0Var, q qVar) {
        super(c0Var);
        j.f("fragment", c0Var);
        j.f("args", qVar);
        this.f7630i = c0Var;
        this.f7631j = qVar;
    }

    public final c0 c(int i10) {
        c0 c0Var;
        if (i10 == 0) {
            c0Var = new n7.g();
        } else if (i10 != 1) {
            i6.a aVar = e.f8314q0;
            q qVar = this.f7631j;
            int i11 = qVar.f7680a;
            aVar.getClass();
            return i6.a.a(i11, qVar.f7685f, qVar.f7681b, qVar.f7682c);
        } else {
            c0Var = new k6.e();
        }
        c0Var.j0(this.f7630i.f1357m);
        return c0Var;
    }

    public final int getItemCount() {
        return 3;
    }
}
