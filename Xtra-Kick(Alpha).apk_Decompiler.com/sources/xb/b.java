package xb;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import bc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import m0.o2;
import xa.j;
import yb.d;
import yb.i;
import yb.l;
import yb.o;
import yb.q;
import yb.r;

public final class b extends s {

    /* renamed from: e  reason: collision with root package name */
    public static final a f16821e = new a(0);

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f16822f;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f16823d;

    static {
        boolean z10 = false;
        s.f16851a.getClass();
        if (r.c() && Build.VERSION.SDK_INT >= 29) {
            z10 = true;
        }
        f16822f = z10;
    }

    public b() {
        boolean z10;
        yb.b bVar;
        r[] rVarArr = new r[4];
        yb.b.f17298a.getClass();
        s.f16851a.getClass();
        if (!r.c() || Build.VERSION.SDK_INT < 29) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            bVar = new yb.b();
        } else {
            bVar = null;
        }
        rVarArr[0] = bVar;
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
        this.f16823d = arrayList2;
    }

    public final e b(X509TrustManager x509TrustManager) {
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

    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        j.f("protocols", list);
        Iterator it = this.f16823d.iterator();
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

    public final String f(SSLSocket sSLSocket) {
        Object obj;
        Iterator it = this.f16823d.iterator();
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

    public final Object g() {
        if (Build.VERSION.SDK_INT < 30) {
            return super.g();
        }
        o2.h();
        CloseGuard c10 = o2.c();
        c10.open("response.body().close()");
        return c10;
    }

    public final boolean h(String str) {
        j.f("hostname", str);
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    public final void j(String str, Object obj) {
        j.f("message", str);
        if (Build.VERSION.SDK_INT >= 30) {
            j.d("null cannot be cast to non-null type android.util.CloseGuard", obj);
            o2.d(obj).warnIfOpen();
            return;
        }
        super.j(str, obj);
    }
}
