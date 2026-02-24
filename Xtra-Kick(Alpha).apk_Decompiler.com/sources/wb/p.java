package wb;

import java.io.IOException;
import la.v;
import wa.a;
import xa.k;

public final class p extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ v f16289h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f16290i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f16291j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(v vVar, int i10, int i11) {
        super(0);
        this.f16289h = vVar;
        this.f16290i = i10;
        this.f16291j = i11;
    }

    public final Object b() {
        int i10 = this.f16290i;
        int i11 = this.f16291j;
        v vVar = this.f16289h;
        vVar.getClass();
        try {
            vVar.F.z(i10, i11, true);
        } catch (IOException e10) {
            vVar.e(e10);
        }
        return v.f9814a;
    }
}
