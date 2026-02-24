package androidx.appcompat.widget;

import android.os.LocaleList;
import android.widget.TextView;

public final class n1 {
    private n1() {
    }

    public static LocaleList a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    public static void b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
