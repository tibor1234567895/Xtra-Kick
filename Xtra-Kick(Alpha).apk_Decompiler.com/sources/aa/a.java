package aa;

import android.net.Uri;
import hb.h0;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import ma.j0;
import ma.o0;
import pb.d1;
import pb.f1;
import pb.i1;
import pb.j1;
import pb.o1;
import pb.r1;
import pb.u1;
import pb.v0;
import xa.j;
import y9.e;
import y9.f;
import y9.g;
import y9.h;
import y9.q;

public final class a implements h {

    /* renamed from: h  reason: collision with root package name */
    public final Map f291h;

    /* renamed from: i  reason: collision with root package name */
    public volatile f1 f292i;

    /* renamed from: j  reason: collision with root package name */
    public final e f293j;

    public a() {
        this((f1) null, 3);
    }

    public static j1 c(f1 f1Var, g gVar) {
        j.g("client", f1Var);
        i1 i1Var = new i1();
        i1Var.g(gVar.f17257a);
        i1Var.d(gVar.f17261e, (o1) null);
        for (Map.Entry entry : gVar.f17258b.entrySet()) {
            i1Var.a((String) entry.getKey(), (String) entry.getValue());
        }
        return new j1(i1Var);
    }

    public final f B(g gVar, q qVar) {
        r1 r1Var;
        TreeMap treeMap;
        int i10;
        InputStream inputStream;
        String str;
        g gVar2 = gVar;
        j.g("interruptMonitor", qVar);
        j1 c10 = c(this.f292i, gVar2);
        if (c10.b("Referer") == null) {
            String D0 = h0.D0(gVar2.f17257a);
            i1 i1Var = new i1(c10);
            i1Var.a("Referer", D0);
            c10 = new j1(i1Var);
        }
        r1 e10 = this.f292i.a(c10).e();
        TreeMap e11 = e10.f12966m.e();
        int i11 = e10.f12964k;
        if ((i11 == 302 || i11 == 301 || i11 == 303) && h0.p0(e11, "Location") != null) {
            f1 f1Var = this.f292i;
            h0.p0(e11, "Location");
            String str2 = gVar2.f17257a;
            Map map = gVar2.f17258b;
            String str3 = gVar2.f17259c;
            Uri uri = gVar2.f17260d;
            String str4 = gVar2.f17261e;
            y9.j jVar = gVar2.f17262f;
            j.g("url", str2);
            j.g("headers", map);
            j.g("file", str3);
            j.g("fileUri", uri);
            j.g("requestMethod", str4);
            j.g("extras", jVar);
            j.g("client", f1Var);
            i1 i1Var2 = new i1();
            i1Var2.g(str2);
            i1Var2.d(str4, (o1) null);
            for (Map.Entry entry : map.entrySet()) {
                i1Var2.a((String) entry.getKey(), (String) entry.getValue());
            }
            j1 j1Var = new j1(i1Var2);
            if (j1Var.b("Referer") == null) {
                String D02 = h0.D0(gVar2.f17257a);
                i1 i1Var3 = new i1(j1Var);
                i1Var3.a("Referer", D02);
                j1Var = new j1(i1Var3);
            }
            try {
                e10.close();
            } catch (Exception unused) {
            }
            r1 e12 = this.f292i.a(j1Var).e();
            r1Var = e12;
            treeMap = e12.f12966m.e();
            i10 = e12.f12964k;
        } else {
            r1Var = e10;
            treeMap = e11;
            i10 = i11;
        }
        boolean z10 = r1Var.f12976w;
        long d02 = h0.d0(treeMap);
        u1 u1Var = r1Var.f12967n;
        if (u1Var != null) {
            inputStream = u1Var.byteStream();
        } else {
            inputStream = null;
        }
        if (!z10) {
            str = h0.G(inputStream);
        } else {
            str = null;
        }
        String p02 = h0.p0(j0.i(treeMap), "Content-MD5");
        if (p02 == null) {
            p02 = "";
        }
        f fVar = new f(i10, z10, d02, inputStream, gVar, p02, treeMap, h0.b(i10, treeMap), str);
        this.f291h.put(fVar, r1Var);
        return fVar;
    }

    public final void C(g gVar) {
    }

    public final boolean D(g gVar, String str) {
        String m02;
        j.g("request", gVar);
        j.g("hash", str);
        if (!(str.length() == 0) && (m02 = h0.m0(gVar.f17259c)) != null) {
            return m02.contentEquals(str);
        }
        return true;
    }

    public final Set J0(g gVar) {
        e eVar = e.SEQUENTIAL;
        e eVar2 = this.f293j;
        if (eVar2 == eVar) {
            return o0.b(eVar2);
        }
        try {
            return h0.G0(gVar, this);
        } catch (Exception unused) {
            return o0.b(eVar2);
        }
    }

    public final void close() {
        Map map = this.f291h;
        for (Map.Entry value : map.entrySet()) {
            r1 r1Var = (r1) value.getValue();
            if (r1Var != null) {
                try {
                    r1Var.close();
                } catch (Exception unused) {
                }
            }
        }
        map.clear();
    }

    public final e k0(g gVar, Set set) {
        j.g("supportedFileDownloaderTypes", set);
        return this.f293j;
    }

    public final void q0(f fVar) {
        Map map = this.f291h;
        if (map.containsKey(fVar)) {
            r1 r1Var = (r1) map.get(fVar);
            map.remove(fVar);
            if (r1Var != null) {
                try {
                    r1Var.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void s0(g gVar) {
    }

    public final void y0(g gVar) {
    }

    public a(f1 f1Var, int i10) {
        e eVar = null;
        f1Var = (i10 & 1) != 0 ? null : f1Var;
        eVar = (i10 & 2) != 0 ? e.SEQUENTIAL : eVar;
        j.g("fileDownloaderType", eVar);
        this.f293j = eVar;
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        j.b("Collections.synchronized…er.Response, Response>())", synchronizedMap);
        this.f291h = synchronizedMap;
        if (f1Var == null) {
            d1 d1Var = new d1();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            j.f("unit", timeUnit);
            d1Var.f12813z = qb.h.b(20000, timeUnit);
            d1Var.f12812y = qb.h.b(15000, timeUnit);
            d1Var.f12796i = true;
            d1Var.f12797j = true;
            d1Var.f12793f = false;
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            d1Var.f12798k = new v0(cookieManager);
            f1Var = new f1(d1Var);
        }
        this.f292i = f1Var;
    }
}
