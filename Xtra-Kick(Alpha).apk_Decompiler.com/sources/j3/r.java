package j3;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.a2;
import androidx.lifecycle.b2;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0;
import androidx.lifecycle.g2;
import androidx.lifecycle.h2;
import androidx.lifecycle.m;
import androidx.lifecycle.o1;
import androidx.lifecycle.s;
import androidx.lifecycle.s1;
import androidx.lifecycle.t;
import java.util.LinkedHashMap;
import java.util.Set;
import la.f;
import la.o;
import t3.e;
import t3.g;
import t3.h;
import xa.j;

public final class r implements d0, h2, m, h {

    /* renamed from: t  reason: collision with root package name */
    public static final n f8659t = new n(0);

    /* renamed from: h  reason: collision with root package name */
    public final Context f8660h;

    /* renamed from: i  reason: collision with root package name */
    public c1 f8661i;

    /* renamed from: j  reason: collision with root package name */
    public final Bundle f8662j;

    /* renamed from: k  reason: collision with root package name */
    public s f8663k;

    /* renamed from: l  reason: collision with root package name */
    public final h2 f8664l;

    /* renamed from: m  reason: collision with root package name */
    public final String f8665m;

    /* renamed from: n  reason: collision with root package name */
    public final Bundle f8666n;

    /* renamed from: o  reason: collision with root package name */
    public final g0 f8667o = new g0(this);

    /* renamed from: p  reason: collision with root package name */
    public final g f8668p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f8669q;

    /* renamed from: r  reason: collision with root package name */
    public s f8670r;

    /* renamed from: s  reason: collision with root package name */
    public final s1 f8671s;

    public r(Context context, c1 c1Var, Bundle bundle, s sVar, h2 h2Var, String str, Bundle bundle2) {
        this.f8660h = context;
        this.f8661i = c1Var;
        this.f8662j = bundle;
        this.f8663k = sVar;
        this.f8664l = h2Var;
        this.f8665m = str;
        this.f8666n = bundle2;
        g.f14538d.getClass();
        this.f8668p = new g(this);
        o b10 = f.b(new q(this, 0));
        f.b(new q(this, 1));
        this.f8670r = s.INITIALIZED;
        this.f8671s = (s1) b10.getValue();
    }

    public final e a() {
        return this.f8668p.f14540b;
    }

    public final Bundle b() {
        Bundle bundle = this.f8662j;
        if (bundle == null) {
            return null;
        }
        return new Bundle(bundle);
    }

    public final void c(s sVar) {
        j.f("maxState", sVar);
        this.f8670r = sVar;
        d();
    }

    public final void d() {
        if (!this.f8669q) {
            g gVar = this.f8668p;
            gVar.a();
            this.f8669q = true;
            if (this.f8664l != null) {
                o1.b(this);
            }
            gVar.b(this.f8666n);
        }
        this.f8667o.h(this.f8663k.ordinal() < this.f8670r.ordinal() ? this.f8663k : this.f8670r);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x007d
            boolean r1 = r7 instanceof j3.r
            if (r1 != 0) goto L_0x0009
            goto L_0x007d
        L_0x0009:
            j3.r r7 = (j3.r) r7
            java.lang.String r1 = r7.f8665m
            java.lang.String r2 = r6.f8665m
            boolean r1 = xa.j.a(r2, r1)
            if (r1 == 0) goto L_0x007d
            j3.c1 r1 = r6.f8661i
            j3.c1 r2 = r7.f8661i
            boolean r1 = xa.j.a(r1, r2)
            if (r1 == 0) goto L_0x007d
            androidx.lifecycle.g0 r1 = r6.f8667o
            androidx.lifecycle.g0 r2 = r7.f8667o
            boolean r1 = xa.j.a(r1, r2)
            if (r1 == 0) goto L_0x007d
            t3.g r1 = r6.f8668p
            t3.e r1 = r1.f14540b
            t3.g r2 = r7.f8668p
            t3.e r2 = r2.f14540b
            boolean r1 = xa.j.a(r1, r2)
            if (r1 == 0) goto L_0x007d
            android.os.Bundle r1 = r6.f8662j
            android.os.Bundle r7 = r7.f8662j
            boolean r2 = xa.j.a(r1, r7)
            r3 = 1
            if (r2 != 0) goto L_0x007c
            if (r1 == 0) goto L_0x0079
            java.util.Set r2 = r1.keySet()
            if (r2 == 0) goto L_0x0079
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x0052
        L_0x0050:
            r7 = 1
            goto L_0x0075
        L_0x0052:
            java.util.Iterator r2 = r2.iterator()
        L_0x0056:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0050
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.get(r4)
            if (r7 == 0) goto L_0x006d
            java.lang.Object r4 = r7.get(r4)
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            boolean r4 = xa.j.a(r5, r4)
            if (r4 != 0) goto L_0x0056
            r7 = 0
        L_0x0075:
            if (r7 != r3) goto L_0x0079
            r7 = 1
            goto L_0x007a
        L_0x0079:
            r7 = 0
        L_0x007a:
            if (r7 == 0) goto L_0x007d
        L_0x007c:
            r0 = 1
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.r.equals(java.lang.Object):boolean");
    }

    public final b2 h() {
        return this.f8671s;
    }

    public final int hashCode() {
        Set<String> keySet;
        int i10;
        int hashCode = this.f8661i.hashCode() + (this.f8665m.hashCode() * 31);
        Bundle bundle = this.f8662j;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i11 = hashCode * 31;
                Object obj = bundle.get(str);
                if (obj != null) {
                    i10 = obj.hashCode();
                } else {
                    i10 = 0;
                }
                hashCode = i11 + i10;
            }
        }
        int hashCode2 = this.f8667o.hashCode();
        return this.f8668p.f14540b.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public final b1.f i() {
        b1.f fVar = new b1.f(0);
        Application application = null;
        Context context = this.f8660h;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        }
        if (application != null) {
            fVar.b(a2.f1653g, application);
        }
        fVar.b(o1.f1735a, this);
        fVar.b(o1.f1736b, this);
        Bundle b10 = b();
        if (b10 != null) {
            fVar.b(o1.f1737c, b10);
        }
        return fVar;
    }

    public final g2 m() {
        boolean z10;
        if (this.f8669q) {
            if (this.f8667o.f1688d != s.DESTROYED) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                h2 h2Var = this.f8664l;
                if (h2Var != null) {
                    String str = this.f8665m;
                    j.f("backStackEntryId", str);
                    LinkedHashMap linkedHashMap = ((n0) h2Var).f8631d;
                    g2 g2Var = (g2) linkedHashMap.get(str);
                    if (g2Var != null) {
                        return g2Var;
                    }
                    g2 g2Var2 = new g2();
                    linkedHashMap.put(str, g2Var2);
                    return g2Var2;
                }
                throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
            }
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }

    public final t o() {
        return this.f8667o;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(r.class.getSimpleName());
        sb2.append("(" + this.f8665m + ')');
        sb2.append(" destination=");
        sb2.append(this.f8661i);
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }
}
