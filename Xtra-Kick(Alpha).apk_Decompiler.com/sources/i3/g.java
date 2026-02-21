package i3;

import android.graphics.Color;
import j1.l0;

public final class g {
    private g() {
    }

    public static String a(int i10) {
        return l0.l("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Double.valueOf(((double) Color.alpha(i10)) / 255.0d));
    }
}
