package q9;

import java.util.ArrayList;
import java.util.List;
import la.i;
import la.v;
import p9.s;
import t9.o;
import xa.j;
import y9.l;

public final class h implements f {

    /* renamed from: h  reason: collision with root package name */
    public final Object f13464h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public final f f13465i;

    public h(g gVar) {
        this.f13465i = gVar;
        l lVar = gVar.f13460p;
    }

    public final long B0(boolean z10) {
        long B0;
        synchronized (this.f13464h) {
            B0 = this.f13465i.B0(z10);
        }
        return B0;
    }

    public final List G(int i10) {
        List G;
        synchronized (this.f13464h) {
            G = this.f13465i.G(i10);
        }
        return G;
    }

    public final void I(e eVar) {
        j.g("downloadInfo", eVar);
        synchronized (this.f13464h) {
            this.f13465i.I(eVar);
            v vVar = v.f9814a;
        }
    }

    public final void J(o oVar) {
        synchronized (this.f13464h) {
            this.f13465i.J(oVar);
            v vVar = v.f9814a;
        }
    }

    public final List L0(List list) {
        List L0;
        synchronized (this.f13464h) {
            L0 = this.f13465i.L0(list);
        }
        return L0;
    }

    public final e P() {
        return this.f13465i.P();
    }

    public final void V(e eVar) {
        j.g("downloadInfo", eVar);
        synchronized (this.f13464h) {
            this.f13465i.V(eVar);
            v vVar = v.f9814a;
        }
    }

    public final void close() {
        synchronized (this.f13464h) {
            this.f13465i.close();
            v vVar = v.f9814a;
        }
    }

    public final o d() {
        o d10;
        synchronized (this.f13464h) {
            d10 = this.f13465i.d();
        }
        return d10;
    }

    public final void f0(List list) {
        j.g("downloadInfoList", list);
        synchronized (this.f13464h) {
            this.f13465i.f0(list);
            v vVar = v.f9814a;
        }
    }

    public final List get() {
        List list;
        synchronized (this.f13464h) {
            list = this.f13465i.get();
        }
        return list;
    }

    public final i i(e eVar) {
        i i10;
        synchronized (this.f13464h) {
            i10 = this.f13465i.i(eVar);
        }
        return i10;
    }

    public final void j() {
        synchronized (this.f13464h) {
            this.f13465i.j();
            v vVar = v.f9814a;
        }
    }

    public final e m0(String str) {
        e m02;
        j.g("file", str);
        synchronized (this.f13464h) {
            m02 = this.f13465i.m0(str);
        }
        return m02;
    }

    public final void p0(ArrayList arrayList) {
        synchronized (this.f13464h) {
            this.f13465i.p0(arrayList);
            v vVar = v.f9814a;
        }
    }

    public final void u(e eVar) {
        synchronized (this.f13464h) {
            this.f13465i.u(eVar);
            v vVar = v.f9814a;
        }
    }

    public final List z0(s sVar) {
        List z02;
        synchronized (this.f13464h) {
            z02 = this.f13465i.z0(sVar);
        }
        return z02;
    }
}
