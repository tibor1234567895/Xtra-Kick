package ec;

import dc.j;
import dc.p0;
import dc.t;
import java.io.IOException;

public final class b extends t {

    /* renamed from: h  reason: collision with root package name */
    public final long f5358h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5359i;

    /* renamed from: j  reason: collision with root package name */
    public long f5360j;

    public b(p0 p0Var, long j10, boolean z10) {
        super(p0Var);
        this.f5358h = j10;
        this.f5359i = z10;
    }

    public final long read(j jVar, long j10) {
        xa.j.f("sink", jVar);
        long j11 = this.f5360j;
        long j12 = this.f5358h;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f5359i) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1;
            }
            j10 = Math.min(j10, j13);
        }
        long read = super.read(jVar, j10);
        int i10 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
        if (i10 != 0) {
            this.f5360j += read;
        }
        long j14 = this.f5360j;
        int i11 = (j14 > j12 ? 1 : (j14 == j12 ? 0 : -1));
        if ((i11 >= 0 || i10 != 0) && i11 <= 0) {
            return read;
        }
        if (read > 0 && i11 > 0) {
            j jVar2 = new j();
            jVar2.F0(jVar);
            jVar.o0(jVar2, jVar.f4787i - (j14 - j12));
            jVar2.c();
        }
        throw new IOException("expected " + j12 + " bytes but got " + this.f5360j);
    }
}
