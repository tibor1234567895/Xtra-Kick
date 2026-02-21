package vb;

import dc.j;
import dc.n0;
import dc.s0;
import dc.u;

public final class d implements n0 {

    /* renamed from: h  reason: collision with root package name */
    public final u f15992h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15993i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f15994j;

    public d(k kVar) {
        this.f15994j = kVar;
        this.f15992h = new u(kVar.f16010d.timeout());
    }

    public final synchronized void close() {
        if (!this.f15993i) {
            this.f15993i = true;
            this.f15994j.f16010d.v0("0\r\n\r\n");
            k.j(this.f15994j, this.f15992h);
            this.f15994j.f16011e = 3;
        }
    }

    public final synchronized void flush() {
        if (!this.f15993i) {
            this.f15994j.f16010d.flush();
        }
    }

    public final void o0(j jVar, long j10) {
        xa.j.f("source", jVar);
        if (!(!this.f15993i)) {
            throw new IllegalStateException("closed".toString());
        } else if (j10 != 0) {
            k kVar = this.f15994j;
            kVar.f16010d.l(j10);
            kVar.f16010d.v0("\r\n");
            kVar.f16010d.o0(jVar, j10);
            kVar.f16010d.v0("\r\n");
        }
    }

    public final s0 timeout() {
        return this.f15992h;
    }
}
