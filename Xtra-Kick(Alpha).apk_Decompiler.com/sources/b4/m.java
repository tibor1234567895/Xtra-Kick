package b4;

import android.graphics.Rect;
import android.support.v4.media.n;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.x1;
import g.r0;
import i0.f;
import java.util.ArrayList;
import java.util.List;

public class m extends x1 {
    public final void a(View view, Object obj) {
        ((u) obj).b(view);
    }

    public final void b(Object obj, ArrayList arrayList) {
        boolean z10;
        u uVar;
        u uVar2 = (u) obj;
        if (uVar2 != null) {
            int i10 = 0;
            if (uVar2 instanceof a0) {
                a0 a0Var = (a0) uVar2;
                int size = a0Var.F.size();
                while (i10 < size) {
                    if (i10 < 0 || i10 >= a0Var.F.size()) {
                        uVar = null;
                    } else {
                        uVar = (u) a0Var.F.get(i10);
                    }
                    b(uVar, arrayList);
                    i10++;
                }
                return;
            }
            if (!x1.h(uVar2.f2592l) || !x1.h((List) null) || !x1.h((List) null)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && x1.h(uVar2.f2593m)) {
                int size2 = arrayList.size();
                while (i10 < size2) {
                    uVar2.b((View) arrayList.get(i10));
                    i10++;
                }
            }
        }
    }

    public final void c(ViewGroup viewGroup, Object obj) {
        x.a(viewGroup, (u) obj);
    }

    public final boolean e(Object obj) {
        return obj instanceof u;
    }

    public final Object f(Object obj) {
        if (obj != null) {
            return ((u) obj).clone();
        }
        return null;
    }

    public final Object i(Object obj, Object obj2, Object obj3) {
        u uVar = (u) obj;
        u uVar2 = (u) obj2;
        u uVar3 = (u) obj3;
        if (uVar != null && uVar2 != null) {
            a0 a0Var = new a0();
            a0Var.H(uVar);
            a0Var.H(uVar2);
            a0Var.K(1);
            uVar = a0Var;
        } else if (uVar == null) {
            uVar = uVar2 != null ? uVar2 : null;
        }
        if (uVar3 == null) {
            return uVar;
        }
        a0 a0Var2 = new a0();
        if (uVar != null) {
            a0Var2.H(uVar);
        }
        a0Var2.H(uVar3);
        return a0Var2;
    }

    public final Object j(Object obj, Object obj2) {
        a0 a0Var = new a0();
        if (obj != null) {
            a0Var.H((u) obj);
        }
        a0Var.H((u) obj2);
        return a0Var;
    }

    public final void k(Object obj, View view, ArrayList arrayList) {
        ((u) obj).a(new j(view, arrayList));
    }

    public final void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((u) obj).a(new k(this, obj2, arrayList, obj3, arrayList2));
    }

    public final void m(View view, Object obj) {
        if (view != null) {
            x1.g(view, new Rect());
            ((u) obj).A(new i());
        }
    }

    public final void n(Object obj, Rect rect) {
        ((u) obj).A(new i());
    }

    public final void o(Object obj, f fVar, r0 r0Var) {
        u uVar = (u) obj;
        fVar.b(new n((Object) this, (Object) uVar, 23));
        uVar.a(new l(r0Var));
    }

    public final void p(Object obj, View view, ArrayList arrayList) {
        a0 a0Var = (a0) obj;
        ArrayList arrayList2 = a0Var.f2593m;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            x1.d((View) arrayList.get(i10), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(a0Var, arrayList);
    }

    public final void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        a0 a0Var = (a0) obj;
        if (a0Var != null) {
            ArrayList arrayList3 = a0Var.f2593m;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            s(a0Var, arrayList, arrayList2);
        }
    }

    public final Object r(Object obj) {
        if (obj == null) {
            return null;
        }
        a0 a0Var = new a0();
        a0Var.H((u) obj);
        return a0Var;
    }

    public final void s(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        boolean z10;
        int i10;
        u uVar;
        u uVar2 = (u) obj;
        int i11 = 0;
        if (uVar2 instanceof a0) {
            a0 a0Var = (a0) uVar2;
            int size = a0Var.F.size();
            while (i11 < size) {
                if (i11 < 0 || i11 >= a0Var.F.size()) {
                    uVar = null;
                } else {
                    uVar = (u) a0Var.F.get(i11);
                }
                s(uVar, arrayList, arrayList2);
                i11++;
            }
            return;
        }
        if (!x1.h(uVar2.f2592l) || !x1.h((List) null) || !x1.h((List) null)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ArrayList arrayList3 = uVar2.f2593m;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i10 = 0;
                } else {
                    i10 = arrayList2.size();
                }
                while (i11 < i10) {
                    uVar2.b((View) arrayList2.get(i11));
                    i11++;
                }
                int size2 = arrayList.size();
                while (true) {
                    size2--;
                    if (size2 >= 0) {
                        uVar2.w((View) arrayList.get(size2));
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
