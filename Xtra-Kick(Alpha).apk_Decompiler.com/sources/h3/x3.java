package h3;

import android.support.v4.media.h;

public final /* synthetic */ class x3 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7450h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y3 f7451i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7452j;

    public /* synthetic */ x3(y3 y3Var, int i10, int i11) {
        this.f7450h = i11;
        this.f7451i = y3Var;
        this.f7452j = i10;
    }

    public final void run() {
        int i10 = this.f7450h;
        int i11 = this.f7452j;
        y3 y3Var = this.f7451i;
        switch (i10) {
            case 0:
                a4 a4Var = y3Var.f7495f;
                if (a4Var.L0(26)) {
                    if (i11 == -100) {
                        a4Var.X(true);
                        return;
                    } else if (i11 == -1) {
                        a4Var.W();
                        return;
                    } else if (i11 != 1) {
                        boolean z10 = false;
                        if (i11 != 100) {
                            if (i11 != 101) {
                                h.z("onAdjustVolume: Ignoring unknown direction: ", i11, "VolumeProviderCompat");
                                return;
                            }
                            if (a4Var.L0(23) && a4Var.k0()) {
                                z10 = true;
                            }
                            z10 = !z10;
                        }
                        a4Var.X(z10);
                        return;
                    } else {
                        a4Var.n0();
                        return;
                    }
                } else {
                    return;
                }
            default:
                a4 a4Var2 = y3Var.f7495f;
                if (a4Var2.L0(25)) {
                    a4Var2.t0(i11);
                    return;
                }
                return;
        }
    }
}
