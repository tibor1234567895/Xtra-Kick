package p3;

import android.os.Handler;
import android.os.Looper;

public final class l {
    private l() {
    }

    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
