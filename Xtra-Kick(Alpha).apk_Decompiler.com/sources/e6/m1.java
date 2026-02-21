package e6;

import a6.c0;
import a6.z;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import wa.p;

public final class m1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ o1 f5186i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OfflineVideo f5187j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m1(o1 o1Var, OfflineVideo offlineVideo, e eVar) {
        super(2, eVar);
        this.f5186i = o1Var;
        this.f5187j = offlineVideo;
    }

    public final e create(Object obj, e eVar) {
        return new m1(this.f5186i, this.f5187j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((m1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        z zVar = this.f5186i.f5207a;
        OfflineVideo offlineVideo = this.f5187j;
        c0 c0Var = (c0) zVar;
        n0 n0Var = c0Var.f221a;
        n0Var.b();
        n0Var.c();
        try {
            c0Var.f224d.i(offlineVideo);
            n0Var.r();
            n0Var.g();
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }
}
