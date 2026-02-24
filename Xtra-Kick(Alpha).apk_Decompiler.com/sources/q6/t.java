package q6;

import android.os.Bundle;
import android.support.v4.media.h;
import j3.i;
import java.util.Arrays;
import xa.j;

public final class t implements i {

    /* renamed from: b  reason: collision with root package name */
    public static final s f13390b = new s(0);

    /* renamed from: a  reason: collision with root package name */
    public final String[] f13391a;

    public t() {
        this((String[]) null);
    }

    public static final t fromBundle(Bundle bundle) {
        String[] strArr;
        f13390b.getClass();
        j.f("bundle", bundle);
        bundle.setClassLoader(t.class.getClassLoader());
        if (bundle.containsKey("tags")) {
            strArr = bundle.getStringArray("tags");
        } else {
            strArr = null;
        }
        return new t(strArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && j.a(this.f13391a, ((t) obj).f13391a);
    }

    public final int hashCode() {
        String[] strArr = this.f13391a;
        if (strArr == null) {
            return 0;
        }
        return Arrays.hashCode(strArr);
    }

    public final String toString() {
        return h.n("GamesFragmentArgs(tags=", Arrays.toString(this.f13391a), ")");
    }

    public t(String[] strArr) {
        this.f13391a = strArr;
    }
}
