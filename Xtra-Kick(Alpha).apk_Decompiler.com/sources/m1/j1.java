package m1;

import android.os.Handler;
import android.os.Looper;
import g1.u1;
import j1.l0;
import j1.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import n1.a;
import n1.f0;
import p1.p;
import p1.q;
import v1.b0;
import v1.e0;
import v1.e1;
import v1.v;

public final class j1 {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f10295a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f10296b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final IdentityHashMap f10297c = new IdentityHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f10298d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final u0 f10299e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f10300f;

    /* renamed from: g  reason: collision with root package name */
    public final HashSet f10301g;

    /* renamed from: h  reason: collision with root package name */
    public final a f10302h;

    /* renamed from: i  reason: collision with root package name */
    public final n f10303i;

    /* renamed from: j  reason: collision with root package name */
    public e1 f10304j = new e1();

    /* renamed from: k  reason: collision with root package name */
    public boolean f10305k;

    /* renamed from: l  reason: collision with root package name */
    public k1.f0 f10306l;

    public j1(u0 u0Var, a aVar, j1.f0 f0Var, f0 f0Var2) {
        this.f10295a = f0Var2;
        this.f10299e = u0Var;
        this.f10302h = aVar;
        this.f10303i = f0Var;
        this.f10300f = new HashMap();
        this.f10301g = new HashSet();
    }

    public final u1 a(int i10, List list, e1 e1Var) {
        if (!list.isEmpty()) {
            this.f10304j = e1Var;
            for (int i11 = i10; i11 < list.size() + i10; i11++) {
                i1 i1Var = (i1) list.get(i11 - i10);
                ArrayList arrayList = this.f10296b;
                if (i11 > 0) {
                    i1 i1Var2 = (i1) arrayList.get(i11 - 1);
                    i1Var.f10273d = i1Var2.f10270a.f15809o.x() + i1Var2.f10273d;
                } else {
                    i1Var.f10273d = 0;
                }
                i1Var.f10274e = false;
                i1Var.f10272c.clear();
                int x10 = i1Var.f10270a.f15809o.x();
                for (int i12 = i11; i12 < arrayList.size(); i12++) {
                    ((i1) arrayList.get(i12)).f10273d += x10;
                }
                arrayList.add(i11, i1Var);
                this.f10298d.put(i1Var.f10271b, i1Var);
                if (this.f10305k) {
                    e(i1Var);
                    if (this.f10297c.isEmpty()) {
                        this.f10301g.add(i1Var);
                    } else {
                        h1 h1Var = (h1) this.f10300f.get(i1Var);
                        if (h1Var != null) {
                            h1Var.f10259a.c(h1Var.f10260b);
                        }
                    }
                }
            }
        }
        return b();
    }

    public final u1 b() {
        ArrayList arrayList = this.f10296b;
        if (arrayList.isEmpty()) {
            return u1.f6622h;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            i1 i1Var = (i1) arrayList.get(i11);
            i1Var.f10273d = i10;
            i10 += i1Var.f10270a.f15809o.x();
        }
        return new n1(arrayList, this.f10304j);
    }

    public final void c() {
        Iterator it = this.f10301g.iterator();
        while (it.hasNext()) {
            i1 i1Var = (i1) it.next();
            if (i1Var.f10272c.isEmpty()) {
                h1 h1Var = (h1) this.f10300f.get(i1Var);
                if (h1Var != null) {
                    h1Var.f10259a.c(h1Var.f10260b);
                }
                it.remove();
            }
        }
    }

    public final void d(i1 i1Var) {
        if (i1Var.f10274e && i1Var.f10272c.isEmpty()) {
            h1 h1Var = (h1) this.f10300f.remove(i1Var);
            h1Var.getClass();
            b0 b0Var = h1Var.f10260b;
            v1.a aVar = h1Var.f10259a;
            aVar.o(b0Var);
            android.support.v4.media.n nVar = h1Var.f10261c;
            aVar.r(nVar);
            aVar.q(nVar);
            this.f10301g.remove(i1Var);
        }
    }

    public final void e(i1 i1Var) {
        v vVar = i1Var.f10270a;
        c1 c1Var = new c1(this);
        android.support.v4.media.n nVar = new android.support.v4.media.n((Object) this, (Object) i1Var, 8);
        this.f10300f.put(i1Var, new h1(vVar, c1Var, nVar));
        int i10 = l0.f8453a;
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(myLooper, (Handler.Callback) null);
        v1.f0 f0Var = vVar.f15558c;
        f0Var.getClass();
        f0Var.f15620c.add(new e0(handler, nVar));
        Looper myLooper2 = Looper.myLooper();
        if (myLooper2 == null) {
            myLooper2 = Looper.getMainLooper();
        }
        Handler handler2 = new Handler(myLooper2, (Handler.Callback) null);
        q qVar = vVar.f15559d;
        qVar.getClass();
        qVar.f12507c.add(new p(handler2, nVar));
        vVar.k(c1Var, this.f10306l, this.f10295a);
    }

    public final void f(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            ArrayList arrayList = this.f10296b;
            i1 i1Var = (i1) arrayList.remove(i12);
            this.f10298d.remove(i1Var.f10271b);
            int i13 = -i1Var.f10270a.f15809o.x();
            for (int i14 = i12; i14 < arrayList.size(); i14++) {
                ((i1) arrayList.get(i14)).f10273d += i13;
            }
            i1Var.f10274e = true;
            if (this.f10305k) {
                d(i1Var);
            }
        }
    }
}
