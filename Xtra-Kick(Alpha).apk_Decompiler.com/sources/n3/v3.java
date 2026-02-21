package n3;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f1;
import androidx.recyclerview.widget.i1;
import x8.n;

public final class v3 extends i1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f11530a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f11531b;

    public /* synthetic */ v3(int i10, Object obj) {
        this.f11530a = i10;
        this.f11531b = obj;
    }

    public final void a() {
        switch (this.f11530a) {
            case 2:
                ((n) this.f11531b).b();
                return;
            default:
                return;
        }
    }

    public final void b() {
        switch (this.f11530a) {
            case 2:
                ((n) this.f11531b).b();
                return;
            default:
                return;
        }
    }

    public final void c(int i10, int i11, Object obj) {
        switch (this.f11530a) {
            case 2:
                ((n) this.f11531b).b();
                return;
            default:
                b();
                return;
        }
    }

    public final void d(int i10, int i11) {
        int i12 = this.f11530a;
        Object obj = this.f11531b;
        switch (i12) {
            case 0:
                x3 x3Var = (x3) obj;
                if (x3Var.getStateRestorationPolicy() == f1.PREVENT && !x3Var.f11564a) {
                    x3Var.setStateRestorationPolicy(f1.ALLOW);
                }
                x3Var.unregisterAdapterDataObserver(this);
                return;
            case 1:
                if (i10 == 0) {
                    try {
                        ((RecyclerView) obj).scrollToPosition(0);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } else {
                    return;
                }
            default:
                ((n) obj).b();
                return;
        }
    }

    public final void e(int i10, int i11) {
        switch (this.f11530a) {
            case 2:
                ((n) this.f11531b).b();
                return;
            default:
                return;
        }
    }

    public final void f(int i10, int i11) {
        switch (this.f11530a) {
            case 2:
                ((n) this.f11531b).b();
                return;
            default:
                return;
        }
    }
}
