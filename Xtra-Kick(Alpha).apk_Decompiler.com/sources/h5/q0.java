package h5;

import android.support.v4.media.session.u;
import com.bumptech.glide.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import l0.d;
import w5.n;
import z4.c;

public final class q0 {

    /* renamed from: e  reason: collision with root package name */
    public static final p0 f7607e = new p0();

    /* renamed from: f  reason: collision with root package name */
    public static final n0 f7608f = new n0();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f7609a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final p0 f7610b;

    /* renamed from: c  reason: collision with root package name */
    public final HashSet f7611c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public final d f7612d;

    public q0(u uVar) {
        this.f7612d = uVar;
        this.f7610b = f7607e;
    }

    public final synchronized void a(Class cls, Class cls2, j0 j0Var) {
        o0 o0Var = new o0(cls, cls2, j0Var);
        ArrayList arrayList = this.f7609a;
        arrayList.add(arrayList.size(), o0Var);
    }

    public final i0 b(o0 o0Var) {
        i0 a10 = o0Var.f7603c.a(this);
        n.b(a10);
        return a10;
    }

    public final synchronized i0 c(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f7609a.iterator();
            boolean z10 = false;
            while (true) {
                boolean z11 = true;
                if (!it.hasNext()) {
                    break;
                }
                o0 o0Var = (o0) it.next();
                if (this.f7611c.contains(o0Var)) {
                    z10 = true;
                } else {
                    if (!o0Var.f7601a.isAssignableFrom(cls) || !o0Var.f7602b.isAssignableFrom(cls2)) {
                        z11 = false;
                    }
                    if (z11) {
                        this.f7611c.add(o0Var);
                        arrayList.add(b(o0Var));
                        this.f7611c.remove(o0Var);
                    }
                }
            }
            if (arrayList.size() > 1) {
                p0 p0Var = this.f7610b;
                d dVar = this.f7612d;
                p0Var.getClass();
                return new q(arrayList, dVar);
            } else if (arrayList.size() == 1) {
                return (i0) arrayList.get(0);
            } else if (z10) {
                return f7608f;
            } else {
                throw new m(cls, cls2);
            }
        } catch (Throwable th) {
            this.f7611c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList d(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f7609a.iterator();
            while (it.hasNext()) {
                o0 o0Var = (o0) it.next();
                if (!this.f7611c.contains(o0Var)) {
                    if (o0Var.f7601a.isAssignableFrom(cls)) {
                        this.f7611c.add(o0Var);
                        i0 a10 = o0Var.f7603c.a(this);
                        n.b(a10);
                        arrayList.add(a10);
                        this.f7611c.remove(o0Var);
                    }
                }
            }
        } catch (Throwable th) {
            this.f7611c.clear();
            throw th;
        }
        return arrayList;
    }

    public final synchronized ArrayList e(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f7609a.iterator();
        while (it.hasNext()) {
            o0 o0Var = (o0) it.next();
            if (!arrayList.contains(o0Var.f7602b) && o0Var.f7601a.isAssignableFrom(cls)) {
                arrayList.add(o0Var.f7602b);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList f() {
        ArrayList arrayList;
        boolean z10;
        Class<x> cls = x.class;
        Class<InputStream> cls2 = InputStream.class;
        synchronized (this) {
            arrayList = new ArrayList();
            Iterator it = this.f7609a.iterator();
            while (it.hasNext()) {
                o0 o0Var = (o0) it.next();
                if (!o0Var.f7601a.isAssignableFrom(cls) || !o0Var.f7602b.isAssignableFrom(cls2)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    it.remove();
                    arrayList.add(o0Var.f7603c);
                }
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList g(c cVar) {
        ArrayList f10;
        Class<x> cls = x.class;
        Class<InputStream> cls2 = InputStream.class;
        synchronized (this) {
            f10 = f();
            a(cls, cls2, cVar);
        }
        return f10;
    }
}
