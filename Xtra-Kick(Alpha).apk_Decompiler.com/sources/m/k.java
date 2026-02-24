package m;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import g.i;
import g.l;
import g.m;

public final class k implements c0, AdapterView.OnItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public Context f9959h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f9960i;

    /* renamed from: j  reason: collision with root package name */
    public o f9961j;

    /* renamed from: k  reason: collision with root package name */
    public ExpandedMenuView f9962k;

    /* renamed from: l  reason: collision with root package name */
    public b0 f9963l;

    /* renamed from: m  reason: collision with root package name */
    public j f9964m;

    public k(Context context) {
        this.f9959h = context;
        this.f9960i = LayoutInflater.from(context);
    }

    public final void a(o oVar, boolean z10) {
        b0 b0Var = this.f9963l;
        if (b0Var != null) {
            b0Var.a(oVar, z10);
        }
    }

    public final void c(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f9962k.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public final void e(boolean z10) {
        j jVar = this.f9964m;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    public final boolean g(q qVar) {
        return false;
    }

    public final int getId() {
        return 0;
    }

    public final void h(Context context, o oVar) {
        if (this.f9959h != null) {
            this.f9959h = context;
            if (this.f9960i == null) {
                this.f9960i = LayoutInflater.from(context);
            }
        }
        this.f9961j = oVar;
        j jVar = this.f9964m;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    public final boolean i() {
        return false;
    }

    public final Parcelable j() {
        if (this.f9962k == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f9962k;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final boolean k(i0 i0Var) {
        if (!i0Var.hasVisibleItems()) {
            return false;
        }
        p pVar = new p(i0Var);
        Context context = i0Var.f9972a;
        l lVar = new l(context);
        k kVar = new k(lVar.getContext());
        pVar.f9998j = kVar;
        kVar.f9963l = pVar;
        i0Var.b(kVar, context);
        k kVar2 = pVar.f9998j;
        if (kVar2.f9964m == null) {
            kVar2.f9964m = new j(kVar2);
        }
        j jVar = kVar2.f9964m;
        i iVar = lVar.f6176a;
        iVar.f6096p = jVar;
        iVar.f6097q = pVar;
        View view = i0Var.f9986o;
        if (view != null) {
            iVar.f6085e = view;
        } else {
            iVar.f6083c = i0Var.f9985n;
            lVar.setTitle(i0Var.f9984m);
        }
        iVar.f6094n = pVar;
        m create = lVar.create();
        pVar.f9997i = create;
        create.setOnDismissListener(pVar);
        WindowManager.LayoutParams attributes = pVar.f9997i.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        pVar.f9997i.show();
        b0 b0Var = this.f9963l;
        if (b0Var == null) {
            return true;
        }
        b0Var.n(i0Var);
        return true;
    }

    public final void l(b0 b0Var) {
        this.f9963l = b0Var;
    }

    public final boolean m(q qVar) {
        return false;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        this.f9961j.q(this.f9964m.getItem(i10), this, 0);
    }
}
