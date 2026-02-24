package yb;

import java.util.List;
import javax.net.ssl.SSLSocket;
import xa.j;

public final class q implements r {

    /* renamed from: a  reason: collision with root package name */
    public final p f17318a;

    /* renamed from: b  reason: collision with root package name */
    public r f17319b;

    public q(p pVar) {
        j.f("socketAdapterFactory", pVar);
        this.f17318a = pVar;
    }

    public final boolean a(SSLSocket sSLSocket) {
        return this.f17318a.a(sSLSocket);
    }

    public final String b(SSLSocket sSLSocket) {
        r rVar;
        synchronized (this) {
            if (this.f17319b == null && this.f17318a.a(sSLSocket)) {
                this.f17319b = this.f17318a.b(sSLSocket);
            }
            rVar = this.f17319b;
        }
        if (rVar != null) {
            return rVar.b(sSLSocket);
        }
        return null;
    }

    public final boolean c() {
        return true;
    }

    public final void d(SSLSocket sSLSocket, String str, List list) {
        r rVar;
        j.f("protocols", list);
        synchronized (this) {
            if (this.f17319b == null && this.f17318a.a(sSLSocket)) {
                this.f17319b = this.f17318a.b(sSLSocket);
            }
            rVar = this.f17319b;
        }
        if (rVar != null) {
            rVar.d(sSLSocket, str, list);
        }
    }
}
