package j1;

import android.os.Trace;

public final class i0 {
    private i0() {
    }

    public static void a(String str) {
        if (l0.f8453a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void b() {
        if (l0.f8453a >= 18) {
            Trace.endSection();
        }
    }
}
