package j3;

import android.os.Bundle;
import fb.a;
import fb.w;
import xa.j;

public final class w1 extends g2 {
    public w1() {
        super(false);
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        Object obj = bundle.get(str);
        j.d("null cannot be cast to non-null type kotlin.Long", obj);
        return (Long) obj;
    }

    public final String b() {
        return "long";
    }

    public final Object c(String str) {
        String str2;
        long j10;
        j.f("value", str);
        if (w.f(str, "L", false)) {
            str2 = str.substring(0, str.length() - 1);
            j.e("this as java.lang.String…ing(startIndex, endIndex)", str2);
        } else {
            str2 = str;
        }
        if (w.m(str, "0x", false)) {
            String substring = str2.substring(2);
            j.e("this as java.lang.String).substring(startIndex)", substring);
            a.a(16);
            j10 = Long.parseLong(substring, 16);
        } else {
            j10 = Long.parseLong(str2);
        }
        return Long.valueOf(j10);
    }

    public final void e(Bundle bundle, String str, Object obj) {
        long longValue = ((Number) obj).longValue();
        j.f("key", str);
        bundle.putLong(str, longValue);
    }
}
