package w4;

import hb.h0;
import hb.k;
import java.io.IOException;
import la.v;
import pb.i;
import pb.j;
import pb.r1;
import tb.o;
import wa.l;

public final class f implements j, l {

    /* renamed from: h  reason: collision with root package name */
    public final i f16083h;

    /* renamed from: i  reason: collision with root package name */
    public final k f16084i;

    public f(o oVar, hb.l lVar) {
        this.f16083h = oVar;
        this.f16084i = lVar;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        try {
            ((o) this.f16083h).cancel();
        } catch (Throwable unused) {
        }
        return v.f9814a;
    }

    public final void onFailure(i iVar, IOException iOException) {
        if (!((o) iVar).f14995w) {
            k kVar = this.f16084i;
            int i10 = la.l.f9802h;
            kVar.resumeWith(h0.I(iOException));
        }
    }

    public final void onResponse(i iVar, r1 r1Var) {
        int i10 = la.l.f9802h;
        this.f16084i.resumeWith(r1Var);
    }
}
