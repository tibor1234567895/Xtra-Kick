package xa;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Map;
import wa.l;
import wa.p;
import wa.q;
import wa.r;
import ya.a;
import ya.b;
import ya.c;

public final class y {
    public static Collection a(AbstractCollection abstractCollection) {
        if (!(abstractCollection instanceof a) || (abstractCollection instanceof b)) {
            return abstractCollection;
        }
        d("kotlin.collections.MutableCollection", abstractCollection);
        throw null;
    }

    public static Map b(Map map) {
        if (!(map instanceof a) || (map instanceof c)) {
            return map;
        }
        d("kotlin.collections.MutableMap", map);
        throw null;
    }

    public static void c(int i10, Object obj) {
        int i11;
        if (obj != null) {
            boolean z10 = false;
            if (obj instanceof la.b) {
                if (obj instanceof h) {
                    i11 = ((h) obj).getArity();
                } else if (obj instanceof wa.a) {
                    i11 = 0;
                } else if (obj instanceof l) {
                    i11 = 1;
                } else if (obj instanceof p) {
                    i11 = 2;
                } else if (obj instanceof q) {
                    i11 = 3;
                } else if (obj instanceof r) {
                    i11 = 4;
                } else if (obj instanceof r7.l) {
                    i11 = 5;
                } else {
                    i11 = -1;
                }
                if (i11 == i10) {
                    z10 = true;
                }
            }
            if (!z10) {
                d("kotlin.jvm.functions.Function" + i10, obj);
                throw null;
            }
        }
    }

    public static void d(String str, Object obj) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        ClassCastException classCastException = new ClassCastException(str2 + " cannot be cast to " + str);
        j.j(y.class.getName(), classCastException);
        throw classCastException;
    }
}
