package com.bumptech.glide;

import android.support.v4.media.session.u;
import b5.p;
import b5.q;
import d5.o;
import h5.i0;
import h5.j0;
import h5.k0;
import h5.l0;
import h5.q0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p5.e;
import r5.b;
import r5.c;
import r5.d;
import r5.f;
import r5.g;
import r5.h;
import r5.i;
import x5.a;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final android.support.v4.media.n f3293a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3294b;

    /* renamed from: c  reason: collision with root package name */
    public final g f3295c;

    /* renamed from: d  reason: collision with root package name */
    public final i f3296d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bumptech.glide.load.data.i f3297e;

    /* renamed from: f  reason: collision with root package name */
    public final e f3298f;

    /* renamed from: g  reason: collision with root package name */
    public final c f3299g;

    /* renamed from: h  reason: collision with root package name */
    public final r5.e f3300h = new r5.e();

    /* renamed from: i  reason: collision with root package name */
    public final d f3301i = new d();

    /* renamed from: j  reason: collision with root package name */
    public final u f3302j;

    public n() {
        a aVar = x5.g.f16680a;
        u uVar = new u(new l0.e(20), new x5.b(), new x5.c(), 24);
        this.f3302j = uVar;
        this.f3293a = new android.support.v4.media.n(uVar);
        this.f3294b = new b();
        this.f3295c = new g();
        this.f3296d = new i();
        this.f3297e = new com.bumptech.glide.load.data.i();
        this.f3298f = new e();
        this.f3299g = new c();
        List<String> asList = Arrays.asList(new String[]{"Animation", "Bitmap", "BitmapDrawable"});
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        for (String add : asList) {
            arrayList.add(add);
        }
        arrayList.add("legacy_append");
        g gVar = this.f3295c;
        synchronized (gVar) {
            ArrayList arrayList2 = new ArrayList(gVar.f13832a);
            gVar.f13832a.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                gVar.f13832a.add((String) it.next());
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (!arrayList.contains(str)) {
                    gVar.f13832a.add(str);
                }
            }
        }
    }

    public final void a(p pVar, Class cls, Class cls2, String str) {
        g gVar = this.f3295c;
        synchronized (gVar) {
            gVar.a(str).add(new f(cls, cls2, pVar));
        }
    }

    public final void b(Class cls, b5.d dVar) {
        b bVar = this.f3294b;
        synchronized (bVar) {
            bVar.f13822a.add(new r5.a(cls, dVar));
        }
    }

    public final void c(Class cls, q qVar) {
        i iVar = this.f3296d;
        synchronized (iVar) {
            iVar.f13836a.add(new h(cls, qVar));
        }
    }

    public final void d(Class cls, Class cls2, j0 j0Var) {
        android.support.v4.media.n nVar = this.f3293a;
        synchronized (nVar) {
            ((q0) nVar.f337i).a(cls, cls2, j0Var);
            ((l0) nVar.f338j).f7585a.clear();
        }
    }

    public final ArrayList e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        boolean z10;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f3295c.b(cls, cls2).iterator();
        while (it.hasNext()) {
            Class cls4 = (Class) it.next();
            Iterator it2 = this.f3298f.b(cls4, cls3).iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class cls5 = (Class) it2.next();
                    g gVar = this.f3295c;
                    synchronized (gVar) {
                        arrayList = new ArrayList();
                        Iterator it3 = gVar.f13832a.iterator();
                        while (it3.hasNext()) {
                            List<f> list = (List) gVar.f13833b.get((String) it3.next());
                            if (list != null) {
                                for (f fVar : list) {
                                    if (!fVar.f13829a.isAssignableFrom(cls) || !cls4.isAssignableFrom(fVar.f13830b)) {
                                        z10 = false;
                                    } else {
                                        z10 = true;
                                    }
                                    if (z10) {
                                        arrayList.add(fVar.f13831c);
                                    }
                                }
                            }
                        }
                    }
                    arrayList2.add(new o(cls, cls4, cls5, arrayList, this.f3298f.a(cls4, cls5), this.f3302j));
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList f() {
        ArrayList arrayList;
        c cVar = this.f3299g;
        synchronized (cVar) {
            arrayList = cVar.f13823a;
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new l();
    }

    public final List g(Object obj) {
        List list;
        android.support.v4.media.n nVar = this.f3293a;
        nVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (nVar) {
            k0 k0Var = (k0) ((l0) nVar.f338j).f7585a.get(cls);
            if (k0Var == null) {
                list = null;
            } else {
                list = k0Var.f7580a;
            }
            if (list == null) {
                list = Collections.unmodifiableList(((q0) nVar.f337i).d(cls));
                if (((k0) ((l0) nVar.f338j).f7585a.put(cls, new k0(list))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (!list.isEmpty()) {
            int size = list.size();
            List emptyList = Collections.emptyList();
            boolean z10 = true;
            for (int i10 = 0; i10 < size; i10++) {
                i0 i0Var = (i0) list.get(i10);
                if (i0Var.b(obj)) {
                    if (z10) {
                        emptyList = new ArrayList(size - i10);
                        z10 = false;
                    }
                    emptyList.add(i0Var);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new m(obj, list);
        }
        throw new m(obj);
    }

    public final com.bumptech.glide.load.data.g h(Object obj) {
        com.bumptech.glide.load.data.g b10;
        com.bumptech.glide.load.data.i iVar = this.f3297e;
        synchronized (iVar) {
            w5.n.b(obj);
            com.bumptech.glide.load.data.f fVar = (com.bumptech.glide.load.data.f) iVar.f3226a.get(obj.getClass());
            if (fVar == null) {
                Iterator it = iVar.f3226a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.bumptech.glide.load.data.f fVar2 = (com.bumptech.glide.load.data.f) it.next();
                    if (fVar2.a().isAssignableFrom(obj.getClass())) {
                        fVar = fVar2;
                        break;
                    }
                }
            }
            if (fVar == null) {
                fVar = com.bumptech.glide.load.data.i.f3225b;
            }
            b10 = fVar.b(obj);
        }
        return b10;
    }

    public final void i(p pVar, Class cls, Class cls2, String str) {
        g gVar = this.f3295c;
        synchronized (gVar) {
            gVar.a(str).add(0, new f(cls, cls2, pVar));
        }
    }

    public final void j(b5.f fVar) {
        c cVar = this.f3299g;
        synchronized (cVar) {
            cVar.f13823a.add(fVar);
        }
    }

    public final void k(com.bumptech.glide.load.data.f fVar) {
        com.bumptech.glide.load.data.i iVar = this.f3297e;
        synchronized (iVar) {
            iVar.f3226a.put(fVar.a(), fVar);
        }
    }

    public final void l(Class cls, Class cls2, p5.c cVar) {
        e eVar = this.f3298f;
        synchronized (eVar) {
            eVar.f12573a.add(new p5.d(cls, cls2, cVar));
        }
    }

    public final void m(z4.c cVar) {
        android.support.v4.media.n nVar = this.f3293a;
        synchronized (nVar) {
            Iterator it = ((q0) nVar.f337i).g(cVar).iterator();
            while (it.hasNext()) {
                ((j0) it.next()).b();
            }
            ((l0) nVar.f338j).f7585a.clear();
        }
    }
}
