package b4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

public final class o0 extends AnimatorListenerAdapter implements t {

    /* renamed from: a  reason: collision with root package name */
    public final View f2568a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2569b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f2570c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2572e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2573f = false;

    public o0(View view, int i10) {
        this.f2568a = view;
        this.f2569b = i10;
        this.f2570c = (ViewGroup) view.getParent();
        this.f2571d = true;
        f(true);
    }

    public final void a(u uVar) {
        if (!this.f2573f) {
            g0.f2543a.b(this.f2568a, this.f2569b);
            ViewGroup viewGroup = this.f2570c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        uVar.v(this);
    }

    public final void b(u uVar) {
    }

    public final void c() {
        f(false);
    }

    public final void d() {
        f(true);
    }

    public final void e() {
    }

    public final void f(boolean z10) {
        ViewGroup viewGroup;
        if (this.f2571d && this.f2572e != z10 && (viewGroup = this.f2570c) != null) {
            this.f2572e = z10;
            f0.a(viewGroup, z10);
        }
    }

    public final void onAnimationCancel(Animator animator) {
        this.f2573f = true;
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.f2573f) {
            g0.f2543a.b(this.f2568a, this.f2569b);
            ViewGroup viewGroup = this.f2570c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    public final void onAnimationPause(Animator animator) {
        if (!this.f2573f) {
            g0.f2543a.b(this.f2568a, this.f2569b);
        }
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationResume(Animator animator) {
        if (!this.f2573f) {
            g0.f2543a.b(this.f2568a, 0);
        }
    }

    public final void onAnimationStart(Animator animator) {
    }
}
