package e1;

import android.os.IBinder;
import com.google.gson.internal.bind.l;

public final class x implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4952h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f4953i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f4954j;

    public /* synthetic */ x(l lVar, l lVar2, int i10) {
        this.f4952h = i10;
        this.f4954j = lVar;
        this.f4953i = lVar2;
    }

    public final void run() {
        int i10 = this.f4952h;
        l lVar = this.f4954j;
        l lVar2 = this.f4953i;
        switch (i10) {
            case 0:
                j jVar = (j) ((a0) lVar.f4038a).f4890k.remove(lVar2.a());
                if (jVar != null) {
                    jVar.f4920e.a().unlinkToDeath(jVar, 0);
                    return;
                }
                return;
            default:
                IBinder a10 = lVar2.a();
                j jVar2 = (j) ((a0) lVar.f4038a).f4890k.remove(a10);
                if (jVar2 != null) {
                    a10.unlinkToDeath(jVar2, 0);
                    return;
                }
                return;
        }
    }
}
