package j3;

import java.util.LinkedHashMap;
import xa.j;

public final class p2 {
    private p2() {
    }

    public /* synthetic */ p2(int i10) {
        this();
    }

    public static String a(Class cls) {
        LinkedHashMap linkedHashMap = q2.f8657c;
        String str = (String) linkedHashMap.get(cls);
        if (str == null) {
            l2 l2Var = (l2) cls.getAnnotation(l2.class);
            if (l2Var != null) {
                str = l2Var.value();
            } else {
                str = null;
            }
            if (b(str)) {
                linkedHashMap.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for ".concat(cls.getSimpleName()).toString());
            }
        }
        j.c(str);
        return str;
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.length() > 0;
    }
}
