package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

public final class l implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2072h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2073i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ r f2074j;

    public /* synthetic */ l(r rVar, ArrayList arrayList, int i10) {
        this.f2072h = i10;
        this.f2074j = rVar;
        this.f2073i = arrayList;
    }

    public final void run() {
        View view;
        View view2;
        long j10;
        int i10 = this.f2072h;
        r rVar = this.f2074j;
        ArrayList arrayList = this.f2073i;
        switch (i10) {
            case 0:
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    q qVar = (q) it.next();
                    k2 k2Var = qVar.f2134a;
                    rVar.getClass();
                    View view3 = k2Var.itemView;
                    int i11 = qVar.f2137d - qVar.f2135b;
                    int i12 = qVar.f2138e - qVar.f2136c;
                    if (i11 != 0) {
                        view3.animate().translationX(0.0f);
                    }
                    if (i12 != 0) {
                        view3.animate().translationY(0.0f);
                    }
                    ViewPropertyAnimator animate = view3.animate();
                    rVar.f2169p.add(k2Var);
                    animate.setDuration(rVar.f2100e).setListener(new n(rVar, k2Var, i11, view3, i12, animate)).start();
                }
                arrayList.clear();
                rVar.f2166m.remove(arrayList);
                return;
            case 1:
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    p pVar = (p) it2.next();
                    rVar.getClass();
                    k2 k2Var2 = pVar.f2117a;
                    if (k2Var2 == null) {
                        view = null;
                    } else {
                        view = k2Var2.itemView;
                    }
                    k2 k2Var3 = pVar.f2118b;
                    if (k2Var3 != null) {
                        view2 = k2Var3.itemView;
                    } else {
                        view2 = null;
                    }
                    ArrayList arrayList2 = rVar.f2171r;
                    long j11 = rVar.f2101f;
                    if (view != null) {
                        ViewPropertyAnimator duration = view.animate().setDuration(j11);
                        arrayList2.add(pVar.f2117a);
                        duration.translationX((float) (pVar.f2121e - pVar.f2119c));
                        duration.translationY((float) (pVar.f2122f - pVar.f2120d));
                        ViewPropertyAnimator alpha = duration.alpha(0.0f);
                        o oVar = r4;
                        j10 = j11;
                        o oVar2 = new o(rVar, pVar, duration, view, 0);
                        alpha.setListener(oVar).start();
                    } else {
                        j10 = j11;
                    }
                    if (view2 != null) {
                        ViewPropertyAnimator animate2 = view2.animate();
                        arrayList2.add(pVar.f2118b);
                        animate2.translationX(0.0f).translationY(0.0f).setDuration(j10).alpha(1.0f).setListener(new o(rVar, pVar, animate2, view2, 1)).start();
                    }
                }
                arrayList.clear();
                rVar.f2167n.remove(arrayList);
                return;
            default:
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    k2 k2Var4 = (k2) it3.next();
                    rVar.getClass();
                    View view4 = k2Var4.itemView;
                    ViewPropertyAnimator animate3 = view4.animate();
                    rVar.f2168o.add(k2Var4);
                    animate3.alpha(1.0f).setDuration(rVar.f2098c).setListener(new m(rVar, k2Var4, view4, animate3)).start();
                }
                arrayList.clear();
                rVar.f2165l.remove(arrayList);
                return;
        }
    }
}
