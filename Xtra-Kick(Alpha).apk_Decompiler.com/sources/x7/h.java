package x7;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import t8.i;

public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f16725a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f16726b;

    public /* synthetic */ h(int i10, Object obj) {
        this.f16725a = i10;
        this.f16726b = obj;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f16725a;
        Object obj = this.f16726b;
        switch (i10) {
            case 0:
                ((CollapsingToolbarLayout) obj).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
            case 1:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                i iVar = ((BottomSheetBehavior) obj).f3673i;
                if (iVar != null) {
                    t8.h hVar = iVar.f14744h;
                    if (hVar.f14732j != floatValue) {
                        hVar.f14732j = floatValue;
                        iVar.f14748l = true;
                        iVar.invalidateSelf();
                        return;
                    }
                    return;
                }
                return;
            case 2:
                ((TabLayout) obj).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                return;
            default:
                ((TextInputLayout) obj).f3927z0.p(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
