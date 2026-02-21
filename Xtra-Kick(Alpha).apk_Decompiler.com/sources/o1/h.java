package o1;

import android.support.v4.media.n;
import androidx.appcompat.widget.j3;
import d9.r0;
import d9.v0;
import j1.l0;
import m1.k0;
import n1.b;
import n1.x;
import v1.a0;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11925h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f11926i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f11927j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f11928k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f11929l;

    public /* synthetic */ h(Object obj, int i10, long j10, long j11, int i11) {
        this.f11925h = i11;
        this.f11929l = obj;
        this.f11926i = i10;
        this.f11927j = j10;
        this.f11928k = j11;
    }

    public final void run() {
        a0 a0Var;
        int i10 = this.f11925h;
        Object obj = this.f11929l;
        switch (i10) {
            case 0:
                int i11 = this.f11926i;
                long j10 = this.f11927j;
                long j11 = this.f11928k;
                int i12 = l0.f8453a;
                x xVar = (x) ((k0) ((n) obj).f338j).f10314h.f10394r;
                b c02 = xVar.c0();
                xVar.d0(c02, 1011, new n1.n(c02, i11, j10, j11, 0));
                return;
            default:
                int i13 = this.f11926i;
                long j12 = this.f11927j;
                long j13 = this.f11928k;
                x xVar2 = (x) ((a2.b) obj).f19b;
                j3 j3Var = xVar2.f11000k;
                if (((r0) j3Var.f895b).isEmpty()) {
                    a0Var = null;
                } else {
                    a0Var = (a0) v0.a((r0) j3Var.f895b);
                }
                b a02 = xVar2.a0(a0Var);
                xVar2.d0(a02, 1006, new n1.n(a02, i13, j12, j13, 1));
                return;
        }
    }
}
