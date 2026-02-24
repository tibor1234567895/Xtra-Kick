package p9;

import hb.h0;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ma.b0;
import ma.o0;
import xa.j;
import y9.e;
import y9.f;
import y9.g;
import y9.h;
import y9.q;

public final class n implements h {

    /* renamed from: h  reason: collision with root package name */
    public final m f12699h;

    /* renamed from: i  reason: collision with root package name */
    public final Map f12700i;

    /* renamed from: j  reason: collision with root package name */
    public final CookieManager f12701j;

    /* renamed from: k  reason: collision with root package name */
    public final e f12702k;

    public n() {
        this(0);
    }

    public static LinkedHashMap c(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                Object obj = (List) entry.getValue();
                if (obj == null) {
                    obj = b0.f10801h;
                }
                linkedHashMap.put(str, obj);
            }
        }
        return linkedHashMap;
    }

    public final f B(g gVar, q qVar) {
        HttpURLConnection httpURLConnection;
        LinkedHashMap linkedHashMap;
        int i10;
        boolean z10;
        String str;
        InputStream inputStream;
        long j10;
        g gVar2 = gVar;
        j.g("interruptMonitor", qVar);
        CookieHandler.setDefault(this.f12701j);
        String str2 = gVar2.f17257a;
        URLConnection openConnection = new URL(str2).openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
            e(httpURLConnection2, gVar2);
            if (httpURLConnection2.getRequestProperty("Referer") == null) {
                httpURLConnection2.addRequestProperty("Referer", h0.D0(str2));
            }
            httpURLConnection2.connect();
            Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
            j.b("client.headerFields", headerFields);
            LinkedHashMap c10 = c(headerFields);
            int responseCode = httpURLConnection2.getResponseCode();
            String str3 = "";
            if ((responseCode == 302 || responseCode == 301 || responseCode == 303) && h0.p0(c10, "Location") != null) {
                try {
                    httpURLConnection2.disconnect();
                } catch (Exception unused) {
                }
                String p02 = h0.p0(c10, "Location");
                if (p02 == null) {
                    p02 = str3;
                }
                URLConnection openConnection2 = new URL(p02).openConnection();
                if (openConnection2 != null) {
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) openConnection2;
                    e(httpURLConnection3, gVar2);
                    if (httpURLConnection3.getRequestProperty("Referer") == null) {
                        httpURLConnection3.addRequestProperty("Referer", h0.D0(str2));
                    }
                    httpURLConnection3.connect();
                    Map<String, List<String>> headerFields2 = httpURLConnection3.getHeaderFields();
                    j.b("client.headerFields", headerFields2);
                    httpURLConnection = httpURLConnection3;
                    linkedHashMap = c(headerFields2);
                    i10 = httpURLConnection3.getResponseCode();
                } else {
                    throw new la.q("null cannot be cast to non-null type java.net.HttpURLConnection");
                }
            } else {
                httpURLConnection = httpURLConnection2;
                linkedHashMap = c10;
                i10 = responseCode;
            }
            boolean z11 = false;
            if (200 <= i10 && 299 >= i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                long d02 = h0.d0(linkedHashMap);
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String p03 = h0.p0(linkedHashMap, "Content-MD5");
                if (p03 != null) {
                    str3 = p03;
                }
                inputStream = inputStream2;
                str = null;
                j10 = d02;
                z11 = true;
            } else {
                str = h0.G(httpURLConnection.getErrorStream());
                inputStream = null;
                j10 = -1;
            }
            boolean b10 = h0.b(i10, linkedHashMap);
            j.b("client.headerFields", httpURLConnection.getHeaderFields());
            f fVar = new f(i10, z11, j10, inputStream, gVar, str3, linkedHashMap, b10, str);
            this.f12700i.put(fVar, httpURLConnection);
            return fVar;
        }
        throw new la.q("null cannot be cast to non-null type java.net.HttpURLConnection");
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
        e eVar2 = this.f12702k;
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
        Map map = this.f12700i;
        for (Map.Entry value : map.entrySet()) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) value.getValue();
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        }
        map.clear();
    }

    public final void e(HttpURLConnection httpURLConnection, g gVar) {
        httpURLConnection.setRequestMethod(gVar.f17261e);
        m mVar = this.f12699h;
        httpURLConnection.setReadTimeout(mVar.f12696a);
        httpURLConnection.setConnectTimeout(mVar.f12697b);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(mVar.f12698c);
        httpURLConnection.setDoInput(true);
        for (Map.Entry entry : gVar.f17258b.entrySet()) {
            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public final e k0(g gVar, Set set) {
        j.g("supportedFileDownloaderTypes", set);
        return this.f12702k;
    }

    public final void q0(f fVar) {
        Map map = this.f12700i;
        if (map.containsKey(fVar)) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) map.get(fVar);
            map.remove(fVar);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void s0(g gVar) {
    }

    public final void y0(g gVar) {
    }

    public n(int i10) {
        this.f12702k = e.SEQUENTIAL;
        this.f12699h = new m();
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        j.b("Collections.synchronized…se, HttpURLConnection>())", synchronizedMap);
        this.f12700i = synchronizedMap;
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        this.f12701j = cookieManager;
    }
}
