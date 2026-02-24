package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;

public final class b {
    private b() {
    }

    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
