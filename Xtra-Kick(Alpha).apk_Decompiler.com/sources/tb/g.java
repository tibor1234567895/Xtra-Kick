package tb;

import androidx.lifecycle.p1;
import dc.k;
import dc.l;
import hb.h0;
import java.io.IOException;
import java.net.Socket;
import pb.g0;
import pb.j1;
import pb.o1;
import pb.q1;
import pb.r1;
import ub.e;
import ub.f;
import xa.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final o f14960a;

    /* renamed from: b  reason: collision with root package name */
    public final g0 f14961b;

    /* renamed from: c  reason: collision with root package name */
    public final h f14962c;

    /* renamed from: d  reason: collision with root package name */
    public final f f14963d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14964e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14965f;

    public g(o oVar, g0 g0Var, h hVar, f fVar) {
        j.f("eventListener", g0Var);
        this.f14960a = oVar;
        this.f14961b = g0Var;
        this.f14962c = hVar;
        this.f14963d = fVar;
    }

    public final IOException a(boolean z10, boolean z11, IOException iOException) {
        if (iOException != null) {
            g(iOException);
        }
        g0 g0Var = this.f14961b;
        o oVar = this.f14960a;
        if (z11) {
            g0Var.getClass();
            if (iOException != null) {
                j.f("call", oVar);
            } else {
                j.f("call", oVar);
            }
        }
        if (z10) {
            if (iOException != null) {
                g0Var.getClass();
                j.f("call", oVar);
            } else {
                g0Var.getClass();
                j.f("call", oVar);
            }
        }
        return oVar.h(this, z11, z10, iOException);
    }

    public final e b(j1 j1Var, boolean z10) {
        this.f14964e = z10;
        o1 o1Var = j1Var.f12887d;
        j.c(o1Var);
        long contentLength = o1Var.contentLength();
        this.f14961b.getClass();
        j.f("call", this.f14960a);
        return new e(this, this.f14963d.h(j1Var, contentLength), contentLength);
    }

    public final r c() {
        e e10 = this.f14963d.e();
        r rVar = e10 instanceof r ? (r) e10 : null;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels".toString());
    }

    public final q d() {
        o oVar = this.f14960a;
        if (!oVar.f14990r) {
            oVar.f14990r = true;
            oVar.f14985m.j();
            e e10 = this.f14963d.e();
            j.d("null cannot be cast to non-null type okhttp3.internal.connection.RealConnection", e10);
            r rVar = (r) e10;
            Socket socket = rVar.f15005e;
            j.c(socket);
            l lVar = rVar.f15008h;
            j.c(lVar);
            k kVar = rVar.f15009i;
            j.c(kVar);
            socket.setSoTimeout(0);
            rVar.g();
            return new q(lVar, kVar, this);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final qb.e e(r1 r1Var) {
        f fVar = this.f14963d;
        try {
            String e10 = r1.e(r1Var, "Content-Type");
            long a10 = fVar.a(r1Var);
            return new qb.e(e10, a10, h0.o(new f(this, fVar.f(r1Var), a10)));
        } catch (IOException e11) {
            this.f14961b.getClass();
            j.f("call", this.f14960a);
            g(e11);
            throw e11;
        }
    }

    public final q1 f(boolean z10) {
        try {
            q1 i10 = this.f14963d.i(z10);
            if (i10 != null) {
                i10.f12946m = this;
                i10.f12947n = new p1(26, this);
            }
            return i10;
        } catch (IOException e10) {
            this.f14961b.getClass();
            j.f("call", this.f14960a);
            g(e10);
            throw e10;
        }
    }

    public final void g(IOException iOException) {
        this.f14965f = true;
        this.f14963d.e().h(this.f14960a, iOException);
    }
}
