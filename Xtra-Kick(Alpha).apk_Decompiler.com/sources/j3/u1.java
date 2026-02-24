package j3;

import android.os.Bundle;
import fb.a;
import fb.w;
import xa.j;

public final class u1 extends g2 {
    public u1() {
        super(false);
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        Object obj = bundle.get(str);
        j.d("null cannot be cast to non-null type kotlin.Int", obj);
        return (Integer) obj;
    }

    public final String b() {
        return "integer";
    }

    public final Object c(String str) {
        int i10;
        j.f("value", str);
        if (w.m(str, "0x", false)) {
            String substring = str.substring(2);
            j.e("this as java.lang.String).substring(startIndex)", substring);
            a.a(16);
            i10 = Integer.parseInt(substring, 16);
        } else {
            i10 = Integer.parseInt(str);
        }
        return Integer.valueOf(i10);
    }

    public final void e(Bundle bundle, String str, Object obj) {
        int intValue = ((Number) obj).intValue();
        j.f("key", str);
        bundle.putInt(str, intValue);
    }
}
