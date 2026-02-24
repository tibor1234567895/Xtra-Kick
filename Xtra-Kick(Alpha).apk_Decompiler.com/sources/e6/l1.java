package e6;

import a6.c;
import a6.c0;
import a6.z;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import u3.o;
import wa.p;

public final class l1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ o1 f5177i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfflineVideo f5178j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l1(o1 o1Var, OfflineVideo offlineVideo, e eVar) {
        super(2, eVar);
        this.f5177i = o1Var;
        this.f5178j = offlineVideo;
    }

    public final e create(Object obj, e eVar) {
        return new l1(this.f5177i, this.f5178j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        c cVar;
        o c10;
        h0.O1(obj);
        z zVar = this.f5177i.f5207a;
        OfflineVideo offlineVideo = this.f5178j;
        c0 c0Var = (c0) zVar;
        n0 n0Var = c0Var.f221a;
        n0Var.b();
        n0Var.c();
        try {
            cVar = c0Var.f222b;
            c10 = cVar.c();
            cVar.h(c10, offlineVideo);
            long A0 = c10.A0();
            cVar.g(c10);
            n0Var.r();
            n0Var.g();
            return new Long(A0);
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
