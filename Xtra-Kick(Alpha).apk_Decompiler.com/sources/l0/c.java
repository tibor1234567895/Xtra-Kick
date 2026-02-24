package l0;

import android.os.Parcelable;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f9498a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f9499b;

    public c(Object obj, Parcelable parcelable) {
        this.f9498a = obj;
        this.f9499b = parcelable;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!b.a(cVar.f9498a, this.f9498a) || !b.a(cVar.f9499b, this.f9499b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i10 = 0;
        Object obj = this.f9498a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f9499b;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return i10 ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.f9498a + " " + this.f9499b + "}";
    }
}
