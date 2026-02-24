package androidx.lifecycle;

import android.app.Activity;
import xa.j;

public final class v0 extends k {
    final /* synthetic */ y0 this$0;

    public v0(y0 y0Var) {
        this.this$0 = y0Var;
    }

    public void onActivityPostResumed(Activity activity) {
        j.f("activity", activity);
        this.this$0.b();
    }

    public void onActivityPostStarted(Activity activity) {
        j.f("activity", activity);
        y0 y0Var = this.this$0;
        int i10 = y0Var.f1794h + 1;
        y0Var.f1794h = i10;
        if (i10 == 1 && y0Var.f1797k) {
            y0Var.f1799m.f(r.ON_START);
            y0Var.f1797k = false;
        }
    }
}
