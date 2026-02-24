package j3;

import android.os.Bundle;
import android.support.v4.media.h;
import java.util.Iterator;
import java.util.List;
import ma.q;
import xa.j;

@l2("navigation")
public class i1 extends o2 {

    /* renamed from: c  reason: collision with root package name */
    public final q2 f8566c;

    public i1(q2 q2Var) {
        this.f8566c = q2Var;
    }

    public final c1 a() {
        return new h1(this);
    }

    public final void d(List list, n1 n1Var) {
        boolean z10;
        String str;
        c1 c1Var;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            c1 c1Var2 = rVar.f8661i;
            j.d("null cannot be cast to non-null type androidx.navigation.NavGraph", c1Var2);
            h1 h1Var = (h1) c1Var2;
            Bundle b10 = rVar.b();
            int i10 = h1Var.f8558s;
            String str2 = h1Var.f8560u;
            if (i10 == 0 && str2 == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                StringBuilder sb2 = new StringBuilder("no start destination defined via app:startDestination for ");
                int i11 = h1Var.f8513o;
                if (i11 != 0) {
                    str = h1Var.f8508j;
                    if (str == null) {
                        str = String.valueOf(i11);
                    }
                } else {
                    str = "the root navigation";
                }
                sb2.append(str);
                throw new IllegalStateException(sb2.toString().toString());
            }
            if (str2 != null) {
                c1Var = h1Var.j(str2, false);
            } else {
                c1Var = h1Var.i(i10, false);
            }
            if (c1Var == null) {
                if (h1Var.f8559t == null) {
                    String str3 = h1Var.f8560u;
                    if (str3 == null) {
                        str3 = String.valueOf(h1Var.f8558s);
                    }
                    h1Var.f8559t = str3;
                }
                String str4 = h1Var.f8559t;
                j.c(str4);
                throw new IllegalArgumentException(h.n("navigation destination ", str4, " is not a direct child of this NavGraph"));
            }
            this.f8566c.b(c1Var.f8506h).d(q.b(b().a(c1Var, c1Var.b(b10))), n1Var);
        }
    }
}
