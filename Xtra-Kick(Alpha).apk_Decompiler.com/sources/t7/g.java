package t7;

import hb.f0;
import hb.h0;
import kb.j;
import kb.n;
import kb.o0;
import kb.t;
import la.v;
import pa.e;
import pa.h;
import ra.i;
import wa.q;

public final class g extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f14688i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f14689j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i10, k kVar, e eVar) {
        super(3, eVar);
        this.f14688i = i10;
        this.f14689j = kVar;
    }

    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
        switch (this.f14688i) {
            case 0:
                j jVar = (j) obj;
                Throwable th = (Throwable) obj2;
                return l((e) obj3);
            default:
                j jVar2 = (j) obj;
                Throwable th2 = (Throwable) obj2;
                return l((e) obj3);
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i10 = this.f14688i;
        k kVar = this.f14689j;
        switch (i10) {
            case 0:
                h0.O1(obj);
                boolean z10 = kVar.f14709h;
                if (z10) {
                    boolean z11 = kVar.f14710i;
                    f0 f0Var = kVar.f14705d;
                    if (z11) {
                        kVar.f14710i = false;
                        h0.b1(f0Var, (h) null, 0, new n(new t(new o0(new i(kVar.f14711j, kVar, (e) null)), new g(1, kVar, (e) null)), (e) null), 3);
                    } else if (z10) {
                        h0.b1(f0Var, (h) null, 0, new h(kVar, (e) null), 3);
                    }
                }
                return v.f9814a;
            default:
                h0.O1(obj);
                if (kVar.f14709h) {
                    k.a(kVar);
                }
                return v.f9814a;
        }
    }

    public final v l(e eVar) {
        int i10 = this.f14688i;
        k kVar = this.f14689j;
        switch (i10) {
            case 0:
                return (v) new g(0, kVar, eVar).invokeSuspend(v.f9814a);
            default:
                return (v) new g(1, kVar, eVar).invokeSuspend(v.f9814a);
        }
    }
}
