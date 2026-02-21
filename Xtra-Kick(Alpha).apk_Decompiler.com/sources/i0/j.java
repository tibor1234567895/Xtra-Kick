package i0;

import android.support.v4.media.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public final class j implements k {

    /* renamed from: c  reason: collision with root package name */
    public static final Locale[] f7948c = new Locale[0];

    /* renamed from: a  reason: collision with root package name */
    public final Locale[] f7949a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7950b;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        String[] split = "en-Latn".split("-", -1);
        if (split.length > 2) {
            new Locale(split[0], split[1], split[2]);
        } else if (split.length > 1) {
            new Locale(split[0], split[1]);
        } else if (split.length == 1) {
            new Locale(split[0]);
        } else {
            throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
        }
    }

    public j(Locale... localeArr) {
        String str;
        if (localeArr.length == 0) {
            this.f7949a = f7948c;
            str = "";
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            while (i10 < localeArr.length) {
                Locale locale = localeArr[i10];
                if (locale != null) {
                    if (!hashSet.contains(locale)) {
                        Locale locale2 = (Locale) locale.clone();
                        arrayList.add(locale2);
                        sb2.append(locale2.getLanguage());
                        String country = locale2.getCountry();
                        if (country != null && !country.isEmpty()) {
                            sb2.append('-');
                            sb2.append(locale2.getCountry());
                        }
                        if (i10 < localeArr.length - 1) {
                            sb2.append(Constants.COMMA_CHAR);
                        }
                        hashSet.add(locale2);
                    }
                    i10++;
                } else {
                    throw new NullPointerException(h.j("list[", i10, "] is null"));
                }
            }
            this.f7949a = (Locale[]) arrayList.toArray(new Locale[0]);
            str = sb2.toString();
        }
        this.f7950b = str;
    }

    public final String a() {
        return this.f7950b;
    }

    public final Object b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        Locale[] localeArr = ((j) obj).f7949a;
        Locale[] localeArr2 = this.f7949a;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i10 = 0; i10 < localeArr2.length; i10++) {
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f7949a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    public final int hashCode() {
        int i10 = 1;
        for (Locale hashCode : this.f7949a) {
            i10 = (i10 * 31) + hashCode.hashCode();
        }
        return i10;
    }

    public final boolean isEmpty() {
        return this.f7949a.length == 0;
    }

    public final int size() {
        return this.f7949a.length;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f7949a;
            if (i10 < localeArr.length) {
                sb2.append(localeArr[i10]);
                if (i10 < localeArr.length - 1) {
                    sb2.append(Constants.COMMA_CHAR);
                }
                i10++;
            } else {
                sb2.append("]");
                return sb2.toString();
            }
        }
    }
}
