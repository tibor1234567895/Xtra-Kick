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
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import xa.j;

public final class g extends s {

    /* renamed from: e  reason: collision with root package name */
    public static final f f16829e = new f(0);

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f16830f;

    /* renamed from: d  reason: collision with root package name */
    public final Provider f16831d;

    static {
        boolean z10 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, f.class.getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f16830f = z10;
    }

    private g() {
        this.f16831d = new BouncyCastleJsseProvider();
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
        if (sSLSocket instanceof BCSSLSocket) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            s.f16851a.getClass();
            Object[] array = r.a(list).toArray(new String[0]);
            j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
            return;
        }
        super.d(sSLSocket, str, list);
    }

    public final String f(SSLSocket sSLSocket) {
        if (sSLSocket instanceof BCSSLSocket) {
            String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
            if (applicationProtocol == null ? true : j.a(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        }
        return null;
    }

    public final SSLContext k() {
        SSLContext instance = SSLContext.getInstance("TLS", this.f16831d);
        j.e("getInstance(\"TLS\", provider)", instance);
        return instance;
    }

    public final X509TrustManager m() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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

    public /* synthetic */ g(int i10) {
        this();
    }
}
