package d5;

import android.os.Handler;
import android.os.Looper;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4482a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f4483b = new Handler(Looper.getMainLooper(), new r0());

    public final synchronized void a(o0 o0Var, boolean z10) {
        if (!this.f4482a) {
            if (!z10) {
                this.f4482a = true;
                o0Var.e();
                this.f4482a = false;
            }
        }
        this.f4483b.obtainMessage(1, o0Var).sendToTarget();
    }
}
