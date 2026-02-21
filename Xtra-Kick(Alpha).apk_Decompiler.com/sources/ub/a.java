package ub;

import hb.h0;
import java.util.List;
import ma.r;
import pb.i1;
import pb.j1;
import pb.n0;
import pb.o1;
import pb.p0;
import pb.q1;
import pb.r1;
import pb.t0;
import pb.u0;
import pb.u1;
import pb.w;
import pb.x0;
import pb.z;
import qb.e;
import qb.h;
import xa.j;

public final class a implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final z f15466a;

    public a(z zVar) {
        j.f("cookieJar", zVar);
        this.f15466a = zVar;
    }

    public final r1 a(i iVar) {
        boolean z10;
        u1 u1Var;
        j1 j1Var = iVar.f15476e;
        j1Var.getClass();
        i1 i1Var = new i1(j1Var);
        o1 o1Var = j1Var.f12887d;
        if (o1Var != null) {
            x0 contentType = o1Var.contentType();
            if (contentType != null) {
                i1Var.c("Content-Type", contentType.f13024a);
            }
            long contentLength = o1Var.contentLength();
            if (contentLength != -1) {
                i1Var.c("Content-Length", String.valueOf(contentLength));
                i1Var.e("Transfer-Encoding");
            } else {
                i1Var.c("Transfer-Encoding", "chunked");
                i1Var.e("Content-Length");
            }
        }
        String b10 = j1Var.b("Host");
        int i10 = 0;
        t0 t0Var = j1Var.f12884a;
        if (b10 == null) {
            i1Var.c("Host", h.k(t0Var, false));
        }
        if (j1Var.b("Connection") == null) {
            i1Var.c("Connection", "Keep-Alive");
        }
        if (j1Var.b("Accept-Encoding") == null && j1Var.b("Range") == null) {
            i1Var.c("Accept-Encoding", "gzip");
            z10 = true;
        } else {
            z10 = false;
        }
        z zVar = this.f15466a;
        List b11 = zVar.b(t0Var);
        if (true ^ b11.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (Object next : b11) {
                int i11 = i10 + 1;
                if (i10 >= 0) {
                    w wVar = (w) next;
                    if (i10 > 0) {
                        sb2.append("; ");
                    }
                    sb2.append(wVar.f13014a);
                    sb2.append('=');
                    sb2.append(wVar.f13015b);
                    i10 = i11;
                } else {
                    r.h();
                    throw null;
                }
            }
            String sb3 = sb2.toString();
            j.e("StringBuilder().apply(builderAction).toString()", sb3);
            i1Var.c("Cookie", sb3);
        }
        if (j1Var.b("User-Agent") == null) {
            i1Var.c("User-Agent", "okhttp/5.0.0-alpha.11");
        }
        j1 j1Var2 = new j1(i1Var);
        r1 b12 = iVar.b(j1Var2);
        t0 t0Var2 = j1Var2.f12884a;
        p0 p0Var = b12.f12966m;
        g.b(zVar, t0Var2, p0Var);
        q1 q1Var = new q1(b12);
        q1Var.e(j1Var2);
        if (z10 && fb.w.g("gzip", r1.e(b12, "Content-Encoding")) && g.a(b12) && (u1Var = b12.f12967n) != null) {
            dc.w wVar2 = new dc.w(u1Var.source());
            n0 d10 = p0Var.d();
            d10.c("Content-Encoding");
            d10.c("Content-Length");
            q1Var.b(d10.b());
            q1Var.f12940g = new e(r1.e(b12, "Content-Type"), -1, h0.o(wVar2));
        }
        return q1Var.a();
    }
}
