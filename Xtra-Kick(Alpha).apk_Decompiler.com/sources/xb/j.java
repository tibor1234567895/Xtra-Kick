package xb;

import java.security.KeyStore;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

public final class j extends s {

    /* renamed from: e  reason: collision with root package name */
    public static final h f16833e = new h(0);

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f16834f;

    /* renamed from: d  reason: collision with root package name */
    public final Provider f16835d;

    static {
        boolean z10 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, h.class.getClassLoader());
            if (Conscrypt.isAvailable() && h.a()) {
                z10 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f16834f = z10;
    }

    private j() {
        Provider newProvider = Conscrypt.newProvider();
        xa.j.e("newProvider()", newProvider);
        this.f16835d = newProvider;
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        xa.j.f("protocols", list);
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            s.f16851a.getClass();
            Object[] array = r.a(list).toArray(new String[0]);
            xa.j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
            return;
        }
        super.d(sSLSocket, str, list);
    }

    public final String f(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    public final SSLContext k() {
        SSLContext instance = SSLContext.getInstance("TLS", this.f16835d);
        xa.j.e("getInstance(\"TLS\", provider)", instance);
        return instance;
    }

    public final SSLSocketFactory l(X509TrustManager x509TrustManager) {
        SSLContext k10 = k();
        k10.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
        SSLSocketFactory socketFactory = k10.getSocketFactory();
        xa.j.e("newSSLContext().apply {\n…null)\n    }.socketFactory", socketFactory);
        return socketFactory;
    }

    public final X509TrustManager m() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        xa.j.c(trustManagers);
        boolean z10 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z10 = false;
        }
        if (z10) {
            TrustManager trustManager = trustManagers[0];
            xa.j.d("null cannot be cast to non-null type javax.net.ssl.X509TrustManager", trustManager);
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, i.f16832a);
            return x509TrustManager;
        }
        String arrays = Arrays.toString(trustManagers);
        xa.j.e("toString(this)", arrays);
        throw new IllegalStateException("Unexpected default trust managers: ".concat(arrays).toString());
    }

    public /* synthetic */ j(int i10) {
        this();
    }
}
