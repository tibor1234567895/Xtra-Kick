package p1;

import android.media.MediaDrm;
import j1.l0;

public final class w {
    private w() {
    }

    public static boolean a(Throwable th) {
        return th instanceof MediaDrm.MediaDrmStateException;
    }

    public static int b(Throwable th) {
        return l0.q(l0.r(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
    }
}
