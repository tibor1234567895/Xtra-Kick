package o1;

import android.support.v4.media.n;
import j1.l0;
import m1.k0;
import n1.b;
import n1.j;
import n1.x;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ n f11872h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f11873i;

    public /* synthetic */ e(n nVar, long j10) {
        this.f11872h = nVar;
        this.f11873i = j10;
    }

    public final void run() {
        int i10 = l0.f8453a;
        x xVar = (x) ((k0) this.f11872h.f338j).f10314h.f10394r;
        b c02 = xVar.c0();
        xVar.d0(c02, 1010, new j(c02, this.f11873i, 0));
    }
}
