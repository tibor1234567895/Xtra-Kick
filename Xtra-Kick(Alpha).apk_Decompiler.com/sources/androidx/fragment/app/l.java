package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;
import xa.j;

public final class l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f1474a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1475b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f1476c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h2 f1477d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ i f1478e;

    public l(n nVar, View view, boolean z10, h2 h2Var, i iVar) {
        this.f1474a = nVar;
        this.f1475b = view;
        this.f1476c = z10;
        this.f1477d = h2Var;
        this.f1478e = iVar;
    }

    public final void onAnimationEnd(Animator animator) {
        j.f("anim", animator);
        ViewGroup viewGroup = this.f1474a.f1506a;
        View view = this.f1475b;
        viewGroup.endViewTransition(view);
        boolean z10 = this.f1476c;
        h2 h2Var = this.f1477d;
        if (z10) {
            g2 g2Var = h2Var.f1453a;
            j.e("viewToAnimate", view);
            g2Var.a(view);
        }
        this.f1478e.b();
        if (c1.I(2)) {
            Objects.toString(h2Var);
        }
    }
}
