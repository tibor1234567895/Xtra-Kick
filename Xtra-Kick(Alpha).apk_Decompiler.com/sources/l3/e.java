package l3;

import android.content.Context;
import android.support.v4.media.h;
import android.util.Log;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.t;
import androidx.lifecycle.g0;
import androidx.navigation.fragment.DialogFragmentNavigator$observer$1;
import j3.l2;
import j3.n1;
import j3.o2;
import j3.r;
import j3.r2;
import j3.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kb.e1;
import ma.p0;
import ma.z;
import xa.j;

@l2("dialog")
public final class e extends o2 {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ int f9537h = 0;

    /* renamed from: c  reason: collision with root package name */
    public final Context f9538c;

    /* renamed from: d  reason: collision with root package name */
    public final c1 f9539d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet f9540e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    public final DialogFragmentNavigator$observer$1 f9541f = new DialogFragmentNavigator$observer$1(this);

    /* renamed from: g  reason: collision with root package name */
    public final LinkedHashMap f9542g = new LinkedHashMap();

    static {
        new b(0);
    }

    public e(Context context, c1 c1Var) {
        this.f9538c = context;
        this.f9539d = c1Var;
    }

    public final j3.c1 a() {
        return new c(this);
    }

    public final void d(List list, n1 n1Var) {
        c1 c1Var = this.f9539d;
        if (c1Var.N()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            k(rVar).q0(c1Var, rVar.f8665m);
            b().h(rVar);
        }
    }

    public final void e(y yVar) {
        g0 g0Var;
        super.e(yVar);
        Iterator it = ((List) yVar.f8678e.getValue()).iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            c1 c1Var = this.f9539d;
            if (hasNext) {
                r rVar = (r) it.next();
                t tVar = (t) c1Var.E(rVar.f8665m);
                if (tVar == null || (g0Var = tVar.V) == null) {
                    this.f9540e.add(rVar.f8665m);
                } else {
                    g0Var.a(this.f9541f);
                }
            } else {
                c1Var.f1385o.add(new a(this));
                return;
            }
        }
    }

    public final void f(r rVar) {
        c1 c1Var = this.f9539d;
        if (c1Var.N()) {
            Log.i("DialogFragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        LinkedHashMap linkedHashMap = this.f9542g;
        String str = rVar.f8665m;
        t tVar = (t) linkedHashMap.get(str);
        if (tVar == null) {
            c0 E = c1Var.E(str);
            if (E instanceof t) {
                tVar = (t) E;
            } else {
                tVar = null;
            }
        }
        if (tVar != null) {
            tVar.V.c(this.f9541f);
            tVar.l0();
        }
        k(rVar).q0(c1Var, str);
        r2 b10 = b();
        List list = (List) b10.f8678e.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            r rVar2 = (r) listIterator.previous();
            if (j.a(rVar2.f8665m, str)) {
                e1 e1Var = b10.f8676c;
                e1Var.k(p0.c(p0.c((Set) e1Var.getValue(), rVar2), rVar));
                b10.c(rVar);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public final void i(r rVar, boolean z10) {
        j.f("popUpTo", rVar);
        c1 c1Var = this.f9539d;
        if (c1Var.N()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) b().f8678e.getValue();
        for (r rVar2 : z.E(list.subList(list.indexOf(rVar), list.size()))) {
            c0 E = c1Var.E(rVar2.f8665m);
            if (E != null) {
                ((t) E).l0();
            }
        }
        b().e(rVar, z10);
    }

    public final t k(r rVar) {
        j3.c1 c1Var = rVar.f8661i;
        j.d("null cannot be cast to non-null type androidx.navigation.fragment.DialogFragmentNavigator.Destination", c1Var);
        c cVar = (c) c1Var;
        String str = cVar.f9535r;
        if (str != null) {
            char charAt = str.charAt(0);
            Context context = this.f9538c;
            if (charAt == '.') {
                str = context.getPackageName() + str;
            }
            c0 a10 = this.f9539d.G().a(context.getClassLoader(), str);
            j.e("fragmentManager.fragment…ader, className\n        )", a10);
            if (t.class.isAssignableFrom(a10.getClass())) {
                t tVar = (t) a10;
                tVar.j0(rVar.b());
                tVar.V.a(this.f9541f);
                this.f9542g.put(rVar.f8665m, tVar);
                return tVar;
            }
            StringBuilder sb2 = new StringBuilder("Dialog destination ");
            String str2 = cVar.f9535r;
            if (str2 != null) {
                throw new IllegalArgumentException(h.p(sb2, str2, " is not an instance of DialogFragment").toString());
            }
            throw new IllegalStateException("DialogFragment class was not set".toString());
        }
        throw new IllegalStateException("DialogFragment class was not set".toString());
    }
}
