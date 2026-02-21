package xb;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;
import xa.j;

public final class q extends s {

    /* renamed from: e  reason: collision with root package name */
    public static final p f16848e = new p(0);

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f16849f;

    /* renamed from: d  reason: collision with root package name */
    public final Provider f16850d;

    static {
        boolean z10 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, p.class.getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f16849f = z10;
    }

    private q() {
        this.f16850d = new OpenJSSE();
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
        if (sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) {
            org.openjsse.javax.net.ssl.SSLSocket sSLSocket2 = (org.openjsse.javax.net.ssl.SSLSocket) sSLSocket;
            SSLParameters sSLParameters = sSLSocket2.getSSLParameters();
            if (sSLParameters instanceof SSLParameters) {
                s.f16851a.getClass();
                Object[] array = r.a(list).toArray(new String[0]);
                j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
                sSLParameters.setApplicationProtocols((String[]) array);
                sSLSocket2.setSSLParameters(sSLParameters);
                return;
            }
            return;
        }
        super.d(sSLSocket, str, list);
    }

    public final String f(SSLSocket sSLSocket) {
        if (sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) {
            String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sSLSocket).getApplicationProtocol();
            if (applicationProtocol == null ? true : j.a(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        }
        return null;
    }

    public final SSLContext k() {
        SSLContext instance = SSLContext.getInstance("TLSv1.3", this.f16850d);
        j.e("getInstance(\"TLSv1.3\", provider)", instance);
        return instance;
    }

    public final X509TrustManager m() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f16850d);
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        j.c(trustManagers);
        boolean z10 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z10 = false;
        }
        if (z10) {
            TrustManager trustManager = trustManagers[0];
            j.d("null cannot be cast to non-null type javax.net.ssl.X509TrustManager", trustManager);
            return (X509TrustManager) trustManager;
        }
        String arrays = Arrays.toString(trustManagers);
        j.e("toString(this)", arrays);
        throw new IllegalStateException("Unexpected default trust managers: ".concat(arrays).toString());
    }

    public /* synthetic */ q(int i10) {
        this();
    }
}
