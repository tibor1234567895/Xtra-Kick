package wb;

import java.io.IOException;
import la.v;
import wa.a;
import xa.j;
import xa.k;

public final class t extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16304h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ v f16305i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f16306j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ c f16307k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(v vVar, int i10, c cVar, int i11) {
        super(0);
        this.f16304h = i11;
        this.f16305i = vVar;
        this.f16306j = i10;
        this.f16307k = cVar;
    }

    public final void a() {
        switch (this.f16304h) {
            case 0:
                l0 l0Var = this.f16305i.f16322s;
                c cVar = this.f16307k;
                l0Var.getClass();
                j.f("errorCode", cVar);
                v vVar = this.f16305i;
                int i10 = this.f16306j;
                synchronized (vVar) {
                    vVar.H.remove(Integer.valueOf(i10));
                    v vVar2 = v.f9814a;
                }
                return;
            default:
                v vVar3 = this.f16305i;
                try {
                    int i11 = this.f16306j;
                    c cVar2 = this.f16307k;
                    vVar3.getClass();
                    j.f("statusCode", cVar2);
                    vVar3.F.N(i11, cVar2);
                    return;
                } catch (IOException e10) {
                    vVar3.e(e10);
                    return;
                }
        }
    }

    public final /* bridge */ /* synthetic */ Object b() {
        switch (this.f16304h) {
            case 0:
                a();
                return v.f9814a;
            default:
                a();
                return v.f9814a;
        }
    }
}
