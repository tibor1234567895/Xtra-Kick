package pb;

import fb.w;
import java.util.LinkedHashMap;
import xa.j;

public final class o {
    private o() {
    }

    public /* synthetic */ o(int i10) {
        this();
    }

    public static final p a(o oVar, String str) {
        p pVar = new p(str);
        p.f12912d.put(str, pVar);
        return pVar;
    }

    public final synchronized p b(String str) {
        p pVar;
        String str2;
        j.f("javaName", str);
        LinkedHashMap linkedHashMap = p.f12912d;
        pVar = (p) linkedHashMap.get(str);
        if (pVar == null) {
            if (w.m(str, "TLS_", false)) {
                String substring = str.substring(4);
                j.e("this as java.lang.String).substring(startIndex)", substring);
                str2 = "SSL_".concat(substring);
            } else if (w.m(str, "SSL_", false)) {
                String substring2 = str.substring(4);
                j.e("this as java.lang.String).substring(startIndex)", substring2);
                str2 = "TLS_".concat(substring2);
            } else {
                str2 = str;
            }
            pVar = (p) linkedHashMap.get(str2);
            if (pVar == null) {
                pVar = new p(str);
            }
            linkedHashMap.put(str, pVar);
        }
        return pVar;
    }
}
