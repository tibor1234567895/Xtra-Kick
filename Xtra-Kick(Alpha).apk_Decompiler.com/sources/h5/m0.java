package h5;

import b5.a;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import d5.i0;
import java.util.ArrayList;
import java.util.List;
import w5.n;

public final class m0 implements e, d {

    /* renamed from: h  reason: collision with root package name */
    public final List f7587h;

    /* renamed from: i  reason: collision with root package name */
    public final l0.d f7588i;

    /* renamed from: j  reason: collision with root package name */
    public int f7589j;

    /* renamed from: k  reason: collision with root package name */
    public j f7590k;

    /* renamed from: l  reason: collision with root package name */
    public d f7591l;

    /* renamed from: m  reason: collision with root package name */
    public List f7592m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f7593n;

    public m0(ArrayList arrayList, l0.d dVar) {
        this.f7588i = dVar;
        if (!arrayList.isEmpty()) {
            this.f7587h = arrayList;
            this.f7589j = 0;
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public final Class a() {
        return ((e) this.f7587h.get(0)).a();
    }

    public final void b() {
        if (!this.f7593n) {
            if (this.f7589j < this.f7587h.size() - 1) {
                this.f7589j++;
                f(this.f7590k, this.f7591l);
                return;
            }
            n.b(this.f7592m);
            this.f7591l.e(new i0("Fetch failed", new ArrayList(this.f7592m)));
        }
    }

    public final void c() {
        List list = this.f7592m;
        if (list != null) {
            this.f7588i.e(list);
        }
        this.f7592m = null;
        for (e c10 : this.f7587h) {
            c10.c();
        }
    }

    public final void cancel() {
        this.f7593n = true;
        for (e cancel : this.f7587h) {
            cancel.cancel();
        }
    }

    public final a d() {
        return ((e) this.f7587h.get(0)).d();
    }

    public final void e(Exception exc) {
        List list = this.f7592m;
        n.b(list);
        list.add(exc);
        b();
    }

    public final void f(j jVar, d dVar) {
        this.f7590k = jVar;
        this.f7591l = dVar;
        this.f7592m = (List) this.f7588i.j();
        ((e) this.f7587h.get(this.f7589j)).f(jVar, this);
        if (this.f7593n) {
            cancel();
        }
    }

    public final void g(Object obj) {
        if (obj != null) {
            this.f7591l.g(obj);
        } else {
            b();
        }
    }
}
