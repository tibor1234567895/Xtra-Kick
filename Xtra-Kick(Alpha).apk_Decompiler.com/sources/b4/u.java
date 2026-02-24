package b4;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.v4.media.h;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.appcompat.widget.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.o0;
import q.e;
import q.g;
import q.i;
import q0.f;

public abstract class u implements Cloneable {
    public static final int[] C = {2, 1, 3, 4};
    public static final p D = new p();
    public static final ThreadLocal E = new ThreadLocal();
    public s A;
    public n B = D;

    /* renamed from: h  reason: collision with root package name */
    public final String f2588h = getClass().getName();

    /* renamed from: i  reason: collision with root package name */
    public long f2589i = -1;

    /* renamed from: j  reason: collision with root package name */
    public long f2590j = -1;

    /* renamed from: k  reason: collision with root package name */
    public TimeInterpolator f2591k = null;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f2592l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f2593m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public d0 f2594n = new d0();

    /* renamed from: o  reason: collision with root package name */
    public d0 f2595o = new d0();

    /* renamed from: p  reason: collision with root package name */
    public a0 f2596p = null;

    /* renamed from: q  reason: collision with root package name */
    public final int[] f2597q = C;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList f2598r;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList f2599s;

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList f2600t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    public int f2601u = 0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2602v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f2603w = false;

    /* renamed from: x  reason: collision with root package name */
    public ArrayList f2604x = null;

    /* renamed from: y  reason: collision with root package name */
    public ArrayList f2605y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    public y f2606z;

    public static void c(d0 d0Var, View view, c0 c0Var) {
        d0Var.f2526a.put(view, c0Var);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = d0Var.f2527b;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, (Object) null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = c1.f10054a;
        String k10 = o0.k(view);
        if (k10 != null) {
            e eVar = d0Var.f2529d;
            if (eVar.containsKey(k10)) {
                eVar.put(k10, (Object) null);
            } else {
                eVar.put(k10, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                i iVar = d0Var.f2528c;
                if (iVar.f13066h) {
                    iVar.d();
                }
                if (g.b(iVar.f13067i, iVar.f13069k, itemIdAtPosition) >= 0) {
                    View view2 = (View) iVar.e(itemIdAtPosition, (Long) null);
                    if (view2 != null) {
                        i0.r(view2, false);
                        iVar.g(itemIdAtPosition, (Object) null);
                        return;
                    }
                    return;
                }
                i0.r(view, true);
                iVar.g(itemIdAtPosition, view);
            }
        }
    }

    public static e o() {
        ThreadLocal threadLocal = E;
        e eVar = (e) threadLocal.get();
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        threadLocal.set(eVar2);
        return eVar2;
    }

    public static boolean t(c0 c0Var, c0 c0Var2, String str) {
        Object obj = c0Var.f2521a.get(str);
        Object obj2 = c0Var2.f2521a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(s sVar) {
        this.A = sVar;
    }

    public void B(TimeInterpolator timeInterpolator) {
        this.f2591k = timeInterpolator;
    }

    public void C(n nVar) {
        if (nVar == null) {
            nVar = D;
        }
        this.B = nVar;
    }

    public void D(y yVar) {
        this.f2606z = yVar;
    }

    public void E(long j10) {
        this.f2589i = j10;
    }

    public final void F() {
        if (this.f2601u == 0) {
            ArrayList arrayList = this.f2604x;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f2604x.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((t) arrayList2.get(i10)).b(this);
                }
            }
            this.f2603w = false;
        }
        this.f2601u++;
    }

    public String G(String str) {
        StringBuilder q10 = h.q(str);
        q10.append(getClass().getSimpleName());
        q10.append("@");
        q10.append(Integer.toHexString(hashCode()));
        q10.append(": ");
        String sb2 = q10.toString();
        if (this.f2590j != -1) {
            sb2 = sb2 + "dur(" + this.f2590j + ") ";
        }
        if (this.f2589i != -1) {
            sb2 = sb2 + "dly(" + this.f2589i + ") ";
        }
        if (this.f2591k != null) {
            sb2 = sb2 + "interp(" + this.f2591k + ") ";
        }
        ArrayList arrayList = this.f2592l;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2593m;
        if (size <= 0 && arrayList2.size() <= 0) {
            return sb2;
        }
        String g10 = f.g(sb2, "tgts(");
        if (arrayList.size() > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (i10 > 0) {
                    g10 = f.g(g10, ", ");
                }
                StringBuilder q11 = h.q(g10);
                q11.append(arrayList.get(i10));
                g10 = q11.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                if (i11 > 0) {
                    g10 = f.g(g10, ", ");
                }
                StringBuilder q12 = h.q(g10);
                q12.append(arrayList2.get(i11));
                g10 = q12.toString();
            }
        }
        return f.g(g10, ")");
    }

    public void a(t tVar) {
        if (this.f2604x == null) {
            this.f2604x = new ArrayList();
        }
        this.f2604x.add(tVar);
    }

    public void b(View view) {
        this.f2593m.add(view);
    }

    public void cancel() {
        ArrayList arrayList = this.f2600t;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = this.f2604x;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) this.f2604x.clone();
            int size2 = arrayList3.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((t) arrayList3.get(i10)).e();
            }
        }
    }

    public abstract void d(c0 c0Var);

    public final void e(View view, boolean z10) {
        if (view != null) {
            view.getId();
            if (view.getParent() instanceof ViewGroup) {
                c0 c0Var = new c0(view);
                if (z10) {
                    g(c0Var);
                } else {
                    d(c0Var);
                }
                c0Var.f2523c.add(this);
                f(c0Var);
                c(z10 ? this.f2594n : this.f2595o, view, c0Var);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    e(viewGroup.getChildAt(i10), z10);
                }
            }
        }
    }

    public void f(c0 c0Var) {
        String[] b10;
        if (this.f2606z != null) {
            HashMap hashMap = c0Var.f2521a;
            if (!hashMap.isEmpty() && (b10 = this.f2606z.b()) != null) {
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= b10.length) {
                        z10 = true;
                        break;
                    } else if (!hashMap.containsKey(b10[i10])) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (!z10) {
                    this.f2606z.a();
                }
            }
        }
    }

    public abstract void g(c0 c0Var);

    public final void h(ViewGroup viewGroup, boolean z10) {
        i(z10);
        ArrayList arrayList = this.f2592l;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2593m;
        if (size > 0 || arrayList2.size() > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i10)).intValue());
                if (findViewById != null) {
                    c0 c0Var = new c0(findViewById);
                    if (z10) {
                        g(c0Var);
                    } else {
                        d(c0Var);
                    }
                    c0Var.f2523c.add(this);
                    f(c0Var);
                    c(z10 ? this.f2594n : this.f2595o, findViewById, c0Var);
                }
            }
            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                View view = (View) arrayList2.get(i11);
                c0 c0Var2 = new c0(view);
                if (z10) {
                    g(c0Var2);
                } else {
                    d(c0Var2);
                }
                c0Var2.f2523c.add(this);
                f(c0Var2);
                c(z10 ? this.f2594n : this.f2595o, view, c0Var2);
            }
            return;
        }
        e(viewGroup, z10);
    }

    public final void i(boolean z10) {
        d0 d0Var;
        if (z10) {
            this.f2594n.f2526a.clear();
            this.f2594n.f2527b.clear();
            d0Var = this.f2594n;
        } else {
            this.f2595o.f2526a.clear();
            this.f2595o.f2527b.clear();
            d0Var = this.f2595o;
        }
        d0Var.f2528c.b();
    }

    /* renamed from: j */
    public u clone() {
        try {
            u uVar = (u) super.clone();
            uVar.f2605y = new ArrayList();
            uVar.f2594n = new d0();
            uVar.f2595o = new d0();
            uVar.f2598r = null;
            uVar.f2599s = null;
            return uVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        return null;
    }

    public void l(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList arrayList, ArrayList arrayList2) {
        int i10;
        boolean z10;
        Animator k10;
        Animator animator;
        c0 c0Var;
        View view;
        c0 c0Var2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        e o10 = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j10 = Long.MAX_VALUE;
        int i11 = 0;
        while (i11 < size) {
            c0 c0Var3 = (c0) arrayList.get(i11);
            c0 c0Var4 = (c0) arrayList2.get(i11);
            if (c0Var3 != null && !c0Var3.f2523c.contains(this)) {
                c0Var3 = null;
            }
            if (c0Var4 != null && !c0Var4.f2523c.contains(this)) {
                c0Var4 = null;
            }
            if (!(c0Var3 == null && c0Var4 == null)) {
                if (c0Var3 == null || c0Var4 == null || r(c0Var3, c0Var4)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 && (k10 = k(viewGroup2, c0Var3, c0Var4)) != null) {
                    if (c0Var4 != null) {
                        String[] p10 = p();
                        View view2 = c0Var4.f2522b;
                        if (p10 != null && p10.length > 0) {
                            c0Var2 = new c0(view2);
                            Animator animator3 = k10;
                            c0 c0Var5 = (c0) d0Var2.f2526a.getOrDefault(view2, (Object) null);
                            i10 = size;
                            if (c0Var5 != null) {
                                int i12 = 0;
                                while (i12 < p10.length) {
                                    HashMap hashMap = c0Var2.f2521a;
                                    String str = p10[i12];
                                    hashMap.put(str, c0Var5.f2521a.get(str));
                                    i12++;
                                    d0 d0Var3 = d0Var2;
                                    p10 = p10;
                                }
                            }
                            int i13 = o10.f13081j;
                            int i14 = 0;
                            while (true) {
                                if (i14 >= i13) {
                                    animator2 = animator3;
                                    break;
                                }
                                r rVar = (r) o10.getOrDefault((Animator) o10.h(i14), (Object) null);
                                if (rVar.f2584c != null && rVar.f2582a == view2 && rVar.f2583b.equals(this.f2588h) && rVar.f2584c.equals(c0Var2)) {
                                    animator2 = null;
                                    break;
                                }
                                i14++;
                            }
                        } else {
                            i10 = size;
                            animator2 = k10;
                            c0Var2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        c0Var = c0Var2;
                    } else {
                        i10 = size;
                        view = c0Var3.f2522b;
                        animator = k10;
                        c0Var = null;
                    }
                    if (animator != null) {
                        y yVar = this.f2606z;
                        if (yVar != null) {
                            long c10 = yVar.c();
                            sparseIntArray.put(this.f2605y.size(), (int) c10);
                            j10 = Math.min(c10, j10);
                        }
                        long j11 = j10;
                        String str2 = this.f2588h;
                        i0 i0Var = g0.f2543a;
                        o10.put(animator, new r(view, str2, this, new r0(viewGroup2), c0Var));
                        this.f2605y.add(animator);
                        j10 = j11;
                    }
                    i11++;
                    size = i10;
                }
            }
            i10 = size;
            i11++;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i15 = 0; i15 < sparseIntArray.size(); i15++) {
                Animator animator4 = (Animator) this.f2605y.get(sparseIntArray.keyAt(i15));
                animator4.setStartDelay(animator4.getStartDelay() + (((long) sparseIntArray.valueAt(i15)) - j10));
            }
        }
    }

    public final void m() {
        int i10 = this.f2601u - 1;
        this.f2601u = i10;
        if (i10 == 0) {
            ArrayList arrayList = this.f2604x;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f2604x.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((t) arrayList2.get(i11)).a(this);
                }
            }
            for (int i12 = 0; i12 < this.f2594n.f2528c.i(); i12++) {
                View view = (View) this.f2594n.f2528c.j(i12);
                if (view != null) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    i0.r(view, false);
                }
            }
            for (int i13 = 0; i13 < this.f2595o.f2528c.i(); i13++) {
                View view2 = (View) this.f2595o.f2528c.j(i13);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = c1.f10054a;
                    i0.r(view2, false);
                }
            }
            this.f2603w = true;
        }
    }

    public final c0 n(View view, boolean z10) {
        a0 a0Var = this.f2596p;
        if (a0Var != null) {
            return a0Var.n(view, z10);
        }
        ArrayList arrayList = z10 ? this.f2598r : this.f2599s;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            c0 c0Var = (c0) arrayList.get(i10);
            if (c0Var == null) {
                return null;
            }
            if (c0Var.f2522b == view) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return null;
        }
        return (c0) (z10 ? this.f2599s : this.f2598r).get(i10);
    }

    public String[] p() {
        return null;
    }

    public final c0 q(View view, boolean z10) {
        d0 d0Var;
        a0 a0Var = this.f2596p;
        if (a0Var != null) {
            return a0Var.q(view, z10);
        }
        if (z10) {
            d0Var = this.f2594n;
        } else {
            d0Var = this.f2595o;
        }
        return (c0) d0Var.f2526a.getOrDefault(view, (Object) null);
    }

    public boolean r(c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null) {
            return false;
        }
        String[] p10 = p();
        if (p10 != null) {
            int length = p10.length;
            int i10 = 0;
            while (i10 < length) {
                if (!t(c0Var, c0Var2, p10[i10])) {
                    i10++;
                }
            }
            return false;
        }
        for (String t10 : c0Var.f2521a.keySet()) {
            if (t(c0Var, c0Var2, t10)) {
            }
        }
        return false;
        return true;
    }

    public final boolean s(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f2592l;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2593m;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final String toString() {
        return G("");
    }

    public void u(View view) {
        if (!this.f2603w) {
            ArrayList arrayList = this.f2600t;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Animator) arrayList.get(size)).pause();
            }
            ArrayList arrayList2 = this.f2604x;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList3 = (ArrayList) this.f2604x.clone();
                int size2 = arrayList3.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    ((t) arrayList3.get(i10)).c();
                }
            }
            this.f2602v = true;
        }
    }

    public void v(t tVar) {
        ArrayList arrayList = this.f2604x;
        if (arrayList != null) {
            arrayList.remove(tVar);
            if (this.f2604x.size() == 0) {
                this.f2604x = null;
            }
        }
    }

    public void w(View view) {
        this.f2593m.remove(view);
    }

    public void x(ViewGroup viewGroup) {
        if (this.f2602v) {
            if (!this.f2603w) {
                ArrayList arrayList = this.f2600t;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    ((Animator) arrayList.get(size)).resume();
                }
                ArrayList arrayList2 = this.f2604x;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ArrayList arrayList3 = (ArrayList) this.f2604x.clone();
                    int size2 = arrayList3.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        ((t) arrayList3.get(i10)).d();
                    }
                }
            }
            this.f2602v = false;
        }
    }

    public void y() {
        F();
        e o10 = o();
        Iterator it = this.f2605y.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (o10.containsKey(animator)) {
                F();
                if (animator != null) {
                    animator.addListener(new q(this, o10));
                    long j10 = this.f2590j;
                    if (j10 >= 0) {
                        animator.setDuration(j10);
                    }
                    long j11 = this.f2589i;
                    if (j11 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j11);
                    }
                    TimeInterpolator timeInterpolator = this.f2591k;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new d(1, this));
                    animator.start();
                }
            }
        }
        this.f2605y.clear();
        m();
    }

    public void z(long j10) {
        this.f2590j = j10;
    }
}
