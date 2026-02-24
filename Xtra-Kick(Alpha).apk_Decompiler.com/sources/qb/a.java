package qb;

import dc.j;
import dc.l;
import dc.p0;
import dc.s0;
import hb.h0;
import pb.u1;
import pb.x0;

public final class a extends u1 implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final x0 f13474h;

    /* renamed from: i  reason: collision with root package name */
    public final long f13475i;

    public a(x0 x0Var, long j10) {
        this.f13474h = x0Var;
        this.f13475i = j10;
    }

    public final void close() {
    }

    public final long contentLength() {
        return this.f13475i;
    }

    public final x0 contentType() {
        return this.f13474h;
    }

    public final long read(j jVar, long j10) {
        xa.j.f("sink", jVar);
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    public final l source() {
        return h0.o(this);
    }

    public final s0 timeout() {
        return s0.f4821d;
    }
}
