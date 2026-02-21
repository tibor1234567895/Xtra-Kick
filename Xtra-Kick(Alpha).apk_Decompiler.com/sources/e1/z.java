package e1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.h;
import android.util.Log;
import c.c;
import c.g;
import com.google.gson.internal.bind.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class z implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4960h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f4961i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f4962j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Bundle f4963k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f4964l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ l f4965m;

    public /* synthetic */ z(l lVar, l lVar2, String str, Bundle bundle, g gVar, int i10) {
        this.f4960h = i10;
        this.f4965m = lVar;
        this.f4961i = lVar2;
        this.f4962j = str;
        this.f4963k = bundle;
        this.f4964l = gVar;
    }

    public final void run() {
        int i10 = this.f4960h;
        Object obj = this.f4964l;
        String str = this.f4962j;
        l lVar = this.f4965m;
        l lVar2 = this.f4961i;
        switch (i10) {
            case 0:
                j jVar = (j) ((a0) lVar.f4038a).f4890k.getOrDefault(lVar2.a(), (Object) null);
                if (jVar == null) {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                    return;
                }
                a0 a0Var = (a0) lVar.f4038a;
                a0Var.getClass();
                g gVar = new g(str, (g) obj, 1);
                a0Var.f4891l = jVar;
                gVar.f4944c = 4;
                gVar.c();
                a0Var.f4891l = null;
                if (!gVar.a()) {
                    throw new IllegalStateException(h.m("onSearch must call detach() or sendResult() before returning for query=", str));
                }
                return;
            case 1:
                j jVar2 = (j) ((a0) lVar.f4038a).f4890k.getOrDefault(lVar2.a(), (Object) null);
                if (jVar2 == null) {
                    StringBuilder s10 = h.s("sendCustomAction for callback that isn't registered action=", str, ", extras=");
                    s10.append(this.f4963k);
                    Log.w("MBServiceCompat", s10.toString());
                    return;
                }
                a0 a0Var2 = (a0) lVar.f4038a;
                a0Var2.getClass();
                a0Var2.f4891l = jVar2;
                c cVar = ((g) obj).f2715h;
                if (cVar != null) {
                    try {
                        cVar.x0(-1, (Bundle) null);
                    } catch (RemoteException unused) {
                    }
                }
                a0Var2.f4891l = null;
                return;
            default:
                j jVar3 = (j) ((a0) lVar.f4038a).f4890k.getOrDefault(lVar2.a(), (Object) null);
                if (jVar3 == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    return;
                }
                a0 a0Var3 = (a0) lVar.f4038a;
                String str2 = this.f4962j;
                IBinder iBinder = (IBinder) obj;
                Bundle bundle = this.f4963k;
                a0Var3.getClass();
                HashMap hashMap = jVar3.f4921f;
                List<l0.c> list = (List) hashMap.get(str2);
                if (list == null) {
                    list = new ArrayList<>();
                }
                for (l0.c cVar2 : list) {
                    if (iBinder == cVar2.f9498a && e.a(bundle, (Bundle) cVar2.f9499b)) {
                        return;
                    }
                }
                list.add(new l0.c(iBinder, bundle));
                hashMap.put(str2, list);
                f fVar = new f(a0Var3, str2, jVar3, str2, bundle);
                a0Var3.f4891l = jVar3;
                if (bundle == null) {
                    a0Var3.b(fVar);
                } else {
                    fVar.f4944c = 1;
                    a0Var3.b(fVar);
                }
                a0Var3.f4891l = null;
                if (fVar.a()) {
                    a0Var3.f4891l = null;
                    return;
                }
                throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + jVar3.f4916a + " id=" + str2);
        }
    }

    public z(l lVar, l lVar2, String str, IBinder iBinder, Bundle bundle) {
        this.f4960h = 2;
        this.f4965m = lVar;
        this.f4961i = lVar2;
        this.f4962j = str;
        this.f4964l = iBinder;
        this.f4963k = bundle;
    }
}
