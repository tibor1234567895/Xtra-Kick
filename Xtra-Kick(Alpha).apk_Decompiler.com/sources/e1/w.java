package e1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.internal.bind.l;
import java.util.Iterator;

public final class w implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4945h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f4946i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4947j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f4948k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4949l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Bundle f4950m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ l f4951n;

    public w(l lVar, l lVar2, int i10, String str, int i11, Bundle bundle) {
        this.f4951n = lVar;
        this.f4946i = lVar2;
        this.f4947j = i10;
        this.f4948k = str;
        this.f4949l = i11;
        this.f4950m = bundle;
    }

    public final void run() {
        int i10 = this.f4945h;
        j jVar = null;
        String str = this.f4948k;
        l lVar = this.f4951n;
        l lVar2 = this.f4946i;
        switch (i10) {
            case 0:
                IBinder a10 = lVar2.a();
                ((a0) lVar.f4038a).f4890k.remove(a10);
                Object obj = lVar.f4038a;
                a0 a0Var = (a0) obj;
                j jVar2 = new j(a0Var, this.f4948k, this.f4947j, this.f4949l, this.f4946i);
                a0Var.f4891l = jVar2;
                h a11 = a0Var.a(this.f4950m);
                jVar2.f4922g = a11;
                a0Var.f4891l = null;
                if (a11 == null) {
                    StringBuilder s10 = h.s("No root for client ", str, " from service ");
                    s10.append(w.class.getName());
                    Log.i("MBServiceCompat", s10.toString());
                    try {
                        lVar2.f(2, (Bundle) null);
                        return;
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                        return;
                    }
                } else {
                    try {
                        ((a0) obj).f4890k.put(a10, jVar2);
                        a10.linkToDeath(jVar2, 0);
                        if (((a0) obj).f4893n != null) {
                            h hVar = jVar2.f4922g;
                            lVar2.d((String) hVar.f4907a, ((a0) obj).f4893n, (Bundle) hVar.f4908b);
                            return;
                        }
                        return;
                    } catch (RemoteException unused2) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str);
                        a0Var.f4890k.remove(a10);
                        return;
                    }
                }
            default:
                IBinder a12 = lVar2.a();
                ((a0) lVar.f4038a).f4890k.remove(a12);
                a0 a0Var2 = (a0) lVar.f4038a;
                Iterator it = a0Var2.f4889j.iterator();
                while (true) {
                    if (it.hasNext()) {
                        j jVar3 = (j) it.next();
                        if (jVar3.f4918c == this.f4947j) {
                            if (TextUtils.isEmpty(str) || this.f4949l <= 0) {
                                jVar = new j(a0Var2, jVar3.f4916a, jVar3.f4917b, jVar3.f4918c, this.f4946i);
                            }
                            it.remove();
                        }
                    }
                }
                if (jVar == null) {
                    jVar = new j(a0Var2, this.f4948k, this.f4949l, this.f4947j, this.f4946i);
                }
                a0Var2.f4890k.put(a12, jVar);
                try {
                    a12.linkToDeath(jVar, 0);
                    return;
                } catch (RemoteException unused3) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                    return;
                }
        }
    }

    public w(l lVar, l lVar2, String str, int i10, int i11, Bundle bundle) {
        this.f4951n = lVar;
        this.f4946i = lVar2;
        this.f4948k = str;
        this.f4947j = i10;
        this.f4949l = i11;
        this.f4950m = bundle;
    }
}
