package y8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17124a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f17125b;

    public /* synthetic */ c(d dVar, int i10) {
        this.f17124a = i10;
        this.f17125b = dVar;
    }

    public final void onAnimationEnd(Animator animator) {
        switch (this.f17124a) {
            case 1:
                this.f17125b.f17175b.g(false);
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        switch (this.f17124a) {
            case 0:
                this.f17125b.f17175b.g(true);
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
