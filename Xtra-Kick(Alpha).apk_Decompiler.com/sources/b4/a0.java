package b4;

import android.animation.TimeInterpolator;
import android.support.v4.media.h;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class a0 extends u {
    public ArrayList F = new ArrayList();
    public boolean G = true;
    public int H;
    public boolean I = false;
    public int J = 0;

    public final void A(s sVar) {
        this.A = sVar;
        this.J |= 8;
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((u) this.F.get(i10)).A(sVar);
        }
    }

    public final void C(n nVar) {
        super.C(nVar);
        this.J |= 4;
        if (this.F != null) {
            for (int i10 = 0; i10 < this.F.size(); i10++) {
                ((u) this.F.get(i10)).C(nVar);
            }
        }
    }

    public final void D(y yVar) {
        this.f2606z = yVar;
        this.J |= 2;
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((u) this.F.get(i10)).D(yVar);
        }
    }

    public final void E(long j10) {
        this.f2589i = j10;
    }

    public final String G(String str) {
        String G2 = super.G(str);
        for (int i10 = 0; i10 < this.F.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(G2);
            sb2.append(Constants.WRITE_NEW_LINE);
            sb2.append(((u) this.F.get(i10)).G(str + "  "));
            G2 = sb2.toString();
        }
        return G2;
    }

    public final void H(u uVar) {
        this.F.add(uVar);
        uVar.f2596p = this;
        long j10 = this.f2590j;
        if (j10 >= 0) {
            uVar.z(j10);
        }
        if ((this.J & 1) != 0) {
            uVar.B(this.f2591k);
        }
        if ((this.J & 2) != 0) {
            uVar.D(this.f2606z);
        }
        if ((this.J & 4) != 0) {
            uVar.C(this.B);
        }
        if ((this.J & 8) != 0) {
            uVar.A(this.A);
        }
    }

    /* renamed from: I */
    public final void z(long j10) {
        ArrayList arrayList;
        this.f2590j = j10;
        if (j10 >= 0 && (arrayList = this.F) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((u) this.F.get(i10)).z(j10);
            }
        }
    }

    /* renamed from: J */
    public final void B(TimeInterpolator timeInterpolator) {
        this.J |= 1;
        ArrayList arrayList = this.F;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((u) this.F.get(i10)).B(timeInterpolator);
            }
        }
        this.f2591k = timeInterpolator;
    }

    public final void K(int i10) {
        if (i10 == 0) {
            this.G = true;
        } else if (i10 == 1) {
            this.G = false;
        } else {
            throw new AndroidRuntimeException(h.i("Invalid parameter for TransitionSet ordering: ", i10));
        }
    }

    public final void a(t tVar) {
        super.a(tVar);
    }

    public final void b(View view) {
        for (int i10 = 0; i10 < this.F.size(); i10++) {
            ((u) this.F.get(i10)).b(view);
        }
        this.f2593m.add(view);
    }

    public final void cancel() {
        super.cancel();
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((u) this.F.get(i10)).cancel();
        }
    }

    public final void d(c0 c0Var) {
        View view = c0Var.f2522b;
        if (s(view)) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                if (uVar.s(view)) {
                    uVar.d(c0Var);
                    c0Var.f2523c.add(uVar);
                }
            }
        }
    }

    public final void f(c0 c0Var) {
        super.f(c0Var);
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((u) this.F.get(i10)).f(c0Var);
        }
    }

    public final void g(c0 c0Var) {
        View view = c0Var.f2522b;
        if (s(view)) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                if (uVar.s(view)) {
                    uVar.g(c0Var);
                    c0Var.f2523c.add(uVar);
                }
            }
        }
    }

    /* renamed from: j */
    public final u clone() {
        a0 a0Var = (a0) super.clone();
        a0Var.F = new ArrayList();
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            u j10 = ((u) this.F.get(i10)).clone();
            a0Var.F.add(j10);
            j10.f2596p = a0Var;
        }
        return a0Var;
    }

    public final void l(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList arrayList, ArrayList arrayList2) {
        long j10 = this.f2589i;
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            u uVar = (u) this.F.get(i10);
            if (j10 > 0 && (this.G || i10 == 0)) {
                long j11 = uVar.f2589i;
                if (j11 > 0) {
                    uVar.E(j11 + j10);
                } else {
                    uVar.E(j10);
                }
            }
            uVar.l(viewGroup, d0Var, d0Var2, arrayList, arrayList2);
        }
    }

    public final void u(View view) {
        super.u(view);
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((u) this.F.get(i10)).u(view);
        }
    }

    public final void v(t tVar) {
        super.v(tVar);
    }

    public final void w(View view) {
        for (int i10 = 0; i10 < this.F.size(); i10++) {
            ((u) this.F.get(i10)).w(view);
        }
        this.f2593m.remove(view);
    }

    public final void x(ViewGroup viewGroup) {
        super.x(viewGroup);
        int size = this.F.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((u) this.F.get(i10)).x(viewGroup);
        }
    }

    public final void y() {
        if (this.F.isEmpty()) {
            F();
            m();
            return;
        }
        z zVar = new z(this);
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            ((u) it.next()).a(zVar);
        }
        this.H = this.F.size();
        if (!this.G) {
            for (int i10 = 1; i10 < this.F.size(); i10++) {
                ((u) this.F.get(i10 - 1)).a(new g(this, 2, (u) this.F.get(i10)));
            }
            u uVar = (u) this.F.get(0);
            if (uVar != null) {
                uVar.y();
                return;
            }
            return;
        }
        Iterator it2 = this.F.iterator();
        while (it2.hasNext()) {
            ((u) it2.next()).y();
        }
    }
}
