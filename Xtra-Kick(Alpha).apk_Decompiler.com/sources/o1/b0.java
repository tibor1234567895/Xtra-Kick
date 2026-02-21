package o1;

import android.os.Handler;
import h3.c0;
import j1.l0;
import java.util.concurrent.Executor;

public final /* synthetic */ class b0 implements Executor {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11860h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f11861i;

    public /* synthetic */ b0(int i10, Object obj) {
        this.f11860h = i10;
        this.f11861i = obj;
    }

    public final void execute(Runnable runnable) {
        int i10 = this.f11860h;
        Object obj = this.f11861i;
        switch (i10) {
            case 0:
                ((Handler) obj).post(runnable);
                return;
            case 1:
                ((Handler) obj).post(runnable);
                return;
            case 2:
                ((Handler) obj).post(runnable);
                return;
            case 3:
                ((Handler) obj).post(runnable);
                return;
            case 4:
                l0.L((Handler) obj, runnable);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                ((Handler) obj).post(runnable);
                return;
            case 6:
                ((Handler) obj).post(runnable);
                return;
            default:
                l0.L(((c0) obj).f6950o, runnable);
                return;
        }
    }
}
