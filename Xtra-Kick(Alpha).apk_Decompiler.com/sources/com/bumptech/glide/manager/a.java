package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import w5.p;

public final class a implements l {

    /* renamed from: h  reason: collision with root package name */
    public final Set f3245h = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: i  reason: collision with root package name */
    public boolean f3246i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3247j;

    public final void a() {
        this.f3247j = true;
        Iterator it = p.d(this.f3245h).iterator();
        while (it.hasNext()) {
            ((m) it.next()).k();
        }
    }

    public final void b() {
        this.f3246i = true;
        Iterator it = p.d(this.f3245h).iterator();
        while (it.hasNext()) {
            ((m) it.next()).j();
        }
    }

    public final void c(m mVar) {
        this.f3245h.add(mVar);
        if (this.f3247j) {
            mVar.k();
        } else if (this.f3246i) {
            mVar.j();
        } else {
            mVar.c();
        }
    }

    public final void d() {
        this.f3246i = false;
        Iterator it = p.d(this.f3245h).iterator();
        while (it.hasNext()) {
            ((m) it.next()).c();
        }
    }

    public final void h(m mVar) {
        this.f3245h.remove(mVar);
    }
}
