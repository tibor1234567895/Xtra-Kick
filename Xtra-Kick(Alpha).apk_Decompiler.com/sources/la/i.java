package la;

import java.io.Serializable;
import xa.j;

public final class i implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Object f9799h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f9800i;

    public i(Object obj, Object obj2) {
        this.f9799h = obj;
        this.f9800i = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return j.a(this.f9799h, iVar.f9799h) && j.a(this.f9800i, iVar.f9800i);
    }

    public final int hashCode() {
        int i10 = 0;
        Object obj = this.f9799h;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f9800i;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return hashCode + i10;
    }

    public final String toString() {
        return "(" + this.f9799h + ", " + this.f9800i + ')';
    }
}
