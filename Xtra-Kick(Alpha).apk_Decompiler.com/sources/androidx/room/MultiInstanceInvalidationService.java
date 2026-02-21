package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.LinkedHashMap;
import r3.e0;
import r3.f0;
import xa.j;

public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: h  reason: collision with root package name */
    public int f2278h;

    /* renamed from: i  reason: collision with root package name */
    public final LinkedHashMap f2279i = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    public final f0 f2280j = new f0(this);

    /* renamed from: k  reason: collision with root package name */
    public final e0 f2281k = new e0(this);

    public final IBinder onBind(Intent intent) {
        j.f("intent", intent);
        return this.f2281k;
    }
}
