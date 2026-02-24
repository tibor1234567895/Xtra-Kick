package q1;

import a2.e;
import d2.w0;
import g1.a0;
import g1.y0;
import g1.z;
import g1.z0;
import java.util.Map;
import o2.v;
import p1.q;
import v1.a1;

public final class u extends a1 {
    public final Map H;
    public g1.u I;

    public u(e eVar, p1.u uVar, q qVar, Map map) {
        super(eVar, uVar, qVar);
        this.H = map;
    }

    public final void e(long j10, int i10, int i11, int i12, w0 w0Var) {
        super.e(j10, i10, i11, i12, w0Var);
    }

    public final a0 l(a0 a0Var) {
        int i10;
        g1.u uVar;
        g1.u uVar2 = this.I;
        if (uVar2 == null) {
            uVar2 = a0Var.f6279v;
        }
        if (!(uVar2 == null || (uVar = (g1.u) this.H.get(uVar2.f6594j)) == null)) {
            uVar2 = uVar;
        }
        z0 z0Var = a0Var.f6274q;
        z0 z0Var2 = null;
        if (z0Var != null) {
            y0[] y0VarArr = z0Var.f6770h;
            int length = y0VarArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    i11 = -1;
                    break;
                }
                y0 y0Var = y0VarArr[i11];
                if ((y0Var instanceof v) && "com.apple.streaming.transportStreamTimestamp".equals(((v) y0Var).f12099i)) {
                    break;
                }
                i11++;
            }
            if (i11 != -1) {
                if (length != 1) {
                    y0[] y0VarArr2 = new y0[(length - 1)];
                    for (int i12 = 0; i12 < length; i12++) {
                        if (i12 != i11) {
                            if (i12 < i11) {
                                i10 = i12;
                            } else {
                                i10 = i12 - 1;
                            }
                            y0VarArr2[i10] = y0VarArr[i12];
                        }
                    }
                    z0Var2 = new z0(y0VarArr2);
                }
            }
            if (!(uVar2 == a0Var.f6279v && z0Var == a0Var.f6274q)) {
                z i13 = a0Var.i();
                i13.f6757n = uVar2;
                i13.f6752i = z0Var;
                a0Var = i13.a();
            }
            return super.l(a0Var);
        }
        z0Var = z0Var2;
        z i132 = a0Var.i();
        i132.f6757n = uVar2;
        i132.f6752i = z0Var;
        a0Var = i132.a();
        return super.l(a0Var);
    }
}
