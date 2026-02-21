package j3;

import android.os.Bundle;
import java.io.Serializable;
import xa.j;

public final class e2 extends g2 {

    /* renamed from: n  reason: collision with root package name */
    public final Class f8524n;

    public e2(Class cls) {
        super(true);
        if (Serializable.class.isAssignableFrom(cls)) {
            try {
                this.f8524n = Class.forName("[L" + cls.getName() + ';');
            } catch (ClassNotFoundException e10) {
                throw new RuntimeException(e10);
            }
        } else {
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (Serializable[]) bundle.get(str);
    }

    public final String b() {
        return this.f8524n.getName();
    }

    public final Object c(String str) {
        j.f("value", str);
        throw new UnsupportedOperationException("Arrays don't support default values.");
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
    public final void e(Bundle bundle, String str, Object obj) {
        ? r42 = (Serializable[]) obj;
        j.f("key", str);
        this.f8524n.cast(r42);
        bundle.putSerializable(str, r42);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !j.a(e2.class, obj.getClass())) {
            return false;
        }
        return j.a(this.f8524n, ((e2) obj).f8524n);
    }

    public final int hashCode() {
        return this.f8524n.hashCode();
    }
}
