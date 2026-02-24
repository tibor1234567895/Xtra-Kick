package k1;

import android.system.ErrnoException;
import android.system.OsConstants;

public final class t {
    private t() {
    }

    /* access modifiers changed from: private */
    public static boolean b(Throwable th) {
        return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
    }
}
