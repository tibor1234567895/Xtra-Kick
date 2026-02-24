package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.media.h;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public final class r extends o2 {

    /* renamed from: s  reason: collision with root package name */
    public static TimeInterpolator f2160s;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f2161h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f2162i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f2163j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f2164k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f2165l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f2166m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f2167n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public final ArrayList f2168o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f2169p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public final ArrayList f2170q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public final ArrayList f2171r = new ArrayList();

    public static void q(ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ((k2) arrayList.get(size)).itemView.animate().cancel();
            } else {
                return;
            }
        }
    }

    public final boolean g(k2 k2Var, List list) {
        if (!list.isEmpty() || f(k2Var)) {
            return true;
        }
        return false;
    }

    public final void i(k2 k2Var) {
        View view = k2Var.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f2163j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((q) arrayList.get(size)).f2134a == k2Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                h(k2Var);
                arrayList.remove(size);
            }
        }
        s(k2Var, this.f2164k);
        if (this.f2161h.remove(k2Var)) {
            view.setAlpha(1.0f);
            h(k2Var);
        }
        if (this.f2162i.remove(k2Var)) {
            view.setAlpha(1.0f);
            h(k2Var);
        }
        ArrayList arrayList2 = this.f2167n;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            s(k2Var, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f2166m;
        int size3 = arrayList4.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (((q) arrayList5.get(size4)).f2134a == k2Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    h(k2Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                }
            }
        }
        ArrayList arrayList6 = this.f2165l;
        int size5 = arrayList6.size();
        while (true) {
            size5--;
            if (size5 >= 0) {
                ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
                if (arrayList7.remove(k2Var)) {
                    view.setAlpha(1.0f);
                    h(k2Var);
                    if (arrayList7.isEmpty()) {
                        arrayList6.remove(size5);
                    }
                }
            } else {
                this.f2170q.remove(k2Var);
                this.f2168o.remove(k2Var);
                this.f2171r.remove(k2Var);
                this.f2169p.remove(k2Var);
                r();
                return;
            }
        }
    }

    public final void j() {
        ArrayList arrayList = this.f2163j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            q qVar = (q) arrayList.get(size);
            View view = qVar.f2134a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            h(qVar.f2134a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f2161h;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            h((k2) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f2162i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            k2 k2Var = (k2) arrayList3.get(size3);
            k2Var.itemView.setAlpha(1.0f);
            h(k2Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f2164k;
        int size4 = arrayList4.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            p pVar = (p) arrayList4.get(size4);
            k2 k2Var2 = pVar.f2117a;
            if (k2Var2 != null) {
                t(pVar, k2Var2);
            }
            k2 k2Var3 = pVar.f2118b;
            if (k2Var3 != null) {
                t(pVar, k2Var3);
            }
        }
        arrayList4.clear();
        if (k()) {
            ArrayList arrayList5 = this.f2166m;
            int size5 = arrayList5.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                int size6 = arrayList6.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        q qVar2 = (q) arrayList6.get(size6);
                        View view2 = qVar2.f2134a.itemView;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        h(qVar2.f2134a);
                        arrayList6.remove(size6);
                        if (arrayList6.isEmpty()) {
                            arrayList5.remove(arrayList6);
                        }
                    }
                }
            }
            ArrayList arrayList7 = this.f2165l;
            int size7 = arrayList7.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                int size8 = arrayList8.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        k2 k2Var4 = (k2) arrayList8.get(size8);
                        k2Var4.itemView.setAlpha(1.0f);
                        h(k2Var4);
                        arrayList8.remove(size8);
                        if (arrayList8.isEmpty()) {
                            arrayList7.remove(arrayList8);
                        }
                    }
                }
            }
            ArrayList arrayList9 = this.f2167n;
            int size9 = arrayList9.size();
            while (true) {
                size9--;
                if (size9 < 0) {
                    break;
                }
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                int size10 = arrayList10.size();
                while (true) {
                    size10--;
                    if (size10 >= 0) {
                        p pVar2 = (p) arrayList10.get(size10);
                        k2 k2Var5 = pVar2.f2117a;
                        if (k2Var5 != null) {
                            t(pVar2, k2Var5);
                        }
                        k2 k2Var6 = pVar2.f2118b;
                        if (k2Var6 != null) {
                            t(pVar2, k2Var6);
                        }
                        if (arrayList10.isEmpty()) {
                            arrayList9.remove(arrayList10);
                        }
                    }
                }
            }
            q(this.f2170q);
            q(this.f2169p);
            q(this.f2168o);
            q(this.f2171r);
            ArrayList arrayList11 = this.f2097b;
            if (arrayList11.size() <= 0) {
                arrayList11.clear();
            } else {
                h.y(arrayList11.get(0));
                throw null;
            }
        }
    }

    public final boolean k() {
        return !this.f2162i.isEmpty() || !this.f2164k.isEmpty() || !this.f2163j.isEmpty() || !this.f2161h.isEmpty() || !this.f2169p.isEmpty() || !this.f2170q.isEmpty() || !this.f2168o.isEmpty() || !this.f2171r.isEmpty() || !this.f2166m.isEmpty() || !this.f2165l.isEmpty() || !this.f2167n.isEmpty();
    }

    public final void l() {
        long j10;
        long j11;
        ArrayList arrayList = this.f2161h;
        boolean z10 = !arrayList.isEmpty();
        ArrayList arrayList2 = this.f2163j;
        boolean z11 = !arrayList2.isEmpty();
        ArrayList arrayList3 = this.f2164k;
        boolean z12 = !arrayList3.isEmpty();
        ArrayList arrayList4 = this.f2162i;
        boolean z13 = !arrayList4.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator it = arrayList.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                j10 = this.f2099d;
                if (!hasNext) {
                    break;
                }
                k2 k2Var = (k2) it.next();
                View view = k2Var.itemView;
                ViewPropertyAnimator animate = view.animate();
                this.f2170q.add(k2Var);
                animate.setDuration(j10).alpha(0.0f).setListener(new m(this, k2Var, animate, view)).start();
            }
            arrayList.clear();
            if (z11) {
                ArrayList arrayList5 = new ArrayList();
                arrayList5.addAll(arrayList2);
                this.f2166m.add(arrayList5);
                arrayList2.clear();
                l lVar = new l(this, arrayList5, 0);
                if (z10) {
                    View view2 = ((q) arrayList5.get(0)).f2134a.itemView;
                    WeakHashMap weakHashMap = c1.f10054a;
                    i0.n(view2, lVar, j10);
                } else {
                    lVar.run();
                }
            }
            if (z12) {
                ArrayList arrayList6 = new ArrayList();
                arrayList6.addAll(arrayList3);
                this.f2167n.add(arrayList6);
                arrayList3.clear();
                l lVar2 = new l(this, arrayList6, 1);
                if (z10) {
                    View view3 = ((p) arrayList6.get(0)).f2117a.itemView;
                    WeakHashMap weakHashMap2 = c1.f10054a;
                    i0.n(view3, lVar2, j10);
                } else {
                    lVar2.run();
                }
            }
            if (z13) {
                ArrayList arrayList7 = new ArrayList();
                arrayList7.addAll(arrayList4);
                this.f2165l.add(arrayList7);
                arrayList4.clear();
                l lVar3 = new l(this, arrayList7, 2);
                if (z10 || z11 || z12) {
                    long j12 = 0;
                    if (!z10) {
                        j10 = 0;
                    }
                    if (z11) {
                        j11 = this.f2100e;
                    } else {
                        j11 = 0;
                    }
                    if (z12) {
                        j12 = this.f2101f;
                    }
                    View view4 = ((k2) arrayList7.get(0)).itemView;
                    WeakHashMap weakHashMap3 = c1.f10054a;
                    i0.n(view4, lVar3, Math.max(j11, j12) + j10);
                    return;
                }
                lVar3.run();
            }
        }
    }

    public final void m(k2 k2Var) {
        u(k2Var);
        k2Var.itemView.setAlpha(0.0f);
        this.f2162i.add(k2Var);
    }

    public final boolean n(k2 k2Var, k2 k2Var2, int i10, int i11, int i12, int i13) {
        if (k2Var == k2Var2) {
            return o(k2Var, i10, i11, i12, i13);
        }
        float translationX = k2Var.itemView.getTranslationX();
        float translationY = k2Var.itemView.getTranslationY();
        float alpha = k2Var.itemView.getAlpha();
        u(k2Var);
        k2Var.itemView.setTranslationX(translationX);
        k2Var.itemView.setTranslationY(translationY);
        k2Var.itemView.setAlpha(alpha);
        u(k2Var2);
        k2Var2.itemView.setTranslationX((float) (-((int) (((float) (i12 - i10)) - translationX))));
        k2Var2.itemView.setTranslationY((float) (-((int) (((float) (i13 - i11)) - translationY))));
        k2Var2.itemView.setAlpha(0.0f);
        this.f2164k.add(new p(k2Var, k2Var2, i10, i11, i12, i13));
        return true;
    }

    public final boolean o(k2 k2Var, int i10, int i11, int i12, int i13) {
        View view = k2Var.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) k2Var.itemView.getTranslationY());
        u(k2Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            h(k2Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX((float) (-i14));
        }
        if (i15 != 0) {
            view.setTranslationY((float) (-i15));
        }
        this.f2163j.add(new q(k2Var, translationX, translationY, i12, i13));
        return true;
    }

    public final void p(k2 k2Var) {
        u(k2Var);
        this.f2161h.add(k2Var);
    }

    public final void r() {
        if (!k()) {
            ArrayList arrayList = this.f2097b;
            if (arrayList.size() <= 0) {
                arrayList.clear();
            } else {
                h.y(arrayList.get(0));
                throw null;
            }
        }
    }

    public final void s(k2 k2Var, ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                p pVar = (p) arrayList.get(size);
                if (t(pVar, k2Var) && pVar.f2117a == null && pVar.f2118b == null) {
                    arrayList.remove(pVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean t(p pVar, k2 k2Var) {
        if (pVar.f2118b == k2Var) {
            pVar.f2118b = null;
        } else if (pVar.f2117a != k2Var) {
            return false;
        } else {
            pVar.f2117a = null;
        }
        k2Var.itemView.setAlpha(1.0f);
        k2Var.itemView.setTranslationX(0.0f);
        k2Var.itemView.setTranslationY(0.0f);
        h(k2Var);
        return true;
    }

    public final void u(k2 k2Var) {
        if (f2160s == null) {
            f2160s = new ValueAnimator().getInterpolator();
        }
        k2Var.itemView.animate().setInterpolator(f2160s);
        i(k2Var);
    }
}
