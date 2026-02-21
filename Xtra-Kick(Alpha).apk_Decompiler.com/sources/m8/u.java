package m8;

import android.view.View;
import java.util.WeakHashMap;
import m0.c1;
import m0.m0;

public final class u implements View.OnAttachStateChangeListener {
    public final void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = c1.f10054a;
        m0.c(view);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
