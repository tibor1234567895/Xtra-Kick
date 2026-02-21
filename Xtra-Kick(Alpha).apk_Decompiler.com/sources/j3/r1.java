package j3;

import android.os.Bundle;
import java.util.Arrays;
import xa.j;

public final class r1 extends g2 {
    public r1() {
        super(true);
    }

    public static float[] f(String str) {
        j.f("value", str);
        return new float[]{((Number) g2.f8545h.c(str)).floatValue()};
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (float[]) bundle.get(str);
    }

    public final String b() {
        return "float[]";
    }

    public final /* bridge */ /* synthetic */ Object c(String str) {
        return f(str);
    }

    public final Object d(String str, Object obj) {
        float[] fArr = (float[]) obj;
        if (fArr == null) {
            return f(str);
        }
        float[] f10 = f(str);
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        System.arraycopy(f10, 0, copyOf, length, 1);
        j.e("result", copyOf);
        return copyOf;
    }

    public final void e(Bundle bundle, String str, Object obj) {
        j.f("key", str);
        bundle.putFloatArray(str, (float[]) obj);
    }
}
