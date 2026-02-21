package b5;

import android.support.v4.media.h;
import android.text.TextUtils;
import w5.n;

public final class m {

    /* renamed from: e  reason: collision with root package name */
    public static final k f2630e = new k();

    /* renamed from: a  reason: collision with root package name */
    public final Object f2631a;

    /* renamed from: b  reason: collision with root package name */
    public final l f2632b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2633c;

    /* renamed from: d  reason: collision with root package name */
    public volatile byte[] f2634d;

    public m(String str, Object obj, l lVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f2633c = str;
            this.f2631a = obj;
            n.b(lVar);
            this.f2632b = lVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static m a(String str, Object obj) {
        return new m(str, obj, f2630e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f2633c.equals(((m) obj).f2633c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2633c.hashCode();
    }

    public final String toString() {
        return h.p(new StringBuilder("Option{key='"), this.f2633c, "'}");
    }
}
