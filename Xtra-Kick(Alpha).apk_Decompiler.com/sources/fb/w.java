package fb;

import cb.e;
import java.util.Collection;
import java.util.Iterator;
import ma.f0;
import xa.j;

public class w extends v {
    public static final boolean f(String str, String str2, boolean z10) {
        j.f("<this>", str);
        j.f("suffix", str2);
        return !z10 ? str.endsWith(str2) : i(str.length() - str2.length(), 0, str2.length(), str, str2, true);
    }

    public static final boolean g(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final boolean h(CharSequence charSequence) {
        boolean z10;
        j.f("<this>", charSequence);
        if (charSequence.length() == 0) {
            return true;
        }
        e eVar = new e(0, charSequence.length() - 1);
        if (!(eVar instanceof Collection) || !((Collection) eVar).isEmpty()) {
            Iterator it = eVar.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!a.b(charSequence.charAt(((f0) it).a()))) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z10 = true;
        if (z10) {
            return true;
        }
        return false;
    }

    public static final boolean i(int i10, int i11, int i12, String str, String str2, boolean z10) {
        j.f("<this>", str);
        j.f("other", str2);
        return !z10 ? str.regionMatches(i10, str2, i11, i12) : str.regionMatches(z10, i10, str2, i11, i12);
    }

    public static String j(String str, char c10, char c11) {
        String replace = str.replace(c10, c11);
        j.e("this as java.lang.String…replace(oldChar, newChar)", replace);
        return replace;
    }

    public static String k(String str, String str2, String str3) {
        j.f("<this>", str);
        j.f("newValue", str3);
        int r10 = y.r(0, str, str2, false);
        if (r10 < 0) {
            return str;
        }
        int length = str2.length();
        int i10 = 1;
        if (length >= 1) {
            i10 = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            int i11 = 0;
            do {
                sb2.append(str, i11, r10);
                sb2.append(str3);
                i11 = r10 + length;
                if (r10 >= str.length() || (r10 = y.r(r10 + i10, str, str2, false)) <= 0) {
                    sb2.append(str, i11, str.length());
                    String sb3 = sb2.toString();
                    j.e("stringBuilder.append(this, i, length).toString()", sb3);
                }
                sb2.append(str, i11, r10);
                sb2.append(str3);
                i11 = r10 + length;
                break;
            } while ((r10 = y.r(r10 + i10, str, str2, false)) <= 0);
            sb2.append(str, i11, str.length());
            String sb32 = sb2.toString();
            j.e("stringBuilder.append(this, i, length).toString()", sb32);
            return sb32;
        }
        throw new OutOfMemoryError();
    }

    public static final boolean l(String str, String str2, int i10, boolean z10) {
        j.f("<this>", str);
        if (!z10) {
            return str.startsWith(str2, i10);
        }
        return i(i10, 0, str2.length(), str, str2, z10);
    }

    public static final boolean m(String str, String str2, boolean z10) {
        j.f("<this>", str);
        j.f("prefix", str2);
        return !z10 ? str.startsWith(str2) : i(0, 0, str2.length(), str, str2, z10);
    }
}
