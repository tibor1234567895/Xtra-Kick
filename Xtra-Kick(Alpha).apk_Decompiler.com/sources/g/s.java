package g;

import android.os.LocaleList;
import androidx.activity.j;

public final class s {
    private s() {
    }

    public static LocaleList a(Object obj) {
        return j.b(obj).getApplicationLocales();
    }

    public static void b(Object obj, LocaleList localeList) {
        j.b(obj).setApplicationLocales(localeList);
    }
}
