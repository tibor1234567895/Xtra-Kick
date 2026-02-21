package e1;

import android.os.IBinder;
import android.support.v4.media.h;
import android.util.Log;
import c.g;
import com.google.gson.internal.bind.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import l0.c;

public final class y implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4955h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f4956i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f4957j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ l f4958k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f4959l;

    public /* synthetic */ y(l lVar, l lVar2, String str, Object obj, int i10) {
        this.f4955h = i10;
        this.f4958k = lVar;
        this.f4956i = lVar2;
        this.f4957j = str;
        this.f4959l = obj;
    }

    public final void run() {
        StringBuilder sb2;
        int i10 = this.f4955h;
        boolean z10 = false;
        Object obj = this.f4959l;
        String str = this.f4957j;
        l lVar = this.f4958k;
        l lVar2 = this.f4956i;
        switch (i10) {
            case 0:
                j jVar = (j) ((a0) lVar.f4038a).f4890k.getOrDefault(lVar2.a(), (Object) null);
                if (jVar == null) {
                    sb2 = new StringBuilder("removeSubscription for callback that isn't registered id=");
                    sb2.append(str);
                } else {
                    a0 a0Var = (a0) lVar.f4038a;
                    IBinder iBinder = (IBinder) obj;
                    a0Var.getClass();
                    HashMap hashMap = jVar.f4921f;
                    if (iBinder == null) {
                        try {
                            if (hashMap.remove(str) != null) {
                                z10 = true;
                            }
                        } catch (Throwable th) {
                            a0Var.f4891l = null;
                            throw th;
                        }
                    } else {
                        List list = (List) hashMap.get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (iBinder == ((c) it.next()).f9498a) {
                                    it.remove();
                                    z10 = true;
                                }
                            }
                            if (list.size() == 0) {
                                hashMap.remove(str);
                            }
                        }
                    }
                    a0Var.f4891l = null;
                    if (!z10) {
                        sb2 = h.s("removeSubscription called for ", str, " which is not subscribed");
                    } else {
                        return;
                    }
                }
                Log.w("MBServiceCompat", sb2.toString());
                return;
            default:
                j jVar2 = (j) ((a0) lVar.f4038a).f4890k.getOrDefault(lVar2.a(), (Object) null);
                if (jVar2 == null) {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                    return;
                }
                a0 a0Var2 = (a0) lVar.f4038a;
                a0Var2.getClass();
                g gVar = new g(str, (g) obj, 0);
                a0Var2.f4891l = jVar2;
                gVar.f4944c = 2;
                gVar.c();
                a0Var2.f4891l = null;
                if (!gVar.a()) {
                    throw new IllegalStateException(h.m("onLoadItem must call detach() or sendResult() before returning for id=", str));
                }
                return;
        }
    }
}
