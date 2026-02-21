package pb;

import java.util.Map;
import la.i;
import ma.j0;
import ma.r;
import qb.f;
import xa.j;

public final class j1 {

    /* renamed from: a  reason: collision with root package name */
    public final t0 f12884a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12885b;

    /* renamed from: c  reason: collision with root package name */
    public final p0 f12886c;

    /* renamed from: d  reason: collision with root package name */
    public final o1 f12887d;

    /* renamed from: e  reason: collision with root package name */
    public final Map f12888e;

    /* renamed from: f  reason: collision with root package name */
    public g f12889f;

    public j1(i1 i1Var) {
        t0 t0Var = i1Var.f12876a;
        if (t0Var != null) {
            this.f12884a = t0Var;
            this.f12885b = i1Var.f12877b;
            this.f12886c = i1Var.f12878c.b();
            this.f12887d = i1Var.f12879d;
            this.f12888e = j0.g(i1Var.f12880e);
            return;
        }
        throw new IllegalStateException("url == null".toString());
    }

    public final g a() {
        g gVar = this.f12889f;
        if (gVar != null) {
            return gVar;
        }
        g.f12846n.getClass();
        g a10 = f.a(this.f12886c);
        this.f12889f = a10;
        return a10;
    }

    public final String b(String str) {
        return this.f12886c.a(str);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Request{method=");
        sb2.append(this.f12885b);
        sb2.append(", url=");
        sb2.append(this.f12884a);
        p0 p0Var = this.f12886c;
        if (p0Var.f12931h.length / 2 != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (Object next : p0Var) {
                int i11 = i10 + 1;
                if (i10 >= 0) {
                    i iVar = (i) next;
                    String str = (String) iVar.f9799h;
                    String str2 = (String) iVar.f9800i;
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(str);
                    sb2.append(':');
                    if (f.k(str)) {
                        str2 = "██";
                    }
                    sb2.append(str2);
                    i10 = i11;
                } else {
                    r.h();
                    throw null;
                }
            }
            sb2.append(']');
        }
        Map map = this.f12888e;
        if (!map.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(map);
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        j.e("StringBuilder().apply(builderAction).toString()", sb3);
        return sb3;
    }
}
