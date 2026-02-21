package m;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.r2;
import androidx.appcompat.widget.z;

public final class b extends r2 {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f9902q = 0;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ View f9903r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f9903r = actionMenuItemView;
    }

    public final g0 b() {
        int i10 = this.f9902q;
        View view = this.f9903r;
        switch (i10) {
            case 0:
                c cVar = ((ActionMenuItemView) view).f551t;
                if (cVar != null) {
                    return cVar.a();
                }
                return null;
            default:
                return ((z) view).getListPopupWindow();
        }
    }

    public final boolean c() {
        g0 b10;
        int i10 = this.f9902q;
        View view = this.f9903r;
        switch (i10) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
                n nVar = actionMenuItemView.f549r;
                if (nVar == null || !nVar.d(actionMenuItemView.f546o) || (b10 = b()) == null || !b10.b()) {
                    return false;
                }
                return true;
            default:
                z zVar = (z) view;
                if (!zVar.b() && zVar.f1151w) {
                    zVar.f1149u = false;
                    zVar.c(zVar.f1150v);
                }
                return true;
        }
    }

    public final boolean d() {
        switch (this.f9902q) {
            case 1:
                ((z) this.f9903r).a();
                return true;
            default:
                g0 b10 = b();
                if (b10 != null && b10.b()) {
                    b10.dismiss();
                }
                return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(z zVar, FrameLayout frameLayout) {
        super(frameLayout);
        this.f9903r = zVar;
    }
}
