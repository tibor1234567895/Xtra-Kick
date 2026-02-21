package j3;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v4.media.session.u;
import android.util.AttributeSet;
import eb.m;
import eb.q;
import fb.w;
import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import la.v;
import ma.z;
import q.l;
import xa.j;
import ya.a;

public final class h1 extends c1 implements Iterable, a {

    /* renamed from: v  reason: collision with root package name */
    public static final f1 f8556v = new f1(0);

    /* renamed from: r  reason: collision with root package name */
    public final l f8557r = new l();

    /* renamed from: s  reason: collision with root package name */
    public int f8558s;

    /* renamed from: t  reason: collision with root package name */
    public String f8559t;

    /* renamed from: u  reason: collision with root package name */
    public String f8560u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h1(o2 o2Var) {
        super(o2Var);
        j.f("navGraphNavigator", o2Var);
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof h1)) {
            l lVar = this.f8557r;
            ArrayList e10 = q.e(m.a(h0.a2(lVar)));
            h1 h1Var = (h1) obj;
            l lVar2 = h1Var.f8557r;
            q.m a22 = h0.a2(lVar2);
            while (a22.hasNext()) {
                e10.remove((c1) a22.next());
            }
            if (!super.equals(obj) || lVar.g() != lVar2.g() || this.f8558s != h1Var.f8558s || !e10.isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final b1 f(u uVar) {
        b1 f10 = super.f(uVar);
        ArrayList arrayList = new ArrayList();
        g1 g1Var = new g1(this);
        while (g1Var.hasNext()) {
            b1 f11 = ((c1) g1Var.next()).f(uVar);
            if (f11 != null) {
                arrayList.add(f11);
            }
        }
        b1[] b1VarArr = {f10, (b1) z.B(arrayList)};
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            b1 b1Var = b1VarArr[i10];
            if (b1Var != null) {
                arrayList2.add(b1Var);
            }
        }
        return (b1) z.B(arrayList2);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        j.f("context", context);
        super.g(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, k3.a.f9077d);
        j.e("context.resources.obtain…vGraphNavigator\n        )", obtainAttributes);
        k(obtainAttributes.getResourceId(0, 0));
        int i10 = this.f8558s;
        c1.f8505q.getClass();
        this.f8559t = a1.b(context, i10);
        v vVar = v.f9814a;
        obtainAttributes.recycle();
    }

    public final void h(c1 c1Var) {
        boolean z10;
        boolean z11;
        j.f("node", c1Var);
        int i10 = c1Var.f8513o;
        String str = c1Var.f8514p;
        boolean z12 = false;
        if (i10 == 0 && str == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            String str2 = this.f8514p;
            if (str2 == null || (!j.a(str, str2))) {
                if (i10 != this.f8513o) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    l lVar = this.f8557r;
                    c1 c1Var2 = (c1) lVar.d(i10, (Integer) null);
                    if (c1Var2 != c1Var) {
                        if (c1Var.f8507i == null) {
                            z12 = true;
                        }
                        if (z12) {
                            if (c1Var2 != null) {
                                c1Var2.f8507i = null;
                            }
                            c1Var.f8507i = this;
                            lVar.f(c1Var.f8513o, c1Var);
                            return;
                        }
                        throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
                    }
                    return;
                }
                throw new IllegalArgumentException(("Destination " + c1Var + " cannot have the same id as graph " + this).toString());
            }
            throw new IllegalArgumentException(("Destination " + c1Var + " cannot have the same route as graph " + this).toString());
        }
        throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
    }

    public final int hashCode() {
        int i10 = this.f8558s;
        l lVar = this.f8557r;
        int g10 = lVar.g();
        for (int i11 = 0; i11 < g10; i11++) {
            i10 = (((i10 * 31) + lVar.e(i11)) * 31) + ((c1) lVar.h(i11)).hashCode();
        }
        return i10;
    }

    public final c1 i(int i10, boolean z10) {
        h1 h1Var;
        c1 c1Var = (c1) this.f8557r.d(i10, (Integer) null);
        if (c1Var != null) {
            return c1Var;
        }
        if (!z10 || (h1Var = this.f8507i) == null) {
            return null;
        }
        return h1Var.i(i10, true);
    }

    public final Iterator iterator() {
        return new g1(this);
    }

    public final c1 j(String str, boolean z10) {
        h1 h1Var;
        Object obj;
        b1 b1Var;
        boolean z11;
        String str2 = str;
        j.f("route", str2);
        c1.f8505q.getClass();
        int hashCode = a1.a(str).hashCode();
        l lVar = this.f8557r;
        c1 c1Var = (c1) lVar.d(hashCode, (Integer) null);
        boolean z12 = false;
        if (c1Var == null) {
            Iterator it = m.a(h0.a2(lVar)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                c1 c1Var2 = (c1) obj;
                c1Var2.getClass();
                x0 x0Var = y0.f8725a;
                Uri parse = Uri.parse(a1.a(str));
                j.b("Uri.parse(this)", parse);
                x0Var.getClass();
                new y0(0);
                u uVar = new u((Object) parse, (Object) null, (Object) null, 14, 0);
                if (c1Var2 instanceof h1) {
                    b1Var = super.f(uVar);
                } else {
                    b1Var = c1Var2.f(uVar);
                }
                if (b1Var != null) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            c1Var = (c1) obj;
        }
        if (c1Var != null) {
            return c1Var;
        }
        if (!z10 || (h1Var = this.f8507i) == null) {
            return null;
        }
        if (w.h(str)) {
            z12 = true;
        }
        if (!z12) {
            return h1Var.j(str2, true);
        }
        return null;
    }

    public final void k(int i10) {
        boolean z10;
        if (i10 != this.f8513o) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (this.f8560u != null) {
                this.f8558s = 0;
                this.f8560u = null;
            }
            this.f8558s = i10;
            this.f8559t = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i10 + " cannot use the same id as the graph " + this).toString());
    }

    public final String toString() {
        boolean z10;
        c1 c1Var;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        String str2 = this.f8560u;
        if (str2 == null || w.h(str2)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            c1Var = j(str2, true);
        } else {
            c1Var = null;
        }
        if (c1Var == null) {
            c1Var = i(this.f8558s, true);
        }
        sb2.append(" startDestination=");
        if (c1Var == null) {
            str = this.f8560u;
            if (str == null && (str = this.f8559t) == null) {
                str = "0x" + Integer.toHexString(this.f8558s);
            }
        } else {
            sb2.append("{");
            sb2.append(c1Var.toString());
            str = "}";
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }
}
