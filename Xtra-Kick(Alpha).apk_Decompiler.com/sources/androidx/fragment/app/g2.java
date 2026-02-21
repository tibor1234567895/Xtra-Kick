package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public enum g2 {
    REMOVED,
    VISIBLE,
    GONE,
    INVISIBLE;
    

    /* renamed from: h  reason: collision with root package name */
    public static final f2 f1435h = null;

    /* access modifiers changed from: public */
    static {
        f1435h = new f2(0);
    }

    public final void a(View view) {
        int i10;
        int ordinal = ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                if (c1.I(2)) {
                    view.toString();
                }
                i10 = 0;
            } else if (ordinal == 2) {
                if (c1.I(2)) {
                    view.toString();
                }
                i10 = 8;
            } else if (ordinal == 3) {
                if (c1.I(2)) {
                    view.toString();
                }
                i10 = 4;
            } else {
                return;
            }
            view.setVisibility(i10);
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            if (c1.I(2)) {
                view.toString();
                viewGroup.toString();
            }
            viewGroup.removeView(view);
        }
    }
}
