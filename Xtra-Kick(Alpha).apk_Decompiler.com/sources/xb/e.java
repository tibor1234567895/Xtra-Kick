package xb;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import bc.g;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import xa.j;
import yb.d;
import yb.i;
import yb.l;
import yb.o;
import yb.q;
import yb.r;
import yb.t;

public final class e extends s {

    /* renamed from: e  reason: collision with root package name */
    public static final c f16826e = new c(0);

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f16827f;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f16828d;

    static {
        boolean z10 = false;
        s.f16851a.getClass();
        if (r.c() && Build.VERSION.SDK_INT < 30) {
            z10 = true;
        }
        f16827f = z10;
    }

    public e() {
        t tVar;
        r[] rVarArr = new r[4];
        t.f17320h.getClass();
        try {
            tVar = new t(Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl")), Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl")), Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl")));
        } catch (Exception e10) {
            s.f16851a.getClass();
            s.f16852b.getClass();
            s.i(5, "unable to load android socket classes", e10);
            tVar = null;
        }
        rVarArr[0] = tVar;
        i.f17307f.getClass();
        rVarArr[1] = new q(i.f17308g);
        o.f17316a.getClass();
        rVarArr[2] = new q(o.f17317b);
        l.f17314a.getClass();
        rVarArr[3] = new q(l.f17315b);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 4; i10++) {
            r rVar = rVarArr[i10];
            if (rVar != null) {
                arrayList.add(rVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((r) next).c()) {
                arrayList2.add(next);
            }
        }
        this.f16828d = arrayList2;
    }

    public final bc.e b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        d.f17299d.getClass();
        d dVar = null;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions != null) {
            dVar = new d(x509TrustManager, x509TrustManagerExtensions);
        }
        if (dVar != null) {
            return dVar;
        }
        return super.b(x509TrustManager);
    }

    public final g c(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new d(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        j.f("protocols", list);
        Iterator it = this.f16828d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((r) obj).a(sSLSocket)) {
                break;
            }
        }
        r rVar = (r) obj;
        if (rVar != null) {
            rVar.d(sSLSocket, str, list);
        }
    }

    public final void e(Socket socket, InetSocketAddress inetSocketAddress, int i10) {
        j.f("address", inetSocketAddress);
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e10);
            }
            throw e10;
        }
    }

    public final String f(SSLSocket sSLSocket) {
        Object obj;
        Iterator it = this.f16828d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((r) obj).a(sSLSocket)) {
                break;
            }
        }
        r rVar = (r) obj;
        if (rVar != null) {
            return rVar.b(sSLSocket);
        }
        return null;
    }

    public final boolean h(String str) {
        j.f("hostname", str);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i10 >= 23) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
        return true;
    }
}
