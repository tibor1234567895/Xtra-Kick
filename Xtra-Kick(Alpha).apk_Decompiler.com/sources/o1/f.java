package o1;

import android.support.v4.media.n;
import j1.l0;
import m1.k0;
import n1.b;
import n1.e;
import n1.x;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11906h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f11907i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f11908j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f11909k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f11910l;

    public /* synthetic */ f(Object obj, String str, long j10, long j11, int i10) {
        this.f11906h = i10;
        this.f11910l = obj;
        this.f11907i = str;
        this.f11908j = j10;
        this.f11909k = j11;
    }

    public final void run() {
        int i10 = this.f11906h;
        Object obj = this.f11910l;
        switch (i10) {
            case 0:
                String str = this.f11907i;
                long j10 = this.f11908j;
                long j11 = this.f11909k;
                int i11 = l0.f8453a;
                x xVar = (x) ((k0) ((n) obj).f338j).f10314h.f10394r;
                b c02 = xVar.c0();
                xVar.d0(c02, 1008, new e(c02, str, j11, j10, 1));
                return;
            default:
                b2.x xVar2 = (b2.x) obj;
                String str2 = this.f11907i;
                long j12 = this.f11908j;
                long j13 = this.f11909k;
                xVar2.getClass();
                int i12 = l0.f8453a;
                x xVar3 = (x) ((k0) xVar2.f2512b).f10314h.f10394r;
                b c03 = xVar3.c0();
                xVar3.d0(c03, 1016, new e(c03, str2, j13, j12, 0));
                return;
        }
    }
}
