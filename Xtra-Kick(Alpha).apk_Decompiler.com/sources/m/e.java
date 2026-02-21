package m;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.h3;
import androidx.appcompat.widget.x0;
import androidx.appcompat.widget.y0;
import androidx.appcompat.widget.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.c1;
import m0.d;
import m0.l0;

public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9907h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9908i;

    public /* synthetic */ e(int i10, Object obj) {
        this.f9907h = i10;
        this.f9908i = obj;
    }

    public final void onGlobalLayout() {
        int i10 = this.f9907h;
        boolean z10 = true;
        Object obj = this.f9908i;
        switch (i10) {
            case 0:
                i iVar = (i) obj;
                if (iVar.b()) {
                    ArrayList arrayList = iVar.f9945p;
                    if (arrayList.size() > 0 && !((h) arrayList.get(0)).f9917a.F) {
                        View view = iVar.f9952w;
                        if (view == null || !view.isShown()) {
                            iVar.dismiss();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((h) it.next()).f9917a.d();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 1:
                h0 h0Var = (h0) obj;
                if (h0Var.b()) {
                    h3 h3Var = h0Var.f9927p;
                    if (!h3Var.F) {
                        View view2 = h0Var.f9932u;
                        if (view2 == null || !view2.isShown()) {
                            h0Var.dismiss();
                            return;
                        } else {
                            h3Var.d();
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 2:
                z zVar = (z) obj;
                if (!zVar.b()) {
                    return;
                }
                if (!zVar.isShown()) {
                    zVar.getListPopupWindow().dismiss();
                    return;
                }
                zVar.getListPopupWindow().d();
                d dVar = zVar.f1144p;
                if (dVar != null) {
                    dVar.i(true);
                    return;
                }
                return;
            case 3:
                h1 h1Var = (h1) obj;
                if (!h1Var.getInternalPopup().b()) {
                    h1Var.f852m.m(y0.b(h1Var), y0.a(h1Var));
                }
                ViewTreeObserver viewTreeObserver = h1Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    x0.a(viewTreeObserver, this);
                    return;
                }
                return;
            default:
                d1 d1Var = (d1) obj;
                h1 h1Var2 = d1Var.O;
                WeakHashMap weakHashMap = c1.f10054a;
                if (!l0.b(h1Var2) || !h1Var2.getGlobalVisibleRect(d1Var.M)) {
                    z10 = false;
                }
                if (!z10) {
                    d1Var.dismiss();
                    return;
                }
                d1Var.r();
                d1Var.d();
                return;
        }
    }
}
