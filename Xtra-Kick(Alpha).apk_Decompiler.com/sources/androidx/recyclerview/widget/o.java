package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2102a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f2103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2104c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f2105d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r f2106e;

    public /* synthetic */ o(r rVar, p pVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i10) {
        this.f2102a = i10;
        this.f2106e = rVar;
        this.f2103b = pVar;
        this.f2104c = viewPropertyAnimator;
        this.f2105d = view;
    }

    public final void onAnimationEnd(Animator animator) {
        int i10 = this.f2102a;
        r rVar = this.f2106e;
        p pVar = this.f2103b;
        View view = this.f2105d;
        ViewPropertyAnimator viewPropertyAnimator = this.f2104c;
        switch (i10) {
            case 0:
                viewPropertyAnimator.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                rVar.h(pVar.f2117a);
                rVar.f2171r.remove(pVar.f2117a);
                rVar.r();
                return;
            default:
                viewPropertyAnimator.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                rVar.h(pVar.f2118b);
                rVar.f2171r.remove(pVar.f2118b);
                rVar.r();
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        int i10 = this.f2102a;
        r rVar = this.f2106e;
        p pVar = this.f2103b;
        switch (i10) {
            case 0:
                k2 k2Var = pVar.f2117a;
                rVar.getClass();
                return;
            default:
                k2 k2Var2 = pVar.f2118b;
                rVar.getClass();
                return;
        }
    }
}
