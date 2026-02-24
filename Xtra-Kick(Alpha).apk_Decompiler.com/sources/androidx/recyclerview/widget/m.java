package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class m extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2077a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k2 f2078b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2079c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2080d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r f2081e;

    public m(r rVar, k2 k2Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2081e = rVar;
        this.f2078b = k2Var;
        this.f2079c = view;
        this.f2080d = viewPropertyAnimator;
    }

    public final void onAnimationCancel(Animator animator) {
        switch (this.f2077a) {
            case 1:
                this.f2079c.setAlpha(1.0f);
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    public final void onAnimationEnd(Animator animator) {
        int i10 = this.f2077a;
        k2 k2Var = this.f2078b;
        r rVar = this.f2081e;
        ViewPropertyAnimator viewPropertyAnimator = this.f2080d;
        switch (i10) {
            case 0:
                viewPropertyAnimator.setListener((Animator.AnimatorListener) null);
                this.f2079c.setAlpha(1.0f);
                rVar.h(k2Var);
                rVar.f2170q.remove(k2Var);
                rVar.r();
                return;
            default:
                viewPropertyAnimator.setListener((Animator.AnimatorListener) null);
                rVar.h(k2Var);
                rVar.f2168o.remove(k2Var);
                rVar.r();
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        int i10 = this.f2077a;
        r rVar = this.f2081e;
        switch (i10) {
            case 0:
                rVar.getClass();
                return;
            default:
                rVar.getClass();
                return;
        }
    }

    public m(r rVar, k2 k2Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2081e = rVar;
        this.f2078b = k2Var;
        this.f2080d = viewPropertyAnimator;
        this.f2079c = view;
    }
}
