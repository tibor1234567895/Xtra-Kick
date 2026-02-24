package m0;

import android.view.View;
import android.view.ViewTreeObserver;

public final class b0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final View f10040h;

    /* renamed from: i  reason: collision with root package name */
    public ViewTreeObserver f10041i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f10042j;

    public b0(View view, Runnable runnable) {
        this.f10040h = view;
        this.f10041i = view.getViewTreeObserver();
        this.f10042j = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            b0 b0Var = new b0(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(b0Var);
            view.addOnAttachStateChangeListener(b0Var);
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public final boolean onPreDraw() {
        ViewTreeObserver viewTreeObserver;
        boolean isAlive = this.f10041i.isAlive();
        View view = this.f10040h;
        if (isAlive) {
            viewTreeObserver = this.f10041i;
        } else {
            viewTreeObserver = view.getViewTreeObserver();
        }
        viewTreeObserver.removeOnPreDrawListener(this);
        view.removeOnAttachStateChangeListener(this);
        this.f10042j.run();
        return true;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f10041i = view.getViewTreeObserver();
    }

    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f10041i.isAlive();
        View view2 = this.f10040h;
        (isAlive ? this.f10041i : view2.getViewTreeObserver()).removeOnPreDrawListener(this);
        view2.removeOnAttachStateChangeListener(this);
    }
}
