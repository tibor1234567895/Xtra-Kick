package d5;

import android.os.Handler;
import android.os.Message;

public final class r0 implements Handler.Callback {
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        ((o0) message.obj).e();
        return true;
    }
}
