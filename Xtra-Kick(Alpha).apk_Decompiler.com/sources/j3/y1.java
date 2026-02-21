package j3;

import android.os.Bundle;
import java.util.Arrays;
import xa.j;

public final class y1 extends g2 {
    public y1() {
        super(true);
    }

    public final Object a(Bundle bundle, String str) {
        j.f("key", str);
        return (String[]) bundle.get(str);
    }

    public final String b() {
        return "string[]";
    }

    public final Object c(String str) {
        j.f("value", str);
        return new String[]{str};
    }

    public final Object d(String str, Object obj) {
        String[] strArr = (String[]) obj;
        if (strArr != null) {
            String[] strArr2 = {str};
            int length = strArr.length;
            Object[] copyOf = Arrays.copyOf(strArr, length + 1);
            System.arraycopy(strArr2, 0, copyOf, length, 1);
            j.e("result", copyOf);
            return (String[]) copyOf;
        }
        return new String[]{str};
    }

    public final void e(Bundle bundle, String str, Object obj) {
        j.f("key", str);
        bundle.putStringArray(str, (String[]) obj);
    }
}
