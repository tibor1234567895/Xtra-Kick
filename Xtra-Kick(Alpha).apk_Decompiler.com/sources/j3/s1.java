package j3;

import android.os.Bundle;
import xa.j;

public final class s1 extends g2 {
    public s1() {
        super(false);
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        Object obj = bundle.get(str);
        j.d("null cannot be cast to non-null type kotlin.Float", obj);
        return (Float) obj;
    }

    public final String b() {
        return "float";
    }

    public final Object c(String str) {
        j.f("value", str);
        return Float.valueOf(Float.parseFloat(str));
    }

    public final void e(Bundle bundle, String str, Object obj) {
        float floatValue = ((Number) obj).floatValue();
        j.f("key", str);
        bundle.putFloat(str, floatValue);
    }
}
