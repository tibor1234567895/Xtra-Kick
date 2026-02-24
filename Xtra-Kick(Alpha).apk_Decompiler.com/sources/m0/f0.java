package m0;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;
import java.util.WeakHashMap;

public final class f0 implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final WeakHashMap f10073h = new WeakHashMap();

    public final void onGlobalLayout() {
        boolean z10;
        int i10;
        if (Build.VERSION.SDK_INT < 28) {
            WeakHashMap weakHashMap = this.f10073h;
            for (Map.Entry entry : weakHashMap.entrySet()) {
                View view = (View) entry.getKey();
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                if (!view.isShown() || view.getWindowVisibility() != 0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (booleanValue != z10) {
                    if (z10) {
                        i10 = 16;
                    } else {
                        i10 = 32;
                    }
                    c1.i(view, i10);
                    weakHashMap.put(view, Boolean.valueOf(z10));
                }
            }
        }
    }

    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
