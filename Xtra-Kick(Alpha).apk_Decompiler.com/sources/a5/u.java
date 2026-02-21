package a5;

import android.os.Handler;
import android.os.Message;
import o5.h;
import o5.j;
import v8.e;

public final class u implements Handler.Callback {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f194h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f195i;

    public /* synthetic */ u(int i10, Object obj) {
        this.f194h = i10;
        this.f195i = obj;
    }

    public final boolean handleMessage(Message message) {
        switch (this.f194h) {
            case 0:
                int i10 = message.what;
                Object obj = this.f195i;
                if (i10 == 1) {
                    ((w) obj).b((s) message.obj);
                    return true;
                }
                if (i10 == 2) {
                    ((w) obj).f202d.o((s) message.obj);
                }
                return false;
            case 1:
                int i11 = message.what;
                Object obj2 = this.f195i;
                if (i11 == 1) {
                    ((j) obj2).b((h) message.obj);
                    return true;
                }
                if (i11 == 2) {
                    ((j) obj2).f12219d.o((h) message.obj);
                }
                return false;
            default:
                if (message.what != 0) {
                    return false;
                }
                android.support.v4.media.h.y(message.obj);
                synchronized (((e) this.f195i).f15969a) {
                    throw null;
                }
        }
    }
}
