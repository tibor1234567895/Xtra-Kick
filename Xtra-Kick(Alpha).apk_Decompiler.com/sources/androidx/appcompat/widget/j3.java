package androidx.appcompat.widget;

import a6.c;
import a6.n;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.andreyasadchy.xtra.ui.view.CustomSwipeRefreshLayout;
import com.github.andreyasadchy.xtra.ui.view.GridRecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tonyodev.fetch2.database.DownloadDatabase;
import com.woxthebox.draglistview.R;
import d9.p0;
import d9.r0;
import d9.s0;
import d9.t0;
import d9.w1;
import e.a;
import g1.k1;
import g1.r1;
import g1.u1;
import h3.b;
import h3.b0;
import h3.c0;
import h3.l4;
import h3.p4;
import h3.w;
import h3.x;
import h3.z;
import j1.l0;
import l.l;
import m.a0;
import m.o;
import m.y;

public final class j3 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f894a;

    /* renamed from: b  reason: collision with root package name */
    public Object f895b;

    /* renamed from: c  reason: collision with root package name */
    public Object f896c;

    /* renamed from: d  reason: collision with root package name */
    public Object f897d;

    /* renamed from: e  reason: collision with root package name */
    public Object f898e;

    /* renamed from: f  reason: collision with root package name */
    public Object f899f;

    public j3(Context context, View view) {
        this.f894a = context;
        this.f896c = view;
        o oVar = new o(context);
        this.f895b = oVar;
        oVar.u(new a(7, (Object) this));
        a0 a0Var = new a0(R.attr.popupMenuStyle, 0, context, view, (o) this.f895b, false);
        this.f897d = a0Var;
        a0Var.f9896g = 0;
        a0Var.f9900k = new y(1, this);
    }

    public static j3 b(View view) {
        int i10 = R.id.nothingHere;
        TextView textView = (TextView) e4.a.a(view, R.id.nothingHere);
        if (textView != null) {
            i10 = R.id.progressBar;
            ProgressBar progressBar = (ProgressBar) e4.a.a(view, R.id.progressBar);
            if (progressBar != null) {
                i10 = R.id.recyclerView;
                GridRecyclerView gridRecyclerView = (GridRecyclerView) e4.a.a(view, R.id.recyclerView);
                if (gridRecyclerView != null) {
                    i10 = R.id.scrollTop;
                    FloatingActionButton floatingActionButton = (FloatingActionButton) e4.a.a(view, R.id.scrollTop);
                    if (floatingActionButton != null) {
                        i10 = R.id.swipeRefresh;
                        CustomSwipeRefreshLayout customSwipeRefreshLayout = (CustomSwipeRefreshLayout) e4.a.a(view, R.id.swipeRefresh);
                        if (customSwipeRefreshLayout != null) {
                            return new j3((ConstraintLayout) view, textView, progressBar, gridRecyclerView, floatingActionButton, customSwipeRefreshLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static v1.a0 d(k1 k1Var, r0 r0Var, v1.a0 a0Var, r1 r1Var) {
        Object obj;
        int i10;
        u1 j02 = k1Var.j0();
        int K = k1Var.K();
        if (j02.y()) {
            obj = null;
        } else {
            obj = j02.u(K);
        }
        if (k1Var.o() || j02.y()) {
            i10 = -1;
        } else {
            i10 = j02.o(K, r1Var, false).j(l0.H(k1Var.j()) - r1Var.f6546l);
        }
        for (int i11 = 0; i11 < r0Var.size(); i11++) {
            v1.a0 a0Var2 = (v1.a0) r0Var.get(i11);
            if (g(a0Var2, obj, k1Var.o(), k1Var.T(), k1Var.Z(), i10)) {
                return a0Var2;
            }
        }
        if (r0Var.isEmpty() && a0Var != null) {
            if (g(a0Var, obj, k1Var.o(), k1Var.T(), k1Var.Z(), i10)) {
                return a0Var;
            }
        }
        return null;
    }

    public static j3 e(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return b(layoutInflater.inflate(R.layout.common_recycler_view_layout, viewGroup, false));
    }

    public static boolean g(v1.a0 a0Var, Object obj, boolean z10, int i10, int i11, int i12) {
        if (!a0Var.f6678a.equals(obj)) {
            return false;
        }
        int i13 = a0Var.f6679b;
        return (z10 && i13 == i10 && a0Var.f6680c == i11) || (!z10 && i13 == -1 && a0Var.f6682e == i12);
    }

    public final void a(s0 s0Var, v1.a0 a0Var, u1 u1Var) {
        if (a0Var != null) {
            if (u1Var.k(a0Var.f6678a) != -1 || (u1Var = (u1) ((t0) this.f896c).get(a0Var)) != null) {
                s0Var.b(a0Var, u1Var);
            }
        }
    }

    public final c0 c() {
        c0 c0Var = new c0((Looper) this.f898e);
        if (((l4) this.f895b).f7191h.b() && ((h3.a) this.f899f) == null) {
            this.f899f = new b(new p4());
        }
        l0.L(new Handler((Looper) this.f898e), new w(c0Var, new b0((Context) this.f894a, (l4) this.f895b, (Bundle) this.f896c, (z) this.f897d, (Looper) this.f898e, c0Var, (h3.a) this.f899f), 0));
        return c0Var;
    }

    public final void f(int i10) {
        new l((Context) this.f894a).inflate(i10, (o) this.f895b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f897d
            m.a0 r0 = (m.a0) r0
            boolean r1 = r0.b()
            if (r1 == 0) goto L_0x000b
            goto L_0x0014
        L_0x000b:
            android.view.View r1 = r0.f9895f
            r2 = 0
            if (r1 != 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            r0.d(r2, r2, r2, r2)
        L_0x0014:
            r2 = 1
        L_0x0015:
            if (r2 == 0) goto L_0x0018
            return
        L_0x0018:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "MenuPopupHelper cannot be used without an anchor"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j3.h():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        if (((d9.r0) r3.f895b).contains((v1.a0) r3.f897d) == false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
        if (c9.n.a((v1.a0) r3.f897d, (v1.a0) r3.f899f) == false) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(g1.u1 r4) {
        /*
            r3 = this;
            d9.s0 r0 = new d9.s0
            r0.<init>()
            java.lang.Object r1 = r3.f895b
            d9.r0 r1 = (d9.r0) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r3.f898e
            v1.a0 r1 = (v1.a0) r1
            r3.a(r0, r1, r4)
            java.lang.Object r1 = r3.f899f
            v1.a0 r1 = (v1.a0) r1
            java.lang.Object r2 = r3.f898e
            v1.a0 r2 = (v1.a0) r2
            boolean r1 = c9.n.a(r1, r2)
            if (r1 != 0) goto L_0x002b
            java.lang.Object r1 = r3.f899f
            v1.a0 r1 = (v1.a0) r1
            r3.a(r0, r1, r4)
        L_0x002b:
            java.lang.Object r1 = r3.f897d
            v1.a0 r1 = (v1.a0) r1
            java.lang.Object r2 = r3.f898e
            v1.a0 r2 = (v1.a0) r2
            boolean r1 = c9.n.a(r1, r2)
            if (r1 != 0) goto L_0x0078
            java.lang.Object r1 = r3.f897d
            v1.a0 r1 = (v1.a0) r1
            java.lang.Object r2 = r3.f899f
            v1.a0 r2 = (v1.a0) r2
            boolean r1 = c9.n.a(r1, r2)
            if (r1 != 0) goto L_0x0078
            goto L_0x0071
        L_0x0048:
            r1 = 0
        L_0x0049:
            java.lang.Object r2 = r3.f895b
            d9.r0 r2 = (d9.r0) r2
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0063
            java.lang.Object r2 = r3.f895b
            d9.r0 r2 = (d9.r0) r2
            java.lang.Object r2 = r2.get(r1)
            v1.a0 r2 = (v1.a0) r2
            r3.a(r0, r2, r4)
            int r1 = r1 + 1
            goto L_0x0049
        L_0x0063:
            java.lang.Object r1 = r3.f895b
            d9.r0 r1 = (d9.r0) r1
            java.lang.Object r2 = r3.f897d
            v1.a0 r2 = (v1.a0) r2
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x0078
        L_0x0071:
            java.lang.Object r1 = r3.f897d
            v1.a0 r1 = (v1.a0) r1
            r3.a(r0, r1, r4)
        L_0x0078:
            d9.t0 r4 = r0.a()
            r3.f896c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j3.i(g1.u1):void");
    }

    public j3(ContextWrapper contextWrapper, l4 l4Var) {
        contextWrapper.getClass();
        this.f894a = contextWrapper;
        l4Var.getClass();
        this.f895b = l4Var;
        this.f896c = Bundle.EMPTY;
        this.f897d = new x();
        Looper myLooper = Looper.myLooper();
        this.f898e = myLooper == null ? Looper.getMainLooper() : myLooper;
    }

    public /* synthetic */ j3(ViewGroup viewGroup, View view, View view2, Object obj, View view3, View view4) {
        this.f894a = viewGroup;
        this.f895b = view;
        this.f896c = view2;
        this.f897d = obj;
        this.f898e = view3;
        this.f899f = view4;
    }

    public j3(DownloadDatabase downloadDatabase) {
        this.f896c = new q9.a();
        this.f894a = downloadDatabase;
        this.f895b = new c(this, downloadDatabase, 10);
        this.f897d = new q9.b(this, downloadDatabase, 0);
        this.f898e = new q9.b(this, downloadDatabase, 1);
        this.f899f = new n(this, downloadDatabase, 2);
    }

    public j3(r1 r1Var) {
        this.f894a = r1Var;
        p0 p0Var = r0.f4657i;
        this.f895b = d9.r1.f4658l;
        this.f896c = w1.f4691n;
    }
}
