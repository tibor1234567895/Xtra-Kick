package h3;

import android.os.IBinder;
import java.util.Objects;

public final /* synthetic */ class e0 implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f6993a;

    public /* synthetic */ e0(y0 y0Var) {
        this.f6993a = y0Var;
    }

    public final void binderDied() {
        b0 b0Var = this.f6993a.f7453a;
        Objects.requireNonNull(b0Var);
        b0Var.S0(new r0(b0Var, 1));
    }
}
