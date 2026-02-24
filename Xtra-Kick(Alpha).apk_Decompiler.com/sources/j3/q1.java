package j3;

import android.os.Bundle;
import xa.j;

public final class q1 extends g2 {
    public q1() {
        super(false);
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (Boolean) bundle.get(str);
    }

    public final String b() {
        return "boolean";
    }

    public final Object c(String str) {
        boolean z10;
        j.f("value", str);
        if (j.a(str, "true")) {
            z10 = true;
        } else if (j.a(str, "false")) {
            z10 = false;
        } else {
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }
        return Boolean.valueOf(z10);
    }

    public final void e(Bundle bundle, String str, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        j.f("key", str);
        bundle.putBoolean(str, booleanValue);
    }
}
