package i0;

import java.util.Locale;
import k0.f;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Locale[] f7945a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    private g() {
    }

    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean b(Locale locale, Locale locale2) {
        boolean z10;
        boolean z11;
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f7945a;
        int length = localeArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            } else if (localeArr[i10].equals(locale)) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (!z10) {
            int length2 = localeArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    z11 = false;
                    break;
                } else if (localeArr[i11].equals(locale2)) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (!z11) {
                String a10 = f.a(locale);
                if (!a10.isEmpty()) {
                    return a10.equals(f.a(locale2));
                }
                String country = locale.getCountry();
                if (country.isEmpty() || country.equals(locale2.getCountry())) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
