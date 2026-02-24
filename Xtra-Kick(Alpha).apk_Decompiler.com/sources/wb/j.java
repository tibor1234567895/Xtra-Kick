package wb;

import cc.g;
import cc.m;
import dc.n;
import java.io.IOException;
import java.net.SocketTimeoutException;
import la.v;
import pb.r1;
import wa.a;
import xa.k;

public final class j extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16267h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f16268i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f16269j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i10, long j10, Object obj) {
        super(0);
        this.f16267h = i10;
        this.f16269j = obj;
        this.f16268i = j10;
    }

    private final Long c() {
        int i10;
        g gVar = (g) this.f16269j;
        synchronized (gVar) {
            if (!gVar.f3113u) {
                m mVar = gVar.f3103k;
                if (mVar != null) {
                    if (gVar.f3115w) {
                        i10 = gVar.f3114v;
                    } else {
                        i10 = -1;
                    }
                    gVar.f3114v++;
                    gVar.f3115w = true;
                    v vVar = v.f9814a;
                    if (i10 != -1) {
                        e = new SocketTimeoutException("sent ping but didn't receive pong within " + gVar.f3096d + "ms (after " + (i10 - 1) + " successful ping/pongs)");
                    } else {
                        try {
                            n nVar = n.f4803l;
                            xa.j.f("payload", nVar);
                            mVar.c(9, nVar);
                        } catch (IOException e10) {
                            e = e10;
                        }
                    }
                    gVar.c(e, (r1) null);
                }
            }
        }
        return Long.valueOf(this.f16268i);
    }

    public final Long a() {
        boolean z10;
        long j10;
        switch (this.f16267h) {
            case 0:
                v vVar = (v) this.f16269j;
                synchronized (vVar) {
                    long j11 = vVar.f16324u;
                    long j12 = vVar.f16323t;
                    if (j11 < j12) {
                        z10 = true;
                    } else {
                        vVar.f16323t = j12 + 1;
                        z10 = false;
                    }
                }
                v vVar2 = (v) this.f16269j;
                if (z10) {
                    vVar2.e((IOException) null);
                    j10 = -1;
                } else {
                    vVar2.getClass();
                    try {
                        vVar2.F.z(1, 0, false);
                    } catch (IOException e10) {
                        vVar2.e(e10);
                    }
                    j10 = this.f16268i;
                }
                return Long.valueOf(j10);
            default:
                return c();
        }
    }

    public final /* bridge */ /* synthetic */ Object b() {
        switch (this.f16267h) {
            case 0:
                return a();
            default:
                return a();
        }
    }
}
