package j3;

import android.os.Bundle;
import java.util.Arrays;
import xa.j;

public final class p1 extends g2 {
    public p1() {
        super(true);
    }

    public static boolean[] f(String str) {
        j.f("value", str);
        return new boolean[]{((Boolean) g2.f8547j.c(str)).booleanValue()};
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (boolean[]) bundle.get(str);
    }

    public final String b() {
        return "boolean[]";
    }

    public final /* bridge */ /* synthetic */ Object c(String str) {
        return f(str);
    }

    public final Object d(String str, Object obj) {
        boolean[] zArr = (boolean[]) obj;
        if (zArr == null) {
            return f(str);
        }
        boolean[] f10 = f(str);
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        System.arraycopy(f10, 0, copyOf, length, 1);
        j.e("result", copyOf);
        return copyOf;
    }

    public final void e(Bundle bundle, String str, Object obj) {
        j.f("key", str);
        bundle.putBooleanArray(str, (boolean[]) obj);
    }
}
