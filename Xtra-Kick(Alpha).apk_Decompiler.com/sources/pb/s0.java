package pb;

import cb.b;
import cb.l;
import fb.c;
import fb.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import qb.f;
import xa.j;

public final class s0 {
    private s0() {
    }

    public /* synthetic */ s0(int i10) {
        this();
    }

    public static String a(s0 s0Var, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12) {
        String str3;
        String str4 = str;
        String str5 = str2;
        int i13 = i12;
        boolean z14 = false;
        int i14 = (i13 & 1) != 0 ? 0 : i10;
        int length = (i13 & 2) != 0 ? str.length() : i11;
        boolean z15 = (i13 & 8) != 0 ? false : z10;
        boolean z16 = (i13 & 16) != 0 ? false : z11;
        boolean z17 = (i13 & 32) != 0 ? false : z12;
        if ((i13 & 64) == 0) {
            z14 = z13;
        }
        int i15 = 128;
        Charset charset2 = (i13 & 128) != 0 ? null : charset;
        s0Var.getClass();
        j.f("<this>", str4);
        int i16 = i14;
        while (i16 < length) {
            int codePointAt = str4.codePointAt(i16);
            int i17 = 43;
            int i18 = 32;
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= i15 && !z14) || y.o(str5, (char) codePointAt) || ((codePointAt == 37 && (!z15 || (z16 && !c(i16, length, str4)))) || (codePointAt == 43 && z17)))) {
                dc.j jVar = new dc.j();
                jVar.W0(i14, i16, str4);
                dc.j jVar2 = null;
                while (i16 < length) {
                    int codePointAt2 = str4.codePointAt(i16);
                    if (!z15 || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (!(codePointAt2 == i18 && str5 == " !\"#$&'()+,/:;<=>?@[\\]^`{|}~")) {
                            if (codePointAt2 != i17 || !z17) {
                                if (codePointAt2 >= i18 && codePointAt2 != 127) {
                                    if ((codePointAt2 < 128 || z14) && !y.o(str5, (char) codePointAt2) && (codePointAt2 != 37 || (z15 && (!z16 || c(i16, length, str4))))) {
                                        jVar.Y0(codePointAt2);
                                        i16 += Character.charCount(codePointAt2);
                                        i18 = 32;
                                        i17 = 43;
                                    }
                                }
                                if (jVar2 == null) {
                                    jVar2 = new dc.j();
                                }
                                if (charset2 == null || j.a(charset2, c.f5986b)) {
                                    jVar2.Y0(codePointAt2);
                                } else {
                                    jVar2.V0(str4, i16, Character.charCount(codePointAt2) + i16, charset2);
                                }
                                while (!jVar2.R()) {
                                    byte readByte = jVar2.readByte() & 255;
                                    jVar.Q0(37);
                                    char[] cArr = t0.f12988l;
                                    jVar.Q0(cArr[(readByte >> 4) & 15]);
                                    jVar.Q0(cArr[readByte & 15]);
                                }
                                i16 += Character.charCount(codePointAt2);
                                i18 = 32;
                                i17 = 43;
                            } else if (!z15) {
                                str3 = "%2B";
                                jVar.X0(str3);
                            }
                        }
                        str3 = "+";
                        jVar.X0(str3);
                    }
                    i16 += Character.charCount(codePointAt2);
                    i18 = 32;
                    i17 = 43;
                }
                return jVar.j0();
            }
            i16 += Character.charCount(codePointAt);
            i15 = 128;
        }
        String substring = str4.substring(i14, length);
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static int b(String str) {
        j.f("scheme", str);
        if (j.a(str, "http")) {
            return 80;
        }
        return j.a(str, "https") ? 443 : -1;
    }

    public static boolean c(int i10, int i11, String str) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && f.l(str.charAt(i10 + 1)) != -1 && f.l(str.charAt(i12)) != -1;
    }

    public static String d(s0 s0Var, String str, int i10, int i11, boolean z10, int i12) {
        int i13;
        int i14;
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        s0Var.getClass();
        j.f("<this>", str);
        int i15 = i10;
        while (i13 < i11) {
            char charAt = str.charAt(i13);
            if (charAt == '%' || (charAt == '+' && z10)) {
                dc.j jVar = new dc.j();
                jVar.W0(i10, i13, str);
                while (i13 < i11) {
                    int codePointAt = str.codePointAt(i13);
                    if (codePointAt == 37 && (i14 = i13 + 2) < i11) {
                        int l10 = f.l(str.charAt(i13 + 1));
                        int l11 = f.l(str.charAt(i14));
                        if (!(l10 == -1 || l11 == -1)) {
                            jVar.Q0((l10 << 4) + l11);
                            i13 = Character.charCount(codePointAt) + i14;
                        }
                    } else if (codePointAt == 43 && z10) {
                        jVar.Q0(32);
                        i13++;
                    }
                    jVar.Y0(codePointAt);
                    i13 += Character.charCount(codePointAt);
                }
                return jVar.j0();
            }
            i15 = i13 + 1;
        }
        String substring = str.substring(i10, i11);
        j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static ArrayList e(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 <= str.length()) {
            int t10 = y.t(str, '&', i10, false, 4);
            if (t10 == -1) {
                t10 = str.length();
            }
            int t11 = y.t(str, '=', i10, false, 4);
            if (t11 == -1 || t11 > t10) {
                String substring = str.substring(i10, t10);
                j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                arrayList.add(substring);
                str2 = null;
            } else {
                String substring2 = str.substring(i10, t11);
                j.e("this as java.lang.String…ing(startIndex, endIndex)", substring2);
                arrayList.add(substring2);
                str2 = str.substring(t11 + 1, t10);
                j.e("this as java.lang.String…ing(startIndex, endIndex)", str2);
            }
            arrayList.add(str2);
            i10 = t10 + 1;
        }
        return arrayList;
    }

    public static void f(List list, StringBuilder sb2) {
        j.f("<this>", list);
        b b10 = l.b(l.c(0, list.size()), 2);
        int i10 = b10.f3063h;
        int i11 = b10.f3064i;
        int i12 = b10.f3065j;
        if ((i12 > 0 && i10 <= i11) || (i12 < 0 && i11 <= i10)) {
            while (true) {
                String str = (String) list.get(i10);
                String str2 = (String) list.get(i10 + 1);
                if (i10 > 0) {
                    sb2.append('&');
                }
                sb2.append(str);
                if (str2 != null) {
                    sb2.append('=');
                    sb2.append(str2);
                }
                if (i10 != i11) {
                    i10 += i12;
                } else {
                    return;
                }
            }
        }
    }
}
