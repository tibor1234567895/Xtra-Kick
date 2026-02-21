package pb;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import ma.p;
import xa.j;

public final class b0 implements d0 {
    public final List a(String str) {
        j.f("hostname", str);
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            j.e("getAllByName(hostname)", allByName);
            return p.j(allByName);
        } catch (NullPointerException e10) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
            unknownHostException.initCause(e10);
            throw unknownHostException;
        }
    }
}
