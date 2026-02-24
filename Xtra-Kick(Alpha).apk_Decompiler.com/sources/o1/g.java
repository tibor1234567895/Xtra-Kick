package o1;

import android.support.v4.media.n;
import j1.l0;
import m1.k0;
import m1.n0;
import m1.w;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ n f11917h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f11918i;

    public /* synthetic */ g(n nVar, boolean z10) {
        this.f11917h = nVar;
        this.f11918i = z10;
    }

    public final void run() {
        int i10 = l0.f8453a;
        n0 n0Var = ((k0) this.f11917h.f338j).f10314h;
        boolean z10 = n0Var.f10369b0;
        boolean z11 = this.f11918i;
        if (z10 != z11) {
            n0Var.f10369b0 = z11;
            n0Var.f10388l.m(23, new w(1, z11));
        }
    }
}
