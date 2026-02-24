package la;

import java.io.Serializable;
import xa.j;

public final class p implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Object f9809h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f9810i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f9811j;

    public p(Object obj, String str, String str2) {
        this.f9809h = obj;
        this.f9810i = str;
        this.f9811j = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return j.a(this.f9809h, pVar.f9809h) && j.a(this.f9810i, pVar.f9810i) && j.a(this.f9811j, pVar.f9811j);
    }

    public final int hashCode() {
        int i10 = 0;
        Object obj = this.f9809h;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f9810i;
        int hashCode2 = (hashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f9811j;
        if (obj3 != null) {
            i10 = obj3.hashCode();
        }
        return hashCode2 + i10;
    }

    public final String toString() {
        return "(" + this.f9809h + ", " + this.f9810i + ", " + this.f9811j + ')';
    }
}
