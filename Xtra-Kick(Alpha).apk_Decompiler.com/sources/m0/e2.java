package m0;

import android.view.View;
import android.view.WindowInsets;
import e0.d;

public class e2 extends g2 {

    /* renamed from: c  reason: collision with root package name */
    public final WindowInsets.Builder f10072c;

    public e2() {
        v0.k();
        this.f10072c = v0.e();
    }

    public q2 b() {
        a();
        q2 h10 = q2.h((View) null, this.f10072c.build());
        h10.f10131a.o(this.f10086b);
        return h10;
    }

    public void d(d dVar) {
        this.f10072c.setMandatorySystemGestureInsets(dVar.d());
    }

    public void e(d dVar) {
        this.f10072c.setStableInsets(dVar.d());
    }

    public void f(d dVar) {
        this.f10072c.setSystemGestureInsets(dVar.d());
    }

    public void g(d dVar) {
        this.f10072c.setSystemWindowInsets(dVar.d());
    }

    public void h(d dVar) {
        this.f10072c.setTappableElementInsets(dVar.d());
    }

    public e2(q2 q2Var) {
        super(q2Var);
        WindowInsets.Builder builder;
        WindowInsets g10 = q2Var.g();
        if (g10 != null) {
            v0.k();
            builder = v0.f(g10);
        } else {
            v0.k();
            builder = v0.e();
        }
        this.f10072c = builder;
    }
}
