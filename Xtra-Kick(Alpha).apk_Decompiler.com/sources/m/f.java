package m;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.util.WeakHashMap;
import m0.c1;
import m0.l0;
import n0.c;
import n0.d;
import y8.n;

public final class f implements View.OnAttachStateChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9909h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9910i;

    public /* synthetic */ f(int i10, Object obj) {
        this.f9909h = i10;
        this.f9910i = obj;
    }

    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.f9909h) {
            case 0:
            case 1:
                return;
            default:
                n nVar = (n) this.f9910i;
                int i10 = n.D;
                if (nVar.B != null && (accessibilityManager = nVar.A) != null) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    if (l0.b(nVar)) {
                        c.a(accessibilityManager, nVar.B);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        int i10 = this.f9909h;
        Object obj = this.f9910i;
        switch (i10) {
            case 0:
                i iVar = (i) obj;
                ViewTreeObserver viewTreeObserver = iVar.F;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        iVar.F = view.getViewTreeObserver();
                    }
                    iVar.F.removeGlobalOnLayoutListener(iVar.f9946q);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            case 1:
                h0 h0Var = (h0) obj;
                ViewTreeObserver viewTreeObserver2 = h0Var.f9934w;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        h0Var.f9934w = view.getViewTreeObserver();
                    }
                    h0Var.f9934w.removeGlobalOnLayoutListener(h0Var.f9928q);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            default:
                n nVar = (n) obj;
                int i11 = n.D;
                d dVar = nVar.B;
                if (dVar != null && (accessibilityManager = nVar.A) != null) {
                    c.b(accessibilityManager, dVar);
                    return;
                }
                return;
        }
    }
}
