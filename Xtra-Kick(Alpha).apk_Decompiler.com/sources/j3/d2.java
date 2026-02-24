package j3;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import xa.j;

public final class d2 extends g2 {

    /* renamed from: n  reason: collision with root package name */
    public final Class f8519n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d2(Class cls) {
        super(true);
        boolean z10 = true;
        if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
            z10 = false;
        }
        if (z10) {
            this.f8519n = cls;
            return;
        }
        throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return bundle.get(str);
    }

    public final String b() {
        return this.f8519n.getName();
    }

    public final Object c(String str) {
        j.f("value", str);
        throw new UnsupportedOperationException("Parcelables don't support default values.");
    }

    public final void e(Bundle bundle, String str, Object obj) {
        j.f("key", str);
        this.f8519n.cast(obj);
        if (obj == null || (obj instanceof Parcelable)) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !j.a(d2.class, obj.getClass())) {
            return false;
        }
        return j.a(this.f8519n, ((d2) obj).f8519n);
    }

    public final int hashCode() {
        return this.f8519n.hashCode();
    }
}
