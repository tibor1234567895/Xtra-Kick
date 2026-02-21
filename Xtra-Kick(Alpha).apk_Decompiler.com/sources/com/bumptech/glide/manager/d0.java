package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import t5.g;
import w5.p;

public final class d0 implements m {

    /* renamed from: h  reason: collision with root package name */
    public final Set f3263h = Collections.newSetFromMap(new WeakHashMap());

    public final void c() {
        Iterator it = p.d(this.f3263h).iterator();
        while (it.hasNext()) {
            ((g) it.next()).c();
        }
    }

    public final void j() {
        Iterator it = p.d(this.f3263h).iterator();
        while (it.hasNext()) {
            ((g) it.next()).j();
        }
    }

    public final void k() {
        Iterator it = p.d(this.f3263h).iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
    }
}
