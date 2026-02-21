package t1;

import android.support.v4.media.h;
import g1.a0;
import j2.b;
import k2.c;
import o2.o;
import q2.d;

public final class a implements b {
    public final b a(a0 a0Var) {
        String str = a0Var.f6276s;
        if (str != null) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1354451219:
                    if (str.equals("application/vnd.dvb.ait")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1348231605:
                    if (str.equals("application/x-icy")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1248341703:
                    if (str.equals("application/id3")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 1154383568:
                    if (str.equals("application/x-emsg")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 1652648887:
                    if (str.equals("application/x-scte35")) {
                        c10 = 4;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    return new c();
                case 1:
                    return new n2.a();
                case 2:
                    return new o();
                case 3:
                    return new l2.c();
                case 4:
                    return new d();
            }
        }
        throw new IllegalArgumentException(h.m("Attempted to create decoder for unsupported MIME type: ", str));
    }

    public final boolean b(a0 a0Var) {
        String str = a0Var.f6276s;
        return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
    }
}
