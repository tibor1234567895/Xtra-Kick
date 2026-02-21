package yb;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;
import xb.j;
import xb.r;
import xb.s;

public final class o implements r {

    /* renamed from: a  reason: collision with root package name */
    public static final n f17316a = new n(0);

    /* renamed from: b  reason: collision with root package name */
    public static final m f17317b = new m();

    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    public final String b(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    public final boolean c() {
        j.f16833e.getClass();
        return j.f16834f;
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        xa.j.f("protocols", list);
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            s.f16851a.getClass();
            Object[] array = r.a(list).toArray(new String[0]);
            xa.j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}
