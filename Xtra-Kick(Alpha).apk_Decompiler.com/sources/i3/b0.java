package i3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class b0 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w f8030b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f8031c;

    public /* synthetic */ b0(c0 c0Var, w wVar, int i10) {
        this.f8029a = i10;
        this.f8031c = c0Var;
        this.f8030b = wVar;
    }

    public final void onAnimationEnd(Animator animator) {
        int i10 = this.f8029a;
        w wVar = this.f8030b;
        c0 c0Var = this.f8031c;
        switch (i10) {
            case 0:
                c0Var.j(1);
                if (c0Var.B) {
                    wVar.post(c0Var.f8056s);
                    c0Var.B = false;
                    return;
                }
                return;
            case 1:
                c0Var.j(2);
                if (c0Var.B) {
                    wVar.post(c0Var.f8056s);
                    c0Var.B = false;
                    return;
                }
                return;
            default:
                c0Var.j(2);
                if (c0Var.B) {
                    wVar.post(c0Var.f8056s);
                    c0Var.B = false;
                    return;
                }
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        int i10 = this.f8029a;
        c0 c0Var = this.f8031c;
        switch (i10) {
            case 0:
                c0Var.j(3);
                return;
            case 1:
                c0Var.j(3);
                return;
            default:
                c0Var.j(3);
                return;
        }
    }
}
