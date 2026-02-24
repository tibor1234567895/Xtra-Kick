package a3;

import android.graphics.PointF;
import j1.l0;
import j1.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f117a = Pattern.compile("\\{([^}]*)\\}");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f118b = Pattern.compile(l0.l("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f119c = Pattern.compile(l0.l("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f120d = Pattern.compile("\\\\an(\\d+)");

    public static PointF a(String str) {
        String str2;
        String str3;
        Matcher matcher = f118b.matcher(str);
        Matcher matcher2 = f119c.matcher(str);
        boolean find = matcher.find();
        boolean find2 = matcher2.find();
        if (find) {
            if (find2) {
                v.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
            }
            str2 = matcher.group(1);
            str3 = matcher.group(2);
        } else if (!find2) {
            return null;
        } else {
            str2 = matcher2.group(1);
            str3 = matcher2.group(2);
        }
        str2.getClass();
        float parseFloat = Float.parseFloat(str2.trim());
        str3.getClass();
        return new PointF(parseFloat, Float.parseFloat(str3.trim()));
    }
}
