package h3;

import android.os.RemoteException;
import android.support.v4.media.h;
import android.support.v4.media.session.z;
import e1.c0;
import j1.v;

public final /* synthetic */ class t1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7326h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7327i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7328j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f7329k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f7330l;

    public /* synthetic */ t1(Object obj, int i10, Object obj2, Object obj3, int i11) {
        this.f7326h = i11;
        this.f7328j = obj;
        this.f7327i = i10;
        this.f7329k = obj2;
        this.f7330l = obj3;
    }

    public final void run() {
        int i10 = this.f7326h;
        int i11 = this.f7327i;
        Object obj = this.f7330l;
        Object obj2 = this.f7329k;
        Object obj3 = this.f7328j;
        switch (i10) {
            case 0:
                y1 y1Var = (y1) obj3;
                g2 g2Var = (g2) obj2;
                r1 r1Var = (r1) obj;
                if (i11 == y1Var.f7487i) {
                    y1Var.d(g2Var, r1Var, y1Var.c(g2Var, false));
                    return;
                }
                return;
            default:
                x2 x2Var = (x2) obj3;
                c0 c0Var = (c0) obj2;
                w2 w2Var = (w2) obj;
                n2 n2Var = x2Var.f7437g;
                if (!n2Var.f()) {
                    if (!((z) x2Var.f7442l.f428i).c()) {
                        StringBuilder r10 = h.r("Ignore incoming player command before initialization. command=", i11, ", pid=");
                        r10.append(c0Var.f4895a.f4910b);
                        v.g("MediaSessionLegacyStub", r10.toString());
                        return;
                    }
                    e2 J = x2Var.J(c0Var);
                    if (x2Var.f7436f.h(i11, J)) {
                        n2Var.f7231d.e();
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
                } else {
                    return;
                }
        }
    }
}
