package vb;

import android.support.v4.media.h;
import dc.j;

public final class i extends c {

    /* renamed from: k  reason: collision with root package name */
    public boolean f16005k;

    public i(k kVar) {
        super(kVar);
    }

    public final void close() {
        if (!this.f15990i) {
            if (!this.f16005k) {
                c();
            }
            this.f15990i = true;
        }
    }

    public final long read(j jVar, long j10) {
        boolean z10;
        xa.j.f("sink", jVar);
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.k("byteCount < 0: ", j10).toString());
        } else if (!(!this.f15990i)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.f16005k) {
            return -1;
        } else {
            long read = super.read(jVar, j10);
            if (read != -1) {
                return read;
            }
            this.f16005k = true;
            c();
            return -1;
        }
    }
}
