package ma;

import java.util.Collections;
import java.util.List;
import na.c;
import xa.j;

public class q {
    public static final c a(c cVar) {
        if (cVar.f11771l == null) {
            cVar.e();
            cVar.f11770k = true;
            return cVar;
        }
        throw new IllegalStateException();
    }

    public static final List b(Object obj) {
        List singletonList = Collections.singletonList(obj);
        j.e("singletonList(element)", singletonList);
        return singletonList;
    }
}
