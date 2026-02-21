package j3;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kb.e1;
import kb.f1;
import kb.n0;
import la.v;
import ma.b0;
import ma.d0;
import ma.i0;
import ma.p0;
import ma.z;
import xa.j;

public abstract class r2 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f8674a = new ReentrantLock(true);

    /* renamed from: b  reason: collision with root package name */
    public final e1 f8675b;

    /* renamed from: c  reason: collision with root package name */
    public final e1 f8676c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8677d;

    /* renamed from: e  reason: collision with root package name */
    public final n0 f8678e;

    /* renamed from: f  reason: collision with root package name */
    public final n0 f8679f;

    public r2() {
        e1 a10 = f1.a(b0.f10801h);
        this.f8675b = a10;
        e1 a11 = f1.a(d0.f10804h);
        this.f8676c = a11;
        this.f8678e = new n0(a10);
        this.f8679f = new n0(a11);
    }

    public abstract r a(c1 c1Var, Bundle bundle);

    public void b(r rVar) {
        j.f("entry", rVar);
        e1 e1Var = this.f8676c;
        Set set = (Set) e1Var.getValue();
        j.f("<this>", set);
        LinkedHashSet linkedHashSet = new LinkedHashSet(i0.a(set.size()));
        boolean z10 = false;
        for (Object next : set) {
            boolean z11 = true;
            if (!z10 && j.a(next, rVar)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(next);
            }
        }
        e1Var.k(linkedHashSet);
    }

    public final void c(r rVar) {
        int i10;
        ReentrantLock reentrantLock = this.f8674a;
        reentrantLock.lock();
        try {
            ArrayList K = z.K((Collection) this.f8678e.getValue());
            ListIterator listIterator = K.listIterator(K.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (j.a(((r) listIterator.previous()).f8665m, rVar.f8665m)) {
                        i10 = listIterator.nextIndex();
                        break;
                    }
                } else {
                    i10 = -1;
                    break;
                }
            }
            K.set(i10, rVar);
            this.f8675b.k(K);
            v vVar = v.f9814a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void d(r rVar, boolean z10) {
        j.f("popUpTo", rVar);
        ReentrantLock reentrantLock = this.f8674a;
        reentrantLock.lock();
        try {
            e1 e1Var = this.f8675b;
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) e1Var.getValue()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!(!j.a((r) next, rVar))) {
                    break;
                }
                arrayList.add(next);
            }
            e1Var.k(arrayList);
            v vVar = v.f9814a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void e(r rVar, boolean z10) {
        boolean z11;
        Object obj;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        j.f("popUpTo", rVar);
        e1 e1Var = this.f8676c;
        Iterable iterable = (Iterable) e1Var.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((r) it.next()) == rVar) {
                    z15 = true;
                    continue;
                } else {
                    z15 = false;
                    continue;
                }
                if (z15) {
                    z11 = true;
                    break;
                }
            }
        }
        z11 = false;
        n0 n0Var = this.f8678e;
        if (z11) {
            Iterable iterable2 = (Iterable) n0Var.getValue();
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                Iterator it2 = iterable2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (((r) it2.next()) == rVar) {
                        z14 = true;
                        continue;
                    } else {
                        z14 = false;
                        continue;
                    }
                    if (z14) {
                        z13 = false;
                        break;
                    }
                }
            }
            z13 = true;
            if (z13) {
                return;
            }
        }
        e1Var.k(p0.c((Set) e1Var.getValue(), rVar));
        List list = (List) n0Var.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            r rVar2 = (r) obj;
            if (j.a(rVar2, rVar) || ((List) n0Var.getValue()).lastIndexOf(rVar2) >= ((List) n0Var.getValue()).lastIndexOf(rVar)) {
                z12 = false;
                continue;
            } else {
                z12 = true;
                continue;
            }
            if (z12) {
                break;
            }
        }
        r rVar3 = (r) obj;
        if (rVar3 != null) {
            e1Var.k(p0.c((Set) e1Var.getValue(), rVar3));
        }
        d(rVar, z10);
    }

    public void f(r rVar) {
        e1 e1Var = this.f8676c;
        e1Var.k(p0.c((Set) e1Var.getValue(), rVar));
    }

    public void g(r rVar) {
        j.f("backStackEntry", rVar);
        ReentrantLock reentrantLock = this.f8674a;
        reentrantLock.lock();
        try {
            e1 e1Var = this.f8675b;
            e1Var.k(z.D(rVar, (Collection) e1Var.getValue()));
            v vVar = v.f9814a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void h(r rVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        j.f("backStackEntry", rVar);
        e1 e1Var = this.f8676c;
        Iterable iterable = (Iterable) e1Var.getValue();
        boolean z13 = false;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((r) it.next()) == rVar) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        n0 n0Var = this.f8678e;
        if (z10) {
            Iterable iterable2 = (Iterable) n0Var.getValue();
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                Iterator it2 = iterable2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((r) it2.next()) == rVar) {
                            z11 = true;
                            continue;
                        } else {
                            z11 = false;
                            continue;
                        }
                        if (z11) {
                            z13 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z13) {
                return;
            }
        }
        r rVar2 = (r) z.A((List) n0Var.getValue());
        if (rVar2 != null) {
            e1Var.k(p0.c((Set) e1Var.getValue(), rVar2));
        }
        e1Var.k(p0.c((Set) e1Var.getValue(), rVar));
        g(rVar);
    }
}
