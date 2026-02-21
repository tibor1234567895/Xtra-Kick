package j3;

import android.os.Bundle;
import android.os.Parcelable;
import xa.j;

public final class c2 extends g2 {

    /* renamed from: n  reason: collision with root package name */
    public final Class f8515n;

    public c2(Class cls) {
        super(true);
        if (Parcelable.class.isAssignableFrom(cls)) {
            try {
                this.f8515n = Class.forName("[L" + cls.getName() + ';');
            } catch (ClassNotFoundException e10) {
                throw new RuntimeException(e10);
            }
        } else {
            throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
        }
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (Parcelable[]) bundle.get(str);
    }

    public final String b() {
        return this.f8515n.getName();
    }

    public final Object c(String str) {
        j.f("value", str);
        throw new UnsupportedOperationException("Arrays don't support default values.");
    }

    public final void e(Bundle bundle, String str, Object obj) {
        Parcelable[] parcelableArr = (Parcelable[]) obj;
        j.f("key", str);
        this.f8515n.cast(parcelableArr);
        bundle.putParcelableArray(str, parcelableArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !j.a(c2.class, obj.getClass())) {
            return false;
        }
        return j.a(this.f8515n, ((c2) obj).f8515n);
    }

    public final int hashCode() {
        return this.f8515n.hashCode();
    }
}
