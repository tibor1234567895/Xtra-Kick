package ec;

import dc.f0;
import dc.n;
import dc.n0;
import dc.p;
import dc.p0;
import dc.r;
import fb.w;
import fb.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import la.i;
import la.o;
import ma.s;
import ma.z;
import xa.j;

public final class f extends r {

    /* renamed from: c  reason: collision with root package name */
    public static final d f5364c = new d(0);

    /* renamed from: d  reason: collision with root package name */
    public static final f0 f5365d = f0.f4761i.getClass();

    /* renamed from: b  reason: collision with root package name */
    public final o f5366b;

    public f(ClassLoader classLoader) {
        this.f5366b = la.f.b(new e(0, classLoader));
    }

    public static String m(f0 f0Var) {
        f0 f0Var2;
        f0 f0Var3;
        f0 f0Var4 = f5365d;
        f0Var4.getClass();
        j.f("child", f0Var);
        boolean z10 = true;
        f0 b10 = l.b(f0Var4, f0Var, true);
        int a10 = l.a(b10);
        f0 f0Var5 = null;
        n nVar = b10.f4763h;
        if (a10 == -1) {
            f0Var2 = null;
        } else {
            f0Var2 = new f0(nVar.n(0, a10));
        }
        int a11 = l.a(f0Var4);
        n nVar2 = f0Var4.f4763h;
        if (a11 != -1) {
            f0Var5 = new f0(nVar2.n(0, a11));
        }
        if (j.a(f0Var2, f0Var5)) {
            ArrayList a12 = b10.a();
            ArrayList a13 = f0Var4.a();
            int min = Math.min(a12.size(), a13.size());
            int i10 = 0;
            while (i10 < min && j.a(a12.get(i10), a13.get(i10))) {
                i10++;
            }
            if (i10 == min && nVar.d() == nVar2.d()) {
                f0Var3 = f0.f4761i.getClass();
            } else {
                if (a13.subList(i10, a13.size()).indexOf(l.f5390e) != -1) {
                    z10 = false;
                }
                if (z10) {
                    dc.j jVar = new dc.j();
                    n c10 = l.c(f0Var4);
                    if (c10 == null && (c10 = l.c(b10)) == null) {
                        c10 = l.f(f0.f4762j);
                    }
                    int size = a13.size();
                    for (int i11 = i10; i11 < size; i11++) {
                        jVar.N0(l.f5390e);
                        jVar.N0(c10);
                    }
                    int size2 = a12.size();
                    while (i10 < size2) {
                        jVar.N0((n) a12.get(i10));
                        jVar.N0(c10);
                        i10++;
                    }
                    f0Var3 = l.d(jVar, false);
                } else {
                    throw new IllegalArgumentException(("Impossible relative path to resolve: " + b10 + " and " + f0Var4).toString());
                }
            }
            return f0Var3.toString();
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + b10 + " and " + f0Var4).toString());
    }

    public final n0 a(f0 f0Var) {
        throw new IOException(this + " is read-only");
    }

    public final void b(f0 f0Var, f0 f0Var2) {
        j.f("source", f0Var);
        j.f("target", f0Var2);
        throw new IOException(this + " is read-only");
    }

    public final void c(f0 f0Var) {
        throw new IOException(this + " is read-only");
    }

    public final void d(f0 f0Var) {
        j.f("path", f0Var);
        throw new IOException(this + " is read-only");
    }

    public final List g(f0 f0Var) {
        d dVar;
        j.f("dir", f0Var);
        String m10 = m(f0Var);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z10 = false;
        for (i iVar : (List) this.f5366b.getValue()) {
            r rVar = (r) iVar.f9799h;
            f0 f0Var2 = (f0) iVar.f9800i;
            try {
                List g10 = rVar.g(f0Var2.c(m10));
                ArrayList arrayList = new ArrayList();
                Iterator it = g10.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    dVar = f5364c;
                    if (!hasNext) {
                        break;
                    }
                    Object next = it.next();
                    if (d.a(dVar, (f0) next)) {
                        arrayList.add(next);
                    }
                }
                ArrayList arrayList2 = new ArrayList(s.i(arrayList));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f0 f0Var3 = (f0) it2.next();
                    dVar.getClass();
                    j.f("<this>", f0Var3);
                    arrayList2.add(f5365d.c(w.j(y.B(f0Var2.toString(), f0Var3.toString()), '\\', '/')));
                }
                ma.w.k(arrayList2, linkedHashSet);
                z10 = true;
            } catch (IOException unused) {
            }
        }
        if (z10) {
            return z.J(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + f0Var);
    }

    public final p i(f0 f0Var) {
        j.f("path", f0Var);
        if (!d.a(f5364c, f0Var)) {
            return null;
        }
        String m10 = m(f0Var);
        for (i iVar : (List) this.f5366b.getValue()) {
            p i10 = ((r) iVar.f9799h).i(((f0) iVar.f9800i).c(m10));
            if (i10 != null) {
                return i10;
            }
        }
        return null;
    }

    public final dc.y j(f0 f0Var) {
        j.f("file", f0Var);
        if (d.a(f5364c, f0Var)) {
            String m10 = m(f0Var);
            for (i iVar : (List) this.f5366b.getValue()) {
                try {
                    return ((r) iVar.f9799h).j(((f0) iVar.f9800i).c(m10));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + f0Var);
        }
        throw new FileNotFoundException("file not found: " + f0Var);
    }

    public final n0 k(f0 f0Var) {
        j.f("file", f0Var);
        throw new IOException(this + " is read-only");
    }

    public final p0 l(f0 f0Var) {
        j.f("file", f0Var);
        if (d.a(f5364c, f0Var)) {
            String m10 = m(f0Var);
            for (i iVar : (List) this.f5366b.getValue()) {
                try {
                    return ((r) iVar.f9799h).l(((f0) iVar.f9800i).c(m10));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + f0Var);
        }
        throw new FileNotFoundException("file not found: " + f0Var);
    }
}
