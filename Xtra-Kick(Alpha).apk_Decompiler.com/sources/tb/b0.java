package tb;

import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import ma.q;
import pb.a;
import pb.g0;
import pb.i;
import pb.t0;
import qb.h;
import xa.j;

public final class b0 {

    /* renamed from: j  reason: collision with root package name */
    public static final a0 f14919j = new a0(0);

    /* renamed from: a  reason: collision with root package name */
    public final a f14920a;

    /* renamed from: b  reason: collision with root package name */
    public final x f14921b;

    /* renamed from: c  reason: collision with root package name */
    public final i f14922c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f14923d;

    /* renamed from: e  reason: collision with root package name */
    public final g0 f14924e;

    /* renamed from: f  reason: collision with root package name */
    public List f14925f;

    /* renamed from: g  reason: collision with root package name */
    public int f14926g;

    /* renamed from: h  reason: collision with root package name */
    public List f14927h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f14928i = new ArrayList();

    public b0(a aVar, x xVar, o oVar, boolean z10, g0 g0Var) {
        List list;
        boolean z11;
        j.f("address", aVar);
        j.f("routeDatabase", xVar);
        j.f("call", oVar);
        j.f("eventListener", g0Var);
        this.f14920a = aVar;
        this.f14921b = xVar;
        this.f14922c = oVar;
        this.f14923d = z10;
        this.f14924e = g0Var;
        ma.b0 b0Var = ma.b0.f10801h;
        this.f14925f = b0Var;
        this.f14927h = b0Var;
        t0 t0Var = aVar.f12763i;
        j.f("url", t0Var);
        Proxy proxy = aVar.f12761g;
        if (proxy != null) {
            list = q.b(proxy);
        } else {
            URI i10 = t0Var.i();
            if (i10.getHost() == null) {
                list = h.g(Proxy.NO_PROXY);
            } else {
                List<Proxy> select = aVar.f12762h.select(i10);
                if (select == null || select.isEmpty()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    list = h.g(Proxy.NO_PROXY);
                } else {
                    j.e("proxiesOrNull", select);
                    list = h.l(select);
                }
            }
        }
        this.f14925f = list;
        this.f14926g = 0;
    }

    public final boolean a() {
        boolean z10;
        if (this.f14926g < this.f14925f.size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || (!this.f14928i.isEmpty())) {
            return true;
        }
        return false;
    }
}
