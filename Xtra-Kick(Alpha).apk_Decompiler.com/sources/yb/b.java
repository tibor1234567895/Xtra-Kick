package yb;

import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import xa.j;
import xb.r;
import xb.s;

public final class b implements r {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17298a = new a(0);

    public final boolean a(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    public final String b(SSLSocket sSLSocket) {
        try {
            String d10 = sSLSocket.getApplicationProtocol();
            if (d10 == null ? true : j.a(d10, "")) {
                return null;
            }
            return d10;
        } catch (UnsupportedOperationException unused) {
        }
    }

    public final boolean c() {
        f17298a.getClass();
        s.f16851a.getClass();
        if (!r.c() || Build.VERSION.SDK_INT < 29) {
            return false;
        }
        return true;
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        j.f("protocols", list);
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            s.f16851a.getClass();
            Object[] array = r.a(list).toArray(new String[0]);
            j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
            sSLParameters.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }
}
