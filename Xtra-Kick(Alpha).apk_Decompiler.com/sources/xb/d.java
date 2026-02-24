package xb;

import bc.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import xa.j;

public final class d implements g {

    /* renamed from: a  reason: collision with root package name */
    public final X509TrustManager f16824a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f16825b;

    public d(X509TrustManager x509TrustManager, Method method) {
        this.f16824a = x509TrustManager;
        this.f16825b = method;
    }

    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            Object invoke = this.f16825b.invoke(this.f16824a, new Object[]{x509Certificate});
            j.d("null cannot be cast to non-null type java.security.cert.TrustAnchor", invoke);
            return ((TrustAnchor) invoke).getTrustedCert();
        } catch (IllegalAccessException e10) {
            throw new AssertionError("unable to get issues and signature", e10);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.a(this.f16824a, dVar.f16824a) && j.a(this.f16825b, dVar.f16825b);
    }

    public final int hashCode() {
        return this.f16825b.hashCode() + (this.f16824a.hashCode() * 31);
    }

    public final String toString() {
        return "CustomTrustRootIndex(trustManager=" + this.f16824a + ", findByIssuerAndSignatureMethod=" + this.f16825b + ')';
    }
}
