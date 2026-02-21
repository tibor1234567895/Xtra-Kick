package androidx.media3.exoplayer.hls;

import a2.i;
import g1.s0;
import java.util.List;
import k1.g;
import q1.c;
import q1.d;
import q1.l;
import q1.q;
import r1.a;
import r1.e;
import r1.t;
import r1.u;
import r1.x;
import v1.k;
import v1.z;

public final class HlsMediaSource$Factory implements z {

    /* renamed from: a  reason: collision with root package name */
    public final c f1814a;

    /* renamed from: b  reason: collision with root package name */
    public final d f1815b = l.f13186a;

    /* renamed from: c  reason: collision with root package name */
    public t f1816c = new a();

    /* renamed from: d  reason: collision with root package name */
    public u f1817d = r1.d.f13542v;

    /* renamed from: e  reason: collision with root package name */
    public final k f1818e = new k();

    /* renamed from: f  reason: collision with root package name */
    public p1.l f1819f = new p1.l();

    /* renamed from: g  reason: collision with root package name */
    public i f1820g = new i();

    /* renamed from: h  reason: collision with root package name */
    public boolean f1821h = true;

    /* renamed from: i  reason: collision with root package name */
    public final int f1822i = 1;

    /* renamed from: j  reason: collision with root package name */
    public final long f1823j = -9223372036854775807L;

    public HlsMediaSource$Factory(g gVar) {
        this.f1814a = new c(gVar);
    }

    public final z b(i iVar) {
        if (iVar != null) {
            this.f1820g = iVar;
            return this;
        }
        throw new NullPointerException("MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
    }

    public final z c(p1.l lVar) {
        if (lVar != null) {
            this.f1819f = lVar;
            return this;
        }
        throw new NullPointerException("MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
    }

    /* renamed from: d */
    public final q a(s0 s0Var) {
        x cVar;
        s0Var.f6557i.getClass();
        t tVar = this.f1816c;
        List list = s0Var.f6557i.f6481d;
        if (!list.isEmpty()) {
            tVar = new e(tVar, list);
        }
        c cVar2 = this.f1814a;
        d dVar = this.f1815b;
        k kVar = this.f1818e;
        p1.u b10 = this.f1819f.b(s0Var);
        i iVar = this.f1820g;
        int i10 = ((f3.a) this.f1817d).f5475h;
        c cVar3 = this.f1814a;
        switch (i10) {
            case 0:
                cVar = new r1.d(cVar3, iVar, tVar);
                break;
            default:
                cVar = new d6.c(cVar3, iVar, tVar);
                break;
        }
        return new q(s0Var, cVar2, dVar, kVar, b10, iVar, cVar, this.f1823j, this.f1821h, this.f1822i);
    }
}
