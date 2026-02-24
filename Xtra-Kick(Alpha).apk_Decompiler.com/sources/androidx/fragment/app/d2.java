package androidx.fragment.app;

import android.view.View;
import java.util.Iterator;
import java.util.Objects;
import xa.j;

public final class d2 extends h2 {

    /* renamed from: h  reason: collision with root package name */
    public final m1 f1399h;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d2(androidx.fragment.app.g2 r3, androidx.fragment.app.e2 r4, androidx.fragment.app.m1 r5, i0.f r6) {
        /*
            r2 = this;
            java.lang.String r0 = "fragmentStateManager"
            xa.j.f(r0, r5)
            java.lang.String r0 = "fragmentStateManager.fragment"
            androidx.fragment.app.c0 r1 = r5.f1502c
            xa.j.e(r0, r1)
            r2.<init>(r3, r4, r1, r6)
            r2.f1399h = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d2.<init>(androidx.fragment.app.g2, androidx.fragment.app.e2, androidx.fragment.app.m1, i0.f):void");
    }

    public final void b() {
        if (!this.f1459g) {
            if (c1.I(2)) {
                toString();
            }
            this.f1459g = true;
            Iterator it = this.f1456d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f1399h.k();
    }

    public final void d() {
        boolean z10;
        float f10;
        e2 e2Var = this.f1454b;
        e2 e2Var2 = e2.ADDING;
        m1 m1Var = this.f1399h;
        if (e2Var == e2Var2) {
            c0 c0Var = m1Var.f1502c;
            j.e("fragmentStateManager.fragment", c0Var);
            View findFocus = c0Var.M.findFocus();
            if (findFocus != null) {
                c0Var.s().f1609m = findFocus;
                if (c1.I(2)) {
                    findFocus.toString();
                    c0Var.toString();
                }
            }
            View h02 = this.f1455c.h0();
            if (h02.getParent() == null) {
                m1Var.b();
                h02.setAlpha(0.0f);
            }
            if (h02.getAlpha() == 0.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && h02.getVisibility() == 0) {
                h02.setVisibility(4);
            }
            x xVar = c0Var.P;
            if (xVar == null) {
                f10 = 1.0f;
            } else {
                f10 = xVar.f1608l;
            }
            h02.setAlpha(f10);
        } else if (e2Var == e2.REMOVING) {
            c0 c0Var2 = m1Var.f1502c;
            j.e("fragmentStateManager.fragment", c0Var2);
            View h03 = c0Var2.h0();
            if (c1.I(2)) {
                Objects.toString(h03.findFocus());
                h03.toString();
                c0Var2.toString();
            }
            h03.clearFocus();
        }
    }
}
