package h3;

import android.graphics.Bitmap;
import android.os.RemoteException;
import android.support.v4.media.session.z;
import e1.c0;
import g1.s0;
import h9.e0;
import h9.w;
import j1.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7496h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7497i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7498j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f7499k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f7500l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f7501m;

    public /* synthetic */ z0(l1 l1Var, AtomicInteger atomicInteger, List list, ArrayList arrayList, int i10) {
        this.f7498j = l1Var;
        this.f7499k = atomicInteger;
        this.f7500l = list;
        this.f7501m = arrayList;
        this.f7497i = i10;
    }

    public final void run() {
        Object obj;
        Bitmap bitmap;
        int i10 = this.f7496h;
        int i11 = this.f7497i;
        Object obj2 = this.f7501m;
        Object obj3 = this.f7500l;
        Object obj4 = this.f7499k;
        Object obj5 = this.f7498j;
        switch (i10) {
            case 0:
                l1 l1Var = (l1) obj5;
                List list = (List) obj3;
                List list2 = (List) obj2;
                l1Var.getClass();
                if (((AtomicInteger) obj4).incrementAndGet() == list.size()) {
                    for (int i12 = 0; i12 < list2.size(); i12++) {
                        e0 e0Var = (e0) list2.get(i12);
                        if (e0Var != null) {
                            try {
                                bitmap = (Bitmap) w.b(e0Var);
                            } catch (CancellationException | ExecutionException unused) {
                                v.b();
                            }
                            l1Var.f7177g.k(t3.i((s0) list.get(i12), bitmap), i11 + i12);
                        }
                        bitmap = null;
                        l1Var.f7177g.k(t3.i((s0) list.get(i12), bitmap), i11 + i12);
                    }
                    return;
                }
                return;
            default:
                x2 x2Var = (x2) obj5;
                f4 f4Var = (f4) obj4;
                c0 c0Var = (c0) obj3;
                w2 w2Var = (w2) obj2;
                if (!x2Var.f7437g.f()) {
                    if (!((z) x2Var.f7442l.f428i).c()) {
                        StringBuilder sb2 = new StringBuilder("Ignore incoming session command before initialization. command=");
                        if (f4Var == null) {
                            obj = Integer.valueOf(i11);
                        } else {
                            obj = f4Var.f7035i;
                        }
                        sb2.append(obj);
                        sb2.append(", pid=");
                        sb2.append(c0Var.f4895a.f4910b);
                        v.g("MediaSessionLegacyStub", sb2.toString());
                        return;
                    }
                    e2 J = x2Var.J(c0Var);
                    g gVar = x2Var.f7436f;
                    if (f4Var != null) {
                        if (!gVar.j(J, f4Var)) {
                            return;
                        }
                    } else if (!gVar.i(i11, J)) {
                        return;
                    }
                    try {
                        w2Var.e(J);
                        return;
                    } catch (RemoteException e10) {
                        v.h("MediaSessionLegacyStub", "Exception in " + J, e10);
                        return;
                    }
                } else {
                    return;
                }
        }
    }

    public /* synthetic */ z0(x2 x2Var, f4 f4Var, int i10, c0 c0Var, w2 w2Var) {
        this.f7498j = x2Var;
        this.f7499k = f4Var;
        this.f7497i = i10;
        this.f7500l = c0Var;
        this.f7501m = w2Var;
    }
}
