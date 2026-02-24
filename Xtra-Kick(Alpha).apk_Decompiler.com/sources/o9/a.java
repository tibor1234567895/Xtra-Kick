package o9;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import l9.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Class f12361a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f12362b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12363c;

    public a() {
        Type genericSuperclass = a.class.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            Type a10 = e.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            this.f12362b = a10;
            this.f12361a = e.e(a10);
            this.f12363c = a10.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            if (e.c(this.f12362b, ((a) obj).f12362b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f12363c;
    }

    public final String toString() {
        return e.h(this.f12362b);
    }

    public a(Type type) {
        type.getClass();
        Type a10 = e.a(type);
        this.f12362b = a10;
        this.f12361a = e.e(a10);
        this.f12363c = a10.hashCode();
    }
}
