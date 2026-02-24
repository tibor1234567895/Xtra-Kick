package r3;

import android.os.RemoteException;
import android.util.Log;
import java.util.Set;
import n.b;
import xa.j;

public final class a0 extends v {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13656b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f13657c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(d0 d0Var, String[] strArr) {
        super(strArr);
        this.f13657c = d0Var;
    }

    public final boolean a() {
        switch (this.f13656b) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final void b(Set set) {
        int i10 = this.f13656b;
        Object obj = this.f13657c;
        switch (i10) {
            case 0:
                j.f("tables", set);
                if (!((d0) obj).f13672i.get()) {
                    try {
                        r rVar = ((d0) obj).f13670g;
                        if (rVar != null) {
                            rVar.b0(((d0) obj).f13668e, (String[]) set.toArray(new String[0]));
                            return;
                        }
                        return;
                    } catch (RemoteException e10) {
                        Log.w("ROOM", "Cannot broadcast invalidation", e10);
                        return;
                    }
                } else {
                    return;
                }
            default:
                j.f("tables", set);
                b a10 = b.a();
                t0 t0Var = ((u0) obj).f13764u;
                if (a10.b()) {
                    t0Var.run();
                    return;
                } else {
                    a10.c(t0Var);
                    return;
                }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(String[] strArr, u0 u0Var) {
        super(strArr);
        this.f13657c = u0Var;
    }
}
