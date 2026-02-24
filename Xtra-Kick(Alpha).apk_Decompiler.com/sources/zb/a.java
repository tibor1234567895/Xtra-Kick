package zb;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import ma.q;

public final class a extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17808a = new a();

    private a() {
    }

    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    public final List select(URI uri) {
        if (uri != null) {
            return q.b(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
