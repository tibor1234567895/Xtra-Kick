package j1;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.media.n;
import g1.x;
import g1.y;
import h3.i1;
import h3.l1;
import h3.y0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import v.e;

public final /* synthetic */ class o implements Handler.Callback {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8466h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f8467i;

    public /* synthetic */ o(int i10, Object obj) {
        this.f8466h = i10;
        this.f8467i = obj;
    }

    public final boolean handleMessage(Message message) {
        int i10 = this.f8466h;
        Object obj = this.f8467i;
        switch (i10) {
            case 0:
                e eVar = (e) obj;
                Iterator it = ((CopyOnWriteArraySet) eVar.f15504f).iterator();
                while (it.hasNext()) {
                    s sVar = (s) it.next();
                    r rVar = (r) eVar.f15503e;
                    if (!sVar.f8475d && sVar.f8474c) {
                        y c10 = sVar.f8473b.c();
                        sVar.f8473b = new x();
                        sVar.f8474c = false;
                        rVar.c(sVar.f8472a, c10);
                    }
                    if (((f0) ((n) eVar.f15502d)).f8429a.hasMessages(0)) {
                        return true;
                    }
                }
                return true;
            case 1:
                n nVar = (n) obj;
                nVar.getClass();
                if (message.what == 1) {
                    try {
                        Object obj2 = nVar.f338j;
                        ((y0) obj2).f7475w.W(((y0) obj2).f7455c);
                    } catch (RemoteException unused) {
                        v.g("MCImplBase", "Error in sending flushCommandQueue");
                    }
                }
                return true;
            default:
                i1 i1Var = (i1) obj;
                i1Var.getClass();
                if (message.what == 1) {
                    l1 l1Var = i1Var.f7101e;
                    l1Var.R0(false, l1Var.f7182l);
                }
                return true;
        }
    }
}
