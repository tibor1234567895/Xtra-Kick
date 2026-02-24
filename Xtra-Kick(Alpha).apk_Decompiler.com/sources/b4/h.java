package b4;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.recyclerview.widget.e0;

public final class h extends q0 {
    public h() {
    }

    public h(int i10) {
        if ((i10 & -4) == 0) {
            this.F = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public final Animator J(View view, c0 c0Var) {
        float f10;
        Float f11;
        float f12 = 0.0f;
        if (c0Var == null || (f11 = (Float) c0Var.f2521a.get("android:fade:transitionAlpha")) == null) {
            f10 = 0.0f;
        } else {
            f10 = f11.floatValue();
        }
        if (f10 != 1.0f) {
            f12 = f10;
        }
        return L(view, f12, 1.0f);
    }

    public final Animator K(View view, c0 c0Var) {
        float f10;
        Float f11;
        g0.f2543a.getClass();
        if (c0Var == null || (f11 = (Float) c0Var.f2521a.get("android:fade:transitionAlpha")) == null) {
            f10 = 1.0f;
        } else {
            f10 = f11.floatValue();
        }
        return L(view, f10, 0.0f);
    }

    public final ObjectAnimator L(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        g0.f2543a.d(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, g0.f2544b, new float[]{f11});
        ofFloat.addListener(new e0(view));
        a(new g(this, 0, view));
        return ofFloat;
    }

    public final void g(c0 c0Var) {
        H(c0Var);
        c0Var.f2521a.put("android:fade:transitionAlpha", Float.valueOf(g0.f2543a.c(c0Var.f2522b)));
    }
}
