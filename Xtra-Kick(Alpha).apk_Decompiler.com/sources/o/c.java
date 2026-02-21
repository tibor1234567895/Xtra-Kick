package o;

import java.util.Map;

public final class c implements Map.Entry {

    /* renamed from: h  reason: collision with root package name */
    public final Object f11840h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f11841i;

    /* renamed from: j  reason: collision with root package name */
    public c f11842j;

    /* renamed from: k  reason: collision with root package name */
    public c f11843k;

    public c(Object obj, Object obj2) {
        this.f11840h = obj;
        this.f11841i = obj2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11840h.equals(cVar.f11840h) && this.f11841i.equals(cVar.f11841i);
    }

    public final Object getKey() {
        return this.f11840h;
    }

    public final Object getValue() {
        return this.f11841i;
    }

    public final int hashCode() {
        return this.f11840h.hashCode() ^ this.f11841i.hashCode();
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f11840h + Constants.ATTRIBUTE_SEPARATOR + this.f11841i;
    }
}
