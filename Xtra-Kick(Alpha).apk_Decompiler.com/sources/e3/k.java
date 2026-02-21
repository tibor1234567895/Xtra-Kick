package e3;

import g1.b1;
import j1.b0;
import j1.l0;
import java.util.regex.Pattern;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f5037a = Pattern.compile("^NOTE([ \t].*)?$");

    private k() {
    }

    public static boolean a(b0 b0Var) {
        String g10 = b0Var.g();
        return g10 != null && g10.startsWith("WEBVTT");
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        int i10 = l0.f8453a;
        String[] split = str.split("\\.", 2);
        long j10 = 0;
        for (String parseLong : split[0].split(Constants.EXT_TAG_END, -1)) {
            j10 = (j10 * 60) + Long.parseLong(parseLong);
        }
        long j11 = j10 * 1000;
        if (split.length == 2) {
            j11 += Long.parseLong(split[1]);
        }
        return j11 * 1000;
    }

    public static void d(b0 b0Var) {
        int i10 = b0Var.f8415b;
        if (!a(b0Var)) {
            b0Var.G(i10);
            throw b1.a("Expected WEBVTT. Got " + b0Var.g(), (Exception) null);
        }
    }
}
