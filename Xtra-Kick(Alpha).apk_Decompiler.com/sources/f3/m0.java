package f3;

import d2.m;
import d2.x0;
import d2.y;
import g1.a0;
import g1.z;
import j1.a;
import j1.b0;
import java.util.List;

public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public final List f5654a;

    /* renamed from: b  reason: collision with root package name */
    public final x0[] f5655b;

    public m0(List list) {
        this.f5654a = list;
        this.f5655b = new x0[list.size()];
    }

    public final void a(long j10, b0 b0Var) {
        if (b0Var.f8416c - b0Var.f8415b >= 9) {
            int f10 = b0Var.f();
            int f11 = b0Var.f();
            int v10 = b0Var.v();
            if (f10 == 434 && f11 == 1195456820 && v10 == 3) {
                m.b(j10, b0Var, this.f5655b);
            }
        }
    }

    public final void b(y yVar, j0 j0Var) {
        boolean z10;
        int i10 = 0;
        while (true) {
            x0[] x0VarArr = this.f5655b;
            if (i10 < x0VarArr.length) {
                j0Var.a();
                j0Var.b();
                x0 d10 = yVar.d(j0Var.f5630d, 3);
                a0 a0Var = (a0) this.f5654a.get(i10);
                String str = a0Var.f6276s;
                if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a.a("Invalid closed caption mime type provided: " + str, z10);
                z zVar = new z();
                j0Var.b();
                zVar.f6744a = j0Var.f5631e;
                zVar.f6754k = str;
                zVar.f6747d = a0Var.f6268k;
                zVar.f6746c = a0Var.f6267j;
                zVar.C = a0Var.K;
                zVar.f6756m = a0Var.f6278u;
                d10.a(new a0(zVar));
                x0VarArr[i10] = d10;
                i10++;
            } else {
                return;
            }
        }
    }
}
