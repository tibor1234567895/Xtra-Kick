package h3;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import h9.k0;

public final class f1 extends ResultReceiver {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ k0 f7022h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f1(Handler handler, k0 k0Var) {
        super(handler);
        this.f7022h = k0Var;
    }

    public final void onReceiveResult(int i10, Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.f7022h.l(new j4(i10, bundle));
    }
}
