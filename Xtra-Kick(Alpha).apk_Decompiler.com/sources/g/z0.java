package g;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;
import l.b;
import m0.c1;
import m0.m0;
import m0.p1;

public final class z0 extends p1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6239a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b1 f6240b;

    public /* synthetic */ z0(b1 b1Var, int i10) {
        this.f6239a = i10;
        this.f6240b = b1Var;
    }

    public final void a() {
        View view;
        int i10 = this.f6239a;
        b1 b1Var = this.f6240b;
        switch (i10) {
            case 0:
                if (b1Var.f6041o && (view = b1Var.f6033g) != null) {
                    view.setTranslationY(0.0f);
                    b1Var.f6030d.setTranslationY(0.0f);
                }
                b1Var.f6030d.setVisibility(8);
                b1Var.f6030d.setTransitioning(false);
                b1Var.f6045s = null;
                b bVar = b1Var.f6037k;
                if (bVar != null) {
                    bVar.h(b1Var.f6036j);
                    b1Var.f6036j = null;
                    b1Var.f6037k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = b1Var.f6029c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    m0.c(actionBarOverlayLayout);
                    return;
                }
                return;
            default:
                b1Var.f6045s = null;
                b1Var.f6030d.requestLayout();
                return;
        }
    }
}
