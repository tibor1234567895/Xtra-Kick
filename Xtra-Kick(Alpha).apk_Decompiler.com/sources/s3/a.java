package s3;

import fb.y;
import xa.j;

public final class a {
    private a() {
    }

    public /* synthetic */ a(int i10) {
        this();
    }

    public static boolean a(String str, String str2) {
        boolean z10;
        boolean z11;
        j.f("current", str);
        if (j.a(str, str2)) {
            return true;
        }
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i10 < str.length()) {
                    char charAt = str.charAt(i10);
                    int i13 = i12 + 1;
                    if (i12 == 0 && charAt != '(') {
                        break;
                    }
                    if (charAt != '(') {
                        if (charAt == ')' && i11 - 1 == 0 && i12 != str.length() - 1) {
                            break;
                        }
                    } else {
                        i11++;
                    }
                    i10++;
                    i12 = i13;
                } else if (i11 == 0) {
                    z11 = true;
                }
            }
        }
        z11 = false;
        if (!z11) {
            return false;
        }
        String substring = str.substring(1, str.length() - 1);
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return j.a(y.R(substring).toString(), str2);
    }
}
