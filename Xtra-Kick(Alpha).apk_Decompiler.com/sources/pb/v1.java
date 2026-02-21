package pb;

import fb.y;
import hb.h0;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import xa.j;

public final class v1 {

    /* renamed from: a  reason: collision with root package name */
    public final a f13006a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f13007b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f13008c;

    public v1(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        j.f("address", aVar);
        j.f("socketAddress", inetSocketAddress);
        this.f13006a = aVar;
        this.f13007b = proxy;
        this.f13008c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v1) {
            v1 v1Var = (v1) obj;
            return j.a(v1Var.f13006a, this.f13006a) && j.a(v1Var.f13007b, this.f13007b) && j.a(v1Var.f13008c, this.f13008c);
        }
    }

    public final int hashCode() {
        int hashCode = this.f13007b.hashCode();
        return this.f13008c.hashCode() + ((hashCode + ((this.f13006a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        String str;
        String str2;
        String hostAddress;
        StringBuilder sb2 = new StringBuilder();
        a aVar = this.f13006a;
        String str3 = aVar.f12763i.f12992d;
        InetSocketAddress inetSocketAddress = this.f13008c;
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null || (hostAddress = address.getHostAddress()) == null) {
            str = null;
        } else {
            str = h0.R1(hostAddress);
        }
        if (y.o(str3, ':')) {
            sb2.append("[");
            sb2.append(str3);
            sb2.append("]");
        } else {
            sb2.append(str3);
        }
        t0 t0Var = aVar.f12763i;
        if (t0Var.f12993e != inetSocketAddress.getPort() || j.a(str3, str)) {
            sb2.append(Constants.EXT_TAG_END);
            sb2.append(t0Var.f12993e);
        }
        if (!j.a(str3, str)) {
            if (j.a(this.f13007b, Proxy.NO_PROXY)) {
                str2 = " at ";
            } else {
                str2 = " via proxy ";
            }
            sb2.append(str2);
            if (str == null) {
                sb2.append("<unresolved>");
            } else if (y.o(str, ':')) {
                sb2.append("[");
                sb2.append(str);
                sb2.append("]");
            } else {
                sb2.append(str);
            }
            sb2.append(Constants.EXT_TAG_END);
            sb2.append(inetSocketAddress.getPort());
        }
        String sb3 = sb2.toString();
        j.e("StringBuilder().apply(builderAction).toString()", sb3);
        return sb3;
    }
}
