package j3;

import android.support.v4.media.h;
import fb.w;
import xa.j;

public final class b2 extends f2 {

    /* renamed from: o  reason: collision with root package name */
    public final Class f8501o;

    public b2(Class cls) {
        super(cls, 0);
        if (cls.isEnum()) {
            this.f8501o = cls;
            return;
        }
        throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
    }

    public final String b() {
        return this.f8501o.getName();
    }

    /* renamed from: g */
    public final Enum f(String str) {
        Enum enumR;
        j.f("value", str);
        Class cls = this.f8501o;
        Object[] enumConstants = cls.getEnumConstants();
        j.e("type.enumConstants", enumConstants);
        int length = enumConstants.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                enumR = null;
                break;
            }
            enumR = enumConstants[i10];
            if (w.g(((Enum) enumR).name(), str)) {
                break;
            }
            i10++;
        }
        Enum enumR2 = enumR;
        if (enumR2 != null) {
            return enumR2;
        }
        StringBuilder s10 = h.s("Enum value ", str, " not found for type ");
        s10.append(cls.getName());
        s10.append('.');
        throw new IllegalArgumentException(s10.toString());
    }
}
