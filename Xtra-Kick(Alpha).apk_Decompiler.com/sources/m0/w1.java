package m0;

import a1.a;
import android.support.v4.media.n;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import b8.j;
import com.woxthebox.draglistview.R;
import java.util.List;

public final class w1 extends z1 {

    /* renamed from: e  reason: collision with root package name */
    public static final PathInterpolator f10154e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

    /* renamed from: f  reason: collision with root package name */
    public static final a f10155f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final DecelerateInterpolator f10156g = new DecelerateInterpolator();

    public w1(int i10, Interpolator interpolator, long j10) {
        super(i10, interpolator, j10);
    }

    public static void e(View view) {
        j j10 = j(view);
        if (j10 != null) {
            j10.f2691b.setTranslationY(0.0f);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                e(viewGroup.getChildAt(i10));
            }
        }
    }

    public static void f(View view, WindowInsets windowInsets, boolean z10) {
        j j10 = j(view);
        if (j10 != null) {
            j10.f2690a = windowInsets;
            if (!z10) {
                View view2 = j10.f2691b;
                int[] iArr = j10.f2694e;
                view2.getLocationOnScreen(iArr);
                z10 = true;
                j10.f2692c = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                f(viewGroup.getChildAt(i10), windowInsets, z10);
            }
        }
    }

    public static void g(View view, q2 q2Var, List list) {
        j j10 = j(view);
        if (j10 != null) {
            j10.a(q2Var, list);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                g(viewGroup.getChildAt(i10), q2Var, list);
            }
        }
    }

    public static void h(View view, n nVar) {
        j j10 = j(view);
        if (j10 != null) {
            View view2 = j10.f2691b;
            int[] iArr = j10.f2694e;
            view2.getLocationOnScreen(iArr);
            int i10 = j10.f2692c - iArr[1];
            j10.f2693d = i10;
            view2.setTranslationY((float) i10);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                h(viewGroup.getChildAt(i11), nVar);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static j j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof v1) {
            return ((v1) tag).f10152a;
        }
        return null;
    }
}
