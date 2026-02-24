package wb;

import java.io.IOException;
import la.v;
import wa.a;
import xa.k;

public final class u extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ v f16308h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f16309i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f16310j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(v vVar, int i10, long j10) {
        super(0);
        this.f16308h = vVar;
        this.f16309i = i10;
        this.f16310j = j10;
    }

    public final Object b() {
        v vVar = this.f16308h;
        try {
            vVar.F.Y(this.f16309i, this.f16310j);
        } catch (IOException e10) {
            vVar.e(e10);
        }
        return v.f9814a;
    }
}
