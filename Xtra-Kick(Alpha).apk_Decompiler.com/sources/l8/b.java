package l8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9703b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9704c;

    public b(boolean z10, View view, View view2) {
        this.f9702a = z10;
        this.f9703b = view;
        this.f9704c = view2;
    }

    public final void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.f9702a) {
            ((View) this.f9703b).setVisibility(4);
            View view = (View) this.f9704c;
            view.setAlpha(1.0f);
            view.setVisibility(0);
        }
    }

    public final void onAnimationStart(Animator animator) {
        if (this.f9702a) {
            ((View) this.f9703b).setVisibility(0);
            View view = (View) this.f9704c;
            view.setAlpha(0.0f);
            view.setVisibility(4);
        }
    }
}
