package l9;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class b implements GenericArrayType, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Type f9755h;

    public b(Type type) {
        this.f9755h = e.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && e.c(this, (GenericArrayType) obj);
    }

    public final Type getGenericComponentType() {
        return this.f9755h;
    }

    public final int hashCode() {
        return this.f9755h.hashCode();
    }

    public final String toString() {
        return e.h(this.f9755h) + "[]";
    }
}
