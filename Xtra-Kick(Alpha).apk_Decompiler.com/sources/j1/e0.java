package j1;

import android.os.Message;
import java.util.ArrayList;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public Message f8423a;

    private e0() {
    }

    public final void a() {
        Message message = this.f8423a;
        message.getClass();
        message.sendToTarget();
        this.f8423a = null;
        ArrayList arrayList = f0.f8428b;
        synchronized (arrayList) {
            if (arrayList.size() < 50) {
                arrayList.add(this);
            }
        }
    }

    public /* synthetic */ e0(int i10) {
        this();
    }
}
