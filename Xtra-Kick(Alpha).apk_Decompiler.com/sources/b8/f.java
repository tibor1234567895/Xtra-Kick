package b8;

import android.view.View;

public final class f extends b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2674b;

    public /* synthetic */ f(int i10, Object obj) {
        this.f2673a = i10;
        this.f2674b = obj;
    }

    public final void b(View view) {
    }

    public final void c(View view, int i10) {
        int i11 = this.f2673a;
        Object obj = this.f2674b;
        switch (i11) {
            case 0:
                if (i10 == 5) {
                    ((h) obj).cancel();
                    return;
                }
                return;
            default:
                if (i10 == 5) {
                    int i12 = i.f2689t0;
                    ((i) obj).m0(false, false);
                    return;
                }
                return;
        }
    }
}
