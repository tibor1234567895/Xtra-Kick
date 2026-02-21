package androidx.lifecycle;

import androidx.activity.h;
import java.util.Map;
import n.b;
import o.d;
import o.g;

public abstract class k0 {

    /* renamed from: k  reason: collision with root package name */
    public static final Object f1718k = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f1719a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final g f1720b = new g();

    /* renamed from: c  reason: collision with root package name */
    public int f1721c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1722d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f1723e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f1724f;

    /* renamed from: g  reason: collision with root package name */
    public int f1725g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1726h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1727i;

    /* renamed from: j  reason: collision with root package name */
    public final h f1728j;

    public k0() {
        Object obj = f1718k;
        this.f1724f = obj;
        this.f1728j = new h(6, this);
        this.f1723e = obj;
        this.f1725g = -1;
    }

    public static void a(String str) {
        if (!b.a().b()) {
            throw new IllegalStateException(android.support.v4.media.h.n("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(j0 j0Var) {
        if (j0Var.f1708i) {
            if (!j0Var.j()) {
                j0Var.c(false);
                return;
            }
            int i10 = j0Var.f1709j;
            int i11 = this.f1725g;
            if (i10 < i11) {
                j0Var.f1709j = i11;
                j0Var.f1707h.b(this.f1723e);
            }
        }
    }

    public final void c(j0 j0Var) {
        if (this.f1726h) {
            this.f1727i = true;
            return;
        }
        this.f1726h = true;
        do {
            this.f1727i = false;
            if (j0Var == null) {
                g gVar = this.f1720b;
                gVar.getClass();
                d dVar = new d(gVar);
                gVar.f11851j.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((j0) ((Map.Entry) dVar.next()).getValue());
                    if (this.f1727i) {
                        break;
                    }
                }
            } else {
                b(j0Var);
                j0Var = null;
            }
        } while (this.f1727i);
        this.f1726h = false;
    }

    public final Object d() {
        Object obj = this.f1723e;
        if (obj != f1718k) {
            return obj;
        }
        return null;
    }

    public final boolean e() {
        return this.f1723e != f1718k;
    }

    public void f(d0 d0Var, p0 p0Var) {
        a("observe");
        if (d0Var.o().b() != s.DESTROYED) {
            LiveData$LifecycleBoundObserver liveData$LifecycleBoundObserver = new LiveData$LifecycleBoundObserver(this, d0Var, p0Var);
            j0 j0Var = (j0) this.f1720b.b(p0Var, liveData$LifecycleBoundObserver);
            if (j0Var != null && !j0Var.i(d0Var)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (j0Var == null) {
                d0Var.o().a(liveData$LifecycleBoundObserver);
            }
        }
    }

    public final void g(p0 p0Var) {
        a("observeForever");
        i0 i0Var = new i0(this, p0Var);
        j0 j0Var = (j0) this.f1720b.b(p0Var, i0Var);
        if (j0Var instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (j0Var == null) {
            i0Var.c(true);
        }
    }

    public void h() {
    }

    public void i() {
    }

    public void j(Object obj) {
        boolean z10;
        synchronized (this.f1719a) {
            z10 = this.f1724f == f1718k;
            this.f1724f = obj;
        }
        if (z10) {
            b.a().c(this.f1728j);
        }
    }

    public final void k(p0 p0Var) {
        a("removeObserver");
        j0 j0Var = (j0) this.f1720b.c(p0Var);
        if (j0Var != null) {
            j0Var.h();
            j0Var.c(false);
        }
    }

    public void l(Object obj) {
        a("setValue");
        this.f1725g++;
        this.f1723e = obj;
        c((j0) null);
    }
}
