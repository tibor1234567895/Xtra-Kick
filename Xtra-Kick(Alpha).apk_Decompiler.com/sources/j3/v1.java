package j3;

import android.os.Bundle;
import java.util.Arrays;
import xa.j;

public final class v1 extends g2 {
    public v1() {
        super(true);
    }

    public static long[] f(String str) {
        j.f("value", str);
        return new long[]{((Number) g2.f8543f.c(str)).longValue()};
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (long[]) bundle.get(str);
    }

    public final String b() {
        return "long[]";
    }

    public final /* bridge */ /* synthetic */ Object c(String str) {
        return f(str);
    }

    public final Object d(String str, Object obj) {
        long[] jArr = (long[]) obj;
        if (jArr == null) {
            return f(str);
        }
        long[] f10 = f(str);
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        System.arraycopy(f10, 0, copyOf, length, 1);
        j.e("result", copyOf);
        return copyOf;
    }

    public final void e(Bundle bundle, String str, Object obj) {
        j.f("key", str);
        bundle.putLongArray(str, (long[]) obj);
    }
}
