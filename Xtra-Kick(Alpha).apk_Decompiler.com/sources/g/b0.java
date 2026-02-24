package g;

import android.content.res.Configuration;
import android.os.LocaleList;
import i0.i;

public final class b0 {
    private b0() {
    }

    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList g10 = configuration.getLocales();
        LocaleList g11 = configuration2.getLocales();
        if (!g10.equals(g11)) {
            configuration3.setLocales(g11);
            configuration3.locale = configuration2.locale;
        }
    }

    public static i b(Configuration configuration) {
        return i.b(configuration.getLocales().toLanguageTags());
    }

    public static void c(i iVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(iVar.e()));
    }

    public static void d(Configuration configuration, i iVar) {
        configuration.setLocales(LocaleList.forLanguageTags(iVar.e()));
    }
}
