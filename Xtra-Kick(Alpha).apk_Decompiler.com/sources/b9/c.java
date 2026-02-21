package b9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2701a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f2702b;

    public c(boolean z10, View view) {
        this.f2701a = z10;
        this.f2702b = view;
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.f2701a) {
            this.f2702b.setVisibility(4);
        }
    }

    public final void onAnimationStart(Animator animator) {
        if (this.f2701a) {
            this.f2702b.setVisibility(0);
        }
    }
}
