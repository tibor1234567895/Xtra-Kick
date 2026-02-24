package t9;

import android.os.Handler;
import android.os.HandlerThread;
import wa.a;
import xa.k;

public final class q extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public static final q f14900h = new q();

    public q() {
        super(0);
    }

    public final Object b() {
        HandlerThread handlerThread = new HandlerThread("FetchNotificationsIO");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }
}
