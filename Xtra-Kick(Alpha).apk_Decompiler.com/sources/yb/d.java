package yb;

import android.net.http.X509TrustManagerExtensions;
import bc.e;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import xa.j;

public final class d extends e {

    /* renamed from: d  reason: collision with root package name */
    public static final c f17299d = new c(0);

    /* renamed from: b  reason: collision with root package name */
    public final X509TrustManager f17300b;

    /* renamed from: c  reason: collision with root package name */
    public final X509TrustManagerExtensions f17301c;

    public d(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f17300b = x509TrustManager;
        this.f17301c = x509TrustManagerExtensions;
    }

    public final List a(String str, List list) {
        j.f("chain", list);
        j.f("hostname", str);
        Object[] array = list.toArray(new X509Certificate[0]);
        j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
        try {
            List<X509Certificate> checkServerTrusted = this.f17301c.checkServerTrusted((X509Certificate[]) array, "RSA", str);
            j.e("x509TrustManagerExtensio…ficates, \"RSA\", hostname)", checkServerTrusted);
            return checkServerTrusted;
        } catch (CertificateException e10) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
            sSLPeerUnverifiedException.initCause(e10);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).f17300b == this.f17300b;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f17300b);
    }
}
