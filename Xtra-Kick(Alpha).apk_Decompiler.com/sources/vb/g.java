package vb;

import dc.j;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import qb.h;

public final class g extends c {

    /* renamed from: k  reason: collision with root package name */
    public long f15999k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ k f16000l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(k kVar, long j10) {
        super(kVar);
        this.f16000l = kVar;
        this.f15999k = j10;
        if (j10 == 0) {
            c();
        }
    }

    public final void close() {
        if (!this.f15990i) {
            if (this.f15999k != 0 && !h.d(this, TimeUnit.MILLISECONDS)) {
                this.f16000l.f16008b.g();
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
            throw new IllegalArgumentException(android.support.v4.media.h.k("byteCount < 0: ", j10).toString());
        } else if (!this.f15990i) {
            long j11 = this.f15999k;
            if (j11 == 0) {
                return -1;
            }
            long read = super.read(jVar, Math.min(j11, j10));
            if (read != -1) {
                long j12 = this.f15999k - read;
                this.f15999k = j12;
                if (j12 == 0) {
                    c();
                }
                return read;
            }
            this.f16000l.f16008b.g();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            c();
            throw protocolException;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }
}
