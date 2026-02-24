package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Paint;
import android.view.View;
import b4.g0;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public final class e0 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1969a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1970b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f1971c;

    public e0(View view) {
        this.f1969a = 1;
        this.f1970b = false;
        this.f1971c = view;
    }

    public final void onAnimationCancel(Animator animator) {
        switch (this.f1969a) {
            case 0:
                this.f1970b = true;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    public final void onAnimationEnd(Animator animator) {
        int i10 = this.f1969a;
        Object obj = this.f1971c;
        switch (i10) {
            case 0:
                if (this.f1970b) {
                    this.f1970b = false;
                    return;
                }
                g0 g0Var = (g0) obj;
                if (((Float) g0Var.f2017z.getAnimatedValue()).floatValue() == 0.0f) {
                    g0Var.A = 0;
                    g0Var.d(0);
                    return;
                }
                g0Var.A = 2;
                g0Var.f2010s.invalidate();
                return;
            default:
                View view = (View) obj;
                g0.f2543a.d(view, 1.0f);
                if (this.f1970b) {
                    view.setLayerType(0, (Paint) null);
                    return;
                }
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        switch (this.f1969a) {
            case 1:
                View view = (View) this.f1971c;
                WeakHashMap weakHashMap = c1.f10054a;
                if (i0.h(view) && view.getLayerType() == 0) {
                    this.f1970b = true;
                    view.setLayerType(2, (Paint) null);
                    return;
                }
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public e0(g0 g0Var) {
        this.f1969a = 0;
        this.f1971c = g0Var;
        this.f1970b = false;
    }
}
