package g1;

import java.util.HashSet;

public final class t0 {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet f6571a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static String f6572b = "media3.common";

    private t0() {
    }

    public static synchronized void a(String str) {
        synchronized (t0.class) {
            if (f6571a.add(str)) {
                f6572b += ", " + str;
            }
        }
    }
}
