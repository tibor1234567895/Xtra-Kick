package yb;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import xa.j;
import xb.g;
import xb.r;
import xb.s;

public final class l implements r {

    /* renamed from: a  reason: collision with root package name */
    public static final k f17314a = new k(0);

    /* renamed from: b  reason: collision with root package name */
    public static final j f17315b = new j();

    public final boolean a(SSLSocket sSLSocket) {
        return sSLSocket instanceof BCSSLSocket;
    }

    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : j.a(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    public final boolean c() {
        g.f16829e.getClass();
        return g.f16830f;
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            s.f16851a.getClass();
            Object[] array = r.a(list).toArray(new String[0]);
            j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
