package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import xa.j;

public final class g1 extends Fragment {

    /* renamed from: i  reason: collision with root package name */
    public static final d1 f1694i = new d1(0);

    /* renamed from: h  reason: collision with root package name */
    public x0 f1695h;

    public final void a(r rVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            j.e("activity", activity);
            f1694i.getClass();
            d1.a(activity, rVar);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(r.ON_CREATE);
    }

    public final void onDestroy() {
        super.onDestroy();
        a(r.ON_DESTROY);
        this.f1695h = null;
    }

    public final void onPause() {
        super.onPause();
        a(r.ON_PAUSE);
    }

    public final void onResume() {
        super.onResume();
        x0 x0Var = this.f1695h;
        if (x0Var != null) {
            x0Var.f1784a.b();
        }
        a(r.ON_RESUME);
    }

    public final void onStart() {
        super.onStart();
        x0 x0Var = this.f1695h;
        if (x0Var != null) {
            y0 y0Var = x0Var.f1784a;
            int i10 = y0Var.f1794h + 1;
            y0Var.f1794h = i10;
            if (i10 == 1 && y0Var.f1797k) {
                y0Var.f1799m.f(r.ON_START);
                y0Var.f1797k = false;
            }
        }
        a(r.ON_START);
    }

    public final void onStop() {
        super.onStop();
        a(r.ON_STOP);
    }
}
