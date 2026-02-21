package rb;

import fb.w;
import hb.h0;
import pb.g0;
import pb.h1;
import pb.j1;
import pb.n0;
import pb.p0;
import pb.q1;
import pb.r1;
import pb.u0;
import qb.f;
import tb.o;
import ub.i;
import xa.j;

public final class b implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13898a = new a(0);

    public final r1 a(i iVar) {
        o oVar;
        Object obj;
        boolean z10;
        p0 p0Var;
        boolean z11;
        p0 p0Var2;
        boolean z12;
        i iVar2 = iVar;
        System.currentTimeMillis();
        j1 j1Var = iVar2.f15476e;
        j.f("request", j1Var);
        r1 r1Var = null;
        d dVar = new d(j1Var, (r1) null);
        if (j1Var.a().f12858j) {
            dVar = new d((j1) null, (r1) null);
        }
        o oVar2 = iVar2.f15472a;
        if (oVar2 instanceof o) {
            oVar = oVar2;
        } else {
            oVar = null;
        }
        if (oVar == null || (obj = oVar.f14984l) == null) {
            obj = g0.f12862a;
        }
        j1 j1Var2 = dVar.f13899a;
        r1 r1Var2 = dVar.f13900b;
        if (j1Var2 == null && r1Var2 == null) {
            q1 q1Var = new q1();
            q1Var.e(j1Var);
            q1Var.d(h1.HTTP_1_1);
            q1Var.f12936c = 504;
            q1Var.c("Unsatisfiable Request (only-if-cached)");
            q1Var.f12944k = -1;
            q1Var.f12945l = System.currentTimeMillis();
            r1 a10 = q1Var.a();
            obj.getClass();
            j.f("call", oVar2);
            return a10;
        } else if (j1Var2 == null) {
            j.c(r1Var2);
            q1 q1Var2 = new q1(r1Var2);
            r1 L1 = h0.L1(r1Var2);
            h0.y("cacheResponse", L1);
            q1Var2.f12942i = L1;
            r1 a11 = q1Var2.a();
            obj.getClass();
            j.f("call", oVar2);
            return a11;
        } else {
            if (r1Var2 != null) {
                obj.getClass();
                j.f("call", oVar2);
            }
            r1 b10 = iVar2.b(j1Var2);
            if (r1Var2 != null) {
                if (b10.f12964k == 304) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    q1 q1Var3 = new q1(r1Var2);
                    f13898a.getClass();
                    n0 n0Var = new n0();
                    p0 p0Var3 = r1Var2.f12966m;
                    int length = p0Var3.f12931h.length / 2;
                    int i10 = 0;
                    while (true) {
                        p0Var = b10.f12966m;
                        if (i10 >= length) {
                            break;
                        }
                        String c10 = p0Var3.c(i10);
                        String f10 = p0Var3.f(i10);
                        if (w.g("Warning", c10)) {
                            p0Var2 = p0Var3;
                            if (w.m(f10, "1", false)) {
                                i10++;
                                p0Var3 = p0Var2;
                            }
                        } else {
                            p0Var2 = p0Var3;
                        }
                        if (w.g("Content-Length", c10) || w.g("Content-Encoding", c10) || w.g("Content-Type", c10)) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12 || !a.a(c10) || p0Var.a(c10) == null) {
                            h0.C(n0Var, c10, f10);
                            i10++;
                            p0Var3 = p0Var2;
                        } else {
                            i10++;
                            p0Var3 = p0Var2;
                        }
                    }
                    int length2 = p0Var.f12931h.length / 2;
                    for (int i11 = 0; i11 < length2; i11++) {
                        String c11 = p0Var.c(i11);
                        if (w.g("Content-Length", c11) || w.g("Content-Encoding", c11) || w.g("Content-Type", c11)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11 && a.a(c11)) {
                            h0.C(n0Var, c11, p0Var.f(i11));
                        }
                    }
                    q1Var3.b(n0Var.b());
                    q1Var3.f12944k = b10.f12971r;
                    q1Var3.f12945l = b10.f12972s;
                    r1 L12 = h0.L1(r1Var2);
                    h0.y("cacheResponse", L12);
                    q1Var3.f12942i = L12;
                    r1 L13 = h0.L1(b10);
                    h0.y("networkResponse", L13);
                    q1Var3.f12941h = L13;
                    q1Var3.a();
                    b10.f12967n.close();
                    j.c((Object) null);
                    throw null;
                }
                f.b(r1Var2.f12967n);
            }
            q1 q1Var4 = new q1(b10);
            if (r1Var2 != null) {
                r1Var = h0.L1(r1Var2);
            }
            h0.y("cacheResponse", r1Var);
            q1Var4.f12942i = r1Var;
            r1 L14 = h0.L1(b10);
            h0.y("networkResponse", L14);
            q1Var4.f12941h = L14;
            return q1Var4.a();
        }
    }
}
