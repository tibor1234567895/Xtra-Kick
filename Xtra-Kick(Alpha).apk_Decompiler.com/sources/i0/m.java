package i0;

import android.os.Trace;

public final class m {
    private m() {
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
