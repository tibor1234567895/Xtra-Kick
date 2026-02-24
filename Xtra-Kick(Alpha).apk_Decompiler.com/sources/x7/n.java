package x7;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import z.b;

public class n extends b {

    /* renamed from: a  reason: collision with root package name */
    public o f16741a;

    /* renamed from: b  reason: collision with root package name */
    public int f16742b = 0;

    public n() {
    }

    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
        u(coordinatorLayout, view, i10);
        if (this.f16741a == null) {
            this.f16741a = new o(view);
        }
        o oVar = this.f16741a;
        View view2 = oVar.f16743a;
        oVar.f16744b = view2.getTop();
        oVar.f16745c = view2.getLeft();
        this.f16741a.a();
        int i11 = this.f16742b;
        if (i11 == 0) {
            return true;
        }
        o oVar2 = this.f16741a;
        if (oVar2.f16746d != i11) {
            oVar2.f16746d = i11;
            oVar2.a();
        }
        this.f16742b = 0;
        return true;
    }

    public final int s() {
        o oVar = this.f16741a;
        if (oVar != null) {
            return oVar.f16746d;
        }
        return 0;
    }

    public int t() {
        return s();
    }

    public void u(CoordinatorLayout coordinatorLayout, View view, int i10) {
        coordinatorLayout.r(view, i10);
    }

    public n(int i10) {
        super(0);
    }
}
