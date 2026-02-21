package m8;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b4.c0;
import b4.u;
import java.util.HashMap;
import z3.b;

public final class p extends u {
    public final void d(c0 c0Var) {
        View view = c0Var.f2522b;
        if (view instanceof TextView) {
            c0Var.f2521a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public final void g(c0 c0Var) {
        View view = c0Var.f2522b;
        if (view instanceof TextView) {
            c0Var.f2521a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public final Animator k(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null || !(c0Var.f2522b instanceof TextView)) {
            return null;
        }
        View view = c0Var2.f2522b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        HashMap hashMap = c0Var.f2521a;
        HashMap hashMap2 = c0Var2.f2521a;
        float f10 = 1.0f;
        float floatValue = hashMap.get("android:textscale:scale") != null ? ((Float) hashMap.get("android:textscale:scale")).floatValue() : 1.0f;
        if (hashMap2.get("android:textscale:scale") != null) {
            f10 = ((Float) hashMap2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f10) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f10});
        ofFloat.addUpdateListener(new b(this, 1, textView));
        return ofFloat;
    }
}
