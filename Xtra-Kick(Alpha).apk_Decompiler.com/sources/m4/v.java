package m4;

import j4.e0;
import s.i;
import xa.j;

public final class v extends i {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f10600a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10601b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10602c;

    public v(e0 e0Var, String str, int i10) {
        super(0);
        this.f10600a = e0Var;
        this.f10601b = str;
        this.f10602c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            return j.a(this.f10600a, vVar.f10600a) && j.a(this.f10601b, vVar.f10601b) && this.f10602c == vVar.f10602c;
        }
    }

    public final int hashCode() {
        int hashCode = this.f10600a.hashCode() * 31;
        String str = this.f10601b;
        return i.a(this.f10602c) + ((hashCode + (str != null ? str.hashCode() : 0)) * 31);
    }
}
