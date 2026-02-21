package j3;

import android.os.Bundle;
import java.util.Arrays;
import xa.j;

public final class t1 extends g2 {
    public t1() {
        super(true);
    }

    public static int[] f(String str) {
        j.f("value", str);
        return new int[]{((Number) g2.f8540c.c(str)).intValue()};
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (int[]) bundle.get(str);
    }

    public final String b() {
        return "integer[]";
    }

    public final /* bridge */ /* synthetic */ Object c(String str) {
        return f(str);
    }

    public final Object d(String str, Object obj) {
        int[] iArr = (int[]) obj;
        if (iArr == null) {
            return f(str);
        }
        int[] f10 = f(str);
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        System.arraycopy(f10, 0, copyOf, length, 1);
        j.e("result", copyOf);
        return copyOf;
    }

    public final void e(Bundle bundle, String str, Object obj) {
        j.f("key", str);
        bundle.putIntArray(str, (int[]) obj);
    }
}
