package j4;

import m4.v;
import ob.i;
import ob.j;
import s4.m;

public final class d implements j {

    /* renamed from: a  reason: collision with root package name */
    public final int f8739a;

    /* renamed from: b  reason: collision with root package name */
    public final i f8740b;

    public d() {
        this(4, 2);
    }

    public final k a(v vVar, m mVar) {
        return new f(vVar.f10600a, mVar, this.f8740b, this.f8739a);
    }

    public final boolean equals(Object obj) {
        return obj instanceof d;
    }

    public final int hashCode() {
        return d.class.hashCode();
    }

    public d(int i10, int i11) {
        this.f8739a = i11;
        int i12 = j.f12385a;
        this.f8740b = new i(i10, 0);
    }
}
