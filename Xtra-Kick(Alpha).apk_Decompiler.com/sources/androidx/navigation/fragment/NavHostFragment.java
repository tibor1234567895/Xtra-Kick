package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.a;
import androidx.fragment.app.c0;
import androidx.lifecycle.p1;
import com.woxthebox.draglistview.R;
import j3.j1;
import j3.k2;
import j3.t2;
import l3.n;
import la.f;
import la.o;
import la.v;
import xa.j;

public class NavHostFragment extends c0 {

    /* renamed from: h0  reason: collision with root package name */
    public static final n f1870h0 = new n(0);

    /* renamed from: d0  reason: collision with root package name */
    public final o f1871d0 = f.b(new p1(2, this));

    /* renamed from: e0  reason: collision with root package name */
    public View f1872e0;

    /* renamed from: f0  reason: collision with root package name */
    public int f1873f0;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f1874g0;

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        if (this.f1874g0) {
            a aVar = new a(x());
            aVar.m(this);
            aVar.g();
        }
    }

    public final void N(Bundle bundle) {
        l0();
        if (bundle != null && bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
            this.f1874g0 = true;
            a aVar = new a(x());
            aVar.m(this);
            aVar.g();
        }
        super.N(bundle);
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        Context context = layoutInflater.getContext();
        j.e("inflater.context", context);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        int i10 = this.D;
        if (i10 == 0 || i10 == -1) {
            i10 = R.id.nav_host_fragment_container;
        }
        fragmentContainerView.setId(i10);
        return fragmentContainerView;
    }

    public final void Q() {
        this.K = true;
        View view = this.f1872e0;
        if (view != null && k2.a(view) == l0()) {
            view.setTag(R.id.nav_controller_view_tag, (Object) null);
        }
        this.f1872e0 = null;
    }

    public final void T(Context context, AttributeSet attributeSet, Bundle bundle) {
        j.f("context", context);
        j.f("attrs", attributeSet);
        super.T(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t2.f8686b);
        j.e("context.obtainStyledAttr…yleable.NavHost\n        )", obtainStyledAttributes);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f1873f0 = resourceId;
        }
        v vVar = v.f9814a;
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, l3.o.f9562c);
        j.e("context.obtainStyledAttr…tyleable.NavHostFragment)", obtainStyledAttributes2);
        if (obtainStyledAttributes2.getBoolean(0, false)) {
            this.f1874g0 = true;
        }
        obtainStyledAttributes2.recycle();
    }

    public final void W(Bundle bundle) {
        if (this.f1874g0) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        if (view instanceof ViewGroup) {
            j1 l02 = l0();
            k2 k2Var = k2.f8602a;
            view.setTag(R.id.nav_controller_view_tag, l02);
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                j.d("null cannot be cast to non-null type android.view.View", parent);
                View view2 = (View) parent;
                this.f1872e0 = view2;
                if (view2.getId() == this.D) {
                    View view3 = this.f1872e0;
                    j.c(view3);
                    view3.setTag(R.id.nav_controller_view_tag, l0());
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
    }

    public final j1 l0() {
        return (j1) this.f1871d0.getValue();
    }
}
