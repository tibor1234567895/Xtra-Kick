package b4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import q.e;

public final class q extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f2580a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2581b;

    public /* synthetic */ q(Object obj, e eVar) {
        this.f2581b = obj;
        this.f2580a = eVar;
    }

    public final void onAnimationEnd(Animator animator) {
        ((e) this.f2580a).remove(animator);
        ((u) this.f2581b).f2600t.remove(animator);
    }

    public final void onAnimationStart(Animator animator) {
        ((u) this.f2581b).f2600t.add(animator);
    }
}
