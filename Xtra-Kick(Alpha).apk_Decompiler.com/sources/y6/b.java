package y6;

import a7.e;
import androidx.fragment.app.c0;
import androidx.viewpager2.adapter.g;
import d7.f;
import g7.h;
import hb.h0;
import la.i;
import r7.q;
import xa.j;

public final class b extends g {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f17073i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i10, c0 c0Var) {
        super(c0Var);
        this.f17073i = i10;
        if (i10 == 1) {
            j.f("fragment", c0Var);
            super(c0Var);
        } else if (i10 != 2) {
            j.f("fragment", c0Var);
        } else {
            super(c0Var);
        }
    }

    public final c0 c(int i10) {
        switch (this.f17073i) {
            case 0:
                if (i10 == 0) {
                    return new z6.g();
                }
                return new e();
            case 1:
                if (i10 == 0) {
                    return new h();
                }
                if (i10 == 1) {
                    return new e7.g();
                }
                if (i10 != 2) {
                    return new f();
                }
                return new c7.h();
            default:
                q.f13858l0.getClass();
                q qVar = new q();
                qVar.j0(h0.r(new i("position", Integer.valueOf(i10))));
                return qVar;
        }
    }

    public final int getItemCount() {
        switch (this.f17073i) {
            case 0:
                return 2;
            case 1:
                return 4;
            default:
                return 3;
        }
    }
}
