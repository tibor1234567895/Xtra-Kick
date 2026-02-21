package fb;

import android.support.v4.media.h;
import androidx.fragment.app.k;
import cb.b;
import cb.c;
import cb.e;
import eb.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ma.p;
import ma.q;
import ma.s;
import xa.j;

public class y extends w {
    public static final boolean A(CharSequence charSequence, int i10, CharSequence charSequence2, int i11, int i12, boolean z10) {
        j.f("<this>", charSequence);
        j.f("other", charSequence2);
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > charSequence2.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.c(charSequence.charAt(i10 + i13), charSequence2.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final String B(String str, String str2) {
        if (!H(str2, str)) {
            return str2;
        }
        String substring = str2.substring(str.length());
        j.e("this as java.lang.String).substring(startIndex)", substring);
        return substring;
    }

    public static final void C(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.i("Limit must be non-negative, but was ", i10).toString());
        }
    }

    public static final List D(int i10, CharSequence charSequence, String str, boolean z10) {
        C(i10);
        int i11 = 0;
        int r10 = r(0, charSequence, str, z10);
        if (r10 == -1 || i10 == 1) {
            return q.b(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        int i12 = 10;
        if (z11 && i10 <= 10) {
            i12 = i10;
        }
        ArrayList arrayList = new ArrayList(i12);
        do {
            arrayList.add(charSequence.subSequence(i11, r10).toString());
            i11 = str.length() + r10;
            if ((z11 && arrayList.size() == i10 - 1) || (r10 = r(i11, charSequence, str, z10)) == -1) {
                arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i11, r10).toString());
            i11 = str.length() + r10;
            break;
        } while ((r10 = r(i11, charSequence, str, z10)) == -1);
        arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
        return arrayList;
    }

    public static List E(CharSequence charSequence, char[] cArr) {
        j.f("<this>", charSequence);
        if (cArr.length == 1) {
            return D(0, charSequence, String.valueOf(cArr[0]), false);
        }
        C(0);
        o oVar = new o(new e(charSequence, 0, 0, new x(0, cArr, false)));
        ArrayList arrayList = new ArrayList(s.i(oVar));
        Iterator it = oVar.iterator();
        while (it.hasNext()) {
            arrayList.add(I(charSequence, (e) it.next()));
        }
        return arrayList;
    }

    public static List F(String str, String[] strArr) {
        j.f("<this>", str);
        boolean z10 = true;
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                return D(0, str, str2, false);
            }
        }
        o oVar = new o(z(str, strArr, false, 0));
        ArrayList arrayList = new ArrayList(s.i(oVar));
        Iterator it = oVar.iterator();
        while (it.hasNext()) {
            arrayList.add(I(str, (e) it.next()));
        }
        return arrayList;
    }

    public static boolean G(CharSequence charSequence, char c10) {
        j.f("<this>", charSequence);
        if (charSequence.length() <= 0 || !b.c(charSequence.charAt(0), c10, false)) {
            return false;
        }
        return true;
    }

    public static boolean H(CharSequence charSequence, String str) {
        if (charSequence instanceof String) {
            return w.m((String) charSequence, str, false);
        }
        return A(charSequence, 0, str, 0, str.length(), false);
    }

    public static final String I(CharSequence charSequence, e eVar) {
        j.f("<this>", charSequence);
        j.f("range", eVar);
        return charSequence.subSequence(Integer.valueOf(eVar.f3063h).intValue(), Integer.valueOf(eVar.f3064i).intValue() + 1).toString();
    }

    public static final String J(String str, String str2, String str3) {
        j.f("<this>", str);
        j.f("delimiter", str2);
        j.f("missingDelimiterValue", str3);
        int u10 = u(str, str2, 0, false, 6);
        if (u10 == -1) {
            return str3;
        }
        String substring = str.substring(str2.length() + u10, str.length());
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static final String K(String str, char c10, String str2) {
        j.f("<this>", str);
        j.f("missingDelimiterValue", str2);
        int w10 = w(str, c10, 0, 6);
        if (w10 == -1) {
            return str2;
        }
        String substring = str.substring(w10 + 1, str.length());
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static String L(String str, String str2) {
        int x10 = x(str, str2, 6);
        if (x10 == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + x10, str.length());
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static final String M(String str, String str2, String str3) {
        j.f("<this>", str);
        j.f("missingDelimiterValue", str3);
        int u10 = u(str, str2, 0, false, 6);
        if (u10 == -1) {
            return str3;
        }
        String substring = str.substring(0, u10);
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static String N(String str, char c10) {
        int t10 = t(str, c10, 0, false, 6);
        if (t10 == -1) {
            return str;
        }
        String substring = str.substring(0, t10);
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static final String P(String str, String str2, String str3) {
        j.f("missingDelimiterValue", str3);
        int x10 = x(str, str2, 6);
        if (x10 == -1) {
            return str3;
        }
        String substring = str.substring(0, x10);
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static String Q(String str, char c10) {
        j.f("<this>", str);
        j.f("missingDelimiterValue", str);
        int w10 = w(str, c10, 0, 6);
        if (w10 == -1) {
            return str;
        }
        String substring = str.substring(0, w10);
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static final CharSequence R(CharSequence charSequence) {
        j.f("<this>", charSequence);
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean b10 = a.b(charSequence.charAt(!z10 ? i10 : length));
            if (!z10) {
                if (!b10) {
                    z10 = true;
                } else {
                    i10++;
                }
            } else if (!b10) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final boolean n(CharSequence charSequence, String str, boolean z10) {
        j.f("<this>", charSequence);
        return u(charSequence, str, 0, z10, 2) >= 0;
    }

    public static boolean o(CharSequence charSequence, char c10) {
        j.f("<this>", charSequence);
        if (t(charSequence, c10, 0, false, 2) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean p(String str, char c10) {
        return str.length() > 0 && b.c(str.charAt(q(str)), c10, false);
    }

    public static final int q(CharSequence charSequence) {
        j.f("<this>", charSequence);
        return charSequence.length() - 1;
    }

    public static final int r(int i10, CharSequence charSequence, String str, boolean z10) {
        j.f("<this>", charSequence);
        j.f("string", str);
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i10);
        }
        return s(charSequence, str, i10, charSequence.length(), z10, false);
    }

    public static final int s(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        b bVar;
        if (!z11) {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = charSequence.length();
            if (i11 > length) {
                i11 = length;
            }
            bVar = new e(i10, i11);
        } else {
            int q10 = q(charSequence);
            if (i10 > q10) {
                i10 = q10;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            b.f3062k.getClass();
            bVar = new b(i10, i11, -1);
        }
        boolean z12 = charSequence instanceof String;
        int i12 = bVar.f3063h;
        int i13 = bVar.f3065j;
        int i14 = bVar.f3064i;
        if (!z12 || !(charSequence2 instanceof String)) {
            if ((i13 > 0 && i12 <= i14) || (i13 < 0 && i14 <= i12)) {
                while (true) {
                    if (!A(charSequence2, 0, charSequence, i12, charSequence2.length(), z10)) {
                        if (i12 == i14) {
                            break;
                        }
                        i12 += i13;
                    } else {
                        return i12;
                    }
                }
            }
        } else if ((i13 > 0 && i12 <= i14) || (i13 < 0 && i14 <= i12)) {
            while (true) {
                if (!w.i(0, i12, charSequence2.length(), (String) charSequence2, (String) charSequence, z10)) {
                    if (i12 == i14) {
                        break;
                    }
                    i12 += i13;
                } else {
                    return i12;
                }
            }
        }
        return -1;
    }

    public static int t(CharSequence charSequence, char c10, int i10, boolean z10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        j.f("<this>", charSequence);
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c10, i10);
        }
        return v(i10, charSequence, z10, new char[]{c10});
    }

    public static /* synthetic */ int u(CharSequence charSequence, String str, int i10, boolean z10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return r(i10, charSequence, str, z10);
    }

    public static final int v(int i10, CharSequence charSequence, boolean z10, char[] cArr) {
        boolean z11;
        j.f("<this>", charSequence);
        j.f("chars", cArr);
        if (z10 || cArr.length != 1 || !(charSequence instanceof String)) {
            if (i10 < 0) {
                i10 = 0;
            }
            c a10 = new e(i10, q(charSequence)).iterator();
            while (a10.f3068j) {
                int a11 = a10.a();
                char charAt = charSequence.charAt(a11);
                int length = cArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z11 = false;
                        continue;
                        break;
                    } else if (b.c(cArr[i11], charAt, z10)) {
                        z11 = true;
                        continue;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    return a11;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(p.i(cArr), i10);
    }

    public static int w(CharSequence charSequence, char c10, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = q(charSequence);
        }
        j.f("<this>", charSequence);
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c10, i10);
        }
        char[] cArr = {c10};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(p.i(cArr), i10);
        }
        int q10 = q(charSequence);
        if (i10 > q10) {
            i10 = q10;
        }
        while (-1 < i10) {
            if (b.c(cArr[0], charSequence.charAt(i10), false)) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static int x(CharSequence charSequence, String str, int i10) {
        int i11;
        if ((i10 & 2) != 0) {
            i11 = q(charSequence);
        } else {
            i11 = 0;
        }
        j.f("<this>", charSequence);
        j.f("string", str);
        if (!(charSequence instanceof String)) {
            return s(charSequence, str, i11, 0, false, true);
        }
        return ((String) charSequence).lastIndexOf(str, i11);
    }

    public static final List y(CharSequence charSequence) {
        j.f("<this>", charSequence);
        return eb.q.d(eb.q.c(z(charSequence, new String[]{"\r\n", Constants.WRITE_NEW_LINE, "\r"}, false, 0), new k(19, charSequence)));
    }

    public static e z(CharSequence charSequence, String[] strArr, boolean z10, int i10) {
        C(i10);
        return new e(charSequence, 0, i10, new x(1, ma.o.b(strArr), z10));
    }
}
