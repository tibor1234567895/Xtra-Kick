package pb;

import fb.w;
import java.io.IOException;
import xa.j;

public final class g1 {
    private g1() {
    }

    public /* synthetic */ g1(int i10) {
        this();
    }

    public static h1 a(String str) {
        h1 h1Var = h1.HTTP_1_0;
        if (!j.a(str, "http/1.0")) {
            h1Var = h1.HTTP_1_1;
            if (!j.a(str, "http/1.1")) {
                h1Var = h1.H2_PRIOR_KNOWLEDGE;
                if (!j.a(str, "h2_prior_knowledge")) {
                    h1Var = h1.HTTP_2;
                    if (!j.a(str, "h2")) {
                        h1Var = h1.SPDY_3;
                        if (!j.a(str, "spdy/3.1")) {
                            h1Var = h1.QUIC;
                            if (!j.a(str, "quic")) {
                                h1Var = h1.HTTP_3;
                                if (!w.m(str, "h3", false)) {
                                    throw new IOException("Unexpected protocol: ".concat(str));
                                }
                            }
                        }
                    }
                }
            }
        }
        return h1Var;
    }
}
