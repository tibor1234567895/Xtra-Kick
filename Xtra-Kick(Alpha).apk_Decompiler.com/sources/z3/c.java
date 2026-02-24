package z3;

import android.animation.Animator;

public final class c implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f17510a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f17511b;

    public c(e eVar, d dVar) {
        this.f17511b = eVar;
        this.f17510a = dVar;
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
        e eVar = this.f17511b;
        d dVar = this.f17510a;
        eVar.a(1.0f, dVar, true);
        dVar.f17522k = dVar.f17516e;
        dVar.f17523l = dVar.f17517f;
        dVar.f17524m = dVar.f17518g;
        dVar.a((dVar.f17521j + 1) % dVar.f17520i.length);
        if (eVar.f17541m) {
            eVar.f17541m = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            if (dVar.f17525n) {
                dVar.f17525n = false;
                return;
            }
            return;
        }
        eVar.f17540l += 1.0f;
    }

    public final void onAnimationStart(Animator animator) {
        this.f17511b.f17540l = 0.0f;
    }
}
