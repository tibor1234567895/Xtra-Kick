package h3;

import j1.v;

public final class w1 {
    private w1() {
    }

    public static void a(b3 b3Var, r1 r1Var) {
        try {
            b3Var.startForeground(r1Var.f7299a, r1Var.f7300b, 2);
        } catch (RuntimeException e10) {
            v.c("MediaNtfMng", "The service must be declared with a foregroundServiceType that includes  mediaPlayback");
            throw e10;
        }
    }
}
