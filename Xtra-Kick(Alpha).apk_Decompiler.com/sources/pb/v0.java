package pb;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import xb.s;

public final class v0 implements z {

    /* renamed from: b  reason: collision with root package name */
    public final CookieHandler f13005b;

    public v0(CookieManager cookieManager) {
        this.f13005b = cookieManager;
    }

    public static ArrayList c(t0 t0Var, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int delimiterOffset = Util.delimiterOffset(str, i10, length, ";,");
            int delimiterOffset2 = Util.delimiterOffset(str, i10, delimiterOffset, '=');
            String trimSubstring = Util.trimSubstring(str, i10, delimiterOffset2);
            if (!trimSubstring.startsWith("$")) {
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (trimSubstring2.startsWith("\"") && trimSubstring2.endsWith("\"")) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                }
                u uVar = new u();
                uVar.c(trimSubstring);
                uVar.d(trimSubstring2);
                uVar.b(t0Var.f());
                arrayList.add(uVar.a());
            }
            i10 = delimiterOffset + 1;
        }
        return arrayList;
    }

    public final void a(t0 t0Var, List list) {
        CookieHandler cookieHandler = this.f13005b;
        if (cookieHandler != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((w) it.next()).toString(true));
            }
            try {
                cookieHandler.put(t0Var.i(), Collections.singletonMap("Set-Cookie", arrayList));
            } catch (IOException e10) {
                s.f16851a.getClass();
                s.f16852b.getClass();
                s.i(5, "Saving cookies failed for " + t0Var.h("/..."), e10);
            }
        }
    }

    public final List b(t0 t0Var) {
        try {
            ArrayList arrayList = null;
            for (Map.Entry next : this.f13005b.get(t0Var.i(), Collections.emptyMap()).entrySet()) {
                String str = (String) next.getKey();
                if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) next.getValue()).isEmpty()) {
                    for (String str2 : (List) next.getValue()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.addAll(c(t0Var, str2));
                    }
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        } catch (IOException e10) {
            s.f16851a.getClass();
            s.f16852b.getClass();
            s.i(5, "Loading cookies failed for " + t0Var.h("/..."), e10);
            return Collections.emptyList();
        }
    }
}
