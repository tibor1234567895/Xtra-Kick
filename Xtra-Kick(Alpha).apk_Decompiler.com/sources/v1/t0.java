package v1;

import a2.i;
import d2.a0;
import g1.s0;
import k1.g;
import p0.c;
import p1.l;

public final class t0 implements z {

    /* renamed from: a  reason: collision with root package name */
    public final g f15788a;

    /* renamed from: b  reason: collision with root package name */
    public final c f15789b;

    /* renamed from: c  reason: collision with root package name */
    public l f15790c;

    /* renamed from: d  reason: collision with root package name */
    public i f15791d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15792e = 1048576;

    public t0(g gVar, a0 a0Var) {
        c cVar = new c(6, a0Var);
        l lVar = new l();
        i iVar = new i();
        this.f15788a = gVar;
        this.f15789b = cVar;
        this.f15790c = lVar;
        this.f15791d = iVar;
    }

    public final a a(s0 s0Var) {
        s0Var.f6557i.getClass();
        Object obj = s0Var.f6557i.f6484g;
        return new u0(s0Var, this.f15788a, this.f15789b, this.f15790c.b(s0Var), this.f15791d, this.f15792e);
    }

    public final z b(i iVar) {
        if (iVar != null) {
            this.f15791d = iVar;
            return this;
        }
        throw new NullPointerException("MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
    }

    public final z c(l lVar) {
        if (lVar != null) {
            this.f15790c = lVar;
            return this;
        }
        throw new NullPointerException("MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
    }
}
