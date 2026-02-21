package d5;

import b5.j;
import b5.n;
import b5.r;
import com.bumptech.glide.h;
import h5.h0;
import h5.i0;
import j5.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r5.a;
import r5.b;
import r5.d;
import r5.e;
import w5.m;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4392a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f4393b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public h f4394c;

    /* renamed from: d  reason: collision with root package name */
    public Object f4395d;

    /* renamed from: e  reason: collision with root package name */
    public int f4396e;

    /* renamed from: f  reason: collision with root package name */
    public int f4397f;

    /* renamed from: g  reason: collision with root package name */
    public Class f4398g;

    /* renamed from: h  reason: collision with root package name */
    public v f4399h;

    /* renamed from: i  reason: collision with root package name */
    public n f4400i;

    /* renamed from: j  reason: collision with root package name */
    public Map f4401j;

    /* renamed from: k  reason: collision with root package name */
    public Class f4402k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4403l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4404m;

    /* renamed from: n  reason: collision with root package name */
    public j f4405n;

    /* renamed from: o  reason: collision with root package name */
    public com.bumptech.glide.j f4406o;

    /* renamed from: p  reason: collision with root package name */
    public u f4407p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f4408q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4409r;

    public final ArrayList a() {
        boolean z10 = this.f4404m;
        ArrayList arrayList = this.f4393b;
        if (!z10) {
            this.f4404m = true;
            arrayList.clear();
            ArrayList b10 = b();
            int size = b10.size();
            for (int i10 = 0; i10 < size; i10++) {
                h0 h0Var = (h0) b10.get(i10);
                if (!arrayList.contains(h0Var.f7575a)) {
                    arrayList.add(h0Var.f7575a);
                }
                int i11 = 0;
                while (true) {
                    List list = h0Var.f7576b;
                    if (i11 >= list.size()) {
                        break;
                    }
                    if (!arrayList.contains(list.get(i11))) {
                        arrayList.add(list.get(i11));
                    }
                    i11++;
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z10 = this.f4403l;
        ArrayList arrayList = this.f4392a;
        if (!z10) {
            this.f4403l = true;
            arrayList.clear();
            List g10 = this.f4394c.b().g(this.f4395d);
            int size = g10.size();
            for (int i10 = 0; i10 < size; i10++) {
                h0 a10 = ((i0) g10.get(i10)).a(this.f4395d, this.f4396e, this.f4397f, this.f4400i);
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
        }
        return arrayList;
    }

    public final l0 c(Class cls) {
        l0 l0Var;
        com.bumptech.glide.n b10 = this.f4394c.b();
        Class cls2 = this.f4398g;
        Class cls3 = this.f4402k;
        d dVar = b10.f3301i;
        l0 l0Var2 = null;
        m mVar = (m) dVar.f13826b.getAndSet((Object) null);
        if (mVar == null) {
            mVar = new m();
        }
        mVar.f16122a = cls;
        mVar.f16123b = cls2;
        mVar.f16124c = cls3;
        synchronized (dVar.f13825a) {
            l0Var = (l0) dVar.f13825a.getOrDefault(mVar, (Object) null);
        }
        dVar.f13826b.set(mVar);
        b10.f3301i.getClass();
        if (d.f13824c.equals(l0Var)) {
            return null;
        }
        if (l0Var != null) {
            return l0Var;
        }
        ArrayList e10 = b10.e(cls, cls2, cls3);
        if (!e10.isEmpty()) {
            l0Var2 = new l0(cls, cls2, cls3, e10, b10.f3302j);
        }
        b10.f3301i.a(cls, cls2, cls3, l0Var2);
        return l0Var2;
    }

    public final List d() {
        List list;
        com.bumptech.glide.n b10 = this.f4394c.b();
        Class<?> cls = this.f4395d.getClass();
        Class cls2 = this.f4398g;
        Class cls3 = this.f4402k;
        e eVar = b10.f3300h;
        m mVar = (m) eVar.f13827a.getAndSet((Object) null);
        if (mVar == null) {
            mVar = new m(cls, cls2, cls3);
        } else {
            mVar.f16122a = cls;
            mVar.f16123b = cls2;
            mVar.f16124c = cls3;
        }
        synchronized (eVar.f13828b) {
            list = (List) eVar.f13828b.getOrDefault(mVar, (Object) null);
        }
        eVar.f13827a.set(mVar);
        ArrayList arrayList = list;
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = b10.f3293a.r(cls).iterator();
            while (it.hasNext()) {
                Iterator it2 = b10.f3295c.b((Class) it.next(), cls2).iterator();
                while (it2.hasNext()) {
                    Class cls4 = (Class) it2.next();
                    if (!b10.f3298f.b(cls4, cls3).isEmpty() && !arrayList2.contains(cls4)) {
                        arrayList2.add(cls4);
                    }
                }
            }
            b10.f3300h.a(cls, cls2, cls3, Collections.unmodifiableList(arrayList2));
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public final b5.d e(Object obj) {
        b5.d dVar;
        b bVar = this.f4394c.b().f3294b;
        Class<?> cls = obj.getClass();
        synchronized (bVar) {
            Iterator it = bVar.f13822a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dVar = null;
                    break;
                }
                a aVar = (a) it.next();
                if (aVar.f13820a.isAssignableFrom(cls)) {
                    dVar = aVar.f13821b;
                    break;
                }
            }
        }
        if (dVar != null) {
            return dVar;
        }
        throw new com.bumptech.glide.m(2, (Class) obj.getClass());
    }

    public final r f(Class cls) {
        r rVar = (r) this.f4401j.get(cls);
        if (rVar == null) {
            Iterator it = this.f4401j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    rVar = (r) entry.getValue();
                    break;
                }
            }
        }
        if (rVar != null) {
            return rVar;
        }
        if (!this.f4401j.isEmpty() || !this.f4408q) {
            return c.f8808b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
