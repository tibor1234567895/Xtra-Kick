package h5;

import android.support.v4.media.h;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f7556a;

    public b0(String str) {
        this.f7556a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b0) {
            return this.f7556a.equals(((b0) obj).f7556a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7556a.hashCode();
    }

    public final String toString() {
        return h.p(new StringBuilder("StringHeaderFactory{value='"), this.f7556a, "'}");
    }
}
