package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class n extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k2 f2088a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2089b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f2090c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2091d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2092e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ r f2093f;

    public n(r rVar, k2 k2Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2093f = rVar;
        this.f2088a = k2Var;
        this.f2089b = i10;
        this.f2090c = view;
        this.f2091d = i11;
        this.f2092e = viewPropertyAnimator;
    }

    public final void onAnimationCancel(Animator animator) {
        int i10 = this.f2089b;
        View view = this.f2090c;
        if (i10 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f2091d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        this.f2092e.setListener((Animator.AnimatorListener) null);
        r rVar = this.f2093f;
        k2 k2Var = this.f2088a;
        rVar.h(k2Var);
        rVar.f2169p.remove(k2Var);
        rVar.r();
    }

    public final void onAnimationStart(Animator animator) {
        this.f2093f.getClass();
    }
}
