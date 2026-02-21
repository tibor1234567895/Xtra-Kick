package vb;

import dc.j;
import dc.p0;
import dc.s0;
import dc.u;
import java.io.IOException;

public abstract class c implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final u f15989h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15990i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f15991j;

    public c(k kVar) {
        this.f15991j = kVar;
        this.f15989h = new u(kVar.f16009c.timeout());
    }

    public final void c() {
        k kVar = this.f15991j;
        int i10 = kVar.f16011e;
        if (i10 != 6) {
            if (i10 == 5) {
                k.j(kVar, this.f15989h);
                kVar.f16011e = 6;
                return;
            }
            throw new IllegalStateException("state: " + kVar.f16011e);
        }
    }

    public long read(j jVar, long j10) {
        k kVar = this.f15991j;
        xa.j.f("sink", jVar);
        try {
            return kVar.f16009c.read(jVar, j10);
        } catch (IOException e10) {
            kVar.f16008b.g();
            c();
            throw e10;
        }
    }

    public final s0 timeout() {
        return this.f15989h;
    }
}
