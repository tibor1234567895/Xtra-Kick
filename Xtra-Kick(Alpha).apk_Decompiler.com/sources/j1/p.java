package j1;

import android.os.RemoteException;
import android.support.v4.media.n;
import android.util.Pair;
import h3.j4;
import h3.x2;
import h3.y0;
import h9.e0;
import j0.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import m1.j1;
import n1.x;
import p1.q;
import p1.r;
import p3.b;
import p3.e;
import p3.g;
import v1.a0;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8468h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8469i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f8470j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f8471k;

    public /* synthetic */ p(Object obj, int i10, Object obj2, int i11) {
        this.f8468h = i11;
        this.f8470j = obj;
        this.f8469i = i10;
        this.f8471k = obj2;
    }

    public final void run() {
        j4 j4Var;
        int i10 = this.f8468h;
        int i11 = this.f8469i;
        Object obj = this.f8471k;
        Object obj2 = this.f8470j;
        switch (i10) {
            case 0:
                q qVar = (q) obj;
                Iterator it = ((CopyOnWriteArraySet) obj2).iterator();
                while (it.hasNext()) {
                    s sVar = (s) it.next();
                    if (!sVar.f8475d) {
                        if (i11 != -1) {
                            sVar.f8473b.a(i11);
                        }
                        sVar.f8474c = true;
                        qVar.invoke(sVar.f8472a);
                    }
                }
                return;
            case 1:
                Pair pair = (Pair) obj;
                ((x) ((j1) ((n) obj2).f338j).f10302h).E(((Integer) pair.first).intValue(), (a0) pair.second, i11);
                return;
            case 2:
                q qVar2 = (q) obj2;
                r rVar = (r) obj;
                int i12 = qVar2.f12505a;
                rVar.W();
                rVar.E(i12, qVar2.f12506b, i11);
                return;
            case 3:
                y0 y0Var = (y0) obj2;
                e0 e0Var = (e0) obj;
                y0Var.getClass();
                try {
                    j4Var = (j4) e0Var.get();
                    a.d(j4Var, "SessionResult must not be null");
                } catch (CancellationException unused) {
                    j4Var = new j4(1);
                } catch (InterruptedException | ExecutionException unused2) {
                    j4Var = new j4(-1);
                }
                h3.r rVar2 = y0Var.f7475w;
                if (rVar2 != null) {
                    try {
                        rVar2.V(y0Var.f7455c, i11, j4Var.h());
                        return;
                    } catch (RemoteException unused3) {
                        v.g("MCImplBase", "Error in sending");
                        return;
                    }
                } else {
                    return;
                }
            case 4:
                h hVar = (h) obj2;
                List list = (List) obj;
                if (i11 == -1) {
                    ((x2) hVar.f8396i).f7437g.f7246s.g0(list);
                    return;
                } else {
                    ((x2) hVar.f8396i).f7437g.f7246s.F0(list, i11);
                    return;
                }
            case Constants.MAX_COMPATIBILITY_VERSION:
                ((b) obj2).f12528c.t(i11, obj);
                return;
            default:
                e eVar = p3.h.f12544a;
                ((g) obj2).t(i11, obj);
                return;
        }
    }

    public /* synthetic */ p(Object obj, Object obj2, int i10, int i11) {
        this.f8468h = i11;
        this.f8470j = obj;
        this.f8471k = obj2;
        this.f8469i = i10;
    }
}
