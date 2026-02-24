package o1;

import android.support.v4.media.n;
import h3.j3;
import j1.l0;
import m1.k0;
import n1.b;
import n1.x;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11862h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ n f11863i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Exception f11864j;

    public /* synthetic */ c(n nVar, Exception exc, int i10) {
        this.f11862h = i10;
        this.f11863i = nVar;
        this.f11864j = exc;
    }

    public final void run() {
        int i10 = this.f11862h;
        Exception exc = this.f11864j;
        n nVar = this.f11863i;
        switch (i10) {
            case 0:
                int i11 = l0.f8453a;
                x xVar = (x) ((k0) nVar.f338j).f10314h.f10394r;
                b c02 = xVar.c0();
                xVar.d0(c02, 1029, new j3(c02, exc, 2));
                return;
            default:
                int i12 = l0.f8453a;
                x xVar2 = (x) ((k0) nVar.f338j).f10314h.f10394r;
                b c03 = xVar2.c0();
                xVar2.d0(c03, 1014, new j3(c03, exc, 1));
                return;
        }
    }
}
