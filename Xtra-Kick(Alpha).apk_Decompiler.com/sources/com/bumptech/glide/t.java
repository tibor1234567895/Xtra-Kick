package com.bumptech.glide;

import u5.e;
import u5.h;
import w5.p;

public abstract class t implements Cloneable {

    /* renamed from: h  reason: collision with root package name */
    public h f3318h = e.f15364b;

    /* renamed from: a */
    public final t clone() {
        try {
            return (t) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof t) {
            return p.b(this.f3318h, ((t) obj).f3318h);
        }
        return false;
    }

    public int hashCode() {
        h hVar = this.f3318h;
        if (hVar != null) {
            return hVar.hashCode();
        }
        return 0;
    }
}
