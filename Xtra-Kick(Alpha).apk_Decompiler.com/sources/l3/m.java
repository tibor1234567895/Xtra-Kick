package l3;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.session.u;
import android.util.Log;
import androidx.fragment.app.a1;
import androidx.fragment.app.b1;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.k;
import androidx.lifecycle.b2;
import androidx.lifecycle.g2;
import b1.a;
import b1.c;
import b1.d;
import b1.e;
import b1.g;
import hb.h0;
import j3.l2;
import j3.n1;
import j3.o2;
import j3.r;
import j3.r2;
import j3.v;
import j3.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import la.i;
import ma.s;
import ma.w;
import ma.z;
import xa.j;

@l2("fragment")
public class m extends o2 {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ int f9553i = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Context f9554c;

    /* renamed from: d  reason: collision with root package name */
    public final c1 f9555d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9556e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedHashSet f9557f = new LinkedHashSet();

    /* renamed from: g  reason: collision with root package name */
    public final v f9558g = new v(1, this);

    /* renamed from: h  reason: collision with root package name */
    public final k f9559h = new k(2, this);

    static {
        new h(0);
    }

    public m(Context context, c1 c1Var, int i10) {
        this.f9554c = context;
        this.f9555d = c1Var;
        this.f9556e = i10;
    }

    public static void k(c0 c0Var, r rVar, r2 r2Var) {
        j.f("state", r2Var);
        g2 m10 = c0Var.m();
        e eVar = new e();
        Class<g> cls = g.class;
        xa.e a10 = xa.v.a(cls);
        k kVar = k.f9550h;
        j.f("initializer", kVar);
        ArrayList arrayList = eVar.f2412a;
        arrayList.add(new g(h0.s0(a10), kVar));
        g[] gVarArr = (g[]) arrayList.toArray(new g[0]);
        ((g) new u(m10, (b2) new d((g[]) Arrays.copyOf(gVarArr, gVarArr.length)), (c) a.f2409b).q(cls)).f9545d = new WeakReference(new j(rVar, 0, r2Var));
    }

    public final j3.c1 a() {
        return new i(this);
    }

    public final void d(List list, n1 n1Var) {
        boolean z10;
        c1 c1Var = this.f9555d;
        if (c1Var.N()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            boolean isEmpty = ((List) b().f8678e.getValue()).isEmpty();
            if (n1Var == null || isEmpty || !n1Var.f8633b || !this.f9557f.remove(rVar.f8665m)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                c1Var.w(new b1(c1Var, rVar.f8665m, 0), false);
            } else {
                androidx.fragment.app.a l10 = l(rVar, n1Var);
                if (!isEmpty) {
                    l10.c(rVar.f8665m);
                }
                l10.g();
            }
            b().h(rVar);
        }
    }

    public final void e(y yVar) {
        super.e(yVar);
        f fVar = new f(yVar, this);
        c1 c1Var = this.f9555d;
        c1Var.f1385o.add(fVar);
        l lVar = new l(yVar, this);
        if (c1Var.f1383m == null) {
            c1Var.f1383m = new ArrayList();
        }
        c1Var.f1383m.add(lVar);
    }

    public final void f(r rVar) {
        c1 c1Var = this.f9555d;
        if (c1Var.N()) {
            Log.i("FragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        androidx.fragment.app.a l10 = l(rVar, (n1) null);
        if (((List) b().f8678e.getValue()).size() > 1) {
            String str = rVar.f8665m;
            c1Var.w(new a1(c1Var, str, -1), false);
            l10.c(str);
        }
        l10.g();
        b().c(rVar);
    }

    public final void g(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            LinkedHashSet linkedHashSet = this.f9557f;
            linkedHashSet.clear();
            w.k(stringArrayList, linkedHashSet);
        }
    }

    public final Bundle h() {
        LinkedHashSet linkedHashSet = this.f9557f;
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return h0.r(new i("androidx-nav-fragment:navigator:savedIds", new ArrayList(linkedHashSet)));
    }

    public final void i(r rVar, boolean z10) {
        j.f("popUpTo", rVar);
        c1 c1Var = this.f9555d;
        if (c1Var.N()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) b().f8678e.getValue();
        List subList = list.subList(list.indexOf(rVar), list.size());
        if (z10) {
            r rVar2 = (r) z.s(list);
            for (r rVar3 : z.E(subList)) {
                if (j.a(rVar3, rVar2)) {
                    Log.i("FragmentNavigator", "FragmentManager cannot save the state of the initial destination " + rVar3);
                } else {
                    c1Var.w(new b1(c1Var, rVar3.f8665m, 1), false);
                    this.f9557f.add(rVar3.f8665m);
                }
            }
        } else {
            c1Var.w(new a1(c1Var, rVar.f8665m, -1), false);
        }
        b().e(rVar, z10);
    }

    public final androidx.fragment.app.a l(r rVar, n1 n1Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        j3.c1 c1Var = rVar.f8661i;
        j.d("null cannot be cast to non-null type androidx.navigation.fragment.FragmentNavigator.Destination", c1Var);
        Bundle b10 = rVar.b();
        String str = ((i) c1Var).f9546r;
        if (str != null) {
            int i14 = 0;
            char charAt = str.charAt(0);
            Context context = this.f9554c;
            if (charAt == '.') {
                str = context.getPackageName() + str;
            }
            c1 c1Var2 = this.f9555d;
            c0 a10 = c1Var2.G().a(context.getClassLoader(), str);
            j.e("fragmentManager.fragment…t.classLoader, className)", a10);
            a10.j0(b10);
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(c1Var2);
            if (n1Var != null) {
                i10 = n1Var.f8637f;
            } else {
                i10 = -1;
            }
            if (n1Var != null) {
                i11 = n1Var.f8638g;
            } else {
                i11 = -1;
            }
            if (n1Var != null) {
                i12 = n1Var.f8639h;
            } else {
                i12 = -1;
            }
            if (n1Var != null) {
                i13 = n1Var.f8640i;
            } else {
                i13 = -1;
            }
            if (!(i10 == -1 && i11 == -1 && i12 == -1 && i13 == -1)) {
                if (i10 == -1) {
                    i10 = 0;
                }
                if (i11 == -1) {
                    i11 = 0;
                }
                if (i12 == -1) {
                    i12 = 0;
                }
                if (i13 != -1) {
                    i14 = i13;
                }
                aVar.f1534b = i10;
                aVar.f1535c = i11;
                aVar.f1536d = i12;
                aVar.f1537e = i14;
            }
            aVar.e(this.f9556e, a10, rVar.f8665m);
            aVar.m(a10);
            aVar.f1548p = true;
            return aVar;
        }
        throw new IllegalStateException("Fragment class was not set".toString());
    }

    public final Set m() {
        Set<r> set;
        Set set2 = (Set) b().f8679f.getValue();
        Set N = z.N((Iterable) b().f8678e.getValue());
        j.f("<this>", set2);
        j.f("elements", N);
        if (N.isEmpty()) {
            set = z.N(set2);
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Object next : set2) {
                if (!N.contains(next)) {
                    linkedHashSet.add(next);
                }
            }
            set = linkedHashSet;
        }
        ArrayList arrayList = new ArrayList(s.i(set));
        for (r rVar : set) {
            arrayList.add(rVar.f8665m);
        }
        return z.N(arrayList);
    }
}
