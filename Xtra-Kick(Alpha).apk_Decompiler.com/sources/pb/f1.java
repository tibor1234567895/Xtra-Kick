package pb;

import bc.e;
import e7.b;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import qb.h;
import sb.g;
import tb.o;
import tb.x;
import xa.j;

public final class f1 implements h {
    public static final e1 F = new e1(0);
    public static final List G = h.g(h1.HTTP_2, h1.HTTP_1_1);
    public static final List H = h.g(t.f12981e, t.f12982f);
    public final int A;
    public final int B;
    public final long C;
    public final x D;
    public final g E;

    /* renamed from: a  reason: collision with root package name */
    public final a0 f12820a;

    /* renamed from: b  reason: collision with root package name */
    public final q f12821b;

    /* renamed from: c  reason: collision with root package name */
    public final List f12822c;

    /* renamed from: d  reason: collision with root package name */
    public final List f12823d;

    /* renamed from: e  reason: collision with root package name */
    public final b f12824e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f12825f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f12826g;

    /* renamed from: h  reason: collision with root package name */
    public final d f12827h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f12828i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f12829j;

    /* renamed from: k  reason: collision with root package name */
    public final z f12830k;

    /* renamed from: l  reason: collision with root package name */
    public final d0 f12831l;

    /* renamed from: m  reason: collision with root package name */
    public final Proxy f12832m;

    /* renamed from: n  reason: collision with root package name */
    public final ProxySelector f12833n;

    /* renamed from: o  reason: collision with root package name */
    public final d f12834o;

    /* renamed from: p  reason: collision with root package name */
    public final SocketFactory f12835p;

    /* renamed from: q  reason: collision with root package name */
    public final SSLSocketFactory f12836q;

    /* renamed from: r  reason: collision with root package name */
    public final X509TrustManager f12837r;

    /* renamed from: s  reason: collision with root package name */
    public final List f12838s;

    /* renamed from: t  reason: collision with root package name */
    public final List f12839t;

    /* renamed from: u  reason: collision with root package name */
    public final HostnameVerifier f12840u;

    /* renamed from: v  reason: collision with root package name */
    public final m f12841v;

    /* renamed from: w  reason: collision with root package name */
    public final e f12842w;

    /* renamed from: x  reason: collision with root package name */
    public final int f12843x;

    /* renamed from: y  reason: collision with root package name */
    public final int f12844y;

    /* renamed from: z  reason: collision with root package name */
    public final int f12845z;

    public f1() {
        this(new d1());
    }

    public final o a(j1 j1Var) {
        j.f("request", j1Var);
        return new o(this, j1Var, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004a, code lost:
        if (r0 == null) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f1(pb.d1 r6) {
        /*
            r5 = this;
            r5.<init>()
            pb.a0 r0 = r6.f12788a
            r5.f12820a = r0
            pb.q r0 = r6.f12789b
            r5.f12821b = r0
            java.util.ArrayList r0 = r6.f12790c
            java.util.List r0 = qb.h.l(r0)
            r5.f12822c = r0
            java.util.ArrayList r0 = r6.f12791d
            java.util.List r0 = qb.h.l(r0)
            r5.f12823d = r0
            e7.b r0 = r6.f12792e
            r5.f12824e = r0
            boolean r0 = r6.f12793f
            r5.f12825f = r0
            boolean r0 = r6.f12794g
            r5.f12826g = r0
            pb.d r0 = r6.f12795h
            r5.f12827h = r0
            boolean r0 = r6.f12796i
            r5.f12828i = r0
            boolean r0 = r6.f12797j
            r5.f12829j = r0
            pb.z r0 = r6.f12798k
            r5.f12830k = r0
            pb.d0 r0 = r6.f12799l
            r5.f12831l = r0
            java.net.Proxy r0 = r6.f12800m
            r5.f12832m = r0
            if (r0 == 0) goto L_0x0042
            goto L_0x004c
        L_0x0042:
            java.net.ProxySelector r0 = r6.f12801n
            if (r0 != 0) goto L_0x004a
            java.net.ProxySelector r0 = java.net.ProxySelector.getDefault()
        L_0x004a:
            if (r0 != 0) goto L_0x004e
        L_0x004c:
            zb.a r0 = zb.a.f17808a
        L_0x004e:
            r5.f12833n = r0
            pb.d r0 = r6.f12802o
            r5.f12834o = r0
            javax.net.SocketFactory r0 = r6.f12803p
            r5.f12835p = r0
            java.util.List r0 = r6.f12806s
            r5.f12838s = r0
            java.util.List r1 = r6.f12807t
            r5.f12839t = r1
            javax.net.ssl.HostnameVerifier r1 = r6.f12808u
            r5.f12840u = r1
            int r1 = r6.f12811x
            r5.f12843x = r1
            int r1 = r6.f12812y
            r5.f12844y = r1
            int r1 = r6.f12813z
            r5.f12845z = r1
            int r1 = r6.A
            r5.A = r1
            int r1 = r6.B
            r5.B = r1
            long r1 = r6.C
            r5.C = r1
            tb.x r1 = r6.D
            if (r1 != 0) goto L_0x0085
            tb.x r1 = new tb.x
            r1.<init>()
        L_0x0085:
            r5.D = r1
            sb.g r1 = r6.E
            if (r1 != 0) goto L_0x008d
            sb.g r1 = sb.g.f14472j
        L_0x008d:
            r5.E = r1
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x009c
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x009c
            goto L_0x00b2
        L_0x009c:
            java.util.Iterator r0 = r0.iterator()
        L_0x00a0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b2
            java.lang.Object r1 = r0.next()
            pb.t r1 = (pb.t) r1
            boolean r1 = r1.f12983a
            if (r1 == 0) goto L_0x00a0
            r0 = 0
            goto L_0x00b3
        L_0x00b2:
            r0 = 1
        L_0x00b3:
            r1 = 0
            if (r0 == 0) goto L_0x00bf
            r5.f12836q = r1
            r5.f12842w = r1
            r5.f12837r = r1
            pb.m r6 = pb.m.f12900d
            goto L_0x0104
        L_0x00bf:
            javax.net.ssl.SSLSocketFactory r0 = r6.f12804q
            if (r0 == 0) goto L_0x00d6
            r5.f12836q = r0
            bc.e r0 = r6.f12810w
            xa.j.c(r0)
            r5.f12842w = r0
            javax.net.ssl.X509TrustManager r4 = r6.f12805r
            xa.j.c(r4)
            r5.f12837r = r4
            pb.m r6 = r6.f12809v
            goto L_0x0100
        L_0x00d6:
            xb.r r0 = xb.s.f16851a
            r0.getClass()
            xb.s r0 = xb.s.f16852b
            javax.net.ssl.X509TrustManager r0 = r0.m()
            r5.f12837r = r0
            xb.s r4 = xb.s.f16852b
            xa.j.c(r0)
            javax.net.ssl.SSLSocketFactory r4 = r4.l(r0)
            r5.f12836q = r4
            bc.d r4 = bc.e.f2705a
            r4.getClass()
            xb.s r4 = xb.s.f16852b
            bc.e r0 = r4.b(r0)
            r5.f12842w = r0
            pb.m r6 = r6.f12809v
            xa.j.c(r0)
        L_0x0100:
            pb.m r6 = r6.b(r0)
        L_0x0104:
            r5.f12841v = r6
            java.util.List r6 = r5.f12822c
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>"
            xa.j.d(r0, r6)
            boolean r4 = r6.contains(r1)
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x01d7
            java.util.List r6 = r5.f12823d
            xa.j.d(r0, r6)
            boolean r0 = r6.contains(r1)
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x01bf
            java.util.List r6 = r5.f12838s
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x012d
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x012d
            goto L_0x0143
        L_0x012d:
            java.util.Iterator r6 = r6.iterator()
        L_0x0131:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0143
            java.lang.Object r0 = r6.next()
            pb.t r0 = (pb.t) r0
            boolean r0 = r0.f12983a
            if (r0 == 0) goto L_0x0131
            r6 = 0
            goto L_0x0144
        L_0x0143:
            r6 = 1
        L_0x0144:
            javax.net.ssl.X509TrustManager r0 = r5.f12837r
            bc.e r1 = r5.f12842w
            javax.net.ssl.SSLSocketFactory r4 = r5.f12836q
            if (r6 == 0) goto L_0x0194
            if (r4 != 0) goto L_0x0150
            r6 = 1
            goto L_0x0151
        L_0x0150:
            r6 = 0
        L_0x0151:
            java.lang.String r4 = "Check failed."
            if (r6 == 0) goto L_0x018a
            if (r1 != 0) goto L_0x0159
            r6 = 1
            goto L_0x015a
        L_0x0159:
            r6 = 0
        L_0x015a:
            if (r6 == 0) goto L_0x0180
            if (r0 != 0) goto L_0x015f
            r2 = 1
        L_0x015f:
            if (r2 == 0) goto L_0x0176
            pb.m r6 = r5.f12841v
            pb.m r0 = pb.m.f12900d
            boolean r6 = xa.j.a(r6, r0)
            if (r6 == 0) goto L_0x016c
            goto L_0x019a
        L_0x016c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = r4.toString()
            r6.<init>(r0)
            throw r6
        L_0x0176:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = r4.toString()
            r6.<init>(r0)
            throw r6
        L_0x0180:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = r4.toString()
            r6.<init>(r0)
            throw r6
        L_0x018a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = r4.toString()
            r6.<init>(r0)
            throw r6
        L_0x0194:
            if (r4 == 0) goto L_0x01b3
            if (r1 == 0) goto L_0x01a7
            if (r0 == 0) goto L_0x019b
        L_0x019a:
            return
        L_0x019b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "x509TrustManager == null"
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x01a7:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "certificateChainCleaner == null"
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x01b3:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "sslSocketFactory == null"
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x01bf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Null network interceptor: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            throw r0
        L_0x01d7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Null interceptor: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.f1.<init>(pb.d1):void");
    }
}
