package j4;

import dc.j;
import dc.l;
import dc.t;

public final class c extends t {

    /* renamed from: h  reason: collision with root package name */
    public Exception f8735h;

    public c(l lVar) {
        super(lVar);
    }

    public final long read(j jVar, long j10) {
        try {
            return super.read(jVar, j10);
        } catch (Exception e10) {
            this.f8735h = e10;
            throw e10;
        }
    }
}
