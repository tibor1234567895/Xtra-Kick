package fb;

import android.support.v4.media.h;
import cb.e;

public class a {
    public static final void a(int i10) {
        if (!new e(2, 36).b(i10)) {
            StringBuilder r10 = h.r("radix ", i10, " was not in valid range ");
            r10.append(new e(2, 36));
            throw new IllegalArgumentException(r10.toString());
        }
    }

    public static final boolean b(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }
}
