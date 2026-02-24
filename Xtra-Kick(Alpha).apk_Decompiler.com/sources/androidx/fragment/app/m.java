package androidx.fragment.app;

import android.view.View;
import android.view.animation.Animation;
import androidx.emoji2.text.r;
import java.util.Objects;
import xa.j;

public final class m implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h2 f1494a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f1495b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1496c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f1497d;

    public m(View view, i iVar, n nVar, h2 h2Var) {
        this.f1494a = h2Var;
        this.f1495b = nVar;
        this.f1496c = view;
        this.f1497d = iVar;
    }

    public final void onAnimationEnd(Animation animation) {
        j.f("animation", animation);
        n nVar = this.f1495b;
        nVar.f1506a.post(new r(nVar, this.f1496c, this.f1497d, 3));
        if (c1.I(2)) {
            Objects.toString(this.f1494a);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
        j.f("animation", animation);
    }

    public final void onAnimationStart(Animation animation) {
        j.f("animation", animation);
        if (c1.I(2)) {
            Objects.toString(this.f1494a);
        }
    }
}
