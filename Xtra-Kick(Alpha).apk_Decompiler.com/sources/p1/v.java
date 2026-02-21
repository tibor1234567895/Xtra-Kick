package p1;

import android.media.DeniedByServerException;
import android.media.NotProvisionedException;

public final class v {
    private v() {
    }

    public static boolean a(Throwable th) {
        return th instanceof DeniedByServerException;
    }

    public static boolean b(Throwable th) {
        return th instanceof NotProvisionedException;
    }
}
