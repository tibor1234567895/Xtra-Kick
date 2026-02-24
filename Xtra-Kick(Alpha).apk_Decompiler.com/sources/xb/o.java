package xb;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import xa.j;

public final class o extends s {

    /* renamed from: d  reason: collision with root package name */
    public static final n f16845d = new n(0);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f16846e;

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f16847f;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r0.intValue() >= 9) goto L_0x002c;
     */
    static {
        /*
            xb.n r0 = new xb.n
            r1 = 0
            r0.<init>(r1)
            f16845d = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L_0x0015
            java.lang.Integer r0 = fb.v.d(r0)
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            f16847f = r0
            if (r0 == 0) goto L_0x0023
            int r0 = r0.intValue()
            r2 = 9
            if (r0 < r2) goto L_0x002d
            goto L_0x002c
        L_0x0023:
            java.lang.Class<javax.net.ssl.SSLSocket> r0 = javax.net.ssl.SSLSocket.class
            java.lang.String r2 = "getApplicationProtocol"
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x002d }
            r0.getMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x002d }
        L_0x002c:
            r1 = 1
        L_0x002d:
            f16846e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xb.o.<clinit>():void");
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        s.f16851a.getClass();
        Object[] array = r.a(list).toArray(new String[0]);
        j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
        sSLParameters.setApplicationProtocols((String[]) array);
        sSLSocket.setSSLParameters(sSLParameters);
    }

    public final String f(SSLSocket sSLSocket) {
        try {
            String d10 = sSLSocket.getApplicationProtocol();
            if (d10 == null ? true : j.a(d10, "")) {
                return null;
            }
            return d10;
        } catch (UnsupportedOperationException unused) {
        }
    }

    public final SSLContext k() {
        SSLContext sSLContext;
        String str;
        Integer num = f16847f;
        if (num == null || num.intValue() < 9) {
            try {
                sSLContext = SSLContext.getInstance("TLSv1.3");
            } catch (NoSuchAlgorithmException unused) {
                sSLContext = SSLContext.getInstance("TLS");
            }
            str = "try {\n          // Based…Instance(\"TLS\")\n        }";
        } else {
            sSLContext = SSLContext.getInstance("TLS");
            str = "getInstance(\"TLS\")";
        }
        j.e(str, sSLContext);
        return sSLContext;
    }
}
