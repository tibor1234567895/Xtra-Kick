package androidx.fragment.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.a2;
import androidx.lifecycle.b2;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0;
import androidx.lifecycle.g2;
import androidx.lifecycle.h2;
import androidx.lifecycle.m;
import androidx.lifecycle.o0;
import androidx.lifecycle.o1;
import androidx.lifecycle.s;
import androidx.lifecycle.s1;
import androidx.lifecycle.t;
import com.woxthebox.draglistview.R;
import hb.h0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import o3.z;
import t3.e;
import t3.g;
import t3.h;
import xa.j;
import z0.a;
import z0.c;
import z0.d;
import z0.f;

public class c0 implements ComponentCallbacks, View.OnCreateContextMenuListener, d0, h2, m, h {

    /* renamed from: c0  reason: collision with root package name */
    public static final Object f1349c0 = new Object();
    public e0 A;
    public d1 B = new d1();
    public c0 C;
    public int D;
    public int E;
    public String F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J = true;
    public boolean K;
    public ViewGroup L;
    public View M;
    public boolean N;
    public boolean O = true;
    public x P;
    public boolean Q;
    public LayoutInflater R;
    public boolean S;
    public String T;
    public s U;
    public g0 V;
    public y1 W;
    public final o0 X;
    public s1 Y;
    public g Z;

    /* renamed from: a0  reason: collision with root package name */
    public final ArrayList f1350a0;

    /* renamed from: b0  reason: collision with root package name */
    public final v f1351b0;

    /* renamed from: h  reason: collision with root package name */
    public int f1352h = -1;

    /* renamed from: i  reason: collision with root package name */
    public Bundle f1353i;

    /* renamed from: j  reason: collision with root package name */
    public SparseArray f1354j;

    /* renamed from: k  reason: collision with root package name */
    public Bundle f1355k;

    /* renamed from: l  reason: collision with root package name */
    public String f1356l = UUID.randomUUID().toString();

    /* renamed from: m  reason: collision with root package name */
    public Bundle f1357m;

    /* renamed from: n  reason: collision with root package name */
    public c0 f1358n;

    /* renamed from: o  reason: collision with root package name */
    public String f1359o = null;

    /* renamed from: p  reason: collision with root package name */
    public int f1360p;

    /* renamed from: q  reason: collision with root package name */
    public Boolean f1361q = null;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1362r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1363s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1364t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1365u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1366v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f1367w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1368x;

    /* renamed from: y  reason: collision with root package name */
    public int f1369y;

    /* renamed from: z  reason: collision with root package name */
    public c1 f1370z;

    public c0() {
        new u(0, this);
        this.U = s.RESUMED;
        this.X = new o0();
        new AtomicInteger();
        this.f1350a0 = new ArrayList();
        this.f1351b0 = new v(this);
        D();
    }

    public final String A(int i10, Object... objArr) {
        return y().getString(i10, objArr);
    }

    public final c0 B(boolean z10) {
        String str;
        if (z10) {
            d dVar = d.f17359a;
            f fVar = new f(this);
            d.f17359a.getClass();
            d.c(fVar);
            c a10 = d.a(this);
            if (a10.f17357a.contains(a.DETECT_TARGET_FRAGMENT_USAGE) && d.e(a10, getClass(), f.class)) {
                d.b(a10, fVar);
            }
        }
        c0 c0Var = this.f1358n;
        if (c0Var != null) {
            return c0Var;
        }
        c1 c1Var = this.f1370z;
        if (c1Var == null || (str = this.f1359o) == null) {
            return null;
        }
        return c1Var.B(str);
    }

    public final y1 C() {
        y1 y1Var = this.W;
        if (y1Var != null) {
            return y1Var;
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
    }

    public final void D() {
        this.V = new g0(this);
        g.f14538d.getClass();
        this.Z = new g(this);
        this.Y = null;
        ArrayList arrayList = this.f1350a0;
        v vVar = this.f1351b0;
        if (arrayList.contains(vVar)) {
            return;
        }
        if (this.f1352h >= 0) {
            vVar.a();
        } else {
            arrayList.add(vVar);
        }
    }

    public final void E() {
        D();
        this.T = this.f1356l;
        this.f1356l = UUID.randomUUID().toString();
        this.f1362r = false;
        this.f1363s = false;
        this.f1365u = false;
        this.f1366v = false;
        this.f1367w = false;
        this.f1369y = 0;
        this.f1370z = null;
        this.B = new d1();
        this.A = null;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = false;
        this.H = false;
    }

    public final boolean F() {
        return this.A != null && this.f1362r;
    }

    public final boolean G() {
        boolean z10;
        if (!this.G) {
            c1 c1Var = this.f1370z;
            if (c1Var == null) {
                return false;
            }
            c0 c0Var = this.C;
            c1Var.getClass();
            if (c0Var == null) {
                z10 = false;
            } else {
                z10 = c0Var.G();
            }
            if (z10) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean H() {
        return this.f1369y > 0;
    }

    public final boolean I() {
        return this.f1352h >= 7;
    }

    public void J() {
        this.K = true;
    }

    public void K(int i10, int i11, Intent intent) {
        if (c1.I(2)) {
            toString();
            Objects.toString(intent);
        }
    }

    public void L(Activity activity) {
        this.K = true;
    }

    public void M(Context context) {
        this.K = true;
        e0 e0Var = this.A;
        Activity activity = e0Var == null ? null : e0Var.f1402h;
        if (activity != null) {
            this.K = false;
            L(activity);
        }
    }

    public void N(Bundle bundle) {
        boolean z10;
        Bundle bundle2;
        this.K = true;
        Bundle bundle3 = this.f1353i;
        if (!(bundle3 == null || (bundle2 = bundle3.getBundle("childFragmentManager")) == null)) {
            this.B.V(bundle2);
            d1 d1Var = this.B;
            d1Var.G = false;
            d1Var.H = false;
            d1Var.N.f1452i = false;
            d1Var.t(1);
        }
        d1 d1Var2 = this.B;
        if (d1Var2.f1391u >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            d1Var2.G = false;
            d1Var2.H = false;
            d1Var2.N.f1452i = false;
            d1Var2.t(1);
        }
    }

    public View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void P() {
        this.K = true;
    }

    public void Q() {
        this.K = true;
    }

    public void R() {
        this.K = true;
    }

    public LayoutInflater S(Bundle bundle) {
        e0 e0Var = this.A;
        if (e0Var != null) {
            f0 f0Var = e0Var.f1406l;
            LayoutInflater cloneInContext = f0Var.getLayoutInflater().cloneInContext(f0Var);
            cloneInContext.setFactory2(this.B.f1376f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void T(Context context, AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        this.K = true;
        e0 e0Var = this.A;
        if (e0Var == null) {
            activity = null;
        } else {
            activity = e0Var.f1402h;
        }
        if (activity != null) {
            this.K = true;
        }
    }

    public void U(boolean z10) {
    }

    public void V() {
        this.K = true;
    }

    public void W(Bundle bundle) {
    }

    public void X() {
        this.K = true;
    }

    public void Y() {
        this.K = true;
    }

    public void Z(View view, Bundle bundle) {
    }

    public final e a() {
        return this.Z.f14540b;
    }

    public void a0(Bundle bundle) {
        this.K = true;
    }

    public void b0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.B.P();
        boolean z10 = true;
        this.f1368x = true;
        this.W = new y1(this, m(), new androidx.activity.e(6, this));
        View O2 = O(layoutInflater, viewGroup);
        this.M = O2;
        if (O2 != null) {
            this.W.c();
            if (c1.I(3)) {
                Objects.toString(this.M);
                toString();
            }
            h0.B1(this.M, this.W);
            View view = this.M;
            y1 y1Var = this.W;
            j.f("<this>", view);
            view.setTag(R.id.view_tree_view_model_store_owner, y1Var);
            View view2 = this.M;
            y1 y1Var2 = this.W;
            j.f("<this>", view2);
            view2.setTag(R.id.view_tree_saved_state_registry_owner, y1Var2);
            this.X.l(this.W);
            return;
        }
        if (this.W.f1619l == null) {
            z10 = false;
        }
        if (!z10) {
            this.W = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public final LayoutInflater c0(Bundle bundle) {
        LayoutInflater S2 = S(bundle);
        this.R = S2;
        return S2;
    }

    public final f0 d0() {
        f0 t10 = t();
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle e0() {
        Bundle bundle = this.f1357m;
        if (bundle != null) {
            return bundle;
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", this, " does not have any arguments."));
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final Context f0() {
        Context v10 = v();
        if (v10 != null) {
            return v10;
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", this, " not attached to a context."));
    }

    public final c0 g0() {
        c0 c0Var = this.C;
        if (c0Var != null) {
            return c0Var;
        }
        if (v() == null) {
            throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + v());
    }

    public b2 h() {
        Application application;
        if (this.f1370z != null) {
            if (this.Y == null) {
                Context applicationContext = f0().getApplicationContext();
                while (true) {
                    if (!(applicationContext instanceof ContextWrapper)) {
                        application = null;
                        break;
                    } else if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else {
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    }
                }
                if (application == null && c1.I(3)) {
                    Objects.toString(f0().getApplicationContext());
                }
                this.Y = new s1(application, this, this.f1357m);
            }
            return this.Y;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final View h0() {
        View view = this.M;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final b1.f i() {
        Application application;
        Context applicationContext = f0().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        if (application == null && c1.I(3)) {
            Objects.toString(f0().getApplicationContext());
        }
        b1.f fVar = new b1.f();
        if (application != null) {
            fVar.b(a2.f1653g, application);
        }
        fVar.b(o1.f1735a, this);
        fVar.b(o1.f1736b, this);
        Bundle bundle = this.f1357m;
        if (bundle != null) {
            fVar.b(o1.f1737c, bundle);
        }
        return fVar;
    }

    public final void i0(int i10, int i11, int i12, int i13) {
        if (this.P != null || i10 != 0 || i11 != 0 || i12 != 0 || i13 != 0) {
            s().f1598b = i10;
            s().f1599c = i11;
            s().f1600d = i12;
            s().f1601e = i13;
        }
    }

    public final void j0(Bundle bundle) {
        boolean z10;
        c1 c1Var = this.f1370z;
        if (c1Var != null) {
            if (c1Var == null) {
                z10 = false;
            } else {
                z10 = c1Var.N();
            }
            if (z10) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1357m = bundle;
    }

    public final void k0(z zVar) {
        d dVar = d.f17359a;
        z0.g gVar = new z0.g(this, zVar);
        d.f17359a.getClass();
        d.c(gVar);
        c a10 = d.a(this);
        if (a10.f17357a.contains(a.DETECT_TARGET_FRAGMENT_USAGE) && d.e(a10, getClass(), z0.g.class)) {
            d.b(a10, gVar);
        }
        c1 c1Var = this.f1370z;
        c1 c1Var2 = zVar.f1370z;
        if (c1Var == null || c1Var2 == null || c1Var == c1Var2) {
            c0 c0Var = zVar;
            while (c0Var != null) {
                if (!c0Var.equals(this)) {
                    c0Var = c0Var.B(false);
                } else {
                    throw new IllegalArgumentException("Setting " + zVar + " as the target of " + this + " would create a target cycle");
                }
            }
            if (this.f1370z == null || zVar.f1370z == null) {
                this.f1359o = null;
                this.f1358n = zVar;
            } else {
                this.f1359o = zVar.f1356l;
                this.f1358n = null;
            }
            this.f1360p = 0;
            return;
        }
        throw new IllegalArgumentException("Fragment " + zVar + " must share the same FragmentManager to be set as a target fragment");
    }

    public final g2 m() {
        if (this.f1370z == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (w() != 1) {
            HashMap hashMap = this.f1370z.N.f1449f;
            g2 g2Var = (g2) hashMap.get(this.f1356l);
            if (g2Var != null) {
                return g2Var;
            }
            g2 g2Var2 = new g2();
            hashMap.put(this.f1356l, g2Var2);
            return g2Var2;
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    public final t o() {
        return this.V;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.K = true;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        d0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public final void onLowMemory() {
        this.K = true;
    }

    public h0 r() {
        return new w(this);
    }

    public final x s() {
        if (this.P == null) {
            this.P = new x();
        }
        return this.P;
    }

    public final f0 t() {
        e0 e0Var = this.A;
        if (e0Var == null) {
            return null;
        }
        return (f0) e0Var.f1402h;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} (");
        sb2.append(this.f1356l);
        if (this.D != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.D));
        }
        if (this.F != null) {
            sb2.append(" tag=");
            sb2.append(this.F);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public final c1 u() {
        if (this.A != null) {
            return this.B;
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", this, " has not been attached yet."));
    }

    public Context v() {
        e0 e0Var = this.A;
        if (e0Var == null) {
            return null;
        }
        return e0Var.f1403i;
    }

    public final int w() {
        s sVar = this.U;
        return (sVar == s.INITIALIZED || this.C == null) ? sVar.ordinal() : Math.min(sVar.ordinal(), this.C.w());
    }

    public final c1 x() {
        c1 c1Var = this.f1370z;
        if (c1Var != null) {
            return c1Var;
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", this, " not associated with a fragment manager."));
    }

    public final Resources y() {
        return f0().getResources();
    }

    public final String z(int i10) {
        return y().getString(i10);
    }
}
