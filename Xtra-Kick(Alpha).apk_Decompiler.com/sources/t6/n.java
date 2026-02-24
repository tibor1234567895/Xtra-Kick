package t6;

import hb.c2;
import hb.h0;
import hb.p0;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import pa.e;
import xa.j;
import xa.r;

public final class n extends TimerTask {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ o f14636h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r f14637i;

    public n(o oVar, r rVar) {
        this.f14636h = oVar;
        this.f14637i = rVar;
    }

    public final void run() {
        boolean z10;
        o oVar = this.f14636h;
        double doubleValue = ((Number) oVar.f14641a.b()).doubleValue();
        r rVar = this.f14637i;
        double d10 = doubleValue - rVar.f16815h;
        if (0.0d > d10 || d10 > 20.0d) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            c2 c2Var = oVar.f14646f;
            if (c2Var != null) {
                c2Var.e((CancellationException) null);
                oVar.f14645e.clear();
                oVar.f14642b.b();
                oVar.f14646f = h0.b1(oVar.f14643c, p0.f7834b, 0, new m((e) null), 2);
            } else {
                j.l("offsetJob");
                throw null;
            }
        }
        rVar.f16815h = doubleValue;
    }
}
