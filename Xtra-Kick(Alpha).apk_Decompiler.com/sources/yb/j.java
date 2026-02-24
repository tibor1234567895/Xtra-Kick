package yb;

import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLSocket;
import xb.f;
import xb.g;

public final class j implements p {
    public final boolean a(SSLSocket sSLSocket) {
        g.f16829e.getClass();
        return f.a() && (sSLSocket instanceof BCSSLSocket);
    }

    public final r b(SSLSocket sSLSocket) {
        return new l();
    }
}
