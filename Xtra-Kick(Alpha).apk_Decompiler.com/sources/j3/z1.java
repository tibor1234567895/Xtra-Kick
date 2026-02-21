package j3;

import android.os.Bundle;
import xa.j;

public final class z1 extends g2 {
    public z1() {
        super(true);
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (String) bundle.get(str);
    }

    public final String b() {
        return "string";
    }

    public final Object c(String str) {
        j.f("value", str);
        if (j.a(str, "null")) {
            return null;
        }
        return str;
    }

    public final void e(Bundle bundle, String str, Object obj) {
        j.f("key", str);
        bundle.putString(str, (String) obj);
    }
}
