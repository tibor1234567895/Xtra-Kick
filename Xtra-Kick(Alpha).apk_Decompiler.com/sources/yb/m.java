package yb;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;
import xb.h;
import xb.j;

public final class m implements p {
    public final boolean a(SSLSocket sSLSocket) {
        j.f16833e.getClass();
        return h.b() && Conscrypt.isConscrypt(sSLSocket);
    }

    public final r b(SSLSocket sSLSocket) {
        return new o();
    }
}
