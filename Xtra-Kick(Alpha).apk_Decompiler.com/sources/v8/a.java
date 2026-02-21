package v8;

import android.os.Handler;
import android.os.Message;
import android.support.v4.media.h;

public final class a implements Handler.Callback {
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            h.y(message.obj);
            throw null;
        } else if (i10 != 1) {
            return false;
        } else {
            h.y(message.obj);
            throw null;
        }
    }
}
