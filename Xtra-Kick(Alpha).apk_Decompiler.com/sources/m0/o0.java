package m0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.woxthebox.draglistview.R;
import e0.d;

public final class o0 {
    private o0() {
    }

    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static q2 b(View view, q2 q2Var, Rect rect) {
        WindowInsets g10 = q2Var.g();
        if (g10 != null) {
            return q2.h(view, view.computeSystemWindowInsets(g10, rect));
        }
        rect.setEmpty();
        return q2Var;
    }

    public static boolean c(View view, float f10, float f11, boolean z10) {
        return view.dispatchNestedFling(f10, f11, z10);
    }

    public static boolean d(View view, float f10, float f11) {
        return view.dispatchNestedPreFling(f10, f11);
    }

    public static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
    }

    public static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static q2 j(View view) {
        if (b2.f10050d && view.isAttachedToWindow()) {
            try {
                Object obj = b2.f10047a.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) b2.f10048b.get(obj);
                    Rect rect2 = (Rect) b2.f10049c.get(obj);
                    if (!(rect == null || rect2 == null)) {
                        g2 g2Var = new c2().f10061a;
                        g2Var.e(d.b(rect.left, rect.top, rect.right, rect.bottom));
                        g2Var.g(d.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
                        q2 b10 = g2Var.b();
                        b10.f10131a.p(b10);
                        b10.f10131a.d(view.getRootView());
                        return b10;
                    }
                }
            } catch (IllegalAccessException e10) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
            }
        }
        return null;
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f10) {
        view.setElevation(f10);
    }

    public static void t(View view, boolean z10) {
        view.setNestedScrollingEnabled(z10);
    }

    public static void u(View view, y yVar) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, yVar);
        }
        if (yVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new n0(view, yVar));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f10) {
        view.setTranslationZ(f10);
    }

    public static void x(View view, float f10) {
        view.setZ(f10);
    }

    public static boolean y(View view, int i10) {
        return view.startNestedScroll(i10);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
