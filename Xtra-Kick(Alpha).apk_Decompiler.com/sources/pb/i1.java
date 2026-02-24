package pb;

import fb.w;
import hb.h0;
import java.util.LinkedHashMap;
import java.util.Map;
import ma.j0;
import ub.h;
import xa.e;
import xa.j;
import xa.v;
import xa.y;

public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    public t0 f12876a;

    /* renamed from: b  reason: collision with root package name */
    public String f12877b;

    /* renamed from: c  reason: collision with root package name */
    public n0 f12878c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f12879d;

    /* renamed from: e  reason: collision with root package name */
    public Map f12880e;

    public i1() {
        this.f12880e = j0.d();
        this.f12877b = "GET";
        this.f12878c = new n0();
    }

    public final void a(String str, String str2) {
        j.f("name", str);
        j.f("value", str2);
        this.f12878c.a(str, str2);
    }

    public final void b(g gVar) {
        boolean z10;
        j.f("cacheControl", gVar);
        String gVar2 = gVar.toString();
        if (gVar2.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            e("Cache-Control");
        } else {
            c("Cache-Control", gVar2);
        }
    }

    public final void c(String str, String str2) {
        j.f("value", str2);
        n0 n0Var = this.f12878c;
        n0Var.getClass();
        h0.N0(str);
        h0.O0(str2, str);
        n0Var.c(str);
        h0.C(n0Var, str, str2);
    }

    public final void d(String str, o1 o1Var) {
        boolean z10;
        j.f("method", str);
        boolean z11 = false;
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (o1Var == null) {
                h hVar = h.f15471a;
                if (j.a(str, "POST") || j.a(str, "PUT") || j.a(str, "PATCH") || j.a(str, "PROPPATCH") || j.a(str, "REPORT")) {
                    z11 = true;
                }
                if (!(!z11)) {
                    throw new IllegalArgumentException(android.support.v4.media.h.n("method ", str, " must have a request body.").toString());
                }
            } else if (!h.a(str)) {
                throw new IllegalArgumentException(android.support.v4.media.h.n("method ", str, " must not have a request body.").toString());
            }
            this.f12877b = str;
            this.f12879d = o1Var;
            return;
        }
        throw new IllegalArgumentException("method.isEmpty() == true".toString());
    }

    public final void e(String str) {
        this.f12878c.c(str);
    }

    public final void f(Class cls, Object obj) {
        Map map;
        j.f("type", cls);
        e a10 = v.a(cls);
        if (obj != null) {
            if (this.f12880e.isEmpty()) {
                map = new LinkedHashMap();
                this.f12880e = map;
            } else {
                Map map2 = this.f12880e;
                j.d("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>", map2);
                y.b(map2);
                map = map2;
            }
            map.put(a10, obj);
        } else if (!this.f12880e.isEmpty()) {
            Map map3 = this.f12880e;
            j.d("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>", map3);
            y.b(map3);
            map3.remove(a10);
        }
    }

    public final void g(String str) {
        String str2;
        String str3;
        j.f("url", str);
        s0 s0Var = t0.f12987k;
        if (w.m(str, "ws:", true)) {
            str2 = str.substring(3);
            j.e("this as java.lang.String).substring(startIndex)", str2);
            str3 = "http:";
        } else {
            if (w.m(str, "wss:", true)) {
                str2 = str.substring(4);
                j.e("this as java.lang.String).substring(startIndex)", str2);
                str3 = "https:";
            }
            s0Var.getClass();
            j.f("<this>", str);
            r0 r0Var = new r0();
            r0Var.c((t0) null, str);
            this.f12876a = r0Var.a();
        }
        str = str3.concat(str2);
        s0Var.getClass();
        j.f("<this>", str);
        r0 r0Var2 = new r0();
        r0Var2.c((t0) null, str);
        this.f12876a = r0Var2.a();
    }

    public i1(j1 j1Var) {
        this.f12880e = j0.d();
        this.f12876a = j1Var.f12884a;
        this.f12877b = j1Var.f12885b;
        this.f12879d = j1Var.f12887d;
        Map map = j1Var.f12888e;
        this.f12880e = map.isEmpty() ? j0.d() : j0.i(map);
        this.f12878c = j1Var.f12886c.d();
    }
}
