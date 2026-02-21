package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import l.d;
import m.c0;
import m.i0;
import m.o;
import m.q;

public final class y4 implements c0 {

    /* renamed from: h  reason: collision with root package name */
    public o f1133h;

    /* renamed from: i  reason: collision with root package name */
    public q f1134i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Toolbar f1135j;

    public y4(Toolbar toolbar) {
        this.f1135j = toolbar;
    }

    public final void a(o oVar, boolean z10) {
    }

    public final void c(Parcelable parcelable) {
    }

    public final void e(boolean z10) {
        if (this.f1134i != null) {
            o oVar = this.f1133h;
            boolean z11 = false;
            if (oVar != null) {
                int size = oVar.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    } else if (this.f1133h.getItem(i10) == this.f1134i) {
                        z11 = true;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            if (!z11) {
                m(this.f1134i);
            }
        }
    }

    public final boolean g(q qVar) {
        Toolbar toolbar = this.f1135j;
        toolbar.c();
        ViewParent parent = toolbar.f698o.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f698o);
            }
            toolbar.addView(toolbar.f698o);
        }
        View actionView = qVar.getActionView();
        toolbar.f699p = actionView;
        this.f1134i = qVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f699p);
            }
            z4 z4Var = new z4();
            z4Var.f6019a = (toolbar.f704u & 112) | 8388611;
            z4Var.f1154b = 2;
            toolbar.f699p.setLayoutParams(z4Var);
            toolbar.addView(toolbar.f699p);
        }
        int childCount = toolbar.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            View childAt = toolbar.getChildAt(childCount);
            if (!(((z4) childAt.getLayoutParams()).f1154b == 2 || childAt == toolbar.f691h)) {
                toolbar.removeViewAt(childCount);
                toolbar.L.add(childAt);
            }
        }
        toolbar.requestLayout();
        qVar.C = true;
        qVar.f10012n.p(false);
        View view = toolbar.f699p;
        if (view instanceof d) {
            ((d) view).a();
        }
        toolbar.s();
        return true;
    }

    public final int getId() {
        return 0;
    }

    public final void h(Context context, o oVar) {
        q qVar;
        o oVar2 = this.f1133h;
        if (!(oVar2 == null || (qVar = this.f1134i) == null)) {
            oVar2.d(qVar);
        }
        this.f1133h = oVar;
    }

    public final boolean i() {
        return false;
    }

    public final Parcelable j() {
        return null;
    }

    public final boolean k(i0 i0Var) {
        return false;
    }

    public final boolean m(q qVar) {
        Toolbar toolbar = this.f1135j;
        View view = toolbar.f699p;
        if (view instanceof d) {
            ((d) view).e();
        }
        toolbar.removeView(toolbar.f699p);
        toolbar.removeView(toolbar.f698o);
        toolbar.f699p = null;
        ArrayList arrayList = toolbar.L;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                toolbar.addView((View) arrayList.get(size));
            } else {
                arrayList.clear();
                this.f1134i = null;
                toolbar.requestLayout();
                qVar.C = false;
                qVar.f10012n.p(false);
                toolbar.s();
                return true;
            }
        }
    }
}
