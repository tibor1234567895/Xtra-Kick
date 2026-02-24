package m0;

import android.os.Build;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import b2.n;

public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    public final z1 f10039a;

    public a2(int i10, Interpolator interpolator, long j10) {
        z1 w1Var;
        if (Build.VERSION.SDK_INT >= 30) {
            n.y();
            w1Var = new y1(n.k(i10, interpolator, j10));
        } else {
            w1Var = new w1(i10, interpolator, j10);
        }
        this.f10039a = w1Var;
    }

    public a2(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, (Interpolator) null, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f10039a = new y1(windowInsetsAnimation);
        }
    }
}
