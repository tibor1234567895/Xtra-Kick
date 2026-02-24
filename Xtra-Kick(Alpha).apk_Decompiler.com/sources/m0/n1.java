package m0;

import android.animation.Animator;
import android.view.View;
import java.lang.ref.WeakReference;

public final class n1 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f10125a;

    public n1(View view) {
        this.f10125a = new WeakReference(view);
    }

    public final void a(float f10) {
        View view = (View) this.f10125a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
    }

    public final void b() {
        View view = (View) this.f10125a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j10) {
        View view = (View) this.f10125a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
    }

    public final void d(o1 o1Var) {
        View view = (View) this.f10125a.get();
        if (view == null) {
            return;
        }
        if (o1Var != null) {
            view.animate().setListener(new l1(this, o1Var, view, 0));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public final void e(float f10) {
        View view = (View) this.f10125a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
    }
}
