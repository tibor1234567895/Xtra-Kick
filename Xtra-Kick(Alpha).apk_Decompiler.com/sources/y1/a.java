package y1;

import java.util.ArrayDeque;
import w2.c;
import w2.e;
import w2.i;

public final class a extends i {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f16858l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ e f16859m;

    public /* synthetic */ a(e eVar, int i10) {
        this.f16858l = i10;
        this.f16859m = eVar;
    }

    public final void h() {
        boolean z10;
        boolean z11 = false;
        switch (this.f16858l) {
            case 0:
                ArrayDeque arrayDeque = ((c) this.f16859m).f16864c;
                if (arrayDeque.size() < 2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                j1.a.e(z10);
                j1.a.b(true ^ arrayDeque.contains(this));
                this.f9501h = 0;
                this.f16065j = null;
                arrayDeque.addFirst(this);
                return;
            default:
                c cVar = (c) this.f16859m;
                synchronized (cVar.f16042b) {
                    this.f9501h = 0;
                    this.f16065j = null;
                    int i10 = cVar.f16048h;
                    cVar.f16048h = i10 + 1;
                    cVar.f16046f[i10] = this;
                    if (!cVar.f16043c.isEmpty() && cVar.f16048h > 0) {
                        z11 = true;
                    }
                    if (z11) {
                        cVar.f16042b.notify();
                    }
                }
                return;
        }
    }
}
