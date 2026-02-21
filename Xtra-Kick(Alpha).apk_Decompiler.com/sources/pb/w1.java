package pb;

import xa.j;

public final class w1 {
    private w1() {
    }

    public /* synthetic */ w1(int i10) {
        this();
    }

    public static x1 a(String str) {
        j.f("javaName", str);
        int hashCode = str.hashCode();
        if (hashCode != 79201641) {
            if (hashCode != 79923350) {
                switch (hashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return x1.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return x1.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return x1.TLS_1_3;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return x1.TLS_1_0;
            }
        } else if (str.equals("SSLv3")) {
            return x1.SSL_3_0;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
    }
}
