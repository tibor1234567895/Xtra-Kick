package m8;

import a2.j;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import java.util.WeakHashMap;
import k5.a;
import m0.c1;
import m0.j0;
import m0.l0;
import m0.m0;
import m0.o0;

public final class w {
    private w() {
    }

    public static void a(View view, v vVar) {
        WeakHashMap weakHashMap = c1.f10054a;
        o0.u(view, new a((Object) vVar, 8, (Object) new j(j0.f(view), view.getPaddingTop(), j0.e(view), view.getPaddingBottom())));
        if (l0.b(view)) {
            m0.c(view);
        } else {
            view.addOnAttachStateChangeListener(new u());
        }
    }

    public static float b(Context context, int i10) {
        return TypedValue.applyDimension(1, (float) i10, context.getResources().getDisplayMetrics());
    }

    public static boolean c(View view) {
        WeakHashMap weakHashMap = c1.f10054a;
        if (j0.d(view) == 1) {
            return true;
        }
        return false;
    }

    public static PorterDuff.Mode d(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case Constants.IV_SIZE:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
