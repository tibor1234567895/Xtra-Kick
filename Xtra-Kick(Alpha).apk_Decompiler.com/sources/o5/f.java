package o5;

import android.util.Log;
import b5.c;
import b5.n;
import b5.q;
import d5.o0;
import java.io.File;
import java.io.IOException;
import w5.a;

public final class f implements q {
    public final boolean c(Object obj, File file, n nVar) {
        try {
            a.d(((e) ((o0) obj).get()).f12201h.f12200a.f12216a.getData().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            }
            return false;
        }
    }

    public final c g(n nVar) {
        return c.SOURCE;
    }
}
