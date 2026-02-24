package a5;

import android.util.Log;
import b5.c;
import b5.n;
import b5.q;
import d5.o0;
import java.io.File;
import java.io.IOException;
import w5.a;

public final class o implements q {
    public final boolean c(Object obj, File file, n nVar) {
        try {
            a.d(((n) ((o0) obj).get()).f175h.f174a.f199a.f154a.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("WebpEncoder", 5)) {
                Log.w("WebpEncoder", "Failed to encode WebP drawable data", e10);
            }
            return false;
        }
    }

    public final c g(n nVar) {
        return c.SOURCE;
    }
}
