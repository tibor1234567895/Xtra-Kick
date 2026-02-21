package j4;

import s4.m;

public final class v implements j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8791a;

    public v() {
        this(true);
    }

    public final k a(m4.v vVar, m mVar) {
        int i10 = i.f8763a;
        if (!t.a(vVar.f10600a.v())) {
            return null;
        }
        return new w(vVar.f10600a, mVar, this.f8791a);
    }

    public final boolean equals(Object obj) {
        return obj instanceof v;
    }

    public final int hashCode() {
        return v.class.hashCode();
    }

    public v(boolean z10) {
        this.f8791a = z10;
    }
}
