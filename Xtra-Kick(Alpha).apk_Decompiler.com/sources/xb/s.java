package xb;

import bc.b;
import bc.c;
import bc.e;
import bc.g;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import pb.f1;
import xa.j;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static final r f16851a = new r(0);

    /* renamed from: b  reason: collision with root package name */
    public static volatile s f16852b;

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f16853c = Logger.getLogger(f1.class.getName());

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: xb.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: xb.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: xb.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: xb.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: xb.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: xb.e} */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ac, code lost:
        if (r0 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d2, code lost:
        if (r0 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (r0 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012a, code lost:
        if (java.lang.Integer.parseInt(r3) >= 9) goto L_0x0189;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018d  */
    static {
        /*
            xb.r r0 = new xb.r
            r1 = 0
            r0.<init>(r1)
            f16851a = r0
            boolean r0 = xb.r.c()
            r2 = 0
            if (r0 == 0) goto L_0x008a
            yb.e r0 = yb.e.f17302a
            r0.getClass()
            java.util.Map r0 = yb.e.f17304c
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x001e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            java.util.logging.Logger r4 = java.util.logging.Logger.getLogger(r4)
            java.util.concurrent.CopyOnWriteArraySet r5 = yb.e.f17303b
            boolean r5 = r5.add(r4)
            if (r5 == 0) goto L_0x001e
            r4.setUseParentHandlers(r1)
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r3, r5)
            if (r5 == 0) goto L_0x004f
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            goto L_0x005b
        L_0x004f:
            r5 = 4
            boolean r3 = android.util.Log.isLoggable(r3, r5)
            if (r3 == 0) goto L_0x0059
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            goto L_0x005b
        L_0x0059:
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
        L_0x005b:
            r4.setLevel(r3)
            yb.f r3 = yb.f.f17305a
            r4.addHandler(r3)
            goto L_0x001e
        L_0x0064:
            xb.a r0 = xb.b.f16821e
            r0.getClass()
            boolean r0 = xb.b.f16822f
            if (r0 == 0) goto L_0x0073
            xb.b r0 = new xb.b
            r0.<init>()
            goto L_0x0074
        L_0x0073:
            r0 = r2
        L_0x0074:
            if (r0 != 0) goto L_0x0192
            xb.c r0 = xb.e.f16826e
            r0.getClass()
            boolean r0 = xb.e.f16827f
            if (r0 == 0) goto L_0x0084
            xb.e r2 = new xb.e
            r2.<init>()
        L_0x0084:
            xa.j.c(r2)
        L_0x0087:
            r0 = r2
            goto L_0x0192
        L_0x008a:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r1]
            java.lang.String r0 = r0.getName()
            java.lang.String r3 = "Conscrypt"
            boolean r0 = xa.j.a(r3, r0)
            if (r0 == 0) goto L_0x00b0
            xb.h r0 = xb.j.f16833e
            r0.getClass()
            boolean r0 = xb.j.f16834f
            if (r0 == 0) goto L_0x00ab
            xb.j r0 = new xb.j
            r0.<init>(r1)
            goto L_0x00ac
        L_0x00ab:
            r0 = r2
        L_0x00ac:
            if (r0 == 0) goto L_0x00b0
            goto L_0x0192
        L_0x00b0:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r1]
            java.lang.String r0 = r0.getName()
            java.lang.String r3 = "BC"
            boolean r0 = xa.j.a(r3, r0)
            if (r0 == 0) goto L_0x00d6
            xb.f r0 = xb.g.f16829e
            r0.getClass()
            boolean r0 = xb.g.f16830f
            if (r0 == 0) goto L_0x00d1
            xb.g r0 = new xb.g
            r0.<init>(r1)
            goto L_0x00d2
        L_0x00d1:
            r0 = r2
        L_0x00d2:
            if (r0 == 0) goto L_0x00d6
            goto L_0x0192
        L_0x00d6:
            java.security.Provider[] r0 = java.security.Security.getProviders()
            r0 = r0[r1]
            java.lang.String r0 = r0.getName()
            java.lang.String r3 = "OpenJSSE"
            boolean r0 = xa.j.a(r3, r0)
            if (r0 == 0) goto L_0x00fc
            xb.p r0 = xb.q.f16848e
            r0.getClass()
            boolean r0 = xb.q.f16849f
            if (r0 == 0) goto L_0x00f7
            xb.q r0 = new xb.q
            r0.<init>(r1)
            goto L_0x00f8
        L_0x00f7:
            r0 = r2
        L_0x00f8:
            if (r0 == 0) goto L_0x00fc
            goto L_0x0192
        L_0x00fc:
            xb.n r0 = xb.o.f16845d
            r0.getClass()
            boolean r0 = xb.o.f16846e
            if (r0 == 0) goto L_0x010b
            xb.o r0 = new xb.o
            r0.<init>()
            goto L_0x010c
        L_0x010b:
            r0 = r2
        L_0x010c:
            if (r0 == 0) goto L_0x0110
            goto L_0x0192
        L_0x0110:
            xb.l r0 = xb.m.f16839i
            r0.getClass()
            java.lang.Class<javax.net.ssl.SSLSocket> r0 = javax.net.ssl.SSLSocket.class
            java.lang.String r3 = "java.specification.version"
            java.lang.String r4 = "unknown"
            java.lang.String r3 = java.lang.System.getProperty(r3, r4)
            java.lang.String r4 = "jvmVersion"
            xa.j.e(r4, r3)     // Catch:{ NumberFormatException -> 0x012d }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x012d }
            r4 = 9
            if (r3 < r4) goto L_0x012d
            goto L_0x0189
        L_0x012d:
            java.lang.String r3 = "org.eclipse.jetty.alpn.ALPN"
            r4 = 1
            java.lang.Class r3 = java.lang.Class.forName(r3, r4, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r5 = "org.eclipse.jetty.alpn.ALPN$Provider"
            java.lang.Class r5 = java.lang.Class.forName(r5, r4, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r6 = "org.eclipse.jetty.alpn.ALPN$ClientProvider"
            java.lang.Class r11 = java.lang.Class.forName(r6, r4, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r6 = "org.eclipse.jetty.alpn.ALPN$ServerProvider"
            java.lang.Class r12 = java.lang.Class.forName(r6, r4, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r6 = "put"
            r7 = 2
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            r7[r1] = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            r7[r4] = r5     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.reflect.Method r8 = r3.getMethod(r6, r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r5 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            r6[r1] = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.reflect.Method r9 = r3.getMethod(r5, r6)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r5 = "remove"
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            r4[r1] = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.reflect.Method r10 = r3.getMethod(r5, r4)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            xb.m r0 = new xb.m     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r1 = "putMethod"
            xa.j.e(r1, r8)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r1 = "getMethod"
            xa.j.e(r1, r9)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r1 = "removeMethod"
            xa.j.e(r1, r10)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r1 = "clientProviderClass"
            xa.j.e(r1, r11)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            java.lang.String r1 = "serverProviderClass"
            xa.j.e(r1, r12)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0188 }
            r2 = r0
            goto L_0x0189
        L_0x0188:
        L_0x0189:
            if (r2 == 0) goto L_0x018d
            goto L_0x0087
        L_0x018d:
            xb.s r0 = new xb.s
            r0.<init>()
        L_0x0192:
            f16852b = r0
            java.lang.Class<pb.f1> r0 = pb.f1.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f16853c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xb.s.<clinit>():void");
    }

    public static void i(int i10, String str, Throwable th) {
        j.f("message", str);
        f16853c.log(i10 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public e b(X509TrustManager x509TrustManager) {
        return new b(c(x509TrustManager));
    }

    public g c(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        j.e("trustManager.acceptedIssuers", acceptedIssuers);
        return new c((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i10) {
        j.f("address", inetSocketAddress);
        socket.connect(inetSocketAddress, i10);
    }

    public String f(SSLSocket sSLSocket) {
        return null;
    }

    public Object g() {
        if (f16853c.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean h(String str) {
        j.f("hostname", str);
        return true;
    }

    public void j(String str, Object obj) {
        j.f("message", str);
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(5, str, (Throwable) obj);
    }

    public SSLContext k() {
        SSLContext instance = SSLContext.getInstance("TLS");
        j.e("getInstance(\"TLS\")", instance);
        return instance;
    }

    public SSLSocketFactory l(X509TrustManager x509TrustManager) {
        try {
            SSLContext k10 = k();
            k10.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            SSLSocketFactory socketFactory = k10.getSocketFactory();
            j.e("newSSLContext().apply {\n…ll)\n      }.socketFactory", socketFactory);
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS: " + e10, e10);
        }
    }

    public X509TrustManager m() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public final String toString() {
        return getClass().getSimpleName();
    }
}
