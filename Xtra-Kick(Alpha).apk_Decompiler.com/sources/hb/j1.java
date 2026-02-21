package hb;

import la.v;
import pa.e;
import wa.l;

public final class j1 extends p1 {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7814l;

    /* renamed from: m  reason: collision with root package name */
    public final Object f7815m;

    public /* synthetic */ j1(int i10, Object obj) {
        this.f7814l = i10;
        this.f7815m = obj;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f7814l) {
            case 0:
                o((Throwable) obj);
                return v.f9814a;
            case 1:
                o((Throwable) obj);
                return v.f9814a;
            default:
                o((Throwable) obj);
                return v.f9814a;
        }
    }

    public final void o(Throwable th) {
        Object obj;
        int i10 = this.f7814l;
        Object obj2 = this.f7815m;
        switch (i10) {
            case 0:
                ((l) obj2).invoke(th);
                return;
            case 1:
                Object H = p().H();
                l lVar = (l) obj2;
                if (H instanceof w) {
                    int i11 = la.l.f9802h;
                    obj = h0.I(((w) H).f7875a);
                } else {
                    int i12 = la.l.f9802h;
                    obj = v1.a(H);
                }
                lVar.resumeWith(obj);
                return;
            default:
                int i13 = la.l.f9802h;
                ((e) obj2).resumeWith(v.f9814a);
                return;
        }
    }
}
