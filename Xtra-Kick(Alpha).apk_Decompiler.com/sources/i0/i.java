package i0;

import android.os.Build;
import java.util.Locale;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    public static final i f7946b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    public final k f7947a;

    public i(k kVar) {
        this.f7947a = kVar;
    }

    public static i a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new i(new l(h.a(localeArr)));
        }
        return new i(new j(localeArr));
    }

    public static i b(String str) {
        if (str == null || str.isEmpty()) {
            return f7946b;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = g.a(split[i10]);
        }
        return a(localeArr);
    }

    public final Locale c(int i10) {
        return this.f7947a.get(i10);
    }

    public final boolean d() {
        return this.f7947a.isEmpty();
    }

    public final String e() {
        return this.f7947a.a();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            if (this.f7947a.equals(((i) obj).f7947a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7947a.hashCode();
    }

    public final String toString() {
        return this.f7947a.toString();
    }
}
