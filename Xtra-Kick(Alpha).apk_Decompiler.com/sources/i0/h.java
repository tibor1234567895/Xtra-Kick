package i0;

import android.os.LocaleList;
import g.a0;
import java.util.Locale;

public final class h {
    private h() {
    }

    public static LocaleList a(Locale... localeArr) {
        a0.t();
        return a0.j(localeArr);
    }

    public static LocaleList b() {
        return LocaleList.getAdjustedDefault();
    }

    public static LocaleList c() {
        return LocaleList.getDefault();
    }
}
