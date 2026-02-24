package pb;

import bc.e;
import bc.f;
import e7.b;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ma.w;
import qb.h;
import sb.g;
import tb.x;
import xa.j;

public final class d1 {
    public int A;
    public final int B;
    public final long C;
    public x D;
    public final g E;

    /* renamed from: a  reason: collision with root package name */
    public final a0 f12788a;

    /* renamed from: b  reason: collision with root package name */
    public final q f12789b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f12790c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f12791d;

    /* renamed from: e  reason: collision with root package name */
    public b f12792e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12793f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f12794g;

    /* renamed from: h  reason: collision with root package name */
    public final d f12795h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12796i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12797j;

    /* renamed from: k  reason: collision with root package name */
    public z f12798k;

    /* renamed from: l  reason: collision with root package name */
    public final d0 f12799l;

    /* renamed from: m  reason: collision with root package name */
    public final Proxy f12800m;

    /* renamed from: n  reason: collision with root package name */
    public final ProxySelector f12801n;

    /* renamed from: o  reason: collision with root package name */
    public final d f12802o;

    /* renamed from: p  reason: collision with root package name */
    public final SocketFactory f12803p;

    /* renamed from: q  reason: collision with root package name */
    public final SSLSocketFactory f12804q;

    /* renamed from: r  reason: collision with root package name */
    public final X509TrustManager f12805r;

    /* renamed from: s  reason: collision with root package name */
    public final List f12806s;

    /* renamed from: t  reason: collision with root package name */
    public List f12807t;

    /* renamed from: u  reason: collision with root package name */
    public final HostnameVerifier f12808u;

    /* renamed from: v  reason: collision with root package name */
    public final m f12809v;

    /* renamed from: w  reason: collision with root package name */
    public final e f12810w;

    /* renamed from: x  reason: collision with root package name */
    public final int f12811x;

    /* renamed from: y  reason: collision with root package name */
    public int f12812y;

    /* renamed from: z  reason: collision with root package name */
    public int f12813z;

    public d1() {
        this.f12788a = new a0();
        this.f12789b = new q();
        this.f12790c = new ArrayList();
        this.f12791d = new ArrayList();
        e0 e0Var = g0.f12862a;
        p0 p0Var = h.f13493a;
        j.f("<this>", e0Var);
        this.f12792e = new b(5, (Object) e0Var);
        this.f12793f = true;
        this.f12794g = true;
        b bVar = d.f12786a;
        this.f12795h = bVar;
        this.f12796i = true;
        this.f12797j = true;
        this.f12798k = z.f13039a;
        this.f12799l = d0.f12787a;
        this.f12802o = bVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        j.e("getDefault()", socketFactory);
        this.f12803p = socketFactory;
        f1.F.getClass();
        this.f12806s = f1.H;
        this.f12807t = f1.G;
        this.f12808u = f.f2706a;
        this.f12809v = m.f12900d;
        this.f12812y = 10000;
        this.f12813z = 10000;
        this.A = 10000;
        this.C = 1024;
    }

    public d1(f1 f1Var) {
        this();
        this.f12788a = f1Var.f12820a;
        this.f12789b = f1Var.f12821b;
        w.k(f1Var.f12822c, this.f12790c);
        w.k(f1Var.f12823d, this.f12791d);
        this.f12792e = f1Var.f12824e;
        this.f12793f = f1Var.f12825f;
        this.f12794g = f1Var.f12826g;
        this.f12795h = f1Var.f12827h;
        this.f12796i = f1Var.f12828i;
        this.f12797j = f1Var.f12829j;
        this.f12798k = f1Var.f12830k;
        this.f12799l = f1Var.f12831l;
        this.f12800m = f1Var.f12832m;
        this.f12801n = f1Var.f12833n;
        this.f12802o = f1Var.f12834o;
        this.f12803p = f1Var.f12835p;
        this.f12804q = f1Var.f12836q;
        this.f12805r = f1Var.f12837r;
        this.f12806s = f1Var.f12838s;
        this.f12807t = f1Var.f12839t;
        this.f12808u = f1Var.f12840u;
        this.f12809v = f1Var.f12841v;
        this.f12810w = f1Var.f12842w;
        this.f12811x = f1Var.f12843x;
        this.f12812y = f1Var.f12844y;
        this.f12813z = f1Var.f12845z;
        this.A = f1Var.A;
        this.B = f1Var.B;
        this.C = f1Var.C;
        this.D = f1Var.D;
        this.E = f1Var.E;
    }
}
