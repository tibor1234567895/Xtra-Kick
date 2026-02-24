package l2;

import g1.z0;
import j1.b0;
import j2.a;
import j2.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class c extends b {
    public static b c(b0 b0Var) {
        String p10 = b0Var.p();
        p10.getClass();
        String p11 = b0Var.p();
        p11.getClass();
        return new b(p10, p11, b0Var.o(), b0Var.o(), Arrays.copyOfRange(b0Var.f8414a, b0Var.f8415b, b0Var.f8416c));
    }

    public final z0 b(a aVar, ByteBuffer byteBuffer) {
        return new z0(c(new b0(byteBuffer.limit(), byteBuffer.array())));
    }
}
