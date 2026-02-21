package q7;

import android.animation.Animator;
import android.view.View;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import xa.j;

public final class e implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SlidingLayout f13407a;

    public e(SlidingLayout slidingLayout) {
        this.f13407a = slidingLayout;
    }

    public final void onAnimationCancel(Animator animator) {
        j.f("animation", animator);
    }

    public final void onAnimationEnd(Animator animator) {
        j.f("animation", animator);
        SlidingLayout slidingLayout = this.f13407a;
        slidingLayout.f3547w = false;
        slidingLayout.f3548x = false;
        slidingLayout.f3541q = 0;
        slidingLayout.f3542r = 0;
        slidingLayout.requestLayout();
        View secondView = slidingLayout.getSecondView();
        if (secondView != null) {
            secondView.postInvalidate();
        }
    }

    public final void onAnimationRepeat(Animator animator) {
        j.f("animation", animator);
    }

    public final void onAnimationStart(Animator animator) {
        j.f("animation", animator);
        this.f13407a.f3547w = true;
    }
}
