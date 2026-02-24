package ob;

import la.v;
import wa.l;
import xa.k;

public final class b extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12368h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f12369i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c f12370j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar, c cVar, int i10) {
        super(1);
        this.f12368h = i10;
        this.f12369i = dVar;
        this.f12370j = cVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f12368h) {
            case 0:
                invoke((Throwable) obj);
                return v.f9814a;
            default:
                invoke((Throwable) obj);
                return v.f9814a;
        }
    }

    public final void invoke(Throwable th) {
        int i10 = this.f12368h;
        d dVar = this.f12369i;
        c cVar = this.f12370j;
        switch (i10) {
            case 0:
                dVar.f(cVar.f12372i);
                return;
            default:
                d.f12374h.set(dVar, cVar.f12372i);
                dVar.f(cVar.f12372i);
                return;
        }
    }
}
