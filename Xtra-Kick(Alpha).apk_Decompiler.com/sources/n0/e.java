package n0;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import e7.b;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import y8.k;

public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final d f10902a;

    public e(d dVar) {
        this.f10902a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f10902a.equals(((e) obj).f10902a);
    }

    public final int hashCode() {
        return this.f10902a.hashCode();
    }

    public final void onTouchExplorationStateChanged(boolean z10) {
        boolean z11;
        k kVar = (k) ((b) this.f10902a).f5295i;
        AutoCompleteTextView autoCompleteTextView = kVar.f17142h;
        if (autoCompleteTextView != null) {
            int i10 = 1;
            if (autoCompleteTextView.getInputType() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (z10) {
                    i10 = 2;
                }
                WeakHashMap weakHashMap = c1.f10054a;
                i0.s(kVar.f17177d, i10);
            }
        }
    }
}
