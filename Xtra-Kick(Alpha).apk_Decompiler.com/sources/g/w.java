package g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
import m0.c1;
import m0.m0;
import m0.o1;
import m0.p1;

public final class w extends p1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6221a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f6222b;

    public /* synthetic */ w(int i10, Object obj) {
        this.f6221a = i10;
        this.f6222b = obj;
    }

    public final void a() {
        int i10 = this.f6221a;
        Object obj = this.f6222b;
        switch (i10) {
            case 0:
                u uVar = (u) obj;
                uVar.f6218i.C.setAlpha(1.0f);
                k0 k0Var = uVar.f6218i;
                k0Var.F.d((o1) null);
                k0Var.F = null;
                return;
            case 1:
                k0 k0Var2 = (k0) obj;
                k0Var2.C.setAlpha(1.0f);
                k0Var2.F.d((o1) null);
                k0Var2.F = null;
                return;
            default:
                x xVar = (x) obj;
                xVar.f6232i.C.setVisibility(8);
                k0 k0Var3 = xVar.f6232i;
                PopupWindow popupWindow = k0Var3.D;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (k0Var3.C.getParent() instanceof View) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    m0.c((View) k0Var3.C.getParent());
                }
                k0Var3.C.e();
                k0Var3.F.d((o1) null);
                k0Var3.F = null;
                ViewGroup viewGroup = k0Var3.I;
                WeakHashMap weakHashMap2 = c1.f10054a;
                m0.c(viewGroup);
                return;
        }
    }

    public final void c() {
        int i10 = this.f6221a;
        Object obj = this.f6222b;
        switch (i10) {
            case 0:
                ((u) obj).f6218i.C.setVisibility(0);
                return;
            case 1:
                k0 k0Var = (k0) obj;
                k0Var.C.setVisibility(0);
                if (k0Var.C.getParent() instanceof View) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    m0.c((View) k0Var.C.getParent());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
