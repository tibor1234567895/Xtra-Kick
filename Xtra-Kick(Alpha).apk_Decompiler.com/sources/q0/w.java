package q0;

import android.icu.text.DecimalFormatSymbols;
import java.util.Locale;

public final class w {
    private w() {
    }

    public static DecimalFormatSymbols a(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }
}
