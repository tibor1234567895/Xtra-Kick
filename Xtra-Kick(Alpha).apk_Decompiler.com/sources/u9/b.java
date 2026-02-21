package u9;

import java.util.List;
import p9.f;
import p9.l;
import p9.x;
import q9.e;
import x9.a;
import xa.j;
import y9.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f15441a;

    /* renamed from: b  reason: collision with root package name */
    public final a f15442b;

    /* renamed from: c  reason: collision with root package name */
    public final l f15443c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f15444d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15445e;

    public b(a aVar, l lVar, boolean z10, int i10) {
        j.g("downloadInfoUpdater", aVar);
        j.g("fetchListener", lVar);
        this.f15442b = aVar;
        this.f15443c = lVar;
        this.f15444d = z10;
        this.f15445e = i10;
    }

    public final void a(e eVar) {
        if (!this.f15441a) {
            eVar.K(x.COMPLETED);
            this.f15442b.b(eVar);
            this.f15443c.a(eVar);
        }
    }

    public final void b(e eVar, d dVar, int i10) {
        j.g("download", eVar);
        j.g("downloadBlock", dVar);
        if (!this.f15441a) {
            this.f15443c.i(eVar, dVar, i10);
        }
    }

    public final void c(e eVar, f fVar, Exception exc) {
        j.g("download", eVar);
        if (!this.f15441a) {
            int i10 = this.f15445e;
            if (i10 == -1) {
                i10 = eVar.f13451z;
            }
            if (!this.f15444d || eVar.f13443r != f.NO_NETWORK_CONNECTION) {
                int i11 = eVar.A;
                if (i11 < i10) {
                    eVar.A = i11 + 1;
                } else {
                    eVar.K(x.FAILED);
                    this.f15442b.b(eVar);
                    this.f15443c.b(eVar, fVar, exc);
                    return;
                }
            }
            eVar.K(x.QUEUED);
            eVar.D(a.f16791d);
            this.f15442b.b(eVar);
            this.f15443c.c(eVar, true);
        }
    }

    public final void d(e eVar, long j10, long j11) {
        j.g("download", eVar);
        if (!this.f15441a) {
            this.f15443c.d(eVar, j10, j11);
        }
    }

    public final void e(e eVar, List list, int i10) {
        j.g("download", eVar);
        if (!this.f15441a) {
            eVar.K(x.DOWNLOADING);
            this.f15442b.b(eVar);
            this.f15443c.g(eVar, list, i10);
        }
    }

    public final void f(e eVar) {
        j.g("download", eVar);
        if (!this.f15441a) {
            eVar.K(x.DOWNLOADING);
            a aVar = this.f15442b;
            aVar.getClass();
            aVar.f15440a.V(eVar);
        }
    }
}
