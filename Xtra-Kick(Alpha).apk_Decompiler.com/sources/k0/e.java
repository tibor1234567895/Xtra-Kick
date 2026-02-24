package k0;

import android.icu.util.ULocale;
import g.a0;
import java.util.Locale;

public final class e {
    private e() {
    }

    public static ULocale a(Object obj) {
        return ULocale.addLikelySubtags(a0.c(obj));
    }

    public static ULocale b(Locale locale) {
        return ULocale.forLocale(locale);
    }

    public static String c(Object obj) {
        return a0.c(obj).getScript();
    }
}
