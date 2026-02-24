package androidx.appcompat.widget;

import java.util.WeakHashMap;
import m0.c1;
import m0.l0;

public final class u2 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1095h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b3 f1096i;

    public /* synthetic */ u2(b3 b3Var, int i10) {
        this.f1095h = i10;
        this.f1096i = b3Var;
    }

    public final void run() {
        int i10 = this.f1095h;
        b3 b3Var = this.f1096i;
        switch (i10) {
            case 1:
                o2 o2Var = b3Var.f753j;
                if (o2Var != null) {
                    o2Var.setListSelectionHidden(true);
                    o2Var.requestLayout();
                    return;
                }
                return;
            default:
                o2 o2Var2 = b3Var.f753j;
                if (o2Var2 != null) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    if (l0.b(o2Var2) && b3Var.f753j.getCount() > b3Var.f753j.getChildCount() && b3Var.f753j.getChildCount() <= b3Var.f763t) {
                        b3Var.G.setInputMethodMode(2);
                        b3Var.d();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
