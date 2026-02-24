package j3;

import android.os.Bundle;
import java.io.Serializable;
import xa.j;

public class f2 extends g2 {

    /* renamed from: n  reason: collision with root package name */
    public final Class f8534n;

    public f2(Class cls) {
        super(true);
        if (!Serializable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        } else if (true ^ cls.isEnum()) {
            this.f8534n = cls;
        } else {
            throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
        }
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (Serializable) bundle.get(str);
    }

    public String b() {
        return this.f8534n.getName();
    }

    public final void e(Bundle bundle, String str, Object obj) {
        Serializable serializable = (Serializable) obj;
        j.f("key", str);
        j.f("value", serializable);
        this.f8534n.cast(serializable);
        bundle.putSerializable(str, serializable);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        return j.a(this.f8534n, ((f2) obj).f8534n);
    }

    /* renamed from: f */
    public Serializable c(String str) {
        j.f("value", str);
        throw new UnsupportedOperationException("Serializables don't support default values.");
    }

    public final int hashCode() {
        return this.f8534n.hashCode();
    }

    public f2(Class cls, int i10) {
        super(false);
        if (Serializable.class.isAssignableFrom(cls)) {
            this.f8534n = cls;
            return;
        }
        throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
    }
}
