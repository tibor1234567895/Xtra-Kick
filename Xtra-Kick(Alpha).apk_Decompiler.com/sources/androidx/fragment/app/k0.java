package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;
import m0.c1;
import m0.m0;

public final class k0 implements View.OnAttachStateChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1471h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m1 f1472i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1473j;

    public k0(l0 l0Var, m1 m1Var) {
        this.f1473j = l0Var;
        this.f1472i = m1Var;
    }

    public final void onViewAttachedToWindow(View view) {
        int i10 = this.f1471h;
        Object obj = this.f1473j;
        switch (i10) {
            case 0:
                m1 m1Var = this.f1472i;
                c0 c0Var = m1Var.f1502c;
                m1Var.k();
                n.h((ViewGroup) c0Var.M.getParent(), ((l0) obj).f1479h).g();
                return;
            default:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = c1.f10054a;
                m0.c(view2);
                return;
        }
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    public k0(m1 m1Var, View view) {
        this.f1472i = m1Var;
        this.f1473j = view;
    }
}
