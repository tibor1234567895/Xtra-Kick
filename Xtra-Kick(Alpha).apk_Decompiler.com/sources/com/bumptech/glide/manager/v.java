package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import s5.d;
import w5.p;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final Set f3284a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f3285b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public boolean f3286c;

    public final boolean a(d dVar) {
        boolean z10 = true;
        if (dVar == null) {
            return true;
        }
        boolean remove = this.f3284a.remove(dVar);
        if (!this.f3285b.remove(dVar) && !remove) {
            z10 = false;
        }
        if (z10) {
            dVar.clear();
        }
        return z10;
    }

    public final void b() {
        Iterator it = p.d(this.f3284a).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!dVar.j() && !dVar.b()) {
                dVar.clear();
                if (!this.f3286c) {
                    dVar.e();
                } else {
                    this.f3285b.add(dVar);
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f3284a.size() + ", isPaused=" + this.f3286c + "}";
    }
}
