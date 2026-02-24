package s1;

import android.net.Uri;
import d2.a0;
import d2.v;
import java.util.Map;
import v1.m;
import w2.g;
import y1.d;
import y1.e;

public final /* synthetic */ class w implements b0, a0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ g1.a0 f14083h;

    public /* synthetic */ w(g1.a0 a0Var) {
        this.f14083h = a0Var;
    }

    public final v[] a() {
        v vVar;
        v[] vVarArr = new v[1];
        d dVar = e.f16867a;
        g1.a0 a0Var = this.f14083h;
        if (dVar.b(a0Var)) {
            vVar = new g(dVar.a(a0Var), a0Var);
        } else {
            vVar = new m(a0Var);
        }
        vVarArr[0] = vVar;
        return vVarArr;
    }

    public final int d(Object obj) {
        boolean z10;
        q qVar = (q) obj;
        qVar.getClass();
        g1.a0 a0Var = this.f14083h;
        String str = a0Var.f6276s;
        String str2 = qVar.f14034b;
        if (str2.equals(str) || str2.equals(c0.b(a0Var))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || !qVar.c(a0Var, false)) {
            return 0;
        }
        return 1;
    }

    public final v[] f(Uri uri, Map map) {
        return a();
    }
}
