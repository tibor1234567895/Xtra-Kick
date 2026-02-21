package m0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class l1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10116b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f10117c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f10118d;

    public /* synthetic */ l1(Object obj, Object obj2, Object obj3, int i10) {
        this.f10115a = i10;
        this.f10118d = obj;
        this.f10117c = obj2;
        this.f10116b = obj3;
    }

    public final void onAnimationCancel(Animator animator) {
        switch (this.f10115a) {
            case 0:
                ((o1) this.f10117c).b((View) this.f10116b);
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    public final void onAnimationEnd(Animator animator) {
        int i10 = this.f10115a;
        Object obj = this.f10117c;
        switch (i10) {
            case 0:
                ((o1) obj).a();
                return;
            default:
                ((a2) obj).f10039a.d(1.0f);
                w1.e((View) this.f10116b);
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        switch (this.f10115a) {
            case 0:
                ((o1) this.f10117c).c();
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
