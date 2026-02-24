package l8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import k5.a;

public final class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f9709a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f9710b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f9711c;

    public f(l lVar, a aVar) {
        this.f9711c = lVar;
        this.f9710b = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        l lVar = this.f9711c;
        lVar.f9747r = 0;
        lVar.f9741l = null;
        a aVar = this.f9710b;
        if (aVar != null) {
            ((c) aVar.f9124i).getClass();
        }
    }

    public final void onAnimationStart(Animator animator) {
        l lVar = this.f9711c;
        lVar.f9748s.a(0, this.f9709a);
        lVar.f9747r = 2;
        lVar.f9741l = animator;
    }
}
