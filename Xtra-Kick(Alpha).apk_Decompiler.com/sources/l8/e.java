package l8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import k5.a;

public final class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9705a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f9706b = false;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f9707c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f9708d;

    public e(l lVar, a aVar) {
        this.f9708d = lVar;
        this.f9707c = aVar;
    }

    public final void onAnimationCancel(Animator animator) {
        this.f9705a = true;
    }

    public final void onAnimationEnd(Animator animator) {
        int i10;
        l lVar = this.f9708d;
        lVar.f9747r = 0;
        lVar.f9741l = null;
        if (!this.f9705a) {
            boolean z10 = this.f9706b;
            if (z10) {
                i10 = 8;
            } else {
                i10 = 4;
            }
            lVar.f9748s.a(i10, z10);
            a aVar = this.f9707c;
            if (aVar != null) {
                ((c) aVar.f9124i).getClass();
            }
        }
    }

    public final void onAnimationStart(Animator animator) {
        l lVar = this.f9708d;
        lVar.f9748s.a(0, this.f9706b);
        lVar.f9747r = 1;
        lVar.f9741l = animator;
        this.f9705a = false;
    }
}
