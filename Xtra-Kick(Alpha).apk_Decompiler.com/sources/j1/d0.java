package j1;

import android.os.Handler;
import android.os.Looper;

public final class d0 implements d {
    public final f0 a(Looper looper, Handler.Callback callback) {
        return new f0(new Handler(looper, callback));
    }
}
