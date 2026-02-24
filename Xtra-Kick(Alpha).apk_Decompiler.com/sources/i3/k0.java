package i3;

import android.text.Html;
import java.util.regex.Pattern;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f8115a = Pattern.compile("(&#13;)?&#10;");

    private k0() {
    }

    public static String a(CharSequence charSequence) {
        return f8115a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
