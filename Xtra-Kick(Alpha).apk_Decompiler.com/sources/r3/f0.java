package r3;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.room.MultiInstanceInvalidationService;
import xa.j;

public final class f0 extends RemoteCallbackList {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f13678a;

    public f0(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f13678a = multiInstanceInvalidationService;
    }

    public final void onCallbackDied(IInterface iInterface, Object obj) {
        j.f("callback", (o) iInterface);
        j.f("cookie", obj);
        this.f13678a.f2279i.remove((Integer) obj);
    }
}
