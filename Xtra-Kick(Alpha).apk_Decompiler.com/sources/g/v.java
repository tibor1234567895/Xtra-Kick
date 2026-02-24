package g;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.appcompat.widget.d2;
import androidx.appcompat.widget.p2;
import e0.d;
import java.util.WeakHashMap;
import m.b0;
import m.o;
import m0.c1;
import m0.e2;
import m0.f2;
import m0.g2;
import m0.m0;
import m0.q2;
import m0.y;

public final class v implements y, p2, d2, b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6219h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k0 f6220i;

    public /* synthetic */ v(k0 k0Var, int i10) {
        this.f6219h = i10;
        this.f6220i = k0Var;
    }

    public final q2 A(View view, q2 q2Var) {
        g2 g2Var;
        int e10 = q2Var.e();
        int a02 = this.f6220i.a0(q2Var, (Rect) null);
        if (e10 != a02) {
            int c10 = q2Var.c();
            int d10 = q2Var.d();
            int b10 = q2Var.b();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                g2Var = new f2(q2Var);
            } else if (i10 >= 29) {
                g2Var = new e2(q2Var);
            } else {
                g2Var = new m0.d2(q2Var);
            }
            g2Var.g(d.b(c10, a02, d10, b10));
            q2Var = g2Var.b();
        }
        WeakHashMap weakHashMap = c1.f10054a;
        WindowInsets g10 = q2Var.g();
        if (g10 == null) {
            return q2Var;
        }
        WindowInsets b11 = m0.b(view, g10);
        if (!b11.equals(g10)) {
            return q2.h(view, b11);
        }
        return q2Var;
    }

    public final void a(o oVar, boolean z10) {
        boolean z11;
        int i10;
        j0 j0Var;
        int i11 = this.f6219h;
        k0 k0Var = this.f6220i;
        switch (i11) {
            case 3:
                k0Var.H(oVar);
                return;
            default:
                o k10 = oVar.k();
                int i12 = 0;
                if (k10 != oVar) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    oVar = k10;
                }
                j0[] j0VarArr = k0Var.T;
                if (j0VarArr != null) {
                    i10 = j0VarArr.length;
                } else {
                    i10 = 0;
                }
                while (true) {
                    if (i12 >= i10) {
                        j0Var = null;
                    } else {
                        j0Var = j0VarArr[i12];
                        if (j0Var == null || j0Var.f6112h != oVar) {
                            i12++;
                        }
                    }
                }
                if (j0Var == null) {
                    return;
                }
                if (z11) {
                    k0Var.G(j0Var.f6105a, j0Var, k10);
                    k0Var.I(j0Var, true);
                    return;
                }
                k0Var.I(j0Var, z10);
                return;
        }
    }

    public final boolean n(o oVar) {
        Window.Callback R;
        int i10 = this.f6219h;
        k0 k0Var = this.f6220i;
        switch (i10) {
            case 3:
                Window.Callback R2 = k0Var.R();
                if (R2 != null) {
                    R2.onMenuOpened(108, oVar);
                }
                return true;
            default:
                if (oVar == oVar.k() && k0Var.N && (R = k0Var.R()) != null && !k0Var.Y) {
                    R.onMenuOpened(108, oVar);
                }
                return true;
        }
    }
}
