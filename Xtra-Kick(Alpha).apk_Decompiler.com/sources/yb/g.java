package yb;

import fb.w;
import javax.net.ssl.SSLSocket;
import xa.j;

public final class g implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f17306a = "com.google.android.gms.org.conscrypt";

    public final boolean a(SSLSocket sSLSocket) {
        String name = sSLSocket.getClass().getName();
        return w.m(name, this.f17306a + '.', false);
    }

    public final r b(SSLSocket sSLSocket) {
        h hVar = i.f17307f;
        Class<?> cls = sSLSocket.getClass();
        hVar.getClass();
        Class<?> cls2 = cls;
        while (!j.a(cls2.getSimpleName(), "OpenSSLSocketImpl")) {
            cls2 = cls2.getSuperclass();
            if (cls2 == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        return new i(cls2);
    }
}
