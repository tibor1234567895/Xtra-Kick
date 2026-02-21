package fb;

import android.support.v4.media.h;
import xa.j;

public class a0 extends z {
    public static final String S(int i10, String str) {
        boolean z10;
        j.f("<this>", str);
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int length = str.length();
            if (i10 > length) {
                i10 = length;
            }
            String substring = str.substring(0, i10);
            j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
            return substring;
        }
        throw new IllegalArgumentException(h.j("Requested character count ", i10, " is less than zero.").toString());
    }

    public static final String T(String str) {
        int length = str.length();
        int i10 = 2;
        if (2 > length) {
            i10 = length;
        }
        String substring = str.substring(length - i10);
        j.e("this as java.lang.String).substring(startIndex)", substring);
        return substring;
    }
}
