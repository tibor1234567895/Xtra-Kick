package m0;

import android.view.View;
import android.view.WindowInsets;
import e0.d;

public class i2 extends h2 {

    /* renamed from: m  reason: collision with root package name */
    public d f10107m = null;

    public i2(q2 q2Var, WindowInsets windowInsets) {
        super(q2Var, windowInsets);
    }

    public q2 b() {
        return q2.h((View) null, this.f10094c.consumeStableInsets());
    }

    public q2 c() {
        return q2.h((View) null, this.f10094c.consumeSystemWindowInsets());
    }

    public final d h() {
        if (this.f10107m == null) {
            WindowInsets windowInsets = this.f10094c;
            this.f10107m = d.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f10107m;
    }

    public boolean m() {
        return this.f10094c.isConsumed();
    }

    public void q(d dVar) {
        this.f10107m = dVar;
    }
}
