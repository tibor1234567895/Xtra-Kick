package g;

import android.os.PowerManager;
import java.util.Locale;

public final class z {
    private z() {
    }

    public static boolean a(PowerManager powerManager) {
        return powerManager.isPowerSaveMode();
    }

    public static String b(Locale locale) {
        return locale.toLanguageTag();
    }
}
