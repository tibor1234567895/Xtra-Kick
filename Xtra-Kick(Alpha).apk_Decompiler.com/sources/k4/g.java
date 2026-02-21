package k4;

import dc.f0;
import dc.n0;
import dc.p;
import dc.p0;
import dc.r;
import dc.y;
import dc.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ma.l;
import xa.j;
import xa.v;

public final class g extends r {

    /* renamed from: b  reason: collision with root package name */
    public final r f9097b;

    public g(z zVar) {
        j.f("delegate", zVar);
        this.f9097b = zVar;
    }

    public static void m(f0 f0Var, String str, String str2) {
        j.f("path", f0Var);
    }

    public final n0 a(f0 f0Var) {
        m(f0Var, "appendingSink", "file");
        return this.f9097b.a(f0Var);
    }

    public final void b(f0 f0Var, f0 f0Var2) {
        j.f("source", f0Var);
        j.f("target", f0Var2);
        m(f0Var, "atomicMove", "source");
        m(f0Var2, "atomicMove", "target");
        this.f9097b.b(f0Var, f0Var2);
    }

    public final void c(f0 f0Var) {
        m(f0Var, "createDirectory", "dir");
        this.f9097b.c(f0Var);
    }

    public final void d(f0 f0Var) {
        j.f("path", f0Var);
        m(f0Var, "delete", "path");
        this.f9097b.d(f0Var);
    }

    public final List g(f0 f0Var) {
        j.f("dir", f0Var);
        m(f0Var, "list", "dir");
        List<f0> g10 = this.f9097b.g(f0Var);
        ArrayList arrayList = new ArrayList();
        for (f0 f0Var2 : g10) {
            j.f("path", f0Var2);
            arrayList.add(f0Var2);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public final p i(f0 f0Var) {
        j.f("path", f0Var);
        m(f0Var, "metadataOrNull", "path");
        p i10 = this.f9097b.i(f0Var);
        if (i10 == null) {
            return null;
        }
        f0 f0Var2 = i10.f4813c;
        if (f0Var2 == null) {
            return i10;
        }
        boolean z10 = i10.f4811a;
        boolean z11 = i10.f4812b;
        Long l10 = i10.f4814d;
        Long l11 = i10.f4815e;
        Long l12 = i10.f4816f;
        Long l13 = i10.f4817g;
        Map map = i10.f4818h;
        j.f("extras", map);
        return new p(z10, z11, f0Var2, l10, l11, l12, l13, map);
    }

    public final y j(f0 f0Var) {
        j.f("file", f0Var);
        m(f0Var, "openReadOnly", "file");
        return this.f9097b.j(f0Var);
    }

    public final n0 k(f0 f0Var) {
        f0 b10 = f0Var.b();
        if (b10 != null) {
            l lVar = new l();
            while (b10 != null && !f(b10)) {
                lVar.c(b10);
                b10 = b10.b();
            }
            Iterator it = lVar.iterator();
            while (it.hasNext()) {
                f0 f0Var2 = (f0) it.next();
                j.f("dir", f0Var2);
                c(f0Var2);
            }
        }
        m(f0Var, "sink", "file");
        return this.f9097b.k(f0Var);
    }

    public final p0 l(f0 f0Var) {
        j.f("file", f0Var);
        m(f0Var, "source", "file");
        return this.f9097b.l(f0Var);
    }

    /* renamed from: n */
    public final String toString() {
        return v.a(g.class).b() + '(' + this.f9097b + ')';
    }
}
