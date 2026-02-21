package n3;

import la.v;
import wa.l;
import xa.k;

public final class j5 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11267h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ hb.k f11268i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j5(hb.l lVar, int i10) {
        super(1);
        this.f11267h = i10;
        this.f11268i = lVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f11267h) {
            case 0:
                invoke((Throwable) obj);
                return v.f9814a;
            default:
                invoke((Throwable) obj);
                return v.f9814a;
        }
    }

    public final void invoke(Throwable th) {
        int i10 = this.f11267h;
        hb.k kVar = this.f11268i;
        switch (i10) {
            case 0:
                v vVar = v.f9814a;
                int i11 = la.l.f9802h;
                kVar.resumeWith(vVar);
                return;
            default:
                int i12 = la.l.f9802h;
                kVar.resumeWith(v.f9814a);
                return;
        }
    }
}
