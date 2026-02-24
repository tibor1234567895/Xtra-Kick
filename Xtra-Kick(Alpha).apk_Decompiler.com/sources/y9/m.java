package y9;

import java.net.InetSocketAddress;
import la.q;
import xa.j;
import z9.c;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public InetSocketAddress f17267a = new InetSocketAddress(0);

    /* renamed from: b  reason: collision with root package name */
    public c f17268b = new c(0);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(m.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            m mVar = (m) obj;
            return !(j.a(this.f17267a, mVar.f17267a) ^ true) && !(j.a(this.f17268b, mVar.f17268b) ^ true);
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2core.FileServerDownloader.TransporterRequest");
    }

    public final int hashCode() {
        return this.f17268b.hashCode() + (this.f17267a.hashCode() * 31);
    }

    public final String toString() {
        return "TransporterRequest(inetSocketAddress=" + this.f17267a + ", fileRequest=" + this.f17268b + ')';
    }
}
