package android.support.v4.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import r3.d0;
import r3.p;
import r3.q;
import r3.r;
import xa.j;

public final class k implements ServiceConnection {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f335h;

    public /* synthetic */ k(Object obj) {
        this.f335h = obj;
    }

    public final boolean a(String str) {
        h.y(this.f335h);
        throw null;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        r rVar;
        j.f("name", componentName);
        j.f("service", iBinder);
        d0 d0Var = (d0) this.f335h;
        int i10 = q.f13733c;
        IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof r)) {
            rVar = new p(iBinder);
        } else {
            rVar = (r) queryLocalInterface;
        }
        d0Var.f13670g = rVar;
        d0Var.f13666c.execute(d0Var.f13674k);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        j.f("name", componentName);
        d0 d0Var = (d0) this.f335h;
        d0Var.f13666c.execute(d0Var.f13675l);
        d0Var.f13670g = null;
    }
}
