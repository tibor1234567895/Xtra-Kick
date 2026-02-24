package g;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import java.util.Locale;

public final class y {
    private y() {
    }

    public static Context a(Context context, Configuration configuration) {
        return context.createConfigurationContext(configuration);
    }

    public static int b(Configuration configuration) {
        return configuration.getLayoutDirection();
    }

    public static void c(Configuration configuration, Locale locale) {
        configuration.setLayoutDirection(locale);
    }

    public static void d(View view, int i10) {
        view.setLayoutDirection(i10);
    }

    public static void e(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }
}
