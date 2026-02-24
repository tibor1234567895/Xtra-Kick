package fb;

import android.support.v4.media.h;
import eb.r;
import java.io.Serializable;
import java.util.regex.Pattern;
import xa.j;

public final class l implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Pattern f6013h;

    static {
        new i(0);
    }

    public l(String str) {
        Pattern compile = Pattern.compile(str);
        j.e("compile(pattern)", compile);
        this.f6013h = compile;
    }

    public static r a(l lVar, String str) {
        j.f("input", str);
        if (str.length() >= 0) {
            j jVar = new j(lVar, str, 0);
            k kVar = k.f6012q;
            j.f("nextFunction", kVar);
            return new r(jVar, kVar);
        }
        StringBuilder r10 = h.r("Start index out of bounds: ", 0, ", input length: ");
        r10.append(str.length());
        throw new IndexOutOfBoundsException(r10.toString());
    }

    public final boolean b(CharSequence charSequence) {
        j.f("input", charSequence);
        return this.f6013h.matcher(charSequence).matches();
    }

    public final String toString() {
        String pattern = this.f6013h.toString();
        j.e("nativePattern.toString()", pattern);
        return pattern;
    }
}
