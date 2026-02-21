package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.media.h;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.g0;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import m0.c1;
import m0.l0;
import m0.m0;
import q.l;
import z0.a;
import z0.c;
import z0.d;
import z0.e;
import z0.j;

public final class m1 {

    /* renamed from: a  reason: collision with root package name */
    public final n0 f1500a;

    /* renamed from: b  reason: collision with root package name */
    public final n1 f1501b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f1502c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1503d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f1504e = -1;

    public m1(n0 n0Var, n1 n1Var, c0 c0Var) {
        this.f1500a = n0Var;
        this.f1501b = n1Var;
        this.f1502c = c0Var;
    }

    public final void a() {
        Bundle bundle;
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        Bundle bundle2 = c0Var.f1353i;
        if (bundle2 != null) {
            bundle2.getBundle("savedInstanceState");
        }
        c0Var.B.P();
        c0Var.f1352h = 3;
        c0Var.K = false;
        c0Var.J();
        if (c0Var.K) {
            if (c1.I(3)) {
                c0Var.toString();
            }
            if (c0Var.M != null) {
                Bundle bundle3 = c0Var.f1353i;
                if (bundle3 != null) {
                    bundle = bundle3.getBundle("savedInstanceState");
                } else {
                    bundle = null;
                }
                SparseArray sparseArray = c0Var.f1354j;
                if (sparseArray != null) {
                    c0Var.M.restoreHierarchyState(sparseArray);
                    c0Var.f1354j = null;
                }
                c0Var.K = false;
                c0Var.a0(bundle);
                if (!c0Var.K) {
                    throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onViewStateRestored()"));
                } else if (c0Var.M != null) {
                    c0Var.W.b(r.ON_CREATE);
                }
            }
            c0Var.f1353i = null;
            d1 d1Var = c0Var.B;
            d1Var.G = false;
            d1Var.H = false;
            d1Var.N.f1452i = false;
            d1Var.t(4);
            this.f1500a.a(false);
            return;
        }
        throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onActivityCreated()"));
    }

    public final void b() {
        c0 c0Var;
        int i10;
        View view;
        View view2;
        c0 c0Var2;
        c0 c0Var3 = this.f1502c;
        View view3 = c0Var3.L;
        while (true) {
            c0Var = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(R.id.fragment_container_view_tag);
            if (tag instanceof c0) {
                c0Var2 = (c0) tag;
            } else {
                c0Var2 = null;
            }
            if (c0Var2 != null) {
                c0Var = c0Var2;
                break;
            }
            ViewParent parent = view3.getParent();
            if (parent instanceof View) {
                view3 = (View) parent;
            } else {
                view3 = null;
            }
        }
        c0 c0Var4 = c0Var3.C;
        if (c0Var != null && !c0Var.equals(c0Var4)) {
            int i11 = c0Var3.E;
            d dVar = d.f17359a;
            j jVar = new j(c0Var3, c0Var, i11);
            d.f17359a.getClass();
            d.c(jVar);
            c a10 = d.a(c0Var3);
            if (a10.f17357a.contains(a.DETECT_WRONG_NESTED_HIERARCHY) && d.e(a10, c0Var3.getClass(), j.class)) {
                d.b(a10, jVar);
            }
        }
        n1 n1Var = this.f1501b;
        n1Var.getClass();
        ViewGroup viewGroup = c0Var3.L;
        if (viewGroup != null) {
            ArrayList arrayList = n1Var.f1513a;
            int indexOf = arrayList.indexOf(c0Var3);
            int i12 = indexOf - 1;
            while (true) {
                if (i12 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        c0 c0Var5 = (c0) arrayList.get(indexOf);
                        if (c0Var5.L == viewGroup && (view = c0Var5.M) != null) {
                            i10 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    c0 c0Var6 = (c0) arrayList.get(i12);
                    if (c0Var6.L == viewGroup && (view2 = c0Var6.M) != null) {
                        i10 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i12--;
                }
            }
            c0Var3.L.addView(c0Var3.M, i10);
        }
        i10 = -1;
        c0Var3.L.addView(c0Var3.M, i10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.fragment.app.m1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r7 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.c1.I(r0)
            androidx.fragment.app.c0 r1 = r7.f1502c
            if (r0 == 0) goto L_0x000c
            java.util.Objects.toString(r1)
        L_0x000c:
            androidx.fragment.app.c0 r0 = r1.f1358n
            java.lang.String r2 = " that does not belong to this FragmentManager!"
            java.lang.String r3 = " declared target fragment "
            r4 = 0
            androidx.fragment.app.n1 r5 = r7.f1501b
            java.lang.String r6 = "Fragment "
            if (r0 == 0) goto L_0x004c
            java.lang.String r0 = r0.f1356l
            java.util.HashMap r5 = r5.f1514b
            java.lang.Object r0 = r5.get(r0)
            androidx.fragment.app.m1 r0 = (androidx.fragment.app.m1) r0
            if (r0 == 0) goto L_0x002f
            androidx.fragment.app.c0 r2 = r1.f1358n
            java.lang.String r2 = r2.f1356l
            r1.f1359o = r2
            r1.f1358n = r4
            r4 = r0
            goto L_0x0073
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r6)
            r4.append(r1)
            r4.append(r3)
            androidx.fragment.app.c0 r1 = r1.f1358n
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x004c:
            java.lang.String r0 = r1.f1359o
            if (r0 == 0) goto L_0x0073
            java.util.HashMap r4 = r5.f1514b
            java.lang.Object r0 = r4.get(r0)
            r4 = r0
            androidx.fragment.app.m1 r4 = (androidx.fragment.app.m1) r4
            if (r4 == 0) goto L_0x005c
            goto L_0x0073
        L_0x005c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r6)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r1.f1359o
            java.lang.String r1 = android.support.v4.media.h.p(r4, r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x0073:
            if (r4 == 0) goto L_0x0078
            r4.k()
        L_0x0078:
            androidx.fragment.app.c1 r0 = r1.f1370z
            androidx.fragment.app.e0 r2 = r0.f1392v
            r1.A = r2
            androidx.fragment.app.c0 r0 = r0.f1394x
            r1.C = r0
            androidx.fragment.app.n0 r0 = r7.f1500a
            r2 = 0
            r0.g(r2)
            java.util.ArrayList r3 = r1.f1350a0
            java.util.Iterator r4 = r3.iterator()
        L_0x008e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x009e
            java.lang.Object r5 = r4.next()
            androidx.fragment.app.z r5 = (androidx.fragment.app.z) r5
            r5.a()
            goto L_0x008e
        L_0x009e:
            r3.clear()
            androidx.fragment.app.d1 r3 = r1.B
            androidx.fragment.app.e0 r4 = r1.A
            androidx.fragment.app.h0 r5 = r1.r()
            r3.b(r4, r5, r1)
            r1.f1352h = r2
            r1.K = r2
            androidx.fragment.app.e0 r3 = r1.A
            android.content.Context r3 = r3.f1403i
            r1.M(r3)
            boolean r3 = r1.K
            if (r3 == 0) goto L_0x00e4
            androidx.fragment.app.c1 r3 = r1.f1370z
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.f1385o
            java.util.Iterator r4 = r4.iterator()
        L_0x00c3:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d3
            java.lang.Object r5 = r4.next()
            androidx.fragment.app.i1 r5 = (androidx.fragment.app.i1) r5
            r5.b(r3, r1)
            goto L_0x00c3
        L_0x00d3:
            androidx.fragment.app.d1 r1 = r1.B
            r1.G = r2
            r1.H = r2
            androidx.fragment.app.h1 r3 = r1.N
            r3.f1452i = r2
            r1.t(r2)
            r0.b(r2)
            return
        L_0x00e4:
            androidx.fragment.app.j2 r0 = new androidx.fragment.app.j2
            java.lang.String r2 = " did not call through to super.onAttach()"
            java.lang.String r1 = android.support.v4.media.h.l(r6, r1, r2)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m1.c():void");
    }

    public final int d() {
        e2 e2Var;
        Object obj;
        int i10;
        boolean z10;
        c0 c0Var = this.f1502c;
        if (c0Var.f1370z == null) {
            return c0Var.f1352h;
        }
        int i11 = this.f1504e;
        int ordinal = c0Var.U.ordinal();
        if (ordinal == 1) {
            i11 = Math.min(i11, 0);
        } else if (ordinal == 2) {
            i11 = Math.min(i11, 1);
        } else if (ordinal == 3) {
            i11 = Math.min(i11, 5);
        } else if (ordinal != 4) {
            i11 = Math.min(i11, -1);
        }
        if (c0Var.f1365u) {
            if (c0Var.f1366v) {
                i11 = Math.max(this.f1504e, 2);
                View view = c0Var.M;
                if (view != null && view.getParent() == null) {
                    i11 = Math.min(i11, 2);
                }
            } else {
                i11 = this.f1504e < 4 ? Math.min(i11, c0Var.f1352h) : Math.min(i11, 1);
            }
        }
        if (!c0Var.f1362r) {
            i11 = Math.min(i11, 1);
        }
        ViewGroup viewGroup = c0Var.L;
        e2 e2Var2 = null;
        if (viewGroup != null) {
            n h10 = n.h(viewGroup, c0Var.x());
            h10.getClass();
            h2 f10 = h10.f(c0Var);
            if (f10 != null) {
                e2Var = f10.f1454b;
            } else {
                e2Var = null;
            }
            Iterator it = h10.f1508c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                h2 h2Var = (h2) obj;
                if (!xa.j.a(h2Var.f1455c, c0Var) || h2Var.f1458f) {
                    z10 = false;
                    continue;
                } else {
                    z10 = true;
                    continue;
                }
                if (z10) {
                    break;
                }
            }
            h2 h2Var2 = (h2) obj;
            if (h2Var2 != null) {
                e2Var2 = h2Var2.f1454b;
            }
            if (e2Var == null) {
                i10 = -1;
            } else {
                i10 = i2.f1464a[e2Var.ordinal()];
            }
            if (!(i10 == -1 || i10 == 1)) {
                e2Var2 = e2Var;
            }
        }
        if (e2Var2 == e2.ADDING) {
            i11 = Math.min(i11, 6);
        } else if (e2Var2 == e2.REMOVING) {
            i11 = Math.max(i11, 3);
        } else if (c0Var.f1363s) {
            if (c0Var.H()) {
                i11 = Math.min(i11, 1);
            } else {
                i11 = Math.min(i11, -1);
            }
        }
        if (c0Var.N && c0Var.f1352h < 5) {
            i11 = Math.min(i11, 4);
        }
        if (c1.I(2)) {
            Objects.toString(c0Var);
        }
        return i11;
    }

    public final void e() {
        Bundle bundle;
        Bundle bundle2;
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        Bundle bundle3 = c0Var.f1353i;
        if (bundle3 != null) {
            bundle = bundle3.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        if (!c0Var.S) {
            n0 n0Var = this.f1500a;
            n0Var.h(false);
            c0Var.B.P();
            c0Var.f1352h = 1;
            c0Var.K = false;
            c0Var.V.a(new Fragment$6(c0Var));
            c0Var.N(bundle);
            c0Var.S = true;
            if (c0Var.K) {
                c0Var.V.f(r.ON_CREATE);
                n0Var.c(c0Var, bundle, false);
                return;
            }
            throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onCreate()"));
        }
        c0Var.f1352h = 1;
        Bundle bundle4 = c0Var.f1353i;
        if (bundle4 != null && (bundle2 = bundle4.getBundle("childFragmentManager")) != null) {
            c0Var.B.V(bundle2);
            d1 d1Var = c0Var.B;
            d1Var.G = false;
            d1Var.H = false;
            d1Var.N.f1452i = false;
            d1Var.t(1);
        }
    }

    public final void f() {
        Bundle bundle;
        String str;
        c0 c0Var = this.f1502c;
        if (!c0Var.f1365u) {
            if (c1.I(3)) {
                Objects.toString(c0Var);
            }
            Bundle bundle2 = c0Var.f1353i;
            Bundle bundle3 = null;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            LayoutInflater c02 = c0Var.c0(bundle);
            ViewGroup viewGroup = c0Var.L;
            if (viewGroup == null) {
                int i10 = c0Var.E;
                if (i10 == 0) {
                    viewGroup = null;
                } else if (i10 != -1) {
                    viewGroup = (ViewGroup) c0Var.f1370z.f1393w.c(i10);
                    if (viewGroup == null) {
                        if (!c0Var.f1367w) {
                            try {
                                str = c0Var.y().getResourceName(c0Var.E);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(c0Var.E) + " (" + str + ") for fragment " + c0Var);
                        }
                    } else if (!(viewGroup instanceof FragmentContainerView)) {
                        d dVar = d.f17359a;
                        e eVar = new e(c0Var, viewGroup, 1);
                        d.f17359a.getClass();
                        d.c(eVar);
                        c a10 = d.a(c0Var);
                        if (a10.f17357a.contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && d.e(a10, c0Var.getClass(), e.class)) {
                            d.b(a10, eVar);
                        }
                    }
                } else {
                    throw new IllegalArgumentException(h.l("Cannot create fragment ", c0Var, " for a container view with no id"));
                }
            }
            c0Var.L = viewGroup;
            c0Var.b0(c02, viewGroup, bundle);
            if (c0Var.M != null) {
                if (c1.I(3)) {
                    Objects.toString(c0Var);
                }
                c0Var.M.setSaveFromParentEnabled(false);
                c0Var.M.setTag(R.id.fragment_container_view_tag, c0Var);
                if (viewGroup != null) {
                    b();
                }
                if (c0Var.G) {
                    c0Var.M.setVisibility(8);
                }
                View view = c0Var.M;
                WeakHashMap weakHashMap = c1.f10054a;
                if (l0.b(view)) {
                    m0.c(c0Var.M);
                } else {
                    View view2 = c0Var.M;
                    view2.addOnAttachStateChangeListener(new k0(this, view2));
                }
                Bundle bundle4 = c0Var.f1353i;
                if (bundle4 != null) {
                    bundle3 = bundle4.getBundle("savedInstanceState");
                }
                c0Var.Z(c0Var.M, bundle3);
                c0Var.B.t(2);
                this.f1500a.m(c0Var, c0Var.M, bundle, false);
                int visibility = c0Var.M.getVisibility();
                c0Var.s().f1608l = c0Var.M.getAlpha();
                if (c0Var.L != null && visibility == 0) {
                    View findFocus = c0Var.M.findFocus();
                    if (findFocus != null) {
                        c0Var.s().f1609m = findFocus;
                        if (c1.I(2)) {
                            findFocus.toString();
                            Objects.toString(c0Var);
                        }
                    }
                    c0Var.M.setAlpha(0.0f);
                }
            }
            c0Var.f1352h = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r10 = this;
            r0 = 3
            boolean r1 = androidx.fragment.app.c1.I(r0)
            androidx.fragment.app.c0 r2 = r10.f1502c
            if (r1 == 0) goto L_0x000c
            java.util.Objects.toString(r2)
        L_0x000c:
            boolean r1 = r2.f1363s
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x001a
            boolean r1 = r2.H()
            if (r1 != 0) goto L_0x001a
            r1 = 1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            r5 = 0
            androidx.fragment.app.n1 r6 = r10.f1501b
            if (r1 == 0) goto L_0x0029
            boolean r7 = r2.f1364t
            if (r7 != 0) goto L_0x0029
            java.lang.String r7 = r2.f1356l
            r6.i(r5, r7)
        L_0x0029:
            if (r1 != 0) goto L_0x0045
            androidx.fragment.app.h1 r7 = r6.f1516d
            java.util.HashMap r8 = r7.f1447d
            java.lang.String r9 = r2.f1356l
            boolean r8 = r8.containsKey(r9)
            if (r8 != 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            boolean r8 = r7.f1450g
            if (r8 == 0) goto L_0x003f
            boolean r7 = r7.f1451h
            goto L_0x0040
        L_0x003f:
            r7 = 1
        L_0x0040:
            if (r7 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r7 = 0
            goto L_0x0046
        L_0x0045:
            r7 = 1
        L_0x0046:
            if (r7 == 0) goto L_0x00dc
            androidx.fragment.app.e0 r7 = r2.A
            boolean r8 = r7 instanceof androidx.lifecycle.h2
            if (r8 == 0) goto L_0x0053
            androidx.fragment.app.h1 r4 = r6.f1516d
            boolean r4 = r4.f1451h
            goto L_0x0060
        L_0x0053:
            android.content.Context r7 = r7.f1403i
            boolean r8 = r7 instanceof android.app.Activity
            if (r8 == 0) goto L_0x0060
            android.app.Activity r7 = (android.app.Activity) r7
            boolean r7 = r7.isChangingConfigurations()
            r4 = r4 ^ r7
        L_0x0060:
            if (r1 == 0) goto L_0x0066
            boolean r1 = r2.f1364t
            if (r1 == 0) goto L_0x0068
        L_0x0066:
            if (r4 == 0) goto L_0x007b
        L_0x0068:
            androidx.fragment.app.h1 r1 = r6.f1516d
            r1.getClass()
            boolean r0 = androidx.fragment.app.c1.I(r0)
            if (r0 == 0) goto L_0x0076
            java.util.Objects.toString(r2)
        L_0x0076:
            java.lang.String r0 = r2.f1356l
            r1.d(r0)
        L_0x007b:
            androidx.fragment.app.d1 r0 = r2.B
            r0.k()
            androidx.lifecycle.g0 r0 = r2.V
            androidx.lifecycle.r r1 = androidx.lifecycle.r.ON_DESTROY
            r0.f(r1)
            r2.f1352h = r3
            r2.K = r3
            r2.S = r3
            r2.P()
            boolean r0 = r2.K
            if (r0 == 0) goto L_0x00ce
            androidx.fragment.app.n0 r0 = r10.f1500a
            r0.d(r2, r3)
            java.util.ArrayList r0 = r6.d()
            java.util.Iterator r0 = r0.iterator()
        L_0x00a1:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00c0
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.m1 r1 = (androidx.fragment.app.m1) r1
            if (r1 == 0) goto L_0x00a1
            java.lang.String r3 = r2.f1356l
            androidx.fragment.app.c0 r1 = r1.f1502c
            java.lang.String r4 = r1.f1359o
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00a1
            r1.f1358n = r2
            r1.f1359o = r5
            goto L_0x00a1
        L_0x00c0:
            java.lang.String r0 = r2.f1359o
            if (r0 == 0) goto L_0x00ca
            androidx.fragment.app.c0 r0 = r6.b(r0)
            r2.f1358n = r0
        L_0x00ca:
            r6.h(r10)
            goto L_0x00ee
        L_0x00ce:
            androidx.fragment.app.j2 r0 = new androidx.fragment.app.j2
            java.lang.String r1 = "Fragment "
            java.lang.String r3 = " did not call through to super.onDestroy()"
            java.lang.String r1 = android.support.v4.media.h.l(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x00dc:
            java.lang.String r0 = r2.f1359o
            if (r0 == 0) goto L_0x00ec
            androidx.fragment.app.c0 r0 = r6.b(r0)
            if (r0 == 0) goto L_0x00ec
            boolean r1 = r0.I
            if (r1 == 0) goto L_0x00ec
            r2.f1358n = r0
        L_0x00ec:
            r2.f1352h = r3
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m1.g():void");
    }

    public final void h() {
        View view;
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        ViewGroup viewGroup = c0Var.L;
        if (!(viewGroup == null || (view = c0Var.M) == null)) {
            viewGroup.removeView(view);
        }
        c0Var.B.t(1);
        if (c0Var.M != null) {
            y1 y1Var = c0Var.W;
            y1Var.c();
            if (y1Var.f1619l.f1688d.a(s.CREATED)) {
                c0Var.W.b(r.ON_DESTROY);
            }
        }
        c0Var.f1352h = 1;
        c0Var.K = false;
        c0Var.Q();
        if (c0Var.K) {
            l lVar = c1.a.a(c0Var).f2721b.f2719d;
            if (lVar.g() <= 0) {
                c0Var.f1368x = false;
                this.f1500a.n(false);
                c0Var.L = null;
                c0Var.M = null;
                c0Var.W = null;
                c0Var.X.l((Object) null);
                c0Var.f1366v = false;
                return;
            }
            h.y(lVar.h(0));
            throw null;
        }
        throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onDestroyView()"));
    }

    public final void i() {
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        c0Var.f1352h = -1;
        boolean z10 = false;
        c0Var.K = false;
        c0Var.R();
        c0Var.R = null;
        if (c0Var.K) {
            d1 d1Var = c0Var.B;
            if (!d1Var.I) {
                d1Var.k();
                c0Var.B = new d1();
            }
            this.f1500a.e(false);
            c0Var.f1352h = -1;
            c0Var.A = null;
            c0Var.C = null;
            c0Var.f1370z = null;
            boolean z11 = true;
            if (c0Var.f1363s && !c0Var.H()) {
                z10 = true;
            }
            if (!z10) {
                h1 h1Var = this.f1501b.f1516d;
                if (h1Var.f1447d.containsKey(c0Var.f1356l) && h1Var.f1450g) {
                    z11 = h1Var.f1451h;
                }
                if (!z11) {
                    return;
                }
            }
            if (c1.I(3)) {
                Objects.toString(c0Var);
            }
            c0Var.E();
            return;
        }
        throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onDetach()"));
    }

    public final void j() {
        Bundle bundle;
        c0 c0Var = this.f1502c;
        if (c0Var.f1365u && c0Var.f1366v && !c0Var.f1368x) {
            if (c1.I(3)) {
                Objects.toString(c0Var);
            }
            Bundle bundle2 = c0Var.f1353i;
            Bundle bundle3 = null;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            c0Var.b0(c0Var.c0(bundle), (ViewGroup) null, bundle);
            View view = c0Var.M;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                c0Var.M.setTag(R.id.fragment_container_view_tag, c0Var);
                if (c0Var.G) {
                    c0Var.M.setVisibility(8);
                }
                Bundle bundle4 = c0Var.f1353i;
                if (bundle4 != null) {
                    bundle3 = bundle4.getBundle("savedInstanceState");
                }
                c0Var.Z(c0Var.M, bundle3);
                c0Var.B.t(2);
                this.f1500a.m(c0Var, c0Var.M, bundle, false);
                c0Var.f1352h = 2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z10 = this.f1503d;
        c0 c0Var = this.f1502c;
        if (!z10) {
            try {
                this.f1503d = true;
                boolean z11 = false;
                while (true) {
                    int d10 = d();
                    int i10 = c0Var.f1352h;
                    n1 n1Var = this.f1501b;
                    if (d10 != i10) {
                        if (d10 <= i10) {
                            switch (i10 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    if (c0Var.f1364t) {
                                        if (((Bundle) n1Var.f1515c.get(c0Var.f1356l)) == null) {
                                            n1Var.i(o(), c0Var.f1356l);
                                        }
                                    }
                                    g();
                                    break;
                                case 1:
                                    h();
                                    c0Var.f1352h = 1;
                                    break;
                                case 2:
                                    c0Var.f1366v = false;
                                    c0Var.f1352h = 2;
                                    break;
                                case 3:
                                    if (c1.I(3)) {
                                        Objects.toString(c0Var);
                                    }
                                    if (c0Var.f1364t) {
                                        n1Var.i(o(), c0Var.f1356l);
                                    } else if (c0Var.M != null && c0Var.f1354j == null) {
                                        p();
                                    }
                                    if (!(c0Var.M == null || (viewGroup2 = c0Var.L) == null)) {
                                        n h10 = n.h(viewGroup2, c0Var.x());
                                        h10.getClass();
                                        if (c1.I(2)) {
                                            Objects.toString(c0Var);
                                        }
                                        h10.b(g2.REMOVED, e2.REMOVING, this);
                                    }
                                    c0Var.f1352h = 3;
                                    break;
                                case 4:
                                    r();
                                    break;
                                case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                                    c0Var.f1352h = 5;
                                    break;
                                case 6:
                                    l();
                                    break;
                            }
                        } else {
                            switch (i10 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(c0Var.M == null || (viewGroup3 = c0Var.L) == null)) {
                                        n h11 = n.h(viewGroup3, c0Var.x());
                                        int visibility = c0Var.M.getVisibility();
                                        g2.f1435h.getClass();
                                        g2 b10 = f2.b(visibility);
                                        h11.getClass();
                                        if (c1.I(2)) {
                                            Objects.toString(c0Var);
                                        }
                                        h11.b(b10, e2.ADDING, this);
                                    }
                                    c0Var.f1352h = 4;
                                    break;
                                case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                                    q();
                                    break;
                                case 6:
                                    c0Var.f1352h = 6;
                                    break;
                                case 7:
                                    n();
                                    break;
                            }
                        }
                        z11 = true;
                    } else {
                        if (!z11 && i10 == -1 && c0Var.f1363s && !c0Var.H() && !c0Var.f1364t) {
                            if (c1.I(3)) {
                                Objects.toString(c0Var);
                            }
                            h1 h1Var = n1Var.f1516d;
                            h1Var.getClass();
                            if (c1.I(3)) {
                                Objects.toString(c0Var);
                            }
                            h1Var.d(c0Var.f1356l);
                            n1Var.h(this);
                            if (c1.I(3)) {
                                Objects.toString(c0Var);
                            }
                            c0Var.E();
                        }
                        if (c0Var.Q) {
                            if (!(c0Var.M == null || (viewGroup = c0Var.L) == null)) {
                                n h12 = n.h(viewGroup, c0Var.x());
                                boolean z12 = c0Var.G;
                                e2 e2Var = e2.NONE;
                                if (z12) {
                                    h12.getClass();
                                    if (c1.I(2)) {
                                        Objects.toString(c0Var);
                                    }
                                    h12.b(g2.GONE, e2Var, this);
                                } else {
                                    h12.getClass();
                                    if (c1.I(2)) {
                                        Objects.toString(c0Var);
                                    }
                                    h12.b(g2.VISIBLE, e2Var, this);
                                }
                            }
                            c1 c1Var = c0Var.f1370z;
                            if (c1Var != null && c0Var.f1362r && c1.J(c0Var)) {
                                c1Var.F = true;
                            }
                            c0Var.Q = false;
                            c0Var.B.n();
                        }
                        this.f1503d = false;
                        return;
                    }
                }
            } catch (Throwable th) {
                this.f1503d = false;
                throw th;
            }
        } else if (c1.I(2)) {
            Objects.toString(c0Var);
        }
    }

    public final void l() {
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        c0Var.B.t(5);
        if (c0Var.M != null) {
            c0Var.W.b(r.ON_PAUSE);
        }
        c0Var.V.f(r.ON_PAUSE);
        c0Var.f1352h = 6;
        c0Var.K = true;
        this.f1500a.f(false);
    }

    public final void m(ClassLoader classLoader) {
        c0 c0Var = this.f1502c;
        Bundle bundle = c0Var.f1353i;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            if (c0Var.f1353i.getBundle("savedInstanceState") == null) {
                c0Var.f1353i.putBundle("savedInstanceState", new Bundle());
            }
            c0Var.f1354j = c0Var.f1353i.getSparseParcelableArray("viewState");
            c0Var.f1355k = c0Var.f1353i.getBundle("viewRegistryState");
            l1 l1Var = (l1) c0Var.f1353i.getParcelable("state");
            if (l1Var != null) {
                c0Var.f1359o = l1Var.f1491s;
                c0Var.f1360p = l1Var.f1492t;
                c0Var.O = l1Var.f1493u;
            }
            if (!c0Var.O) {
                c0Var.N = true;
            }
        }
    }

    public final void n() {
        View view;
        boolean z10;
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        x xVar = c0Var.P;
        if (xVar == null) {
            view = null;
        } else {
            view = xVar.f1609m;
        }
        if (view != null) {
            if (view != c0Var.M) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent == null) {
                        z10 = false;
                        break;
                    } else if (parent == c0Var.M) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            z10 = true;
            if (z10) {
                view.requestFocus();
                if (c1.I(2)) {
                    view.toString();
                    Objects.toString(c0Var);
                    Objects.toString(c0Var.M.findFocus());
                }
            }
        }
        c0Var.s().f1609m = null;
        c0Var.B.P();
        c0Var.B.y(true);
        c0Var.f1352h = 7;
        c0Var.K = false;
        c0Var.V();
        if (c0Var.K) {
            g0 g0Var = c0Var.V;
            r rVar = r.ON_RESUME;
            g0Var.f(rVar);
            if (c0Var.M != null) {
                c0Var.W.b(rVar);
            }
            d1 d1Var = c0Var.B;
            d1Var.G = false;
            d1Var.H = false;
            d1Var.N.f1452i = false;
            d1Var.t(7);
            this.f1500a.i(false);
            c0Var.f1353i = null;
            c0Var.f1354j = null;
            c0Var.f1355k = null;
            return;
        }
        throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onResume()"));
    }

    public final Bundle o() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        c0 c0Var = this.f1502c;
        if (c0Var.f1352h == -1 && (bundle = c0Var.f1353i) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new l1(c0Var));
        if (c0Var.f1352h > -1) {
            Bundle bundle3 = new Bundle();
            c0Var.W(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f1500a.j(false);
            Bundle bundle4 = new Bundle();
            c0Var.Z.c(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle W = c0Var.B.W();
            if (!W.isEmpty()) {
                bundle2.putBundle("childFragmentManager", W);
            }
            if (c0Var.M != null) {
                p();
            }
            SparseArray sparseArray = c0Var.f1354j;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = c0Var.f1355k;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = c0Var.f1357m;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void p() {
        c0 c0Var = this.f1502c;
        if (c0Var.M != null) {
            if (c1.I(2)) {
                Objects.toString(c0Var);
                Objects.toString(c0Var.M);
            }
            SparseArray sparseArray = new SparseArray();
            c0Var.M.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                c0Var.f1354j = sparseArray;
            }
            Bundle bundle = new Bundle();
            c0Var.W.f1620m.c(bundle);
            if (!bundle.isEmpty()) {
                c0Var.f1355k = bundle;
            }
        }
    }

    public final void q() {
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        c0Var.B.P();
        c0Var.B.y(true);
        c0Var.f1352h = 5;
        c0Var.K = false;
        c0Var.X();
        if (c0Var.K) {
            g0 g0Var = c0Var.V;
            r rVar = r.ON_START;
            g0Var.f(rVar);
            if (c0Var.M != null) {
                c0Var.W.b(rVar);
            }
            d1 d1Var = c0Var.B;
            d1Var.G = false;
            d1Var.H = false;
            d1Var.N.f1452i = false;
            d1Var.t(5);
            this.f1500a.k(false);
            return;
        }
        throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onStart()"));
    }

    public final void r() {
        boolean I = c1.I(3);
        c0 c0Var = this.f1502c;
        if (I) {
            Objects.toString(c0Var);
        }
        d1 d1Var = c0Var.B;
        d1Var.H = true;
        d1Var.N.f1452i = true;
        d1Var.t(4);
        if (c0Var.M != null) {
            c0Var.W.b(r.ON_STOP);
        }
        c0Var.V.f(r.ON_STOP);
        c0Var.f1352h = 4;
        c0Var.K = false;
        c0Var.Y();
        if (c0Var.K) {
            this.f1500a.l(false);
            return;
        }
        throw new j2(h.l("Fragment ", c0Var, " did not call through to super.onStop()"));
    }

    public m1(n0 n0Var, n1 n1Var, c0 c0Var, Bundle bundle) {
        this.f1500a = n0Var;
        this.f1501b = n1Var;
        this.f1502c = c0Var;
        c0Var.f1354j = null;
        c0Var.f1355k = null;
        c0Var.f1369y = 0;
        c0Var.f1366v = false;
        c0Var.f1362r = false;
        c0 c0Var2 = c0Var.f1358n;
        c0Var.f1359o = c0Var2 != null ? c0Var2.f1356l : null;
        c0Var.f1358n = null;
        c0Var.f1353i = bundle;
        c0Var.f1357m = bundle.getBundle("arguments");
    }

    public m1(n0 n0Var, n1 n1Var, ClassLoader classLoader, j0 j0Var, Bundle bundle) {
        this.f1500a = n0Var;
        this.f1501b = n1Var;
        c0 u10 = ((l1) bundle.getParcelable("state")).u(j0Var, classLoader);
        this.f1502c = u10;
        u10.f1353i = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        u10.j0(bundle2);
        if (c1.I(2)) {
            Objects.toString(u10);
        }
    }
}
