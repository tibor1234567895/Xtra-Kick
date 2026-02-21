package e6;

import a6.x;
import a6.y;
import com.github.andreyasadchy.xtra.model.VideoPosition;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class y1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ z1 f5276i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VideoPosition f5277j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y1(z1 z1Var, VideoPosition videoPosition, e eVar) {
        super(2, eVar);
        this.f5276i = z1Var;
        this.f5277j = videoPosition;
    }

    public final e create(Object obj, e eVar) {
        return new y1(this.f5276i, this.f5277j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((y1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        x xVar = this.f5276i.f5285c;
        VideoPosition videoPosition = this.f5277j;
        y yVar = (y) xVar;
        n0 n0Var = yVar.f265a;
        n0Var.b();
        n0Var.c();
        try {
            yVar.f266b.k(videoPosition);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
