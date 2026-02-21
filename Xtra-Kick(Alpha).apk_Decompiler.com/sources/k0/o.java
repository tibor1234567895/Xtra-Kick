package k0;

import android.text.TextUtils;
import java.util.Locale;

public final class o {
    private o() {
    }

    public static int a(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
