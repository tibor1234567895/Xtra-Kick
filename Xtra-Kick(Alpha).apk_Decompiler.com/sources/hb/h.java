package hb;

import java.util.concurrent.Future;
import la.v;
import wa.l;

public final class h extends i {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7800h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f7801i;

    public /* synthetic */ h(int i10, Object obj) {
        this.f7800h = i10;
        this.f7801i = obj;
    }

    public final void a(Throwable th) {
        int i10 = this.f7800h;
        Object obj = this.f7801i;
        switch (i10) {
            case 0:
                if (th != null) {
                    ((Future) obj).cancel(false);
                    return;
                }
                return;
            case 1:
                ((q0) obj).a();
                return;
            default:
                ((l) obj).invoke(th);
                return;
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f7800h) {
            case 0:
                a((Throwable) obj);
                return v.f9814a;
            case 1:
                a((Throwable) obj);
                return v.f9814a;
            default:
                a((Throwable) obj);
                return v.f9814a;
        }
    }

    public final String toString() {
        int i10 = this.f7800h;
        Object obj = this.f7801i;
        switch (i10) {
            case 0:
                return "CancelFutureOnCancel[" + ((Future) obj) + ']';
            case 1:
                return "DisposeOnCancel[" + ((q0) obj) + ']';
            default:
                return "InvokeOnCancel[" + ((l) obj).getClass().getSimpleName() + '@' + h0.r0(this) + ']';
        }
    }
}
