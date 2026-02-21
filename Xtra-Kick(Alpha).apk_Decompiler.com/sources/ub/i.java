package ub;

import java.util.List;
import pb.j1;
import pb.r1;
import pb.u0;
import tb.g;
import tb.o;
import xa.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final o f15472a;

    /* renamed from: b  reason: collision with root package name */
    public final List f15473b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15474c;

    /* renamed from: d  reason: collision with root package name */
    public final g f15475d;

    /* renamed from: e  reason: collision with root package name */
    public final j1 f15476e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15477f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15478g;

    /* renamed from: h  reason: collision with root package name */
    public final int f15479h;

    /* renamed from: i  reason: collision with root package name */
    public int f15480i;

    public i(o oVar, List list, int i10, g gVar, j1 j1Var, int i11, int i12, int i13) {
        j.f("call", oVar);
        j.f("interceptors", list);
        j.f("request", j1Var);
        this.f15472a = oVar;
        this.f15473b = list;
        this.f15474c = i10;
        this.f15475d = gVar;
        this.f15476e = j1Var;
        this.f15477f = i11;
        this.f15478g = i12;
        this.f15479h = i13;
    }

    public static i a(i iVar, int i10, g gVar, j1 j1Var, int i11) {
        int i12;
        int i13;
        int i14;
        if ((i11 & 1) != 0) {
            i10 = iVar.f15474c;
        }
        int i15 = i10;
        if ((i11 & 2) != 0) {
            gVar = iVar.f15475d;
        }
        g gVar2 = gVar;
        if ((i11 & 4) != 0) {
            j1Var = iVar.f15476e;
        }
        j1 j1Var2 = j1Var;
        if ((i11 & 8) != 0) {
            i12 = iVar.f15477f;
        } else {
            i12 = 0;
        }
        if ((i11 & 16) != 0) {
            i13 = iVar.f15478g;
        } else {
            i13 = 0;
        }
        if ((i11 & 32) != 0) {
            i14 = iVar.f15479h;
        } else {
            i14 = 0;
        }
        iVar.getClass();
        j.f("request", j1Var2);
        return new i(iVar.f15472a, iVar.f15473b, i15, gVar2, j1Var2, i12, i13, i14);
    }

    public final r1 b(j1 j1Var) {
        boolean z10;
        boolean z11;
        j.f("request", j1Var);
        List list = this.f15473b;
        int size = list.size();
        boolean z12 = false;
        int i10 = this.f15474c;
        if (i10 < size) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f15480i++;
            g gVar = this.f15475d;
            if (gVar != null) {
                if (gVar.f14962c.b().f(j1Var.f12884a)) {
                    if (this.f15480i == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException(("network interceptor " + list.get(i10 - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + list.get(i10 - 1) + " must retain the same host and port").toString());
                }
            }
            int i11 = i10 + 1;
            i a10 = a(this, i11, (g) null, j1Var, 58);
            u0 u0Var = (u0) list.get(i10);
            r1 a11 = u0Var.a(a10);
            if (a11 != null) {
                if (gVar != null) {
                    if (i11 >= list.size() || a10.f15480i == 1) {
                        z12 = true;
                    }
                    if (!z12) {
                        throw new IllegalStateException(("network interceptor " + u0Var + " must call proceed() exactly once").toString());
                    }
                }
                return a11;
            }
            throw new NullPointerException("interceptor " + u0Var + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
