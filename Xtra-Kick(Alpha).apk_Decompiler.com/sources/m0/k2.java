package m0;

import android.view.View;
import android.view.WindowInsets;
import e0.d;

public class k2 extends j2 {

    /* renamed from: n  reason: collision with root package name */
    public d f10111n = null;

    /* renamed from: o  reason: collision with root package name */
    public d f10112o = null;

    /* renamed from: p  reason: collision with root package name */
    public d f10113p = null;

    public k2(q2 q2Var, WindowInsets windowInsets) {
        super(q2Var, windowInsets);
    }

    public d g() {
        if (this.f10112o == null) {
            this.f10112o = d.c(this.f10094c.getMandatorySystemGestureInsets());
        }
        return this.f10112o;
    }

    public d i() {
        if (this.f10111n == null) {
            this.f10111n = d.c(this.f10094c.getSystemGestureInsets());
        }
        return this.f10111n;
    }

    public d k() {
        if (this.f10113p == null) {
            this.f10113p = d.c(this.f10094c.getTappableElementInsets());
        }
        return this.f10113p;
    }

    public q2 l(int i10, int i11, int i12, int i13) {
        return q2.h((View) null, this.f10094c.inset(i10, i11, i12, i13));
    }

    public void q(d dVar) {
    }
}
