package pb;

import fb.w;
import hb.h0;
import java.nio.charset.Charset;
import xa.j;

public final class x0 {

    /* renamed from: d  reason: collision with root package name */
    public static final w0 f13023d = new w0(0);

    /* renamed from: a  reason: collision with root package name */
    public final String f13024a;

    /* renamed from: b  reason: collision with root package name */
    public final String f13025b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f13026c;

    public x0(String str, String str2, String str3, String[] strArr) {
        j.f("mediaType", str);
        this.f13024a = str;
        this.f13025b = str2;
        this.f13026c = strArr;
    }

    public final Charset a(Charset charset) {
        String str;
        String[] strArr = this.f13026c;
        int i10 = 0;
        int B0 = h0.B0(0, strArr.length - 1, 2);
        if (B0 >= 0) {
            while (true) {
                if (!w.g(strArr[i10], "charset")) {
                    if (i10 == B0) {
                        break;
                    }
                    i10 += 2;
                } else {
                    str = strArr[i10 + 1];
                    break;
                }
            }
        }
        str = null;
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x0) || !j.a(((x0) obj).f13024a, this.f13024a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f13024a.hashCode();
    }

    public final String toString() {
        return this.f13024a;
    }
}
