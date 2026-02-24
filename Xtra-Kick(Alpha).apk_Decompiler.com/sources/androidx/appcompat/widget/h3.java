package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import m.o;
import m.q;

public final class h3 extends b3 implements c3 {
    public static final Method L;
    public c3 K;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public h3(Context context, int i10, int i11) {
        super(context, (AttributeSet) null, i10, i11);
    }

    public final o2 a(Context context, boolean z10) {
        g3 g3Var = new g3(context, z10);
        g3Var.setHoverListener(this);
        return g3Var;
    }

    public final void g(o oVar, q qVar) {
        c3 c3Var = this.K;
        if (c3Var != null) {
            c3Var.g(oVar, qVar);
        }
    }

    public final void w(o oVar, MenuItem menuItem) {
        c3 c3Var = this.K;
        if (c3Var != null) {
            c3Var.w(oVar, menuItem);
        }
    }
}
