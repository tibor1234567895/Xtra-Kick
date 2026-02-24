package m0;

import android.animation.ValueAnimator;
import android.view.ViewPropertyAnimator;

public final class m1 {
    private m1() {
    }

    public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
    }
}
