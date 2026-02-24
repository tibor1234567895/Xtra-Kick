package r3;

import android.os.RemoteException;
import android.util.Log;
import xa.j;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13791h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d0 f13792i;

    public /* synthetic */ z(d0 d0Var, int i10) {
        this.f13791h = i10;
        this.f13792i = d0Var;
    }

    public final void run() {
        int i10 = this.f13791h;
        d0 d0Var = this.f13792i;
        switch (i10) {
            case 0:
                j.f("this$0", d0Var);
                try {
                    r rVar = d0Var.f13670g;
                    if (rVar != null) {
                        d0Var.f13668e = rVar.g0(d0Var.f13671h, d0Var.f13664a);
                        y yVar = d0Var.f13665b;
                        v vVar = d0Var.f13669f;
                        if (vVar != null) {
                            yVar.a(vVar);
                            return;
                        } else {
                            j.l("observer");
                            throw null;
                        }
                    } else {
                        return;
                    }
                } catch (RemoteException e10) {
                    Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
                    return;
                }
            default:
                j.f("this$0", d0Var);
                v vVar2 = d0Var.f13669f;
                if (vVar2 != null) {
                    d0Var.f13665b.d(vVar2);
                    return;
                } else {
                    j.l("observer");
                    throw null;
                }
        }
    }
}
